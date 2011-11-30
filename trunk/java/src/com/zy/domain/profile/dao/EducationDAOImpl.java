package com.zy.domain.profile.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyEducation;

public class EducationDAOImpl extends HibernateDao<ZyEducation, Integer> implements EducationDAO {

	@Override
	public List<ZyEducation> findByUserId(Integer userId) {
		String hql = "from ZyEducation as model where model.userid=? order by model.endyear desc,model.startyear desc";
		return find(hql, userId);
	}

	@Override
	public int findCountByUserId(Integer userId) {
		String hql = "select count(1) from ZyEducation as model where model.userid=?";
		return Integer.parseInt(find(hql, userId).get(0).toString());
	}

	@Override
	public List<ZyEducation> getEducations(int schoolId, int startYear) {
		String hql = "from ZyEducation where schoolid=? and startyear=?";
		return this.find(hql, new Object[] { schoolId, startYear });
	}

	@Override
	public List<ZyEducation> findByEndorse(Integer userId) {
		String hql = "from ZyEducation where id in (select experienceid from BnsEndorse where senderid = ? and categoryid = 2)";
		return this.find(hql, userId);
	}

	@Override
	public List<ZyEducation> findByEndorseStatus(int receiverId, short status) {
		String hql = "from ZyEducation where id in (select experienceid from BnsEndorse where receiverid = ? and status = ?)";
		return this.find(hql, new Object[] {receiverId, status});
	}
}
