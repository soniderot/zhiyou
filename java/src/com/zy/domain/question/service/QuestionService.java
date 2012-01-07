package com.zy.domain.question.service;

import com.zy.common.model.ZyAnsweroption;
import com.zy.common.model.ZyQuestion;

public interface QuestionService {
	public void addQuestion(ZyQuestion question);
	public void addAnswerOption(ZyAnsweroption answerOption);
}
