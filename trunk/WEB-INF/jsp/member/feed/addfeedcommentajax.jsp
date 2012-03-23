<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<li class="uiUfiComment comment_<s:property value='comment.id' /> ufiItem ufiItem uiUfiUnseenItem">
  <div class="UIImageBlock clearfix uiUfiActorBlock">
    <a href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value='user.userid'/>" tabindex="-1" class="actorPic UIImageBlock_Image UIImageBlock_SMALL_Image">
      <s:if test="#session.userlogo!=null">
      <img alt="" src="<s:property value='#session.userlogo'/>" class="uiProfilePhoto uiProfilePhotoMedium img"/>
    	</s:if>
    	<s:else>
      	 <img alt="" src="/images/default.JPG" class="uiProfilePhoto uiProfilePhotoMedium img"/>
      	 	</s:else>
    </a>
    <label for="u3ft9v_1" class="deleteAction stat_elem UIImageBlock_Ext uiCloseButton">
      <input type="button" id="u3ft9v_<s:property value='comment.id' />" onclick="showDelCommentPop('dialog_delFeedCmt', <s:property value='comment.id' />)" title="删除"/>
    </label>
    <div class="commentContent UIImageBlock_Content UIImageBlock_SMALL_Content">
      <a href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value='user.userid'/>" class="actorName"><s:property value="user.username"/></a>
      <span class="commentBody"><s:property value="comment.content" /></span>
      <div class="commentActions fsm fwn fcg">
        <abbr class="timestamp livetimestamp" title="<s:date name="comment.created" format="yyyy-MM-dd HH:mm" />"><s:date name="comment.created" format="yyyy-MM-dd HH:mm" /></abbr> · 
      </div>
    </div>
  </div>
</li>