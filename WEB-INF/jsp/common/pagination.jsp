<%@page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<s:if test="page.totalPage> 1">
<div class="pages">
<s:if test="page.getIsPrev()">
	<a class="next" href="javascript:void(0);" onclick="return topage('<s:property value="page.prePage" />');">上一页</a>
</s:if>
<s:iterator value="page.getPrevPages()" >
	<a href="javascript:void(0);" onclick="return topage('<s:property />');"><s:property /></a>
</s:iterator>
	<a class="current"><s:property value="page.currentPage"/></a>
<s:iterator value="page.getNextPages()" >
	<a href="javascript:void(0);" onclick="return topage('<s:property />');"><s:property /></a>
</s:iterator>
<s:if test="page.getIsNext()">
  <a class="next" href="javascript:void(0);" onclick="return topage('<s:property value="page.nextPage" />');">下一页</a>
</s:if>
</div>
</s:if>