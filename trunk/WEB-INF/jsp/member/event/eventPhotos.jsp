<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>

<div id="contentArea" role="main">
  <div id="pagelet_roosters"></div>
  <div id="pagelet_stream_header">
    <div class="uiHeader uiHeaderWithImage uiHeaderPage  fbx_stream_header">
      <div class="clearfix uiHeaderTop">
        <div class="uiHeaderActions  rfloat fsl fwb fcb"></div>
        <div>
          <h2 class="uiHeaderTitle">
            <i class="uiHeaderImage img sp_7gl7wd sx_efd21b"></i>活动信息
          </h2>
        </div>
      </div>
    </div>
  </div>
  <%@ include file="/WEB-INF/jsp/member/event/eventdetailhead.jsp"%>
  <s:if test="eventPhotos!=null && eventPhotos.size != 0">
  <div id="pagelet_main_column">
    <div id="pagelet_main_column_personal">
      <div id="pagelet_friends_tab">
        <div id="ulclp8_3" class="fbProfileBrowser">
          <div>
            <div class="uiHeader uiHeaderTopAndBottomBorder uiHeaderSection">
              <div class="clearfix uiHeaderTop">
                <div>
                  <h3 class="uiHeaderTitle">活动照片</h3>
                </div>
              </div>
            </div>
            
            <a class="mbs uiButton" onclick="return showPopup('dialog_uploadPhoto');" href="javascript:void(0);" rel="dialog-post" style="margin-top:10px;">
              <i class="mrs img sp_7gl7wd sx_61da04"></i>
              <span class="uiButtonText">添加活动照片</span>
            </a>
            <div id="ulclp8_4" class="listView clearfix large">
              <img height="32" width="32" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/y9/r/jKEcVPZFk-2.gif" class="throbber img"/>
              <div class="lists">
                <div id="ulclp8_2" class="fbProfileBrowserResult hideSummary">
                  <div class="pvm phs fbProfileBrowserSummaryBox uiBoxWhite bottomborder"></div>
                  <div class="fbProfileBrowserLargeList fbProfileBrowserListContainer">
                    <ul class="uiList uiListHorizontal clearfix mvm phs">
                      <s:iterator value="eventPhotos" status="status">
                      <s:if test="status.index%6==0 && status.index!=0">
                        </ul>
                        <s:if test="status.index!=eventPhotos.size-1">
                        <ul class="uiList uiListHorizontal clearfix mvm phs">
                        </s:if>
                      </s:if>
                      <li class="uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
                        <div class="fbProfileLargePortrait fbProfileLargeMarginLeft">
                          <a>
                            <div class="photoWrapper">
                              <div class="photoCrop">
                                <img alt="" src="<s:property value='photo.filename' />" onclick="showBigPhoto(<s:property value='feed.id' />)" class="fbProfileLargePortraitImgScaleWidth fbProfileLargePortraitImgSmall img"/>
                              </div>
                            </div>
                            <span class="textWrap fsm fwb"></span>
                          </a>
                          <div class="textWrap fsm fcg"></div>
                        </div>
                      </li>
                      </s:iterator>
                      <!-- 
                      <li class="pls uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
                        <div class="fbProfileLargePortrait fbProfileLargeMarginLeft">
                          <a rel="" href="/find-friends/browser/?ref=pb">
                            <div class="photoWrapper">
                            <img src="/images/icons/find_classmates.png" class="blankStateUserListImage"/>
                            </div>
                            <strong>查找同学</strong>
                          </a>
                        </div>
                      </li>
                       -->
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  </s:if>
</div>
<%@ include file="/WEB-INF/jsp/popup/uploadPhotoPop.jsp"%>
<%@ include file="/WEB-INF/jsp/popup/delFeedCommentPop.jsp"%>
<script type="text/javascript">
  
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
</script>