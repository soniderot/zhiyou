<%@page pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<div class="fbPhotoSnowlift fbxPhoto pagingReady" id="fbPhotoSnowlift">
  <div class="fbPhotoSnowliftOuter">
    <div class="fbPhotoSnowliftInner">
      <div class="fbPhotoSnowliftContainer uiContextualLayerParent">
        <div class="fbPhotoSnowliftBorder">
          <div class="clearfix fbPhotoSnowliftPopup" style="width: 860px; height: 520px;">
            <div class="stageWrapper lfloat" style="width: 520px; line-height: 43.3333em;">
              <div class="stage">
                <img class="spotlight" alt="" src="<s:property value='feedBean.photo.bigfilename'/>"/>
                <div id="fbPhotoSnowliftTagBoxes" class="fbPhotosPhotoTagboxes tagContainer">
                  <div class="tagsWrapper"></div>
                </div>
                <div id="fbPhotoSnowliftTagApproval" class="fbPhotoTagApproval hidden_elem"></div>
                <div class="fbPhotoSnowliftDivider"></div>
              </div>
              <div class="videoStage"></div>
              <!-- 
              <div id="snowliftStageActions" class="stageActions">
                <div class="clearfix snowliftOverlayBar">
                  <div id="fbPhotoSnowliftButtons" class="fbPhotosPhotoButtons lfloat">
                    <div class="uiInlineBlock uiInlineBlockMiddle bottomButtonsBar">
                      <a class="buttonLink fbPhotosPhotoLike clearfix">
                        <span class="uiIconText" style="padding-left: 18px;">
                          <img height="14" width="13" style="top: 0px;" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/ym/r/Y2WW7fFlqfj.png" class="img"/>
                          <span class="like">赞</span>
                          <span class="unlike">取消赞</span>
                        </span>
                      </a>
                      <a class="buttonLink fbPhotosPhotoActionsTag tagButton clearfix">
                        <span class="uiIconText" style="padding-left: 16px;">
                          <img height="15" width="11" style="top: -1px;" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yT/r/__Jo7MRgxrQ.png" class="img"/>圈照片
                        </span>
                      </a>
                    </div>
                    <div class="tagMessage">点击照片中的人物开始标记。 <a href="#" class="fbPhotosPhotoActionsTag doneTaggingLink">标记完成</a></div>
                  </div>
                  <div class="clearfix mediaTitleInfo">
                    <div class="rfloat">
                      <span id="fbPhotoSnowliftPositionAndCount"><span class="mhs">—</span>5 张中的第 2 张</span>
                    </div>
                    <div id="fbPhotoSnowliftMediaTitle">
                      <span class="fbPhotoMediaTitle">
                        <a href="http://www.facebook.com/media/set/?set=a.2897209396179.2151094.1438697558&amp;type=1">涂鸦墙照片</a>
                      </span>
                    </div>
                  </div>
                </div>
                <div style="" class="fbPhotosPhotoTagboxBase newTagBox hidden_elem">
                  <div class="borderTagBox">
                    <div class="innerTagBox">
                      <div class="ieContentFix">    </div>
                    </div>
                  </div>
                  <div class="tag">
                    <div class="tagPointer">
                      <i class="tagArrow img sp_be31r1 sx_661780"></i>
                      <div class="tagName"></div>
                    </div>
                  </div>
                </div>
                <div id="ueuh9a_23" class="fbPhotoTagger hidden_elem snowliftTagger">
                  <div class="faceBox">
                    <div class="typeaheadWrapper">
                      <div class="typeaheadContainer">
                        <div class="arrow">
                          <div class="nub"></div>
                        </div>
                        <div class="typeaheadBackdrop">
                          <div class="mbs typeaheadLabel">输入任意姓氏来标记：</div>
                          <div id="ueuh9a_22" class="clearfix uiTokenizer uiNormalTokenizer photoTagTokenizer">
                            <div id="ueuh9a_24" class="uiTypeahead photoTagTypeahead">
                              <div class="wrap">
                                <input type="hidden" class="hiddenInput" autocomplete="off"/>
                                <div class="innerWrap">
                                  <div class="uiStickyPlaceholderInput uiStickyPlaceholderEmptyInput">
                                    <div class="placeholder">键入任意姓名。</div>
                                    <input type="text" title="键入任意姓名。" value="键入任意姓名。" id="ueuh9a_25" spellcheck="false" onfocus="return wait_for_load(this, event, function() {JSCC.get(&#39;j4f3f670e6efa153439746389&#39;).init(JSCC.get(&#39;j4f3f670e6efa153439746387&#39;));;JSCC.get(&#39;j4f3f670e6efa153439746387&#39;).init([&quot;hoistFriends&quot;,&quot;hintText&quot;]);;});" autocomplete="off" placeholder="" name="user_name" class="inputtext textInput"/>
                                  </div>
                                </div>
                              </div>
                              <div class="uiTypeaheadView"></div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              
              <a title="上一页" href="#" class="snowliftPager prev hilightPager"><i></i></a>
              <a title="下一页" href="#" class="snowliftPager next"><i></i></a>
               -->
              <div id="fbPhotoSnowliftError" class="photoError stageError hidden_elem"></div>
            </div>
            <div class="rhc photoUfiContainer">
              <div class="rhcHeader">
                <div class="fbPhotoSnowliftControls">
                  <a href="javascript:void(0)" onclick="removeBigPhoto()" class="closeTheater" title=""></a>
                </div>
                
              </div>
              <form onsubmit="return commentSubmit(this);" action="usr/feed!addFeedComment.jhtml"" method="post" class="fbPhotosSnowliftFeedbackForm rhcBody commentable_item autoexpand_mode" rel="async" style="padding-bottom: 41px;">
                <input type="hidden"  name="feedId" value="<s:property value='feedBean.feed.id' />" />
                <div style="width: 285px; height: auto;" class="uiScrollableArea rhcScroller fade">
                  <div class="uiScrollableAreaWrap scrollable">
                    <div class="uiScrollableAreaBody" style="width: 340px;">
                      <div class="uiScrollableAreaContent">
                        <div class="clearfix fbPhotoSnowliftAuthorInfo">
                          <div id="fbPhotoSnowliftAuthorPic" class="lfloat">
                            <a href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value='feedBean.user.userid'/>"">
                              <img alt="" src="<s:property value='feedBean.user.avatar'/>" class="uiProfilePhoto uiProfilePhotoLarge img"/>
                            </a>
                          </div>
                          <div>
                            <div id="fbPhotoSnowliftAuthorName" class="fbPhotoContributorName">
                              <a href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value='feedBean.user.userid'/>"><s:property value='feedBean.user.username'/></a>
                            </div>
                            <div class="mrs fsm fwn fcg">
                              <span id="fbPhotoSnowliftTimestamp">
                                <abbr title="<s:date name="feedBean.feed.created" format="yyyy年MM月dd日 HH:mm" />"><s:date name="feedBean.feed.created" format="MM月dd日" /></abbr>
                              </span>
                            </div>
                            <div class="fsm fwn fcg">
                              <div id="fbPhotoSnowliftOnProfile" class="fbPhotosOnProfile"></div>
                            </div>
                          </div>
                        </div>
                        <div id="fbPhotoSnowliftCaption" class="fbPhotosPhotoCaption">
                          <span class="hasCaption"><br/>
                          <s:property value='feedBean.feed.shareReason'/></span>
                        </div>
                        <div id="fbPhotoSnowliftTagList" class="fbPhotoTagList hidden_elem"></div>
                        <div id="fbPhotoSnowliftPagesTagList" class="fbPhotoPagesTagList"></div>
                        <div id="fbPhotoSnowliftLegacyTagList" class="pts fbPhotoLegacyTagList">
                          <div></div>
                        </div>
                        
                        <div id="fbPhotoSnowliftFeedback" class="fbPhotosSnowliftFeedback">
                          <div id="fbPhotoUndoSpamReport"></div>
                          <div class="fbPhotoSnowliftActionLinks">
                            <span class="UIActionLinks UIActionLinks_bottom">
                            <label title="发表留言" class="uiLinkButton comment_link">
                            <input type="button" onclick="replyFocus('feedComment')" value="回复" />
                            </label>
                            · <a href="usr/feed!sharedFeed.jhtml?feedId=<s:property value="feedBean.feed.id" />" onclick="return showShareReasonInput(this);" rel="dialog">分享</a>
                            </span>
                          </div>
                          <ul class="uiList uiUfi focus_target fbUfi fbPhotosSnowliftUfi">
                            <li class="ufiNub uiListItem uiListVerticalItemBorder"><i></i></li>
                            <li class="hidden_elem uiUfiLike uiListItem uiListVerticalItemBorder"></li>
                            <li class="uiUfiViewReposts ufiItem uiListItem uiListVerticalItemBorder">
                              <!-- <span class="stat_elem">
                                <a href="/shares/view?id=3208743944348" rel="async" class="uiIconText uiUfiViewSharesLink">
                                  <i class="img sp_be31r1 sx_2d5461"></i>被转载分享了 1 次
                                </a>
                              </span> -->
                            </li>
                            <li class="translateable_info hidden_elem uiListItem uiListVerticalItemBorder">
                              <input type="hidden" value="" name="translate_on_load" autocomplete="off"/>
                            </li>
                            <li class="uiUfiComments uiListItem uiListVerticalItemBorder">
                              <ul class="commentList">
                                <s:iterator value="feedBean.comments">
                                <li class="uiUfiComment comment_<s:property value="comment.id" />  ufiItem ufiItem uiUfiUnseenItem">
                                  <div class="UIImageBlock clearfix uiUfiActorBlock">
                                    <a href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value="user.userid" />" class="actorPic UIImageBlock_Image UIImageBlock_SMALL_Image">
                                      <img alt="" src="<s:property value='user.avatar' />" class="uiProfilePhoto uiProfilePhotoMedium img"/>
                                    </a>
                                    <label for="uexpq3_1" class="deleteAction stat_elem UIImageBlock_Ext uiCloseButton">
                                    <input type="button" onclick="showDelCommentPop('dialog_delFeedCmt', <s:property value='comment.id' />)" title="删除"/>
                                    </label>
                                    <div class="commentContent UIImageBlock_Content UIImageBlock_SMALL_Content">
                                      <a href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value='user.userid' />" class="actorName"><s:property value="user.username" /></a>
                                      <span class="commentBody"><s:property value="comment.content" /></span>
                                      <div class="commentActions fsm fwn fcg">
                                        <abbr class="timestamp livetimestamp" title="<s:date name="comment.created" format="yyyy-MM-dd HH:mm" />"><s:date name="comment.created" format="yyyy-MM-dd HH:mm" />发布</abbr>
                                        <!-- · <span class="comment_like_2332806 fsm fwn fcg">
                                        <button title="喜欢此评论" value="2332806" name="like_comment_id[2332806]" type="submit" class="stat_elem as_link cmnt_like_link">
                                          <span class="default_message">赞</span><span class="saving_message">取消</span>
                                        </button>
                                        </span>-->
                                      </div>
                                    </div>
                                  </div>
                                </li>
                              </ul>
                            </li>
                            </s:iterator>
                          </ul>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="uiScrollableAreaTrack" style="opacity: 1;">
                    <div class="uiScrollableAreaGripper hidden_elem" style="height: 174.081px; top: 0px;"></div>
                  </div>
                </div>
                <div id="fbPhotoSnowliftFeedbackInput" class="fbPhotosSnowboxFeedbackInput">
                  <ul class="uiUfi fbPhotosSnowliftUfi">
                    <li class="uiUfiAddComment clearfix uiUfiSmall ufiItem ufiItem">
                      <div class="UIImageBlock clearfix mentionsAddComment">
                        <img alt="" src="<s:property value="#session.userlogo"/>" class="uiProfilePhoto actorPic UIImageBlock_Image UIImageBlock_ICON_Image uiProfilePhotoMedium img"/>
                        <div class="commentArea UIImageBlock_Content UIImageBlock_ICON_Content">
                          <div class="commentBox">
                            <div id="uex6s3_3" class="uiMentionsInput textBoxContainer">
                              <div class="highlighter" style="direction: ltr; text-align: left;">
                                <div style="width: 242px;"><span class="highlighterContent hidden_elem"></span></div>
                              </div>
                              <div id="uex6s3_4" class="uiTypeahead mentionsTypeahead" style="height: auto;">
                                <div class="wrap">
                                  <input type="hidden" class="hiddenInput"/>
                                  <div class="innerWrap">
                                    <s:textarea id="feedComment" name="feedComment" onkeypress="enterKeypress(this, event)" placeholder="留段话吧..." title="留段话吧..." cssClass="enter_submit uiTextareaNoResize uiTextareaAutogrow textBox mentionsTextarea textInput DOMControl_placeholder"></s:textarea>
                                  </div>
                                </div>
                              </div>
                              <input type="hidden" class="mentionsHidden" name="add_comment_text" value=""/>
                            </div>
                          </div>
                          <!--
                          <label for="uex6s3_5" class="mts commentBtn stat_elem hidden_elem optimistic_submit uiButton uiButtonConfirm">
                          <input type="submit" id="uex6s3_5" name="comment" class="enter_submit_target" value="回复"/>
                          </label>-->
                        </div>
                      </div>
                    </li>
                  </ul>
                </div>
                <div id="shareReasonInput" class="fbPhotosSnowboxFeedbackInput hidden_elem">
                  <ul class="uiUfi fbPhotosSnowliftUfi">
                    <li class="uiUfiAddComment clearfix uiUfiSmall ufiItem ufiItem">
                      <div class="UIImageBlock clearfix mentionsAddComment">
                        <img alt="" src="<s:property value="#session.userlogo"/>" class="uiProfilePhoto actorPic UIImageBlock_Image UIImageBlock_ICON_Image uiProfilePhotoMedium img"/>
                        <div class="commentArea UIImageBlock_Content UIImageBlock_ICON_Content">
                          <div class="commentBox">
                            <div id="uex6s3_3" class="uiMentionsInput textBoxContainer">
                              <div class="highlighter" style="direction: ltr; text-align: left;">
                                <div style="width: 242px;"><span class="highlighterContent hidden_elem"></span></div>
                              </div>
                              <div id="uex6s3_4" class="uiTypeahead mentionsTypeahead" style="height: auto;">
                                <div class="wrap">
                                  <input type="hidden" class="hiddenInput"/>
                                  <div class="innerWrap">
                                    <s:textarea name="shareReason" onfocus="commentFocus(this)" onkeypress="share(this, event, %{feedBean.feed.id})" placeholder="分享理由..." title="分享理由..." cssClass="enter_submit uiTextareaNoResize uiTextareaAutogrow textBox mentionsTextarea textInput DOMControl_placeholder"></s:textarea>
                                  </div>
                                </div>
                              </div>
                              <input type="hidden" class="mentionsHidden" name="add_comment_text" value=""/>
                            </div>
                          </div>
                          <!--
                          <label for="uex6s3_5" class="mts commentBtn stat_elem hidden_elem optimistic_submit uiButton uiButtonConfirm">
                          <input type="submit" id="uex6s3_5" name="comment" class="enter_submit_target" value="回复"/>
                          </label>-->
                        </div>
                      </div>
                    </li>
                  </ul>
                </div>
              </form>

              <div class="coverRhcClick hidden_elem" id="snowliftCoverRhc"></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>