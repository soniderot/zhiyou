<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<table class="uiInfoTable mts noBorder">
  <tbody>
    <tr class="dataRow">
      <td>你可能感兴趣的标签：</td>
      <td colspan="4"><span style="float:right;padding-right"><a onclick="changeTag()">换一换</a></span></td>
    </tr>
    <c:set var="count">${fn:length(interests)}</c:set>
    <c:forEach items="${interests}" var="interest" step="4" varStatus="status">
    <tr>
      <td></td>
      <td>
        <c:if test="${count>status.index}">
          <span class="removable uiToken" onclick="addTag(${interests[status.index].id}, '${interests[status.index].tag}')">
            <b>+</b>${interests[status.index].tag}
          </span>
         </c:if>
      </td>
      <td>
        <c:if test="${count>status.index+1}">
          <span class="removable uiToken" onclick="addTag(${interests[status.index+1].id}, '${interests[status.index+1].tag}')">
            <b>+</b>${interests[status.index+1].tag}
          </span>
        </c:if>
      </td>
      <td>
        <c:if test="${count>status.index+2}">
          <span class="removable uiToken" onclick="addTag(${interests[status.index+2].id}, '${interests[status.index+2].tag}')">
            <b>+</b>${interests[status.index+2].tag}
          </span>
        </c:if>
      </td>
      <td>
        <c:if test="${count>status.index+3}">
          <span class="removable uiToken" onclick="addTag(${interests[status.index+3].id}, '${interests[status.index+3].tag}')">
            <b>+</b>${interests[status.index+3].tag}
          </span>
        </c:if>
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
