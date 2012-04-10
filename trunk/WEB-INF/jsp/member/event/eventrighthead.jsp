<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<div id="event_profile_guest_info">
    <div id="pagelet_nav_visitors"></div>
    
    <s:if test="#session.user.userid==event.createuserid||event.type==1">
    <div class="uiHeader uiHeaderTopBorder uiHeaderNav">
     </div>
        
    <a class="mbs uiButton" onclick="return inviteFriends(<s:property value="eventId" />);" href="javascript:void(0);" rel="dialog-post">
      <i class="mrs img sp_7gl7wd sx_61da04"></i>
      <span class="uiButtonText">选择你要邀请的朋友</span>
    </a>
    </s:if>
    
    
    <div>
    
      <div class="event_guestlist mbm">
      		<s:if test="followers.size()>0">
      	 <div class="uiHeader uiHeaderTopBorder uiHeaderNav">
          <div class="clearfix uiHeaderTop">
            <a class="uiHeaderActions rfloat" href="event/event!getEventFollowers.jhtml?eventId=<s:property value="eventId" />" rel="dialog">查看全部</a>
            <div>
              <h4 class="uiHeaderTitle"><s:property value="followers.size()"/> 人感兴趣</h4>
            </div>
          </div>
        </div>
        
        
        <div class="phs">
											<div class="fbFriendListMemberBoxContent">
												<div class="uiFacepile fbFriendListMemberBoxFacepile uiFacepileMedium" id="u29f2l_23">
													<ul class="uiList uiListHorizontal clearfix pvm">
														<s:iterator value="followers" status='st'>
															<s:if test="#st.index%3==0&&#st.index>0"> 
															<ul class="uiList uiListHorizontal clearfix pvm"></ul>
															</s:if> 
															<s:if test="#st.index<12"> 
														<li class="uiFacepileItem uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
															<a class="uiTooltip link" onmouseout="this.blur();" href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value="userid" />" data-jsid="anchor">
																<img class="uiProfilePhoto uiProfilePhotoLarge img" src="<s:property value="avatar" />" alt="" data-jsid="img">
																<span class="uiTooltipWrap top left lefttop">
																	<span class="uiTooltipText"><s:property value="username" /></span>
																</span>
															</a>
														</li>
														</s:if> 
														</s:iterator>
													</ul>
												</div>
											</div>
										</div>
      
    
         </s:if>
        
      
        <div class="uiHeader uiHeaderTopBorder uiHeaderNav">
          <div class="clearfix uiHeaderTop">
            <a class="uiHeaderActions rfloat" href="event/event!listMembers.jhtml?eventId=<s:property value="eventId" />" rel="dialog">查看全部</a>
            <div>
              <h4 class="uiHeaderTitle"><s:property value="members.size()"/> 人确定参加</h4>
            </div>
          </div>
        </div>
      
      	<div class="phs">
											<div class="fbFriendListMemberBoxContent">
												<div class="uiFacepile fbFriendListMemberBoxFacepile uiFacepileMedium" id="u29f2l_23">
													<ul class="uiList uiListHorizontal clearfix pvm">
														<s:iterator value="members" status='st'>
															<s:if test="#st.index%3==0&&#st.index>0"> 
															<ul class="uiList uiListHorizontal clearfix pvm"></ul>
															</s:if> 
															<s:if test="#st.index<12"> 
														<li class="uiFacepileItem uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
															<a class="uiTooltip link" onmouseout="this.blur();" href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value="userid" />" data-jsid="anchor">
																<img class="uiProfilePhoto uiProfilePhotoLarge img" src="<s:property value="avatar" />" alt="" data-jsid="img">
																<span class="uiTooltipWrap top left lefttop">
																	<span class="uiTooltipText"><s:property value="username" /></span>
																</span>
															</a>
														</li>
														</s:if> 
														</s:iterator>
													</ul>
												</div>
											</div>
										</div>
      </div>
    </div>
    
    
    
    
    
  </div>