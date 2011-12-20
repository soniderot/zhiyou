package com.zy.facade.vo;

import java.io.Serializable;

public class SearchResultVo implements Serializable {
	private static final long serialVersionUID = 1L;
	// profile
	private int profileId;
	private String countryname;
	private String cityname;
	private int friendsCnt;

	private String fullname;
	private String domain;
	private short membership;
	private String careerbrief;
	private int degree;
	private int mutualCnt;

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}


	public short getMembership() {
		return membership;
	}

	public void setMembership(short membership) {
		this.membership = membership;
	}

	public String getCareerbrief() {
		return careerbrief;
	}

	public void setCareerbrief(String careerbrief) {
		this.careerbrief = careerbrief;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public int getFriendsCnt() {
		return friendsCnt;
	}

	public void setFriendsCnt(int friendsCnt) {
		this.friendsCnt = friendsCnt;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public int getMutualCnt() {
		return mutualCnt;
	}

	public void setMutualCnt(int mutualCnt) {
		this.mutualCnt = mutualCnt;
	}

}
