<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page pageEncoding="utf-8"%>
<s:iterator value="profileList" id="profile">
  <div class="userinfo hidden_elem">
  	
    <div class="yesNoBtns">感兴趣？
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
        	<a href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value='userid' />">
          <img src="<s:property value='avatar' />"/>
        </a>
        </div>
        <center>
        <span id=""><a href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value='userid' />"><s:property value='username' /></a></span>
      	<span>，<s:property value='age' />岁</span>
        </center>
      </div>
    </div>
    
    <div class="v_profile">
      <h1>个人信息</h1>
      <ul>
        <li>
          <h3>活动爱好</h3>
           <s:property value='hobbyStr' /></li>
        <li>
          <h3>兴趣</h3>
          <s:property value='interest' /></li>
        <li>
          <h3>自我介绍</h3>
          <s:property value='introduction' /></li>
        <li>
          <h3>所在城市</h3>
          <s:property value='cityname' /></li>
        <li>
          <h3>大学</h3>
          <s:property value='collegename' /></li>
      </ul>
    </div>
  </div>
  
</s:iterator>
