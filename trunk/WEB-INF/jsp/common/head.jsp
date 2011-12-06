<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
	<div class="slim" id="blueBarHolder">
		<div id="blueBar">
			<div role="banner" id="pageHead" class="clearfix slimHeader">
				<h1 id="pageLogo">
					<a title="首页" href="http://www.facebook.com/?ref=logo"/>
				</h1>
				
				<div id="jewelContainer">
					<div id="fbRequestsJewel" class="fbJewel hasNew">
						<a data-gt='{"ua_id":"jewel:requests"}' data-target="fbRequestsFlyout" href="" name="requests" rel="toggle" class="jewelButton">
							<span id="requestsCountWrapper" class="jewelCount">
								<span id="requestsCountValue"><s:property value="newrequestcnt"/></span>
							</span>
						</a>
					</div>
					<div id="fbMessagesJewel" class="fbJewel hasNew">
						<a data-gt='{"ua_id":"jewel:messages"}' data-target="fbMessagesFlyout" name="messages" rel="toggle" class="jewelButton">
							<span id="messagesCountWrapper" class="jewelCount">
								<span id="messagesCountValue"><s:property value="newmessagecnt"/></span>
							</span>
						</a>
					</div>
					
					
					<div id="fbNotificationsJewel" class="fbJewel hasNew">
						<a data-gt='{"ua_id":"jewel:notifications"}' data-target="fbNotificationsFlyout" onclick='return run_with(this, ["min-notifications-jewel"], function() {MinNotifications.bootstrap(this)});' name="notifications" rel="toggle" class="jewelButton">
							<span id="notificationsCountWrapper" class="jewelCount">
								<span id="notificationsCountValue"><s:property value="newnotificationcnt"/></span>
							</span>
						</a>
					</div>
					<div id="jewelFlyoutContainer" class="fbJewelCaseFlyoutContainer">
						<div id="fbRequestsFlyout" class="fbJewelFlyout toggleTargetClosed">
							<div class="uiHeader uiHeaderBottomBorder jewelHeader">
								<div class="clearfix uiHeaderTop">
									<a href="http://www.facebook.com/?sk=ff" class="uiHeaderActions rfloat">搜索朋友</a>
									<div>
										<h3 class="uiHeaderTitle">朋友请求</h3>
									</div>
								</div>
							</div>
							<ul id="fbRequestsList" class="jewelItemList">
								<li id="fbRequestsList_loading_indicator">
									<img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="jewelLoading img"/>
								</li>
							</ul>
						</div>
						<div id="fbMessagesFlyout" class="fbJewelFlyout toggleTargetClosed">
							<div class="uiHeader uiHeaderBottomBorder jewelHeader">
								<div class="clearfix uiHeaderTop">
									<a rel="dialog" accesskey="m" onclick="window.Toggler &amp;&amp; Toggler.hide();" href="/ajax/messaging/composer.php" class="uiHeaderActions rfloat">发送新信息</a>
									<div>
										<h3 class="uiHeaderTitle">站内信息</h3>
									</div>
								</div>
							</div>
							<ul id="fbMessagesItemList" class="jewelItemList jewelHighlight">
								<li id="fbMessagesItemList_loading_indicator">
									<img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="jewelLoading img"/>
								</li>
							</ul>
							<div class="jewelFooter">
								<a href="http://www.facebook.com/messages/?ref=mb" class="seeMore">
									<span>查看所有信息</span>
									<span id="jewelOuterInboxCount" class="seeMoreCount fss fwn fcg">
										<span id="jewelInnerInboxCount">0</span> 条未读信息
									</span>
								</a>
							</div>
						</div>
						<div id="fbNotificationsFlyout" class="fbJewelFlyout toggleTargetClosed">
							<div class="uiHeader uiHeaderBottomBorder jewelHeader">
								<div class="clearfix uiHeaderTop">
									<div><h3 class="uiHeaderTitle">通知</h3></div>
								</div>
							</div>
							<ul data-gt='{"ref":"notif_jewel"}' id="fbNotificationsList" class="jewelItemList jewelHighlight">
								<li id="fbNotificationsList_loading_indicator">
									<img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="jewelLoading img"/>
								</li>
							</ul>
							<div class="jewelFooter">
								<a href="http://www.facebook.com/notifications" class="seeMore">
									<span>查看所有通知</span>
								</a>
							</div>
						</div>
					</div>
				</div>
				
				<div id="headNav" class="clearfix">
					<div class="lfloat">
						<form onsubmit="return Event.__inlineSubmit(this,event)" role="search" action="http://www.facebook.com/search/results.php" name="navSearch" id="navSearch" method="get">
							<div id="upob5b_1" class="uiTypeahead">
								<div class="wrap">
									<input type="hidden" class="hiddenInput" autocomplete="off"/>
									<div class="innerWrap">
										<span class="uiSearchInput textInput">
											<span>
												<input type="text" title="搜索" value="搜索" spellcheck="false" onfocus="Bootloader.loadComponents(&quot;SearchBootloader&quot;, function() {$(&quot;search_first_focus&quot;).value = $(&quot;search_first_focus&quot;).value || +new Date(); ;JSCC.get(&#39;j4ec31fa49ef5616409038223&#39;).init([&quot;searchRecorderBasic&quot;,&quot;showLoadingIndicator&quot;,&quot;initFilters&quot;]);;;});" tabindex="" autocomplete="off" placeholder="搜索" onclick='var q = $("q");if (q.value == q.getAttribute("placeholder")) {q.focus(); return false;}' name="q" id="q" accesskey="/" maxlength="100" class="inputtext DOMControl_placeholder"/>
												<button title="搜索" onclick='var q = $("q");if (q.value == q.getAttribute("placeholder")) {q.focus(); return false;}' type="submit">
													<span class="hidden_elem">搜索</span>
												</button>
											</span>
										</span>
									</div>
								</div>
							</div>
							<input type="hidden" value="quick" id="init" name="init"/>
							<input type="hidden" value="search_preload" class="search_sid_input" name="tas"/>
							<input type="hidden" value="" id="search_first_focus" name="search_first_focus"/>
						</form>
					</div>
					<div class="rfloat">
						<ul role="navigation" id="pageNav">
							<li class="topNavLink tinyman">
								<a title="个人主页" href="http://www.facebook.com/profile.php?id=1438697558&amp;ref=tn_tnmn">
									<img alt="" src="http://profile.ak.fbcdn.net/hprofile-ak-ash2/370142_1438697558_1584603112_q.jpg" class="uiProfilePhoto headerTinymanPhoto uiProfilePhotoLarge img"/>
									<span class="headerTinymanName"><s:property value="#session.user.username"/></span>
								</a>
							</li>
							<li class="topNavLink middleLink">
								<a href="http://www.facebook.com/?sk=ff">搜索朋友</a>
							</li>
							<li class="topNavLink middleLink">
								<a href="http://www.facebook.com/?ref=tn_tnmn">首页</a>
							</li>
							<li class="topNavLink" id="navAccount">
								<a aria-haspopup="1" role="button" rel="toggle" href="http://www.facebook.com/editaccount.php?ref=mb&amp;drop" id="navAccountLink">
									<div class="menuPulldown"/>
								</a>
								<ul role="navigation" class="navigation">
									<li><a accesskey="6" href="http://www.facebook.com/editaccount.php?ref=mb&amp;drop" class="navSubmenu">帐户设置</a></li>
									<li><a accesskey="7" href="http://www.facebook.com/settings/?tab=privacy&amp;ref=mb" class="navSubmenu">隐私设置</a></li>
									<li>
										<form onsubmit="return Event.__inlineSubmit(this,event)" action="/logout.php" method="post" id="logout_form">
											<input type="hidden" value="c0a81f7ab46455dde1e203435e599680" name="post_form_id" autocomplete="off"/>
											<input type="hidden" autocomplete="off" value="AQAkl6kl" name="fb_dtsg"/>
											<input type="hidden" value="mb" name="ref" autocomplete="off"/>
											<input type="hidden" value="d36ba5fa7376c19311d9436bf72eebd6" name="h" autocomplete="off"/>
											<label class="uiLinkButton logoutButton navSubmenu">
												<input type="submit" value="退出"/>
											</label>
										</form>
									</li>
									<li class="menuDivider"/>
									<li>
										<a id="navHelpCenter" href="http://www.facebook.com/help/?ref=drop" class="navSubmenu">
											<div class="clearfix">
												<div class="lfloat">帮助中心</div>
												<img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="rfloat uiLoadingIndicatorAsync img"/>
											</div>
										</a>
									</li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>