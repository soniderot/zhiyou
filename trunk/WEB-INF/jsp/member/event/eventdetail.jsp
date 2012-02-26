<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>

<div id="contentArea" role="main">
  <div data-referrer="pagelet_roosters" id="pagelet_roosters"></div>
  <div data-referrer="pagelet_stream_header" id="pagelet_stream_header">
    <div class="uiHeader uiHeaderWithImage uiHeaderPage  fbx_stream_header">
      <div class="clearfix uiHeaderTop">
        <div class="uiHeaderActions  rfloat fsl fwb fcb"></div>
        <div>
          <h2 class="uiHeaderTitle">
            <i class="uiHeaderImage img sp_7gl7wd sx_efd21b"></i>活动信息
          </h2>
        </div>
      </div>
    </div>
  </div>
  <%@ include file="/WEB-INF/jsp/member/event/eventdetailhead.jsp"%>
  <div id="pagelet_main_column">
    <div id="pagelet_main_column_personal">
      <div id="pagelet_friends_tab">
        <div id="ulclp8_3" class="fbProfileBrowser">
          <div>
            <div class="uiHeader uiHeaderTopAndBottomBorder uiHeaderSection">
              <div class="clearfix uiHeaderTop">
                <div>
                  <h3 class="uiHeaderTitle">活动照片</h3>
                  <a class="uiAddPhoto" onclick="return showPopup('dialog_uploadPhoto');" href="javascript:void(0);" rel="dialog-post">
                    <span class="uiButtonText">+添加活动照片</span>
                  </a>
                </div>
              </div>
            </div>
            <div id="ulclp8_4" class="listView clearfix large">
              <img height="32" width="32" alt="" src="/images/jKEcVPZFk-2.gif" class="throbber img"/>
              <div class="lists">
                <div id="ulclp8_2" class="fbProfileBrowserResult hideSummary">
                  <div class="pvm phs fbProfileBrowserSummaryBox uiBoxWhite bottomborder"></div>
                  <div class="fbProfileBrowserLargeList fbProfileBrowserListContainer">
                    <ul class="uiList uiListHorizontal clearfix mvm phs">
                      <s:iterator value="eventPhotos" status="status" id="eventPhoto">
                      <li class="uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
                        <div class="fbProfileLargePortrait fbProfileLargeMarginLeft">
                          <a href="event/event!viewEventPhotos.jhtml?eventId=<s:property value='event.id' />">
                            <div class="photoWrapper">
                              <div class="photoCrop">
                                <img alt="" src="<s:property value='photo.filename' />" class="fbProfileLargePortraitImgScaleWidth fbProfileLargePortraitImgSmall img"/>
                              </div>
                            </div>
                            <span class="textWrap fsm fwb"></span>
                          </a>
                          <div class="textWrap fsm fcg"></div>
                        </div>
                      </li>
                      </s:iterator>
                      <!-- 
                      <li class="pls uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
                        <div class="fbProfileLargePortrait fbProfileLargeMarginLeft">
                          <a rel="" href="/find-friends/browser/?ref=pb">
                            <div class="photoWrapper">
                            <img src="/images/icons/find_classmates.png" class="blankStateUserListImage"/>
                            </div>
                            <strong>查找同学</strong>
                          </a>
                        </div>
                      </li>
                       -->
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div id="pagelet_composer">
    <div id="u3mxyl_2" class="uiComposer uiComposerHideContent stat_elem uiMetaComposer uiComposerOpen uiComposerHideContent uiComposerWhiteMessageBox">
      <div class="focus_target">
        <ul class="uiList uiListHorizontal clearfix uiComposerAttachments">
          
          <li class="uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
            <span id="composerTourStart"
              class="uiComposerAttachment statusAttachment uiComposerAttachmentSelected attachmentAcceptsLink">
              <a href="#" tabindex="0" class="uiIconText attachmentLink normal" onclick="changeStatus(this, 'status'); return false;">
                <i class="img sp_7gl7wd sx_bd619c"></i>
                <strong class="attachmentName">活动评论</strong>
              </a> 
              <span class="uiIconText">
                <i class="img sp_7gl7wd sx_bd619c"></i>
                <strong class="attachmentName">活动评论<i class="nub"></i></strong>
              </span>
            </span>
          </li>
          <!--
          <li class="plm uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
            <span id="u3mxyl_4" class="uiComposerAttachment photoAttachment">
             <a href="#" tabindex="0" class="uiIconText attachmentLink normal" onclick="changeStatus(this, 'photo'); return false;">
              <i class="img sp_6h8b4g sx_282f2a"></i>
              <strong class="attachmentName">添加活动照片</strong>
             </a>
             <span class="uiIconText selected">
              <i class="img sp_6h8b4g sx_282f2a"></i>
              <strong class="attachmentName">添加活动照片<i class="nub"></i></strong>
             </span>
            </span>
          </li>-->
          <li class="showWhenLoading attachmentLoader plm uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
            <img height="11" width="16" alt="" src="images/GsNJNwuI-UM.gif" class="uiLoadingIndicatorAsync img" />
          </li>
        </ul>
        <div class="showWhenOpen mutableContent uiComposerMetaContainer">
          <s:form onsubmit="return checkInput();" method="post" action="usr/feed!updateStatusAjax.jhtml" target="u3jjus_1" enctype="multipart/form-data">
            <input type="hidden" value="c0a81f7ab46455dde1e203435e599680" name="post_form_id" />
            <input type="hidden" name="feedtype" value="status" />
            <input type="hidden" name="eventId"  value="<s:property value="event.Id"/>" />
            <div id="u3mxyl_6" class="uiMetaComposerMessageBox uiComposerMessageBoxMentions">
              <table cellspacing="0" cellpadding="0" class="uiMetaComposerMessageBoxTable">
                <tbody>
                  <tr>
                    <td>
                      <div class="inputContainer">
                        <div id="u3mxyl_3" class="uiMentionsInput">
                          <div class="highlighter">
                            <div>
                              <span class="highlighterContent"></span>
                            </div>
                          </div>
                          <div id="u3mxyl_7" class="uiTypeahead composerTypeahead mentionsTypeahead">
                            <div class="wrap">
                              <div class="innerWrap">
                                <s:textarea id="feedmessage" name="feedmessage" placeholder="发表点看法吧" onfocus="expandInput('u3mxyl_2')" 
                                  cssClass="DOMControl_placeholder uiTextareaAutogrow input mentionsTextarea textInput"></s:textarea>
                              </div>
                            </div>
                          </div>
                          <input type="hidden" id="friendId" name="friendId" class="mentionsHidden" />
                        </div>
                        <div class="attachmentMetaArea hidden_elem">
                          <div class="pbm webComposerPhotoUpload">
                            <input type="hidden" value="1324457070" name="qn"/>
                            <div class="webComposerPhotoInputArea">
                              <div class="mbs photoUploadPrompt fwb">从你的电脑上选择一个图像。</div>
                              <input type="file" name="feedphoto" onchange="enableSubmitBtn()" />
                            </div>
                           
                            <div class="webComposerPhotoPreviewArea clearfix hidden_elem">
                              <label for="u3jjus_9" class="uiCloseButton uiCloseButtonDark">
                                <input type="button" id="u3jjus_9" title="删除"/>
                              </label>
                            </div>
                          </div>
                        </div>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <div class="attachmentBottomArea"></div>
                    </td>
                  </tr>
                </tbody>
              </table>
              <div class="showOnceInteracted uiMetaComposerMessageBoxShelf">
                <div class="clearfix uiComposerMessageBoxControls">
                  <ul class="uiList uiListHorizontal clearfix uiComposerBarRightArea rfloat">
                    <li class="pls uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
                      <label for="u3mxyl_8" class="submitBtn uiButton uiButtonConfirm">
                        <input type="submit" id="submitBtn" value="发布" />
                      </label>
                    </li>
                  </ul>
                  <div>
                    <div class="pls textBlurb fsm fwn fcg">
                      <a onclick="return addOptions(this);" rel="async" class="addPollOptionsLink">添加投票选项</a>
                      <label for="u1bkpn_32" class="uiCheckbox hidden_elem optionAddAble">
                        <input type="checkbox" id="u1bkpn_32" name="optionAddAble" value="true" />
                        <span>允许任何人添加选项</span>
                      </label>
                    </div>
                    <div class="attachmentBarArea"></div>
                  </div>
                </div>
              </div>
            </div>
          </s:form>
        </div>
      </div>
    </div>
  </div>
  
  <iframe style="width: 1px; height: 1px; position: absolute; top: -10000px;" name="u3jjus_1" class="fbUploadIframe"></iframe>
  <div id="pagelet_home_stream">
    <div id="c4ec37b3fc7e022d58174072" class="UIIntentionalStream UIStream">
      <ul id="home_stream" class="uiList uiStream UIIntentionalStream_Content" style="min-height: 100px;">
        <s:iterator value="feeds">
          <li id="feed_<s:property value="feed.id"/>"
            class="pvm uiUnifiedStory uiStreamStory genericStreamStory aid_1438697558 uiListItem uiListLight uiListVerticalItemBorder">
            <div class="storyHighlightIndicatorWrapper"></div>
            <div class="storyContent">
              <div class="UIImageBlock clearfix">
                <a href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="user.userid"/>"
                  tabindex="-1"
                  class="actorPhoto UIImageBlock_Image UIImageBlock_MED_Image">
                  <img alt="" src="<s:property value="user.avatar"/>" class="uiProfilePhoto profilePic uiProfilePhotoLarge img" />
                </a>
                <div class="storyInnerContent UIImageBlock_Content UIImageBlock_MED_Content">
                  <a href="javascript:void(0)" onclick="<s:if test="user.userid==#session.user.userid">showDelFeedPop('dialog_delFeed', <s:property value="feed.id"/>)</s:if><s:else>blockFeed(<s:property value="feed.id"/>)</s:else>" title="" class="mlm uiStreamHide uiCloseButton"></a>
                  <div class="mainWrapper">
                    <h6 class="uiStreamMessage">
                      <div class="actorDescription actorName">
                        <a href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="user.userid"/>">
                          <s:property value="user.username" />
                        </a>
                        <s:if test="feed.atuserid!=null&&feed.atuserid>0">
                        (@<a href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="atuser.userid"/>">
                          <s:property value="atuser.username" />
                        </a>)
                        </s:if>
                        <s:if test="feed.handle=='sns.publish.text'">发布了评论</s:if>
                        <s:if test="feed.handle=='sns.event.text'">发布了关于活动
                          <a href="event/event!viewEvent.jhtml?eventId=<s:property value="event.id"/>">
                          <s:property value="event.eventname" />
                          </a>的评论
                        </s:if>
                          
                        <s:if test="feed.handle=='sns.event.photo'">发布了关于活动
                          <a href="event/event!viewEvent.jhtml?eventId=<s:property value="event.id"/>">
                            <s:property value="event.eventname" />
                          </a>的照片
                        </s:if>
                          
                        <s:if test="feed.handle=='sns.event.create'">创建了一个活动</s:if>
                        <s:if test="feed.handle=='sns.event.join'">参加了一个活动</s:if>
                        <s:if test="feed.handle=='sns.publish.photo'">发布了照片</s:if>
                        <s:if test="feed.handle=='sns.share.connection'">
                                                    和<a href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="friend.userid"/>">
                            <s:property value="friend.username" />
                          </a>变为朋友
                        </s:if>
                        <s:if test="feed.handle=='sns.share.text'">分享了<a href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="friend.userid"/>"><s:property value="friend.username"/></a>的评论</s:if>
                        <s:if test="feed.handle=='sns.share.photo'">分享了<a href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="friend.userid"/>"><s:property value="friend.username"/></a>的照片</s:if>
                        <s:if test="feed.handle=='sns.publish.question'">发布了问题
                          <a href="sns/question!viewQuestion.jhtml?questionId=<s:property value='feed.referenceid'/>">
                            <s:property value="feed.body"/>
                           </a>
                        </s:if>
                      </div>
                      
                      <s:if test="feed.handle=='sns.publish.text'||feed.handle=='sns.event.text'">
                        <span class="messageBody">
                          <s:property value="feed.body" />
                        </span>
                        <%@ include file="/WEB-INF/jsp/member/feed/comments.jsp"%>
                      </s:if>
                      <s:if test="feed.handle=='sns.share.connection'">
                        <%@ include file="/WEB-INF/jsp/member/feed/comments.jsp"%>
                      </s:if>
                      <s:if test="feed.handle=='sns.share.text'">
                        <span class="messageBody">
                          <s:property value="oldFeed.body" />
                        </span>
                        <%@ include file="/WEB-INF/jsp/member/feed/comments.jsp"%>
                      </s:if>
                    </h6>
                    <s:if test="feed.handle=='sns.share.photo'">
                    <h6 class="uiStreamMessage">
                      <span class="messageBody"><s:property value="feed.shareReason"/></span>
                    </h6>
                    </s:if>
                    <s:if test="(feed.handle=='sns.event.create')||(feed.handle=='sns.event.join')">
                      <%@ include file="/WEB-INF/jsp/member/feed/eventfeed.jsp"%>
                    </s:if>
                     <s:if test="(feed.handle=='sns.publish.photo'||feed.handle=='sns.share.photo'||feed.handle=='sns.event.photo')">
                      <%@ include file="/WEB-INF/jsp/member/feed/photofeed.jsp"%>
                    </s:if>
                    <s:if test="(feed.handle=='sns.publish.question')">
                      <%@ include file="/WEB-INF/jsp/member/feed/questionfeed.jsp"%>
                    </s:if>
                  </div>
                </div>
              </div>
            </div>
          </li>
        </s:iterator>
      </ul>
      <div>
        <div id="pagelet_stream_pager">
          <div class="clearfix mts uiMorePager stat_elem fbStreamPager">
            <div>
              <s:if test="feeds.size()>0">
              <jsp:include page="/WEB-INF/jsp/common/pagination.jsp" flush="true" />
            </s:if>
            <s:else>
              <div class="pam uiBoxLightblue uiMorePagerPrimary">目前没有更多动态可显示。</div>
            </s:else>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
  var attach = $(".attachmentMetaArea").html();
  $(".attachmentMetaArea").empty();
  $("#ue0994_29").hide();
  var addOptionLink = $(".textBlurb").html();
  $(".textBlurb").empty();
  
  function changeStatus(obj, feedtype) {
    $("input[name='feedtype']").val(feedtype);
    $("#u3mxyl_2").find("div:first").addClass("child_was_focused");
    if (feedtype == "photo") {
      $(".uiMetaComposerMessageBoxTable").show();
      $(".attachmentMetaArea").html(attach);
      $(".attachmentMetaArea").removeClass("hidden_elem");
      $(".textBlurb").empty();
      $("#submitBtn").parent().addClass("uiButtonDisabled");
      $("textarea[name='feedmessage']").attr("placeholder", "说点什么吧!");
      $("textarea[name='feedmessage']").val("说点什么吧!");
      $(".attachmentFrame").addClass("hidden_elem");
    } else if(feedtype == "question") {
      var i = 0;
      $(".fbEigenpollTypeahead").each(function() {
        if (i >= 2) {
          $(this).addClass("hidden_elem");
        }
        i++;
      });
      $(".uiMetaComposerMessageBoxTable").hide();
      $("textarea[name='feedmessage']").val("");
      $(".attachmentMetaArea").empty();
      $(".textBlurb").html(addOptionLink);
      $("#submitBtn").parent().removeClass("uiButtonDisabled");
      $(".attachmentFrame").removeClass("hidden_elem");
    } else {
      $(".uiMetaComposerMessageBoxTable").show();
      $("textarea[name='feedmessage']").attr("placeholder", "你在想什么？");
      $("textarea[name='feedmessage']").val("你在想什么？");
      $(".attachmentMetaArea").empty();
      $(".textBlurb").empty();
      $("#submitBtn").parent().removeClass("uiButtonDisabled");
      $(".attachmentFrame").addClass("hidden_elem");
      $("#ue0994_29").hide();
    }

    $(obj).parents("ul").find("a").each(function() {
      if($(this).html() == $(obj).html()) {
        $(this).hide();
        $(this).next().show();
      } else {
        $(this).show();
        $(this).next().hide();
      }
    });
  }
  
  function expandInput(container) {
    $("#" + container).find("div:first").addClass("child_was_focused");
  }
  
  function updateCallback(feedtype, data) {
    $("#home_stream").prepend(data);
    if ("photo" == feedtype) {
      $("#submitBtn").parent().addClass("uiButtonDisabled");
    } else if ("question" == feedtype) {
      $("input[name='options']").each(function(){
        $(this).val($(this).attr("placeholder"));
      });
      var question = $("input[name='question']").attr("placeholder");
      $("input[name='question']").val(question);
      $(".addPollOptionsLink").show();
      $("#ue0994_29").hide();
      $(".optionAddAble").addClass("hidden_elem");
    }
  }
  
  function enableSubmitBtn() {
    $("#submitBtn").parent().removeClass("uiButtonDisabled");
  }
  
  // show comment
  function showComments(obj) {
    $(obj).parents("form").removeClass("collapsed_comments");
    $(obj).parents("ul").addClass("child_was_focused");
    $("div[id^='shareInput_']").find("ul").css("display", "none");
    return false;
  }
  
  function showShareInput(feedId) {
    $("#shareInput_" + feedId).parents("form").addClass("collapsed_comments");
    $("#shareInput_" + feedId).find("ul").css("display", "block");
    return false;
  }
  function commentFocus(obj) {
    $(obj).parents("ul").addClass("child_is_active child_is_focused");
    return false;
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
    $.post("usr/feed!addFeedCommentAjax.jhtml", {
      feedId : form.feedId.value,
      feedComment : form.feedComment.value
    }, function (data) {
      $(form).find(".commentList").append(data);
      form.feedComment.value = "";
    });
    return false;
  }
  
  function topage(pageNo) {
  <s:if test="event!=null">
   location.href = "event/event!viewEvent.jhtml?eventId=<s:property value="event.id" />&pageNo="+pageNo
  </s:if>
  <s:else>
  location.href = "/usr/feed.jhtml?handle=<s:property value="handle" />&pageNo="+pageNo
  </s:else>
  return false;
  }
  function addOptions(obj) {
    $(obj).hide();
    $("#ue0994_29").show();
    $(".optionAddAble").removeClass("hidden_elem");
    return false;
  }

  function addNextOption(obj) {
    $("#" + obj).removeClass("hidden_elem");
  }
  function checkInput() {
    $("input[name='options']").each(function(){
      if($(this).val() == $(this).attr("placeholder")) {
        $(this).val("");
      }
    });
  }
  
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
       if (obj.checked) {
          $("#optionrow_" + obj.value).find(".full").addClass("shaded");
       } else {
          $("#optionrow_" + obj.value).find(".full").removeClass("shaded");
       }
     }
    });
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
  
  function share(obj, event, feedId) {
  
    if(event.keyCode == 13)
    {
      $.ajax({
       type: "GET",
       url: "usr/feed!sharedFeedAjax.jhtml",
       dataType: 'html',
       data: "feedId=" + feedId + "&shareReason=" + $(obj).val(),
       success: function(data) {
         $("body").append(data);
         $(obj).val("");
       }
      });
    }
    return false;
  }
  
  function blockFeed(feedId) {
    $.post("usr/feed!blockFeedAjax.jhtml", {
        feedId : feedId
      }, function (data) {
        $("#feed_" + feedId).remove();
      });
      return false;
  }
  
  function showBigPhoto(feedId) {
    $.ajax({
     type: "GET",
     url: "usr/feed!showBigPhotoAjax.jhtml",
     dataType: 'html',
     data: "feedId=" + feedId,
     success: function(data) {
       $("body").append(data);
     }
    });
  }
  
  function removeBigPhoto() {
    $("#fbPhotoSnowlift").remove();
  }
  
  function replyFocus(name) {
    $("#shareReasonInput").addClass("hidden_elem");
    $("#fbPhotoSnowliftFeedbackInput").removeClass("hidden_elem");
    $("#"+name).parents().find(".uiUfiComments").show();
    $("#"+name).parents().find(".ufiNub").removeClass("share");
    document.getElementById(name).focus();
    return false;
  }
  
  function showShareReasonInput(obj) {
    $("#shareReasonInput").removeClass("hidden_elem");
    $("#fbPhotoSnowliftFeedbackInput").addClass("hidden_elem");
    $(obj).parents().find(".uiUfiComments").hide();
    $(obj).parents().find(".ufiNub").addClass("share");
    return false;
  }
</script>

<%@ include file="/WEB-INF/jsp/popup/delFeedCommentPop.jsp"%>
<%@ include file="/WEB-INF/jsp/popup/uploadPhotoPop.jsp"%>