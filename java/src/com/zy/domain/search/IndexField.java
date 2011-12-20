package com.zy.domain.search;


public class IndexField {
	

	
	// school
	public final static String SCHOOL_ID = "schoolId";
	public final static String SCHOOL_NAME = "schoolName";
	public final static String SCHOOL_WEBSITE = "schoolWebsite";
	public final static String SCHOOL_NAME_PINYIN="schoolNamePinyin";
	public final static String SCHOOL_ORDER="schoolOrder";
	public final static String SCHOOL_VERIFIEDID="verifiedSchoolId";
	
	// company
	public final static String COMPANY_ID = "companyId";
	public final static String COMPANY_NAME = "companyName";
	public final static String COMPANY_WEBSITE = "companyWebsite";
	public final static String COMPANY_SIZE = "companySize";
	public final static String COMPANY_NAME_PINYIN="companyNamePinyin";
	public final static String COMPANY_ORDER="companyOrder";
	public final static String COMPANY_VERIFIEDID="verifiedCompanyId";
	
	//profile
	public static class Profile {
		public final static String USER_ID = "userId";
		//keywords
		public final static String FULL_NAME = "fullName";
		public final static String FULL_NAME_PINYIN = "fullNamePinyin";
		public final static String CAREER_BRIEF= "careerBrief";
		public final static String COMPANY_NAME="companyName";
		public final static String POSITION="position";
		public final static String SCHOOL_NAME = "schoolName";
		public final static String MAJOR="major";
		public final static String KEY_WORD="keyword";
		//more condition
		public final static String FRIENDS_1D="friendsCnt"; 
		public final static String INDUSTRY="industry";
		public final static String COUNTRY="countryId";
		public final static String REGION="regionId";
		public final static String CITY="cityId";
		public final static String GROUPS="groups";
		public final static String CONTACT_SETTING="contactSetting";
		
		public final static String COUNTRY_NAME_CN="countryName";
		public final static String CITY_NAME_CN="cityName";
		public final static String COUNTRY_NAME_EN="countryName_EN";
		public final static String CITY_NAME_EN="cityName_EN";
		
		//2010-7-13
		public final static String REG_TIME="regTime"; 
		public final static String VERIFIED_COMPANY="verifiedCompanyId";
		public final static String VERIFIED_SCHOOL="verifiedSchoolId";
	}
}
