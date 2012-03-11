<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="textml;charset=utf-8"%>
<script type="text/javascript" language="javascript" src="js/jquery.imgareaselect.js"></script>
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
    //img.src = getFullPath(obj);
    //验证上传文件格式是否正确  
    var pos = strSrc.lastIndexOf(".");  
    var lastname = strSrc.substring(pos, strSrc.length)  
    if (lastname.toLowerCase() != ".jpg" && lastname.toLowerCase() != ".png") {  
        $("#error").removeClass("hidden_elem");
        return false;  
      }
   $("#form_upload_profile_pic").submit();
   $("#profile_pic_form").addClass("hidden_elem");
   $("#profile_pic_upload_indicator").removeClass("profile_pic_display_none");
}

function submitPhotoCallback(imgSrc) {
  $("#orgPhoto").html(imgSrc);
  $("#preview").html(imgSrc);
  $("#profile_pic_form").removeClass("hidden_elem");
  $("#profile_pic_upload_indicator").addClass("profile_pic_display_none");
  initCropArea();
}

function deletePhotoAjax() {
  $.ajax({
    type: "post",
    url: "usr/upload!deletePhotoAjax.jhtml",
    success: function(data) {
      if (data == 2) {
         $("#orgPhoto > img").attr("src", "images/female.gif");
      } else {
        $("#orgPhoto > img").attr("src", "images/male.gif");
      }
      $('#dialog_1').addClass('hidden_elem');
    }
  });
}

function initCropArea() {
  $(".preview-wrapper").removeClass("hidden_elem");
  var w = $("#orgPhoto > img").width();
  var h = $("#orgPhoto > img").height();
  if (w<120 || h< 120) {
    afterCropAction();
    return false;
  } 
  
  if (w>=h && w>320) {
    $("#orgPhoto > img").width("320");
  } else if (h>=w && h>320) {
    $("#orgPhoto > img").height("320");
  }

  <c:choose>
  <c:when test="${empty faceCrop.centreX || empty faceCrop.centreY || empty faceCrop.width || empty faceCrop.height}">
    var face = false;
    var faceX = 0;
    var faceY = 0;
    var faceWidth = 0;
    var faceHeight = 0;
  </c:when>
  <c:otherwise>
    var face = true;
    var faceX = ${faceCrop.centreX} / 100;
    var faceY = ${faceCrop.centreY} / 100;
    var faceWidth = ${faceCrop.width} / 100 * w;
    var faceHeight = ${faceCrop.height} / 100 * h;
  </c:otherwise>
  </c:choose>
  
  faceWidth = Math.max(faceWidth, faceHeight);
  faceHeight = Math.max(faceWidth, faceHeight);

  var minH = 120 * (h/$("#orgPhoto > img").height());
  var minW = 120 * (w/$("#orgPhoto > img").width());
  
  var x1,x2,y1,y2;
  x1 = (w * faceX) - (faceWidth<minW ? minW/2 : faceWidth/2);
  y1 = (h * faceY) - (faceHeight<minH ? minH/2 : faceHeight/2);
  x2 = (w * faceX) + (faceWidth<minW ? minW/2 : faceWidth/2);
  y2 = (h * faceY) + (faceHeight<minH ? minH/2 : faceHeight/2);
  
  if (x1 < 0) {
    x1 = 0;
    x2 = minW;
  }
  if (x1 > (w-minW)) {
    x1 = w-minW;
    x2 = w;
  }
  if (y1 < 0) {
    y1 = 0;
    y2 = minH;
  }
  if (y1 > (h-minH)) {
    y1 = h-minH;
    y2 = h;
  }
  
  $("#orgPhoto > img").show();
  
  $('#orgPhoto > img').imgAreaSelect({
    fadeSpeed: 400,
    aspectRatio: "1:1",
    handles: "corners",
    imageHeight: h,
    imageWidth: w,
    minHeight: minH,
    minWidth: minW,
    x1: x1,
    y1: y1,
    x2: x2,
    y2: y2,
    onInit: function (img, selection) { 
      cropPhoto(img, selection);
      preview(img, selection, w, h);
    },
    onSelectEnd: function (img, selection) { 
      cropPhoto(img, selection); 
    },
    onSelectChange: function (img, selection) { 
      preview(img, selection, w, h); 
    }       
  });
  
  <c:if test="${!faceCrop.multi}">
    if (face) {
      submitCrop(null,x1,y1,x2,y2);
    }
  </c:if>
}

