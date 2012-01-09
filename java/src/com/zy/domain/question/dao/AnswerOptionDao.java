package com.zy.domain.question.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyAnsweroption;

public interface AnswerOptionDao extends BaseDao<ZyAnsweroption, Integer>{
	List<ZyAnsweroption> getOptionsByQuestion(int questionId);
}
