<%@page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
          <div id="leftCol">
            <div id="pagelet_welcome_box" data-referrer="pagelet_welcome_box">
              <div class="UIImageBlock clearfix fbxWelcomeBox UIImageBlock_Entity">
                <a tabindex="-1" aria-hidden="true" href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="#session.user.userid"/>" class="fbxWelcomeBoxBlock UIImageBlock_Image UIImageBlock_ENT_Image">
               
                  <s:if test="#session.userlogo!=null">   
                  <img alt="" src="<s:property value="#session.userlogo"/>" class="fbxWelcomeBoxImg img"/>
                	 </s:if>   
                	 <s:else>
                	 	<img alt="" src="images/DEFAULT.JPG" class="fbxWelcomeBoxImg img"/>
                	</s:else>
                </a>
                <div class="prs UIImageBlock_Content UIImageBlock_ENT_Content">
                  <a href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="#session.user.userid"/>" class="fbxWelcomeBoxName"><s:property value="#session.user.username"/></a>
                </div>
              </div>
            </div>
            
            <div id="pagelet_navigation" data-referrer="pagelet_navigation">
              <div id="sideNav" data-gt='{"ref":"bookmarks"}' class="uiFutureSideNav">
                
                <div id="pagelet_pinned_nav" data-referrer="pagelet_pinned_nav">
                  <div id="pinnedNav" class="homeSideNav">
                    <div class="navHeader">最爱</div>
                    <div class="mts mbm droppableNav">
                      <ul data-gt='{"nav_items_count":"5","nav_section":"pinnedNav"}' role="navigation" class="uiSideNav">
                        <li id="navItem_app_156203961126022" class="sideNavItem stat_elem selectedItem open">
                          <div class="buttonWrap"></div>
                          <a data-gt='{"bmid":"156203961126022","count":"0","coeff2_info":"AasM7zARnPgbgC_QyV1VyOv88p8dSL-UzGszpVbiurs-Ze51FDKAJBmNRk0XhUz0-Mi9HoXJsBeNarBIEVuaar6F","coeff2_registry_key":"0016","coeff2_action":"3","rank":"1"}' title="欢迎来到 知友" href="/usr/landing.jhtml" class="item clearfix">
                            <div class="rfloat">
                              <img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="uiLoadingIndicatorAsync img"/>
                              <span class="count hidden_elem uiSideNavCount">
                                <span class="countValue fss">0</span>
                                <span class="maxCountIndicator"></span>
                              </span>
                            </div>
                            <div>
                              <span class="imgWrap">
                                <i class="img sp_enac13 sx_89179c"></i>
                              </span>
                              <div class="linkWrap noCount">欢迎来到 知友</div>
                            </div>
                          </a>
                        </li>
                        <li id="navItem_app_4748854339" class="sideNavItem stat_elem">
                          
                          <a data-gt='{"bmid":"4748854339","count":"0","coeff2_info":"Aasb80t8kL0QLo_8OvmsvgTMV-IUsl33Qc4hL-Voy6mMUADa31aZbymtMtThn1d5mJQ","coeff2_registry_key":"0016","coeff2_action":"3","rank":"2"}' title="" href="/usr/feed.jhtml" class="item clearfix" style="">
                            <div class="rfloat">
                              <img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="uiLoadingIndicatorAsync img"/>
                              <span class="count hidden_elem uiSideNavCount">
                                <span class="countValue fss">0</span>
                                <span class="maxCountIndicator"></span>
                              </span>
                            </div>
                            <div>
                              <span class="imgWrap">
                                <i class="img sp_7gl7wd sx_efd21b"></i>
                              </span>
                              <div class="linkWrap noCount">动态汇总</div>
                            </div>
                          </a>
                        </li>
                        <li id="navItem_app_217974574879787" class="sideNavItem stat_elem">
                          <a data-gt='{"bmid":"217974574879787","count":"0","coeff2_info":"Aaswb8c23rf7yV2wsauNLbjN3PTuDkcZ4O6pM5sUv-Z31EVolPbAyyn2l_khXf8l-PBFQ_poEjhITzENdALTSlRa","coeff2_registry_key":"0016","coeff2_action":"3","rank":"3"}' title="" href="/usr/message.jhtml" class="item clearfix sortableItem">
                            <div class="rfloat">
                              <img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="uiLoadingIndicatorAsync img"/>
                              <span class="count hidden_elem uiSideNavCount">
                                <span class="countValue fss">0</span>
                              </span>
                              <span class="grip"></span>
                            </div>
                            <div>
                              <span class="imgWrap">
                                <i class="img sp_1md9rt sx_73fc1d"></i>
                              </span>
                              <div class="linkWrap noCount">消息</div>
                            </div>
                          </a>
                         
                        </li>
                        <li id="navItem_app_2344061033" class="sideNavItem stat_elem">
                         
                          <a data-gt='{"bmid":"2344061033","count":"0","coeff2_info":"Aas57PhE1Z0iK6Z02IMoWK9Qp8gnEQGdYCp_tpM1G14IzmQk-0bR9482p21bxlkle_A","coeff2_registry_key":"0016","coeff2_action":"3","rank":"4"}' title="" href="/event/event!getEvents.jhtml" class="item clearfix sortableItem">
                            <div class="rfloat">
                              <img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="uiLoadingIndicatorAsync img"/>
                              <span class="count hidden_elem uiSideNavCount">
                                <span class="countValue fss">0</span>
                                <span class="maxCountIndicator"></span>
                              </span>
                              <span class="grip"></span>
                            </div>
                            <div>
                              <span class="imgWrap">
                                <i class="img sp_6h8b4g sx_70f090"></i>
                              </span>
                              <div class="linkWrap noCount">活动</div>
                            </div>
                          </a>
                          <ul>
                            <li id="navItem_fe">
                              <a href="/events/friends/" class="subitem clearfix">
                                <div class="rfloat">
                                  <img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="uiLoadingIndicatorAsync img"/>
                                  <span class="count hidden_elem uiSideNavCount">
                                    <span class="countValue fss">0</span>
                                  </span>
                                </div>
                                <div>
                                  <div class="linkWrap noCount">朋友的活动</div>
                                </div>
                              </a>
                            </li>
                          </ul>
                          <span class="mover hidden_elem"></span>
                        </li>
                        <li id="navItem_app_2356318349" class="sideNavItem stat_elem">
                         
                          <a data-gt='{"bmid":"2356318349","count":"0","coeff2_info":"Aaspwvb3buiDZvUxvLIoJf844ijN51XYfPV2qBK57VMyX7HDXQlQUK8qg6zj5xrPQGs","coeff2_registry_key":"0016","coeff2_action":"3","rank":"5"}' title="" href="/sns/sns!viewInvitePage.jhtml" class="item clearfix sortableItem" style="">
                            <div class="rfloat">
                              <img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="uiLoadingIndicatorAsync img"/>
                              <span class="count hidden_elem uiSideNavCount">
                                <span class="countValue fss">0</span>
                                <span class="maxCountIndicator"></span>
                              </span>
                              <span class="grip"></span>
                            </div>
                            <div>
                              <span class="imgWrap">
                                <i class="img sp_7gl7wd sx_0b0f8c"></i>
                              </span>
                              <div class="linkWrap noCount">邀请朋友</div>
                              
                            </div>
                            
                            
                          </a>
                          <span class="mover hidden_elem"></span>
                        </li>
                        
                         <li id="navItem_app_2356318349" class="sideNavItem stat_elem">
                         
                          <a data-gt='{"bmid":"2356318349","count":"0","coeff2_info":"Aaspwvb3buiDZvUxvLIoJf844ijN51XYfPV2qBK57VMyX7HDXQlQUK8qg6zj5xrPQGs","coeff2_registry_key":"0016","coeff2_action":"3","rank":"5"}' title="" href="/sns/sns!getFriendsList.jhtml" class="item clearfix sortableItem" style="">
                            <div class="rfloat">
                              <img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="uiLoadingIndicatorAsync img"/>
                              <span class="count hidden_elem uiSideNavCount">
                                <span class="countValue fss">0</span>
                                <span class="maxCountIndicator"></span>
                              </span>
                              <span class="grip"></span>
                            </div>
                            <div>
                              <span class="imgWrap">
                                <i class="img sp_7gl7wd sx_0b0f8c"></i>
                              </span>
                              <div class="linkWrap noCount">好友</div>
                              
                            </div>
                            
                            
                          </a>
                          <span class="mover hidden_elem"></span>
                        </li>
                        
                      </ul>
                    
                    </div>
                  </div>
                </div>
                
                <div id="pagelet_bookmark_nav" data-referrer="pagelet_bookmark_nav">
                 
                  <div>
                  	
                  	<!--
                    <div id="listsNav" class="homeSideNav">
                      <div class="navHeader">
                        <a href="/sns/sns!getFriendsList.jhtml">
                          <div class="clearfix">
                            <div class="lfloat">好友名单</div>
                            <span class="mrm rfloat">
                              <div class="bookmarksNavSeeAll">所有好友</div>
                              <img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="uiLoadingIndicatorAsync img"/>
                            </span>
                          </div>
                        </a>
                      </div>
                      <ul data-gt='{"nav_items_count":"2","nav_section":"listsNav"}' role="navigation" class="uiSideNav mts mbm nonDroppableNav">
                        <li id="navItem_fl_2634661952657" class="sideNavItem stat_elem">
                        
                          <a data-gt='{"bmid":"2634661952657","count":"0","coeff2_info":"AatJTHR-AJBfw_7yYaQBE-KE2v9rqUbgBsHedfV-KC2Bk0X7wv-hNwMz3WjaR69RBf5WbHX1nfAy8n4IPApXVzpr","coeff2_registry_key":"0016","coeff2_action":"3","rank":"1"}' title="" href="/lists/2634661952657" class="item clearfix sortableItem">
                            <div class="rfloat">
                              <img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="uiLoadingIndicatorAsync img"/>
                              <span class="count hidden_elem uiSideNavCount">
                                <span class="countValue fss">0</span>
                                <span class="maxCountIndicator"></span>
                              </span>
                              <span class="grip"></span>
                            </div>
                            <div>
                              <span class="imgWrap">
                                <i class="img sp_7gl7wd sx_357d0f"></i>
                              </span>
                              <div class="linkWrap noCount">挚友</div>
                            </div>
                          </a>
                          <span class="mover hidden_elem"></span>
                        </li>
                        <li id="navItem_fl_2634662072660" class="sideNavItem stat_elem">
                         
                          <a data-gt='{"bmid":"2634662072660","count":"0","coeff2_info":"AasBG67cxuKgDbFuw51bkDyN1-YaNDsR3JNDcGuFXPl9QHIZOQNJlq3pULq209uUmztfJ5Y3mIoBh3adU6tXkBcv","coeff2_registry_key":"0016","coeff2_action":"3","rank":"2"}' title="" href="/lists/2634662072660" class="item clearfix sortableItem">
                            <div class="rfloat">
                              <img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="uiLoadingIndicatorAsync img"/>
                              <span class="count hidden_elem uiSideNavCount">
                                <span class="countValue fss">0</span>
                                <span class="maxCountIndicator"></span>
                              </span>
                              <span class="grip"></span>
                            </div>
                            <div>
                              <span class="imgWrap">
                                <i class="img sp_7gl7wd sx_0a8b75"></i>
                              </span>
                              <div class="linkWrap noCount">家人</div>
                            </div>
                          </a>
                          <span class="mover hidden_elem"></span>
                        </li>
                      </ul>
                    </div>
                    -->
                    
                    
                    <div id="appsNav" class="homeSideNav">
                      <div class="navHeader">
                        
                          <div class="clearfix">
                            <div class="lfloat">应用程序</div>
                            <span class="mrm rfloat">
                              <div class="bookmarksNavSeeAll"></div>
                              <img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="uiLoadingIndicatorAsync img"/>
                            </span>
                          </div>
                        
                      </div>
                      <ul data-gt='{"nav_items_count":"5","nav_section":"appsNav"}' role="navigation" class="uiSideNav mts mbm nonDroppableNav">
                        <li id="navItem_app_2305272732" class="sideNavItem stat_elem">
                         
                          <a data-gt='{"bmid":"2305272732","count":"0","coeff2_info":"AavlFDtX3Zh1sRcSv6cXUkzN2msD6OSwuDo1LJvCn9BD5qZIaApSrOUUBaHXCVG5Em0","coeff2_registry_key":"0016","coeff2_action":"3","rank":"1"}' title="" href="usr/feed.jhtml?handle=sns.publish.photo" class="item clearfix sortableItem">
                            <div class="rfloat">
                              <img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="uiLoadingIndicatorAsync img"/>
                              <span class="count hidden_elem uiSideNavCount">
                                <span class="countValue fss">0</span>
                                <span class="maxCountIndicator"></span>
                              </span>
                              <span class="grip"></span>
                            </div>
                            <div>
                              <span class="imgWrap">
                                <i class="img sp_6h8b4g sx_282f2a"></i>
                              </span>
                              <div class="linkWrap noCount">照片</div>
                            </div>
                          </a>
                          <span class="mover hidden_elem"></span>
                        </li>
                        <li id="navItem_app_10150110253435258" class="sideNavItem stat_elem">
                         
                          <a data-gt='{"bmid":"10150110253435258","count":"0","coeff2_info":"AascNaC5GNX94bXmRL8InEKxGm-39eQ5SfwNcUulSMDReSQ6rlnBwPOk7AFx62cEoqpRxf1oT7GtQr9FuMTffZXQ","coeff2_registry_key":"0016","coeff2_action":"3","rank":"5"}' title="" href="http://www.facebook.com/questions/friends/" class="item clearfix sortableItem" style="">
                            <div class="rfloat">
                              <img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="uiLoadingIndicatorAsync img"/>
                              <span class="count hidden_elem uiSideNavCount">
                                <span class="countValue fss">0</span>
                                <span class="maxCountIndicator"></span>
                              </span>
                              <span class="grip"></span>
                            </div>
                            <div>
                              <span class="imgWrap">
                                <i class="img sp_7gl7wd sx_97759f"></i>
                              </span>
                              <div class="linkWrap noCount">问题</div>
                            </div>
                          </a>
                          <span class="mover hidden_elem"></span>
                        </li>
                      </ul>
                    </div>
                    
                  </div>
                </div>
                  
                
              </div>
            </div>
            <div id="pagelet_friends_online" data-referrer="pagelet_friends_online"></div>
          </div>