package com.zy.domain.sns.dao;

import java.util.List;

import com.zy.common.db.HibernateDao;
import com.zy.common.model.ZyMatchanswer;

public class MatchAnswerDaoImpl extends HibernateDao<ZyMatchanswer, Integer> implements MatchAnswerDao{
	public ZyMatchanswer getAnswer(int userId,int questionId){
		String hql = "from ZyMatchanswer  where userid=? and matchquestionid = ?";
		List<ZyMatchanswer> answers = this.find(hql,new Object[]{userId,questionId});
		if(answers.size()>0){
			return answers.get(0);
		}
		return null;
	}
	
	public ZyMatchanswer getAnswer(int userId){
		String hql = "from ZyMatchanswer  where userid=?";
		List<ZyMatchanswer> answers = this.find(hql,new Object[]{userId});
		if(answers.size()>0){
			return answers.get(0);
		}
		return null;
	}
}
