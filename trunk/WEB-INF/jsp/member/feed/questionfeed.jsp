<%@page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<div class="mvm uiStreamAttachments clearfix">
  <div class="clearfix">
    <div>
      <div class="fbEigenpoll fbEigenpollFeed live_<s:property value='question.id' />">
        <s:iterator value="options">
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
                <div class="phs auxlabel"><span class="fwb fcg votecount"><s:property value='option.hot' /> 票</span></div>
              </div>
            </div>
          </s:form>
        </div>
        </s:iterator>
        <s:if test="question.optionaddable">
        <div class="fbEigenpollAddOption">
          <s:form method="post" action="/ajax/questions/eigenpolls/add_option.php" cssClass="focus_target child_was_focused" rel="async">
            <table cellspacing="0" cellpadding="0">
              <tbody>
                <tr>
                  <td class="fbEigenpollTypeaheadTD">
                    <div id="uxa0y2_<s:property value='question.id' />" class="uiTypeahead fbEigenpollTypeahead">
                      <div class="wrap">
                        <div class="innerWrap">
                          <s:textfield id="optionText_%{question.id}" name="optionText" title="添加选项..." placeholder="添加选项..." maxlength="80" cssClass="inputtext textInput DOMControl_placeholder"/>
                        </div>
                        <i class="plus img sp_ayuesb sx_56af78"></i>
                      </div>
                    </div>
                  </td>
                  <td>
                    <label for="uxa0y2_<s:property value='question.id' />" class="fbEigenpollAddButton uiButton">
                      <input type="button" id="uxa0y2_<s:property value='question.id' />" value="添加" onclick="addOption(<s:property value='question.id' />)"/>
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

<s:form onsubmit="return commentSubmit(this);" action="usr/feed!addFeedComment.jhtml" method="post" cssClass="commentable_item autoexpand_mode collapsed_comments">
  <input type="hidden" name="feedId" value="<s:property value='feed.id' />" />
  
  <div class="UIImageBlock clearfix uiStreamFooter">
    <i class="UIImageBlock_Image UIImageBlock_ICON_Image img sp_7gl7wd sx_97759f"></i>
    <div class="UIImageBlock_Content UIImageBlock_ICON_Content">
      <span>
        <span class="UIActionLinks UIActionLinks_bottom">
          <a title="向指定的人们寻求答案" class="" onclick="return askFriends(<s:property value='feed.referenceid' />);">提问</a> · 
        </span>
        <span class="UIActionLinks UIActionLinks_bottom">
          <label class="uiLinkButton comment_link" title="发表留言">
            <input type="button" value="评论" onclick="return showComments(this);" />
          </label> · 
        </span>
        <span class="uiStreamSource">
          <abbr title="<s:date name="feed.created" format="yyyy-MM-dd HH:mm" />"  class="timestamp livetimestamp">
            <s:date name="feed.created" format="yyyy-MM-dd HH:mm" />
          </abbr>
        </span>
      </span>
    </div>
  </div>

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
              <input type="button" onclick="showDelCommentPop('dialog_delFeedCmt', <s:property value='comment.id' />)" title="删除"/>
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
                  <input type="hidden" class="hiddenInput"/>
                  <div class="innerWrap">
                    <s:textarea name="feedComment" onfocus="commentFocus(this)" onkeypress="enterKeypress(this, event)" placeholder="留段话吧..." title="留段话吧..." cssClass="enter_submit uiTextareaNoResize uiTextareaAutogrow textBox mentionsTextarea textInput DOMControl_placeholder"></s:textarea>
                  </div>
                </div>
                <div class="uiTypeaheadView hidden_elem"/>
              </div>
              <input type="hidden" class="mentionsHidden" name="add_comment_text" value=""/>
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