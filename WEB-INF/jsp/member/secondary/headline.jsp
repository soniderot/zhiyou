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
  return false;
}

function addFriendRequest(obj, userId) {
  $.ajax({
   type: "GET",
   url: "usr/request!addFriendRequest.jhtml",
   dataType: 'text',
   data: "to="+userId+"&content="+content,
   success: function(data){
     if ("true" == data) {
        $("#ucyftu_4").find("label").addClass("hidden_elem");
        $("#ucyftu_4").removeClass("fStatusRequestable");
        $("#ucyftu_4").addClass("fStatusOutgoing");
        $("#ucyftu_4").find("a").removeClass("hidden_elem");
        $("#ucyftu_4").find("a").addClass("selected uiButtonHover");
     }
   }
  });
  return false;
}
</script>

<div id="headerArea">
  <div id="pagelet_header">
    <div id="pagelet_above_header"></div>
    <div id="pagelet_header_personal">
      <div class="clearfix profileHeader">
      <s:if test="profile.userid!=#session.user.userid">
        <div class="rfloat">
          <div id="ucyftu_4" class="FriendButton profileHeaderButton fStatusRequestable">
            <label for="ucyftu_5" class="FriendRequestAdd addButton uiButton">
              <i class="mrs img sp_ah6icc sx_070d6b"></i>
              
              <s:if test="friendFlag==false&&requestOutFlag==false&&requestInFlag==false">
              <input type="button" id="ucyftu_5" value="加为好友" onclick="showPopup('dialog_0', <s:property value="profile.userid"/>)" />
            </s:if>
            
            <s:if test="friendFlag==true">
            	<span class="uiButtonText">一度朋友</span>
            </s:if>
            
             <s:if test="requestOutFlag==true">
            	<span class="uiButtonText">朋友请求已传送。</span>
            </s:if>
            
             <s:if test="requestInFlag==true">
            	<span class="uiButtonText">朋友请求已收到。</span>
            </s:if>
            
            </label>
            <a href="#" role="button" class="FriendRequestOutgoing enableFriendListFlyout hidden_elem outgoingButton uiButton">
              <i class="mrs img sp_ah6icc sx_070d6b"></i>
              <span class="uiButtonText">朋友请求已传送。</span>
            </a>
          </div>
          
          
           <s:if test="friendFlag==true">
          <a rel="" id="profile_action_send_message" href="usr/message!newMessage.jhtml?receiverId=<s:property value="profile.userid"/>" class="mls uiButton" onclick="return showPopup('dialog_send_msg',<s:property value='profile.userid'/>)">
            <i class="mrs img sp_ah6icc sx_5ecc8d"></i>
            <span class="uiButtonText">发信息</span>
          </a>
          </s:if>
          <!--
          <div class="uiSelector inlineBlock mls uiSelectorRight uiSelectorNormal">
            <div class="wrap">
              <a rel="toggle" data-length="30" aria-haspopup="1" href="#" role="button" class="uiSelectorButton uiButton uiButtonNoText">
                <i class="mrs img sp_ah6icc sx_87bdb5"></i>
                <span class="uiButtonText"></span>
              </a>
              <div class="uiSelectorMenuWrapper uiToggleFlyout">
                <div class="uiMenu uiSelectorMenu" role="menu">
                  <ul class="uiMenuInner">
                    <li id="profile_action_report_block" data-label="举报/屏蔽" class="uiMenuItem">
                      <a rel="dialog" onclick='var report_link = DOM.find($("profile_action_report_block"), "a");report_link.href = URI(report_link.href).addQueryData(  {"profile_wall_tab" : Boolean(      FutureSideNav.getInstance().selected.matchKey("wall"))});' href="/ajax/report/social.php?content_type=0&amp;cid=508440173&amp;rid=508440173&amp;h=AfiqlcXetd52APpQ&amp;from_gear=fbx" tabindex="0" role="menuitem" class="itemAnchor">
                        <span class="itemLabel fsm">举报/屏蔽</span>
                      </a>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>-->
        </div>
        </s:if>
        <div class="profileHeaderMain">
          <h1><span class="profileName fn ginormousProfileName fwb"><s:property value="profile.username"/></span></h1>
        </div>
      </div>
    </div>
    <div id="pagelet_byline">
      <div class="fbProfileByline">
        <s:if test="profile.cityname != null">
        <span class="fbProfileBylineFragment">
          <span class="fbProfileBylineIconContainer">
            <i class="mrs fbProfileBylineIcon img sp_9brcjp sx_60c040"></i>
          </span><span class="fbProfileBylineLabel">住在<a href="javascript:void(0)"><s:property value="profile.cityname"></s:property></a></span>
        </span>
        </s:if>
        <span class="fbProfileBylineFragment">
          <span class="fbProfileBylineIconContainer">
            <i class="mrs fbProfileBylineIcon img sp_9brcjp sx_450ec4"></i>
          </span>
          <span class="fbProfileBylineLabel">年龄：<s:property value="profile.age"></s:property></span>
        </span>
        <s:if test="profile.userid == #session.user.userid">
          <a href="usr/update!basic.jhtml" class="fbProfileEditLink fbEditProfileLink">编辑个人主页</a>
        </s:if>
      </div>
    </div>
  </div>
</div>
<%@ include file="/WEB-INF/jsp/popup/addFriendRequest.jsp"%>
<%@ include file="/WEB-INF/jsp/popup/sendMessagePop.jsp"%>