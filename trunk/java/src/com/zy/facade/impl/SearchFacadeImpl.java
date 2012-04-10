package com.zy.facade.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.zy.Constants;
import com.zy.common.util.LogUtil;
import com.zy.domain.message.bean.RequestBean;
import com.zy.domain.message.service.RequestService;
import com.zy.domain.profile.service.ProfileService;
import com.zy.domain.search.IndexField;
import com.zy.domain.search.service.SearchService;
import com.zy.domain.sns.service.SNSService;
import com.zy.facade.SearchFacade;
import com.zy.facade.vo.PageListVO;
import com.zy.facade.vo.SearchComparator;
import com.zy.facade.vo.SearchFormVo;
import com.zy.facade.vo.SearchResultVo;

public class SearchFacadeImpl implements SearchFacade{
	private SearchService searchService;
	private SNSService snsService;
	private ProfileService profileService;
	private RequestService requestService;
	
	
	//private SchoolService schoolService;
	
	/*
	public SchoolService getSchoolService() {
		return schoolService;
	}

	public void setSchoolService(SchoolService schoolService) {
		this.schoolService = schoolService;
	}*/

	public RequestService getRequestService() {
		return requestService;
	}

	public void setRequestService(RequestService requestService) {
		this.requestService = requestService;
	}

	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public SNSService getSnsService() {
		return snsService;
	}

	public void setSnsService(SNSService snsService) {
		this.snsService = snsService;
	}

	public SearchService getSearchService() {
		return searchService;
	}

	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}

	public List<SearchResultVo> getProfilesBySearch_tx(int userId, SearchFormVo form, int limitNum){
		List<SearchResultVo> vos = null;
		if (form.isKeyWordSearch()) {
			if (StringUtils.isNotBlank(form.getKeyword())) {
				String q = IndexField.Profile.KEY_WORD + ":" + form.getKeyword() + " " + IndexField.Profile.KEY_WORD + ":" + form.getKeyword() + "*";
				vos = this.searchService.getSearchProfileId(q, limitNum);
			}
		} else {
			// exclude 1d
			if (form.isExclude1d()) {
				List<Integer> ids1 = this.snsService.getAllFriendsByDegree(userId, (short) 1);
				StringBuffer sb1 = new StringBuffer();
				if (ids1 != null) {
					for (int id : ids1)
						sb1.append(id).append(" ");
				}
				sb1.append(userId);
				if (StringUtils.isNotBlank(sb1.toString()))
					form.setExclude1dId(sb1.toString());
			} else {
				List<Integer> ids = null;
				if (form.getScope() == Constants.SEARCH_SCOPE_1D) {// 1D friend
					ids = this.snsService.getAllFriendsByDegree(userId, (short) 1);
				} else if (form.getScope() == Constants.SEARCH_SCOPE_2D) { // 3D
					// friend
					ids = this.snsService.getAllFriendsByDegree(userId, (short) 2);
				}
				StringBuffer sb = new StringBuffer();
				if (ids != null) {
					for (int id : ids)
						sb.append(id).append(" ");
				}
				if (StringUtils.isNotBlank(sb.toString()))
					form.setFriendIds(sb.toString());
			}
			if (form.getSchoolId() > 0) {
				//form.setSchoolName(this.educationService.getSchoolById(form.getSchoolId()).getSchoolname());
				//form.setSchoolName(this.schoolService.getSchoolById(form.getSchoolId()).getSchoolname());
			}
			
			if(form.isExcludeReq()){
				String str = "";
				List<RequestBean> requests = requestService.getUserRequestOutbox(userId, (short)1,1,Integer.MAX_VALUE);
				for(int i=0;i<requests.size();i++){
					str = str+" "+requests.get(i).getRequest().getReceiverid();
				}
				str = str.trim();
				if(str.length()>0){
					form.setExcludedReqUserIds(str);
				}
			}
			
			form.generateQuery();
			// recent 14 days
			if (StringUtils.isNotBlank(form.getStart()) && StringUtils.isNotBlank(form.getEnd())) {
				System.out.println("-------------into range query------------");
				vos = this.searchService.getSearchProfileId(form.getFields(), form.getValues(), form.getFlags(),form.getStart(),form.getEnd(), limitNum);
			} else {
				vos = this.searchService.getSearchProfileId(form.getFields(), form.getValues(), form.getFlags(), limitNum);
			}
		}
		if (vos != null) {
			long s3 = System.currentTimeMillis();
			for (SearchResultVo vo : vos) {
				vo.setDegree(this.snsService.getTargetDegree(userId, vo.getProfileId()));
			}
			long s4 = System.currentTimeMillis();
			System.out.println("---calculte degree time--------" + (s4 - s3));
			SearchComparator c = new SearchComparator();
			Collections.sort(vos, c);
			long s5 = System.currentTimeMillis();
			System.out.println("---sort results time--------" + (s5 - s4));
			for (SearchResultVo vo : vos) {
				vo.setMutualCnt(this.snsService.getMutualFriends(userId, vo.getProfileId()).size());
				//ZyProfile p = this.profileService.findProfileById(vo.getProfileId());
				//vo.setFullname(p.getUsername());
			}
			System.out.println("---get mutual friends and profile time--------" + (System.currentTimeMillis() - s5));
//			return vos;
		}

		return (vos!=null)? vos : (new ArrayList<SearchResultVo>());
	}
	
	/*
	public int getCntProfilesBySearch(int userId, SearchFormVo form, int limitNum){
		return 0;
	}
	public int getCntReceProfilesBySearch(int userId, SearchFormVo form){
		return 0;
	}*/
	
	public PageListVO<SearchResultVo> getProfilesBySearch(int userId, SearchFormVo form, int pageNo, int pageSize, int limitNum){
		List<SearchResultVo> vos = getProfilesBySearch_tx(userId, form, limitNum);
		System.out.println("vos.size---"+vos.size());
		if (vos != null) {
			if (pageNo <= 0)
				pageNo = 1;
			int startRows = (pageNo - 1) * pageSize;
			int endRows = pageNo * pageSize;
			int endIndex = (vos.size() - endRows) > 0 ? endRows : vos.size();
			LogUtil.info("-----api search--pageNo---" + pageNo + "---startRows---" + startRows + "--endIndex---" + endIndex);
			List<SearchResultVo> sublist = vos.subList(startRows, endIndex);
			PageListVO<SearchResultVo> pageList = new PageListVO<SearchResultVo>(sublist, pageNo, pageSize, vos.size());
			return pageList;
		}
		return null;
	}

}
