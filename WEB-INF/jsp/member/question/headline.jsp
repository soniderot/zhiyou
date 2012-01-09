<%@page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<div id="headerArea">
<div id=pagelet_question_header data-referrer="pagelet_question_header">
  <div class="uiHeader uiHeaderPage fbQuestionHeader">
    <div class="clearfix uiHeaderTop">
      <div class="plm uiHeaderActions rfloat">
        <div id=pagelet_question_buttons data-referrer="pagelet_question_buttons">
          <div class="pbm clearfix">
            <a class="rfloat uiButton" title=向指定的人们寻求答案 role=button href="/ajax/choose/?type=questions_forward&amp;qid=3011255527261" rel=dialog>
              <i class="mrs img sp_cw228w sx_4a9919"></i><span class=uiButtonText>问好友</span>
            </a>
            <form class="mrs rfloat" onsubmit="return Event.__inlineSubmit(this,event)" method=post action=/ajax/questions/permalink/follow.php rel="async">
              <label class="selected uiButton uiButtonConfirm" for=unu6gc_13>
                <i class="mrs img sp_4m1rvz sx_5a8389"></i>
                <input id=unu6gc_13 value=关注 type=submit />
              </label>
              <input value=3011255527261 type=hidden name=question_id autocomplete="off">
            </form>
          </div>
        </div>
      </div>
      <div>
        <h2 class=uiHeaderTitle tabIndex=0>世界的尽头在什么时候出现?</h2>
      </div>
    </div>
  </div>
</div>
</div>