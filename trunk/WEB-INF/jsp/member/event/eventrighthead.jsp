<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<div id="event_profile_guest_info">
    <div id="pagelet_nav_visitors"></div>
    
    
    <div class="uiHeader uiHeaderTopBorder uiHeaderNav">
         
        </div>
    <a class="mbs uiButton" onclick="return inviteFriends(<s:property value="eventId" />);" href="javascript:void(0);" rel="dialog-post">
      <i class="mrs img sp_7gl7wd sx_61da04"></i>
      <span class="uiButtonText">选择你要邀请的朋友</span>
    </a>
    
    <div>
      <div class="event_guestlist mbm">
      	
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
														<li class="uiFacepileItem uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
															<a class="uiTooltip link" onmouseout="this.blur();" href="http://www.facebook.com/profile.php?id=100003175668442" data-jsid="anchor">
																<img class="uiProfilePhoto uiProfilePhotoLarge img" src="<s:property value="avatar" />" alt="" data-jsid="img">
																<span class="uiTooltipWrap top left lefttop">
																	<span class="uiTooltipText"><s:property value="username" /></span>
																</span>
															</a>
														</li>
														</s:iterator>
													</ul>
												</div>
											</div>
										</div>
      </div>
    </div>
    
  </div>