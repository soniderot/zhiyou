package com.zy.facade.vo;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

public class LuceneProfileVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userId;
	private String fullName;
	private String careerBrief = "";
	private String companyName = "";
	private String position = "";
	private String schoolName = "";
	private String major = "";
	private String keyword = "";
	// more condition
	private Integer friendsCnt;
	private String industry = "";
	private Integer countryId;
	private Integer regionId;
	private Integer cityId;
	private String groups = "";
	private String contactSetting = "";

	private String countrynamecn = "";
	private String citynamecn = "";
	private String countrynameen = "";
	private String citynameen = "";
	
	private String regTime;
	private String verifiedCompanyId = "";
	private String verifiedSchoolId = "";
	
	private Short gender;
	private String birthDate;
	
	private String interest;
	private String introduction;
	private String hobby;
	
	private String friendIds;
	private int schoolId;
	
	private int homeId;
	
	
	
	public int getHomeId() {
		return homeId;
	}

	public void setHomeId(int homeId) {
		this.homeId = homeId;
	}

	public String getKeyword() {
		return keyword;
	}

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public String getFriendIds() {
		return friendIds;
	}

	public void setFriendIds(String friendIds) {
		this.friendIds = friendIds;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public Short getGender() {
		return gender;
	}

	public void setGender(Short gender) {
		this.gender = gender;
	}

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	public String getVerifiedCompanyId() {
		return verifiedCompanyId;
	}

	public void setVerifiedCompanyId(String verifiedCompanyId) {
		this.verifiedCompanyId = verifiedCompanyId;
	}

	public String getVerifiedSchoolId() {
		return verifiedSchoolId;
	}

	public void setVerifiedSchoolId(String verifiedSchoolId) {
		this.verifiedSchoolId = verifiedSchoolId;
	}

	public String getCountrynameen() {
		return countrynameen;
	}

	public void setCountrynameen(String countrynameen) {
		this.countrynameen = countrynameen;
	}

	public String getCitynameen() {
		return citynameen;
	}

	public void setCitynameen(String citynameen) {
		this.citynameen = citynameen;
	}

	public String getCountrynamecn() {
		return countrynamecn;
	}

	public void setCountrynamecn(String countrynamecn) {
		this.countrynamecn = countrynamecn;
	}

	public String getCitynamecn() {
		return citynamecn;
	}

	public void setCitynamecn(String citynamecn) {
		this.citynamecn = citynamecn;
	}

	public Integer getFriendsCnt() {
		return friendsCnt;
	}

	public void setFriendsCnt(Integer friendsCnt) {
		this.friendsCnt = friendsCnt;
	}

	public String getKeywords() {
		StringBuffer sb = new StringBuffer(fullName);
		if (StringUtils.isNotBlank(careerBrief))
			sb.append(" ").append(careerBrief).append(" ");
		if (StringUtils.isNotBlank(citynamecn))
			sb.append(" ").append(citynamecn).append(" ");
		if (StringUtils.isNotBlank(companyName))
			sb.append(companyName).append(" ");
		if (StringUtils.isNotBlank(position))
			sb.append(position).append(" ");
		if (StringUtils.isNotBlank(schoolName))
			sb.append(schoolName).append(" ");
		if (StringUtils.isNotBlank(major))
			sb.append(major).append(" ");
		
		if (StringUtils.isNotBlank(interest))
			sb.append(interest).append(" ");
		
		if (StringUtils.isNotBlank(hobby))
			sb.append(hobby).append(" ");
		
		if (StringUtils.isNotBlank(introduction))
			sb.append(introduction).append(" ");
		
		this.keyword = sb.toString();
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCareerBrief() {
		return careerBrief;
	}

	public void setCareerBrief(String careerBrief) {
		this.careerBrief = careerBrief;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getGroups() {
		return groups;
	}

	public void setGroups(String groups) {
		this.groups = groups;
	}

	public String getContactSetting() {
		return contactSetting;
	}

	public void setContactSetting(String contactSetting) {
		this.contactSetting = contactSetting;
	}

}

