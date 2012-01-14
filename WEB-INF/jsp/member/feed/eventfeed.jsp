<%@page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<div class="mvm uiStreamAttachments clearfix fbMainStreamAttachment">
  <div class="clearfix">
    <div class="UIImageBlock clearfix">
      <a tabindex="-1" href="event/event!viewEvent.jhtml?eventId=<s:property value="event.id"/>" class="UIImageBlock_Image UIImageBlock_SMALL_Image">
        <img alt="" src="<s:property value="event.logo"/>" class="uiProfilePhoto uiProfilePhotoLarge img" />
      </a>
      <div class="UIImageBlock_Content UIImageBlock_SMALL_Content">
        <div class="mbs">
          <strong>
            <a href="event/event!viewEvent.jhtml?eventId=<s:property value="event.id"/>"><s:property value="event.eventname"/></a>
          </strong>
        </div>
        <div class="fsm fwn fcg">
          <s:date name="event.begintime" format="yyyy-MM-dd HH:mm" />
        </div>
        <div class="fsm fwn fcg">
          <s:property value="event.address"/>
        </div>
      </div>
    </div>
  </div>
  <div class="fsm fwn fcg">
    <span class="caption"></span>
    <div class="uiAttachmentDesc translationEligibleUserAttachmentMessage"></div>
  </div>
</div>
<%@ include file="/WEB-INF/jsp/member/feed/comments.jsp"%>