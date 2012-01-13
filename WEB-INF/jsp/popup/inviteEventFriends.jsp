<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<script>
$(function(){
  $("#dialog_0").hide();
});

function hidePopup(dialog) {
  $("#" + dialog).hide();
  $("#" + dialog).addClass("hidden_elem");
}
function showPopup(dialog) {
  $("#" + dialog).show();
  $("#" + dialog).removeClass("hidden_elem");
  return false;
}

function saveFriends() {

  var invitees = "";
  $("input[name='checkableitems']:checked").each(function (){
    invitees = invitees + $(this).val() + " ";
  });
  $("input[name='invitees']").val(invitees);
  var num = $("input[name='checkableitems']:checked").size();
  if(num > 0) {
    $("#customerSelect").find("span").html("选择更多宾客 " + num);
  }
  hidePopup('dialog_0');
}
</script>


<div class="generic_dialog pop_dialog profileBrowserDialog full_bleed generic_dialog_fixed_overflow hidden_elem" id="dialog_0" style="">
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
                            <a class="anchor" href="#" tabindex="-1">
                              <div class="UIImageBlock UIImageBlock_Entity clearfix">
                                <img src="<s:property value="#friend.avatar" />" class="photo UIImageBlock_Image img UIImageBlock_ENT_Image"/>
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