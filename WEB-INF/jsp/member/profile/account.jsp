<%@page contentType="textml;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<script type="text/javascript">
var result = '${result}';
if (result == 'success') {
  $.facebox("<div class='alert error'>修改账户信息成功！</div>")
}

function validateUpdateAccount() {
  var result = true;
  if ($("#username").val() != '${profile.username}') {
    result = checkUsername($("#username"))&&result;
  }
  if ($("#email").val() != '${profile.email}') {
    result = checkEmail($("#email"))&&result;
  }
  if ($("#passwd").val() != '') {
    result = checkOldPassword($("#passwd"))&&result;
    result = checkPassword($("#newPasswd1"))&&result;
    result = checkPassword2($("#newPasswd2"), $("#newPasswd1"))&&result;
  }
  return result;
}

</script>
<div role="main" id="contentArea">
  <div id="SettingsPage_Content" class="uiBoxGray">
    <form onsubmit="return validateUpdateAccount()" method="post" action="usr/account!update.jhtml" class="show_label">
    <ul class="uiList fbSettingsList">
      <li class="fbSettingsListItem clearfix uiListItem uiListLight uiListVerticalItemBorder">
		<div class="pvm phs fbSettingsListLink clearfix">
			<span class="pls fbSettingsListItemLabel"><strong>用户名</strong></span>
			<span class="uiIconText fbSettingsListItemEdit" style="padding-left: 23px;">
				<i style="top: -2px;" class="img sp_1qb0a3 sx_00805c"></i>
			</span>
			<span class="fbSettingsListItemContent fcg">
              <input type="text" value="<s:property value="profile.username"/>" id="username" name="username" class="inputtext DOMControl_placeholder" tipstype="error"/>
            </span>
		</div>
        <div class="content"></div>
      </li>
      <li class="fbSettingsListItem clearfix uiListItem uiListLight uiListVerticalItemBorder">
		<div class="pvm phs fbSettingsListLink clearfix">
			<span class="pls fbSettingsListItemLabel"><strong>电子邮件</strong></span>
			<span class="uiIconText fbSettingsListItemEdit" style="padding-left: 23px;">
				<i style="top: -2px;" class="img sp_1qb0a3 sx_00805c"></i>
			</span>
			<span class="fbSettingsListItemContent fcg">
              <input type="text" value="<s:property value="profile.email"/>" id="email" name="email" class="inputtext DOMControl_placeholder" tipstype="error"/>
            </span>
		</div>
      </li>
      <li class="fbSettingsListItem clearfix uiListItem uiListLight uiListVerticalItemBorder">
        <div class="pvm phs fbSettingsListLink clearfix">
          <span class="pls fbSettingsListItemLabel"><strong>旧密码</strong></span>
          <span class="uiIconText fbSettingsListItemEdit" style="padding-left: 23px;">
            <i style="top: -2px;" class="img sp_1qb0a3 sx_00805c"></i>
          </span>
          <span class="fbSettingsListItemContent fcg">
            <input type="password" id="passwd" name="passwd" class="inputtext DOMControl_placeholder" tipstype="error"/>
          </span>
        </div>
      </li>
      <li class="fbSettingsListItem clearfix uiListItem uiListLight uiListVerticalItemBorder">
        <div class="pvm phs fbSettingsListLink clearfix">
          <span class="pls fbSettingsListItemLabel"><strong>新密码</strong></span>
          <span class="uiIconText fbSettingsListItemEdit" style="padding-left: 23px;">
            <i style="top: -2px;" class="img sp_1qb0a3 sx_00805c"></i>
          </span>
          <span class="fbSettingsListItemContent fcg">
            <input type="password" id="newPasswd1" name="newPasswd1" class="inputtext DOMControl_placeholder" tipstype="error"/>
          </span>
        </div>
      </li>
      <li class="fbSettingsListItem clearfix uiListItem uiListLight uiListVerticalItemBorder">
        <div class="pvm phs fbSettingsListLink clearfix">
          <span class="pls fbSettingsListItemLabel"><strong>重复新密码</strong></span>
          <span class="uiIconText fbSettingsListItemEdit" style="padding-left: 23px;">
            <i style="top: -2px;" class="img sp_1qb0a3 sx_00805c"></i>
          </span>
          <span class="fbSettingsListItemContent fcg">
            <input type="password" id="newPasswd2" name="newPasswd2" class="inputtext DOMControl_placeholder" tipstype="error"/>
          </span>
        </div>
      </li>
      <li class="fbSettingsListItem clearfix uiListItem uiListLight uiListVerticalItemBorder openPanel">
        <div class="content">
          <div class="fbSettingsEditor">
              <div class="pbm fbSettingsEditorFields">
                <div class="mtm">
                  <label for="ue2q4d_3" id="ue2q4d_2" class="submit uiButton uiButtonConfirm">
                  	<input type="submit" id="ue2q4d_3"  value="保存更改"/>
                  </label>
                  <label for="ue2q4d_4" class="cancel uiButton">
                  	<input type="reset" id="ue2q4d_4" value="取消"/>
                  </label>
                </div>
              </div>
          </div>
        </div>
      </li>
    </ul>
    </form>
  </div>
</div>