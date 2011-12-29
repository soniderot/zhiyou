<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>

<div id="contentArea" role="main">
    <div class="mbl" id="event_info_pagelet" data-referrer="event_info_pagelet">
      <table class="uiInfoTable mvm profileInfoTable">
        <tbody>
          <tr>
            <th class="label">时间</th>
            <td class="data">
              <div> 
                <span class="dtstart">
                  <span class="value-title" title=""> </span>
                  <s:date name="event.begintime" format="yyyy-MM-dd HH:mm" />
                </span> - 
                <span class="dtend">
                  <span class="value-title" title=""> </span>
                  <s:date name="event.endtime" format="yyyy-MM-dd HH:mm" />
                </span>
              </div>
            </td>
          </tr>
          <tr class="spacer">
            <td colspan="2"><hr></td>
          </tr>
        </tbody>
        <tbody>
          <tr>
            <th class="label">位置</th>
            <td class="data">
              <div class="location vcard">
                <span class="fn org"> <s:property value="event.address" /></span>
                <div class="adr"></div>
              </div>
            </td>
          </tr>
          <tr class="spacer">
            <td colspan="2"><hr></td>
          </tr>
        </tbody>
        
        <tbody>
          <tr>
            <th class="label">详细信息</th>
            <td class="data">
              <div class="location vcard">
                <span class="fn org"> <s:property value="event.detail" /></span>
                <div class="adr"></div>
              </div>
            </td>
          </tr>
          <tr class="spacer">
            <td colspan="2"><hr></td>
          </tr>
        </tbody>
        
        <tbody>
          <tr>
            <th class="label">创建人</th>
            <td class="data">
              <div class="uiCollapsedList uiCollapsedListHidden organizer" id="u4yt3n_2">
                <span class="visible">
                  <a href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value="createUser.userid" />" > <s:property value="createUser.username" /></a>
                </span>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    
    <s:if test="feed.handle=='sns.event.create'">
    <div id="pagelet_event_wall" data-referrer="pagelet_event_wall">
      <div id="event_profile_wall" class="eventsWhiteComposer">
        <div id="feedwall_with_composer">
          <div class="pbm">
            <div class="uiComposer uiComposerHideContent stat_elem fbEventComposer uiComposerOpen uiComposerHideContent uiComposerWhiteMessageBox" onclick="Bootloader.loadComponents(&quot;Composer&quot;, function() { JSCC.get('j4ec9f957e971500439141666') });" id="u4yt3n_8">
              <div class="focus_target">
                <form rel="async" class="attachmentSelectForm" action="/" method="get" onsubmit="return Event.__inlineSubmit(this,event)">
                  <ul class="uiList uiListHorizontal clearfix uiComposerAttachments" onclick="var el = (event.target || event.srcElement), a = Parent.byClass(el, &quot;uiComposerAttachment&quot;); if (!a) { return; } var b = window.DOM &amp;&amp; DOM.find(a, &quot;a&quot;), f = Parent.byTag(a,&quot;form&quot;); f.action = a.getAttribute(&quot;data-endpoint&quot;); b &amp;&amp; f.setAttribute(&quot;data-gt&quot;, b.getAttribute(&quot;data-gt&quot;)); f.xhpc.value = a.id; f.xhpc.click();">
                    <li class="uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
                      <span class="fsm fwb fcg">分享：</span>
                    </li>
                    <li class="plm uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
                      <span class="uiComposerAttachment postAttachment uiComposerAttachmentSelected" id="u4yt3n_9" data-endpoint="/ajax/composer/attachment/wallpost/wallpost.php">
                        <a class="uiIconText attachmentLink normal" tabindex="0" href="#">
                          <i class="img sp_6h8b4g sx_052e77"></i>
                          <strong class="attachmentName">留言</strong>
                        </a>
                        <span class="uiIconText selected">
                          <i class="img sp_6h8b4g sx_052e77"></i>
                          <strong class="attachmentName">留言<i class="nub"></i></strong>
                        </span>
                      </span>
                    </li>
                    <li class="plm uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
                      <span class="uiComposerAttachment linkAttachment" id="u4yt3n_11" data-endpoint="/ajax/composer/attachment/link/link.php">
                        <a class="uiIconText attachmentLink normal" tabindex="0" href="#">
                          <i class="img sp_6h8b4g sx_36fd74" style="top: -1px;"></i>
                          <strong class="attachmentName">链接</strong>
                        </a>
                        <span class="uiIconText selected">
                          <i class="img sp_6h8b4g sx_36fd74" style="top: -1px;"></i>
                          <strong class="attachmentName">链接<i class="nub"></i></strong>
                        </span>
                      </span>
                    </li>
                    <li class="plm uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
                      <span class="uiComposerAttachment photoAttachment" id="u4yt3n_12" data-endpoint="/ajax/composer/attachment/photo/photo.php">
                        <a class="uiIconText attachmentLink normal" tabindex="0" href="#">
                          <i class="img sp_6h8b4g sx_282f2a"></i>
                          <strong class="attachmentName">照片</strong>
                        </a>
                        <span class="uiIconText selected">
                          <i class="img sp_6h8b4g sx_282f2a"></i>
                          <strong class="attachmentName">照片<i class="nub"></i></strong>
                          <i class="nub"></i>
                        </span>
                        <i class="nub"></i>
                      </span>
                      <i class="nub"></i>
                    </li>
                    <i class="nub">
                      <li class="showWhenLoading attachmentLoader plm uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
                        <img width="16" height="11" class="img" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" alt="" />
                      </li>
                    </i>
                  </ul>
                  <i class="nub">
                    <input type="hidden" autocomplete="off" name="targetid" value="241236155939386">
                    <input type="submit" class="hidden_elem" name="xhpc">
                
                    <div class="showWhenOpen mutableContent">
                      <form rel="async" class="attachmentForm" action="/ajax/updatestatus.php" method="post" onsubmit="return Event.__inlineSubmit(this,event)">
                        <input type="hidden" autocomplete="off" name="post_form_id" value="6e216452824f44ec542d34fca1ae8f75">
                        <input type="hidden" name="fb_dtsg" value="AQAlLjK8" autocomplete="off">
                        <div class="pas attachmentFrame">
                          <div class="attachmentContent"></div>
                        </div>
                        <div class="uiComposerMessageBox uiComposerMessageBoxMentions">
                          <div class="pas inputContainer">
                            <div class="uiMentionsInput" id="u4yt3n_10">
                              <div class="highlighter">
                                <div>
                                  <span class="highlighterContent"></span>
                                </div>
                              </div>
                              <div class="uiTypeahead composerTypeahead mentionsTypeahead" id="u4yt3n_14">
                                <div class="wrap">
                                  <input type="hidden" autocomplete="off" class="hiddenInput">
                                  <div class="innerWrap">
                                    <textarea class="DOMControl_placeholder uiTextareaAutogrow input mentionsTextarea textInput" title="写点什么吧..." name="xhpc_message" placeholder="写点什么吧..." onfocus="return wait_for_load(this, event, function() {if (!this._has_control) {  new TextAreaControl(this).setAutogrow(true);  this._has_control = true; } return wait_for_load(this, event, function() {;JSCC.get('j4ec9f957e971500439141668').init([&quot;buildBestAvailableNames&quot;,&quot;hoistFriends&quot;]);JSCC.get('j4ec9f957e971500439141667').init({&quot;max&quot;:10}, null);;;});});" autocomplete="off">写点什么吧...</textarea>
                                  </div>
                                </div>
                              </div>
                              <input type="hidden" autocomplete="off" class="mentionsHidden" />
                            </div>
                          </div>
                          <div class="clearfix showOnceInteracted uiComposerMessageBoxControls">
                            <ul class="uiList uiListHorizontal clearfix rfloat">
                              <li class="privacyWidget hidden_elem uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
                                <div id="pagelet_privacy_widget" data-referrer="pagelet_privacy_widget"></div>
                              </li>
                              <li class="pls uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
                                <label class="submitBtn uiButton uiButtonConfirm uiButtonLarge" for="u4yt3n_15">
                                  <input type="submit" value="分享" id="u4yt3n_15" />
                                </label>
                              </li>
                            </ul>
                            <div>
                              <div class="textBlurb fsm fwn fcg"></div>
                            </div>
                          </div>
                        </div>
                      </form>
                    </div>
                  </i>
                </form>
              </div>
              <i class="nub"></i>
            </div>
            <i class="nub">
              <div class="UIIntentionalStream UIStream" id="c4ec9f958166056f08014909">
                <ul class="uiList uiStream UIIntentionalStream_Content" id="home_stream">
                  <li class="pvm uiUnifiedStory uiStreamStory genericStreamStory aid_1438697558 uiListItem uiListLight uiListVerticalItemBorder" data-ft="{&quot;src&quot;:9,&quot;sty&quot;:100,&quot;actrs&quot;:&quot;1438697558&quot;,&quot;targets&quot;:&quot;241236155939386&quot;,&quot;pub_time&quot;:1321856140,&quot;fbid&quot;:&quot;241237019272633&quot;,&quot;s_obj&quot;:26,&quot;s_edge&quot;:1,&quot;s_prnt&quot;:1,&quot;ft_story_name&quot;:&quot;StreamStoryCreateGeneric_WallPostStreamContent&quot;,&quot;mf_objid&quot;:1438697558,&quot;object_id&quot;:&quot;241236155939386&quot;}" id="stream_story_4ec9f95812f717b44498289">
                    <div class="storyHighlightIndicatorWrapper"></div>
                    <div class="storyContent">
                      <div class="UIImageBlock clearfix">
                        <a class="actorPhoto UIImageBlock_Image UIImageBlock_MED_Image" tabindex="-1" href="http://www.facebook.com/mkk158" data-ft="{&quot;type&quot;:60}" aria-hidden="true" data-hovercard="/ajax/hovercard/hovercard.php?id=1438697558">
                          <img class="uiProfilePhoto profilePic uiProfilePhotoLarge img" src="http://profile.ak.fbcdn.net/hprofile-ak-ash2/370142_1438697558_1584603112_q.jpg" alt="">
                        </a>
                        <div class="storyInnerContent UIImageBlock_Content UIImageBlock_MED_Content">
                          <div class="mainWrapper">
                            <a class="mlm uiTooltip uiStreamHide uiCloseButton" onmouseout="this.blur();" rel="async-post" href="#" ajaxify="/ajax/minifeed.php?dialog=1&amp;ministory_key=2566998&amp;profile_fbid=241236155939386&amp;story_type=100&amp;feedback=1&amp;action_key=remove_content&amp;story_fbids%5B0%5D=241236155939386%3A241237019272633&amp;story_id=stream_story_4ec9f95812f717b44498289">
                              <span class="uiTooltipWrap top right righttop">
                                <span class="uiTooltipText">删除帖子</span>
                              </span>
                            </a>
                            <h6 class="uiStreamMessage" data-ft="{&quot;type&quot;:1}">
                              <div class="actorDescription actorName" data-ft="{&quot;type&quot;:2}">
                                <a href="http://www.facebook.com/mkk158" data-hovercard="/ajax/hovercard/user.php?id=1438697558">ま か</a>
                              </div>
                              <span class="messageBody" data-ft="{&quot;type&quot;:3}">lets go</span>
                            </h6>
                            <form rel="async" class="commentable_item collapsed_comments autoexpand_mode" method="post" action="/ajax/ufi/modify.php" onsubmit="return Event.__inlineSubmit(this,event)">
                              <input type="hidden" name="charset_test" value="€,′,€,′,水,Д,?">
                              <input type="hidden" autocomplete="off" name="post_form_id" value="6e216452824f44ec542d34fca1ae8f75">
                              <input type="hidden" name="fb_dtsg" value="AQAlLjK8" autocomplete="off">
                              <input type="hidden" autocomplete="off" name="feedback_params" value="{&quot;actor&quot;:&quot;1438697558&quot;,&quot;target_fbid&quot;:&quot;241237019272633&quot;,&quot;target_profile_id&quot;:&quot;241236155939386&quot;,&quot;type_id&quot;:&quot;100&quot;,&quot;source&quot;:&quot;0&quot;,&quot;assoc_obj_id&quot;:&quot;241236155939386&quot;,&quot;source_app_id&quot;:&quot;&quot;,&quot;extra_story_params&quot;:[],&quot;content_timestamp&quot;:&quot;1321856140&quot;,&quot;check_hash&quot;:&quot;4b4851704fbf0c78&quot;}">
                              <span class="uiStreamFooter">
                                <span class="UIActionLinks UIActionLinks_bottom" data-ft="{&quot;type&quot;:&quot;20&quot;}">
                                  <button class="like_link stat_elem as_link" title="喜欢这个" type="submit" name="like" onclick="fc_click(this, false); return true;" data-ft="{&quot;type&quot;:22}">
                                    <span class="default_message">赞</span>
                                    <span class="saving_message">取消</span>
                                  </button> · 
                                  <label class="uiLinkButton comment_link" title="发表留言">
                                    <input type="button" data-ft="{&quot;type&quot;:24}" value="评论" onclick="return fc_click(this);">
                                  </label> · 
                                </span>
                                <span class="uiStreamSource" data-ft="{&quot;type&quot;:26}">
                                  <a href="/permalink.php?story_fbid=241237019272633&amp;id=241236155939386">
                                    <abbr title="2011年11月21日14:15" data-date="Sun, 20 Nov 2011 22:15:40 -0800" class="timestamp livetimestamp">54分钟前发布</abbr>
                                  </a>
                                </span>
                              </span>
                              <ul class="uiList uiUfi focus_target fbUfi" data-ft="{&quot;type&quot;:30}">
                                <li class="ufiNub uiListItem uiListVerticalItemBorder"><i></i></li>
                                <li class="hidden_elem uiUfiLike uiListItem uiListVerticalItemBorder" data-ft="{&quot;type&quot;:31}"></li>
                                <li class="translateable_info uiListItem uiListVerticalItemBorder">
                                  <input type="hidden" autocomplete="off" name="translate_on_load" value="">
                                </li>
                                <li class="uiUfiComments uiListItem uiListVerticalItemBorder hidden_elem" data-ft="{&quot;type&quot;:32}">
                                  <ul class="commentList"></ul>
                                </li>
                                <li class="uiUfiAddComment clearfix uiUfiSmall ufiItem ufiItem uiListItem uiListVerticalItemBorder uiUfiAddCommentCollapsed">
                                  <div class="UIImageBlock clearfix mentionsAddComment">
                                    <img class="uiProfilePhoto actorPic UIImageBlock_Image UIImageBlock_ICON_Image uiProfilePhotoMedium img" src="http://profile.ak.fbcdn.net/hprofile-ak-ash2/370142_1438697558_1584603112_q.jpg" alt="">
                                    <div class="commentArea UIImageBlock_Content UIImageBlock_ICON_Content">
                                      <div class="commentBox">
                                        <div class="uiMentionsInput textBoxContainer" id="u4yt3n_5">
                                          <div class="highlighter">
                                            <div>
                                              <span class="highlighterContent"></span>
                                            </div>
                                          </div>
                                          <div class="uiTypeahead mentionsTypeahead" id="u4yt3n_6">
                                            <div class="wrap">
                                              <input type="hidden" autocomplete="off" class="hiddenInput">
                                              <div class="innerWrap">
                                                <textarea class="enter_submit DOMControl_placeholder uiTextareaNoResize uiTextareaAutogrow textBox mentionsTextarea textInput" title="留段话吧..." placeholder="留段话吧..." name="add_comment_text" onfocus="return wait_for_load(this, event, function() {if (!this._has_control) {  new TextAreaControl(this).setAutogrow(true);  this._has_control = true; } return wait_for_load(this, event, function() {;JSCC.get('j4ec9f957e971500439141664').init([&quot;buildBestAvailableNames&quot;,&quot;hoistFriends&quot;]);JSCC.get('j4ec9f957e971500439141662').init({&quot;max&quot;:10}, null);;;});});" autocomplete="off">留段话吧...</textarea>
                                              </div>
                                            </div>
                                          </div>
                                          <input type="hidden" autocomplete="off" class="mentionsHidden">
                                        </div>
                                        <div class="uiUfiAddTip sendOnEnterTip fss fcg">按回车键（Enter）发表评论。</div>
                                      </div>
                                      <label class="mts commentBtn stat_elem hidden_elem optimistic_submit uiButton uiButtonConfirm" for="u4yt3n_7">
                                        <input type="submit" value="评论" class="enter_submit_target" name="comment" id="u4yt3n_7">
                                      </label>
                                    </div>
                                  </div>
                                </li>
                              </ul>
                              <input type="hidden" value="{&quot;src&quot;:9,&quot;sty&quot;:100,&quot;actrs&quot;:&quot;1438697558&quot;,&quot;targets&quot;:&quot;241236155939386&quot;,&quot;pub_time&quot;:1321856140,&quot;fbid&quot;:&quot;241237019272633&quot;,&quot;s_obj&quot;:26,&quot;s_edge&quot;:1,&quot;s_prnt&quot;:1,&quot;ft_story_name&quot;:&quot;StreamStoryCreateGeneric_WallPostStreamContent&quot;,&quot;mf_objid&quot;:1438697558,&quot;object_id&quot;:&quot;241236155939386&quot;}" name="link_data">
                            </form>
                          </div>
                        </div>
                      </div>
                    </div>
                  </li>
                </ul>
                <div>
                  <div class="UIIntentionalStream_Error">
                    <div class="pam uiBoxRed">
                      <div class="fsl fwb fcb">该动态流目前无法显示，请稍后再试一次。</div>
                    </div>
                  </div>
                </div>
              </div>
              <div id="pagelet_events_pager_wrapper"></div>
            </i>
          </div>
          <i class="nub"></i>
        </div>
        <i class="nub"></i>
      </div>
      <i class="nub"></i>
    </div>
    </s:if>
  
    <i class="nub">
    <div id="bottomContent"></div>
    </i>
  </div>