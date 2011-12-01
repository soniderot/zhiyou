package com.zy.domain.profile.service;

import java.util.Date;
import java.util.List;

import org.apache.tiles.util.LocaleUtil;

import com.zy.Constants;
import com.zy.common.model.ZyEducation;
import com.zy.common.model.ZyMemo;
import com.zy.common.model.ZyOption;
import com.zy.common.model.ZyProfile;
import com.zy.common.model.ZySchool;
import com.zy.common.util.SecurityUtil;
import com.zy.domain.option.service.CityService;
import com.zy.domain.option.service.OptionService;
import com.zy.domain.option.service.RegionService;
import com.zy.domain.option.service.SchoolService;
import com.zy.domain.profile.dao.EducationDAO;
import com.zy.domain.profile.dao.MemoDao;
import com.zy.domain.profile.dao.ProfileDao;


public class ProfileServiceImpl implements ProfileService {

	private ProfileDao profileDao;
	private MemoDao memoDao;
	private EducationDAO educationDAO;
	private CityService cityService;
	private RegionService regionService;
	private SchoolService schoolService;
	private OptionService optionService;
	
	
	public OptionService getOptionService() {
		return optionService;
	}

	public void setOptionService(OptionService optionService) {
		this.optionService = optionService;
	}

	public EducationDAO getEducationDAO() {
		return educationDAO;
	}

	public void setEducationDAO(EducationDAO educationDAO) {
		this.educationDAO = educationDAO;
	}

	public SchoolService getSchoolService() {
		return schoolService;
	}

	public void setSchoolService(SchoolService schoolService) {
		this.schoolService = schoolService;
	}

	public MemoDao getMemoDao() {
		return memoDao;
	}

	public void setMemoDao(MemoDao memoDao) {
		this.memoDao = memoDao;
	}

	public CityService getCityService() {
		return cityService;
	}

	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}

	public RegionService getRegionService() {
		return regionService;
	}

	public void setRegionService(RegionService regionService) {
		this.regionService = regionService;
	}

	public ProfileDao getProfileDao() {
		return profileDao;
	}

	public void setProfileDao(ProfileDao profileDao) {
		this.profileDao = profileDao;
	}
	
	public ZyProfile findProfileById(int profileId){
		ZyProfile profile = profileDao.load(profileId);
		profile.setCityname(cityService.getCity(profile.getCityid()).getCityname());
		profile.setCountryname("中国");
		profile.setRegionname(regionService.getRegion(profile.getRegionid()).getRegionname());
		return profile;
	}
	public ZyProfile findProfileByEmail(String email){
		return profileDao.findProfileByEmail(email);
	}
	
	public boolean checkProfileLogin(String email,String password){
		ZyProfile profile = this.findProfileByEmail(email);
		if(profile==null){
			return false;
		}else{
			String newPass = SecurityUtil.getMD5(password);
			if(profile.getPasswd().equalsIgnoreCase(newPass)){
				return true;
			}else{
				return false;
			}
		}
	}
	
	
	public void insertProfile(ZyProfile profile){
		profile.setRegistertime(new Date());
		profile.setLastlogintime(new Date());
		profile.setAvatar(Constants.LOGO_PATH+profile.getAvatar());
		profile.setPasswd(SecurityUtil.getMD5(profile.getPasswd()));
		profileDao.save(profile);
	}
	
	public void updateProfile(ZyProfile profile){
		profileDao.update(profile);
	}
	
	public void updateLogo(int userId,String path){
		ZyProfile profile = profileDao.load(userId);
		profile.setAvatar(Constants.LOGO_PATH+path);
		this.updateProfile(profile);
	}

	public List<ZyMemo> findMemoByUserId(int userId,int pageNo,int pageSize){
		return memoDao.findMemoByUserId(userId, pageNo, pageSize);
	}
	
	public void deleteMemoByMemoId(int userId,int memoId){
		if (userId == memoDao.load(memoId).getUserid()) {
			memoDao.deleteByKey(memoId);
		}
	}
	
	public int getUserMemoCnt(int userId){
		return memoDao.getMemosCnt(userId);
	}
	
	public void saveMemo(String content,int userId,int targetUserId){
		ZyMemo memo = memoDao.getMemoByUidPid(userId, targetUserId);
		if (memo == null) {
			memo = new ZyMemo();
			memo.setUserid(userId);
			memo.setMemorid(targetUserId);
		}
		memo.setContent(content);
		memo.setCreatetime(new Date());
		memoDao.saveOrUpdate(memo);
	}
	
	public ZyMemo getMemoByUidPid(int userId,int targetUserId){
		return memoDao.getMemoByUidPid(userId, targetUserId);
	}
	
	public ZyEducation getByEductioinId(Integer id){
		ZyEducation education = educationDAO.load(id);
		if(education == null){
			return null;
		}
		education.setSchoolname(schoolService.getSchoolById(education.getSchoolid()).getSchoolname());
		return education;
	}
	public List<ZyEducation> findByEducationsUserId(Integer userId){
		List<ZyEducation> educationList = educationDAO.findByUserId(userId);
		List<ZyOption> olist = optionService.getOptionList("EDUCATION_DEGREE");
		for(int i=0;i<educationList.size();i++){
			ZyEducation education = educationList.get(i);
			if(education.getSchoolid()!=null){
				ZySchool school=schoolService.getSchoolById(education.getSchoolid());
				education.setSchoolname(school.getSchoolname());
				//education.setVerifiedschoolId(school.getVerifiedschoolid());
				Integer cs = education.getDegreeid();
				if(cs!=null){
					for(ZyOption o:olist){
						if(o.getOptionid().intValue()==cs.intValue()){
							education.setDegreename(o.getContent());
						}
					}
				}
			}
		}
		return educationList;
	}
	public void updateEducation(ZyEducation education){
		if (education.getId() != null) {
			educationDAO.update(education);
		} else {
			education.setCreatetime(new Date());
			if(education.getStartyear()==null)
				education.setStartyear(0);
			educationDAO.save(education);
		}
	}
}