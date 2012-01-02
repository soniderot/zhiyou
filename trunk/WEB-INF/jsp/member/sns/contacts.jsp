<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<div role="main" id="contentArea">
						<div data-referrer="pagelet_friends" id="pagelet_friends">
							<div class="uiHeader uiHeaderWithImage uiHeaderPage">
								<div class="clearfix uiHeaderTop">
									<a href="sns/sns!getFriendsList.jhtml" role="button" class="uiHeaderActions rfloat uiButton">
										<span class="uiButtonText">管理朋友列表</span>
									</a>
									<div>
										<h2 class="uiHeaderTitle">
											<i class="uiHeaderImage img sp_biub6x sx_e332d4"></i>朋友
										</h2>
									</div>
								</div>
							</div>
							<div class="clearfix findfriends" id="content_inner">
								<div class="new_ff" id="importer_frame">
									<div style="display: none;" id="success" class="mbl pam uiBoxYellow"></div>
									<div style="display: none;" id="error" class="mbl pam uiBoxRed"></div>
									<div style="display: none;" id="done" class="mbl"></div>
									<div id="befriend_selector"></div>
									<div id="invite">
										<div id="address_book_selector" class="mbl">
											<div class="UIImageBlock clearfix">
												<img height="36" width="35" alt="" src="images/UHkKDRwgbaw.png" class="UIImageBlock_Image UIImageBlock_MED_Image img"/>
												<div class="uiHeader uiHeaderPage UIImageBlock_Content UIImageBlock_MED_Content">
													<div class="clearfix uiHeaderTop">
														<div class="uiHeaderActions rfloat"></div>
														<div>
															<h2 class="uiHeaderTitle">邀请朋友和家人加入</h2>
														</div>
													</div>
												</div>
											</div>
											<div class="uiStepList pbs">
												<ol>
													<li class="uiStep uiStepFirst">
														<div class="part back"></div>
														<div class="part middle">
															<div class="content">
																<div class="title fsl fwb fcb">步骤 1</div>
																<span class="description">搜索朋友</span>
															</div>
														</div>
														<div class="part point"></div>
													</li>
													<li class="uiStep uiStepNextSelected">
														<div class="part back"></div>
														<div class="part middle">
															<div class="content">
																<div class="title fsl fwb fcb">步骤 2</div>
																<span class="description">添加朋友</span>
															</div>
														</div>
														<div class="part point"></div>
													</li>
													<li id="ci_steplist_3" class="uiStep uiStepLast uiStepLastSelected uiStepSelected">
														<div class="part back"></div>
														<div class="part middle">
															<div class="content">
																<div class="title fsl fwb fcb">步骤 3</div>
																<span class="description">邀请朋友</span>
															</div>
														</div>
														<div class="part point"></div>
													</li>
												</ol>
											</div>
											<form onsubmit="return Event.__inlineSubmit(this,event)" id="friend_finder_invite_form" name="friend_finder_invite_form" method="post" action="/invite.php">
												<input type="hidden" value="dd6118a0a26b26fbe1db089ba7fc77f9" name="post_form_id" autocomplete="off"/>
												<input type="hidden" autocomplete="off" value="AQAQAK2a" name="fb_dtsg"/>
												<div class="contact_wrapper fixed_height">
													<table cellspacing="0" cellpadding="0" width="100%" class="uiGrid invite_selector_header">
														<tbody>
															<tr>
																<td class="checkbox">
																	<input type="checkbox" id="toggle_all_checkbox" onclick='__UIControllerRegistry["c4ecc92aab86ee3542164333"].toggleAll(true, false);'/>
																</td>
																<td>
																	<a onclick='__UIControllerRegistry["c4ecc92aab86ee3542164333"].toggleAll(false, false);'>
																		<span class="fsm">全选/全不选</span>
																	</a>
																</td>
															</tr>
														</tbody>
													</table>
													<div class="invite_selector_table_wrapper">
														<table cellspacing="0" cellpadding="0" width="100%" id="email_contacts_list" class="invite_selector_table">
															<tbody>
															<s:iterator value="contacts">
																<tr>
																	<td class="checkbox">
																		<input type="checkbox" class="contacts" value=""/>
																	</td>
																	<td title="<s:property value="name"/>" onclick="CIUtil.toggleRow(this)" class="name"><s:property value="name"/>${name }</td>
																	<td title="<s:property value="email"/>" onclick="CIUtil.toggleRow(this)" class="email"><s:property value="email"/><span class="login_credential"><s:property value="email"/></span></td>
																</tr>
															</s:iterator>
															</tbody>
														</table>
													</div>
													<table cellspacing="0" cellpadding="0" width="100%" class="uiGrid mts invite_selector_footer">
														<tbody>
															<tr>
																<td class="vMid">
																	
																</td>
																<td class="vTop hRght">
																	<img height="11" width="16" alt="" src="images/GsNJNwuI-UM.gif" class="mhm mts uiLoadingIndicatorAsync img"/>
																	<label for="uydez6_1" class="uiButton uiButtonConfirm uiButtonLarge">
																		<input type="submit" id="uydez6_1" onclick='__UIControllerRegistry["c4ecc92aab86ee3542164333"].sendInvites("friend_finder_invite_form"); return false;' value="Send Invites"/>
																	</label>
																	<label class="uiButton uiButtonConfirm uiButtonLarge" for="ur7504_29">
																				
																				<a href="sns/sns!getFriendsList.jhtml">跳过</a>
																	</label>
																</td>
															</tr>
														</tbody>
													</table>
													<!--
													<div class="mvl uiP fsm fcg">
														请只邀请你认识，并且愿意接受邀请的人。第一次邀请发出后，我们会自动提醒对方最多两次。
														<a href="/ajax/invite/learn_more.php" rel="dialog">了解更多</a>或
														<a href="/ajax/invite/invite_example.php?pm=0" rel="dialog">查看范例</a>。
													</div>-->
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div id="bottomContent"></div>
					</div>