<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
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
          </h6>

        </div>
      </div>
    </div>
  </div>
</li>