package com.zy.facade.vo;

import com.zy.common.model.ZyAnswer;
import com.zy.common.model.ZyProfile;

public class AnswerVO {
	private ZyProfile profile;
	private ZyAnswer answer;
	public ZyProfile getProfile() {
		return profile;
	}

	public void setProfile(ZyProfile profile) {
		this.profile = profile;
	}

	public ZyAnswer getAnswer() {
		return answer;
	}

	public void setAnswer(ZyAnswer answer) {
		this.answer = answer;
	}


}
