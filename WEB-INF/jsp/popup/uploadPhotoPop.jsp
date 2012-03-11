<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>

<div class="generic_dialog pop_dialog profileBrowserDialog full_bleed generic_dialog_fixed_overflow hidden_elem" id="dialog_uploadPhoto" style="">
  <div class="generic_dialog_popup" style="top: 40px; width: 577px;">
    <div class="pop_container_advanced">
      <div id="pop_content" class="pop_content">
        <h2 class="dialog_title" id="title_dialog_0"><span>上传图片</span></h2>
        <div class="dialog_content">
          <div class="dialog_summary hidden_elem"></div>
          <div>
            <div id="uawg93_1" class="fbProfileBrowser">
              <div class="eventInviteLayout">
                <div class="pam filterBox uiBoxGray topborder">
                  <s:form id="uploadPhotoForm"  method="post" action="usr/feed!uploadEventPhoto.jhtml?feedId=%{event.Id}" enctype="multipart/form-data">
                    <input type="hidden" name="eventId"  value="<s:property value="event.Id"/>" />
                    <div id="u3mxyl_6" class="uiMetaComposerMessageBox uiComposerMessageBoxMentions">
                      <table>
                        <tbody>
                        	<!--
                          <tr>
                            <td>
                              <label for="emails">描述：</label>
                            </td>
                            <td class="fullWidth">
                              <div class="uiTypeahead uiClearableTypeahead fbProfileBrowserTypeahead" id="uawg93_3">
                                <div class="wrap">
                                  <div class="innerWrap">
                                    <input type="text" class="inputtext textInput DOMControl_placeholder" placeholder="发表点看法吧..." title="发表点看法吧..." name="feedmessage"/>
                                  </div>
                                </div>
                              </div>
                            </td>
                          </tr>-->
                          <tr>
                            <td>
                              <label for="emails">图片：</label>
                            </td>
                            <td class="fullWidth">
                              <div class="webComposerPhotoInputArea">
                                <div class="mbs photoUploadPrompt fwb">从你的电脑上选择一个图像。</div>
                                <input type="file" name="feedphoto" onchange="enableSubmitBtn(this)" />
                              </div>
                            </td>
                          </tr>
                        </tbody>
                      </table>
                    </div>
                  </s:form>
                </div>
              </div>
            </div>
          </div>
          <div class="dialog_buttons clearfix">
            <div class="dialog_buttons_msg"></div>
            <div>
              <label class="uiButton uiButtonLarge uiButtonConfirm inputsubmit uiButtonDisabled">
              <input type="button" name="uploadBtn" value="保存" onclick="uploadPhoto()"/>
              </label>
              <label class="uiButton uiButtonLarge uiButtonConfirm inputsubmit">
              <input type="button" name="uploadBtn" value="取消" onclick="hidePop('dialog_uploadPhoto')"/>
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
function checkInput() {
  var photoName = $("input[name='feedphoto']").val();
  var i = photoName.lastIndexOf(".");
  if (i == -1) {
    return false;
  }
  var suffix = photoName.substring(i);
  if (".jpg" != suffix && ".png" != suffix ) {
    return false;
  }
  var photoDesc = $("input[name='feedmessage']").val();
  var holder = $("input[name='feedmessage']").attr("placeholder");
  if (photoDesc == holder) {
    $("input[name='feedmessage']").val("");
  }
  return true;
}
function showPopup(dialog) {
  $("#" + dialog).removeClass("hidden_elem");
  return false;
}
function hidePop(dialog) {
  $("#" + dialog).addClass("hidden_elem");
  return false;
}
function uploadPhoto() {
  $("form:last").submit();
}
function enableSubmitBtn(obj) {
	var strSrc = $(obj).val();
    img = new Image();  
    //img.src = getFullPath(obj);
    //验证上传文件格式是否正确  
    var pos = strSrc.lastIndexOf(".");  
    var lastname = strSrc.substring(pos, strSrc.length);
    if (lastname.toLowerCase() != ".jpg" && lastname.toLowerCase() != ".png") {  
  		alert('您输入的图片不符合要求。图片要求小于2M，格式为.jpg或者.png。');
        return false;  
      }
  $("input[name='uploadBtn']").parent().removeClass("uiButtonDisabled");
}
</script>