<%@page contentType="textml;charset=utf-8"%>
<div role="main" id="contentArea">
  <div class="uiHeader mhl uiHeaderPage">
    <div class="clearfix uiHeaderTop">
      <div class="uiHeaderActions rfloat">
        <a href="http://www.facebook.com/mkk158?ref=profile&amp;v=info" role="button" class="uiButton">
          <i class="mrs img sp_ah6icc sx_2efcc5"></i>
          <span class="uiButtonText">查看个人主页</span>
        </a>
        <a href="http://www.facebook.com/mkk158?viewas=100000686899395" role="button" class="uiButton">
          <span class="uiButtonText">以朋友身份查看…</span>
        </a>
      </div>
      <div>
        <h2 class="uiHeaderTitle">ま か<i class="mhs img sp_4fkm6u sx_e93a7e"></i>编辑个人主页</h2>
      </div>
    </div>
  </div>
  <div class="pal grayArea uiBoxGray noborder">
    <div data-referrer="editProfileForm" id="editProfileForm">
      <iframe class="UIComposer_Upload_Iframe" name="profile_pic_iframe" src="http://static.ak.facebook.com/common/redirectiframe.html"></iframe>
      <table style="border-collapse: collapse;" class="center">
        <tbody>
          <tr>
            <td>
              <div class="profile-picture">
                <img src="http://profile.ak.fbcdn.net/hprofile-ak-ash2/370142_1438697558_1584603112_n.jpg" id="profile_pic"/>
              </div>
              <div id="edit_thumbnail_link" class="thumbnail_action">
                <a rel="dialog" href="/ajax/profile/picture/square.php?id=1438697558&amp;target=profile_pic_iframe">编辑缩略图</a>
              </div>
              <div id="remove_profile_picture_link" class="thumbnail_action">
                <a rel="dialog" href="/ajax/profile/picture/remove.php?id=1438697558">删除你的图像</a>
              </div>
            </td>
            <td>
              <div class="profile_pic_new">
                <div class="profile_pic_upload">
                  <div id="profile_pic_form">从计算机中选择上传一张图片文件（最大 4MB）：
                    <form onsubmit="return Event.__inlineSubmit(this,event)" target="profile_pic_iframe" enctype="multipart/form-data" id="form_upload_profile_pic" method="post" action="http://upload.facebook.com/pic_upload.php" class="profile_pic_upload">
                      <input type="hidden" value="28919a42cab825a462a76591f83e5fc1" name="post_form_id" autocomplete="off"/>
                      <input type="hidden" autocomplete="off" value="AQCjyPru" name="fb_dtsg"/>
                      <input type="hidden" value="1438697558" name="id"/>
                      <input type="hidden" value="28919a42cab825a462a76591f83e5fc1" name="post_form_id"/>
                      <input type="hidden" value="profile" name="type"/>
                      <input type="hidden" value="/ajax/profile/picture/upload_iframe.php?pic_type=1&amp;id=1438697558" name="return"/>
                      <div class="pfileselector">
                        <input type="file" onchange="ProfilePicUploader.submitToIframe(); return false;" id="profile_picture_post_file" name="pic"/>
                      </div>
                    </form>
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