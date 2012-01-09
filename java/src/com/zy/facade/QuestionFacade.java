package com.zy.facade;

import java.util.List;

import com.zy.common.model.ZyAnswer;
import com.zy.common.model.ZyAnsweroption;
import com.zy.common.model.ZyQuestion;

public interface QuestionFacade {
	public void addQuestion(ZyQuestion question);
	public void addAnswerQuestion(List<String> options, int questionId);
	public List<ZyAnswer> getAnswerByUserAndOption(int userId, int optionId);
	public ZyAnsweroption getAnsweroptionById(int optionId);
	public void updateAnsweroption(ZyAnsweroption answerOption);
	public void addAnswer(ZyAnswer answer);
	public void removeAnswer(int answerId);
}
