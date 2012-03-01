<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>

<div class="generic_dialog pop_dialog generic_dialog_fixed_overflow" id="dialog_0" style="">
  <div class="generic_dialog_popup" style="top: 40px;">
    <div class="pop_container_advanced">
      <div id="pop_content" class="pop_content" tabindex="0" role="alertdialog">
        <h2 class="dialog_title" id="title_dialog_0"><span>创建分组</span></h2>
        <div class="dialog_content">
          <div class="dialog_summary hidden_elem"/>
          <div class="dialog_body">
            <div class="mam">
              <!--div>建立一个朋友名单，只要在一个地方，你可以方便地和他们分享你的消息，和他们保持联系。</div-->
              <table class="uiInfoTable mvl noBorder">
                <tbody>
                  <tr class="dataRow">
                    <th class="label"><label for="createListname">分组名称：</label></th>
                    <td class="data"><input type="text" id="createListname" name="snsGroupname" maxlength="80" class="inputtext"/></td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
          <div class="dialog_buttons clearfix">
            <div class="dialog_buttons_msg"/>
            <div>
              <label class="uiButton uiButtonLarge uiButtonConfirm">
              <input type="button" name="submit" value="创建"/>
              </label>
              <label class="uiButton uiButtonLarge">
              <input type="button" name="cancel" value="取消"/>
              </label>
            </div>
          </div>
          <div class="dialog_footer hidden_elem"/>
        </div>
        <div class="dialog_loading">加载中...</div>
      </div>
    </div>
  </div>
</div>