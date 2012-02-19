<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>

<%@page contentType="text/html; charset=UTF-8"%>
    <div role="complementary" id="rightCol">
      <div class="home_right_column">
        <div class="rightColumnWrapper">
          <div data-referrer="pagelet_chbox" id="pagelet_chbox"></div>
          <div data-referrer="pagelet_ego_pane_w" id="pagelet_ego_pane_w">
            <div class="ego_column egoOrganicColumn">
              <div class="ego_section">
              <s:if test="friendEvents!=null">   
                <div class="uiHeader uiHeaderTopAndBottomBorder mbs uiSideHeader">
                 
                  <div class="clearfix uiHeaderTop">
                    <a href="/event/event!getFriendsEvents.jhtml" class="uiHeaderActions rfloat">显示更多</a>
                    <div><h4 class="uiHeaderTitle">朋友的活动</h4></div>
                  </div>
                 
                  
                </div>
                 </s:if>   
                <div class="phs">
                  
                  
                   <s:iterator value="friendEvents">
                  <div class="UIImageBlock clearfix ego_unit">
                    <a aria-hidden="true" tabindex="-1" data-gt='{"engagement":{"eng_type":"1","eng_src":"13","eng_tid":"1372884330","eng_data":{"ego_service":"pymk","ego_pos":"4"}}}' href="/event/event!viewEvent.jhtml?eventId=<s:property value="event.id" />" class="UIImageBlock_Image UIImageBlock_SMALL_Image">
                      <img alt="" src="<s:property value="event.logo" />" class="uiProfilePhoto uiProfilePhotoLarge img"/>
                    </a>
                    <div class="egoProfileTemplate UIImageBlock_Content UIImageBlock_SMALL_Content">
                      <a data-gt='{"engagement":{"eng_type":"1","eng_src":"13","eng_tid":"1372884330","eng_data":{"ego_service":"pymk","ego_pos":"4"}}}' href="/event/event!viewEvent.jhtml?eventId=<s:property value="event.id" />" class="ego_title"><s:property value="event.eventname" /></a>
                      <div class="ego_action">
                        
                        <a href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="friends.get(0).userid" />" class="ego_title"><s:property value="friends.get(0).username" /></a>等<s:property value="friends.size()" />位好友参加
                        	
                        
                      
                      </div>
                    </div>
                  </div>
           		</s:iterator>
           		
                </div>
                
                 <s:if test="publicEvents!=null">   
               
                <div class="uiHeader uiHeaderTopAndBottomBorder mbs uiSideHeader">
                 
                  <div class="clearfix uiHeaderTop">
                    
                    <div><h4 class="uiHeaderTitle">您可能感兴趣的活动</h4></div>
                  </div>
                 
                  
                </div>
                </s:if>   
                
                <div class="phs">
                  
                  
                   <s:iterator value="publicEvents">
                  <div class="UIImageBlock clearfix ego_unit">
                    <a aria-hidden="true" tabindex="-1" data-gt='{"engagement":{"eng_type":"1","eng_src":"13","eng_tid":"1372884330","eng_data":{"ego_service":"pymk","ego_pos":"4"}}}' href="/event/event!viewEvent.jhtml?eventId=<s:property value="event.id" />" class="UIImageBlock_Image UIImageBlock_SMALL_Image">
                      <img alt="" src="<s:property value="event.logo" />" class="uiProfilePhoto uiProfilePhotoLarge img"/>
                    </a>
                    <div class="egoProfileTemplate UIImageBlock_Content UIImageBlock_SMALL_Content">
                      <a data-gt='{"engagement":{"eng_type":"1","eng_src":"13","eng_tid":"1372884330","eng_data":{"ego_service":"pymk","ego_pos":"4"}}}' href="/event/event!viewEvent.jhtml?eventId=<s:property value="event.id" />" class="ego_title"><s:property value="event.eventname" /></a>
                      <div class="ego_action">
                        
                        <s:if test="joined==true">   
                        	您已参加
                        </s:if>   
                        
                         
                        
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