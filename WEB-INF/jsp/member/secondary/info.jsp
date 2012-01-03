<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
  <div role="main" id="contentArea" style="min-height: 100px;" data-referrer="contentArea">
      <div data-referrer="pagelet_main_column" id="pagelet_main_column">
        <div data-referrer="pagelet_main_column_personal_info" id="pagelet_main_column_personal">
          <div data-referrer="pagelet_photo_bar" id="pagelet_photo_bar"></div>
          <div data-referrer="pagelet_eduwork" id="pagelet_eduwork"></div>
          <div data-referrer="pagelet_philosophy" id="pagelet_philosophy"></div>
          <div data-referrer="pagelet_sports" id="pagelet_sports"></div>
          <div data-referrer="pagelet_arts_and_entertainment" id="pagelet_arts_and_entertainment"></div>
          <div data-referrer="pagelet_activities_and_interests" id="pagelet_activities_and_interests">
            <div id="activities" class="profileInfoSection">
              <div class="uiHeader uiHeaderTopAndBottomBorder uiHeaderSection">
                <div class="clearfix uiHeaderTop">
                  <div>
                    <h4 class="uiHeaderTitle">活动和爱好</h4>
                  </div>
                </div>
              </div>
              <div class="phs">
                <table class="uiInfoTable mtm profileInfoTable">
                  <tbody>
                    <tr>
                      <th class="label">活动爱好</th>
                      <td class="data">
                        <div id="ucyftu_8" class="uiCollapsedList uiCollapsedListHidden uiCollapsedListNoSeparate pagesListData">
                          <span class="visible">
                          	<s:property value="profile.hobby"/>
                          		
                            
                          </span>
                        </div>
                      </td>
                      <td class="rightCol"></td>
                    </tr>
                    
                     <tr>
                      <th class="label">兴趣</th>
                      <td class="data">
                        <div id="ucyftu_8" class="uiCollapsedList uiCollapsedListHidden uiCollapsedListNoSeparate pagesListData">
                          <span class="visible">
                          	
                          		<s:property value="profile.interest"/>
                            
                          </span>
                        </div>
                      </td>
                      <td class="rightCol"></td>
                    </tr>
                    
                  </tbody>
                </table>
              </div>
            </div>
          </div>
          <div data-referrer="pagelet_games" id="pagelet_games"></div>
          <div data-referrer="pagelet_profile_groups" id="pagelet_profile_groups"></div>
          <div data-referrer="pagelet_basic" id="pagelet_basic">
            <div class="mbs profileInfoSection">
              <div class="uiHeader uiHeaderTopAndBottomBorder uiHeaderSection infoSectionHeader">
                <div class="clearfix uiHeaderTop">
                  <div>
                    <h4 class="uiHeaderTitle">基本信息</h4>
                  </div>
                </div>
              </div>
              <div class="phs">
                <table class="uiInfoTable mtm profileInfoTable">
                  <tbody>
                    <tr>
                      <th class="label">性别</th>
                      <s:if test="profile.gender==1">   
                      <td class="data">男</td>
                      </s:if>   
                      
                       <s:if test="profile.gender==2">   
                      <td class="data">女</td>
                      </s:if>   
                    </tr>
                  </tbody>
                  
                  
                  <tbody>
                    <tr>
                      <th class="label">自我介绍</th>
                      <td class="data"><s:property value="profile.introduction"/></td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
          <div data-referrer="pagelet_contact" id="pagelet_contact">
            <div class="profileInfoSection">
              <div class="uiHeader uiHeaderTopAndBottomBorder uiHeaderSection infoSectionHeader">
                <div class="clearfix uiHeaderTop">
                  <div>
                    <h4 class="uiHeaderTitle">联系信息</h4>
                  </div>
                </div>
              </div>
              <div class="phs">
                <table class="uiInfoTable mtm profileInfoTable">
                  <tbody>
                    <tr>
                      <th class="label">QQ</th>
                      <td class="data">
                        <ul class="uiList">
                          <li class="uiListItem uiListVerticalItemBorder">
                            <s:property value="profile.qq"/>
                          </li>
                        </ul>
                      </td>
                    </tr>
                    
                    <tr>
                      <th class="label">邮件地址</th>
                      <td class="data">
                        <ul class="uiList">
                          <li class="uiListItem uiListVerticalItemBorder">
                          	<s:if test="friendFlag==true">   
                            	<s:property value="profile.email"/>
                          </s:if>
                          <s:else>
                          		一度朋友可见
                           </s:else>
                          </li>
                        </ul>
                      </td>
                    </tr>
                    
                    <tr>
                      <th class="label">电话号码</th>
                      <td class="data">
                        <ul class="uiList">
                          <li class="uiListItem uiListVerticalItemBorder">
                            <s:if test="friendFlag==true">   
                            	<s:property value="profile.mobile"/>
                          	</s:if>
                          	<s:else>
                          		一度朋友可见
                           	</s:else>
                          </li>
                        </ul>
                      </td>
                    </tr>
                    
                    <tr class="spacer">
                      <td colspan="2"><hr/></td>
                    </tr>
                  </tbody>
                 
                </table>
              </div>
            </div>
          </div>
          <div data-referrer="pagelet_privacy_notice" id="pagelet_privacy_notice">
            <div id="ucyftu_9" class="pal hidden_elem uiBoxLightblue topborder">
              <div class="UIImageBlock clearfix">
                <i class="UIImageBlock_Image UIImageBlock_ICON_Image img sp_9tlaa1 sx_a69ec9"></i>
                <div class="UIImageBlock_Content UIImageBlock_ICON_Content">
                  <span class="fwb">Yu only shares some information publicly.</span> 
                  如果你认识 Yu， 
                  <a ajaxify="/ajax/profile/connect.php?profile_id=508440173&amp;rel_dialog=1&amp;src=info_tab" rel="dialog-post" href="/addfriend.php?id=508440173&amp;hf=profile_button">将她加为朋友</a>或者
                  <a rel="dialog" href="/ajax/messaging/composer.php?id=508440173">给她发条消息</a>。
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div id="bottomContent"/>
  </div>
</div>