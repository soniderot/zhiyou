package com.zy.facade.impl;

import java.util.ArrayList;
import java.util.List;

import com.zy.common.model.ZyAnswer;
import com.zy.common.model.ZyAnsweroption;
import com.zy.common.model.ZyNewsfeed;
import com.zy.common.model.ZyNewsfeedcomment;
import com.zy.common.model.ZyProfile;
import com.zy.common.model.ZyQuestion;
import com.zy.common.model.ZyRequest;
import com.zy.common.util.ActionUtil;
import com.zy.domain.feed.bean.CommentBean;
import com.zy.domain.feed.service.FeedService;
import com.zy.domain.message.service.RequestService;
import com.zy.domain.profile.service.ProfileService;
import com.zy.domain.question.service.QuestionService;
import com.zy.domain.sns.service.SNSService;
import com.zy.facade.QuestionFacade;
import com.zy.facade.vo.AnswerVO;
import com.zy.facade.vo.OptionVO;
import com.zy.facade.vo.QuestionVO;

public class QuestionFacadeImpl implements QuestionFacade {
	private QuestionService questionService;
	private SNSService snsService;
	private RequestService requestService;
	private ProfileService profileService;
	private FeedService feedService;
	
	public RequestService getRequestService() {
		return requestService;
	}

	public void setRequestService(RequestService requestService) {
		this.requestService = requestService;
	}

	public SNSService getSnsService() {
		return snsService;
	}

	public void setSnsService(SNSService snsService) {
		this.snsService = snsService;
	}

	public QuestionService getQuestionService() {
		return questionService;
	}

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}
	
	public FeedService getFeedService() {
		return feedService;
	}

	public void setFeedService(FeedService feedService) {
		this.feedService = feedService;
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

	@Override
	public List<QuestionVO> getAskedFriends(int userId, int questionId) {
		List<ZyProfile> allFriends = snsService.getAllFriends(userId, (short)1);
		List<ZyProfile> questionMembers = getRequestSentTo(questionId);
		List<QuestionVO> questionFriends = new ArrayList<QuestionVO>();
		for(int i = 0; i < allFriends.size(); i++) {
			ZyProfile profile = allFriends.get(i);
			QuestionVO questionVO = new QuestionVO();
			questionVO.setProfile(profile);
			if (questionMembers.contains(profile)) {
				questionVO.setInvited(true);
			} else {
				questionVO.setInvited(false);
			}
			questionFriends.add(questionVO);
		}
		return questionFriends;
	}
	
	public List<ZyProfile> getRequestSentTo(int eventId){
		List<ZyRequest> members = requestService.getRequests(eventId);
		List<ZyProfile> profiles = new ArrayList<ZyProfile>();
		for(int i = 0; i < members.size(); i++){
			ZyProfile profile = profileService.findProfileById(members.get(i).getReceiverid());
			profiles.add(profile);
		}
		return profiles;
	}

	@Override
	public List<OptionVO> getOptionVoByQuestion(int questionId) {
		List<OptionVO> optionUsers = new ArrayList<OptionVO>();
		List<ZyAnsweroption> options = questionService.getOptionsByQuestion(questionId);
		for (int i = 0; i < options.size(); i++) {
			OptionVO optionVo = new OptionVO();
			ZyAnsweroption option = options.get(i);
			List<ZyAnswer> answers = questionService.getOptionUsers(option.getId());
			List<ZyProfile> profiles = new ArrayList<ZyProfile>();
			boolean selected = false;
			for (int j = 0; j < answers.size(); j++) {
				ZyAnswer answer = answers.get(j);
				ZyProfile profile = profileService.findProfileById(answer.getUserid());
				profiles.add(profile);
				if (profile.getUserid() == ActionUtil.getSessionUserId()) {
					selected = true;
				}
			}
			optionVo.setSelected(selected);
			optionVo.setOption(option);
			optionVo.setOptionProfiles(profiles);
			optionUsers.add(optionVo);
		}
		return optionUsers;
	}

	
	@Override
	public QuestionVO getQuestionVoById(int questionId) {
		QuestionVO questionVo = new QuestionVO();
		List<OptionVO> options = getOptionVoByQuestion(questionId);
		List<AnswerVO> answers = getAnswerVoByQuestion(questionId);
		ZyQuestion question = getQuestionById(questionId);
		ZyProfile profile = profileService.findProfileById(question.getUserid());
		questionVo.setQuestion(question);
		questionVo.setOptionUsers(options);
		questionVo.setProfile(profile);
		questionVo.setAnswers(answers);
		return questionVo;
	}

	@Override
	public ZyQuestion getQuestionById(int questionId) {
		return questionService.getQuestionById(questionId);
	}

	@Override
	public List<AnswerVO> getAnswerVoByQuestion(int questionId) {
		List<AnswerVO> answerList = new ArrayList<AnswerVO>();
		List<ZyAnswer> answers = questionService.getAnswersByQuestion(questionId);
		for (int i = 0; i < answers.size(); i++) {
			AnswerVO answerVo = new AnswerVO();
			ZyAnswer answer = answers.get(i);
			ZyProfile profile = profileService.findProfileById(answer.getUserid());
			answerVo.setAnswer(answer);
			answerVo.setProfile(profile);
			answerList.add(answerVo);
		}
		return answerList;
	}

	@Override
	public List<CommentBean> getQuestionComments(int questionId) {
		ZyNewsfeed feed = feedService.getFeedByReferenceId(questionId);
		if (feed != null) {
			List<ZyNewsfeedcomment> comments = feedService.getCommentsByFeedId(feed.getId());
			List<CommentBean> commentBeans = new ArrayList<CommentBean>();
			for(int j = 0; j < comments.size(); j++){
				CommentBean commentBean = new CommentBean();
				commentBean.setComment(comments.get(j));
				commentBean.setUser(profileService.findProfileById(comments.get(j).getUserid()));
				commentBeans.add(commentBean);
			}
			return commentBeans;
		}
		return null;
	}

	@Override
	public ZyNewsfeed getFeedByReferenceId(int questionId) {
		return feedService.getFeedByReferenceId(questionId);
	}

	@Override
	public void addAnsweroption(ZyAnsweroption option) {
		questionService.addAnswerOption(option);
	}

	@Override
	public List<ZyProfile> getOptionUsers(int optionId) {
		List<ZyAnswer> answers = questionService.getOptionUsers(optionId);
		List<ZyProfile> profiles = new ArrayList<ZyProfile>();
		for (int j = 0; j < answers.size(); j++) {
			ZyAnswer answer = answers.get(j);
			ZyProfile profile = profileService.findProfileById(answer.getUserid());
			profiles.add(profile);
		}
		return profiles;
	}

}
