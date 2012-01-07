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
						                  </li>
						                </ul>
						              </td>
						            </tr>
						          </tbody>
						        </table>
						        
                    </div>
                  </div>
                  <div class="mbs clearfix" id="MessagingMainContent">
                    <ul class="uiList" id="MessagingThreadlist">
                    	<s:if test="(requests==null||requests.size()==0)">
                    		
                    		
                    		 <li class="threadRow noDraft uiListItem uiListLight uiListVerticalItemBorder" id="id.237791252950736">
                        <table cellspacing="0" cellpadding="0" class="uiGrid">
                          <tbody>
                            <tr>
                               <td class="threadMainCol">
                                
                                <div class="snippet fsm fwn fcg">
                                        <i class="mrs indicator img sp_d1pr3k sx_18fadf"></i>
                                        <span id="snippet_id.237791252950736"><s:property value="content"/>没有新的请求</span>
                                 </div>
                              </td>
                             
                            </tr>
                          </tbody>
                        </table>
                      </li>
                       
                    	</s:if>
                   <s:iterator value="requests">
                      <li class="threadRow noDraft uiListItem uiListLight uiListVerticalItemBorder" id="id.237791252950736">
                        <table cellspacing="0" cellpadding="0" class="uiGrid">
                          <tbody>
                            <tr>
                              <td class="threadMainCol">
                                <a class="threadLink" href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="profile.userid"/>" rel="ignore">
                                  <div class="UIImageBlock clearfix pvs">
                                    <img class="uiProfilePhoto UIImageBlock_Image UIImageBlock_MED_Image uiProfilePhotoLarge img" src="<s:property value="profile.avatar"/>" alt="">
                                    
                                    <div class="content UIImageBlock_Content UIImageBlock_MED_Content">
                                      <div class="authorsWrapper">
                                        <strong class="authors"><s:property value="profile.username"/></strong>
                                        <span class="mls mutualFriends fsm fwn fcg"></span>
                                      </div>
                                      
                                    </div>
                                  </div>
                                  
                                </a>
                              
                              
                              
                              
                              </td>
                              
                               <td class="threadMainCol">
                                
                                <div class="snippet fsm fwn fcg">
                                        
                                         <s:if test="request.eventkey==1">
                                        <span id="snippet_id.237791252950736"><s:property value="content"/><s:if test="(formatedMsg!=null&&formatedMsg!=''&&formatedMsg!='[object Window]')">(<s:property value="formatedMsg"/>)</s:if></span>
                                 			</s:if>
                                 			 <s:if test="request.eventkey==5">
                                        <span id="snippet_id.237791252950736"><s:property value="content"/><a title="dota" href="event/event!viewEvent.jhtml?eventId=<s:property value="event.id"/>"><s:property value="event.eventname"/></a></span>
                                 			</s:if>
                                 </div>
                              </td>
                              
                              
                              
                              <td class="plm">
                                
                                <a class="uiTooltip markAsUnreadLink" onmouseout="this.blur();" href="/usr/request!approveRequest.jhtml?requestId=<s:property value="request.id"/>"  rel="async-post">
                                  <span class="readState markunread"></span>
                                  <span class="uiTooltipWrap top right righttop">
                                    <span class="uiTooltipText">同意</span>
                                  </span>
                                </a>
                              </td>
                              <td class="pls">
                                <a class="uiTooltip archiveLink" onmouseout="this.blur();"  href="/usr/request!deleteRequest.jhtml?requestId=<s:property value="request.id"/>" rel="async-post">
                                  <label class="uiCloseButton uiCloseButtonSmall" for="up3vb3_4">
                                    <input type="button" title="" id="up3vb3_4">
                                  </label>
                                  <span class="uiTooltipWrap top right righttop">
                                    <span class="uiTooltipText">删除</span>
                                  </span>
                                </a>
                              </td>
                            </tr>
                          </tbody>
                        </table>
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