<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="textml;charset=utf-8"%>

<div role="main" id="contentArea">
  <div class="uiHeader mhl uiHeaderPage">
    <div class="clearfix uiHeaderTop">
      <div class="uiHeaderActions rfloat">
        
      </div>
      <div>
        <h2 class="uiHeaderTitle"><i class="mhs img sp_4fkm6u sx_e93a7e"></i>创建相册</h2>
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
                  <div id="profile_pic_form">
                   
                    <s:form id="form_upload_profile_pic"  enctype="multipart/form-data" method="post" action="photo/photo!createAlbum.jhtml" class="profile_pic_upload">
                      <input type="hidden" value="28919a42cab825a462a76591f83e5fc1" name="post_form_id" autocomplete="off"/>
                      <input type="hidden" autocomplete="off" value="AQCjyPru" name="fb_dtsg"/>
                      相册名称：
                      <div class="pfileselector">
                        <input type="text" id="profile_picture_post_file" name="zyAlbum.albumname" />
                      </div>
                     
                      相册描述：
                      <div class="pfileselector">
                        <textarea id="event_saveEvent_detail" rows="2" cols="40" name="summary"></textarea>
                      </div>
                      
                       <div class="pfileselector">
                        <input type="submit"  name="upload" value="创建"/>
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

