<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>

<script type="text/javascript">
setTimeout("freshNotice()", 1000);
function freshNotice() {
  $.ajax({
     type: "GET",
     url: "usr/feed!getNoticeAjax.jhtml",
     dataType: 'text',
     success: function(data) {
       var count = data.split(" ");
       var requestcnt = count[0];
       var messagecnt = count[1];
       var noticecnt = count[2];
       if (requestcnt > 0) {
          $("#fbRequestsJewel").addClass("hasNew");
          $("#requestsCountValue").text(requestcnt);
       } else {
          $("#fbRequestsJewel").removeClass("hasNew");
       }
       if (messagecnt > 0) {
          $("#fbMessagesJewel").addClass("hasNew");
          $("#messagesCountValue").text(messagecnt);
       } else {
          $("#fbMessagesJewel").removeClass("hasNew");
       }
       if (noticecnt > 0) {
          $("#fbNotificationsJewel").addClass("hasNew");
          $("#notificationsCountValue").text(noticecnt);
       } else {
          $("#fbNotificationsJewel").removeClass("hasNew");
       }
     }
  });
  setTimeout("freshNotice()", 1000);
}
</script>
  <div class="slim" id="blueBarHolder">
    <div id="blueBar">
      <div role="banner" id="pageHead" class="clearfix slimHeader">
        <h1 id="pageLogo">
          <a  title="首页" href="/usr/landing.jhtml"/>
        </h1>
        
        <div id="jewelContainer">
          <div id="fbRequestsJewel" class="fbJewel <s:if test="newrequestcnt>0"> hasNew  </s:if>" >
            <a href="usr/request.jhtml" name="requests" rel="toggle" class="jewelButton">
              <span id="requestsCountWrapper" class="jewelCount">
                <span id="requestsCountValue"><s:property value="newrequestcnt"/></span>
              </span>
            </a>
          </div>
          <div id="fbMessagesJewel" class="fbJewel <s:if test="newmessagecnt>0"> hasNew  </s:if>">
            <a name="messages" rel="toggle" href = "usr/message.jhtml" class="jewelButton">
              <span id="messagesCountWrapper" class="jewelCount">
                <span id="messagesCountValue"><s:property value="newmessagecnt"/></span>
              </span>
            </a>
          </div>
          
          <div id="fbNotificationsJewel" class="fbJewel <s:if test="newnotificationcnt>0"> hasNew  </s:if>">
            <a href="usr/notify.jhtml" name="notifications" rel="toggle" class="jewelButton">
              <span id="notificationsCountWrapper" class="jewelCount">
                <span id="notificationsCountValue"><s:property value="newnotificationcnt"/></span>
              </span>
            </a>
          </div>
         
        </div>
        
        <div id="headNav" class="clearfix">
         
         <div class="lfloat">
						<form  role="search" action="sns/sns!keyWordSearch.jhtml" name="navSearch" id="navSearch" method="get">
						
							<div id="upob5b_1" class="uiTypeahead">
								<div class="wrap">
									<input type="hidden" class="keywordsearch" value="true"/>
									<div class="innerWrap">
										<span class="uiSearchInput textInput">
											<span>
												<input type="text" title="搜索"  spellcheck="false" onfocus="Bootloader.loadComponents(&quot;SearchBootloader&quot;, function() {$(&quot;search_first_focus&quot;).value = $(&quot;search_first_focus&quot;).value || +new Date(); ;JSCC.get(&#39;j4ec31fa49ef5616409038223&#39;).init([&quot;searchRecorderBasic&quot;,&quot;showLoadingIndicator&quot;,&quot;initFilters&quot;]);;;});" tabindex="" autocomplete="off" placeholder="搜索" onclick='var q = $("q");if (q.value == q.getAttribute("placeholder")) {q.focus(); return false;}' name="keyword" value="<s:property value="keyword"/>" id="q" accesskey="/" maxlength="100" class="inputtext DOMControl_placeholder"/>
												<button title="搜索" onclick='var q = $("q");if (q.value == q.getAttribute("placeholder")) {q.focus(); return false;}' type="submit">
													<span class="hidden_elem">搜索</span>
												</button>
											</span>
										</span>
									</div>
								</div>
							</div>
							
						</form>
					</div>
         
         
          <div class="rfloat">
            <ul role="navigation" id="pageNav">
            	<li class="topNavLink middleLink">
                <a href="/usr/landing.jhtml">首页</a>
              </li>
              <li class="topNavLink tinyman">
                <a title="个人主页" href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="#session.user.userid"/>">
                  <span class="headerTinymanName">个人信息</span>
                </a>
              </li>
              <li class="topNavLink middleLink">
                <a href="/sns/sns!search.jhtml">搜索朋友</a>
              </li>
              <li class="topNavLink" id="navAccount">
                
                <a href="javascript:void(0);" id="navAccountLink" onclick="listToggle()">
                  <div class="menuPulldown"></div>
                </a>
                <ul role="navigation" class="navigation">
                  <li>
                    <a accesskey="6" href="usr/account.jhtml" class="navSubmenu">帐户设置</a>
                  </li>
                  <li>
                    <form action="usr/logout.jhtml" method="post">
                      <label class="uiLinkButton logoutButton navSubmenu">
                        <input type="submit" value="退出"/>
                      </label>
                     </form>
                   </li>
                   <!--
                   <li class="menuDivider"></li>
                    
                   <li>
                      <a target="_blank" id="navHelpCenter" href="#" class="navSubmenu">
                      <div class="clearfix">
                        <div class="lfloat">帮助中心</div>
                        <img height="11" width="16" alt="" src="#" class="rfloat uiLoadingIndicatorAsync img"/>
                      </div>
                      </a>
                    </li>
                   -->
                  </ul>
                </li>
             
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>