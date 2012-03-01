<%@page pageEncoding="utf-8"%>
<script type="text/javascript">
function hideGrpPopup(dialog) {
  $("#" + dialog).addClass("hidden_elem");
  $("#" + dialog).hide();
}
function showGrpPopup(dialog) {
  $("#" + dialog).removeClass("hidden_elem");
  $("#" + dialog).show();
  return false;
}

function deleteGroup(groupId) {
  location.href="sns/sns!deleteSnsGroup.jhtml?snsGroupId=" + groupId;
}

</script>

<div class="generic_dialog pop_dialog generic_dialog_fixed_overflow hidden_elem" id="dialog_delete_grp" style="">
  <div class="generic_dialog_popup" style="top: 40px;">
    <div class="pop_container_advanced">
      <div id="pop_content" class="pop_content">
        <h2 class="dialog_title" id="title_dialog_0"><span>删除<s:property value="friendGroup.groupname"/> ？</span></h2>
        <div class="dialog_content">
          <div class="dialog_summary hidden_elem"></div>
          <div class="dialog_body">
            <div>删除朋友分组后:
              <ul class="uiList pam uiListBulleted">
                <li class="ptm uiListVerticalItemBorder">
                  <div class="fcb">删除清单将无法恢复，不过，你可以建立新的清单，加入同一群朋友。</div>
                </li>
              </ul>
            </div>
          </div>
          <div class="dialog_buttons clearfix">
            <div class="dialog_buttons_msg"></div>
            <div>
              <label class="uiButton uiButtonLarge uiButtonConfirm">
              <input type="button" name="confirm" value="确认" onclick="deleteGroup(<s:property value='friendGroup.id'/>)"/>
              </label>
              <label class="uiButton uiButtonLarge">
              <input type="button" name="cancel" value="取消" onclick="hideGrpPopup('dialog_delete_grp')"/>
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