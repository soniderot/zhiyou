<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<div id="contentArea" role="main">
					  <div id="pagelet_main_column" data-referrer="pagelet_main_column">
					  	<div id="pagelet_main_column_personal" data-referrer="pagelet_main_column_personal_photos">
					  		<div id="pagelet_photo_albums" data-referrer="pagelet_photo_albums">
					  			<div class="uiHeader uiHeaderSection fbPhotosGridHeader">
					  				<div class="clearfix uiHeaderTop">
					  					<!--
					  					<span class="uiHeaderActions rfloat fsm fwn fcg">
					  						
					  						查看全部： <span class="fsm fwn fcg"><a href="/media/albums/?id=1438697558">照片</a> · <a href="/video/?id=1438697558">视频</a></span>
					  					</span>-->
					  					<div>
					  						<s:if test="albums.size()==0">  
					  								<h3 class="uiHeaderTitle">无照片</h3>
					  					</s:if> 
					  						<s:else>
					  						<h3 class="uiHeaderTitle">我的照片</h3>
					  					</s:else>
					  					</div>
					  				</div>
					  			</div>
					  			<table cellspacing="0" cellpadding="0" class="uiGrid fbPhotosGrid fbPhotosReorderableGrid fbPhotosGridTight" id="u4yh8o_1">
					  				<tbody>
					  					<tr>
					  						
					  						 <s:iterator value="albums">
					  						<td class="vTop hLeft prm" data-id="">
					  							<div class="dragWrapper">
					  								<a href="photo/photo!getPhotos.jhtml?userid=<s:property value="userid"/>&albumId=<s:property value="id"/>" class="uiMediaThumb uiScrollableThumb uiMediaThumbLarge uiMediaThumbAlb uiMediaThumbAlbLarge"  style="" name="2731104643664" href="" title="" tabindex="-1">
					  									<img width="150px" height="120px" alt="" src="<s:property value="logo"/>" class="img">
					  								</a>
					  								<div class="clearfix pvs photoDetails">
					  									<div class="photoText">
					  										<a href="photo/photo!getPhotos.jhtml?userid=<s:property value="userid"/>&albumId=<s:property value="id"/>">
					  											<strong><s:property value="albumname"/></strong>
					  										</a>
					  										<div class="fsm fwn fcg"><s:property value="photosCnt"/>张照片</div>
					  									</div>
					  									
					  									
					  								</div>
					  								<i class="dragHover img sp_biub6x sx_e83c4c"></i>
					  								<span class="mover">
					  									<a class="arrow down" href="#" title="将照片下移"> ↓ </a>
					  									<a class="arrow up" href="#" title="将照片上移"> ↑ </a>
					  								</span>
					  							</div>
					  						</td>
					  						
					  						
					  						</s:iterator>
					  						
					  						<!--	
					  						<td class="vTop hLeft prm" data-id="">
					  							<div class="dragWrapper">
					  								<a class="uiMediaThumb uiScrollableThumb uiMediaThumbLarge uiMediaThumbAlb uiMediaThumbAlbLarge" style="" name="2651622016648" href="http://www.facebook.com/media/set/?set=a.2651622016648.2147291.1438697558&amp;type=3" title="" tabindex="-1">
					  									<span class="uiMediaThumbWrap">
					  										<i style="background-image: url(http://photos-a.ak.fbcdn.net/hphotos-ak-snc7/387621_2651622096650_1438697558_32951077_404100207_a.jpg);"></i>
					  									</span>
					  								</a>
					  								<div class="clearfix pvs photoDetails">
					  									<div class="photoText">
					  										<a href="http://www.facebook.com/media/set/?set=a.2651622016648.2147291.1438697558&amp;type=3">
					  											<strong>个人头像</strong>
					  										</a>
					  										<div class="fsm fwn fcg">1 张照片</div>
					  									</div>
					  								</div>
					  								<i class="dragHover img sp_biub6x sx_e83c4c"></i>
					  								<span class="mover">
					  									<a class="arrow down" href="#" title="将照片下移"> ↓ </a>
					  									<a class="arrow up" href="#" title="将照片上移"> ↑ </a>
					  								</span>
					  							</div>
					  						</td>
					  						-->
					  						
					  						<!--
					  						<td class="vTop hLeft lastChild">
					  							<div class="dragWrapper">
					  								<div>
					  									<a class="fbBlankAlbumIcon" href="/albums/create.php" ajaxify="/ajax/photos/upload/flash/help/?id=1438697558&amp;ref=profile" rel="dialog">
					  										<span class="iconSpan">
					  											<img width="62" height="49" class="iconImage img" src="http://static.ak.fbcdn.net/rsrc.php/v1/yw/r/lKt8RB_a4CA.png" alt="">
					  										</span>
					  									</a>
					  									<div class="pvs photoDetails">
					  										<a rel="dialog" ajaxify="/ajax/photos/upload/flash/help/?id=1438697558&amp;ref=profile" href="/albums/create.php">上传更多照片</a>
					  									</div>
					  								</div>
					  							</div>
					  						</td>
					  						-->
					  					</tr>
					  				</tbody>
					  			</table>
					  		</div>
					  		<div id="pagelet_photos_of_me" data-referrer="pagelet_photos_of_me"></div>
					  	</div>
					  </div>
					</div>