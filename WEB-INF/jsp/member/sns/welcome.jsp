  <%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
 				<div role="main" id="contentArea">
 				
						<div data-referrer="pagelet_welcome" id="pagelet_welcome">
							<div class="uiHeader uiHeaderWithImage uiHeaderBottomBorder uiHeaderPage">
								<div class="clearfix uiHeaderTop">
									<div class="uiHeaderActions rfloat"></div>
									<div>
										<h2 class="uiHeaderTitle">
											<i class="uiHeaderImage img sp_enac13 sx_89179c"></i><s:property value="#session.user.username"/>，欢迎造访 知友，
										</h2>
									</div>
								</div>
							</div>
							<ul id="welcome_dashboard">
							<s:if test="(#session.user.avatar==null)||(#session.user.avatar=='/images/default.JPG')"> 
								<li class="clearfix step">
								  <h3 class="step_indicator">1</h3>
								  <div class="welcome_task welcomeTaskProfilePic">
								    <h3>上传个人头像</h3>
								    <div class="clearfix NUXUploadPic">
								      <div class="lfloat"><img src="../../images/nuxwizard_profile_picture.gif" id="profile_pic_nux"/></div>
								      <div class="options_container">
								        <div class="options">
								          <div class="desc"><input type="file" name="pic" id="profile_picture_post_file" class="inputfile"/></div>
								        </div>
								      </div>
								    </div>
								  </div>
								</li>
							 </s:if>   	
								<li class="clearfix step last">
								
								<s:if test="(#session.user.avatar==null)||(#session.user.avatar=='/images/default.JPG')"> 
								  <h3 class="step_indicator active_step">2</h3>
								   </s:if>   	
								   <s:else>   
								    <h3 class="step_indicator active_step">1</h3>
								    </s:else>
								  <div class="welcome_task">
								    <h3><a href="find-friends/browser/?ref=wd">加你认识的人</a></h3>
								    
								    
								    <div class="welcome_description">
								      <form onsubmit="return Event.__inlineSubmit(this,event)" id="ukwlm4_3" method="post" action="/ajax/growth/friend_browser/checkbox.php" class="friendBrowserForm" rel="async">
								        <div>
								        	<img height="32" width="32" alt="" src="<s:property value="#session.user.avatar"/>" class="hidden_elem friendBrowsingCheckboxContentLoadingIndicator img"/>
								          <div class="friendBrowserCheckboxResults">
								            <div class="friendBrowserCheckboxContentGrid">
								              <ul class="uiList">
								               
								                
								              
								                
								                <s:iterator value="profiles">
								                <li class="pvm friendBrowserListUnit uiListItem uiListLight uiListVerticalItemBorder">
								                  <div class="UIImageBlock clearfix">
								                  	<a aria-hidden="true" tabindex="-1" href="http://www.facebook.com/profile.php?id=1649024971&amp;ref=pymk" class="UIImageBlock_Image UIImageBlock_MED_Image">
								                    <div class="friendBrowserPhotoWrapper">
								                      <div class="friendBrowserPhotoCrop">
								                      	<img style="left: -24px;" alt="" src="${avatar }" class="fbProfileLargePortraitImgScaleHeight img"/>
								                      </div>
								                    </div>
								                    </a>
								                    <div class="UIImageBlock_Ext">
								                      <div id="friend_browser_unit_1649024971" class="friendBrowserUnit friendBrowserAuxAlignMiddle">
								                        <input type="hidden" value="1649024971" name="friend_browser_id[]" class="friendBrowserID" autocomplete="off"/>
								                        <div id="friendBrowserActionId_1649024971" class="friendBrowserAddAsFriend stat_elem">
								                          <div id="ukwnh2_12" class="FriendButton">
								                            <label for="ukwnh2_13" class="FriendRequestAdd addButton uiButton">
								                            	<i class="mrs img sp_9bp6bo sx_35b899"></i>
								                            	<input type="button" id="ukwnh2_13" value="加为好友"/>
								                            </label>
								                            <a data-flloc="friend_browser_wd" data-profileid="1649024971" href="#" role="button" class="FriendRequestOutgoing enableFriendListFlyout hidden_elem outgoingButton uiButton">
								                            	<i class="mrs img sp_9bp6bo sx_35b899"></i>
								                            	<span class="uiButtonText">朋友请求已传送。</span>
								                            </a>
								                          </div>
								                        </div>
								                      </div>
								                    </div>
								                    <div class="friendBrowserContentAlignMiddle UIImageBlock_Content UIImageBlock_MED_Content">
								                      <div class="fsl fwb fcb">
								                      	<a data-hovercard="/ajax/hovercard/hovercard.php?id=1649024971" data-gt='{"engagement":{"eng_type":"1","eng_src":"1","eng_tid":"1649024971","eng_data":[]}}' href="http://www.facebook.com/profile.php?id=1649024971&amp;ref=pymk">${username }</a>
								                      </div>
								                      
								                      <div class="fsm fwn fcg">
								                        <div class="friendBrowserMarginTopTiny">
								                          <div>共同朋友 <a href="http://www.facebook.com/profile.php?id=100002966365120">Flora Tang</a> 。</div>
								                        </div>
								                      </div>
								                    </div>
								                  </div>
								                </li>
								                </s:iterator>
								                
								                <li class="ptm uiListItem uiListLight uiListVerticalItemBorder"></li>
								              </ul>
								            </div>
								            <div class="friendBrowserCheckboxContentPager">
								              <div class="clearfix uiMorePager stat_elem friendBrowserMorePager uiMorePagerCenter">
								               <jsp:include page="/WEB-INF/jsp/common/pagination.jsp" flush="true" />
								               
								            </div>
								          </div>
								        </div>
							
								      </form>
								    </div>
								  </div>
								</li>
							</ul>
						</div>
					</div>
					
		<script>
function topage(pageNo) {
	location.href = "/usr/landing.jhtml?pageNo="+pageNo
	return false;
}
</script>			
					