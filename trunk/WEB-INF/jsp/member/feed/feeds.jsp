<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<div role="main" id="contentArea">
	<div data-referrer="pagelet_roosters" id="pagelet_roosters"></div>
	<div data-referrer="pagelet_stream_header" id="pagelet_stream_header">
		<div class="uiHeader uiHeaderWithImage uiHeaderPage	fbx_stream_header">
			<div class="clearfix uiHeaderTop">
				<div class="uiHeaderActions	rfloat fsl fwb fcb">
					<a href="/?sk=h"><span class="fwn">热门消息</span> </a> ·
					<div id="u3mxyl_1"
						class="uiSelector inlineBlock filterListSelector	uiSelectorRight	uiSelectorNormal uiSelectorDynamicLabel">
						<div class="wrap">
							<a rel="toggle" data-length="30" aria-haspopup="1" href="#"
								role="button" class="uiSelectorButton	uiButton"> <span
								class="uiButtonText">最新消息</span> </a>
							<div class="uiSelectorMenuWrapper	uiToggleFlyout">
								<div class="uiMenu uiSelectorMenu" role="menu">
									<ul class="uiMenuInner">
										<li data-label="最新消息"
											class="uiMenuItem	uiMenuItemRadio	uiSelectorOption checked">
											<a href="/?sk=lf" aria-checked="true" tabindex="0"
												role="menuitemradio" class="itemAnchor"> <span
												class="itemLabel fsm"> <i
													class="mrs	img	sp_6h8b4g	sx_ed8728"></i>最新消息 </span> </a>
										</li>
										<li data-label="状态更新"
											class="uiMenuItem	uiMenuItemRadio	uiSelectorOption">
											<a href="/?sk=app_2915120374" aria-checked="false"
												tabindex="-1" role="menuitemradio" class="itemAnchor"> <span
												class="itemLabel fsm"> <i
													class="mrs	img	sp_cnv1wq	sx_fe0386"></i>状态更新 </span> </a>
										</li>
										<li data-label="专页"
											class="uiMenuItem	uiMenuItemRadio	uiSelectorOption">
											<a href="/?sk=pp" aria-checked="false" tabindex="-1"
												role="menuitemradio" class="itemAnchor"> <span
												class="itemLabel fsm"> <i
													class="mrs	img	sp_6h8b4g	sx_6bbf39"></i>专页 </span> </a>
										</li>
										<li data-label="提问"
											class="uiMenuItem	uiMenuItemRadio	uiSelectorOption">
											<a href="/?sk=app_10150110253435258" aria-checked="false"
												tabindex="-1" role="menuitemradio" class="itemAnchor"> <span
												class="itemLabel fsm"> <i
													class="mrs	img	sp_cnv1wq	sx_589bc0"></i>提问 </span> </a>
										</li>
										<li class="uiMenuSeparator"></li>
										<li data-label="编辑显示设置" class="uiMenuItem">
											<a ajaxify="/ajax/feed/edit_options_dialog.php?filter_key=lf"
												rel="dialog-post" href="#" tabindex="-1" role="menuitem"
												class="itemAnchor"> <span class="itemLabel fsm"><i
													class="mrs	img	sp_7gl7wd	sx_d43f0c"></i>编辑显示设置</span> </a>
										</li>
									</ul>
								</div>
							</div>
						</div>
						<select>
							<option value=""></option>
							<option selected="1" value="lf">
								最新消息
							</option>
							<option value="app_2915120374">
								状态更新
							</option>
							<option value="pp">
								专页
							</option>
							<option value="app_10150110253435258">
								提问
							</option>
						</select>
					</div>
				</div>
				<div>
					<h2 class="uiHeaderTitle">
						<i class="uiHeaderImage	img	sp_7gl7wd	sx_efd21b"></i>动态汇总
					</h2>
				</div>
			</div>
		</div>
	</div>
	<div data-referrer="pagelet_composer" id="pagelet_composer">
		<div id="u3mxyl_2"
			onclick="Bootloader.loadComponents(&quot;Composer&quot;, function() { JSCC.get(&#39;j4ec37b3f908df06889566482&#39;) });"
			class="uiComposer uiComposerHideContent stat_elem uiMetaComposer uiComposerTopBorder uiComposerOpen uiComposerHideContent uiComposerWhiteMessageBox">
			<div class="focus_target">
				<form onsubmit="return Event.__inlineSubmit(this,event)"
					method="get" action="/" class="attachmentSelectForm" rel="async">
					<ul
						onclick='var el = (event.target || event.srcElement), a = Parent.byClass(el, "uiComposerAttachment"); if (!a) { return; } var b = window.DOM &amp;&amp; DOM.find(a, "a"), f = Parent.byTag(a,"form"); f.action = a.getAttribute("data-endpoint"); b &amp;&amp; f.setAttribute("data-gt", b.getAttribute("data-gt")); f.xhpc.value = a.id; f.xhpc.click();'
						class="uiList uiListHorizontal clearfix uiComposerAttachments">
						<li
							class="uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
							<span
								data-endpoint="/ajax/metacomposer/attachment/status/status.php"
								onclick='var c; var root = Parent.byClass(this, "uiComposer");if (window.Composer &amp;&amp; (c = Composer.getInstance(this)) &amp;&amp; !CSS.hasClass(this, "uiComposerAttachmentSelected")) {c.reset(true);}CSS.addClass(this, "uiComposerAttachmentSelected");CSS.addClass(root, "uiComposerOpen");Bootloader.loadComponents("dom",function(){DOM.find(root,"textarea.mentionsTextarea").focus();});CSS.removeClass.curry(root, "async_saving").defer();'
								id="composerTourStart"
								class="uiComposerAttachment statusAttachment uiComposerAttachmentSelected attachmentAcceptsLink">
								<a href="#" tabindex="0"
								class="uiIconText attachmentLink normal"> <i
									class="img sp_7gl7wd sx_bd619c"></i> <strong
									class="attachmentName">更新信息</strong> </a> <span
								class="uiIconText selected"> <i
									class="img sp_7gl7wd sx_bd619c"></i> <strong
									class="attachmentName">更新信息<i class="nub"></i> </strong> </span> </span>
						</li>
						<li
							class="plm uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
							<span
								data-endpoint="/ajax/metacomposer/attachment/photo/photo.php"
								id="u3mxyl_4" class="uiComposerAttachment photoAttachment">
								<a href="#" tabindex="0"
								class="uiIconText attachmentLink normal"> <i
									class="img sp_6h8b4g sx_282f2a"></i> <strong
									class="attachmentName">添加照片/视频</strong> </a> <span
								class="uiIconText selected"> <i
									class="img sp_6h8b4g sx_282f2a"></i> <strong
									class="attachmentName">添加照片/视频<i class="nub"></i> </strong> </span> </span>
						</li>
						<li
							class="plm uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
							<span
								data-endpoint="/ajax/metacomposer/attachment/question/question.php?create_eigenpoll=1&amp;source=composer"
								id="u3mxyl_5" class="uiComposerAttachment"> <a href="#"
								tabindex="0" class="uiIconText attachmentLink normal"> <i
									class="img sp_7gl7wd sx_97759f"></i> <strong
									class="attachmentName">提问</strong> </a> <span
								class="uiIconText selected"> <i
									class="img sp_7gl7wd sx_97759f"></i> <strong
									class="attachmentName">提问<i class="nub"></i> </strong> </span> </span>
						</li>
						<li
							class="showWhenLoading attachmentLoader plm uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
							<img height="11" width="16" alt=""
								src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif"
								class="img" />
						</li>
					</ul>
					<input type="hidden" value="1438697558" name="targetid"
						autocomplete="off" />
					<input type="submit" name="xhpc" class="hidden_elem" />
				</form>
				<div class="showWhenOpen mutableContent uiComposerMetaContainer">
					<form onsubmit="return Event.__inlineSubmit(this,event)"
						method="post" action="/ajax/updatestatus.php"
						class="attachmentForm" rel="async">
						<input type="hidden" value="c0a81f7ab46455dde1e203435e599680"
							name="post_form_id" autocomplete="off" />
						<input type="hidden" autocomplete="off" value="AQAkl6kl"
							name="fb_dtsg" />
						<input type="hidden" value="u3mxyl_2" name="xhpc_composerid"
							autocomplete="off" />
						<input type="hidden" value="1438697558" name="xhpc_targetid"
							autocomplete="off" />
						<input type="hidden" value="home" name="xhpc_context"
							autocomplete="off" />
						<input type="hidden" value="1" name="xhpc_fbx" autocomplete="off" />
						<input type="hidden" value="" name="xhpc_timeline"
							autocomplete="off" />
						<input type="hidden" value="1" name="xhpc_ismeta"
							autocomplete="off" />
						<div class="attachmentFrame">
							<div class="attachmentContent"></div>
						</div>
						<div id="u3mxyl_6"
							class="uiMetaComposerMessageBox uiComposerMessageBoxMentions">
							<table cellspacing="0" cellpadding="0"
								class="uiMetaComposerMessageBoxTable">
								<tbody>
									<tr>
										<td>
											<div class="inputContainer">
												<div id="u3mxyl_3" class="uiMentionsInput">
													<div class="highlighter">
														<div>
															<span class="highlighterContent"></span>
														</div>
													</div>
													<div id="u3mxyl_7"
														class="uiTypeahead composerTypeahead mentionsTypeahead">
														<div class="wrap">
															<input type="hidden" class="hiddenInput"
																autocomplete="off" />
															<div class="innerWrap">
																<textarea autocomplete="off"
																	onfocus="return wait_for_load(this, event, function() {if (!this._has_control) {  new TextAreaControl(this).setAutogrow(true);  this._has_control = true; } return wait_for_load(this, event, function() {;JSCC.get(&#39;j4ec37b3f908df06889566485&#39;).init([&quot;buildBestAvailableNames&quot;,&quot;hoistFriends&quot;]);JSCC.get(&#39;j4ec37b3f908df06889566483&#39;).init({&quot;max&quot;:10}, null);;;});});"
																	placeholder="你在想什么？" name="xhpc_message" title="你在想什么？"
																	class="DOMControl_placeholder uiTextareaAutogrow input mentionsTextarea textInput">你在想什么？</textarea>
															</div>
														</div>
													</div>
													<input type="hidden" class="mentionsHidden"
														autocomplete="off" />
												</div>
												<div class="attachmentMetaArea"></div>
											</div>
										</td>
									</tr>
									<tr>
										<td>
											<div class="attachmentBottomArea"></div>
										</td>
									</tr>
								</tbody>
							</table>
							<div class="showOnceInteracted uiMetaComposerMessageBoxShelf">
								<div class="clearfix uiComposerMessageBoxControls">
									<ul
										class="uiList uiListHorizontal clearfix uiComposerBarRightArea rfloat">
										<li
											data-gt='{"composer":{"comp":"audience","ua_id":"composer:post"}}'
											id="composerTourAudience"
											class="privacyWidget uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
											<div data-referrer="pagelet_privacy_widget"
												id="pagelet_privacy_widget">
												<div class="composerAudienceWrapper stat_elem widget">
													<div data-name="audience[0][value]"
														class="uiSelector inlineBlock audienceSelector composerAudienceSelector audienceSelectorNoTruncate dynamicIconSelector uiSelectorRight uiSelectorNormal uiSelectorDynamicLabel uiSelectorDynamicTooltip">
														<div class="wrap">
															<a rel="toggle" data-length="30" aria-haspopup="1"
																href="#" role="button" onmouseout="this.blur();"
																class="uiTooltip uiSelectorButton uiButton uiButtonSuppressed">
																<i
																class="mrs defaultIcon customimg img sp_7gl7wd sx_dd5a6e"></i>
																<span class="uiButtonText">朋友</span> <span
																class="uiTooltipWrap top right righttop"> <span
																	class="uiTooltipText">你的朋友们</span> </span> </a>
															<div class="uiSelectorMenuWrapper uiToggleFlyout">
																<div class="uiMenu uiSelectorMenu" role="menu">
																	<ul class="uiMenuInner">
																		<li data-label="公开"
																			class="uiMenuItem uiMenuItemRadio uiSelectorOption fbPrivacyAudienceSelectorOption">
																			<a
																				ajaxify="/ajax/privacy/simple_save.php?id=0&amp;audience_json=%5B%7B%22value%22%3A%2280%22%7D%5D"
																				rel="async-post" href="#" aria-checked="false"
																				tabindex="0" role="menuitemradio"
																				class="itemAnchor itemWithIcon"> <i
																				class="mrs itemIcon img sp_7gl7wd sx_701c4a"></i> <span
																				class="itemLabel fsm">公开</span> </a>
																		</li>
																		<li id="u3mxyl_24" data-label="朋友"
																			class="uiMenuItem uiMenuItemRadio uiSelectorOption fbPrivacyAudienceSelectorOption checked">
																			<a
																				ajaxify="/ajax/privacy/simple_save.php?id=0&amp;audience_json=%5B%7B%22value%22%3A%2240%22%7D%5D"
																				rel="async-post" href="#" aria-checked="true"
																				tabindex="-1" role="menuitemradio"
																				class="itemAnchor itemWithIcon"> <i
																				class="mrs itemIcon img sp_7gl7wd sx_dd5a6e"></i> <span
																				class="itemLabel fsm">朋友 <span
																					class="plusLabel hidden_elem fcg"> (+)</span> </span> </a>
																		</li>
																		<li id="u3mxyl_25" data-label="自定义"
																			class="uiMenuItem uiMenuItemRadio uiSelectorOption fbPrivacyAudienceSelectorOption">
																			<a rel="ignore" href="#" aria-checked="false"
																				tabindex="-1" role="menuitemradio"
																				class="itemAnchor itemWithIcon"> <i
																				class="mrs itemIcon img sp_7gl7wd sx_853685"></i> <span
																				class="itemLabel fsm">自定义 <span
																					class="customPrivacyInputs"></span> </span> </a>
																		</li>
																		<li class="uiMenuSeparator"></li>
																		<li id="u3mxyl_26" data-label="挚友"
																			class="uiMenuItem uiMenuItemRadio uiSelectorOption fbPrivacyAudienceSelectorOption friendListOption specialOption primaryOption">
																			<a
																				ajaxify="/ajax/privacy/simple_save.php?id=0&amp;audience_json=%5B%7B%22value%22%3A%222634661952657%22%7D%5D"
																				rel="async-post" href="#" data-flid="2634661952657"
																				aria-checked="false" tabindex="-1"
																				role="menuitemradio" class="itemAnchor itemWithIcon">
																				<i class="mrs itemIcon img sp_7gl7wd sx_357d0f"></i>
																				<span class="itemLabel fsm">挚友</span> </a>
																		</li>
																		<li id="u3mxyl_27" data-label="家人"
																			class="uiMenuItem uiMenuItemRadio uiSelectorOption fbPrivacyAudienceSelectorOption friendListOption specialOption primaryOption">
																			<a
																				ajaxify="/ajax/privacy/simple_save.php?id=0&amp;audience_json=%5B%7B%22value%22%3A%222634662072660%22%7D%5D"
																				rel="async-post" href="#" aria-checked="false"
																				tabindex="-1" role="menuitemradio"
																				class="itemAnchor itemWithIcon"> <i
																				class="mrs itemIcon img sp_7gl7wd sx_0a8b75"></i> <span
																				class="itemLabel fsm">家人</span> </a>
																		</li>
																		<li id="u3mxyl_22" data-label="点头之交"
																			class="uiMenuItem uiMenuItemRadio uiSelectorOption fbPrivacyAudienceSelectorOption friendListOption specialOption primaryOption">
																			<a
																				ajaxify="/ajax/privacy/simple_save.php?id=0&amp;audience_json=%5B%7B%22value%22%3A%221438697558_124542800973931%22%7D%5D"
																				rel="async-post" href="#"
																				data-flid="1438697558_124542800973931"
																				aria-checked="false" tabindex="-1"
																				role="menuitemradio" class="itemAnchor itemWithIcon">
																				<i class="mrs itemIcon img sp_7gl7wd sx_7f568c"></i>
																				<span class="itemLabel fsm">点头之交</span> </a>
																		</li>
																		<li class="uiMenuSeparator secondaryOption"></li>
																		<li data-label="Return"
																			class="uiMenuItem uiMenuItemRadio uiSelectorOption returnOption secondaryOption specialOption">
																			<a rel="ignore" href="#" aria-checked="false"
																				tabindex="-1" role="menuitemradio"
																				class="itemAnchor"> <span class="itemLabel fsm">Return</span>
																			</a>
																		</li>
																	</ul>
																</div>
															</div>
														</div>
														<select name="audience[0][value]">
															<option value=""></option>
															<option value="80">
																公开
															</option>
															<option selected="1" value="40">
																朋友
															</option>
															<option value="111">
																自定义
															</option>
															<option value="2634661952657">
																挚友
															</option>
															<option value="2634662072660">
																家人
															</option>
															<option value="1438697558_124542800973931">
																点头之交
															</option>
															<option value="Return">
																Return
															</option>
														</select>
													</div>
												</div>
											</div>
										</li>
										<li
											class="pls uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
											<label for="u3mxyl_8"
												class="submitBtn uiButton uiButtonConfirm">
												<input type="submit" id="u3mxyl_8" value="发布" />
											</label>
										</li>
									</ul>
									<div>
										<div class="pls textBlurb fsm fwn fcg"></div>
										<div class="attachmentBarArea">
											<span class="uiComposerTagControls friendTaggerIcon"></span>
											<span class="uiComposerTagControls placeTaggerIcon"></span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div data-gt='{"ref":"nf"}' data-referrer="pagelet_home_stream"
		id="pagelet_home_stream">
		<div id="c4ec37b3fc7e022d58174072"
			class="UIIntentionalStream UIStream">
			<ul id="home_stream"
				class="uiList uiStream UIIntentionalStream_Content"
				data-referrer="home_stream" style="min-height: 100px;">
			<s:iterator value="feeds">
				<li id="stream_story_4ec37b3fd947b3232640247"
					data-ft='{"qid":"5675515467749930831","mf_story_key":"2652098748566","c":"m"}'
					class="pvm uiUnifiedStory uiStreamStory genericStreamStory aid_1438697558 uiListItem uiListLight uiListVerticalItemBorder">
					<div class="storyHighlightIndicatorWrapper"></div>
					<div class="storyContent">
						<div class="UIImageBlock clearfix">
							<a data-hovercard="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="user.userid"/>"
								aria-hidden="true" data-ft='{"type":60}'
								href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="user.userid"/>"
								tabindex="-1"
								class="actorPhoto UIImageBlock_Image UIImageBlock_MED_Image">
								<img alt=""
									src="<s:property value="user.avatar"/>"
									class="uiProfilePhoto profilePic uiProfilePhotoLarge img" /> </a>
							<div
								class="storyInnerContent UIImageBlock_Content UIImageBlock_MED_Content">
								<div class="mainWrapper">
									
									<h6 data-ft='{"type":1}' class="uiStreamMessage">
										<div data-ft='{"type":2}' class="actorDescription actorName">
											<a data-hovercard="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="user.userid"/>"
												href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="user.userid"/>">
												<s:property value="user.username"/></a>
												<s:if test="feed.handle=='sns.share.connection'">   
													和<a href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="friend.userid"/>"> <s:property value="friend.username"/></a>变为朋友
										  </s:if>
										</div>
										<s:if test="feed.handle=='sns.publish.text'">  
										<span data-ft='{"type":3}' class="messageBody"><s:property value="feed.body"/></span>
										</s:if>
										
										<s:if test="feed.handle=='sns.event.create'">   
										<%@ include file="/WEB-INF/jsp/member/feed/eventfeed.jsp"%>
										</s:if> 
										
										
										
									</h6>
								
								</div>
							</div>
						</div>
					</div>
				</li>
				</s:iterator>
				
		
			</ul>
			
			<div>
				<div id="pagelet_stream_pager" data-referrer="pagelet_stream_pager">
					<div class="clearfix mts uiMorePager stat_elem fbStreamPager">
						<a href="/ajax/feed/edit_options_dialog.php?filter_key=lf"
							rel="dialog" class="uiMorePagerSecondary rfloat">编辑选项</a>
						<div>
							<div class="pam uiBoxLightblue uiMorePagerPrimary">
								目前没有更多动态可显示。
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>