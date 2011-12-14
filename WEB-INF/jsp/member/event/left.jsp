<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<div id="leftCol" style="min-height:100px;">
  <img alt="" src="http://profile.ak.fbcdn.net/static-ak/rsrc.php/v1/yn/r/5uwzdFmIMKQ.png" class="mbm event_upload_image img"/>
  <div id="event_profile_guest_info">
    <div data-referrer="pagelet_nav_visitors" id="pagelet_nav_visitors"></div>
    <a ajaxify="/ajax/choose/?type=event&amp;eid=241236155939386&amp;send_invites_on_close=1" rel="dialog-post" href="/events/create/?eid=241236155939386" role="button" class="mbs uiButton">
      <i class="mrs img sp_7gl7wd sx_61da04"></i>
      <span class="uiButtonText">选择你要邀请的朋友</span>
    </a>
    <div>
      <div class="event_guestlist mbm">
        <div class="uiHeader uiHeaderTopBorder uiHeaderNav">
          <div class="clearfix uiHeaderTop">
            <a rel="dialog" href="/ajax/browser/dialog/guestlist/?eid=241236155939386&amp;edge=events%3Ausers_attending" class="uiHeaderActions rfloat">查看全部</a>
            <div>
              <h4 class="uiHeaderTitle">2 人确定参加</h4>
            </div>
          </div>
        </div>
        <ul class="uiList mts prs">
          <li data-gt='{"engagement":{"eng_type":"1","eng_src":"12","eng_tid":"","eng_data":[]}}' class="uiListItem uiListVerticalItemBorder">
            <div class="UIImageBlock clearfix">
              <a aria-hidden="true" tabindex="-1" href="http://www.facebook.com/mkk158" class="UIImageBlock_Image UIImageBlock_ICON_Image">
                <img alt="" src="http://profile.ak.fbcdn.net/hprofile-ak-ash2/370142_1438697558_1584603112_q.jpg" class="uiProfilePhoto uiProfilePhotoMedium img"/>
              </a>
              <div class="guest_name UIImageBlock_Content UIImageBlock_ICON_Content">
                <a href="http://www.facebook.com/mkk158">ま か</a>
              </div>
            </div>
          </li>
          <li data-gt='{"engagement":{"eng_type":"1","eng_src":"12","eng_tid":"","eng_data":[]}}' class="pts uiListItem uiListVerticalItemBorder">
            <div class="UIImageBlock clearfix">
              <a aria-hidden="true" tabindex="-1" href="http://www.facebook.com/profile.php?id=100003175668442" class="UIImageBlock_Image UIImageBlock_ICON_Image">
                <img alt="" src="http://profile.ak.fbcdn.net/hprofile-ak-snc4/372577_100003175668442_1734471697_q.jpg" class="uiProfilePhoto uiProfilePhotoMedium img"/>
              </a>
              <div class="guest_name UIImageBlock_Content UIImageBlock_ICON_Content">
                <a href="http://www.facebook.com/profile.php?id=100003175668442">Mark  Ma</a>
              </div>
            </div>
          </li>
        </ul>
      </div>
    </div>
    <div class="event_guestlist">
      <div class="uiHeader uiHeaderTopBorder uiHeaderNav">
        <div class="clearfix uiHeaderTop">
          <div>
            <h4 class="uiHeaderTitle">等待发出的邀请</h4>
          </div>
        </div>
      </div>
      <div class="prm">一部分邀请正在处理中。稍后将会发送。</div>
    </div>
  </div>
</div>