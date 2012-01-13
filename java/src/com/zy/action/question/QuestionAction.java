package com.zy.action.question;

import java.util.List;

import com.zy.common.model.ZyNewsfeed;
import com.zy.domain.feed.bean.CommentBean;
import com.zy.facade.QuestionFacade;
import com.zy.facade.vo.QuestionVO;

public class QuestionAction {
	
	private int questionId;
	private QuestionVO questionVo;
	private List<CommentBean> comments;
	private QuestionFacade questionFacade;
	private ZyNewsfeed feed;
	
	public ZyNewsfeed getFeed() {
		return feed;
	}
	public void setFeed(ZyNewsfeed feed) {
		this.feed = feed;
	}
	public QuestionVO getQuestionVo() {
		return questionVo;
	}
	public void setQuestionVo(QuestionVO questionVo) {
		this.questionVo = questionVo;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public QuestionFacade getQuestionFacade() {
		return questionFacade;
	}
	public void setQuestionFacade(QuestionFacade questionFacade) {
		this.questionFacade = questionFacade;
	}
	public List<CommentBean> getComments() {
		return comments;
	}
	public void setComments(List<CommentBean> comments) {
		this.comments = comments;
	}
	
	public String viewQuestion() {
		questionVo = questionFacade.getQuestionVoById(questionId);
		comments = questionFacade.getQuestionComments(questionId);
		feed = questionFacade.getFeedByReferenceId(questionId);
		return "question.detail";
	}

}
