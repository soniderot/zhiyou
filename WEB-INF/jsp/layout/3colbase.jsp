<%@page trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh" id="facebook" class="no_js">
<head>
<tiles:insertAttribute name="css" ignore="true"/>
</head>

<body class="hasLeftCol home fbx hasSlimHeader ff3 win Locale_zh_CN">
	<input type="hidden" autocomplete="off" id="post_form_id" name="post_form_id" value="c0a81f7ab46455dde1e203435e599680" />
	<div id="FB_HiddenContainer" style="position:absolute; top:-10000px; width:0px; height:0px;"></div>
	<!-- 
	
	include head.jsp
	
	-->
	<tiles:insertAttribute name="head" ignore="true"/>
	
	<div id="globalContainer">
		<div id="content" class="fb_content clearfix">
			<div id="toolbarContainer"></div>
			<div id="mainContainer">
				<div id="leftColContainer">
						<!-- 
	
							include left.jsp
	
						-->
				
				
				<tiles:insertAttribute name="left" ignore="true"/>
				</div>
				<div class="clearfix hasRightCol" id="contentCol">
					<!-- 
	
						include right.jsp
	
					-->
					<tiles:insertAttribute name="right" ignore="true"/>
					<!-- 
	
						include center.jsp
	
					-->
					
					<tiles:insertAttribute name="center" ignore="true"/>
					
					
					<div id="bottomContent"></div>
					
					
				</div>
			</div>
		</div>
		<!-- 
	
			include footer.jsp
	
		-->
		<tiles:insertAttribute name="footer" ignore="true"/>
		
	</div>

	
</body>
</html>