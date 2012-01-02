<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
{
  query:"<%=request.getParameter("term")%>",
  suggestions:[
    <c:if test="${!empty recommended}">
      "${recommended.city.name}"<c:if test="${!empty suggested}">,</c:if>
    </c:if>
    <c:if test="${!empty suggested}">
      <c:forEach items="${suggested}" var="school" varStatus="status">
        "${school.schoolname}"<c:if test="${!status.last}">,</c:if>
      </c:forEach>
    </c:if>
  ],
  data:[
    <c:if test="${!empty recommended}">
      {
        schoolId:"${recommended.school.id}",
        schoolName: "${recommended.school.schoolname}"
      },
    </c:if>
    <c:if test="${!empty suggested}">
      <c:forEach items="${suggested}" var="school" varStatus="status">
        {
          schoolId:"${school.id}",
          schoolName: "${school.schoolname}"
        }<c:if test="${!status.last}">,</c:if>
      </c:forEach>
    </c:if>
  ]
}
