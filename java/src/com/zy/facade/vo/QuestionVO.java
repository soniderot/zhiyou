package com.zy.facade.vo;

import java.util.List;

import com.zy.common.model.ZyAnsweroption;
import com.zy.common.model.ZyProfile;
import com.zy.common.model.ZyQuestion;

public class QuestionVO {
	private ZyQuestion question;
	private ZyProfile profile;
	private boolean invited;
	private List<ZyAnsweroption> options;
	private List<OptionVO> optionUsers;
	private List<AnswerVO> answers;
	public List<AnswerVO> getAnswers() {
		return answers;
	}
	public void setAnswers(List<AnswerVO> answers) {
		this.answers = answers;
	}
	public List<OptionVO> getOptionUsers() {
		return optionUsers;
	}
	public void setOptionUsers(List<OptionVO> optionUsers) {
		this.optionUsers = optionUsers;
	}
	public List<ZyAnsweroption> getOptions() {
		return options;
	}
	public void setOptions(List<ZyAnsweroption> options) {
		this.options = options;
	}
	public ZyQuestion getQuestion() {
		return question;
	}
	public ZyProfile getProfile() {
		return profile;
	}
	public boolean isInvited() {
		return invited;
	}
	public void setQuestion(ZyQuestion question) {
		this.question = question;
	}
	public void setProfile(ZyProfile profile) {
		this.profile = profile;
	}
	public void setInvited(boolean invited) {
		this.invited = invited;
	}
	

}
