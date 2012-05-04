<%@page contentType="textml;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<div id="contentArea">
  <div class="uiHeader uiHeaderWithImage uiHeaderPage">
    <div class="clearfix uiHeaderTop">
      <div class="uiToolbar uiToolbarUnbordered uiHeaderActions rfloat">
        <div class="clearfix uiToolbarContent">
          <div>
            <a href="event/createOrUpdate!createOrUpdate.jhtml" class="uiToolbarItem uiButton">
              <i class="mrs img sp_tdh7xb sx_4b9f00"></i><span class="uiButtonText">创建活动</span>
            </a>
          </div>
        </div>
      </div>
      <div>
      	<s:if test="(friendFlag==true)"> 
        <h2 class="uiHeaderTitle"><i class="uiHeaderImage img sp_6h8b4g sx_70f090"></i>朋友的活动</h2>
      </s:if>
      <s:elseif test="(publicflag==0)"> 
        <h2 class="uiHeaderTitle"><i class="uiHeaderImage img sp_6h8b4g sx_70f090"></i>
        	<s:if test="(followEventFlag==true)"> 
        	我感兴趣的活动 
        	</s:if>
        	<s:if test="(followEventFlag==false)"> 
        	我的活动
        	</s:if>
        	</h2>
    
      </s:elseif>
      <s:else>
      	 <h2 class="uiHeaderTitle"><i class="uiHeaderImage img sp_6h8b4g sx_70f090"></i>公共活动</h2>
      </s:else>
      <br>
      <s:if test="(followEventFlag==true)"> 
      <a  href="event/event!getMyEvents.jhtml">我的活动</a>
      </s:if>
      <s:if test="(followEventFlag==false)"> 
      <a  href="event/event!getMyFollowEvents.jhtml">我感兴趣的活动</a>
      </s:if>
      </div>
    </div>
  </div>
  <div id="pagelet_main_events_dashboard_list">
    <div>
      <s:if test="userevents==null||userevents.size==0">
      	<div class="UIImageBlock clearfix fbxNullState">
								<i class="UIImageBlock_Image UIImageBlock_SMALL_Image img sp_9dewam sx_83050b"></i>
								<div class="UIImageBlock_Content UIImageBlock_SMALL_Content">
									<p>没有即将举行的活动。
										<a class="pls" href="/event/createOrUpdate!createOrUpdate.jhtml">创建活动</a>
									</p>
								</div>
							</div>
      
      </s:if>
      <s:iterator value="userevents">
      
      <s:if test="newDateFlag">
      <div class="uiHeader uiHeaderTopAndBottomBorder uiHeaderSection">
        <div class="clearfix uiHeaderTop">
          <div>
            <h3 class="uiHeaderTitle" tabindex="0"><s:date name="event.begintime" format="yyyy年MM月dd日" /></h3>
          </div>
        </div>
      </div>
    </s:if>
      
      <ul class="uiList phs">
        <li class="uiListItem uiListLight uiListVerticalItemBorder">
          <div class="pvm uiBoxWhite noborder">
            <div class="clearfix uiImageBlock">
              <a href="event/event!viewEvent.jhtml?eventId=<s:property value="event.id" />" class="uiImageBlockImage uiImageBlockLargeImage lfloat">
                <img alt="" src="<s:property value="event.logo" />" class="fbProfileLargePortraitImgScaleWidth fbProfileLargePortraitImgScaleHeight img"/>
              </a>
              <div class="clearfix uiImageBlockContent">
                <div class="uiInlineBlock mlm rfloat">
                  <div style="height: 50px;" class="uiInlineBlock uiInlineBlockMiddle"></div>
                 
                  	<!--
                  <div class="uiInlineBlock uiInlineBlockMiddle">
                    <div id="req_220103838085749" class="mvl">
                      <div class="fbEventStatus fsm fwn fcg">你是发起人</div>
                    </div>
                  </div>-->
                  
                  <div class="uiInlineBlock uiInlineBlockTop">
                    <div id="req_220103838085749" class="mvl">
                      <div class="stat_elem">
                        <div class="fbEventListItemActions fsm fwn fcg">
                          <s:if test="(expired==true)">
                                已结束
                          </s:if>
                          <s:elseif test="(joined==true)">
                            <a href="event/event!quitEvent.jhtml?eventId=<s:property value="event.id" />">退出</a>
                          </s:elseif>
                          <s:else>
                            <a href="event/event!joinEvent.jhtml?eventId=<s:property value="event.id" />">加入</a>
                            	
                            <s:if test="(followFlag==false)">
                            <a href="event/event!followEvent.jhtml?eventId=<s:property value="event.id" />">有兴趣</a>
                            </s:if>
                            <s:else>
                            	<a href="event/event!notFollowEvent.jhtml?eventId=<s:property value="event.id" />">取消关注</a>
                            </s:else>
                          </s:else>
                        </div>
                        <div class="mrl">
                          <img class="uiLoadingIndicatorAsync img" alt="" src="/images/GsNJNwuI-UM.gif" width="16" height="11"/>
                        </div>
                      </div>
                      <div class="fbEventStatus fsm fwn fcg"></div>
                    </div>
                  </div>
                  
                </div>
                <div class="uiProfileBlockContent">
                  <div class="uiInlineBlock">
                    <div style="height: 50px;" class="uiInlineBlock uiInlineBlockMiddle"></div>
                    <div class="uiInlineBlock uiInlineBlockMiddle">
                      <div>
                        <div class="fsl fwb fcb">
                          <a href="event/event!viewEvent.jhtml?eventId=<s:property value='event.id' />"><s:property value="event.eventname" /></a>
                        </div>
                        <div class="fsm fwn fcg">举办时间：<s:date name="event.begintime" format="yyyy-MM-dd HH:mm" /> 至 <s:date name="event.endtime" format="yyyy-MM-dd HH:mm" /></div>
                        
                      </div>
                      
                      <div class="fsm fwn fcg">举办地点：<s:property value='event.address' /> 
                     <div class="fsm fwn fcg" style="white-space:nowrap">活动描述：<s:if test="event.detail.length()>20"><s:property value='event.detail.substring(0,20)' />... </s:if><s:else><s:property value='event.detail' /></s:else>
                       <div class="fsm fwn fcg">参加人数：<s:property value='members.size()' />  照片数：<s:property value='event.photosCnt' /> 评论数：<s:property value='event.commentsCnt' />
                       	
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </li>
      </ul>
      </s:iterator>
    </div>
  </div>
  
<s:if test="userevents.size()>0">
		<jsp:include page="/WEB-INF/jsp/common/pagination.jsp" flush="true" />
</s:if>
</div>
	
<script>
function topage(pageNo) {
	<s:if test="(friendFlag==true)"> 
  location.href = "event/event!getFriendsEvents.jhtml?pageNo="+pageNo
  </s:if>
  <s:elseif test="(followEventFlag==true)">
  location.href = "event/event!getFollowEvents.jhtml?pageNo="+pageNo
  </s:elseif>
  <s:elseif test="(publicflag==1)">
  location.href = "event/event!getPubEvents.jhtml?pageNo="+pageNo
  </s:elseif>
  <s:else>
  location.href = "event/event!getMyEvents.jhtml?pageNo="+pageNo
  </s:else>
  return false;
}
</script>