<%@page pageEncoding="utf-8"%>
<script type="text/javascript">
$(function(){
  $("#dialog_add_message").hide();
  $("#dialog_friends").hide();
});

function hidePopup(dialog) {
  $("#" + dialog).hide();
}
function showPopup(dialog) {
  $("#" + dialog).removeClass("hidden_elem");
  $("#" + dialog).show();
  return false;
}

function sendMessage() {

  var recipients = $("input[id=recipients]").val();
  var message = $("textarea[name=message_body]").val();
  $.ajax({
   type: "GET",
   url: "usr/message!sendMessageAjax.jhtml",
   dataType: 'text',
   data: "recipients="+recipients+"&message="+message,
   success: function(data){
      hidePopup("dialog_add_message");
      $("#MessagingThreadlist").prepend(data);
   }
  });
}

function selectFriendsPop() {
  hidePopup("dialog_add_message");
  showPopup("dialog_friends");
}
function saveFriends() {
  var html = "";
  $("input[name='checkableitems']:checked").each(function (){
    var friendId = $(this).val();
    var nameInput = "input[name='name_" + friendId + "']";
    var friendName = $(nameInput).val();
    var idInput = "input[id='id_" + friendId + "']";
    var obj = $("#ugxgvx_4").find(idInput);
    if (obj.val() == undefined) {
      html = "<span title='Fei Wang' class='removable uiToken'>" + friendName
      html = html + "<input type='hidden' value="+friendId+" name='selectedFriends[]' id='id_"+friendId+"' />"
      html = html + "<a href='#' title='删除" + friendName +"' class='remove uiCloseButton uiCloseButtonSmall' onclick='return removeSelectdFriend(this)'></a>"
    }
  });
  $("#ugxgvx_4").append(html);
  hidePopup("dialog_friends");
  showPopup("dialog_add_message");
}

function removeSelectdFriend(obj) {
  $(obj).parent().remove();
  return false;
}
</script>

<div class="generic_dialog pop_dialog generic_dialog_fixed_overflow hidden_elem" id="dialog_add_message" style="">
  <div class="generic_dialog_popup" style="top: 40px;">
    <div class="pop_container_advanced">
      <div id="pop_content" class="pop_content" tabindex="0" role="alertdialog">
        <h2 class="dialog_title" id="title_dialog_0"><span>新消息！</span></h2>
        <div class="dialog_content">
          <div class="dialog_summary hidden_elem"></div>
          <div class="dialog_body">
            <div id="ugxgvx_1" class="mhm MessagingComposer clearfix">
              <div id="MessagingComposerError" class="mts mbm pam hidden_elem uiBoxRed"></div>
              <div class="MessagingComposerForm">
                <table class="uiInfoTable noBorder">
                  <tbody>
                    <tr class="toField dataRow">
                      <th class="label">收件人：</th>
                      <td class="data">
                        <div class="MessagingComposerTypeaheadWrapper">
                          <div id="ugxgvx_2" onclick="$('recipnients').focus();" class="clearfix uiTokenizer uiInlineTokenizer MessagingComposerTypeahead">
                            <div id="ugxgvx_4" class="tokenarea"></div>
                            <div id="ugxgvx_3" class="uiTypeahead">
                              <div class="wrap">
                                <input type="hidden" class="hiddenInput" autocomplete="off" value=""/>
                                <div class="innerWrap">
                                  <input type="text" id="recipnients" title="Click me to select friends." value="Click me to select friends." spellcheck="false" onfocus="selectFriendsPop()" autocomplete="off" data-placeholder="Click me to select friends." size="76" placeholder="Click me to select friends." class="inputtext textInput DOMControl_placeholder"/>
                                </div>
                              </div>
                              <div class="uiTypeaheadView hidden_elem"></div>
                            </div>
                          </div>
                        </div>
                      </td>
                    </tr>
                    <tr class="dataRow">
                      <th class="label">发信息：</th>
                      <td class="data">
                        <div class="MessagingComposerContainer">
                          <textarea rows="1" name="message_body" class="uiTextareaAutogrow MessagingComposerBody MessagingComposerFullTextArea"></textarea>
                        </div>
                      </td>
                    </tr>
                    <tr class="dataRow">
                      <th class="label"></th>
                      <td class="data"><div class="attachmentArea"></div></td>
                    </tr>
                    <tr>
                      <th class="label"></th>
                      <td class="data">
                        <div class="mvl pas FBAttachmentStage hidden_elem">
                          <div class="uiHeader uiHeaderWithImage uiHeaderBottomBorder">
                            <div class="clearfix uiHeaderTop">
                              <label for="ugxgvx_7" class="uiHeaderActions rfloat uiCloseButton">
                                <input type="button" id="ugxgvx_7" onclick="JSCC.get('j4ee9a67edcfb96f186712731').onScraperCancel();" title="删除"/>
                              </label>
                              <div>
                                <h4 class="uiHeaderTitle"><i class="uiHeaderImage img sp_9rf1fr sx_73faa2"></i>链接</h4>
                              </div>
                            </div>
                          </div>
                          <img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="FBAttachmentStageLoader uiLoadingIndicatorAsync img"/>
                          <div class="pam FBAttachmentStageTarget"></div>
                        </div>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
          <div class="dialog_buttons clearfix">
            <div class="dialog_buttons_msg"></div>
            <div>
              <label class="uiButton uiButtonLarge uiButtonConfirm">
                <input type="button" name="send" value="发送" onclick="sendMessage()" />
              </label>
              <label class="uiButton uiButtonLarge">
                <input type="button" name="cancel" value="取消" onclick="hidePopup('dialog_add_message')" />
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


