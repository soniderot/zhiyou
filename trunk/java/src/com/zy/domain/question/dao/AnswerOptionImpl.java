package com.zy.domain.question.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyAnsweroption;

public class AnswerOptionImpl extends HibernateDao<ZyAnsweroption, Integer> implements AnswerOptionDao{

	@Override
	public List<ZyAnsweroption> getOptionsByQuestion(int questionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
