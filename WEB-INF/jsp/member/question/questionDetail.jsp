<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<div role="main" id="contentArea">
  <div data-referrer="pagelet_question_answers" id="pagelet_question_answers">
    <div class="mvm uiStreamAttachments clearfix">
      <div class="clearfix">
        <div>
          <div class="fbEigenpoll fbEigenpollFeed live_<s:property value='questionVo.question.id' />">
            <s:iterator value="questionVo.optionUsers">
            <div class="fbEigenpollRow clearfix">
              <s:form method="post" action="#" cssClass="fbEigenpollForm fbEigenpollResults_167223450051505" rel="async">
                <div class="uiFacepile fbEigenpollFacepile rfloat uiFacepileSmall">
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
                    <s:if test="optionProfiles.size() > 0">
                    <li class="uiListItem  uiListHorizontalItemBorder uiListHorizontalItem uiFacepileItem fbFacepileItemMore fbFacepileItemMoreLow">
                      <a class=fbFacepileItemMoreText title="" href="#" onclick="return showOptionUsers(<s:property value='option.id'/>);" rel="dialog">
                        <i class="img sp_7oewf3 sx_3e7f3b"></i>
                      </a>
                    </li>
                    </s:if>
                  </ul>
                </div>
                
                <div class="fbEigenpollCheckbox lfloat">
                  <input type="checkbox" id="option_<s:property value='option.id'/>" value="<s:property value='option.id'/>" name="should_vote" <s:if test='selected'>checked="true"</s:if> onchange="voteOrUnvote(this)"/>
                </div>
                <div class="fbEigenpollResults" id="optionrow_<s:property value='option.id'/>">
                  <div title="<s:property value='option.summary' />" class="pas fbQuestionsPollResultsBar">
                    <div style="width: 100%;" class="<s:if test='selected'>shaded</s:if> full"></div>
                    <div class="label"><span class="fwb"><s:property value='option.summary' /></span></div>
                    <div onclick="voteOption('<s:property value="option.id"/>')" class="fbQuestionsPollClickTarget"></div>
                    <div class="phs auxlabel" id="optionrow_<s:property value='option.id'/>">
                      <span class="fwb fcg votecount"><s:property value='option.hot' /> 票</span>
                    </div>
                  </div>
                </div>
              </s:form>
            </div>
            </s:iterator>
            <s:if test="questionVo.question.optionaddable">
            <div class="fbEigenpollAddOption">
              <s:form method="post" action="#" cssClass="focus_target child_was_focused" rel="async">
                <table cellspacing="0" cellpadding="0">
                  <tbody>
                    <tr>
                      <td class="fbEigenpollTypeaheadTD">
                        <div id="uxa0y2_<s:property value='questionVo.question.id' />" class="uiTypeahead fbEigenpollTypeahead">
                          <div class="wrap">
                            <div class="innerWrap">
                              <s:textfield id="optionText_%{questionVo.question.id}" name="optionText" title="添加选项..." placeholder="添加选项..." maxlength="80" cssClass="inputtext textInput DOMControl_placeholder"/>
                            </div>
                            <i class="plus img sp_ayuesb sx_56af78"></i>
                          </div>
                        </div>
                      </td>
                      <td>
                        <label for="uxa0y2_<s:property value='questionVo.question.id' />" class="fbEigenpollAddButton uiButton">
                          <input type="button" id="uxa0y2_<s:property value='questionVo.question.id' />" value="添加" onclick="addOption(<s:property value='questionVo.question.id' />)"/>
                        </label>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </s:form>
            </div>
            </s:if>
          </div>
        </div>
      </div>
      <div class="fsm fwn fcg">
        <span class="caption"></span>
        <div class="uiAttachmentDesc translationEligibleUserAttachmentMessage"></div>
      </div>
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
    obj.checked
    $.ajax({
     type: "GET",
     url: "usr/feed!voteOptionAjax.jhtml",
     dataType: 'text',
     data: "optionId="+obj.value,
     success: function(data) {
       $("#optionrow_" + obj.value).find(".votecount").html(data + " 票");
       if (obj.checked) {
          $("#optionrow_" + obj.value).find(".full").addClass("shaded");
       } else {
          $("#optionrow_" + obj.value).find(".full").removeClass("shaded");
       }
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
      $(form).parent("li").after(data);
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
  
  function addOption(questionId) {
    var optionText = $("#optionText_" + questionId).val();
    var holder = $("#optionText_" + questionId).attr("placeholder");
    if (optionText == holder) {
      return false;
    }
    $.ajax({
     type: "GET",
     url: "usr/feed!addQuestionOptionAjax.jhtml",
     dataType: 'html',
     data: "questionId=" + questionId + "&optionText=" + optionText,
     success: function(data) {
       $(".live_" + questionId).find(".fbEigenpollAddOption").before(data);
       $("#optionText_" + questionId).val(holder);
     }
    });
  }
  
    
  function showOptionUsers(optionId) {
    $.ajax({
     type: "GET",
     url: "usr/feed!getOptionUsersAjax.jhtml",
     dataType: 'html',
     data: "optionId=" + optionId,
     success: function(data) {
       $("body").append(data);
     }
    });
    return false;
  }
</script>
<%@ include file="/WEB-INF/jsp/popup/delFeedCommentPop.jsp"%>