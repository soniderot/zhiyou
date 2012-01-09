package com.zy.domain.question.service;

import java.util.List;

import com.zy.common.model.ZyAnswer;
import com.zy.common.model.ZyAnsweroption;
import com.zy.common.model.ZyQuestion;
import com.zy.domain.question.dao.AnswerDao;
import com.zy.domain.question.dao.AnswerOptionDao;
import com.zy.domain.question.dao.QuestionDao;

public class QuestionServiceImpl implements QuestionService{
	private QuestionDao questionDao;
	private AnswerOptionDao answerOptionDao;
	private AnswerDao answerDao;
	
	public AnswerDao getAnswerDao() {
		return answerDao;
	}

	public void setAnswerDao(AnswerDao answerDao) {
		this.answerDao = answerDao;
	}

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

	@Override
	public ZyQuestion getQuestionById(int questionId) {
		return questionDao.load(questionId);
	}

	@Override
	public List<ZyAnsweroption> getOptionsByQuestion(int questionId) {
		return answerOptionDao.getOptionsByQuestion(questionId);
	}

	@Override
	public List<ZyAnswer> getAnswerByUserAndOption(int userId, int optionId) {
		return answerDao.getAnswerByUserAndOption(userId, optionId);
	}

	@Override
	public ZyAnsweroption getAnsweroptionById(int optionId) {
		return answerOptionDao.load(optionId);
	}

	@Override
	public void updateAnsweroption(ZyAnsweroption answerOption) {
		answerOptionDao.update(answerOption);
	}

	@Override
	public void addAnswer(ZyAnswer answer) {
		answerDao.save(answer);		
	}

	@Override
	public void removeAnswer(int answerId) {
		answerDao.deleteByKey(answerId);
		
	}

}
