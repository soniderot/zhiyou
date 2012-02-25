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
        <h2 class="uiHeaderTitle"><i class="uiHeaderImage img sp_6h8b4g sx_70f090"></i>我的活动</h2>
      </s:elseif>
      <s:else>
      	 <h2 class="uiHeaderTitle"><i class="uiHeaderImage img sp_6h8b4g sx_70f090"></i>公共活动</h2>
      </s:else>
      </div>
    </div>
  </div>
  <div id="pagelet_main_events_dashboard_list">
    <div>
      <s:if test="userevents==null||userevents.size==0">
      <div class="pam uiBoxWhite topborder">没有任何的活动。</div>
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
                  
                  <div class="uiInlineBlock uiInlineBlockMiddle">
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
                     <div class="fsm fwn fcg">活动描述：<s:property value='event.detail' /> 
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
	<s:if test="(friendFlag==false)"> 
  location.href = "event/event!getEvents.jhtml?pageNo="+pageNo
  </s:if>
  <s:else>
  location.href = "event/event!getFriendsEvents.jhtml?pageNo="+pageNo
  </s:else>
  return false;
}
</script>