<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>

<div class="generic_dialog pop_dialog profileBrowserDialog full_bleed generic_dialog_fixed_overflow" id="dialog_0" style="">
  <div class="generic_dialog_popup" style="top: 40px; width: 577px;">
    <div class="pop_container_advanced">
      <div id="pop_content" class="pop_content">
        <h2 class="dialog_title" id="title_dialog_0"><span>邀请朋友</span></h2>
        <div class="dialog_content">
          <div class="dialog_summary hidden_elem"></div>
          <div class="dialog_body">
            <div id="uawg93_1" class="fbProfileBrowser">
              <div class="eventInviteLayout">
                <div class="pam filterBox uiBoxGray topborder">
                  <table>
                    <tbody>
                      <tr>
                        <td>
                          <label for="emails">邀请留言：</label>
                        </td>
                        <td class="fullWidth">
                          <div id="uawg93_3" class="uiTypeahead uiClearableTypeahead fbProfileBrowserTypeahead">
                            <div class="wrap">
                              <div class="innerWrap">
                                <input type="text" name="inviteMessage" title="邀请信息..." placeholder="邀请信息..." class="inputtext textInput DOMControl_placeholder"/>
                              </div>
                            </div>
                          </div>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
                <div id="uawg93_12" class="listView clearfix">
                  <img height="32" width="32" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/y9/r/jKEcVPZFk-2.gif" class="throbber img"/>
                  <div class="lists">
                    <div id="uawg93_4" class="fbProfileBrowserResult hideSummary hidden_elem">
                      <div class="pvm phs fbProfileBrowserSummaryBox uiBoxWhite bottomborder"></div>
                      <div class="fbProfileBrowserNullstate fbProfileBrowserListContainer fsxl fcg">加载中...</div>
                    </div>
                    <div id="uawg93_2" class="fbProfileBrowserResult scrollable threeColumns hideSummary">
                      <div class="fbProfileBrowserListContainer">
                        <ul class="">
                          <s:iterator value="userevents">
                          <li class="multiColumnCheckable checkableListItem <s:if test='joined'>disabledCheckable</s:if>">
                            <input type="checkbox" class="checkbox" name="checkableitems" value="<s:property value='profile.userid' />" />
                            <a class="anchor" href="#" tabindex="-1">
                              <div class="UIImageBlock UIImageBlock_Entity clearfix">
                                <img src="<s:property value="profile.avatar" />" class="photo UIImageBlock_Image img UIImageBlock_ENT_Image"/>
                                <div class="content UIImageBlock_Content">
                                  <div class="fcb fwb text"><s:property value="profile.username" /> </div>
                                  <div class="fcg text subtitle"></div>
                                </div>
                              </div>
                            </a>
                          </li>
                          </s:iterator>
                        </ul>
                      </div>
                    </div>
                  </div>
                </div>
                <input type="hidden" name="eventId" value="<s:property value='eventId' />" />
              </div>
            </div>
          </div>
          <div class="dialog_buttons clearfix">
            <div class="dialog_buttons_msg"></div>
            <div>
              <label class="uiButton uiButtonLarge uiButtonConfirm inputsubmit">
              <input type="button" name="ok" value="保存后关闭" onclick="sendInviteRequest()"/>
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