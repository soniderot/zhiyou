<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>

          <div role="main" id="contentArea">
            <div data-referrer="pagelet_titan" id="pagelet_titan">
              <div id="MessagingDashboard">
                <div id="MessagingFrame" class="clearfix">
                  <div class="hidden_elem"></div>
                  <div class="uiHeader uiHeaderWithImage uiHeaderPage">
                    <div class="clearfix uiHeaderTop">
                     
                      <div>
                        <h2 class="uiHeaderTitle">
                          <i class="uiHeaderImage img sp_7gl7wd sx_0b0f8c"></i>通知
                        </h2>
                      </div>
                      
                      <table cellspacing="0" cellpadding="0" class="uiGrid mts footerActionBar">
						          
						        </table>
						        
                    </div>
                  </div>
                  <div class="mbs clearfix" id="MessagingMainContent">
                   
                   
                   <ul class="uiList">
                   	<s:iterator value="notifys">
						      	<li class="objectListItem uiListItem uiListLight uiListVerticalItemBorder" id="100003206989957_1_req">
						        <div class="UIImageBlock clearfix">
						        	  <a class="actorPhoto UIImageBlock_Image UIImageBlock_MED_Image" tabindex="-1" href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value="profile.userid"/>">
												<img class="uiProfilePhoto profilePic uiProfilePhotoLarge img" src="<s:property value="profile.avatar"/>" alt="">
												</a>
											
					          <div id="100003206989957_1_req_status" class="requestStatus UIImageBlock_Content UIImageBlock_SMALL_Content">
					            <div class="clearfix">
					              <div class="rfloat">
					                <div class="auxiliary" id="100003206989957_1_req_aux">
					                  
					                    <div class="actions">
					                    	
					                      
					                      	<a id="profile_action_send_message" class="uiButton"  href="usr/notify!deleteNotify.jhtml?notifyId=<s:property value="notification.id"/>" rel="">
																	<i class="mrs img sp_ah6icc sx_5ecc8d"></i>
																	<span class="uiButtonText">删除</span>
																	</a>
																	
					                    </div>
					                  
					                </div>
					              </div>
					              <div>
					                <div>
					                	<span class="title fsl fwb fcb"><a href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value="profile.userid"/>"><s:property value="profile.username"/></a>
					                		<s:if test="notification.eventkey==1">
					                		成为您的一度朋友
					                		</s:if>
					                		<s:if test="notification.eventkey==5">
					                		参加了活动
					                		<a title="dota" href="event/event!viewEvent.jhtml?eventId=<s:property value="event.id"/>"><s:property value="event.eventname"/></a>
					                		</s:if>
					                		<s:if test="notification.eventkey==16">
					                		回答回答了问题<a title="dota" href="sns/question!viewQuestion.jhtml?questionId=<s:property value="question.id"/>"><s:property value="question.summary"/></a>
					                		</s:if>
					                		</span>
					                	
					                </div>
					                <div class="networkContextWrapper"></div>
					              </div>
					            </div>
					            <div class="fsm fwn fcg"></div>
					          </div>
					        </div>
					      </li>
					      <li class="uiListItem uiListLight uiListVerticalItemBorder">
					        <div class="pam hidden_elem uiBoxLightblue">没有新请求</div>
					      </li>
					      </s:iterator>
					    </ul>
                   
                   
                   
                   
                  </div>
                 </div>
              </div>
            </div>
          </div>
 <div>
  <s:if test="notifys.size()>0">
    <jsp:include page="/WEB-INF/jsp/common/pagination.jsp" flush="true" />
  </s:if>
  <s:else>
    <div class="pam uiBoxLightblue uiMorePagerPrimary">目前没有更多通知可显示。</div>
  </s:else>
</div>
      
<script>
function topage(pageNo) {
  location.href = "usr/notify.jhtml?pageNo="+pageNo
  return false;
}
</script>    