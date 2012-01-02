package com.zy.domain.option.dao;

import java.util.List;

import com.zy.Constants;
import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZySchool;

public class SchoolDaoImpl extends HibernateDao<ZySchool, Integer> implements SchoolDao {

	@Override
	public List<ZySchool> getApprovedSchools() {
		String hql = "from ZySchool where flag=?";
		return this.find(hql, new Object[] { Constants.IndexFlag.FLAG_APPROVED.getFlag() });
	}
	
	@Override
	public List<ZySchool> getAllSchools() {
		String hql = "from ZySchool";
		return find(hql);
	}
	
	@Override
	public List<ZySchool> getUnapprovedSchools() {
		String hql = "from ZySchool where flag=?";
		return find(hql, Constants.IndexFlag.FLAG_UNAPPROVED.getFlag());
	}

	@Override
	public ZySchool loadSchoolByName(String name) {
		String hql = "from ZySchool where schoolname=?";
		//List<ZySchool> list = this.find(hql, new Object[] { name });
		List<ZySchool> list= getHibernateTemplate().find(hql,new Object[]{name});
		if (list != null && list.size() > 0)
			return (ZySchool)list.get(0);
		return null;
	}

	@Override
	public List<ZySchool> getSchoolsByPagination(int pageNo, int pageSize, short flag, int verifiedSchoolId) {
		String hql = "from ZySchool where";
		hql += " 1 = 1"; //ensure where clause is valid
		hql += " and flag = " + flag;
		hql += " and verifiedschoolid = " + verifiedSchoolId;
		return loadByPagenation(hql, pageNo, pageSize);
	}

	@Override
	public List<ZySchool> getSchoolsByVerifiedSchoolId(int verifiedSchoolId) {
		String hql = "from ZySchool where verifiedschoolid = " + verifiedSchoolId;
		return find(hql);
	}

	@Override
	public int getSchoolCount(short flag, int verifiedSchoolId) {
		String hql = "select count(id) from ZySchool where";
		hql += " 1 = 1"; //ensure where clause is valid
		hql += " and flag = " + flag;
		hql += " and verifiedschoolid = " + verifiedSchoolId;
		return getTotalRows(hql);
	}

	@Override
	public int getAllSchoolCount() {
		String hql = "select count(id) from ZySchool";
		return getTotalRows(hql);
	}

	@Override
	public int getApprovedSchoolCount() {
		return 0;
	}

	@Override
	public int getUnapprovedSchoolCount() {
		return 0;
	}

	@Override
	public ZySchool loadSchoolById(int id) {
		String hql = "from ZySchool where id=?";
		List<ZySchool> list= getHibernateTemplate().find(hql,new Object[]{id});
		if (list != null && list.size() > 0)
			return (ZySchool)list.get(0);
		return null;
	}

	@Override
	public List<ZySchool> getSchoolsByKey(String key) {
		String hql = "from ZySchool where schoolpinyin like ?";
		List<ZySchool> list= getHibernateTemplate().find(hql,new Object[]{key + "%"});
		return list;
	}

}
