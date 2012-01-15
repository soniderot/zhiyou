<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>

<div class="generic_dialog pop_dialog profileBrowserDialog full_bleed generic_dialog_fixed_overflow" id="dialog_notice" style="">
  <div class="generic_dialog_popup" style="top: 40px; width: 577px;">
    <div class="pop_container_advanced">
      <div id="pop_content" class="pop_content" tabindex="0" role="alertdialog">
        <h2 class="dialog_title"><span>分享</span></h2>
        <div class="dialog_content">
          <div class="dialog_summary hidden_elem"></div>
          <div class="dialog_body">
            <div class='pam uiBoxYellow noborder'>这个已经成功发布到你的动态主页</div>
          </div>
          <div class="dialog_buttons clearfix">
            <div class="dialog_buttons_msg"></div>
            <div>
              <label class="uiButton uiButtonLarge uiButtonConfirm inputsubmit">
                <input type='button' name='ok' value='关闭' onclick="removePopup('dialog_notice')"/>
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
function removePopup(dialog) {
  $("#" + dialog).remove();
}
</script>