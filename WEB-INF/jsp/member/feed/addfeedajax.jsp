<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
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
          <h6 data-ft='{"type":1}' class="uiStreamMessage">
            <div data-ft='{"type":2}' class="actorDescription actorName">
              <a data-hovercard="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="feedBean.user.userid"/>" href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="feedBean.user.userid"/>">
                <s:property value="feedBean.user.username" />
              </a>
            </div>
            <s:if test="feedBean.feed.handle=='sns.publish.text'">
              <span data-ft='{"type":3}' class="messageBody"><s:property value="feedBean.feed.body" />
              </span>
            </s:if>
            
             <s:if test="feed.handle=='sns.event.create'">
             						<%@ include file="/WEB-INF/jsp/member/feed/eventfeed.jsp"%>
             </s:if>
                      
             <s:if test="feed.handle=='sns.publish.photo'">
                        <%@ include file="/WEB-INF/jsp/member/feed/photofeed.jsp"%>
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
                          <s:date name="feedBean.feed.created" format="yyyy-MM-dd HH:mm" />
                        </abbr>
                      </span>
              </span>
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