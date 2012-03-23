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
								
							</div>
							<div class="profileHeaderMain">
								<h1>
									<span class="profileName fn fsxl fwb"><s:property value="event.eventname" /></span>
								</h1>
								<s:if test="joined==false">
								<div class="fsm fwn fcg">
									<span class="fsl">你<a rel="dialog" href="event/event!joinEvent.jhtml?eventId=<s:property value="event.id" />">确定参加</a></span> · 
									
								</div>
							</s:if>
							</div>
						</div>
					</div>