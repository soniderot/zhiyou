package com.zy.facade.impl;

import java.util.List;

import com.zy.common.model.ZyAnswer;
import com.zy.common.model.ZyAnsweroption;
import com.zy.common.model.ZyQuestion;
import com.zy.domain.question.service.QuestionService;
import com.zy.facade.QuestionFacade;

public class QuestionFacadeImpl implements QuestionFacade {
	private QuestionService questionService;
	
	public QuestionService getQuestionService() {
		return questionService;
	}

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	@Override
	public void addQuestion(ZyQuestion question) {
		questionService.addQuestion(question);
	}

	@Override
	public void addAnswerQuestion(List<String> options, int questionId) {
		for (int i = 0; i < options.size(); i++) {
			String option = options.get(i);
			ZyAnsweroption answerOption = new ZyAnsweroption();
			answerOption.setQuestionid(questionId);
			answerOption.setSummary(option);
			answerOption.setHot(0);
			questionService.addAnswerOption(answerOption);
		}
		
	}

	@Override
	public List<ZyAnswer> getAnswerByUserAndOption(int userId, int optionId) {
		return questionService.getAnswerByUserAndOption(userId, optionId);
		
	}

	@Override
	public ZyAnsweroption getAnsweroptionById(int optionId) {
		return questionService.getAnsweroptionById(optionId);
	}

	@Override
	public void updateAnsweroption(ZyAnsweroption answerOption) {
		questionService.updateAnsweroption(answerOption);
	}

	@Override
	public void addAnswer(ZyAnswer answer) {
		questionService.addAnswer(answer);
	}

	@Override
	public void removeAnswer(int answerId) {
		questionService.removeAnswer(answerId);
		
	}
}
