<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page pageEncoding="utf-8"%>
<s:iterator value="profileList" id="profile">
  <div class="userinfo hidden_elem">
    <div class="yesNoBtns">
    	<!--
      <label class="uiButton uiButtonDisabled uiButtonConfirm" for="noBtn_<s:property value='userid' />">
        <input type="button" value="&nbsp;&nbsp;No&nbsp;&nbsp;" onclick="addOrCancelRequest(<s:property value='userid' />, 0)" id="noBtn_<s:property value='userid' />"/>
      </label>
      -->
      <label class="saveButton uiButton uiButtonConfirm" for="yesBtn_<s:property value='userid' />">
        <input type="button" value="&nbsp;&nbsp;Yes&nbsp;&nbsp;" onclick="addOrCancelRequest(<s:property value='userid' />, 1)" id="yesBtn_<s:property value='userid' />"/>
      </label>
    </div>
    <div class="slidewrap">
      <div class="slidesubwrap">
        <div class="slidecontent">
          <img src="<s:property value='avatar' />"/>
        </div>
      </div>
    </div>
    <div align="center">
      <span id=""><a href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value='userid' />"><s:property value='username' /></a></span>
      <span>，<s:property value='age' />岁</span>
    </div>
  </div>
</s:iterator>
