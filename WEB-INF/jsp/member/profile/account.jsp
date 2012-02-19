<%@page contentType="textml;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<div role="main" id="contentArea">
  <div id="SettingsPage_Content">
    <ul class="uiList fbSettingsList">
     
      <li class="fbSettingsListItem clearfix uiListItem uiListLight uiListVerticalItemBorder">
		<a href="javacript:void(0);" class="pvm phs fbSettingsListLink clearfix">
			<span class="pls fbSettingsListItemLabel"><strong>用户名</strong></span>
			<span class="uiIconText fbSettingsListItemEdit" style="padding-left: 23px;">
				<i style="top: -2px;" class="img sp_1qb0a3 sx_00805c"></i>
			</span>
			<span class="fbSettingsListItemSaved hidden_elem">修改已保存。</span>
			<span class="fbSettingsListItemContent fcg"> <strong><s:property value="profile.username"/></strong></span>
		</a>
        <div class="content"></div>
      </li>
      <li class="fbSettingsListItem clearfix uiListItem uiListLight uiListVerticalItemBorder">
		<a href="javacript:void(0);" class="pvm phs fbSettingsListLink clearfix">
			<span class="pls fbSettingsListItemLabel"><strong>电子邮件</strong></span>
			<span class="uiIconText fbSettingsListItemEdit" style="padding-left: 23px;">
				<i style="top: -2px;" class="img sp_1qb0a3 sx_00805c"></i>
			</span>
			<span class="fbSettingsListItemSaved hidden_elem">修改已保存。</span>
			<span class="fbSettingsListItemContent fcg"><strong><s:property value="profile.email"/></strong> </span>
		</a>
        <div class="content">
      	  <div class="fbSettingsEditor uiBoxGray noborder">
            <form onsubmit="return Event.__inlineSubmit(this,event)" id="uilt2i_1" method="post" action="#" class="show_label" rel="async">
              <div class="mam fbSettingsEditorLabel"><strong>电子邮件</strong></div>
              <div class="pbm fbSettingsEditorFields">
                <div class="ptm">
                  <table class="uiInfoTable">
                    <tbody>
                      <tr class="fbSettingsAddEmail">
                        <td colspan="2">
                          <div>
                            <a id="uilt2i_6" name="new_email" href="#" class="hidden_elem">添加另一电子邮件</a>
                            <div id="uilt2i_7" class="">
                              <table class="uiInfoTable noBorder">
                                <tbody>
                                  <tr class="dataRow">
                                    <th class="label"><label for="uilt2i_5">新邮件：</label></th>
                                    <td class="data">
                        	           <input type="text" title="选填" value="选填" id="uilt2i_5" placeholder="选填" name="new_email" class="inputtext DOMControl_placeholder"/>
                                    </td>
                                  </tr>
                                </tbody>
                              </table>
                            </div>
                          </div>
                        </td>
                      </tr>
                      <tr class="spacer">
                        <td colspan="2"><hr/></td>
                      </tr>
                    </tbody>
                  </table>
                </div>
                <div class="mtm uiBoxGray topborder">
                  <div class="mtm">
                    <label for="uilt2i_10" id="uilt2i_2" class="submit uiButtonDisabled uiButton uiButtonConfirm">
                    <input type="submit" id="uilt2i_10" disabled="1" value="保存更改"/>
                    </label>
                    <label for="uilt2i_11" class="cancel uiButton">
                    <input type="button" id="uilt2i_11" value="取消"/>
                    </label>
                    <img height="11" width="16" alt="" src="https://s-static.ak.facebook.com/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="mas saveThrobber uiLoadingIndicatorAsync img"/></div>
                </div>
              </div>
            </form>
		  </div>		
        </div>
      </li>
      <li class="fbSettingsListItem clearfix uiListItem uiListLight uiListVerticalItemBorder openPanel">
		<a href="/settings?tab=account&amp;section=password" class="pvm phs fbSettingsListLink clearfix">
          <span class="pls fbSettingsListItemLabel"><strong>密码</strong></span>
          <span class="uiIconText fbSettingsListItemEdit" style="padding-left: 23px;">
          	<i style="top: -2px;" class="img sp_1qb0a3 sx_00805c"></i>编辑
          </span>
          <span class="fbSettingsListItemSaved hidden_elem">修改已保存。</span>
          <span class="fbSettingsListItemContent fcg">从未修改过密码。</span>
		</a>
        <div class="content">
          <div class="fbSettingsEditor uiBoxGray noborder">
            <form  id="ue2q4d_1" method="post" action="/usr/account!update.jhtml" class="show_label" rel="async">
              <input type="hidden" value="2c9ad650639fb8c34e3c8b399afb74ed" name="post_form_id" autocomplete="off"/>
              <input type="hidden" autocomplete="off" value="AQBOkcIK" name="fb_dtsg"/>
              <div class="mam fbSettingsEditorLabel"><strong>密码</strong></div>
              <div class="pbm fbSettingsEditorFields">
                <div class="ptm">
                  <table class="uiInfoTable noBorder">
                    <tbody>
                     
                     
                      <tr class="dataRow">
                        <th class="label"><label for="password_new">新密码：</label></th>
                        <td class="data"><input type="password" autocomplete="off" id="password_new" name="newpassword" class="inputtext"/></td>
                      </tr>
                      <tr>
                        <th class="label noLabel"></th>
                        <td class="data"><div id="password_new_status"> </div></td>
                      </tr>
                      <tr class="dataRow">
                        <th class="label"><label for="password_confirm">重新输入新密码：</label></th>
                        <td class="data"><input type="password" autocomplete="off" id="password_confirm" name="confirmpassword" class="inputtext"/></td>
                      </tr>
                      <tr>
                        <th class="label noLabel"></th>
                        <td class="data"><div id="password_confirm_status"> </div></td>
                      </tr>
                    </tbody>
                  </table>
                </div>
                <div class="mtm uiBoxGray topborder">
                  <div class="mtm">
                    <label for="ue2q4d_3" id="ue2q4d_2" class="submit uiButton uiButtonConfirm">
                    	<input type="submit" id="ue2q4d_3"  value="保存更改"/>
                    </label>
                    <label for="ue2q4d_4" class="cancel uiButton">
                    	<input type="button" id="ue2q4d_4" value="取消"/>
                    </label>
                    <img height="11" width="16" alt="" src="/images/GsNJNwuI-UM.gif" class="mas saveThrobber uiLoadingIndicatorAsync img"/>
                  </div>
                </div>
              </div>
            </form>
          </div>
        </div>
      </li>
    </ul>
  </div>
</div>