<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<div role="main" id="contentArea">
  <div data-referrer="pagelet_roosters" id="pagelet_roosters"></div>
  <div data-referrer="pagelet_stream_header" id="pagelet_stream_header">
    
  </div>
  <div data-referrer="pagelet_composer" id="pagelet_composer">
    <div id="u3mxyl_2"
      onclick="Bootloader.loadComponents(&quot;Composer&quot;, function() { JSCC.get(&#39;j4ec37b3f908df06889566482&#39;) });"
      class="uiComposer uiComposerHideContent stat_elem uiMetaComposer uiComposerTopBorder uiComposerOpen uiComposerHideContent uiComposerWhiteMessageBox">
      
      <div class="focus_target">
        <ul class="uiList uiListHorizontal clearfix uiComposerAttachments">
         
          <li class="showWhenLoading attachmentLoader plm uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
            <img height="11" width="16" alt="" src="images/GsNJNwuI-UM.gif" class="uiLoadingIndicatorAsync img" />
          </li>
        </ul>

       
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
                        
                        <s:if test="feed.handle=='sns.event.join'">参加了一个活动</s:if>
                        
                        <s:if test="feed.handle=='sns.publish.photo'">发布了照片</s:if>
                        
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

                      <s:if test="(feed.handle=='sns.event.create')||(feed.handle=='sns.event.join')">
                        <%@ include file="/WEB-INF/jsp/member/feed/eventfeed.jsp"%>
                      </s:if>
                      
                       <s:if test="feed.handle=='sns.publish.photo'">
                        <%@ include file="/WEB-INF/jsp/member/feed/photofeed.jsp"%>
                      </s:if>
                    </h6>
                    <!--
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
                    </span>-->
                  </div>
                </div>
              </div>
            </div>
          </li>
        </s:iterator>
				<s:if test="feeds.size()==0">  
				<div>
              <div class="pam uiBoxLightblue uiMorePagerPrimary">
                目前没有更多动态可显示。
              </div>
            </div>
			</s:if>  
      </ul>

      <div>
        <div id="pagelet_stream_pager"
          data-referrer="pagelet_stream_pager">
          <div class="clearfix mts uiMorePager stat_elem fbStreamPager">
             <!--
            <div>
              <div class="pam uiBoxLightblue uiMorePagerPrimary">
                目前没有更多动态可显示。
              </div>
            </div>-->
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
  
  function updateCallback(feedtype, data) {
    $("#home_stream").prepend(data);
    if ("photo" == feedtype) {
      $("#submitBtn").parent().addClass("uiButtonDisabled");
    }
  }
  
  function enableSubmitBtn() {
    $("#submitBtn").parent().removeClass("uiButtonDisabled");
  }
</script>