package com.zy.domain.feed.bean;

import java.util.List;

import com.zy.common.model.ZyAnsweroption;
import com.zy.common.model.ZyQuestion;

public class QuestionBean {
	private ZyQuestion question;
	private List<ZyAnsweroption> options;
	public ZyQuestion getQuestion() {
		return question;
	}
	public List<ZyAnsweroption> getOptions() {
		return options;
	}
	public void setQuestion(ZyQuestion question) {
		this.question = question;
	}
	public void setOptions(List<ZyAnsweroption> options) {
		this.options = options;
	}
}
