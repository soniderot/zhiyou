<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<div id="leftCol" style="min-height:100px;">
	<s:if test="(event!=null)&&(event.logo!=null)">
  	<img alt="" src="<s:property value="event.logo"/>" class="pbs fbEventPhoto profile-picture img"/>
  </s:if>
  <s:else>
  	<img alt="" src="images/event.jpg" class="pbs fbEventPhoto profile-picture img"/>
</s:else>
  <div id="event_profile_guest_info">
    <div data-referrer="pagelet_nav_visitors" id="pagelet_nav_visitors"></div>
     <s:if test="(event!=null)">
    <a ajaxify="/ajax/choose/?type=event&amp;eid=241236155939386&amp;send_invites_on_close=1" rel="dialog-post" href="/events/create/?eid=241236155939386" role="button" class="mbs uiButton">
      <i class="mrs img sp_7gl7wd sx_61da04"></i>
      <span class="uiButtonText">选择你要邀请的朋友</span>
    </a>
     </s:if>
    <div>
      <div class="event_guestlist mbm">
      	<s:if test="(event!=null)">
        <div class="uiHeader uiHeaderTopBorder uiHeaderNav">
          <div class="clearfix uiHeaderTop">
            <a rel="dialog" href="#" class="uiHeaderActions rfloat">查看全部</a>
            <div>
              <h4 class="uiHeaderTitle"><s:property value="members.size()"/> 人确定参加</h4>
            </div>
          </div>
        </div>
      </s:if>
        <ul class="uiList mts prs">
         <s:iterator value="members">
          <li data-gt='{"engagement":{"eng_type":"1","eng_src":"12","eng_tid":"","eng_data":[]}}' class="pts uiListItem uiListVerticalItemBorder">
            <div class="UIImageBlock clearfix">
              <a aria-hidden="true" tabindex="-1" href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value="userid"/>" class="UIImageBlock_Image UIImageBlock_ICON_Image">
                <img alt="" src="<s:property value="avatar"/>" class="uiProfilePhoto uiProfilePhotoMedium img"/>
              </a>
              <div class="guest_name UIImageBlock_Content UIImageBlock_ICON_Content">
                <a href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value="userid"/>"><s:property value="username"/></a>
              </div>
            </div>
          </li>
        </s:iterator>
        </ul>
      </div>
    </div>
    
  </div>
</div>