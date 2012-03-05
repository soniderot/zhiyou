<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<div id="rightCol">
  <div id="pagelet_right_sidebar">
    <div id="pagelet_contextual_help"></div>
    <div id="pagelet_ego_pane">
      <div class="ego_column egoOrganicColumn">
        <div class="ego_section">
          <div class="uiHeader uiHeaderTopAndBottomBorder mbs uiSideHeader">
            <div class="clearfix uiHeaderTop">
              <div>
                <h4 class="uiHeaderTitle">个人信息</h4>
              </div>
            </div>
          </div>
          <div class="phs">
            <div class="UIImageBlock clearfix ego_unit">
              <div class="egoProfileTemplate UIImageBlock_Content UIImageBlock_SMALL_Content">
              	<div class="ego_action">
              	  <span class="rightLabel">活动爱好</span>
                  <span class="rightValue"><s:if test="profile.hobbyList.size > 0"><s:property value="profile.hobbyList[0].tag"/></s:if></span>
              	</div>
              	<div class="ego_action">
              	  <span class="rightLabel">兴趣</span>
                  <span class="rightValue"><s:property value="profile.interest"/></span>
              	</div>
              </div>
            </div>
            <div class="UIImageBlock clearfix ego_unit">
              <div class="ego_action">
              	<div class="rightLabel">性别</div>
                <span class="rightValue">
                  <s:if test="profile.gender==1">男</s:if>
                  <s:if test="profile.gender==2">女</s:if> 
                  
                </span>
              </div>
              <div class="ego_action">
              	<span class="rightLabel">自我介绍</span>
                <span class="rightValue"><s:property value="profile.introduction"/></span>
              </div>
            </div>
            
            
            <div class="UIImageBlock clearfix ego_unit">
              <div class="ego_action">
                <span class="rightLabel">QQ</span>
                <span class="rightValue">
                  <s:if test="friendFlag">   
                    <s:property value="profile.qq"/>
                  </s:if>
                  <s:else>一度朋友可见</s:else>
                </span>
              </div>
              <div class="ego_action">
                <span class="rightLabel">邮件地址</span>
                <span class="rightValue">
                  <s:if test="friendFlag">   
                    <s:property value="profile.email"/>
                  </s:if>
                  <s:else>一度朋友可见</s:else>
                </span>
              </div>
              <div class="ego_action">
                <span class="rightLabel">电话号码</span>
                <span class="rightValue">
                  <s:if test="friendFlag==true">   
                  	<s:property value="profile.mobile"/>
                  </s:if>
                  <s:else>一度朋友可见</s:else>
                </span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>