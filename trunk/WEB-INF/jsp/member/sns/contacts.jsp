<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<div role="main" id="contentArea">
  <div id="pagelet_friends">
    <div class="uiHeader uiHeaderWithImage uiHeaderPage">
      <div class="clearfix uiHeaderTop">
        <a href="sns/sns!getFriendsList.jhtml" role="button" class="uiHeaderActions rfloat uiButton">
          <span class="uiButtonText">管理朋友列表</span>
        </a>
        <div>
          <h2 class="uiHeaderTitle">
            <i class="uiHeaderImage img sp_biub6x sx_e332d4"></i>朋友
          </h2>
        </div>
      </div>
    </div>
    <div class="clearfix findfriends" id="content_inner">
      <div class="new_ff" id="importer_frame">
        <div style="display: none;" id="success" class="mbl pam uiBoxYellow"></div>
        <div style="display: none;" id="error" class="mbl pam uiBoxRed"></div>
        <div style="display: none;" id="done" class="mbl"></div>
        <div id="befriend_selector"></div>
        <div id="invite">
          <div id="address_book_selector" class="mbl">
            <div class="UIImageBlock clearfix">
              <img height="36" width="35" alt="" src="images/UHkKDRwgbaw.png" class="UIImageBlock_Image UIImageBlock_MED_Image img"/>
              <div class="uiHeader uiHeaderPage UIImageBlock_Content UIImageBlock_MED_Content">
                <div class="clearfix uiHeaderTop">
                  <div class="uiHeaderActions rfloat"></div>
                  <div>
                    <h2 class="uiHeaderTitle">邀请朋友和家人加入</h2>
                  </div>
                </div>
              </div>
            </div>
            <div class="uiStepList pbs">
              <ol>
                <li class="uiStep uiStepFirst">
                  <div class="part back"></div>
                  <div class="part middle">
                    <div class="content">
                      <div class="title fsl fwb fcb">步骤 1</div>
                      <span class="description">搜索朋友</span>
                    </div>
                  </div>
                  <div class="part point"></div>
                </li>
                <!---
                <li class="uiStep uiStepNextSelected">
                  <div class="part back"></div>
                  <div class="part middle">
                    <div class="content">
                      <div class="title fsl fwb fcb">步骤 2</div>
                      <span class="description">添加朋友</span>
                    </div>
                  </div>
                  <div class="part point"></div>
                </li>--->
                <li id="ci_steplist_3" class="uiStep uiStepLast uiStepLastSelected uiStepSelected">
                  <div class="part back"></div>
                  <div class="part middle">
                    <div class="content">
                      <div class="title fsl fwb fcb">步骤 2</div>
                      <span class="description">邀请朋友</span>
                    </div>
                  </div>
                  <div class="part point"></div>
                </li>
              </ol>
            </div>
            <form onsubmit="checkInput(this)" method="post" action="sns/sns!invite.jhtml">
              <input type="hidden" value="AQAQAK2a" name="fb_dtsg" />
              <div class="contact_wrapper fixed_height">
                <table cellspacing="0" cellpadding="0" width="100%" class="uiGrid invite_selector_header">
                  <tbody>
                    <tr>
                      <td class="checkbox">
                        <input type="checkbox" id="toggle_all_checkbox" onclick='toggleAll(this)'/>
                      </td>
                      <td>
                        <a onclick='return checkboxToggleAll();'>
                          <span class="fsm">全选/全不选</span>
                        </a>
                      </td>
                    </tr>
                  </tbody>
                </table>
                <div class="invite_selector_table_wrapper">
                  <table cellspacing="0" cellpadding="0" width="100%" id="email_contacts_list" class="invite_selector_table">
                    <tbody>
                    <s:iterator value="contacts">
                      <tr>
                        <td class="checkbox">
                          <input type="checkbox" name="emailsCbx" class="contacts" value="<s:property value='email'/>" />
                          <input type="hidden" name="emails" value="<s:property value='email'/>" />
                          <input type="hidden" name="names" value="<s:property value='name'/>" />
                        </td>
                        <td title="<s:property value="name"/>" onclick="toggleRow(this)" class="name"><s:property value="name"/>${name}</td>
                        <td title="<s:property value="email"/>" onclick="toggleRow(this)" class="email"><s:property value="email"/><span class="login_credential"><s:property value="email"/></span></td>
                      </tr>
                    </s:iterator>
                    </tbody>
                  </table>
                </div>
                <table cellspacing="0" cellpadding="0" width="100%" class="uiGrid mts invite_selector_footer">
                  <tbody>
                    <tr>
                      <td class="vMid"></td>
                      <td class="vTop hRght">
                        <img height="11" width="16" alt="" src="images/GsNJNwuI-UM.gif" class="mhm mts uiLoadingIndicatorAsync img"/>
                        <label for="uydez6_1" class="uiButton uiButtonConfirm uiButtonLarge">
                          <input type="submit" id="uydez6_1" value="发送邀请"/>
                        </label>
                        <label class="uiButton uiButtonConfirm uiButtonLarge" for="ur7504_29">
                          <a href="sns/sns!getFriendsList.jhtml">跳过</a>
                        </label>
                      </td>
                    </tr>
                  </tbody>
                </table>
                <!--
                <div class="mvl uiP fsm fcg">
                  请只邀请你认识，并且愿意接受邀请的人。第一次邀请发出后，我们会自动提醒对方最多两次。
                  <a href="/ajax/invite/learn_more.php" rel="dialog">了解更多</a>或
                  <a href="/ajax/invite/invite_example.php?pm=0" rel="dialog">查看范例</a>。
                </div>-->
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
function toggleAll(obj) {
  if(obj.checked) {
    $("input[name='emailsCbx']").each(function(){
      $(this).attr("checked", true);
    });
  } else {
    $("input[name='emailsCbx']").each(function(){
      $(this).attr("checked", false);
    });
  }
  return false;
}

function checkboxToggleAll() {
  var flg = $("#toggle_all_checkbox").attr("checked");
  if (!flg) {
    $("#toggle_all_checkbox").attr("checked", true);
    $("input[name='emailsCbx']").each(function(){
      $(this).attr("checked", true);
    });
  } else {
    $("#toggle_all_checkbox").attr("checked", false);
    $("input[name='emailsCbx']").each(function(){
      $(this).attr("checked", false);
    });
  }
}

function checkInput(obj) {
  var idx = -1;
  $("input[name='emailsCbx']").each(function(){
    idx = idx + 1;
    if (!this.checked) {
      $("input[name='emails']")[idx].value = "";
    }
  });
}

</script>