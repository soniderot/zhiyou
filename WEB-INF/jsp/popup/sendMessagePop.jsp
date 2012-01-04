<%@page pageEncoding="utf-8"%>
<script>

function sendMessage() {

  $(".dialog_body").hide();
  $(".dialog_buttons").hide();
  $(".dialog_buttons div").hide();
  $(".dialog_loading").show();
  var to = $("#userid").val();
  var content = $("input[id=content]").val();
  $.ajax({
   type: "GET",
   url: "usr/message!sendMessageAjax.jhtml",
   dataType: 'text',
   data: "receiverId="+to+"&message="+content,
   success: function(data){
      hidePopup("dialog_send_msg");
      $("#div_" + to).find("label").addClass("hidden_elem");
      $("#div_" + to).find("a").removeClass("hidden_elem");
   }
  });
}
</script>


<div class="generic_dialog pop_dialog confirm_dialog generic_dialog_modal generic_dialog_fixed_overflow hidden_elem" id="dialog_send_msg">
  <div class="generic_dialog_popup" style="top: 40px;">
    <div class="pop_container_advanced">
      <div id="pop_content" class="pop_content" tabindex="0" role="alertdialog">
        <h2 class="dialog_title" id="title_dialog_1"><span>发送信息</span></h2>
        <div class="dialog_content">
          <div class="dialog_summary hidden_elem"></div>
          <div class="dialog_body">
            <div class="editAlbumDialog">
              <form action="#">
                <input type="hidden" name="userid" id="userid" />
                <table class="uiInfoTable noBorder">
                  <tbody>
                    <tr class="dataRow">
                      <th class="label">信息内容：</th>
                      <td class="data">
                        <input type="text" id="content" class="inputtext textInput requesttext" placeholder="" value="Hi" />
                      </td>
                    </tr>
                  </tbody>
                </table>
                <input type="hidden" value="1322475413" name="session_id" autocomplete="off"/>
              </form>
            </div>
          </div>
          <div class="dialog_buttons clearfix">
            <div>
              <label class="uiButton uiButtonLarge uiButtonConfirm">
                <input type="button" name="submit" value="发送" onclick="sendMessage()" />
              </label>
              <label class="uiButton uiButtonLarge">
                <input type="button" name="cancel" value="取消" onclick="hidePopup('dialog_send_msg')"/>
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