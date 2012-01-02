<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<div role="main" id="contentArea">
  <div data-referrer="pagelet_roosters" id="pagelet_roosters"></div>
  <div data-referrer="pagelet_stream_header" id="pagelet_stream_header">
  	
  	<s:if test="userid>0">
  	
  	<div data-referrer="pagelet_composer" id="pagelet_composer">
    <div id="u3mxyl_2"
      onclick="Bootloader.loadComponents(&quot;Composer&quot;, function() { JSCC.get(&#39;j4ec37b3f908df06889566482&#39;) });"
      class="uiComposer uiComposerHideContent stat_elem uiMetaComposer uiComposerTopBorder uiComposerOpen uiComposerHideContent uiComposerWhiteMessageBox">
      <div class="focus_target">
        <ul class="uiList uiListHorizontal clearfix uiComposerAttachments">
         
          <li class="showWhenLoading attachmentLoader plm uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
            <img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="uiLoadingIndicatorAsync img" />
          </li>
        </ul>

       
      </div>
    </div>
  </div>
</s:if>
  	<s:else>
  	
  	
    <div class="uiHeader uiHeaderWithImage uiHeaderPage  fbx_stream_header">
      <div class="clearfix uiHeaderTop">
        <div class="uiHeaderActions  rfloat fsl fwb fcb">
          
          <a href="usr/feed.jhtml?handle=sns.event.create,sns.event.join"><span class="fwn">活动动态</span> </a> ·
          <a href="usr/feed.jhtml?handle=sns.share.connection"><span class="fwn">交友动态</span> </a> ·
          <div id="u3mxyl_1" class="uiSelector inlineBlock filterListSelector  uiSelectorRight  uiSelectorNormal uiSelectorDynamicLabel">
            <div class="wrap">
              <!--
              <a rel="toggle" data-length="30" aria-haspopup="1"
                href="#" role="button"
                class="uiSelectorButton  uiButton"> <span
                class="uiButtonText">最新消息</span> </a>-->
                <!--
              <div class="uiSelectorMenuWrapper  uiToggleFlyout">
                <div class="uiMenu uiSelectorMenu" role="menu">
                  <ul class="uiMenuInner">
                    <li data-label="最新消息"
                      class="uiMenuItem  uiMenuItemRadio  uiSelectorOption checked">
                      <a href="/?sk=lf" aria-checked="true" tabindex="0"
                        role="menuitemradio" class="itemAnchor"> <span
                        class="itemLabel fsm"> <i
                          class="mrs  img  sp_6h8b4g  sx_ed8728"></i>最新消息
                      </span>
                      </a>
                    </li>
                    <li data-label="状态更新" class="uiMenuItem  uiMenuItemRadio  uiSelectorOption">
                      <a href="/?sk=app_2915120374" aria-checked="false" tabindex="-1" role="menuitemradio" class="itemAnchor">
                        <span class="itemLabel fsm">
                          <i class="mrs  img  sp_cnv1wq  sx_fe0386"></i>状态更新
                        </span>
                      </a>
                    </li>
                    <li data-label="专页" class="uiMenuItem  uiMenuItemRadio  uiSelectorOption">
                      <a href="/?sk=pp" aria-checked="false" tabindex="-1" role="menuitemradio" class="itemAnchor">
                        <span class="itemLabel fsm">
                          <i class="mrs  img  sp_6h8b4g  sx_6bbf39"></i>专页
                        </span>
                      </a>
                    </li>
                    <li data-label="提问" class="uiMenuItem  uiMenuItemRadio  uiSelectorOption">
                      <a href="/?sk=app_10150110253435258" aria-checked="false" tabindex="-1" role="menuitemradio" class="itemAnchor">
                        <span class="itemLabel fsm">
                          <i class="mrs  img  sp_cnv1wq  sx_589bc0"></i>提问
                        </span>
                      </a>
                    </li>
                    <li class="uiMenuSeparator"></li>
                    <li data-label="编辑显示设置" class="uiMenuItem">
                      <a ajaxify="/ajax/feed/edit_options_dialog.php?filter_key=lf" rel="dialog-post" href="#" tabindex="-1" role="menuitem" class="itemAnchor">
                        <span class="itemLabel fsm">
                          <i class="mrs  img  sp_7gl7wd  sx_d43f0c"></i>编辑显示设置
                        </span>
                      </a>
                    </li>
                  </ul>
                </div>
              </div>-->
            </div>
            <select>
              <option value=""></option>
              <option selected="1" value="lf">
                最新消息
              </option>
              <option value="app_2915120374">
                状态更新
              </option>
              <option value="pp">
                专页
              </option>
              <option value="app_10150110253435258">
                提问
              </option>
            </select>
          </div>
        </div>
        <div>
          <h2 class="uiHeaderTitle">
            <i class="uiHeaderImage  img  sp_7gl7wd  sx_efd21b"></i><s:if test="handle=='sns.publish.photo'">照片</s:if><s:else>动态</s:else>汇总
          </h2>
        </div>
      </div>
    </div>
  </div>
  <div data-referrer="pagelet_composer" id="pagelet_composer">
    <div id="u3mxyl_2"
      onclick="Bootloader.loadComponents(&quot;Composer&quot;, function() { JSCC.get(&#39;j4ec37b3f908df06889566482&#39;) });"
      class="uiComposer uiComposerHideContent stat_elem uiMetaComposer uiComposerTopBorder uiComposerOpen uiComposerHideContent uiComposerWhiteMessageBox">
      <div class="focus_target">
        <ul class="uiList uiListHorizontal clearfix uiComposerAttachments">
          <li class="uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
            <span data-endpoint="/ajax/metacomposer/attachment/status/status.php" id="composerTourStart"
              class="uiComposerAttachment statusAttachment uiComposerAttachmentSelected attachmentAcceptsLink">
              <a href="#" tabindex="0" class="uiIconText attachmentLink normal" onclick="changeStatus(this, 'status'); return false;">
                <i class="img sp_7gl7wd sx_bd619c"></i>
                <strong class="attachmentName">更新信息</strong>
              </a> 
              <span class="uiIconText">
                <i class="img sp_7gl7wd sx_bd619c"></i>
                <strong class="attachmentName">更新信息<i class="nub"></i></strong>
              </span>
            </span>
          </li>
          <li class="plm uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
            <span data-endpoint="/ajax/metacomposer/attachment/photo/photo.php" id="u3mxyl_4" class="uiComposerAttachment photoAttachment">
             <a href="#" tabindex="0" class="uiIconText attachmentLink normal" onclick="changeStatus(this, 'photo'); return false;">
              <i class="img sp_6h8b4g sx_282f2a"></i>
              <strong class="attachmentName">添加照片</strong>
             </a>
             <span class="uiIconText selected">
              <i class="img sp_6h8b4g sx_282f2a"></i>
              <strong class="attachmentName">添加照片<i class="nub"></i></strong>
             </span>
            </span>
          </li>
          <li class="plm uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
            <span id="u3mxyl_5" class="uiComposerAttachment">
              <a href="#" tabindex="0" class="uiIconText attachmentLink normal" onclick="changeStatus(this, 'question'); return false;">
                <i class="img sp_7gl7wd sx_97759f"></i>
                <strong class="attachmentName">提问</strong>
              </a>
              <span class="uiIconText selected">
                <i class="img sp_7gl7wd sx_97759f"></i>
                <strong class="attachmentName">提问<i class="nub"></i></strong>
              </span>
            </span>
          </li>
          <li class="showWhenLoading attachmentLoader plm uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
            <img height="11" width="16" alt="" src="images/GsNJNwuI-UM.gif" class="uiLoadingIndicatorAsync img" />
          </li>
        </ul>

        <div class="showWhenOpen mutableContent uiComposerMetaContainer">
          <s:form method="post" action="usr/feed!updateStatusAjax.jhtml" target="u3jjus_1" enctype="multipart/form-data">
            <input type="hidden" value="c0a81f7ab46455dde1e203435e599680" name="post_form_id" autocomplete="off" />
            <input type="hidden" name="feedtype" autocomplete="off" value="status" />
            <div class="attachmentFrame">
              <div class="attachmentContent"></div>
            </div>
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
                              <input type="hidden" class="hiddenInput" autocomplete="off" />
                              <div class="innerWrap">
                                <s:textarea name="feedmessage" placeholder="你在想什么？" onfocus="expandInput('u3mxyl_2')" 
                                  cssClass="DOMControl_placeholder uiTextareaAutogrow input mentionsTextarea textInput"></s:textarea>
                              </div>
                            </div>
                          </div>
                          <input type="hidden" class="mentionsHidden" autocomplete="off" />
                        </div>
                        <div class="attachmentMetaArea">
                          <div class="pbm webComposerPhotoUpload">
                            <input type="hidden" value="1324457070" name="qn" autocomplete="off"/>
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
                    <div class="pls textBlurb fsm fwn fcg"></div>
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
  
