<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<div id="headerArea">
				    <div data-referrer="pagelet_header" id="pagelet_header">
				      <div data-referrer="pagelet_above_header" id="pagelet_above_header"></div>
				      <div data-referrer="pagelet_header_personal" id="pagelet_header_personal">
				        <div class="clearfix profileHeader">
				        	
				        	<s:if test="profile.userid!=#session.user.userid">   
				          <div class="rfloat">
				            <div id="ucyftu_4" class="FriendButton profileHeaderButton">
				              <label for="ucyftu_5" class="FriendRequestAdd addButton uiButton">
				              	<i class="mrs img sp_ah6icc sx_070d6b"></i>
				              	<input type="button" id="ucyftu_5" value="加为好友"/>
				              </label>
				              <a data-flloc="fbx_top_bar" data-profileid="508440173" href="#" role="button" class="FriendRequestOutgoing enableFriendListFlyout hidden_elem outgoingButton uiButton">
				              	<i class="mrs img sp_ah6icc sx_070d6b"></i>
				              	<span class="uiButtonText">朋友请求已传送。</span>
				              </a>
				            </div>
				            <a rel="" id="profile_action_send_message" href="/messages/508440173" role="button" class="mls uiButton">
				            	<i class="mrs img sp_ah6icc sx_5ecc8d"></i>
				            	<span class="uiButtonText">发信息</span>
				            </a>
				            <div class="uiSelector inlineBlock mls uiSelectorRight uiSelectorNormal">
				              <div class="wrap">
				              	<a rel="toggle" data-length="30" aria-haspopup="1" href="#" role="button" class="uiSelectorButton uiButton uiButtonNoText">
				              		<i class="mrs img sp_ah6icc sx_87bdb5"></i>
				              		<span class="uiButtonText"></span>
				              	</a>
				                <div class="uiSelectorMenuWrapper uiToggleFlyout">
				                  <div class="uiMenu uiSelectorMenu" role="menu">
				                    <ul class="uiMenuInner">
				                      <li id="profile_action_report_block" data-label="举报/屏蔽" class="uiMenuItem">
				                      	<a rel="dialog" onclick='var report_link = DOM.find($("profile_action_report_block"), "a");report_link.href = URI(report_link.href).addQueryData(  {"profile_wall_tab" : Boolean(      FutureSideNav.getInstance().selected.matchKey("wall"))});' href="/ajax/report/social.php?content_type=0&amp;cid=508440173&amp;rid=508440173&amp;h=AfiqlcXetd52APpQ&amp;from_gear=fbx" tabindex="0" role="menuitem" class="itemAnchor">
				                      		<span class="itemLabel fsm">举报/屏蔽</span>
				                      	</a>
				                      </li>
				                    </ul>
				                  </div>
				                </div>
				              </div>
				            </div>
				          </div>
				        </s:if>
				          <div class="profileHeaderMain">
				            <h1><span class="profileName fn ginormousProfileName fwb"><s:property value="profile.username"/></span></h1>
				          </div>
				        </div>
				      </div>
				      <div data-referrer="pagelet_byline" id="pagelet_byline">
				        <div class="fbProfileByline">
				        	<span class="fbProfileBylineFragment">
				        		<span class="fbProfileBylineIconContainer">
				        			<i class="mrs fbProfileBylineIcon img sp_ah6icc sx_8083d0"></i>
				        		</span>
				        		<span class="fbProfileBylineLabel">住在<a data-hovercardx="/ajax/hovercard/page.php?id=110730292284790" href="http://www.facebook.com/pages/Beijing-China/110730292284790">北京</a></span>
				        	</span>
				        </div>
				      </div>
				    </div>
				  </div>