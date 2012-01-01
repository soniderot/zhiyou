<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page pageEncoding="utf-8"%>
<!DOCTYPE	html>
<html	lang="zh"	id="facebook"	class="no_js">
<head>
	<tiles:insertAttribute name="css" ignore="true"/>
</head>

<body	class="fbx hasSlimHeader ff3 win Locale_zh_CN defaultScrollbar">
	<input type="hidden" autocomplete="off"	id="post_form_id"	name="post_form_id"	value="c0a81f7ab46455dde1e203435e599680" />
	<div id="FB_HiddenContainer" style="position:absolute; top:-10000px; width:0px;	height:0px;"></div>
	
	<!--
	<tiles:insertAttribute name="head" ignore="true"/>-->
	
	<div id="globalContainer">
		<div id="content"	class="fb_content	clearfix">
			<div id="toolbarContainer"></div>

			<div id="mainContainer">
				
				<div id="leftColContainer">
				</div>
				
				
				<div class="hasRightCol" id="contentCol" style="min-height:	100px;"	data-referrer="contentCol">
					<div id="headerArea"></div>
					

						<tiles:insertAttribute name="right" ignore="true"/>


				
						<tiles:insertAttribute name="content" ignore="true"/>
					
					<div id="bottomContent"></div>
				</div>

			</div>
		</div>
			
			<!--
		<tiles:insertAttribute name="footer" ignore="true"/>
		-->
	</div>
</body>
</html>