</s:else>
  
  	
  
  
  <iframe style="width: 1px; height: 1px; position: absolute; top: -10000px;" name="u3jjus_1" class="fbUploadIframe"></iframe>
  <div data-gt='{"ref":"nf"}' data-referrer="pagelet_home_stream" id="pagelet_home_stream">
    <div id="c4ec37b3fc7e022d58174072" class="UIIntentionalStream UIStream">
      <ul id="home_stream" class="uiList uiStream UIIntentionalStream_Content" data-referrer="home_stream" style="min-height: 100px;">
        <s:iterator value="feeds">
          <li id="stream_story_4ec37b3fd947b3232640247" data-ft='{"qid":"5675515467749930831","mf_story_key":"2652098748566","c":"m"}'
            class="pvm uiUnifiedStory uiStreamStory genericStreamStory aid_1438697558 uiListItem uiListLight uiListVerticalItemBorder">
            <div class="storyHighlightIndicatorWrapper"></div>
            <div class="storyContent">
              <div class="UIImageBlock clearfix">
                <a data-hovercard="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="user.userid"/>"
                  aria-hidden="true" data-ft='{"type":60}'
                  href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="user.userid"/>"
                  tabindex="-1"
                  class="actorPhoto UIImageBlock_Image UIImageBlock_MED_Image">
                  <img alt="" src="<s:property value="user.avatar"/>" class="uiProfilePhoto profilePic uiProfilePhotoLarge img" />
                </a>
                <div class="storyInnerContent UIImageBlock_Content UIImageBlock_MED_Content">
                  <div class="mainWrapper">
                    <h6 class="uiStreamMessage">
                      <div class="actorDescription actorName">
                        <a href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="user.userid"/>">
                          <s:property value="user.username" />
                        </a>
                         <s:if test="feed.handle=='sns.publish.text'">发布了评论</s:if>
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
                      </div>
                      <s:if test="feed.handle=='sns.publish.text'">
                        <span data-ft='{"type":3}' class="messageBody">
                          <s:property value="feed.body" />
                        </span>
                      </s:if>
                      
                       <s:if test="feed.handle=='sns.share.text'">
                        <span data-ft='{"type":3}' class="messageBody">
                          <s:property value="oldFeed.body" />
                        </span>
                      </s:if>

                      <s:if test="(feed.handle=='sns.event.create')||(feed.handle=='sns.event.join')">
                        <%@ include file="/WEB-INF/jsp/member/feed/eventfeed.jsp"%>
                      </s:if>
                      
                       <s:if test="(feed.handle=='sns.publish.photo'||feed.handle=='sns.share.photo')">
                        <%@ include file="/WEB-INF/jsp/member/feed/photofeed.jsp"%>
                      </s:if>
                    </h6>
                    
                    <s:form onsubmit="return commentSubmit(this);" action="usr/feed!addFeedComment.jhtml" method="post" cssClass="commentable_item autoexpand_mode collapsed_comments">
                      <input type="hidden" name="feedId" value="<s:property value='feed.id' />" />
                      <span class="uiStreamFooter">
                        <span class="UIActionLinks UIActionLinks_bottom">
                          <label class="uiLinkButton comment_link" title="发表留言">
                            <input type="button" value="评论" onclick="return showComments(this);">
                           
                          </label> · 
                        </span>
                        
                        <!--
                         <span class="UIActionLinks UIActionLinks_bottom">
                          <label class="uiLinkButton comment_link" title="分享">
                            <s:if test="(feed.handle=='sns.publish.photo'||feed.handle=='sns.publish.text')">
                              <input type="button" value="分享" onclick="return;">
                            </s:if >
                          </label> · 
                        </span>
                        --->
                        
                         <span class="UIActionLinks UIActionLinks_bottom">
                          <label class="uiLinkButton comment_link" title="分享">
                          	<s:if test="(feed.handle=='sns.publish.photo'||feed.handle=='sns.publish.text')">
                          	<a href="usr/feed!sharedFeed.jhtml?feedId=<s:property value="feed.id" />"><span class="fwn">分享</span> </a> 
                          	</s:if >
                          	<!--
                              <input type="button" value="分享" onclick="return;">
                             -->
                          </label> · 
                    			</span>
                        
                        <span class="uiStreamSource" data-ft="{&quot;type&quot;:26}">
                          <abbr title="<s:date name="feed.created" format="yyyy-MM-dd HH:mm" />"  class="timestamp livetimestamp">
                            <s:date name="feed.created" format="yyyy-MM-dd HH:mm" />
                          </abbr>
                        </span>
                      </span>
                      
                      <div>
                        <ul class="uiList uiUfi focus_target fbUfi">
                          <li class="ufiNub uiListItem uiListVerticalItemBorder"><i></i></li>
                          <li class="uiUfiComments uiListItem uiListVerticalItemBorder">
                            <ul class="commentList">
                            <s:iterator value="comments"> 
                              <li class="uiUfiComment comment_<s:property value='comment.id' /> ufiItem ufiItem uiUfiUnseenItem">
                                <div class="UIImageBlock clearfix uiUfiActorBlock">
                                  <a href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value="user.userid" />" tabindex="-1" class="actorPic UIImageBlock_Image UIImageBlock_SMALL_Image">
                                    <img alt="" src="<s:property value='user.avatar' />" class="uiProfilePhoto uiProfilePhotoMedium img"/>
                                  </a>
                                  <label for="u3ft9v_1" class="deleteAction stat_elem UIImageBlock_Ext uiCloseButton">
                                    <input type="button" id="u3ft9v_1" onclick="showDelCommentPop('dialog_delFeedCmt', <s:property value='comment.id' />)" title="删除"/>
                                  </label>
                                  <div class="commentContent UIImageBlock_Content UIImageBlock_SMALL_Content">
                                    <a href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value='user.userid' />" class="actorName"><s:property value="user.username" /></a>
                                    <span class="commentBody"><s:property value="comment.content" /></span>
                                    <div class="commentActions fsm fwn fcg">
                                      <abbr class="timestamp livetimestamp" title="<s:date name="comment.created" format="yyyy-MM-dd HH:mm" />"><s:date name="comment.created" format="yyyy-MM-dd HH:mm" />发布</abbr> 
                                    
                                    <!-- 
                                      <span class="comment_like_5136102 fsm fwn fcg">
                                        <button title="喜欢此评论" value="5136102" name="like_comment_id[5136102]" type="submit" class="stat_elem as_link cmnt_like_link">
                                          <span class="default_message">赞</span>
                                          <span class="saving_message">取消</span>
                                        </button>
                                      </span>
                                    -->
                                    
                                    </div>
                                  </div>
                                </div>
                              </li>
                              </s:iterator>
                            </ul>
                          </li>
                          <li class="uiUfiAddComment clearfix uiUfiSmall ufiItem ufiItem uiListItem uiListVerticalItemBorder uiUfiAddCommentCollapsed">
                            <div class="UIImageBlock clearfix mentionsAddComment">
                              <img alt="" src="<s:property value="#session.userlogo"/>" class="uiProfilePhoto actorPic UIImageBlock_Image UIImageBlock_ICON_Image uiProfilePhotoMedium img"/>
                              <div class="commentArea UIImageBlock_Content UIImageBlock_ICON_Content">
                                <div class="commentBox">
                                  <div id="u3aqpf_8" class="uiMentionsInput textBoxContainer">
                                    <div class="highlighter" style="direction: ltr; text-align: left;">
                                      <div style="width: 340px;"><span class="highlighterContent"/></div>
                                    </div>
                                    <div id="u3aqpf_9" class="uiTypeahead mentionsTypeahead" style="height: auto;">
                                      <div class="wrap">
                                        <input type="hidden" class="hiddenInput" autocomplete="off"/>
                                        <div class="innerWrap">
                                          <s:textarea name="feedComment" onfocus="commentFocus(this)" onkeypress="enterKeypress(this, event)" placeholder="留段话吧..." title="留段话吧..." cssClass="enter_submit uiTextareaNoResize uiTextareaAutogrow textBox mentionsTextarea textInput DOMControl_placeholder"></s:textarea>
                                        </div>
                                      </div>
                                      <div class="uiTypeaheadView hidden_elem"/>
                                    </div>
                                    <input type="hidden" class="mentionsHidden" autocomplete="off" name="add_comment_text" value=""/>
                                  </div>
                                </div>
                                <!--
                                <label for="u3aqpf_10" class="mts commentBtn stat_elem hidden_elem optimistic_submit uiButton uiButtonConfirm">
                                  <input type="submit" id="u3aqpf_10" name="commentBtn" class="enter_submit_target" value="评论"/>
                                </label>-->
                              </div>
                            </div>
                          </li>
                        </ul>
                      </div>
                    </s:form>
                    
                  </div>
                </div>
              </div>
            </div>
          </li>
        </s:iterator>
      </ul>

      <div>
      	
        <div id="pagelet_stream_pager"
          data-referrer="pagelet_stream_pager">
          
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

  function changeStatus(obj, feedtype) {
    $("#input[name='feedtype']").val(feedtype);
    $("#u3mxyl_2").find("div:first").addClass("child_was_focused");
    if (feedtype == "photo") {
      $(".attachmentMetaArea").html(attach);
      $("#submitBtn").parent().addClass("uiButtonDisabled");
      $("textarea[name='feedmessage']").attr("placeholder", "说点什么吧!");
      $("textarea[name='feedmessage']").val("说点什么吧!");

    } else if(feedtype == "question") {
      $("textarea[name='feedmessage']").attr("placeholder", "提个问题试试!");
      $("textarea[name='feedmessage']").val("提个问题试试!");
      $(".attachmentMetaArea").empty();
      $("#submitBtn").parent().removeClass("uiButtonDisabled");
    } else {
      $("textarea[name='feedmessage']").attr("placeholder", "你在想什么？");
      $("textarea[name='feedmessage']").val("你在想什么？");
      $(".attachmentMetaArea").empty();
      $("#submitBtn").parent().removeClass("uiButtonDisabled");
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
    }
  }
  
  function enableSubmitBtn() {
    $("#submitBtn").parent().removeClass("uiButtonDisabled");
  }
  
  // show comment
  function showComments(obj) {
    $(obj).parents("form").removeClass("collapsed_comments");
    $(obj).parents("ul").addClass("child_was_focused");
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
    });
    return false;
  }
  
  function topage(pageNo) {
  location.href = "/usr/feed.jhtml?handle=<s:property value="handle" />&pageNo="+pageNo
  return false;
}
</script>

<%@ include file="/WEB-INF/jsp/popup/delFeedCommentPop.jsp"%>