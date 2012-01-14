package com.zy.facade;

import java.util.List;

import com.zy.common.model.ZyAnswer;
import com.zy.common.model.ZyAnsweroption;
import com.zy.common.model.ZyNewsfeed;
import com.zy.common.model.ZyProfile;
import com.zy.common.model.ZyQuestion;
import com.zy.domain.feed.bean.CommentBean;
import com.zy.facade.vo.AnswerVO;
import com.zy.facade.vo.OptionVO;
import com.zy.facade.vo.QuestionVO;

public interface QuestionFacade {
	public void addQuestion(ZyQuestion question);
	public void addAnswerQuestion(List<String> options, int questionId);
	public List<ZyAnswer> getAnswerByUserAndOption(int userId, int optionId);
	public ZyAnsweroption getAnsweroptionById(int optionId);
	public void updateAnsweroption(ZyAnsweroption answerOption);
	public void addAnswer(ZyAnswer answer);
	public void removeAnswer(int answerId);
	public List<QuestionVO> getAskedFriends(int userId, int questionId);
	public QuestionVO getQuestionVoById(int questionId);
	public ZyQuestion getQuestionById(int questionId);
	public List<OptionVO> getOptionVoByQuestion(int questionId);
	public List<AnswerVO> getAnswerVoByQuestion(int questionId);
	public List<CommentBean> getQuestionComments(int questionId);
	public ZyNewsfeed getFeedByReferenceId(int questionId);
	public void addAnsweroption(ZyAnsweroption option);
	public List<ZyProfile> getOptionUsers(int optionId);
}
