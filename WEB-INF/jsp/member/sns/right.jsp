<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<script type="text/javascript">
function sendFriendRequest(obj, userId) {

  $.ajax({
   type: "GET",
   url: "usr/request!addFriendRequest.jhtml",
   dataType: 'text',
   data: "to="+userId+"&content="+content,
   success: function(data){
     if ("true" == data) {
        var objParent = $(obj).parent();
        $(obj).fadeOut("fast");
        $(objParent).html("好友请求已经发送");
     }
   }
  });
}
</script>
<%@page contentType="text/html; charset=UTF-8"%>
    <div role="complementary" id="rightCol">
      <div class="home_right_column">
        <div class="rightColumnWrapper">
          <div data-referrer="pagelet_chbox" id="pagelet_chbox"></div>
          <div data-referrer="pagelet_ego_pane_w" id="pagelet_ego_pane_w">
            <div class="ego_column egoOrganicColumn">
              <div class="ego_section">
              <s:if test="profiles!=null">   
                <div class="uiHeader uiHeaderTopAndBottomBorder mbs uiSideHeader">
                 
                  <div class="clearfix uiHeaderTop">
                    <a href="#" class="uiHeaderActions rfloat">显示更多</a>
                    <div><h4 class="uiHeaderTitle">你可能认识的人</h4></div>
                  </div>
                 
                  
                </div>
                 </s:if>   
                <div class="phs">
                  
                  
                  <s:iterator value="profiles">
                  <div class="UIImageBlock clearfix ego_unit">
                    <a aria-hidden="true" tabindex="-1" data-gt='{"engagement":{"eng_type":"1","eng_src":"13","eng_tid":"1372884330","eng_data":{"ego_service":"pymk","ego_pos":"4"}}}' href="/profile/profile!viewProfileInfo.jhtml?userid=${userid}" class="UIImageBlock_Image UIImageBlock_SMALL_Image">
                      <img alt="" src="${avatar }" class="uiProfilePhoto uiProfilePhotoLarge img"/>
                    </a>
                    <div class="egoProfileTemplate UIImageBlock_Content UIImageBlock_SMALL_Content">
                      <a data-gt='{"engagement":{"eng_type":"1","eng_src":"13","eng_tid":"1372884330","eng_data":{"ego_service":"pymk","ego_pos":"4"}}}' href="/profile/profile!viewProfileInfo.jhtml?userid=${userid}" class="ego_title">${username }</a>
                      <div class="ego_action">
                        <a rel="async-post" onclick="sendFriendRequest(this, '${userid}')" style="padding-left: 18px;" class="uiIconText">
                          <i style="top: 2px;" class="img sp_6h8b4g sx_c4a0c4"></i>加为好友
                        </a>
                      </div>
                    </div>
                  </div>
           		</s:iterator>
           		
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>