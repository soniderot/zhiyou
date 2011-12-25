<%@page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
	<h6 data-ft="{&quot;type&quot;:1}" class="uiStreamMessage"> 
          											<span data-ft="{&quot;type&quot;:3}" class="messageBody"><s:property value="photo.summary" /></span>
          											</h6>
          											<div data-ft="{&quot;type&quot;:10}" class="mvm uiStreamAttachments clearfix fbMainStreamAttachment">
          												<div>
          													<a data-ft="{&quot;type&quot;:41}" title="<s:property value="photo.summary" />" ajaxify="#" class="uiPhotoThumb largePhoto">
          														<img   alt="" src="<s:property value="photo.filename" />" class="img">
          														</a>
          														<div class="fsm fwn fcg">
          															<span class="caption"></span>
          															<div class="uiAttachmentDesc translationEligibleUserAttachmentMessage"></div>
          														</div>
          														</div>
          														</div>