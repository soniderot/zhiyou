package com.zy.domain.sns.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyMatchquestionoption;

public class MatchQuestionOptionDaoImpl extends HibernateDao<ZyMatchquestionoption,Integer> implements MatchQuestionOptionDao{
	public List<ZyMatchquestionoption> getOptions(int questionId){
		String hql = "from ZyMatchquestionoption  where matchquestionid=?";
		return this.find(hql,new Object[] {questionId});
	}
}
