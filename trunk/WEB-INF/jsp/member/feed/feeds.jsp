<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<div role="main" id="contentArea">
  <div data-referrer="pagelet_roosters" id="pagelet_roosters"></div>
  <div data-referrer="pagelet_stream_header" id="pagelet_stream_header">
    <div
      class="uiHeader uiHeaderWithImage uiHeaderPage  fbx_stream_header">
      <div class="clearfix uiHeaderTop">
        <div class="uiHeaderActions  rfloat fsl fwb fcb">
          <a href="/?sk=h"><span class="fwn">热门消息</span> </a> ·
          <div id="u3mxyl_1"
            class="uiSelector inlineBlock filterListSelector  uiSelectorRight  uiSelectorNormal uiSelectorDynamicLabel">
            <div class="wrap">
              <a rel="toggle" data-length="30" aria-haspopup="1"
                href="#" role="button"
                class="uiSelectorButton  uiButton"> <span
                class="uiButtonText">最新消息</span> </a>
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
                    <li data-label="专页"
                      class="uiMenuItem  uiMenuItemRadio  uiSelectorOption">
                      <a href="/?sk=pp" aria-checked="false"
                        tabindex="-1" role="menuitemradio"
                        class="itemAnchor"> <span
                        class="itemLabel fsm"> <i
                          class="mrs  img  sp_6h8b4g  sx_6bbf39"></i>专页
                      </span> </a>
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
              </div>
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
            <i class="uiHeaderImage  img  sp_7gl7wd  sx_efd21b"></i>动态汇总
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
        <form onsubmit="return updateStatus(this)" method="get" action="/" class="attachmentSelectForm"
          rel="async">
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
              <span data-endpoint="/ajax/metacomposer/attachment/question/question.php?create_eigenpoll=1&amp;source=composer" id="u3mxyl_5" class="uiComposerAttachment">
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
              <img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="uiLoadingIndicatorAsync img" />
            </li>
          </ul>
          <input type="hidden" value="1438697558" name="targetid" autocomplete="off" />
          <input type="submit" name="xhpc" class="hidden_elem" />
        </form>
        <div class="showWhenOpen mutableContent uiComposerMetaContainer">
          <s:form onsubmit="return updateStatus(this)" method="post" action="usr/feed!updateStatusAjax.jhtml" target="u3jjus_1" enctype="multipart/form-data">
            <input type="hidden" value="c0a81f7ab46455dde1e203435e599680" name="post_form_id" autocomplete="off" />
            <input type="hidden" name="feedtype" autocomplete="off" />
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
                                <textarea onfocus="expandInput('u3mxyl_2')" placeholder="你在想什么？"  name="feedmessage" title="你在想什么？"
                                  class="DOMControl_placeholder uiTextareaAutogrow input mentionsTextarea textInput"></textarea>
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
  <iframe style="width: 1px; height: 1px; position: absolute; top: -10000px;" name="u3jjus_1" class="fbUploadIframe"></iframe>
  <div data-gt='{"ref":"nf"}' data-referrer="pagelet_home_stream" id="pagelet_home_stream">
    <div id="c4ec37b3fc7e022d58174072" class="UIIntentionalStream UIStream">
      <ul id="home_stream" class="uiList uiStream UIIntentionalStream_Content" data-referrer="home_stream" style="min-height: 100px;">
        <s:iterator value="feeds">
          <li id="stream_story_4ec37b3fd947b3232640247"
            data-ft='{"qid":"5675515467749930831","mf_story_key":"2652098748566","c":"m"}'
            class="pvm uiUnifiedStory uiStreamStory genericStreamStory aid_1438697558 uiListItem uiListLight uiListVerticalItemBorder">
            <div class="storyHighlightIndicatorWrapper"></div>
            <div class="storyContent">
              <div class="UIImageBlock clearfix">
                <a
                  data-hovercard="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="user.userid"/>"
                  aria-hidden="true" data-ft='{"type":60}'
                  href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="user.userid"/>"
                  tabindex="-1"
                  class="actorPhoto UIImageBlock_Image UIImageBlock_MED_Image">
                  <img alt="" src="<s:property value="user.avatar"/>" class="uiProfilePhoto profilePic uiProfilePhotoLarge img" />
                </a>
                <div
                  class="storyInnerContent UIImageBlock_Content UIImageBlock_MED_Content">
                  <div class="mainWrapper">
                    <h6 data-ft='{"type":1}' class="uiStreamMessage">
                      <div data-ft='{"type":2}' class="actorDescription actorName">
                        <a data-hovercard="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="user.userid"/>" href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="user.userid"/>">
                          <s:property value="user.username" />
                        </a>
                        
                        <s:if test="feed.handle=='sns.event.create'">创建了一个活动</s:if>
                        
                        <s:if test="feed.handle=='sns.share.connection'">   
                                                  和<a href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="friend.userid"/>">
                            <s:property value="friend.username" />
                          </a>变为朋友
                        </s:if>
                      </div>
                      <s:if test="feed.handle=='sns.publish.text'">
                        <span data-ft='{"type":3}' class="messageBody">
                          <s:property value="feed.body" />
                        </span>
                      </s:if>

                      <s:if test="feed.handle=='sns.event.create'">
                        <%@ include file="/WEB-INF/jsp/member/feed/eventfeed.jsp"%>
                      </s:if>
                    </h6>
                    <span class="uiStreamFooter">
                      <span class="UIActionLinks UIActionLinks_bottom" data-ft="{&quot;type&quot;:&quot;20&quot;}">
                        <label class="uiLinkButton comment_link" title="发表留言">
                          <input type="button" data-ft="{&quot;type&quot;:24}" value="评论" onclick="return fc_click(this);">
                        </label> · 
                      </span>
                      <span class="uiStreamSource" data-ft="{&quot;type&quot;:26}">
                        <abbr title="<s:date name="feed.created" format="yyyy-MM-dd HH:mm" />"  class="timestamp livetimestamp">
                          <s:date name="feed.created" format="yyyy-MM-dd HH:mm" />
                        </abbr>
                      </span>
                    </span>
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
            <a href="/ajax/feed/edit_options_dialog.php?filter_key=lf"
              rel="dialog" class="uiMorePagerSecondary rfloat">编辑选项</a>
            <div>
              <div class="pam uiBoxLightblue uiMorePagerPrimary">
                目前没有更多动态可显示。
              </div>
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
    } else {
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
  
  function updateStatus(form) {
    $(form).submit();
  }
  
  function updateCallback(data) {
    $("#home_stream").prepend(data);
    $("#submitBtn").parent().addClass("uiButtonDisabled");
  }
  
  function enableSubmitBtn() {
    $("#submitBtn").parent().removeClass("uiButtonDisabled");
  }
</script>