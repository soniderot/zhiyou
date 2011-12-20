package com.zy.facade.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.lucene.search.BooleanClause;

import com.zy.Constants;
import com.zy.domain.search.IndexField;

public class SearchFormVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String keyword;
	private boolean isKeyWordSearch;

	private String fullname;
	private String companyName;
	private String schoolName;
	private String position;
	private String major;
	private boolean exclude1d;
	private String exclude1dId;

	// recent 14 days;
	private String start;
	private String end;

	private int countryId;
	private int regionId;
	private int cityId;

	// split by space example 2 10 turn to query:+(industry:2 industry:10)
	private int[] industryIds;
	private int[] groupIds;// split by space
	private int[] contactIds;// split by space
	// the same as above, but they have already been concatenated and separated by space
	private String industryIdsString;
	private String groupIdsString;
	private String contactIdsString;
	
	// profile school and company search
	private int schoolId;
	private int companyId;

	private Integer scope;// 3 all 2 3d 1 1d
	private String friendIds;

	private String[] fields;
	private String[] values;
	private BooleanClause.Occur[] flags;

	public boolean isExclude1d() {
		return exclude1d;
	}

	public void setExclude1d(boolean exclude1d) {
		this.exclude1d = exclude1d;
	}

	public String getExclude1dId() {
		return exclude1dId;
	}

	public void setExclude1dId(String exclude1dId) {
		this.exclude1dId = exclude1dId;
	}

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public void generateQuery() {
		List<String> fields = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		List<BooleanClause.Occur> flags = new ArrayList<BooleanClause.Occur>();
		if (StringUtils.isNotBlank(getKeyword())) {
			fields.add(IndexField.Profile.KEY_WORD);
			if(this.getKeyword() == null || this.getKeyword().length() == 0){
				values.add(this.getKeyword());
			} else {
				if(this.getKeyword().getBytes().length == this.getKeyword().length()){
					values.add(this.getKeyword() + "*");
				} else {
					values.add(this.getKeyword());
				}
			}
			flags.add(BooleanClause.Occur.MUST);
		}
		if (StringUtils.isNotBlank(this.getFullname())) {
			fields.add(IndexField.Profile.FULL_NAME);
			values.add(this.getFullname());
			flags.add(BooleanClause.Occur.MUST);
		}
		if (this.getCountryId() > 0) {
			fields.add(IndexField.Profile.COUNTRY);
			values.add(this.getCountryId() + "");
			flags.add(BooleanClause.Occur.MUST);
		}
		if (this.getRegionId() > 0) {
			fields.add(IndexField.Profile.REGION);
			values.add(this.getRegionId() + "");
			flags.add(BooleanClause.Occur.MUST);
		}
		if (this.getCityId() > 0) {
			fields.add(IndexField.Profile.CITY);
			values.add(this.getCityId() + "");
			flags.add(BooleanClause.Occur.MUST);
		}
		if (StringUtils.isNotBlank(this.getCompanyName()) && getCompanyId() == 0) {
			fields.add(IndexField.Profile.COMPANY_NAME);
			values.add(this.getCompanyName());
			flags.add(BooleanClause.Occur.MUST);
		}
		if (StringUtils.isNotBlank(this.getSchoolName()) && getSchoolId() == 0) {
			fields.add(IndexField.Profile.SCHOOL_NAME);
			values.add(this.getSchoolName());
			flags.add(BooleanClause.Occur.MUST);
		}
		if(getCompanyId()>0){
			fields.add(IndexField.Profile.VERIFIED_COMPANY);
			values.add(this.getCompanyId()+"");
			flags.add(BooleanClause.Occur.MUST);
		}
		if(getSchoolId()>0){
			fields.add(IndexField.Profile.VERIFIED_SCHOOL);
			values.add(this.getSchoolId()+"");
			flags.add(BooleanClause.Occur.MUST);
		}
		
		if (StringUtils.isNotBlank(this.getPosition())) {
			fields.add(IndexField.Profile.POSITION);
			values.add(this.getPosition());
			flags.add(BooleanClause.Occur.MUST);
		}
		if (StringUtils.isNotBlank(this.getMajor())) {
			fields.add(IndexField.Profile.MAJOR);
			values.add(this.getMajor());
			flags.add(BooleanClause.Occur.MUST);
		}
		if (StringUtils.isNotBlank(this.getIndustryIds())) {
			fields.add(IndexField.Profile.INDUSTRY);
			values.add(this.getIndustryIds());
			flags.add(BooleanClause.Occur.MUST);
		}
		if (StringUtils.isNotBlank(this.getGroupIds())) {
			fields.add(IndexField.Profile.GROUPS);
			values.add(this.getGroupIds());
			flags.add(BooleanClause.Occur.MUST);
		}
		if (StringUtils.isNotBlank(this.getContactIds())) {
			fields.add(IndexField.Profile.CONTACT_SETTING);
			values.add(this.getContactIds());
			flags.add(BooleanClause.Occur.MUST);
		}
		if (StringUtils.isNotBlank(this.getFriendIds())) {
			fields.add(IndexField.Profile.USER_ID);
			values.add(this.getFriendIds());
			flags.add(BooleanClause.Occur.MUST);
		}
		if (isExclude1d() && StringUtils.isNotBlank(this.getExclude1dId())) {
			fields.add(IndexField.Profile.USER_ID);
			values.add(this.getExclude1dId());
			flags.add(BooleanClause.Occur.MUST_NOT);
		}
		this.fields = (String[]) fields.toArray(new String[fields.size()]);
		this.values = (String[]) values.toArray(new String[values.size()]);
		this.flags = (BooleanClause.Occur[]) flags.toArray(new BooleanClause.Occur[flags.size()]);
	}

	public String getFriendIds() {
		return friendIds;
	}

	public void setFriendIds(String friendIds) {
		this.friendIds = friendIds;
	}

	public boolean isKeyWordSearch() {
		return isKeyWordSearch;
	}

	public void setKeyWordSearch(boolean isKeyWordSearch) {
		this.isKeyWordSearch = isKeyWordSearch;
	}

	public String[] getFields() {
		return fields;
	}

	public void setFields(String[] fields) {
		this.fields = fields;
	}

	public String[] getValues() {
		return values;
	}

	public void setValues(String[] values) {
		this.values = values;
	}

	public BooleanClause.Occur[] getFlags() {
		return flags;
	}

	public void setFlags(BooleanClause.Occur[] flags) {
		this.flags = flags;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getIndustryIds() {
		if (this.industryIds != null && this.industryIds.length > 0) {
			StringBuffer sb = new StringBuffer();
			for (int i : industryIds)
				sb.append(i).append(" ");
			return sb.toString();
		}
		else if (this.industryIdsString != null) {
		    return this.industryIdsString;
		}
		return null;
	}

	public void setIndustryIds(int[] industryIds) {
		this.industryIds = industryIds;
	}

	public String getGroupIds() {
		if (this.groupIds != null && this.groupIds.length > 0) {
			StringBuffer sb = new StringBuffer();
			for (int i : groupIds)
				sb.append(i).append(" ");
			return sb.toString();
		}
		else if (this.groupIdsString != null) {
		    return this.groupIdsString;
		}
		return null;
	}

	public void setGroupIds(int[] groupIds) {
		this.groupIds = groupIds;
	}

	public String getContactIds() {
		if (this.contactIds != null && this.contactIds.length > 0) {
			StringBuffer sb = new StringBuffer();
			for (int i : contactIds)
				sb.append(i).append(" ");
			return sb.toString();
		}
		else if (this.contactIdsString != null) {
		    return this.contactIdsString;
		}
		return null;
	}

	public void setContactIds(int[] contactIds) {
		this.contactIds = contactIds;
	}

	public Integer getScope() {
		if (this.scope == null || this.scope.intValue() == 0)
			return Constants.SEARCH_SCOPE_ALL;
		return scope;
	}

	public void setScope(Integer scope) {
		this.scope = scope;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

    public String getIndustryIdsString() {
        return industryIdsString;
    }

    public void setIndustryIdsString(String industryIdsString) {
        this.industryIdsString = industryIdsString;
    }

    public String getGroupIdsString() {
        return groupIdsString;
    }

    public void setGroupIdsString(String groupIdsString) {
        this.groupIdsString = groupIdsString;
    }

    public String getContactIdsString() {
        return contactIdsString;
    }

    public void setContactIdsString(String contactIdsString) {
        this.contactIdsString = contactIdsString;
    }

}
