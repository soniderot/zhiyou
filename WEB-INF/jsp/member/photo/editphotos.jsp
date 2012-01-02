<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page pageEncoding="utf-8"%>
<div class="UIStandardFrame_Content">
		      <div>
		        <div class="editalbum_header">
		          <div class="title_header">
		            <h2 class="title_h" style="background-image: url(http://static.ak.fbcdn.net/rsrc.php/v1/yz/r/StEh3RhPvjk.gif);">编辑相册 - <s:property value="zyAlbum.albumname"/></h2>
		          </div>
		        </div>
		        <div class="tabs clearfix">
		          <center>
		            <div class="left_tabs">
		              <ul class="toggle_tabs" id="toggle_tabs_unused">
		                <li class="first"><a class="selected" href="photo/photo!editPhotos.jhtml?albumId=<s:property value="zyAlbum.id"/>">编辑照片</a></li>
		                <li><a href="photo/photo!editAlbum.jhtml?albumId=<s:property value="zyAlbum.id"/>">编辑信息</a></li>
		                <li class="last"><a href="photo/photo!deleteAlbum.jhtml?albumId=<s:property value="zyAlbum.id"/>">删除</a></li>
		              </ul>
		            </div>
		            <div class="back_links">
		              <a class="uiButton" role="button" href="photo/photo!getAlbum.jhtml?userid=<s:property value="zyAlbum.userid"/>">
		              	<i class="mrs img sp_ah6icc sx_2efcc5"></i>
		              	<span class="uiButtonText">返回相册</span>
		              </a>
		            </div>
		          </center>
		        </div>
		        <form method="post" action="photo/photo!updatePhotos.jhtml" >
		          <input type="hidden" name="albumId" value="<s:property value="zyAlbum.id"/>">
		          <div id="editphotoalbum">
		          	<s:iterator value="userPhotos">
		          		
		            <div class="photo clearfix">
		            	<input type="hidden" name="photoIds" value="<s:property value="id"/>">
		              <div class="info">
		                <table cellspacing="0" border="0" class="formtable">
		                  <tbody>
		                    <tr class="tallrow">
		                      <td class="label">描述&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
		                        <small>
		                        <!-- Unlimited Length -->
		                        </small>
		                      </td>
		                      <td>
		                      	<div class="uiMentionsInput" id="uyck2g_1">
		                          <div class="highlighter">
		                            <div><span class="highlighterContent"></span></div>
		                          </div>
		                          <div class="uiTypeahead mentionsTypeahead" id="uyck2g_2">
		                            
		                              <input type="hidden" autocomplete="off" class="hiddenInput">
		                              
		                             
		                              		
		                                <div class="wrap">
		                              <input type="hidden" autocomplete="off" class="hiddenInput">
		                              <div class="innerWrap">
		                                <textarea class="DOMControl_placeholder uiTextareaNoResize uiTextareaAutogrow mentionsTextarea textInput"  name="newSummarys" value="<s:property value="summary"/>" rows="5" cols="36" ><s:property value="summary"/></textarea>
		                              </div>
		                            </div>
		                              
		                            
		                          </div>
		                          <input type="hidden" autocomplete="off" class="mentionsHidden" name="caption_32981385">
		                        </div>
		                      </td>
		                    </tr>
		                    <tr>
		                      <td class="label">移动到其他相册<br>
		                        <small>
		                        <!-- Unlimited Length -->
		                        </small>
		                      </td>
		                      <td>
		                      <div class="pfileselector">
                        <s:select name="newAlbumIds" list="albums" listKey="id"  listValue="albumname" />
                      </div>
		                      </td>
		                    </tr>
		                  </tbody>
		                </table>
		              </div>
		              <div class="thumb">
		              	<img style="cursor: crosshair;" width="150" height="150" src="<s:property value="filename" />" id="32981385_photo_thumb">
		                <div class="covercheck">	
		                  <input type="radio" class="inputradio" <s:if test="filename==zyAlbum.logo"> checked="checked" </s:if> id="cover4ed5cc7874af7" name="albumlogo" value="<s:property value="id"/>">
		                
		                	
		                  <label for="cover4ed5cc7874af7" id="label_cover4ed5cc7874af7">作为相册封面。</label>
		                  <br>
		                  <input type="checkbox" class="inputcheckbox" id="delete_32981385" name="deletephotos" value="<s:property value="id"/>">
		                  <label for="delete_32981385" id="label_delete_32981385">删除</label>
		                </div>
		              </div>
		              <!--<br clear="both">-->
		            </div>
		           </s:iterator>
		          </div>
		          
		          
		          <div id="pagelet_stream_pager"
          data-referrer="pagelet_stream_pager">
          
          <div class="clearfix mts uiMorePager stat_elem fbStreamPager">
          	
            <div>
            	<s:if test="userPhotos.size()>0">
            	<jsp:include page="/WEB-INF/jsp/common/pagination.jsp" flush="true" />
            </s:if>
            <s:else>
              <div class="pam uiBoxLightblue uiMorePagerPrimary">目前没有更多照片可显示。</div>
            </s:else>
            </div>
          </div>
        </div>
      </div>
		          
		          
		          <div class="formbuttons">
		            <label class="uiButton uiButtonConfirm" id="save_changes" for="uyck2g_37">
		            	<input type="submit" value="保存更改" name="save_changes" onclick="" id="uyck2g_37">
		            </label>
		            <label class="uiButton" id="cancel" for="uyck2g_38">
		            	<input type="submit" value="取消" name="cancel" onclick="goURI(&quot;http:\/\/www.facebook.com\/media\/set\/?set=a.2731104643664.2148478.1438697558&amp;type=3&quot;); return false;" id="uyck2g_38">
		            </label>
		          </div>
		        </form>
		      </div>
		    </div>
		    
<script type="text/javascript">
  function topage(pageNo) {
  location.href = "photo/photo!editPhotos.jhtml?albumId=${albumId}&pageNo="+pageNo
  return false;
}
</script>