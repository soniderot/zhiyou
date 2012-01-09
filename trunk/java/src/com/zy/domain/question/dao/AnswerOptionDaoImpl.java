package com.zy.domain.question.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyAnsweroption;

public class AnswerOptionDaoImpl extends HibernateDao<ZyAnsweroption, Integer> implements AnswerOptionDao{

	@Override
	public List<ZyAnsweroption> getOptionsByQuestion(int questionId) {
		String hql = "from ZyAnsweroption where questionid=? order by id";
		return find(hql, questionId);
	}

}
