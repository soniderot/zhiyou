﻿<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<div id="addfeed">
<s:iterator value="feeds">
<li id="stream_story_4ec37b3fd947b3232640247" data-ft='{"qid":"5675515467749930831","mf_story_key":"2652098748566","c":"m"}' class="pvm uiUnifiedStory uiStreamStory genericStreamStory aid_1438697558 uiListItem uiListLight uiListVerticalItemBorder">
  <div class="storyHighlightIndicatorWrapper"></div>
  <div class="storyContent">
    <div class="UIImageBlock clearfix">
      <a
        data-hovercard="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="feedBean.user.userid"/>"
        aria-hidden="true" data-ft='{"type":60}'
        href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="feedBean.user.userid"/>"
        tabindex="-1"
        class="actorPhoto UIImageBlock_Image UIImageBlock_MED_Image">
        <img alt="" src="<s:property value="feedBean.user.avatar"/>" class="uiProfilePhoto profilePic uiProfilePhotoLarge img" />
      </a>
      <div class="storyInnerContent UIImageBlock_Content UIImageBlock_MED_Content">
        <div class="mainWrapper">
          <h6 class="uiStreamMessage">
                      <div class="actorDescription actorName">
                        <a href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="user.userid"/>">
                          <s:property value="user.username" />
                        </a>
                         <s:if test="feed.handle=='sns.publish.text'">发布了评论</s:if>
                         <s:if test="feed.handle=='sns.event.text'">发布了关于活动
                         	 <a href="event/event!viewEvent.jhtml?eventId=<s:property value="event.id"/>">
                          <s:property value="event.eventname" />
                        </a>
                         	的评论</s:if>
                         	
                        <s:if test="feed.handle=='sns.event.photo'">发布了关于活动
                         	 <a href="event/event!viewEvent.jhtml?eventId=<s:property value="event.id"/>">
                          	<s:property value="event.eventname" />
                        	</a>
                         	的照片
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
                      </div>
                      <s:if test="feed.handle=='sns.publish.text'||feed.handle=='sns.event.text'">
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
                      
                       <s:if test="(feed.handle=='sns.publish.photo'||feed.handle=='sns.share.photo'||feed.handle=='sns.event.photo')">
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
            <span class="uiStreamSource" data-ft="{&quot;type&quot;:26}">
              <abbr title="<s:date name="feed.created" format="yyyy-MM-dd HH:mm" />"  class="timestamp livetimestamp">
                <s:date name="feedBean.feed.created" format="yyyy-MM-dd HH:mm" />
              </abbr>
            </span>
          </span>

          <div>
            <ul class="uiList uiUfi focus_target fbUfi child_was_focused">
              <li class="ufiNub uiListItem uiListVerticalItemBorder"><i></i></li>
              
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
</div>
<script type="text/javascript">
  parent.updateCallback('${feedtype}', document.getElementById('addfeed').innerHTML);
</script>