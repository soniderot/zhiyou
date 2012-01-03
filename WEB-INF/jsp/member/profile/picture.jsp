<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="textml;charset=utf-8"%>
<script type="text/javascript">

function getFullPath(obj) { 
  if (obj) {
      //ie
      if (window.navigator.userAgent.indexOf("MSIE") >= 1) {
          obj.select();
          return document.selection.createRange().text;
      }
      //firefox  
      else if (window.navigator.userAgent.indexOf("Firefox") >= 1) {  
         if (obj.files) {
             return obj.files.item(0).getAsDataURL();  
         }
         return obj.value;  
     }
     return obj.value;  
  }
}

function submitPhotoToIframe(obj) {
    $("#error").addClass("hidden_elem");
    var strSrc = $(obj).val();
    img = new Image();  
    img.src = getFullPath(obj);
    //验证上传文件格式是否正确  
    var pos = strSrc.lastIndexOf(".");  
    var lastname = strSrc.substring(pos, strSrc.length)  
    if (lastname.toLowerCase() != ".jpg" && lastname.toLowerCase() != ".png"
      || img.fileSize / 1024 > 2000) {  
        $("#error").removeClass("hidden_elem");
        return false;  
      }
   $("#form_upload_profile_pic").submit();
   $("#profile_pic_form").addClass("hidden_elem");
   $("#profile_pic_upload_indicator").removeClass("profile_pic_display_none");
}

function submitPhotoCallback(imgSrc) {
  $("#profile_pic").attr("src", imgSrc);
  $("#profile_pic_form").removeClass("hidden_elem");
  $("#profile_pic_upload_indicator").addClass("profile_pic_display_none");
}

function deletePhotoAjax() {
  $.ajax({
    type: "post",
    url: "usr/upload!deletePhotoAjax.jhtml",
    success: function(data) {
      if (data == 2) {
         $("#profile_pic").attr("src", "images/female.gif");
      } else {
        $("#profile_pic").attr("src", "images/male.gif");
      }
      $('#dialog_1').addClass('hidden_elem');
    }
  });
}
</script>
<div role="main" id="contentArea">
  <div class="uiHeader mhl uiHeaderPage">
    <div class="clearfix uiHeaderTop">
      <div class="uiHeaderActions rfloat">
      	<!---
        <a href="http://www.facebook.com/mkk158?ref=profile&amp;v=info" role="button" class="uiButton">
          <i class="mrs img sp_ah6icc sx_2efcc5"></i>
          <span class="uiButtonText">查看个人主页</span>
        </a>
        <a href="http://www.facebook.com/mkk158?viewas=100000686899395" role="button" class="uiButton">
          <span class="uiButtonText">以朋友身份查看…</span>
        </a>-->
      </div>
      <div>
        <h2 class="uiHeaderTitle"><s:property value="#session.user.username"/><i class="mhs img sp_4fkm6u sx_e93a7e"></i>编辑个人主页</h2>
      </div>
    </div>
  </div>
  <div class="pal grayArea uiBoxGray noborder">
    <div data-referrer="editProfileForm" id="editProfileForm">
      <iframe class="UIComposer_Upload_Iframe" name="profile_pic_iframe"></iframe>
      <input type="hidden" name="profileform.pageIndex" value="2"/>
      <table style="border-collapse:collapse;height:210px;" class="center">
        <tbody>
          <tr>
            <td>
              <div class="profile-picture">
                <img src="http://profile.ak.fbcdn.net/hprofile-ak-ash2/370142_1438697558_1584603112_n.jpg" id="profile_pic"/>
              </div>
              <div id="remove_profile_picture_link" class="thumbnail_action">
                <a rel="dialog" href="#" onclick="$('#dialog_1').removeClass('hidden_elem'); return false;">删除你的图像</a>
              </div>
              <div id="remove_profile_picture_link" class="thumbnail_action">
                <label class="uiButton uiButtonConfirm" for="u2urlx_7">
		           <input type="button" value="下一步" id="u2urlx_7" onclick="location.href='usr/update!basic.jhtml?profileform.pageIndex=2'" />
		        </label>
              </div>
            </td>
            <td>
              <div class="profile_pic_new">
                <div class="profile_pic_upload">
                  <div id="profile_pic_form">从计算机中选择上传一张图片文件：
                    <div class="UIMessageBox UIMessageBoxError hidden_elem" id="error">
                      <p>您输入的图片不符合要求。图片要求小于2M，格式为.jpg或者.pgn。</p>
                    </div>
                    <s:form id="form_upload_profile_pic" target="profile_pic_iframe" enctype="multipart/form-data" method="post" action="usr/upload!uploadPhotoAjax.jhtml" class="profile_pic_upload">
                      <input type="hidden" value="28919a42cab825a462a76591f83e5fc1" name="post_form_id" autocomplete="off"/>
                      <input type="hidden" autocomplete="off" value="AQCjyPru" name="fb_dtsg"/>
                      <div class="pfileselector">
                        <input type="file" id="profile_picture_post_file" name="logo" onchange="submitPhotoToIframe(this)"/>
                      </div>
                    </s:form>
                  </div>
                  <div id="profile_pic_upload_indicator" class="profile_pic_display_none">
                    <img height="32" width="32" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/y9/r/jKEcVPZFk-2.gif" class="img"/>
                    <div class="load_message">正在上传图片</div>
                  </div>
                </div>
                
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</div>

<div class="generic_dialog pop_dialog hidden_elem" id="dialog_1" style="">
  <div class="generic_dialog_popup" style="top: 68.5px;">
    <div class="pop_container_advanced">
      <div id="pop_content" class="pop_content" tabindex="0" role="alertdialog">
        <h2 class="dialog_title" id="title_dialog_1"><span>删除照片？</span></h2>
        <div class="dialog_content">
          <div class="dialog_summary hidden_elem"></div>
          <div class="dialog_body">你确定要删除这张照片么？</div>
          <div class="dialog_buttons clearfix">
            <div class="dialog_buttons_msg"></div>
            <div>
              <label class="uiButton uiButtonLarge uiButtonConfirm">
              <input type="button" name="ok" value="确定" onclick="deletePhotoAjax()" />
              </label>
              <label class="uiButton uiButtonLarge">
              <input type="button" name="cancel" value="取消" onclick="$('#dialog_1').addClass('hidden_elem')" />
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