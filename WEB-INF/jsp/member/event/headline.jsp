<%@page contentType="textml;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<div id="headerArea">
						<div class="clearfix profileHeader" id="event_profile_header">
							<div class="rfloat">
								<s:if test="#session.user.userid==event.createuserid">
								<a class="mls uiButton" role="button" href="/event/createOrUpdate!createOrUpdate.jhtml?eventId=<s:property value="event.id" />">
									
										<i class="mrs img sp_7gl7wd sx_167a57"></i>
									<span class="uiButtonText">编辑活动资讯</span>
									
								</a>
								</s:if>
								
								<s:if test="photosflag==true">
									<a class="mls uiButton" role="button" href="event/event!viewEvent.jhtml?eventId=<s:property value="event.id" />">
									
										<i class="mrs img sp_7gl7wd sx_167a57"></i>
									<span class="uiButtonText">返回活动页面</span>
									
								</a>
								</s:if>
								
								
							</div>
							<div class="profileHeaderMain">
								<h1>
									<span class="profileName fn fsxl fwb"><a href="/event/event!viewEvent.jhtml?eventId=<s:property value="event.id" />"><s:property value="event.eventname" /></a></span>
								</h1>
								<s:if test="joined==false">
								<div class="fsm fwn fcg">
									<s:if test="eventReqFlag==false">
										<s:if test="event.type==1">
									<span class="fsl">我<a rel="dialog" href="event/event!joinEvent.jhtml?eventId=<s:property value="event.id" />">确定参加</a></span> ·
										 </s:if>
									</s:if>
									<s:if test="eventReqFlag==true">
									<span class="fsl">我<a rel="dialog" href="event/event!joinEvent.jhtml?eventId=<s:property value="event.id" />">确定接受邀请</a></span> · 
									
									</s:if>
										<s:if test="followEventFlag==false">
										<a rel="dialog" href="event/event!followEvent.jhtml?eventId=<s:property value="event.id" />">感兴趣</a></span> ·
										</s:if>
										<s:if test="followEventFlag==true">
										<a rel="dialog" href="event/event!notFollowEvent.jhtml?eventId=<s:property value="event.id" />">取消关注</a></span> ·
										</s:if>
								</div>
							</s:if>
							<s:if test="joined==true">
								<div class="fsm fwn fcg">
									<span class="fsl">我<a rel="dialog" href="event/event!quitEvent.jhtml?eventId=<s:property value="event.id" />">确定退出</a></span> · 
									
								</div>
							</s:if>
							</div>
						</div>
					</div>