<%@page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<div id="headerArea">
						<div id="pagelet_header" data-referrer="pagelet_header">
							<div id="pagelet_above_header" data-referrer="pagelet_above_header"></div>
							<div id="pagelet_header_personal" data-referrer="pagelet_header_personal">
								<div class="clearfix profileHeader">
									<div class="rfloat">
										<s:if test="profile.userid==#session.user.userid">  
										<a class="mls uiButton" role="button" href="photo/photo!toUpladPhoto.jhtml" ajaxify="#" rel="dialog-post">
											<i class="mrs img sp_biub6x sx_bbdac2"></i>
											<span class="uiButtonText">上传照片</span>
										</a>
										
										<s:if test="albumId>0">  
										<a class="mls uiButton" role="button" href="photo/photo!editAlbum.jhtml?albumId=${albumId}" ajaxify="#" rel="dialog-post">
											<i class="mrs img sp_biub6x sx_bbdac2"></i>
											<span class="uiButtonText">编辑相册</span>
										</a>
									</s:if>  
										<a class="mls uiButton" role="button" href="photo/photo!toCreateAlbum.jhtml" ajaxify="#" rel="dialog-post">
											<i class="mrs img sp_biub6x sx_bbdac2"></i>
											<span class="uiButtonText">创建相册</span>
										</a>
									</s:if>  
									
									</div>
									
									<div class="profileHeaderMain">
										<h1>
											<span class="profileName fn ginormousProfileName fwb"><s:property value="profile.username"/></span>
											<i class="profileArrow img sp_enac13 sx_0431aa"></i>
											<span class="profileName ginormousProfileName fwb">照片<i class="profileArrow img sp_enac13 sx_0431aa"></i><s:property value="zyAlbum.albumname"/></span>
										</h1>
									</div>
								</div>
							</div>
						</div>
					</div>