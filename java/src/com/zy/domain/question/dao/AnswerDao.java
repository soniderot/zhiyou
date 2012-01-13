package com.zy.domain.question.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyAnswer;

public interface AnswerDao extends BaseDao<ZyAnswer, Integer>{
	public List<ZyAnswer> getAnswerByUserAndOption(int userId, int optionId);
	public List<ZyAnswer> getOptionUsers(int optionId);
	public List<ZyAnswer> getAnswersByquestion(int questionId);
}
