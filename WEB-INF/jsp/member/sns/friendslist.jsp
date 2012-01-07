  <%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
  <%@page contentType="text/html; charset=UTF-8"%>
<div id="contentArea" role="main">
					  <div id="pagelet_main_column" data-referrer="pagelet_main_column" data-gt="{&quot;profile_owner&quot;:&quot;100001966784035&quot;,&quot;ref&quot;:&quot;mf&quot;}">
					    <div id="pagelet_main_column_personal" data-referrer="pagelet_main_column_personal_friends">
					      <div id="pagelet_friends_tab" data-referrer="pagelet_friends_tab">
					        <div class="fbProfileBrowser" id="ur7504_17">
					          <div class="standardLayout switchableLayout">
					            <div class="uiHeader uiHeaderTopAndBottomBorder uiHeaderSection">
					              <div class="clearfix uiHeaderTop">
					                <div>
					                	<s:if test="(event==null)"> 
					                  <h3 class="uiHeaderTitle">朋友列表</h3>
					                </s:if>
					                <s:else>
					                  <h3 class="uiHeaderTitle">参加活动成员列表</h3>
					               </s:else>
					                </div>
					              </div>
					            </div>
					            <div class="listView clearfix normal" id="ur7504_24">
					            	<img width="32" height="32" class="throbber img" src="http://static.ak.fbcdn.net/rsrc.php/v1/y9/r/jKEcVPZFk-2.gif" alt="">
					              <div class="lists">
					                <div class="fbProfileBrowserResult hideSummary" id="ur7504_7">
					                  <div class="pvm phs fbProfileBrowserSummaryBox uiBoxWhite bottomborder"></div>
					                  <div class="dualList fbProfileBrowserListContainer">
					                    <div class="fbProfileBrowserList normalList">
					                      <ul class="uiList">
					                      	<s:iterator value="friends">
					                        <li class="fbProfileBrowserListItem uiListItem uiListLight uiListVerticalItemBorder">
					                          <div class="UIImageBlock clearfix UIImageBlock_Entity">
					                          	<a class="UIImageBlock_Image UIImageBlock_ENT_Image" href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value="userid"/>" >
					                          		<img class="img" src="<s:property value="avatar"/>" alt="">
					                          	</a>
					                            <div class="UIImageBlock_Ext">
					                              <div class="FriendButton mhs" id="ur7504_28">
					                              	<s:if test="(#session.userid==profile.userid)"> 
					                                <label class="FriendRequestAdd addButton uiButton" for="ur7504_29">
					                                	
					                                	
					                                		<i class="mrs img sp_51cg4r sx_2aaf46"></i>
					                                	<a href="sns/sns!removeFriend.jhtml?friendId=<s:property value="userid"/>">删除好友</a>
					                               
					                                	<!--
					                                	<input type="button" value="删除好友" id="ur7504_29">-->
					                                </label>
					                                 </s:if> 
					                                <a class="FriendRequestOutgoing enableFriendListFlyout hidden_elem outgoingButton uiButton" role="button" href="#" data-profileid="100000298238485" data-flloc="profile_browser">
					                                	<i class="mrs img sp_51cg4r sx_2aaf46"></i>
					                                	<span class="uiButtonText">朋友请求已传送。</span>
					                                </a>
					                              </div>
					                            </div>
					                            <div class="UIImageBlock_Content UIImageBlock_ENT_Content">
					                              <div class="fsl fwb fcb">
					                              	<a href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value="userid"/>"  data-gt="{&quot;engagement&quot;:{&quot;eng_type&quot;:&quot;1&quot;,&quot;eng_src&quot;:&quot;2&quot;,&quot;eng_tid&quot;:&quot;100000298238485&quot;,&quot;eng_data&quot;:[]}}"><s:property value="username"/></a>
					                              </div>
					                              <span class="fsm fwn fcg"><s:property value="username11"/></span>
					                            </div>
					                          </div>
					                        </li>
					                       </s:iterator>
					                      </ul>
					                    </div>
					                    <div class="clearfix uiMorePager stat_elem morePager uiMorePagerCenter" id="ur7504_25">
					                    	<div>
										            	<s:if test="friends.size()>0">
										            	<jsp:include page="/WEB-INF/jsp/common/pagination.jsp" flush="true" />
										            </s:if>
										            <s:else>
										              <div class="pam uiBoxLightblue uiMorePagerPrimary">目前没有更多朋友可显示。</div>
										            </s:else>
										            </div>
					                    	
					                    	<!--
					                      <div>
					                      	<a class="pam uiBoxLightblue uiMorePagerPrimary" id="ur7504_26" href="#" rel="async">查看更多</a>
					                      	<span class="uiMorePagerLoader pam uiBoxLightblue">
					                      		<img width="16" height="11" class="img" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" alt="">
					                      	</span>
					                      </div>
					                      -->
					                      
					                    </div>
					                  </div>
					                </div>
					                <div class="fbProfileBrowserResult hidden_elem" id="ur7504_5"></div>
					                <div class="fbProfileBrowserResult hidden_elem" id="ur7504_6"></div>
					                <div class="fbProfileBrowserResult hidden_elem" id="ur7504_8"></div>
					                <div class="fbProfileBrowserResult hidden_elem" id="ur7504_9"></div>
					                <div class="fbProfileBrowserResult hidden_elem" id="ur7504_10"></div>
					                <div class="fbProfileBrowserResult hidden_elem" id="ur7504_11"></div>
					                <div class="fbProfileBrowserResult hidden_elem" id="ur7504_12"></div>
					                <div class="fbProfileBrowserResult hidden_elem" id="ur7504_13">
					                <div class="fbProfileBrowserResult typeaheadView hidden_elem" id="ur7504_14"></div>
					              </div>
					            </div>
					          </div>
					        </div>
					      </div>
					    </div>
					  </div>
					</div>
				  <div id="bottomContent"></div>
				</div>
<script>
function topage(pageNo) {
	<s:if test="(userid>0)"> 
 location.href = "profile/profile!viewProfileFriends.jhtml?userid=${profile.userid}&pageNo="+pageNo
  </s:if>
  <s:else>
   location.href = "sns/sns!getFriendsList.jhtml?pageNo="+pageNo
  </s:else>
  return false;
}
</script>