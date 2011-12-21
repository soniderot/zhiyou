<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
{
  query:"<%=request.getParameter("term")%>",
  suggestions:[
    <c:if test="${!empty recommended}">
      "${recommended.city.name}"<c:if test="${!empty suggested}">,</c:if>
    </c:if>
    <c:if test="${!empty suggested}">
      <c:forEach items="${suggested}" var="location" varStatus="status">
        "${location.cityname}"<c:if test="${!status.last}">,</c:if>
      </c:forEach>
    </c:if>
  ],
  data:[
    <c:if test="${!empty recommended}">
      {
        city:"${recommended.city.cityId}",
        cityString: "${recommended.city.name}"
      },
    </c:if>
    <c:if test="${!empty suggested}">
      <c:forEach items="${suggested}" var="location" varStatus="status">
        {
          city:"${location.id}",
          cityString: "${location.cityname}"
        }<c:if test="${!status.last}">,</c:if>
      </c:forEach>
    </c:if>
  ]
}
