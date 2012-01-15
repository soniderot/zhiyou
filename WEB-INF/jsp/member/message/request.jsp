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
                          <i class="uiHeaderImage img sp_7gl7wd sx_0b0f8c"></i>收到的请求
                        </h2>
                      </div>
                      
                      <table cellspacing="0" cellpadding="0" class="uiGrid mts footerActionBar">
						          <tbody>
						            <tr>
						              <td class="vTop">
						                <ul class="uiList uiListHorizontal clearfix">
						                  <li class="uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
						                    <div class="clearfix mts"><div class="mrs lfloat fsm fwn fcg">
						                      <strong>查看：</strong>
						                    </div>
						                    <div class="footerActionLinks rfloat fsm fwn fcg">
						                      <a href="usr/request.jhtml?type=inbox" >收件箱</a>
						                       · <a href="usr/request.jhtml?type=outbox">发件箱</a>
						                      </div>
						                    </div>
						                    <div class="pam hidden_elem uiBoxLightblue"></div>
						                    
						                  </li>
						                  
						                  <li class="uiListItem uiListLight uiListVerticalItemBorder">
																<div class="pam hidden_elem uiBoxLightblue"></div>
															</li>
						                </ul>
						                
						                
						              </td>
						            </tr>
						          </tbody>
						        </table>
						        
                    </div>
                  </div>
                  <div class="mbs clearfix" id="MessagingMainContent">
                   
                   
                   <ul class="uiList">
                   	<s:iterator value="requests">
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
					                    	<s:if test="request.eventkey!=16">
					                      	<a id="profile_action_send_message" class="uiButton uiButtonConfirm"  href="/usr/request!approveRequest.jhtml?requestId=<s:property value="request.id"/>" rel="">
																			<i class="mrs img sp_ah6icc sx_5ecc8d"></i>
																			<span class="uiButtonText">接受</span>
																	</a>
					                      	</s:if>
					                      	 <s:else>
					                      	 	<a id="profile_action_send_message" class="uiButton uiButtonConfirm"  href="sns/question!viewQuestion.jhtml?questionId=<s:property value="question.id"/>" rel="">
																			<i class="mrs img sp_ah6icc sx_5ecc8d"></i>
																			<span class="uiButtonText">查看详细</span>
																	</a>
					                      	 </s:else>
					                      
					                      	<a id="profile_action_send_message" class="uiButton"  href="/usr/request!deleteRequest.jhtml?requestId=<s:property value="request.id"/>" rel="">
																	<i class="mrs img sp_ah6icc sx_5ecc8d"></i>
																	<span class="uiButtonText">忽略</span>
																	</a>
																	
					                    </div>
					                  
					                </div>
					              </div>
					              <div>
					                <div>
					                	<span class="title fsl fwb fcb"><a href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value="profile.userid"/>"><s:property value="profile.username"/></a>
					                		<s:if test="request.eventkey==1">
					                		邀请你成为朋友
					                		<s:if test="(request.message!=null&&request.message!=''&&request.message!='[object Window]')">(<s:property value="request.message"/>)</s:if>
					                		</s:if>
					                		<s:if test="request.eventkey==5">
					                		邀请你参加活动
					                		<a title="dota" href="event/event!viewEvent.jhtml?eventId=<s:property value="event.id"/>"><s:property value="event.eventname"/></a>
					                		</s:if>
					                		<s:if test="request.eventkey==16">
					                		邀请你回答问题<a title="dota" href="sns/question!viewQuestion.jhtml?questionId=<s:property value="question.id"/>"><s:property value="question.summary"/></a>
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
  <s:if test="requests.size()>0">
    <jsp:include page="/WEB-INF/jsp/common/pagination.jsp" flush="true" />
  </s:if>
  <s:else>
    <div class="pam uiBoxLightblue uiMorePagerPrimary">目前没有更多请求可显示。</div>
  </s:else>
</div>
      
<script>
function topage(pageNo) {
  location.href = "usr/request.jhtml?pageNo="+pageNo
  return false;
}
</script>    