<div class="generic_dialog pop_dialog profileBrowserDialog full_bleed generic_dialog_fixed_overflow" id="dialog_friends" style="">
  <div class="generic_dialog_popup" style="top: 40px; width: 577px;">
    <div class="pop_container_advanced">
      <div id="pop_content" class="pop_content" tabindex="0" role="alertdialog">
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
                              <label for="uawg93_11" class="clear uiCloseButton">
                              <input type="button" id="uawg93_11" onclick="var c = JSCC.get('j4ee5ce28edab28e651303442').getCore(); c.reset(); c.getElement().focus(); " title="删除"/>
                              </label>
                              <input type="hidden" name="profileChooserItems" class="hiddenInput" autocomplete="off" value="{}"/>
                              <div class="innerWrap">
                                <input type="text" title="寻找全部朋友" value="寻找全部朋友" spellcheck="false" onfocus="return wait_for_load(this, event, function() {;JSCC.get('j4ee5ce28edab28e651303442').init([]);;});" autocomplete="off" placeholder="寻找全部朋友" class="inputtext textInput DOMControl_placeholder"/>
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
                          <s:iterator value="friends" id="friend">
                          <li class="multiColumnCheckable checkableListItem">
                            <input type="checkbox" class="checkbox" name="checkableitems" value="<s:property value='#friend.userid' />" />
                            <input type="hidden" name="name_<s:property value='#friend.userid' />" value="<s:property value="#friend.username" />" />
                            <a class="anchor" href="#" tabindex="-1">
                              <div class="UIImageBlock UIImageBlock_Entity clearfix">
                                <img src="http://profile.ak.fbcdn.net/hprofile-ak-snc4/187103_100000897150377_1981128_q.jpg" class="photo UIImageBlock_Image img UIImageBlock_ENT_Image"/>
                                <div class="content UIImageBlock_Content">
                                  <div class="fcb fwb text"><s:property value="#friend.username" /> </div>
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
                <input type="hidden" name="eid" autocomplete="off"/>
              </div>
            </div>
          </div>
          <div class="dialog_buttons clearfix">
            <div class="dialog_buttons_msg"></div>
            <div>
              <label class="uiButton uiButtonLarge uiButtonConfirm inputsubmit">
              <input type="button" name="ok" value="保存后关闭" onclick="saveFriends()"/>
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