package com.zy.facade;

import java.util.List;

import com.zy.common.model.ZyQuestion;

public interface QuestionFacade {
	public void addQuestion(ZyQuestion question);
	public void addAnswerQuestion(List<String> options, int questionId);
}
