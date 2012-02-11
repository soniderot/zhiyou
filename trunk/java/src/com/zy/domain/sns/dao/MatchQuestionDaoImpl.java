package com.zy.domain.sns.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyMatchquestion;

public class MatchQuestionDaoImpl extends HibernateDao<ZyMatchquestion,Integer> implements MatchQuestionDao{
	public List<ZyMatchquestion> getQuestions(int categoryId,int pageNo,int pageSize){
		String hql = "from ZyMatchquestion  where categoryid=?";
		return this.loadByPagenation(hql,pageNo,pageSize,new Object[] { categoryId});
	}
}
