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
				<li id="stream_story_4ec37b3fd8ba95881006138"
					data-ft='{"qid":"5675515467749930831","mf_story_key":"2652135669489","c":"m"}'
					class="pvm uiUnifiedStory uiStreamStory genericStreamStory aid_1438697558 aid_10150110253435258 uiListItem uiListLight uiListVerticalItemBorder">
					<div class="storyHighlightIndicatorWrapper"></div>
					<div class="storyContent">
						<div class="UIImageBlock clearfix">
							<a data-hovercard="/ajax/hovercard/hovercard.php?id=1438697558"
								aria-hidden="true" data-ft='{"type":60}'
								href="http://www.facebook.com/profile.php?id=1438697558"
								tabindex="-1"
								class="actorPhoto UIImageBlock_Image UIImageBlock_MED_Image">
								<img alt=""
									src="../../images/370142_1438697558_1584603112_q.jpg"
									class="uiProfilePhoto profilePic uiProfilePhotoLarge img" /> </a>
							<div
								class="storyInnerContent UIImageBlock_Content UIImageBlock_MED_Content">
								<div class="mainWrapper">
									<div id="u3mxyl_21"
										class="uiSelector inlineBlock mlm audienceSelector uiStreamHide audienceSelectorNoTruncate dynamicIconSelector uiSelectorRight uiSelectorNormal uiSelectorDynamicTooltip">
										<div class="wrap">
											<a rel="toggle" data-tooltip="Your friends" data-length="30"
												aria-haspopup="1" href="#"
												ajaxify="/ajax/feed/feed_menu_personal.php?ministory_key=48656396392992130&amp;profile_fbid=1438697558&amp;story_type=280&amp;story_id=stream_story_4ec37b3fd8ba95881006138&amp;story_fbids%5B0%5D=1438697558%3A2652135709490&amp;remove=1&amp;is_spam_filter=0&amp;context_menu%5Bremove_content%5D=1&amp;reportable=1&amp;flag_link=%2Fajax%2Fspam_action.php%3FobjectID%3D2652135669489%26objectType%3D61%26paramString%3D1438697558_1438697558_1438697558%26action%3Dmark_spam&amp;actor_id=1438697558&amp;object_name=%E9%97%AE%E9%A2%98&amp;app_id=10150110253435258"
												role="button" onmouseout="this.blur();"
												class="uiTooltip uiSelectorButton uiButton uiButtonSuppressed uiButtonNoText">
												<i class="mrs defaultIcon customimg img sp_7gl7wd sx_dd5a6e"></i>
												<span class="uiButtonText"></span> <span
												class="uiTooltipWrap top right righttop"> <span
													class="uiTooltipText">Your friends</span> </span> </a>
											<div class="uiSelectorMenuWrapper uiToggleFlyout">
												<div class="uiMenu uiSelectorMenu" role="menu">
													<ul class="uiMenuInner">
														<li data-label="公开"
															class="uiMenuItem uiMenuItemRadio uiSelectorOption fbPrivacyAudienceSelectorOption">
															<a
																ajaxify="/ajax/privacy/simple_save.php?id=2652135669489&amp;audience_json=%7B%222652135669489%22%3A%7B%22value%22%3A%2280%22%7D%7D"
																rel="async-post" href="#" aria-checked="false"
																tabindex="0" role="menuitemradio"
																class="itemAnchor itemWithIcon"> <i
																class="mrs itemIcon img sp_7gl7wd sx_701c4a"></i> <span
																class="itemLabel fsm">公开</span> </a>
														</li>
														<li data-label="朋友"
															class="uiMenuItem uiMenuItemRadio uiSelectorOption fbPrivacyAudienceSelectorOption checked">
															<a
																ajaxify="/ajax/privacy/simple_save.php?id=2652135669489&amp;audience_json=%7B%222652135669489%22%3A%7B%22value%22%3A%2240%22%7D%7D"
																rel="async-post" href="#" aria-checked="true"
																tabindex="-1" role="menuitemradio"
																class="itemAnchor itemWithIcon"> <i
																class="mrs itemIcon img sp_7gl7wd sx_dd5a6e"></i> <span
																class="itemLabel fsm">朋友 <span
																	class="plusLabel hidden_elem fcg"> (+)</span> </span> </a>
														</li>
														<li id="u3nxxa_2" data-label="自定义"
															class="uiMenuItem uiMenuItemRadio uiSelectorOption fbPrivacyAudienceSelectorOption">
															<a rel="ignore" href="#" aria-checked="false"
																tabindex="-1" role="menuitemradio"
																class="itemAnchor itemWithIcon"> <i
																class="mrs itemIcon img sp_7gl7wd sx_853685"></i> <span
																class="itemLabel fsm">自定义 <span
																	class="customPrivacyInputs"></span> </span> </a>
														</li>
														<li class="uiMenuSeparator"></li>
														<li id="u3nxxa_3" data-label="挚友"
															class="uiMenuItem uiMenuItemRadio uiSelectorOption fbPrivacyAudienceSelectorOption friendListOption specialOption primaryOption">
															<a
																ajaxify="/ajax/privacy/simple_save.php?id=2652135669489&amp;audience_json=%7B%222652135669489%22%3A%7B%22value%22%3A%222634661952657%22%7D%7D"
																rel="async-post" href="#" data-flid="2634661952657"
																aria-checked="false" tabindex="-1" role="menuitemradio"
																class="itemAnchor itemWithIcon">\ <i
																class="mrs itemIcon img sp_7gl7wd sx_357d0f"></i> <span
																class="itemLabel fsm">挚友</span> </a>
														</li>
														<li id="u3nxxa_4" data-label="家人"
															class="uiMenuItem uiMenuItemRadio uiSelectorOption fbPrivacyAudienceSelectorOption friendListOption specialOption primaryOption">
															<a
																ajaxify="/ajax/privacy/simple_save.php?id=2652135669489&amp;audience_json=%7B%222652135669489%22%3A%7B%22value%22%3A%222634662072660%22%7D%7D"
																rel="async-post" href="#" aria-checked="false"
																tabindex="-1" role="menuitemradio"
																class="itemAnchor itemWithIcon"> <i
																class="mrs itemIcon img sp_7gl7wd sx_0a8b75"></i> <span
																class="itemLabel fsm">家人</span> </a>
														</li>
														<li id="u3nxxa_1" data-label="点头之交"
															class="uiMenuItem uiMenuItemRadio uiSelectorOption fbPrivacyAudienceSelectorOption friendListOption specialOption primaryOption">
															<a
																ajaxify="/ajax/privacy/simple_save.php?id=2652135669489&amp;audience_json=%7B%222652135669489%22%3A%7B%22value%22%3A%221438697558_124542800973931%22%7D%7D"
																rel="async-post" href="#"
																data-flid="1438697558_124542800973931"
																aria-checked="false" tabindex="-1" role="menuitemradio"
																class="itemAnchor itemWithIcon"> <i
																class="mrs itemIcon img sp_7gl7wd sx_7f568c"></i> <span
																class="itemLabel fsm">点头之交</span> </a>
														</li>
														<li class="uiMenuSeparator secondaryOption"></li>
														<li data-label="Return"
															class="uiMenuItem uiMenuItemRadio uiSelectorOption returnOption secondaryOption specialOption">
															<a rel="ignore" href="#" aria-checked="false"
																tabindex="-1" role="menuitemradio" class="itemAnchor">
																<span class="itemLabel fsm">Return</span> </a>
														</li>
														<li class="uiMenuSeparator"></li>
														<li data-label="删除帖子" class="uiMenuItem">
															<a href="#"
																ajaxify="/ajax/minifeed.php?action_key=remove_content&amp;story_fbids%5B0%5D=1438697558%3A2652135709490&amp;subject_name=%E9%97%AE%E9%A2%98&amp;dialog=1&amp;ministory_key=48656396392992130&amp;profile_fbid=1438697558&amp;story_type=280&amp;feedback=1&amp;story_id=stream_story_4ec37b3fd8ba95881006138&amp;app_id=10150110253435258"
																rel="async-post" tabindex="-1" role="menuitem"
																class="itemAnchor"> <span class="itemLabel fsm">删除帖子...</span>
															</a>
														</li>
														<li class="uiMenuSeparator"></li>
														<li data-label="举报/标记为垃圾信息" class="uiMenuItem">
															<a href="#"
																ajaxify="/ajax/spam_action.php?objectID=2652135669489&amp;objectType=61&amp;paramString=1438697558_1438697558_1438697558&amp;action=mark_spam&amp;action_key=remove_content&amp;story_fbids%5B0%5D=1438697558%3A2652135709490&amp;subject_name=%E9%97%AE%E9%A2%98&amp;dialog=1&amp;ministory_key=48656396392992130&amp;profile_fbid=1438697558&amp;story_type=280&amp;feedback=1&amp;story_id=stream_story_4ec37b3fd8ba95881006138&amp;app_id=10150110253435258&amp;removeHref=%2Fajax%2Fminifeed.php"
																rel="async-post" tabindex="-1" role="menuitem"
																class="itemAnchor"> <span class="itemLabel fsm">举报/标记为垃圾信息...</span>
															</a>
														</li>
													</ul>
												</div>
											</div>
										</div>
										<select multiple="false">
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
									<h6 data-ft='{"type":1}'
										class="uiStreamMessage uiStreamPassive">
										<a data-hovercard="/ajax/hovercard/user.php?id=1438697558"
											href="http://www.facebook.com/profile.php?id=1438697558"
											class="passiveName">ま か</a> 提问：
										<a rel="dialog-pipe"
											ajaxify="/ajax/questions/popup.php?question_id=2652135669489&amp;qa_ref=qd"
											href="/questions/2652135669489/?qa_ref=qd"
											class="pronoun-link">是不是属牛姓马 就注定要当牛做马？</a>
									</h6>
									<div data-ft='{"type":10}'
										class="mvm uiStreamAttachments clearfix fbMainStreamAttachment">
										<div class="clearfix">
											<div data-ft='{"type":40}'>
												<div data-live='{"seq":0}'
													class="fbEigenpoll fbEigenpollFeed live_2652135669489_130062803728786">
													<div class="fbEigenpollAddOption">
														<form onsubmit="return Event.__inlineSubmit(this,event)"
															id="u3mxyl_17" method="post"
															action="/ajax/questions/eigenpolls/add_option.php"
															class="focus_target" rel="async">
															<input type="hidden"
																value="c0a81f7ab46455dde1e203435e599680"
																name="post_form_id" autocomplete="off" />
															<input type="hidden" autocomplete="off" value="AQAkl6kl"
																name="fb_dtsg" />
															<input type="hidden" value="2652135669489" name="qid"
																autocomplete="off" />
															<input type="hidden" name="rendered_options"
																autocomplete="off" />
															<table cellspacing="0" cellpadding="0">
																<tbody>
																	<tr>
																		<td class="fbEigenpollTypeaheadTD">
																			<div id="u3mxyl_18"
																				class="uiTypeahead fbEigenpollTypeahead">
																				<div class="wrap">
																					<input type="hidden" name="option_id"
																						class="hiddenInput" autocomplete="off" />
																					<div class="innerWrap">
																						<input type="text" id="u3mxyl_19" title="添加选项..."
																							value="添加选项..." spellcheck="false"
																							autocomplete="off"
																							onfocus="return wait_for_load(this, event, function() {;JSCC.get(&#39;j4ec37b3fc7fcb33332994179&#39;).init([&quot;showLoadingIndicator&quot;]);Event.listen($(&quot;u3mxyl_17&quot;),&quot;submit&quot;,function(e){QuestionsEigenpollForm.submit(e.getTarget());return false;});;});"
																							placeholder="添加选项..." name="option_text"
																							maxlength="80"
																							class="inputtext textInput DOMControl_placeholder" />
																					</div>
																					<i class="plus img sp_ayuesb sx_56af78"></i>
																				</div>
																			</div>
																		</td>
																		<td>
																			<label for="u3mxyl_20"
																				class="fbEigenpollAddButton uiButton">
																				<input type="submit" id="u3mxyl_20" value="添加" />
																			</label>
																		</td>
																	</tr>
																</tbody>
															</table>
														</form>
													</div>
												</div>
											</div>
										</div>
										<div class="fsm fwn fcg">
											<span class="caption"></span>
											<div
												class="uiAttachmentDesc translationEligibleUserAttachmentMessage"></div>
										</div>
									</div>
									<form onsubmit="return Event.__inlineSubmit(this,event)"
										action="/ajax/ufi/modify.php" method="post"
										class="commentable_item collapsed_comments autoexpand_mode"
										rel="async">
										<input type="hidden" value="€,′,€,′,水,Д,?" name="charset_test" />
										<input type="hidden" value="c0a81f7ab46455dde1e203435e599680"
											name="post_form_id" autocomplete="off" />
										<input type="hidden" autocomplete="off" value="AQAkl6kl"
											name="fb_dtsg" />
										<div class="UIImageBlock clearfix uiStreamFooter">
											<i
												class="UIImageBlock_Image UIImageBlock_ICON_Image img sp_7gl7wd sx_97759f"></i>
											<div class="UIImageBlock_Content UIImageBlock_ICON_Content">
												<span> <span data-ft='{"type":"20"}'
													class="UIActionLinks UIActionLinks_bottom"> <a
														title="向指定的人们寻求答案" rel="dialog"
														ajaxify="/ajax/choose/?type=questions_forward&amp;qid=2652135669489">提问</a>
														· </span> <span data-ft='{"type":26}' class="uiStreamSource">
														<a href="/questions/2652135669489/?qa_ref=ssp"> <abbr
															class="timestamp livetimestamp"
															data-date="Tue, 15 Nov 2011 19:25:00 -0800"
															title="2011年11月16日11:25">5小时前</abbr> </a> </span> </span>
											</div>
										</div>
										<input type="hidden" name="link_data"
											value='{"qid":"5675515467749930831","mf_story_key":"2652135669489","c":"m"}' />
									</form>
								</div>
							</div>
						</div>
					</div>
				</li>
				<li id="stream_story_4ec37b3fd947b3232640247"
					data-ft='{"qid":"5675515467749930831","mf_story_key":"2652098748566","c":"m"}'
					class="pvm uiUnifiedStory uiStreamStory genericStreamStory aid_1438697558 uiListItem uiListLight uiListVerticalItemBorder">
					<div class="storyHighlightIndicatorWrapper"></div>
					<div class="storyContent">
						<div class="UIImageBlock clearfix">
							<a data-hovercard="/ajax/hovercard/hovercard.php?id=1438697558"
								aria-hidden="true" data-ft='{"type":60}'
								href="http://www.facebook.com/profile.php?id=1438697558"
								tabindex="-1"
								class="actorPhoto UIImageBlock_Image UIImageBlock_MED_Image">
								<img alt=""
									src="../../images/370142_1438697558_1584603112_q.jpg"
									class="uiProfilePhoto profilePic uiProfilePhotoLarge img" /> </a>
							<div
								class="storyInnerContent UIImageBlock_Content UIImageBlock_MED_Content">
								<div class="mainWrapper">
									<div id="u3mxyl_16"
										class="uiSelector inlineBlock mlm audienceSelector uiStreamHide audienceSelectorNoTruncate dynamicIconSelector uiSelectorRight uiSelectorNormal uiSelectorDynamicTooltip">
										<div class="wrap">
											<a rel="toggle" data-tooltip="Your friends" data-length="30"
												onmouseover="window.Selector &amp;&amp; onloadRegister(Selector.loadMenu.curry($('u3mxyl_16')));"
												aria-haspopup="1" href="#"
												ajaxify="/ajax/feed/feed_menu_personal.php?ministory_key=32020059470212303&amp;profile_fbid=1438697558&amp;story_type=46&amp;story_id=stream_story_4ec37b3fd947b3232640247&amp;story_fbids%5B0%5D=1438697558%3A2652098748566&amp;remove=1&amp;is_spam_filter=0&amp;context_menu%5Bremove_content%5D=1&amp;reportable=0&amp;actor_id=1438697558&amp;object_name&amp;app_id=0"
												role="button" onmouseout="this.blur();"
												class="uiTooltip uiSelectorButton uiButton uiButtonSuppressed uiButtonNoText">
												<i class="mrs defaultIcon customimg img sp_7gl7wd sx_dd5a6e"></i>
												<span class="uiButtonText"></span> <span
												class="uiTooltipWrap top right righttop"> <span
													class="uiTooltipText">Your friends</span> </span> </a>
										</div>
									</div>
									<h6 data-ft='{"type":1}' class="uiStreamMessage">
										<div data-ft='{"type":2}' class="actorDescription actorName">
											<a data-hovercard="/ajax/hovercard/user.php?id=1438697558"
												href="http://www.facebook.com/profile.php?id=1438697558">ま
												か</a>
										</div>
										<span data-ft='{"type":3}' class="messageBody">想找个朋友</span>
									</h6>
									<form onsubmit="return Event.__inlineSubmit(this,event)"
										data-live='{"seq":0}' action="/ajax/ufi/modify.php"
										method="post"
										class="live_2652098748566_131325686911214 commentable_item collapsed_comments autoexpand_mode"
										rel="async">
										<input type="hidden" value="€,′,€,′,水,Д,?" name="charset_test" />
										<input type="hidden" value="c0a81f7ab46455dde1e203435e599680"
											name="post_form_id" autocomplete="off" />
										<input type="hidden" autocomplete="off" value="AQAkl6kl"
											name="fb_dtsg" />
										<input type="hidden"
											value='{"actor":"1438697558","target_fbid":"2652098748566","target_profile_id":"1438697558","type_id":"22","source":"1","assoc_obj_id":"","source_app_id":"0","extra_story_params":[],"content_timestamp":"1321413387","check_hash":"3f5872858ac731ce"}'
											name="feedback_params" autocomplete="off" />
										<span class="uiStreamFooter"> <span
											data-ft='{"type":"20"}'
											class="UIActionLinks UIActionLinks_bottom">
												<button data-ft='{"type":22}'
													onclick="fc_click(this, false); return true;" name="like"
													type="submit" title="喜欢这个"
													class="like_link stat_elem as_link">
													<span class="default_message">赞</span>
													<span class="saving_message">取消</span>
												</button> · <label title="发表留言" class="uiLinkButton comment_link">
													<input type="button" onclick="return fc_click(this);"
														value="评论" data-ft='{"type":24}' />
												</label> · </span> <span data-ft='{"type":26}' class="uiStreamSource">
												<a
												href="/permalink.php?story_fbid=2652098748566&amp;id=1438697558">
													<abbr class="timestamp livetimestamp"
													data-date="Tue, 15 Nov 2011 19:16:27 -0800"
													title="2011年11月16日11:16">6小时前</abbr> </a> </span> </span>
										<ul data-ft='{"type":30}'
											class="uiList uiUfi focus_target fbUfi">
											<li class="ufiNub uiListItem uiListVerticalItemBorder">
												<i></i>
											</li>
											<li data-ft='{"type":31}'
												class="hidden_elem uiUfiLike uiListItem uiListVerticalItemBorder"></li>
											<li data-ft='{"type":32}'
												class="uiUfiComments uiListItem uiListVerticalItemBorder hidden_elem">
												<ul class="commentList"></ul>
											</li>
											<li
												class="uiUfiAddComment clearfix uiUfiSmall ufiItem ufiItem uiListItem uiListVerticalItemBorder uiUfiAddCommentCollapsed">
												<div class="UIImageBlock clearfix mentionsAddComment">
													<img alt=""
														src="../../images/370142_1438697558_1584603112_q.jpg"
														class="uiProfilePhoto actorPic UIImageBlock_Image UIImageBlock_ICON_Image uiProfilePhotoMedium img" />
													<div
														class="commentArea UIImageBlock_Content UIImageBlock_ICON_Content">
														<div class="commentBox">
															<div id="u3mxyl_10"
																class="uiMentionsInput textBoxContainer">
																<div class="highlighter">
																	<div>
																		<span class="highlighterContent"></span>
																	</div>
																</div>
																<div id="u3mxyl_11"
																	class="uiTypeahead mentionsTypeahead">
																	<div class="wrap">
																		<input type="hidden" class="hiddenInput"
																			autocomplete="off" />
																		<div class="innerWrap">
																			<textarea autocomplete="off"
																				onfocus="return wait_for_load(this, event, function() {if (!this._has_control) {  new TextAreaControl(this).setAutogrow(true);  this._has_control = true; } return wait_for_load(this, event, function() {;JSCC.get(&#39;j4ec37b3fc7fcb33332994174&#39;).init([&quot;buildBestAvailableNames&quot;,&quot;hoistFriends&quot;]);JSCC.get(&#39;j4ec37b3fc7fcb33332994172&#39;).init({&quot;max&quot;:10}, null);;;});});"
																				name="add_comment_text" placeholder="留段话吧..."
																				title="留段话吧..."
																				class="enter_submit DOMControl_placeholder uiTextareaNoResize uiTextareaAutogrow textBox mentionsTextarea textInput">留段话吧...</textarea>
																		</div>
																	</div>
																</div>
																<input type="hidden" class="mentionsHidden"
																	autocomplete="off" />
															</div>
															<div class="uiUfiAddTip sendOnEnterTip fss fcg">
																按回车键（Enter）发表评论。
															</div>
														</div>
														<label for="u3mxyl_12"
															class="mts commentBtn stat_elem hidden_elem optimistic_submit uiButton uiButtonConfirm">
															<input type="submit" id="u3mxyl_12" name="comment"
																class="enter_submit_target" value="评论" />
														</label>
													</div>
												</div>
											</li>
										</ul>
										<input type="hidden" name="link_data"
											value='{"qid":"5675515467749930831","mf_story_key":"2652098748566","c":"m"}' />
									</form>
								</div>
							</div>
						</div>
					</div>
				</li>
				<li id="stream_story_4ec37b3fd95bb4672601975"
					data-ft='{"qid":"5675515467749930831","mf_story_key":"2651732819418","c":"m"}'
					class="pvm uiUnifiedStory uiStreamStory genericStreamStory aid_1438697558 aid_2344061033 uiListItem uiListLight uiListVerticalItemBorder">
					<div class="storyHighlightIndicatorWrapper"></div>
					<div class="storyContent">
						<div class="UIImageBlock clearfix">
							<a data-hovercard="/ajax/hovercard/hovercard.php?id=1438697558"
								aria-hidden="true" data-ft='{"type":60}'
								href="http://www.facebook.com/profile.php?id=1438697558"
								tabindex="-1"
								class="actorPhoto UIImageBlock_Image UIImageBlock_MED_Image">
								<img alt=""
									src="../../images/370142_1438697558_1584603112_q.jpg"
									class="uiProfilePhoto profilePic uiProfilePhotoLarge img" /> </a>
							<div
								class="storyInnerContent UIImageBlock_Content UIImageBlock_MED_Content">
								<div class="mainWrapper">
									<a title=""
										ajaxify="/ajax/minifeed.php?ministory_key=10921649747876944&amp;profile_fbid=1438697558&amp;story_type=12&amp;story_id=stream_story_4ec37b3fd95bb4672601975&amp;story_fbids%5B0%5D=1438697558%3A2651732819418&amp;dialog=1&amp;feedback=1&amp;action_key=remove_content"
										href="#" rel="async-post" onmouseout="this.blur();"
										class="mlm uiTooltip uiStreamHide uiCloseButton"> <span
										class="uiTooltipWrap top right righttop"> <span
											class="uiTooltipText">删除帖子</span> </span> </a>
									<h6 data-ft='{"type":1}'
										class="uiStreamMessage uiStreamPassive">
										<a data-hovercard="/ajax/hovercard/user.php?id=1438697558"
											href="http://www.facebook.com/profile.php?id=1438697558"
											class="passiveName">ま か</a> 创建了一个活动。
									</h6>
									<div data-ft='{"type":10}'
										class="mvm uiStreamAttachments clearfix fbMainStreamAttachment">
										<div class="clearfix">
											<div data-ft='{"type":40}' class="UIImageBlock clearfix">
												<a aria-hidden="1" tabindex="-1"
													href="http://www.facebook.com/event.php?eid=224019977664870"
													class="UIImageBlock_Image UIImageBlock_SMALL_Image"> <img
														alt=""
														src="http://profile.ak.fbcdn.net/static-ak/rsrc.php/v1/yz/r/7qDCsX_XJ6c.png"
														class="uiProfilePhoto uiProfilePhotoLarge img" /> </a>
												<div class="UIImageBlock_Content UIImageBlock_SMALL_Content">
													<div class="mbs">
														<strong><a
															href="http://www.facebook.com/event.php?eid=224019977664870">林荫新路钓鱼</a>
														</strong>
													</div>
													<div class="fsm fwn fcg">
														2011年11月19日 8:00
													</div>
													<div class="fsm fwn fcg">
														林荫新路
													</div>
												</div>
											</div>
										</div>
										<div class="fsm fwn fcg">
											<span class="caption"></span>
											<div
												class="uiAttachmentDesc translationEligibleUserAttachmentMessage"></div>
										</div>
									</div>
									<form onsubmit="return Event.__inlineSubmit(this,event)"
										data-live='{"seq":0}' action="/ajax/ufi/modify.php"
										method="post"
										class="live_2651732819418_131325686911214 commentable_item collapsed_comments autoexpand_mode"
										rel="async">
										<input type="hidden" value="€,′,€,′,水,Д,?" name="charset_test" />
										<input type="hidden" value="c0a81f7ab46455dde1e203435e599680"
											name="post_form_id" autocomplete="off" />
										<input type="hidden" autocomplete="off" value="AQAkl6kl"
											name="fb_dtsg" />
										<input type="hidden"
											value='{"actor":"1438697558","target_fbid":"2651732819418","target_profile_id":"1438697558","type_id":"5","source":"1","assoc_obj_id":"224019977664870","source_app_id":"2344061033","extra_story_params":[],"content_timestamp":"1321433919","check_hash":"4dffee5da8347917"}'
											name="feedback_params" autocomplete="off" />
										<div class="UIImageBlock clearfix uiStreamFooter">
											<i
												class="UIImageBlock_Image UIImageBlock_ICON_Image img sp_6h8b4g sx_70f090"></i>
											<div class="UIImageBlock_Content UIImageBlock_ICON_Content">
												<span> <span data-ft='{"type":"20"}'
													class="UIActionLinks UIActionLinks_bottom">
														<button data-ft='{"type":22}'
															onclick="fc_click(this, false); return true;" name="like"
															type="submit" title="喜欢这个"
															class="like_link stat_elem as_link">
															<span class="default_message">赞</span><span
																class="saving_message">取消</span>
														</button>· <label title="发表留言" class="uiLinkButton comment_link">
															<input type="button" onclick="return fc_click(this);"
																value="评论" data-ft='{"type":24}' />
														</label> · <a title="将其发送给朋友或者发布于你的个人主页上。" rel="dialog"
														href="/ajax/sharer/?s=7&amp;appid=2344061033&amp;p%5B0%5D=224019977664870"
														data-ft='{"type":25}' class="share_action_link">分享</a> · <a
														ajaxify="/ajax/choose/?type=event&amp;eid=224019977664870&amp;send_invites_on_close=1"
														rel="dialog"
														href="http://www.facebook.com/event.php?eid=224019977664870&amp;ref=nf">邀请</a>
														· </span> <span data-ft='{"type":26}' class="uiStreamSource">
														<a
														href="/permalink.php?story_fbid=2651732819418&amp;id=1438697558">
															<abbr class="timestamp livetimestamp"
															data-date="Tue, 15 Nov 2011 18:02:58 -0800"
															title="2011年11月16日10:02">7小时前</abbr> </a> </span> </span>
											</div>
										</div>
										<ul data-ft='{"type":30}'
											class="uiList uiUfi focus_target fbUfi">
											<li class="ufiNub uiListItem uiListVerticalItemBorder">
												<i></i>
											</li>
											<li data-ft='{"type":31}'
												class="hidden_elem uiUfiLike uiListItem uiListVerticalItemBorder"></li>
											<li data-ft='{"type":32}'
												class="uiUfiComments uiListItem uiListVerticalItemBorder hidden_elem">
												<ul class="commentList"></ul>
											</li>
											<li
												class="uiUfiAddComment clearfix uiUfiSmall ufiItem ufiItem uiListItem uiListVerticalItemBorder uiUfiAddCommentCollapsed">
												<div class="UIImageBlock clearfix mentionsAddComment">
													<img alt=""
														src="../../images/370142_1438697558_1584603112_q.jpg"
														class="uiProfilePhoto actorPic UIImageBlock_Image UIImageBlock_ICON_Image uiProfilePhotoMedium img" />
													<div
														class="commentArea UIImageBlock_Content UIImageBlock_ICON_Content">
														<div class="commentBox">
															<div id="u3mxyl_13"
																class="uiMentionsInput textBoxContainer">
																<div class="highlighter">
																	<div>
																		<span class="highlighterContent"></span>
																	</div>
																</div>
																<div id="u3mxyl_14"
																	class="uiTypeahead mentionsTypeahead">
																	<div class="wrap">
																		<input type="hidden" class="hiddenInput"
																			autocomplete="off" />
																		<div class="innerWrap">
																			<textarea autocomplete="off"
																				onfocus="return wait_for_load(this, event, function() {if (!this._has_control) {  new TextAreaControl(this).setAutogrow(true);  this._has_control = true; } return wait_for_load(this, event, function() {;JSCC.get(&#39;j4ec37b3fc7fcb33332994177&#39;).init([&quot;buildBestAvailableNames&quot;,&quot;hoistFriends&quot;]);JSCC.get(&#39;j4ec37b3fc7fcb33332994175&#39;).init({&quot;max&quot;:10}, null);;;});});"
																				name="add_comment_text" placeholder="留段话吧..."
																				title="留段话吧..."
																				class="enter_submit DOMControl_placeholder uiTextareaNoResize uiTextareaAutogrow textBox mentionsTextarea textInput">留段话吧...</textarea>
																		</div>
																	</div>
																</div>
																<input type="hidden" class="mentionsHidden"
																	autocomplete="off" />
															</div>
															<div class="uiUfiAddTip sendOnEnterTip fss fcg">
																按回车键（Enter）发表评论。
															</div>
														</div>
														<label for="u3mxyl_15"
															class="mts commentBtn stat_elem hidden_elem optimistic_submit uiButton uiButtonConfirm">
															<input type="submit" id="u3mxyl_15" name="comment"
																class="enter_submit_target" value="评论" />
														</label>
													</div>
												</div>
											</li>
										</ul>
										<input type="hidden" name="link_data"
											value='{"qid":"5675515467749930831","mf_story_key":"2651732819418","c":"m"}' />
									</form>
								</div>
							</div>
						</div>
					</div>
				</li>
			</ul>
			<div>
				<div class="UIIntentionalStream_Error" style="display: none;">
					<div class="pam uiBoxRed">
						<div class="fsl fwb fcb">
							该动态流目前无法显示，请稍后再试一次。
						</div>
					</div>
				</div>
			</div>
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