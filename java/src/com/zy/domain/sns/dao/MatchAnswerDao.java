package com.zy.domain.sns.dao;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyMatchanswer;

public interface MatchAnswerDao extends BaseDao<ZyMatchanswer, Integer>{
	public ZyMatchanswer getAnswer(int userId,int questionId);
	public ZyMatchanswer getAnswer(int userId);
}
