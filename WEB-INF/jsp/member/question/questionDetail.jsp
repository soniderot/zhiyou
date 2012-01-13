<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<div role="main" id="contentArea">
  <div data-referrer="pagelet_question_answers" id="pagelet_question_answers">
    <div class="mbl pbm fbQuestionsAnswers">
      <form method="post" action="/ajax/questions/polls/save.php" id="question_poll3011255527261" class="live_3011255527261_130062803728786" rel="async">
        <table cellspacing="0" cellpadding="1" class="pollOptions">
          <tbody>
            <s:iterator value="questionVo.optionUsers">
            <tr id="optionrow_<s:property value='option.id'/>" class="pollRow_318130211553990 fbOpinionPollHighlight">
              <td class="pollRadioBtn">
                <input type="checkbox" id="option_<s:property value='option.id'/>" class="mts" value="<s:property value='option.id'/>" name="option_id" onchange="voteOrUnvote(this)"/>
              </td>
              <td onclick="voteOption('<s:property value="option.id"/>')" class="pollResultsBar selectedPollOption">
                <div title="2014" class="pas fbQuestionsPollResultsBar">
                  <div style="<s:if test='selected'>width: 100%;</s:if>" class="shaded full"></div>
                  <div class="label"><span class="fwb"><s:property value='option.summary'/></span></div>
                  <div class="fbQuestionsPollClickTarget"></div>
                  <div class="phs auxlabel"><span class="fwb fcg votecount"><s:property value='option.hot'/> 票</span></div>
                </div>
              </td>
              <td style="" class="pollResultsFacepile">
                <div class="uiFacepile uiFacepileSmall">
                  <ul class="uiList uiListHorizontal clearfix">
                    <s:iterator value="optionProfiles" status="rowstatus">
                    <s:if test="#rowstatus.index < 3">
                    <li class="uiFacepileItem uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
                      <a href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value='userid'/>" class="link" title="">
                        <img alt="" src="<s:property value='avatar'/>" class="uiProfilePhoto uiProfilePhotoSmall img"/>
                      </a>
                    </li>
                    </s:if>
                    </s:iterator>
                    <s:if test="optionProfiles.size()>3">
                    <li class="uiListItem  uiListHorizontalItemBorder uiListHorizontalItem uiFacepileItem fbFacepileItemMore fbFacepileItemMoreLow">
                      <a class=fbFacepileItemMoreText title="" href="/browse/option_voters/?option_id=318130211553990" rel="dialog">
                        <i class="img sp_7oewf3 sx_3e7f3b"></i>
                      </a>
                    </li>
                    </s:if>
                  </ul>
                </div>
              </td>
            </tr>
            </s:iterator>
          </tbody>
        </table>
      </form>
    </div>
  </div>
  <div id="pagelet_question_replies">
    <div id="fbQuestionReplies">
      <div class="uiHeader uiHeaderTopAndBottomBorder pts uiHeaderSection">
        <div class="clearfix uiHeaderTop">
          <div class="uiHeaderActions rfloat fsm fwn fcg">
          </div>
          <div>
            <h3 class="uiHeaderTitle" tabindex="0">帖子</h3>
          </div>
        </div>
      </div>
      <div class="phs">
        <ul class="uiList mvm">
          <li class="pbm uiListItem uiListLight uiListVerticalItemBorder">
            <s:form onsubmit="return commentSubmit(this);" method="post" action="usr/feed!addFeedComment.jhtml" cssClass="focus_target" rel="async">
              <input type="hidden" name="feedId" value="<s:property value='feed.id' />" />
              <div class="UIImageBlock clearfix mtm">
                <img alt="" src="${user.avatar}" class="uiProfilePhoto UIImageBlock_Image UIImageBlock_SMALL_Image uiProfilePhotoLarge img"/>
                <div class="UIImageBlock_Content UIImageBlock_SMALL_Content">
                  <s:textarea rows="2" name="feedComment" onkeypress="enterKeypress(this, event)" title="写点什么吧..." placeholder="写点什么吧..." cssClass="DOMControl_placeholder uiTextareaNoResize uiTextareaAutogrow fbQuestionsReplyComposer" />
                  <label for="unurfx_15" class="shareButton rfloat uiButton uiButtonConfirm">
                    <input type="submit" id="unurfx_15" value="分享"/>
                  </label>
                </div>
              </div>
            </s:form>
          </li>
          <s:iterator value="comments">
          <li class="fbQuestionsReply ptm uiListItem uiListLight uiListVerticalItemBorder comment_<s:property value='comment.id' />">
            <div class="UIImageBlock clearfix mvs">
              <a tabindex="-1" href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value='user.userid'/>" class="UIImageBlock_Image UIImageBlock_SMALL_Image">
                <img alt="" src="<s:property value='user.avatar'/>" class="uiProfilePhoto uiProfilePhotoLarge img"/>
              </a>
              <label for="u3ft9v_1" class="deleteAction stat_elem UIImageBlock_Ext uiCloseButton">
                <input type="button" onclick="showDelCommentPop('dialog_delFeedCmt', <s:property value='comment.id' />)" title="删除"/>
              </label>
              <div class="UIImageBlock_Content UIImageBlock_SMALL_Content">
                <div class="mbs fsm fwn fcg">
                  <strong><a href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value='user.userid'/>"><s:property value='user.username'/></a></strong>
                  <s:date name="comment.created" format="yyyy-MM-dd HH:mm" />
                </div>
                <div class="mvs answerText">
                  <p><s:property value='comment.content'/></p>
                </div>
              </div>
            </div>
          </li>
          </s:iterator>
        </ul>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
  function voteOption(obj) {
    $("#option_" + obj).click();
  }
  function voteOrUnvote(obj) {
    $.ajax({
     type: "GET",
     url: "usr/feed!voteOptionAjax.jhtml",
     dataType: 'text',
     data: "optionId="+obj.value,
     success: function(data) {
       $("#optionrow_" + obj.value).find(".votecount").html(data + " 票");
     }
    });
  }
  
  function enterKeypress(obj, event) {
    if ("" == $(obj).val()) {
      return false;
    }
    if(event.keyCode == 13)
    {
      $(obj).parents("form").submit();
    }
    return false;
  }
  
  function commentSubmit(form) {
    var from = "questionDetail";
    $.post("usr/feed!addFeedCommentAjax.jhtml", {
      feedId : form.feedId.value,
      feedComment : form.feedComment.value,
      fromPage : from
    }, function (data) {
      $(".mvm").prepend(data);
      form.feedComment.value = "";
    });
    return false;
  }
  
  function askFriends(questionId) {
    $.ajax({
     type: "GET",
     url: "usr/feed!askFriendsAjax.jhtml",
     dataType: 'html',
     data: "questionId="+questionId,
     success: function(data) {
       $("body").append(data);
     }
    });
  }
</script>
<%@ include file="/WEB-INF/jsp/popup/delFeedCommentPop.jsp"%>