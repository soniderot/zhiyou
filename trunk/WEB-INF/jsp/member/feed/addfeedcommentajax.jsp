<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<li class="uiUfiComment comment_<s:property value='comment.id' /> ufiItem ufiItem uiUfiUnseenItem">
  <div class="UIImageBlock clearfix uiUfiActorBlock">
    <a href="http://www.facebook.com/profile.php?id=100003145753118" tabindex="-1" class="actorPic UIImageBlock_Image UIImageBlock_SMALL_Image">
      <img alt="" src="<s:property value='#session.userlogo'/>" class="uiProfilePhoto uiProfilePhotoMedium img"/>
    </a>
    <label for="u3ft9v_1" class="deleteAction stat_elem UIImageBlock_Ext uiCloseButton">
      <input type="button" id="u3ft9v_1" onclick="showDelCommentPop('dialog_delFeedCmt', <s:property value='comment.id' />)" title="删除"/>
    </label>
    <div class="commentContent UIImageBlock_Content UIImageBlock_SMALL_Content">
      <a href="http://www.facebook.com/profile.php?id=100003145753118" class="actorName"><s:property value="user.username"/></a>
      <span class="commentBody"><s:property value="comment.content" /></span>
      <div class="commentActions fsm fwn fcg">
        <abbr class="timestamp livetimestamp" title="<s:date name="comment.created" format="yyyy-MM-dd HH:mm" />"><s:date name="comment.created" format="yyyy-MM-dd HH:mm" /></abbr> · 
      <!--  
        <span class="comment_like_5136102 fsm fwn fcg">
          <button title="喜欢此评论" value="5136102" name="like_comment_id[5136102]" type="submit" class="stat_elem as_link cmnt_like_link">
            <span class="default_message">赞</span>
            <span class="saving_message">取消</span>
          </button>
        </span>
      -->
      </div>
    </div>
  </div>
</li>