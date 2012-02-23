<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>

<div class="generic_dialog pop_dialog profileBrowserDialog full_bleed generic_dialog_fixed_overflow" id="dialog_1" style="">
  <div class="generic_dialog_popup" style="top: 40px; width: 577px;">
    <div class="pop_container_advanced">
      <div id="pop_content" class="pop_content">
        <h2 class="dialog_title" id="title_dialog_0"><span>上传图片</span></h2>
        <div class="dialog_content">
          <div class="dialog_summary hidden_elem"></div>
          <div>
            <div id="uawg93_1" class="fbProfileBrowser">
              <div class="eventInviteLayout">
                <div class="pam filterBox uiBoxGray topborder">
                  <s:form onsubmit="return checkInput();" method="post" action="usr/feed!updateStatusAjax.jhtml" target="u3jjus_1" enctype="multipart/form-data">
                    <input type="hidden" value="c0a81f7ab46455dde1e203435e599680" name="post_form_id" />
                    <input type="hidden" name="feedtype" value="status" />
                    <input type="hidden" name="eventId"  value="<s:property value="event.Id"/>" />
                    <div id="u3mxyl_6" class="uiMetaComposerMessageBox uiComposerMessageBoxMentions">
                      <table>
                        <tbody>
                          <tr>
                            <td>
                              <label for="emails">描述：</label>
                            </td>
                            <td class="fullWidth">
                              <div class="uiTypeahead uiClearableTypeahead fbProfileBrowserTypeahead" id="uawg93_3">
                                <div class="wrap">
                                  <div class="innerWrap">
                                    <input type="text" class="inputtext textInput DOMControl_placeholder" placeholder="发表点看法吧..." title="发表点看法吧..." name="inviteMessage"/>
                                  </div>
                                </div>
                              </div>
                            </td>
                          </tr>
                          <tr>
                            <td>
                              <label for="emails">图片：</label>
                            </td>
                            <td class="fullWidth">
                              <div class="webComposerPhotoInputArea">
                                <div class="mbs photoUploadPrompt fwb">从你的电脑上选择一个图像。</div>
                                <input type="file" name="feedphoto" onchange="enableSubmitBtn()" />
                              </div>
                            </td>
                          </tr>
                        </tbody>
                      </table>
                    </div>
                  </s:form>
                </div>
              </div>
            </div>
          </div>
          <div class="dialog_buttons clearfix">
            <div class="dialog_buttons_msg"></div>
            <div>
              <label class="uiButton uiButtonLarge uiButtonConfirm inputsubmit">
              <input type="button" name="ok" value="保存" onclick="sendInviteRequest()"/>
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

<script type="text/javascript">

function hidePopup(dialog) {
  $("#" + dialog).remove();
}
function showPopup(dialog) {
  $("#" + dialog).show();
  $("#" + dialog).removeClass("hidden_elem");
  return false;
}

function sendInviteRequest() {
  var invitees = "";
  $("input[name='checkableitems']:checked").each(function (){
    invitees = invitees + $(this).val() + " ";
  });
  var eid = $("input[name='eventId']").val();
  var message = $("input[name='inviteMessage']").val();
  if(message == $("input[name='inviteMessage']").attr("placeholder")) {
    message = "";
  }
  if (invitees == "") {
    hidePopup("dialog_0");
    return false;
  }
  $("#pop_content").addClass("dialog_loading_shown");
  $.get("event/event!inviteFriendsAjax.jhtml", {invitees: invitees, eventId: eid, inviteMessage: message}, function(data){
    if(data == "true") {
      $(".dialog_body").html("<div class='pam uiBoxYellow noborder'>你的邀请已发送。</div>");
    } else {
      $(".dialog_body").html("<div class='pam uiBoxYellow noborder'>请求发送失败，请重新发送。</div>");
    }
    $(".inputsubmit").html("<input type='button' name='ok' value='关闭' onclick=\"hidePopup('dialog_0')\"/>");
    $("#pop_content").removeClass("dialog_loading_shown");
  }, "text");
}
</script>