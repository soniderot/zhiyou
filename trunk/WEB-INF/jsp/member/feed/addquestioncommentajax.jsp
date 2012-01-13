<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<li class="fbQuestionsReply ptm uiListItem uiListLight uiListVerticalItemBorder">
  <div class="UIImageBlock clearfix mvs">
    <a tabindex="-1" href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value='user.userid'/>" class="UIImageBlock_Image UIImageBlock_SMALL_Image">
      <img alt="" src="<s:property value='user.avatar'/>" class="uiProfilePhoto uiProfilePhotoLarge img"/>
    </a>
    <label for="u3ft9v_1" class="deleteAction stat_elem UIImageBlock_Ext uiCloseButton">
      <input type="button" id="u3ft9v_<s:property value='comment.id' />" onclick="showDelCommentPop('dialog_delFeedCmt', <s:property value='comment.id' />)" title="删除"/>
    </label>
    <div class="UIImageBlock_Content UIImageBlock_SMALL_Content">
      <div class="mbs fsm fwn fcg">
        <strong><a href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value='user.userid'/>"><s:property value='user.username'/></a></strong>
        <s:date name="comment.created" format="yyyy-MM-dd HH:mm" />
      </div>
      <div class="mvs answerText">
        <p><s:property value='comment.content'/></p>
      </div>
    </div>
  </div>
</li>