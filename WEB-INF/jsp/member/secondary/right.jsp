<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
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

<div id="rightCol" role="complementary">
  <div id="pagelet_right_sidebar" data-referrer="pagelet_right_sidebar">
    <div id="pagelet_contextual_help" data-referrer="pagelet_contextual_help"></div>
    <div id="pagelet_ego_pane" data-referrer="pagelet_ego_pane">
      <div class="ego_column egoOrganicColumn">
        <div class="ego_section">
          <div class="uiHeader uiHeaderTopAndBottomBorder mbs uiSideHeader">
            <div class="clearfix uiHeaderTop">
            	<a class="uiHeaderActions rfloat" href="/usr/landing.jhtml">显示全部</a>
              <div>
                <h4 class="uiHeaderTitle">你可能认识的人</h4>
              </div>
            </div>
          </div>
          <div class="phs">
            <s:iterator value="profiles" status='st'>
            	<s:if test="#st.getCount()<=10"> 
            <div class="UIImageBlock clearfix ego_unit">
            	<a class="UIImageBlock_Image UIImageBlock_SMALL_Image" href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="userid"/>" tabindex="-1" aria-hidden="true">
            		<img class="uiProfilePhoto uiProfilePhotoLarge img" src="<s:property value="avatar"/>" alt="">
            	</a>
              <div class="egoProfileTemplate UIImageBlock_Content UIImageBlock_SMALL_Content">
              	<!--
              	<a class="ego_x uiCloseButton uiCloseButtonSmall" rel="async-post" href="#" title="删除"></a>
              	-->
              	<a class="ego_title" href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="userid"/>"><s:property value="username"/></a>
                <div class="ego_action">
                	 <s:if test="requestOutFlag==true">   
                        	好友请求已发送
                        </s:if>   
                        
                         <s:elseif test="requestInFlag==true">   
                         	好友请求已收到
                        </s:elseif> 
                        <s:else>
                        <a rel="async-post" onclick="sendFriendRequest(this, '${userid}')" style="padding-left: 18px;" class="uiIconText">
                          <i style="top: 2px;" class="img sp_6h8b4g sx_c4a0c4"></i>加为好友
                        </a>
                      </s:else>
                </div>
              </div>
            </div>
             </s:if> 
            </s:iterator>
          </div>
        </div>
      </div>
      
      <span id="egoRefreshAds"></span>
      <span>
      	<span class="muffin_tracking_pixel_start"></span>
      	<iframe width="0" scrolling="no" height="0" frameborder="0" src="/ai.php?aed=AQIbYh2eblo5ugQM1-cn21ge7BPCSraG8_ao2YXA-iHUjn7A-4vtUL548VKq8nl2ZgiqYiLRUIWS8oisqzfKRQjdYiRUWBaq6kTXwmT-YUjxT0ISvRlyZm6PwWecq2tM2hVubkMxJ1oizrUQ811PaKwBAteAklQTmu8AjbTiOO3Q33seeZbP3gtTXF24hrLW7PCK4BuRCZ1XP0sca0-L42CiAreqI2Uzj7R7jr6nHSQztqdffK0qgZ6GJKQsepg-FeylFIjKqD7WjCWPHRA4QM4iieN4BToWEFSymMI4D5Tb_XaFl4IVMm9enrcN4t4OWutbm5rp0nkNFRoqtFaHMtEXlDU4fqtUc397kxh6DREPylkFtNk1pNlMuq12NE5fN8Y6L-PTNjKlte-VJdMRG26KvkBbAV1Zh8Q_ECWWHnCVa_JyAKux_ia0JkoF0454bTgSpoZNeeLj5vMnmYRBQh74UiIHYTTUuXj-dreJ3SgZNfS1gsX6HRoPONeXAnmWNjOjezdZKbZzKmA10X50uDiCE7iVcbcJN8biqFcV7ZCE00b1pQxXdyKUyVmtYPbgaAFYJmqUAdKFuBJv0AYhzGPP9d7q2kb11T6zI0YtbdIGIJcgP_0viLqZkw0-C8yxn98mXjlGLy6Bfwx7jJLgjSO36oQUhvT6RRrEP5yoqOLvosJ1-1mFFKa-OCyuNWuYqwrdQjCcbEM-mG338MFEBpfNAezYFfvq7NUZwlzJlH235Cy8le8Z9cqbV7sxCT6jfR5h_WPdJGpm7XODefzbdnAHBNxbynN_obQIskRfjccPdvW_14Q6tVvai4XkZy4R8Nsph8tLycqip7bZG4Rkjq6AvtPEgrxn8g_7x2x1nmqX-__3wnHanCFnENFFKEC2rahlqUealeg2Yn_NdkbjBML6rdQjTNlS84B0htsD2jbZng2bFy8pqByPAxbXT2X4q2-6skU9mQ4tHcy5fpsjs-7Q" class="fbEmuTracking"></iframe>
      	<span class="muffin_tracking_pixel_end"></span>
      </span>
    </div>
  </div>
</div>