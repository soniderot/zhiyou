<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page pageEncoding="utf-8"%>
<div class="UIStandardFrame_Content">
		      <div>
		        <div class="editalbum_header">
		          <div class="title_header">
		            <h2 class="title_h" style="background-image: url(http://static.ak.fbcdn.net/rsrc.php/v1/yz/r/StEh3RhPvjk.gif);">编辑相册 - <s:property value="zyAlbum.albumname"/></h2>
		          </div>
		        </div>
		        
		        <div id="beforeupload">
						  <div class="tabs clearfix">
						    <center>
						      <div class="left_tabs">
						        <ul class="toggle_tabs" id="toggle_tabs_unused">
						          <li class="first"><a href="photo/photo!editPhotos.jhtml?albumId=<s:property value="zyAlbum.id"/>">编辑照片</a></li>
						          <li><a class="selected" href="editAlbum.html">编辑信息</a></li>
						          <li class="last"><a href="photo/photo!deleteAlbum.jhtml?albumId=<s:property value="zyAlbum.id"/>">删除</a></li>
						        </ul>
						      </div>
						      <div class="back_links">
						      	<a class="uiButton" role="button" href="photo/photo!getAlbum.jhtml?userid=<s:property value="zyAlbum.userid"/>">
						      		<i class="mrs img sp_ah6icc sx_2efcc5"></i><span class="uiButtonText">返回相册</span>
						      	</a>
						      </div>
						    </center>
						  </div>
						  <div align="center" id="newalbum">
						    <form method="post" action="photo/photo!updateAlbum.jhtml?albumId=${zyAlbum.id}" name="upload" id="upload" onsubmit="return Event.__inlineSubmit(this,event)" enctype="multipart/form-data">
						     
						      <table cellspacing="0" border="0" class="formtable">
						        <tbody>
						          <tr>
						            <td class="label">相册名称</td>
						            <td><s:textfield name="zyAlbum.albumname" cssClass="inputtext" /></td>
						          </tr>
						          <tr>
						            <td class="label">地点</td>
						            <td><input type="text" class="inputtext" style="width: 240px;" id="location" name="location" value=""></td>
						          </tr>
						          <tr class="tallrow">
						            <td class="label">描述</td>
						            <td><textarea name="desc" style="width: 240px;" rows="5" id="desc"></textarea></td>
						          </tr>
						         
						        </tbody>
						      </table>
						      <div class="formbuttons">
						        <input type="submit" class="inputsubmit" value="保存更改">
						      </div>
						    </form>
						  </div>
						</div>
		      </div>
		    </div>