function cropPhoto(img, selection) {
  $("input[name='x1']").val(selection.x1);
  $("input[name='x2']").val(selection.x2);
  $("input[name='y1']").val(selection.y1);
  $("input[name='y2']").val(selection.y2);
}


function preview(img, selection, w, h) {
  var scaleX = selection.width / 200;
  var scaleY = selection.height / 200;
  
  $("#preview").css({
    width: Math.round(selection.width/scaleX) +"px",
    height: Math.round(selection.height/scaleY) +"px"
  });
  
  $("#preview > img").css({
    width: w/scaleX +"px",
    height: h/scaleY +"px",
    marginLeft: "-"+ Math.round(selection.x1/scaleX) +"px",
    marginTop: "-"+ Math.round(selection.y1/scaleY) +"px"
  }).show();    
}

function submitCrop(form,x1,y1,x2,y2) {
  if (form!=null) {
    x1 = form.x1.value;
    y1 = form.y1.value;
    x2 = form.x2.value;
    y2 = form.y2.value;
    
    $("#next_button label").addClass("uiButtonDisabled");
  }
  $.post("usr/upload!cropPhotoAjax.jhtml",{
    x1: x1,
    y1: y1,
    x2: x2,
    y2: y2
  },function(data) {
    if (form!=null && data=='success') {
      afterCropAction();
    } else {
      if (form!=null) {
        $("#next_button label").removeClass("uiButtonDisabled");
        $.facebox("<div class='alert error'>上传头像失败, 请重新上传！</div>")
      }
    }
  }, "text");
  
  return false;
}

function afterCropAction() {
  location.href = "usr/update!basic.jhtml?profileform.pageIndex=2";
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
    <div id="editProfileForm">
      <iframe class="UIComposer_Upload_Iframe" name="profile_pic_iframe"></iframe>
      <input type="hidden" name="profileform.pageIndex" value="2"/>
      <table style="border-collapse:collapse;height:210px;" class="center">
        <tbody>
          <tr>
            <td>
              <div id="orgPhoto" class="crop-picture">
              	<s:if test="#session.userlogo!=null">   
                <img src="<s:property value="#session.userlogo"/>" />
                </s:if>   
                <s:else>
                <img src="images/DEFAULT.JPG" id="profile_pic" />
                </s:else>
              </div>
              
              <div id="remove_profile_picture_link" class="thumbnail_action">
                <a rel="dialog" href="#" onclick="$('#dialog_1').removeClass('hidden_elem'); return false;">删除你的图像</a>
              </div>
              <s:form onsubmit="return submitCrop(this);" action="usr/update!basic.jhtml?profileform.pageIndex=2" id="cropPhotoForm">
              <input type="hidden" name="x1" value="0"/>
              <input type="hidden" name="y1" value="0"/>
              <input type="hidden" name="x2" value="120"/>
              <input type="hidden" name="y2" value="120"/>
              <div id="next_button" class="thumbnail_action">
                <label class="uiButton uiButtonConfirm" for="u2urlx_7">
		           <input type="submit" value="下一步" id="u2urlx_7" />
		        </label>
              </div>
              </s:form>
            </td>
            <td>
              <div class="preview-wrapper hidden_elem">
                <div id="preview" style="width: 200px; height: 200px;"></div>
              </div>
              <div class="profile_pic_new">
                <div class="profile_pic_upload">
                  <div id="profile_pic_form">从计算机中选择上传一张图片文件：
                    <div class="UIMessageBox UIMessageBoxError hidden_elem" id="error">
                      <p>您输入的图片不符合要求。图片要求小于2M，格式为.jpg或者.png。</p>
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
                    <img height="32" width="32" alt="" src="images/jKEcVPZFk-2.gif" class="img"/>
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