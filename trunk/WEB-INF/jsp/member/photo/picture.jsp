<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="textml;charset=utf-8"%>

<div role="main" id="contentArea">
  <div class="uiHeader mhl uiHeaderPage">
    <div class="clearfix uiHeaderTop">
      <div class="uiHeaderActions rfloat">
        
      </div>
      <div>
        <h2 class="uiHeaderTitle"><i class="mhs img sp_4fkm6u sx_e93a7e"></i>上传照片</h2>
      </div>
    </div>
  </div>
  <div class="pal grayArea uiBoxGray noborder">
    <div data-referrer="editProfileForm" id="editProfileForm">
      <iframe class="UIComposer_Upload_Iframe" name="profile_pic_iframe"></iframe>
      <table style="border-collapse:collapse;height:210px;" class="center">
        <tbody>
          <tr>
           
            <td>
              <div class="profile_pic_new">
                <div class="profile_pic_upload">
                  <div id="profile_pic_form">从计算机中选择上传一张图片文件：
                    <div class="UIMessageBox UIMessageBoxError hidden_elem" id="error">
                      <p>您输入的图片不符合要求。图片要求小于2M，格式为.jpg或者.pgn。</p>
                    </div>
                    <s:form id="form_upload_profile_pic"  enctype="multipart/form-data" method="post" action="photo/photo!uploadPhoto.jhtml" class="profile_pic_upload">
                      <input type="hidden" value="28919a42cab825a462a76591f83e5fc1" name="post_form_id" autocomplete="off"/>
                      <input type="hidden" autocomplete="off" value="AQCjyPru" name="fb_dtsg"/>
                      <div class="pfileselector">
                        <input type="file" id="profile_picture_post_file" name="photo" />
                      </div>
                      照片描述：
                      <div class="pfileselector">
                        <textarea id="event_saveEvent_detail" rows="2" cols="40" name="summary"></textarea>
                      </div>
                      选择相册：
                      <div class="pfileselector">
                        <s:select name="albumId" list="albums" listKey="id"  listValue="albumname" />
                      </div>
                       <div class="pfileselector">
                        <input type="submit"  name="upload" value="上传"/>
                      </div>
                    </s:form>
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

