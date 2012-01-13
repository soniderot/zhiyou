package com.zy.domain.question.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyAnswer;
import com.zy.common.model.ZyProfile;

public class AnswerDaoImpl extends HibernateDao<ZyAnswer, Integer> implements AnswerDao{

	@Override
	public List<ZyAnswer> getAnswerByUserAndOption(int userId, int optionId) {
		String hql = "from ZyAnswer where userid=? and optionanswer=?";
		return find(hql, new Object[] {userId, optionId});
	}

	@Override
	public List<ZyAnswer> getOptionUsers(int optionId) {
		String hql = "from ZyAnswer where optionanswer=?";
		return find(hql, new Object[] {optionId});
	}

	@Override
	public List<ZyAnswer> getAnswersByquestion(int questionId) {
		String hql = "from ZyAnswer where questionid=?";
		return find(hql, new Object[] {questionId});
	}

}
