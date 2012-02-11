package com.zy.domain.sns.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyMatchquestionoption;

public interface MatchQuestionOptionDao extends BaseDao<ZyMatchquestionoption, Integer>{
	public List<ZyMatchquestionoption> getOptions(int questionId);
}
