<%@page contentType="textml;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh" id="facebook" class="no_js">
<head>
  <meta name="robots" content="noodp,noydir" />
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
  <tiles:insertAttribute name="css" ignore="true"/>
</head>

<body class="hasLeftCol home fbPageEdit fbx hasSlimHeader ff3 win Locale_zh_CN">
	<input type="hidden" autocomplete="off" id="post_form_id" name="post_form_id" value="c0a81f7ab46455dde1e203435e599680" />
	<div id="FB_HiddenContainer" style="position:absolute; top:-10000px; width:0px; height:0px;"></div>
		<tiles:insertAttribute name="head" ignore="true"/>
	
	<div id="globalContainer">
		<div id="content" class="fb_content clearfix">
			<div id="toolbarContainer"></div>
			<div id="mainContainer">
				<div id="leftColContainer">
					<tiles:insertAttribute name="left" ignore="true"/>
				</div>
				<div class="" id="contentCol" style="min-height: 100px;" data-referrer="contentCol">
					<tiles:insertAttribute name="headline" ignore="true"/>
				  <tiles:insertAttribute name="content" ignore="true"/>
                  <div id="bottomContent"></div>
				</div>
			</div>
		</div>
		
	<tiles:insertAttribute name="footer" ignore="true"/>
	</div>

	
</body>
</html>