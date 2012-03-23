package com.zy.facade.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.apache.commons.lang.StringUtils;

import com.zy.Constants;
import com.zy.common.model.ZyIndexlog;
import com.zy.common.model.ZyIndexqueue;
import com.zy.common.model.ZyInterest;
import com.zy.common.model.ZyProfile;
import com.zy.common.util.DateUtil;
import com.zy.common.util.FileUtil;
import com.zy.common.util.LogUtil;
import com.zy.common.util.StringUtil;
import com.zy.domain.option.service.SchoolService;
import com.zy.domain.profile.service.EducationService;
import com.zy.domain.profile.service.ProfileService;
import com.zy.domain.search.service.LuceneIndexService;
import com.zy.domain.sns.service.SNSService;
import com.zy.facade.LuceneIndexFacade;
import com.zy.facade.OptionFacade;
import com.zy.facade.vo.LuceneProfileVo;

public class LuceneIndexFacadeImpl implements LuceneIndexFacade {

	private LuceneIndexService luceneIndexService;
	private ProfileService profileService;
	private SchoolService schoolService;
	private EducationService educationService;
	private SNSService snsService;
	private OptionFacade optionFacade;
	

	public OptionFacade getOptionFacade() {
		return optionFacade;
	}

	public void setOptionFacade(OptionFacade optionFacade) {
		this.optionFacade = optionFacade;
	}

	public SNSService getSnsService() {
		return snsService;
	}

	public void setSnsService(SNSService snsService) {
		this.snsService = snsService;
	}

	public EducationService getEducationService() {
		return educationService;
	}

	public void setEducationService(EducationService educationService) {
		this.educationService = educationService;
	}

	public SchoolService getSchoolService() {
		return schoolService;
	}

	public void setSchoolService(SchoolService schoolService) {
		this.schoolService = schoolService;
	}

	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	

	public LuceneIndexService getLuceneIndexService() {
		return luceneIndexService;
	}

	public void setLuceneIndexService(LuceneIndexService luceneIndexService) {
		this.luceneIndexService = luceneIndexService;
	}

	@Override
	public void doProfileIndex_tx(String fp, int limitNum) {
		try {
			long start = System.currentTimeMillis();
			List<ZyIndexqueue> users = this.luceneIndexService
					.getUsersInQueue(limitNum);
			Map<Integer, Integer> ids = new HashMap<Integer, Integer>();
			for (ZyIndexqueue queue : users) {
				if (!ids.containsKey(queue.getUserid())) {
					ids.put(queue.getUserid(), queue.getUserid());
				}
			}
			if (ids.size() == 0) {
				return;
			}
			List<LuceneProfileVo> indexProfiles = new ArrayList<LuceneProfileVo>();
			List<Integer> delProfiles = new ArrayList<Integer>();
			HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
			outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
			// ids
			Iterator<Integer> iterator = ids.keySet().iterator();
			while (iterator.hasNext()) {
				int userId = iterator.next();
				delProfiles.add(userId);
				LogUtil.info("------do index on userid------" + userId);
				LuceneProfileVo profile = new LuceneProfileVo();

				ZyProfile p = this.profileService.findProfileById(userId);

				// userId
				profile.setUserId(userId + "");
				// fullName
				StringBuffer sb = new StringBuffer();
				StringBuffer sb1 = new StringBuffer();
				char chrs[] = p.getUsername().toCharArray();
				for (char c : chrs) {
					String[] pinyinArray = PinyinHelper
							.toHanyuPinyinStringArray(c, outputFormat);
					if (pinyinArray != null && pinyinArray.length > 0) {
						sb.append(pinyinArray[0] + " ");
						sb1.append(pinyinArray[0]);
					}
				}
				if (StringUtils.isNotBlank(sb.toString())) {
					profile.setFullName(p.getUsername() + " " + sb1.toString()
							+ " " + sb.toString());
				} else {
					profile.setFullName(p.getUsername());
				}
				
				String str = "";
				List<Integer> friendIds = snsService.getAllFriendsByDegree(p.getUserid(),(short)1);
				for(int m=0;m<friendIds.size();m++){
					str = friendIds.get(m)+"-"+str;
				}
				str = str+"-";
				profile.setFriendIds(str);
				if(p.getHometownid()!=null)
					profile.setHomeId(p.getHometownid());
				
				profile.setGender(p.getGender());
				profile.setRegTime(DateUtil.formatDate(p.getRegistertime(),
						DateUtil.lucenedate));
				
				profile.setBirthDate(DateUtil.formatDate(p.getBirthdate(),
						DateUtil.lucenedate));
				
				profile.setCitynamecn(profileService.findProfileById(p.getUserid()).getCityname());
				System.out.println("------------profile.cityname---"+profile.getCitynamecn());
				// country region city
				profile.setCountryId(p.getCountryid());
				profile.setRegionId(p.getRegionid());
				profile.setCityId(p.getCityid());
			
				
				/*
				ZyCity city = cityService.getCity(p.getCityid());
				if (city != null)
					profile.setCitynamecn(city.getCityname());
				*/
				
				profile.setInterest(p.getInterest());
				
				String hobby = "";
				if (!StringUtil.isNull(p.getHobby())) {
					String[] hobbyArr = p.getHobby().split(" ");
					for(int i = 0; i < hobbyArr.length; i++) {
						ZyInterest interest = optionFacade.getInterestById(Integer.parseInt(hobbyArr[i]));
						hobby = hobby+" "+interest.getTag();
					}
				}
				
				profile.setHobby(hobby);
				profile.setIntroduction(p.getIntroduction());
				if(educationService.getEducationByUser(p.getUserid())!=null){
					profile.setSchoolName(schoolService.getSchoolById(educationService.getEducationByUser(p.getUserid()).getSchoolid()).getSchoolname());
					profile.setSchoolId(educationService.getEducationByUser(p.getUserid()).getSchoolid());
				}
				
				indexProfiles.add(profile);
			}

			// delete document from lucene;
			this.luceneIndexService.deleteDocument(delProfiles, fp);
			this.luceneIndexService.doProfileIndex(indexProfiles, fp);
			// delete queue;
			this.luceneIndexService.deleteUsersInQueue(users);
			// copy file
			ZyIndexlog last = this.luceneIndexService.getLastIndexLog();
			String current_live = Constants.INDEX_LIVE1;
			String current_path = Constants.INDEX_DIR_PROFILE_LIVE
					+ current_live;
			if (last != null && last.getFilename().equals(current_live)) {
				current_live = Constants.INDEX_LIVE2;
				current_path = Constants.INDEX_DIR_PROFILE_LIVE + current_live;
			}
			// delete files in the current path
			System.out.println("---------currentpath---------"+current_path);
			FileUtil.emptyDirectory(current_path);
			// copy from the master directory to the new path
			FileUtil.copyDirectoryContents(fp, current_path);
			// add index log
			long end = System.currentTimeMillis();
			ZyIndexlog next = new ZyIndexlog();
			next.setCreatetime(new Date());
			next.setFilename(current_live);
			next.setIndextimemillis((int) (end - start));
			next.setRecordcount(indexProfiles.size());
			this.luceneIndexService.addIndexLog(next);

		} catch (NullPointerException e) {
			e.printStackTrace();
			LogUtil
					.info("==========profile index NullPointerException ,ignore it=======");
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			LogUtil.error(e);
		}
	}
}
