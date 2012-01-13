package com.zy.domain.question.service;

import java.util.List;

import com.zy.common.model.ZyAnswer;
import com.zy.common.model.ZyAnsweroption;
import com.zy.common.model.ZyQuestion;

public interface QuestionService {
	public ZyQuestion getQuestionById(int questionId);
	public void addQuestion(ZyQuestion question);
	public void addAnswerOption(ZyAnsweroption answerOption);
	public List<ZyAnsweroption> getOptionsByQuestion(int questionId);
	public List<ZyAnswer> getAnswerByUserAndOption(int userId, int optionId);
	public ZyAnsweroption getAnsweroptionById(int optionId);
	public void updateAnsweroption(ZyAnsweroption answerOption);
	public void addAnswer(ZyAnswer answer);
	public void removeAnswer(int answerId);
	public List<ZyAnswer> getOptionUsers(int optionId);
	public List<ZyAnswer> getAnswersByQuestion(int questionId);
}
