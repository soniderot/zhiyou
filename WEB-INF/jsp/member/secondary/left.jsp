<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<div id="leftCol">
					  <div data-referrer="pagelet_left_column" id="pagelet_left_column">
					    <div data-referrer="pagelet_profile_picture" id="pagelet_profile_picture">
					      <div class="profile-picture">
					      	<span class="profile-picture-overlay"></span>
					      	<img id="profile_pic" alt="Yu Li" src="<s:property value="profile.avatar"/>" class="photo img"/>
					      </div>
					    </div>
					    <div data-referrer="pagelet_fbx_navigation" id="pagelet_fbx_navigation">
					      <div id="sideNav" class="mvm uiFutureSideNav">
					        <div id="ucx7gw_1" class="expandableSideNav expandedMode">
					          <ul role="navigation" class="uiSideNav">
					            <li id="navItem_wall" class="sideNavItem stat_elem <s:property value="viewType[0]"/>">
					              <div class="buttonWrap"></div>
					              <a href="profile/profile!viewProfileFeeds.jhtml?userid=<s:property value="profile.userid" />" class="item clearfix" style="">
						              <div class="rfloat">
						              	<img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="uiLoadingIndicatorAsync img"/>
						              </div>
						              <div>
						              	<span class="imgWrap"><i class="img sp_9tlaa1 sx_741547"></i></span>
						                <div class="linkWrap noCount">涂鸦墙 <span class="count hidden_elem uiSideNavCountText">(<span class="countValue fsm">0</span><span class="maxCountIndicator"></span>)</span></div>
						              </div>
					              </a>
					            </li>
					            <li id="navItem_info" class="sideNavItem <s:property value="viewType[1]"/>">
					              <div class="buttonWrap"></div>
					              <a href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value="profile.userid" />" class="item clearfix" style="">
						              <div class="rfloat">
						              	<img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="uiLoadingIndicatorAsync img"/>
						              </div>
						              <div>
						              	<span class="imgWrap"><i class="img sp_9tlaa1 sx_a88c8c"></i></span>
						                <div class="linkWrap noCount">信息 <span class="count hidden_elem uiSideNavCountText">(<span class="countValue fsm">0</span><span class="maxCountIndicator"></span>)</span></div>
						              </div>
					              </a>
					            </li>
					            <li id="navItem_photos" class="sideNavItem stat_elem <s:property value="viewType[2]"/>">
					              <div class="buttonWrap"></div>
					              <a href="photo/photo!getAlbum.jhtml?userid=<s:property value="profile.userid" />" class="item clearfix" style="">
						              <div class="rfloat">
						              	<img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="uiLoadingIndicatorAsync img"/>
						              </div>
						              <div>
						              	<span class="imgWrap"><i class="img sp_9tlaa1 sx_68f922"></i></span>
						                <div class="linkWrap noCount">照片 <span class="count hidden_elem uiSideNavCountText">(<span class="countValue fsm">0</span><span class="maxCountIndicator"></span>)</span></div>
						              </div>
					              </a>
					            </li>
					            <li id="navItem_friends" class="sideNavItem stat_elem <s:property value="viewType[3]"/>">
					              <div class="buttonWrap"></div>
					              <a href="profile/profile!viewProfileFriends.jhtml?userid=<s:property value="profile.userid" />" class="item clearfix" style="">
						              <div class="rfloat">
						              	<img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="uiLoadingIndicatorAsync img"/>
						              </div>
						              <div>
						              	<span class="imgWrap"><i class="img sp_ah6icc sx_b23266"></i></span>
						              	
						                <div class="linkWrap noCount">朋友 <span class="count hidden_elem uiSideNavCountText">(<span class="countValue fsm">0</span><span class="maxCountIndicator"></span>)</span></div>
						             	
						              </div>
					              </a>
					            </li>
					          </ul>
					          <div class="actionLinks"></div>
					        </div>
					      </div>
					    </div>
					    <div data-referrer="pagelet_relationships" id="pagelet_relationships" class="hideWhenFixed">
					      <div class="relationshipSection">
					        <div class="uiHeader uiHeaderTopBorder uiHeaderNav">
					          <div class="clearfix uiHeaderTop">
					            <div>
					              <h5 class="uiHeaderTitle"><span class="fcg"><a href="http://www.facebook.com/yinluotianse?sk=friends&amp;v=friends"> <s:if test="friends.size()>0">  朋友 (<s:property value="friends.size()"/>)</s:if> </a></span></h5>
					            </div>
					          </div>
					        </div>
					        <ul class="profile-friends">
					        	 <s:iterator value="friends" status='st'>
					        	 	<s:if test="#st.getCount()<=10"> 
					          <li data-gt='{"engagement":{"eng_type":"1","eng_src":"5","eng_tid":"100003007263247","eng_data":{"eng_sid":"508440173"}},"coeff2_info":"AatoAtpnTWFkTTLdyvL2EPGa9OXQ7CykQyRdH3lOu6h4vJQCxTXPdML6_wZ8xCin7PJP2kyHsCQ8LJAcSh8IhqXqOGqfHWL08SHB0fa2Kz1Jom0U3WcikAZ6vUkk7CDA1fusafDgA0uSE_V2WsUuzWw5nK_odAD3oPS9zY7YKftg964Xd3NGZnwiMhxRjQlWK3bii74X3tLXSPd2477rzJBtXhgAsBXcuzpzcqWvUJN3iTb1_OXRjkPVr5VKzEL7m9wy4nGf53VX7Nqxpc0XPBHq","coeff2_registry_key":"0005","coeff2_action":"3"}'>
					            <div class="UIImageBlock clearfix ego_unit">
				              	<a aria-hidden="true" tabindex="-1" data-gt="{&quot;engagement&quot;:{&quot;eng_type&quot;:&quot;1&quot;,&quot;eng_src&quot;:&quot;13&quot;,&quot;eng_tid&quot;:&quot;100000640845110&quot;,&quot;eng_data&quot;:{&quot;ego_service&quot;:&quot;pymk&quot;,&quot;ego_pos&quot;:&quot;1&quot;}}}" href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="userid"/>" class="UIImageBlock_Image UIImageBlock_SMALL_Image">
				              		<img alt="" src="<s:property value="avatar"/>" class="uiProfilePhoto uiProfilePhotoLarge img">
				              	</a>
				                <div class="egoProfileTemplate UIImageBlock_Content UIImageBlock_SMALL_Content">
				                	<a data-gt="{&quot;engagement&quot;:{&quot;eng_type&quot;:&quot;1&quot;,&quot;eng_src&quot;:&quot;13&quot;,&quot;eng_tid&quot;:&quot;100000640845110&quot;,&quot;eng_data&quot;:{&quot;ego_service&quot;:&quot;pymk&quot;,&quot;ego_pos&quot;:&quot;1&quot;}}}" href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="userid"/>" class="ego_title"><s:property value="username"/></a>
				                 
				                </div>
				              </div>
					          </li>
					          </s:if> 
					          </s:iterator>
					        </ul>
					      </div>
					    </div>
					    <div data-referrer="pagelet_featured_pages" id="pagelet_featured_pages" class="hideWhenFixed"/>
					   
					  </div>
					</div>
				</div>