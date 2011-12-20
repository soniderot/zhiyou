<%@page contentType="textml;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<div id="contentArea" role="main">
					  <div id="pagelet_events">
					    <div class="uiHeader uiHeaderWithImage uiHeaderPage">
					      <div class="clearfix uiHeaderTop">
					      	<a class="uiHeaderActions rfloat uiButton" role="button" href="event/createOrUpdate!createOrUpdate.jhtml">
					      		<i class="mrs img sp_ah6icc sx_9e9f95"></i>
					      		<span class="uiButtonText">创建活动</span>
					      	</a>
					        <div>
					        	<s:if test="(friendFlag==true)"> 
					          <h2 class="uiHeaderTitle"><i class="uiHeaderImage img sp_9tlaa1 sx_67bb7d"></i>朋友的活动</h2>
					          </s:if> 
					          <s:else>
					          	<h2 class="uiHeaderTitle"><i class="uiHeaderImage img sp_9tlaa1 sx_67bb7d"></i>我的活动</h2>
					          </s:else>
					        </div>
					      </div>
					    </div>
					    <div>
					      <div class="uiHeader uiHeaderTopAndBottomBorder uiHeaderSection">
					        <div class="clearfix uiHeaderTop">
					          <div>
					          	<s:if test="(friendFlag==true)"> 
					            <h3 class="uiHeaderTitle">朋友的近期活动</h3>
					          </s:if> 
					          <s:else>
					          	<h3 class="uiHeaderTitle">我的近期活动</h3>
					         </s:else>
					          </div>
					        </div>
					      </div>
					      <div class="phs">
					        <ul class="uiList fbxevents_eventlist">
					        	
					        	 <s:iterator value="userevents">
					          <li class="objectListItem uiListItem uiListLight uiListVerticalItemBorder">
					            <div class="UIImageBlock clearfix UIImageBlock_Entity">
					            	<a class="UIImageBlock_Image UIImageBlock_ENT_Image" href="event/event!viewEvent.jhtml?eventId=<s:property value="event.id" />" tabindex="-1" aria-hidden="true"><img class="img" src="<s:property value="event.logo" />" alt=""></a>
					              <div class="auxiliary UIImageBlock_Ext" id="req_251994978194505">
					              
					               <s:if test="(joined==true)"> 
					                <div class="fsm fwn fcg">
					                	<a href="event/event!quitEvent.jhtml?eventId=<s:property value="event.id" />" rel="async-post" ajaxify="/ajax/events/dashboard/join.php?eid=251994978194505">退出</a> · 
					                	
					                </div>
					             </s:if> 
					             <s:else>
					             		 <div class="fsm fwn fcg">
					                	<a href="event/event!joinEvent.jhtml?eventId=<s:property value="event.id" />" rel="async-post" ajaxify="/ajax/events/dashboard/join.php?eid=251994978194505">加入</a> · 
					                	
					                </div>
					            </s:else>
					              </div>
					              <div class="UIImageBlock_Content UIImageBlock_ENT_Content">
					              	<span class="mrs fsl fwb fcb">
					              		<a href="event/event!viewEvent.jhtml?eventId=<s:property value="event.id" />" title="dota"><s:property value="event.eventname" /></a>
					              	</span>
					                <div class="fsm fwn fcg"><s:date name="event.begintime" format="yyyy-MM-dd HH:mm" /></div>
					                	<!--
					                <div class="fsm fwn fcg"><a href="http://www.facebook.com/mkk158">位会员将参加</a>将参加</div>
					                -->
					                <div class="fsm fwn fcg"><s:property value="members.size()" />位会员将将参加</div>
					              </div>
					            </div>
					          </li>
					          </s:iterator>
					        </ul>
					      </div>
					    </div>
					    <!----
					    <div>
					      <div class="uiHeader uiHeaderTopAndBottomBorder mtm uiHeaderSection">
					        <div class="clearfix uiHeaderTop">
					          <div>
					            <h3 class="uiHeaderTitle">本周</h3>
					          </div>
					        </div>
					      </div>
					      <div class="phs">
					        <ul class="uiList fbxevents_eventlist">
					          <li class="objectListItem uiListItem uiListLight uiListVerticalItemBorder">
					            <div class="UIImageBlock clearfix UIImageBlock_Entity">
					            	<a class="UIImageBlock_Image UIImageBlock_ENT_Image" href="http://www.facebook.com/events/297786820255644/" tabindex="-1" aria-hidden="true">
					            		<img class="img" src="http://profile.ak.fbcdn.net/hprofile-ak-ash2/370142_1438697558_1584603112_q.jpg" alt="">
					            	</a>
					              <div class="auxiliary UIImageBlock_Ext" id="req_297786820255644">
					                <div class="fsm fwn fcg">你已确认参加</div>
					              </div>
					              <div class="UIImageBlock_Content UIImageBlock_ENT_Content">
					              	<span class="mrs fsl fwb fcb"><a href="http://www.facebook.com/events/297786820255644/" title="钓鱼">钓鱼</a></span>
					                <div class="fsm fwn fcg">2011年12月3日 7:00</div>
					                <div class="fsm fwn fcg"><a href="http://www.facebook.com/mkk158">ま か</a>将参加</div>
					              </div>
					            </div>
					          </li>
					        </ul>
					      </div>
					    </div>
					    ------>
					    <div class="clearfix uiPager uiPagerTopBorder">
					      <div class="summary lfloat fsm fcg">
					        <div class="prm">
					          <div class="fsm fwn fcg">
					          	<!----
					          	<a href="/events/past/">已结束的活动</a> · 
					          	<a href="/events/birthdays/">生日列表</a> · 
					          	<a href="/ajax/events/export_events_dialog.php" rel="dialog">导出到日历</a>--->
					          </div>
					        </div>
					      </div>
					      <div class="rfloat">
					      	<a class="prev uiButtonDisabled uiButton uiButtonNoText" role="button" data-href="/?sk=fe&amp;s=-1">
					      		<i class="mrs customimg img sp_9dewam sx_48249a"></i>
					      		<span class="uiButtonText"></span>
					      	</a>
					      	<a class="next uiButtonDisabled uiButton uiButtonNoText" role="button" data-href="/?sk=fe&amp;s=1">
					      		<i class="mrs customimg img sp_9dewam sx_ce0533"></i>
					      		<span class="uiButtonText"></span>
					      	</a>
					      </div>
					    </div>
					  </div>
					</div>