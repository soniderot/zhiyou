package com.zy.domain.question.service;

import com.zy.common.model.ZyAnsweroption;
import com.zy.common.model.ZyQuestion;
import com.zy.domain.question.dao.AnswerOptionDao;
import com.zy.domain.question.dao.QuestionDao;

public class QuestionServiceImpl implements QuestionService{
	private QuestionDao questionDao;
	private AnswerOptionDao answerOptionDao;
	
	public QuestionDao getQuestionDao() {
		return questionDao;
	}
	
	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}
	
	public AnswerOptionDao getAnswerOptionDao() {
		return answerOptionDao;
	}
	
	public void setAnswerOptionDao(AnswerOptionDao answerOptionDao) {
		this.answerOptionDao = answerOptionDao;
	}
	
	@Override
	public void addQuestion(ZyQuestion question) {
		questionDao.save(question);
	}
	@Override
	public void addAnswerOption(ZyAnsweroption answerOption) {
		answerOptionDao.save(answerOption);
	}


}
