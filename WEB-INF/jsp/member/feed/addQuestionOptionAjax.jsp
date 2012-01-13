<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<div class="fbEigenpollRow clearfix">
  <s:form method="post" action="#" cssClass="fbEigenpollForm fbEigenpollResults_167223450051505" rel="async">
    <div class="uiFacepile fbEigenpollFacepile rfloat uiFacepileSmall">
      <ul class="uiList uiListHorizontal clearfix"/>
    </div>
    <div class="fbEigenpollCheckbox lfloat">
      <input type="checkbox"  id="option_<s:property value='answerOption.id'/>" name="should_vote" onchange="voteOrUnvote(this)"/>
    </div>
    <div class="fbEigenpollResults">
      <div title="<s:property value='answerOption.summary' />" class="pas fbQuestionsPollResultsBar">
        <div class="label"><span class="fwb"><s:property value='answerOption.summary' /></span></div>
        <div onclick="voteOption('<s:property value="answerOption.id"/>')" class="fbQuestionsPollClickTarget"/>
        <div class="phs auxlabel"><span class="fwb fcg votecount"><s:property value='answerOption.hot' /> 票</span></div>
      </div>
    </div>
  </s:form>
</div>