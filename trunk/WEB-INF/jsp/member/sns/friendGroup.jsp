<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<s:if test="friendsInGroup==null || friendsInGroup.size==0">
<div role="main" id="contentArea">
  <div id="pagelet_fl_composer">
    <div id="u3k9qe_7" class="uiComposer uiComposerHideContent stat_elem uiMetaComposer fbFriendListComposer uiComposerTopBorder uiComposerOpen uiComposerHideContent uiComposerWhiteMessageBox"></div>
  </div>
  <div id="pagelet_home_stream">
    <div id="c4f4a2f60a282f5151012731" class="UIIntentionalStream UIStream">
      <ul id="home_stream" class="uiList uiStream translateParent UIIntentionalStream_Content" data-referrer="home_stream"></ul>
      <div>
        <div class="UIIntentionalStream_Error">
          <div class="pam uiBoxRed">
            <div class="fsl fwb fcb">该动态流目前无法显示，请稍后再试一次。</div>
          </div>
        </div>
      </div>
      <div>
        <div id="pagelet_stream_pager"></div>
      </div>
      <div>
        <div class="friendListFilterNullState"><i class="mbm img sp_cv4wwt sx_cf68c0"></i>
          <div class="pbs fsxl fcg"><a href="#" onclick="return getGroupFriends(${param.groupId})" rel="dialog">添加朋友</a>到此列表以查看他们的更新动态</div>
          <div class="friendListFeedFilterSubtitle fsl fcg">If you want to remove friends from the list later, click Manage List, above.</div>
        </div>
      </div>
    </div>
  </div>
</div>
</s:if>
<s:else>
<%@ include file="/WEB-INF/jsp/member/feed/feeds.jsp"%>
</s:else>
<script type="text/javascript">
  function getGroupFriends(groupId) {
    $.ajax({
     type: "GET",
     url: "usr/feed!getGrpFriendsAjax.jhtml",
     dataType: 'html',
     data: "groupId="+groupId,
     success: function(data) {
       $("body").append(data);
     }
    });
    return false;
  }
</script>