<%@page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<div class="mvm uiStreamAttachments clearfix fbMainStreamAttachment">
</div>
<s:form onsubmit="return commentSubmit(this);" action="usr/feed!addFeedComment.jhtml" method="post" cssClass="commentable_item autoexpand_mode collapsed_comments">
  <input type="hidden" name="feedId" value="<s:property value='feed.id' />" />
  <span class="uiStreamFooter">
    <span class="UIActionLinks UIActionLinks_bottom">
      <label class="uiLinkButton comment_link" title="发表留言">
         <input type="button" value="评论<s:if test="comments.size()>0">(<s:property value='comments.size()' />)</s:if>" onclick="return showComments(this);">
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
