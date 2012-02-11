<%@page pageEncoding="utf-8"%>
<script type="text/javascript">
function hidePopup(dialog) {
  $("#" + dialog).addClass("hidden_elem");
  $("#" + dialog).hide();
}
function showPopup(dialog) {
  $("#" + dialog).removeClass("hidden_elem");
  $("#" + dialog).show();
  return false;
}

function showDelCommentPop(dialog, commonId) {
  $("input[name='commentId']").val(commonId);
  showPopup(dialog);
  return false;
}

function showDelFeedPop(dialog, feedId) {
  $("input[name='feedId']").val(feedId);
  showPopup(dialog);
  return false;
}

function deleteComment(manageType) {
  var cmtId = $("input[name='commentId']").val();
  $.post("usr/feed!manageFeedCommentAjax.jhtml", {
      commentId : cmtId,
      manageType : manageType
    }, function (data) {
      hidePopup("dialog_delFeedCmt");
      $("li.comment_" + cmtId).remove();
    });
    return false;
}

function deleteFeed() {
  var feedId = $("input[name='feedId']").val();
  $.post("usr/feed!deleteFeedAjax.jhtml", {
      feedId : feedId
    }, function (data) {
      hidePopup("dialog_delFeed");
      $("#feed_" + feedId).remove();
    });
    return false;
}

function selectFriendsPop() {
  hidePopup("dialog_add_message");
  showPopup("dialog_friends");
}

function removeSelectdFriend(obj) {
  $(obj).parent().remove();
  return false;
}
</script>

<div class="generic_dialog pop_dialog confirm_dialog generic_dialog_modal hidden_elem" id="dialog_delFeedCmt">
  <input type="hidden" name="commentId" />
  <div class="generic_dialog_popup" style="top: 76.5px;">
    <div class="pop_container_advanced">
      <div id="pop_content" class="pop_content" tabindex="0" role="alertdialog">
        <h2 class="dialog_title" id="title_dialog_3"><span>删除评论</span></h2>
        <div class="dialog_content">
          <div class="dialog_summary hidden_elem"></div>
          <div class="dialog_body">
            <div class="confirmation_message">你确定要删除这个评论吗？
              <input type="hidden" value="0" name="ban_user" id="ban_user" autocomplete="off"/>
            </div>
          </div>
          <div class="dialog_buttons clearfix">
            <div class="dialog_buttons_msg"></div>
            <div>
              <label class="uiButton uiButtonLarge uiButtonConfirm">
                <input type="button" name="deleteBtn" value="删除" onclick="deleteComment(1)" />
              </label>
              <label class="uiButton uiButtonLarge">
                <input type="button" name="cancelBtn" value="取消" onclick="hidePopup('dialog_delFeedCmt')" />
              </label>
            </div>
          </div>
          <div class="dialog_footer hidden_elem"></div>
        </div>
        <div class="dialog_loading">加载中...</div>
      </div>
    </div>
  </div>
</div>

<div class="generic_dialog pop_dialog confirm_dialog generic_dialog_modal hidden_elem" id="dialog_delFeed">
  <input type="hidden" name="feedId" />
  <div class="generic_dialog_popup" style="top: 76.5px;">
    <div class="pop_container_advanced">
      <div id="pop_content" class="pop_content" tabindex="0" role="alertdialog">
        <h2 class="dialog_title" id="title_dialog_3"><span>删除动态</span></h2>
        <div class="dialog_content">
          <div class="dialog_summary hidden_elem"></div>
          <div class="dialog_body">
            <div class="confirmation_message">你确定要删除这个动态吗？
              <input type="hidden" value="0" name="ban_user" id="ban_user" autocomplete="off"/>
            </div>
          </div>
          <div class="dialog_buttons clearfix">
            <div class="dialog_buttons_msg"></div>
            <div>
              <label class="uiButton uiButtonLarge uiButtonConfirm">
                <input type="button" name="deleteBtn" value="删除" onclick="deleteFeed()" />
              </label>
              <label class="uiButton uiButtonLarge">
                <input type="button" name="cancelBtn" value="取消" onclick="hidePopup('dialog_delFeed')" />
              </label>
            </div>
          </div>
          <div class="dialog_footer hidden_elem"></div>
        </div>
        <div class="dialog_loading">加载中...</div>
      </div>
    </div>
  </div>
</div>