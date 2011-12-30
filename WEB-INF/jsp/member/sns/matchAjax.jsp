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
      <span id=""><a href="#"><s:property value='username' /></a></span>
      <span>18</span>
      <span><s:property value='countryname' /></span>
    </div>
  </div>
</s:iterator>
