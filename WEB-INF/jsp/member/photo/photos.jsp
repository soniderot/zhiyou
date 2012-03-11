<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<div role="main" id="contentArea">
  <div data-referrer="pagelet_roosters" id="pagelet_roosters"></div>
  <div data-referrer="pagelet_composer" id="pagelet_composer">
    <div id="u3mxyl_2" class="uiComposer uiComposerHideContent stat_elem uiMetaComposer uiComposerTopBorder uiComposerOpen uiComposerHideContent uiComposerWhiteMessageBox">
      <div class="focus_target">
        <ul class="uiList uiListHorizontal clearfix uiComposerAttachments">
        </ul>
      </div>
    </div>
  </div>
  
  <iframe style="width: 1px; height: 1px; position: absolute; top: -10000px;" name="u3jjus_1" class="fbUploadIframe"></iframe>
  <div data-gt='{"ref":"nf"}' data-referrer="pagelet_home_stream" id="pagelet_home_stream">
    <div id="c4ec37b3fc7e022d58174072" class="UIIntentionalStream UIStream">
      <ul id="home_stream" class="uiList uiStream UIIntentionalStream_Content" data-referrer="home_stream" style="min-height: 100px;">
        <s:iterator value="userPhotos">
        <li id="stream_story_4ec37b3fd947b3232640247" class="pvm uiUnifiedStory uiStreamStory genericStreamStory aid_1438697558 uiListItem uiListLight uiListVerticalItemBorder">
          <div class="storyHighlightIndicatorWrapper"></div>
          <div class="storyContent">
            <div class="UIImageBlock clearfix" align="center">
              <div class="storyInnerContent UIImageBlock_Content UIImageBlock_MED_Content">
                <div class="mainWrapper">
                  <h6 class="uiStreamMessage">
                    <div class="actorDescription actorName">
                      <h6 data-ft="{&quot;type&quot;:1}" class="uiStreamMessage"> 
                        <span data-ft="{&quot;type&quot;:3}" class="messageBody"><s:property value="summary" /></span>
                      </h6>
              		<div class="mvm uiStreamAttachments clearfix fbMainStreamAttachment">
              		  <div>
              		  	<!--
              		    <a title="<s:property value="summary" />" ajaxify="#" class="uiPhotoThumb largePhoto">
              		      <img alt="" src="<s:property value="filename" />" class="img" />
              		    </a>
              		    -->
              		    <a title="<s:property value="summary" />" class="uiPhotoThumb largePhoto">
      										<img width="<s:property value="width" />" height="<s:property value="height" />"  alt="" src="<s:property value="filename" />" class="img" onclick="showBigPhoto(<s:property value="feedId" />)">
   										 </a>
              		    
              		    <div class="fsm fwn fcg">
              		      <span class="caption"></span>
              		      <div class="uiAttachmentDesc translationEligibleUserAttachmentMessage"></div>
              		    </div>
              		  </div>
              		</div>
                  </div>
                </h6>
                  <span class="UIActionLinks UIActionLinks_bottom">
                    <label class="uiLinkButton comment_link" title="分享">
                      <a href="photo/photo!sharePhoto.jhtml?photoId=<s:property value="id" />" onclick="return share(<s:property value="id" />);"><span class="fwn">分享</span> </a> 
                    </label> · 
                  </span>
                  
                  <span class="uiStreamFooter">
                  	<span class="uiStreamSource" data-ft="{&quot;type&quot;:26}">
                  	  <abbr title="<s:date name="feed.created" format="yyyy-MM-dd HH:mm" />"  class="timestamp livetimestamp">
                  	    上传于<s:date name="createtime" format="yyyy-MM-dd HH:mm" />
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
      <div id="pagelet_stream_pager" data-referrer="pagelet_stream_pager">
        <div class="clearfix mts uiMorePager stat_elem fbStreamPager">
          <div>
            <s:if test="userPhotos.size()>0">
              <jsp:include page="/WEB-INF/jsp/common/pagination.jsp" flush="true" />
            </s:if>
            <s:else>
              <div class="pam uiBoxLightblue uiMorePagerPrimary">目前没有更多照片可显示。</div>
            </s:else>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>


<script type="text/javascript">
  function topage(pageNo) {
  location.href = "photo/photo!getPhotos.jhtml?userid=${userid}&albumId=${albumId}&pageNo="+pageNo
  return false;
  }

  function share(photoId) {
    $.ajax({
     type: "GET",
     url: "photo/photo!sharePhotoAjax.jhtml",
     dataType: 'html',
     data: "photoId=" + photoId,
     success: function(data) {
       $("body").append(data);
     }
    });
    return false;
  }
  
   function removeBigPhoto() {
    $("#fbPhotoSnowlift").remove();
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
      form.feedComment.value = "";
    });
    return false;
  }
  
  function showShareInput(feedId) {
    $("#shareInput_" + feedId).parents("form").addClass("collapsed_comments");
    $("#shareInput_" + feedId).find("ul").css("display", "block");
    return false;
  }
  
  function commentFocus(obj) {
    $(obj).parents("ul").addClass("child_is_active child_is_focused");
    return false;
  }
  
  function showShareReasonInput(obj) {
    $("#shareReasonInput").removeClass("hidden_elem");
    $("#fbPhotoSnowliftFeedbackInput").addClass("hidden_elem");
    $(obj).parents().find(".uiUfiComments").hide();
    $(obj).parents().find(".ufiNub").addClass("share");
    return false;
  }
  
  function share(obj, event, feedId) {
    if(event.keyCode == 13)
    {
      $.ajax({
       type: "GET",
       url: "usr/feed!sharedFeedAjax.jhtml",
       dataType: 'html',
       data: "feedId=" + feedId + "&shareReason=" + $(obj).val(),
       success: function(data) {
         $("body").append(data);
         $(obj).val("");
       }
      });
    }
    return false;
  }
  function showBigPhoto(feedId) {
    $.ajax({
     type: "GET",
     url: "usr/feed!showBigPhotoAjax.jhtml",
     dataType: 'html',
     data: "feedId=" + feedId,
     success: function(data) {
       $("body").append(data);
     }
    });
  }

</script>