<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<script type="text/javascript">
function sendFriendRequest(obj, userId) {
  $.ajax({
   type: "GET",
   url: "usr/request!addFriendRequest.jhtml",
   dataType: 'text',
   data: "to="+userId+"&content="+content,
   success: function(data){
     if ("true" == data) {
        var objParent = $(obj).parent();
        $(obj).fadeOut("fast");
        $(objParent).html("好友请求已经发送");
     }
   }
  });
}
</script>

<div role="complementary" id="rightCol">
  <s:if test="#session.cssflag==null"> 
  	 <div class="home_right_column" >
  </s:if>
    <div class="rightColumnWrapper">
      <div id="pagelet_chbox"></div>
      <div id="pagelet_ego_pane_w">
        <s:if test="eventId>0">
        <jsp:include page="/WEB-INF/jsp/member/event/eventrighthead.jsp" flush="true" />
        </s:if>
        <div class="ego_column egoOrganicColumn">
          <div class="ego_section">
            <s:if test="groupId>0 && friendsInGroup.size()>0">  
            <div id="friend_list_members_box">
              <div class="fbFriendListMemberBox" id="u29f2l_22">
                <div class="uiHeader uiHeaderTopAndBottomBorder uiHeaderSection fbFriendListMemberBoxTitle">
                  <div class="clearfix uiHeaderTop">
                    <div class="uiHeaderActions rfloat fsm fwn fcg">
                    	<!--
                      <a rel="dialog" href="#" onclick="return getGroupFriends(${param.groupId})">管理列表</a>-->
                    </div>
                    <div><h3 class="uiHeaderTitle">此列表中的朋友（<s:property value="friendsInGroup.size()" />）</h3></div>
                  </div>
                </div>
                <div class="phs">
                  <div class="fbFriendListMemberBoxContent">
                    <div class="uiFacepile fbFriendListMemberBoxFacepile uiFacepileMedium" id="u29f2l_23">
                      <ul class="uiList uiListHorizontal clearfix pvm">
                        <s:iterator value="friendsInGroup" status='st'>
                          <s:if test="#st.index%4==0&&#st.index>0"> 
                          <ul class="uiList uiListHorizontal clearfix pvm"></ul>
                          </s:if> 
                        <li class="uiFacepileItem uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
                          <a class="uiTooltip link" onmouseout="this.blur();" href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value="userid" />">
                            <img class="uiProfilePhoto uiProfilePhotoLarge img" src="<s:property value="avatar" />" alt="">
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
            </s:if> 
            
            <s:if test="events!=null&&events.size()>0">   
            <div class="uiHeader uiHeaderTopAndBottomBorder mbs uiSideHeader">
              <div class="clearfix uiHeaderTop">
                <a href="/event/event!getMyEvents.jhtml" class="uiHeaderActions rfloat">显示更多</a>
                <div><h4 class="uiHeaderTitle">近期活动</h4></div>
              </div>
            </div>
            </s:if>   
            <div class="phs">
              <s:iterator value="events">
              <div class="UIImageBlock clearfix ego_unit">
                <a tabindex="-1" href="event/event!viewEvent.jhtml?eventId=<s:property value="event.id" />" class="UIImageBlock_Image UIImageBlock_SMALL_Image">
                  <img alt="" src="<s:property value="event.logo" />" class="uiProfilePhoto uiProfilePhotoLarge img"/>
                </a>
                <div class="egoProfileTemplate UIImageBlock_Content UIImageBlock_SMALL_Content">
                  <a href="event/event!viewEvent.jhtml?eventId=<s:property value="event.id" />" class="ego_title"><s:property value="event.eventname" /></a>
                  <div class="ego_action"></div>
                </div>
              </div>
              </s:iterator>
            </div>
            <s:if test="matchedProfiles!=null&&matchedProfiles.size()>0">   
            <div class="uiHeader uiHeaderTopAndBottomBorder mbs uiSideHeader">
              <div class="clearfix uiHeaderTop">
                <a href="sns/search!search.jhtml?match=1" class="uiHeaderActions rfloat">显示更多</a>
                <div><h4 class="uiHeaderTitle">已配对列表</h4></div>
              </div>
            </div>
            </s:if>  
             
             
              <!---
             <div class="phs">
               <s:iterator value="matchedProfiles" status="st">
              <div class="UIImageBlock clearfix ego_unit">
                <a aria-hidden="true" tabindex="-1" data-gt='{"engagement":{"eng_type":"1","eng_src":"13","eng_tid":"1372884330","eng_data":{"ego_service":"pymk","ego_pos":"4"}}}' href="/profile/profile!viewProfileInfo.jhtml?userid=${userid}" class="UIImageBlock_Image UIImageBlock_SMALL_Image">
                  <img alt="" src="${avatar }" class="uiProfilePhoto uiProfilePhotoLarge img"/>
                </a>
                <div class="egoProfileTemplate UIImageBlock_Content UIImageBlock_SMALL_Content">
                  <a data-gt='{"engagement":{"eng_type":"1","eng_src":"13","eng_tid":"1372884330","eng_data":{"ego_service":"pymk","ego_pos":"4"}}}' href="/profile/profile!viewProfileInfo.jhtml?userid=${userid}" class="ego_title">${username }</a>
                  <div class="ego_action">
                  </div>
                </div>
              </div>
              </s:iterator>
            </div>-->
            <div class="phs">
              <div class="fbFriendListMemberBoxContent">
                <div class="uiFacepile fbFriendListMemberBoxFacepile uiFacepileMedium" id="u29f2l_23">
                  <ul class="uiList uiListHorizontal clearfix pvm">
                    <s:iterator value="matchedProfiles" status='st'>
                      <s:if test="#st.index%3==0&&#st.index>0"> 
                      <ul class="uiList uiListHorizontal clearfix pvm"></ul>
                      </s:if> 
                    <li class="uiFacepileItem uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
                      <a class="uiTooltip link" onmouseout="this.blur();" href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value="userid" />">
                        <img class="uiProfilePhoto uiProfilePhotoLarge img" src="<s:property value="avatar" />" alt="">
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
            <s:if test="profiles!=null">   
            <div class="uiHeader uiHeaderTopAndBottomBorder mbs uiSideHeader">
              <div class="clearfix uiHeaderTop">
                <a href="usr/landing.jhtml" class="uiHeaderActions rfloat">显示更多</a>
                <div><h4 class="uiHeaderTitle">你可能认识的人</h4></div>
              </div>
            </div>
             </s:if>   
             <div class="phs">
              <s:iterator value="profiles">
              <div class="UIImageBlock clearfix ego_unit">
                <a aria-hidden="true" tabindex="-1" data-gt='{"engagement":{"eng_type":"1","eng_src":"13","eng_tid":"1372884330","eng_data":{"ego_service":"pymk","ego_pos":"4"}}}' href="/profile/profile!viewProfileInfo.jhtml?userid=${userid}" class="UIImageBlock_Image UIImageBlock_SMALL_Image">
                  <img alt="" src="${avatar }" class="uiProfilePhoto uiProfilePhotoLarge img"/>
                </a>
                <div class="egoProfileTemplate UIImageBlock_Content UIImageBlock_SMALL_Content">
                  <a data-gt='{"engagement":{"eng_type":"1","eng_src":"13","eng_tid":"1372884330","eng_data":{"ego_service":"pymk","ego_pos":"4"}}}' href="/profile/profile!viewProfileInfo.jhtml?userid=${userid}" class="ego_title">${username }</a>
                  <div class="ego_action">
                    <s:if test="requestOutFlag==true">   
                      好友请求已发送
                    </s:if>
                     <s:elseif test="requestInFlag==true">   
                       好友请求已收到
                    </s:elseif> 
                    <s:else>
                    <a rel="async-post" onclick="sendFriendRequest(this, '${userid}')" style="padding-left: 18px;" class="uiIconText">
                      <i style="top: 2px;" class="img sp_6h8b4g sx_c4a0c4"></i>加为好友
                    </a>
                  </s:else>
                  </div>
                </div>
              </div>
              </s:iterator>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
   <s:if test="#session.cssflag==null"> 
  	 </div>
  </s:if>

<script type="text/javascript">
  function inviteFriends(eventId) {
    $.get("event/event!getEventFriendsAjax.jhtml", {eventId: eventId}, function(data) {
      $("body").append(data);
    });
  }
</script>