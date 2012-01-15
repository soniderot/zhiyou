<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page pageEncoding="utf-8"%>
<s:iterator value="profileList" id="profile">
  <div class="userinfo hidden_elem">
    <div class="slidewrap">
  <div class="slidesubwrap">
    <div class="slidecontent">
      <img width=250 height=250 src="<s:property value='avatar' />"/>
    </div>
  </div>
  </div>
    <div align="center">
      <span id=""><a href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value='userid' />"><s:property value='username' /></a></span>
      <span>，<s:property value='age' />岁</span>
    </div>
  </div>
</s:iterator>
