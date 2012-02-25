<%@page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<div id="headerArea">
					  <div id="pagelet_header" data-referrer="pagelet_header">
					    <div id="pagelet_above_header" data-referrer="pagelet_above_header"></div>
					    <div id="pagelet_header_personal" data-referrer="pagelet_header_personal">
					      <div class="clearfix profileHeader">
					       
					        <div class="profileHeaderMain">
					          <h1>
					          	<s:if test="(degree<2)"> 
					          	<span class="profileName fn ginormousProfileName fwb">我的一度朋友</span>
					          	</s:if> 
					          	<s:else>
					          	<span class="profileName fn ginormousProfileName fwb">我的二度朋友</span>
					          </s:else>
					          </h1>
					        </div>
					      </div>
					    </div>
					  </div>
					</div>