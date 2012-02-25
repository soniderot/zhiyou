package com.zy.common.model;

import java.util.Date;

import com.zy.common.util.DateUtil;
import com.zy.common.util.ImageUtil;

/**
 * ZyProfile entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ZyProfile implements java.io.Serializable {

	// Fields

	private Integer userid;
	private String email;
	private Short emailstatus;
	private String passwd;
	private String username;
	private String mobile;
	private Short mobilestatus;
	private String avatar;
	private Short gender;
	private Short objectgender;
	private Integer countryid;
	private Integer regionid;
	private Integer cityid;
	private Integer hometownid;
	private Short level;
	private Float point;
	private String ip;
	private String interest;
	private String favoritefile;
	private String favoriteanim;
	private String introduction;
	private Date birthdate;
	private Date registertime;
	private Date updatetime;
	private Date lastlogintime;
	private String hobby;
	private String qq;
	private String address;
	private String cityname;
	private String regionname;
	private String countryname;

	private String token;
	
	private int age;
	
	private boolean requestOutFlag;
	
	private boolean requestInFlag;
	
	private boolean friendFlag;
	
	private String bigavatar;
	
	// Constructors


	public boolean isRequestOutFlag() {
		return requestOutFlag;
	}

	public void setRequestOutFlag(boolean requestOutFlag) {
		this.requestOutFlag = requestOutFlag;
	}

	public boolean isRequestInFlag() {
		return requestInFlag;
	}

	public void setRequestInFlag(boolean requestInFlag) {
		this.requestInFlag = requestInFlag;
	}

	public boolean isFriendFlag() {
		return friendFlag;
	}

	public void setFriendFlag(boolean friendFlag) {
		this.friendFlag = friendFlag;
	}

	public int getAge() {
		if(birthdate!=null){
			return DateUtil.computeAge(birthdate);
		}
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public void setRegionname(String regionname) {
		this.regionname = regionname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public String getCityname() {
		return cityname;
	}

	public String getRegionname() {
		return regionname;
	}

	public String getCountryname() {
		return countryname;
	}

	/** default constructor */
	public ZyProfile() {
	}

	/** full constructor */
	public ZyProfile(String email, Short emailstatus, String passwd,
			String username, String mobile, Short mobilestatus, String avatar,
			Short gender, Integer countryid, Integer regionid, Integer cityid,
			Short level, Float point, String ip, String interest,
			String favoritefile, String favoriteanim, String introduction,
			Date birthdate, Date registertime, Date updatetime,
			Date lastlogintime) {
		this.email = email;
		this.emailstatus = emailstatus;
		this.passwd = passwd;
		this.username = username;
		this.mobile = mobile;
		this.mobilestatus = mobilestatus;
		this.avatar = avatar;
		this.gender = gender;
		this.countryid = countryid;
		this.regionid = regionid;
		this.cityid = cityid;
		this.level = level;
		this.point = point;
		this.ip = ip;
		this.interest = interest;
		this.favoritefile = favoritefile;
		this.favoriteanim = favoriteanim;
		this.introduction = introduction;
		this.birthdate = birthdate;
		this.registertime = registertime;
		this.updatetime = updatetime;
		this.lastlogintime = lastlogintime;
	}

	// Property accessors

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Short getEmailstatus() {
		return this.emailstatus;
	}

	public void setEmailstatus(Short emailstatus) {
		this.emailstatus = emailstatus;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Short getMobilestatus() {
		return this.mobilestatus;
	}

	public void setMobilestatus(Short mobilestatus) {
		this.mobilestatus = mobilestatus;
	}

	public String getAvatar() {
		if(avatar==null||avatar.length()==0){
			return "images/default.JPG";
		}
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public void setProfileAvatar(String avatar) {
		
		String smallLogo = avatar.replace(".jpg","-small.jpg");
		ImageUtil.resetsize(avatar,smallLogo,180,180);
		
		String bigLogo = avatar.replace(".jpg","-big.jpg");
		int[] result = ImageUtil.resetsize(avatar,bigLogo,320,320);
		
		this.avatar = smallLogo;
		this.bigavatar = bigLogo;
		
	}
	
	public String getGenderStr(){
		if(gender==1){
			return "男";
		}
		if(gender==2){
			return "女";
		}
		return "男";
	}

	public Short getGender() {
		return this.gender;
	}

	public void setGender(Short gender) {
		this.gender = gender;
	}

	public Integer getCountryid() {
		return this.countryid;
	}

	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}

	public Integer getRegionid() {
		return this.regionid;
	}

	public void setRegionid(Integer regionid) {
		this.regionid = regionid;
	}

	public Integer getCityid() {
		return this.cityid;
	}

	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}

	public Short getLevel() {
		return this.level;
	}

	public void setLevel(Short level) {
		this.level = level;
	}

	public Float getPoint() {
		return this.point;
	}

	public void setPoint(Float point) {
		this.point = point;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getInterest() {
		return this.interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getFavoritefile() {
		return this.favoritefile;
	}

	public void setFavoritefile(String favoritefile) {
		this.favoritefile = favoritefile;
	}

	public String getFavoriteanim() {
		return this.favoriteanim;
	}

	public void setFavoriteanim(String favoriteanim) {
		this.favoriteanim = favoriteanim;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Date getRegistertime() {
		return this.registertime;
	}

	public void setRegistertime(Date registertime) {
		this.registertime = registertime;
	}

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Date getLastlogintime() {
		return this.lastlogintime;
	}

	public void setLastlogintime(Date lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	public Short getObjectgender() {
		return objectgender;
	}

	public Integer getHometownid() {
		return hometownid;
	}

	public void setObjectgender(Short objectgender) {
		this.objectgender = objectgender;
	}

	public void setHometownid(Integer hometownid) {
		this.hometownid = hometownid;
	}

	public String getHobby() {
		return hobby;
	}

	public String getQq() {
		return qq;
	}

	public String getAddress() {
		return address;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBigavatar() {
		if(bigavatar==null||bigavatar.length()==0){
			return "images/default.JPG";
		}
		return this.bigavatar;
	}

	public void setBigavatar(String bigavatar) {
		this.bigavatar = bigavatar;
	}

}