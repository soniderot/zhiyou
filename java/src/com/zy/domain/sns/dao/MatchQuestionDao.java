package com.zy.domain.sns.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyMatchquestion;

public interface MatchQuestionDao extends BaseDao<ZyMatchquestion, Integer>{
	public List<ZyMatchquestion> getQuestions(int categoryId,int pageNo,int pageSize);
}
