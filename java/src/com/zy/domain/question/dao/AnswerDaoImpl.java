package com.zy.domain.question.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyAnswer;

public class AnswerDaoImpl extends HibernateDao<ZyAnswer, Integer> implements AnswerDao{

	@Override
	public List<ZyAnswer> getAnswerByUserAndOption(int userId, int optionId) {
		String hql = "from ZyAnswer where userid=? and optionanswer=?";
		return find(hql, new Object[] {userId, optionId});
	}

}
