<%@page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<div id="headerArea">
<div id=pagelet_question_header data-referrer="pagelet_question_header">
  <div class="uiHeader uiHeaderPage fbQuestionHeader">
    <div class="clearfix uiHeaderTop">
      <div class="plm uiHeaderActions rfloat">
        <div id=pagelet_question_buttons data-referrer="pagelet_question_buttons">
          <div class="pbm clearfix">
            <a class="rfloat uiButton" title=向指定的人们寻求答案 onclick="return askFriends(<s:property value='questionVo.question.id' />);" href="javascript:void(0);" rel=dialog>
              <i class="mrs img sp_cw228w sx_4a9919"></i><span class=uiButtonText>问好友</span>
            </a>
          </div>
        </div>
      </div>
      <div>
        <h2 class=uiHeaderTitle tabIndex=0><s:property value='questionVo.question.summary' /></h2>
      </div>
    </div>
  </div>
</div>
</div>