<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<script type="text/javascript">
  function selectFriend(userId, username) {
    var friendIds = $("#friendId").val();
    $("#friendId").val(friendIds + " " + userId);
    var text = $("#feedmessage").val();
    var message = text.substring(0, start) + "@" + username + " ";
    if (index < text.length) {
      message = message + text.substring(index);
    }
    $("#feedmessage").val(message);
    $(".uiContextualLayer").remove();
    $("#feedmessage").focus();
    nameFlg = false;
    text = '';
  }
  $(document).ready(function() {
    $(".compact li").hover(
      function () {
        $(this).addClass("selected");
      },
      function () {
        $(this).removeClass("selected");
      });
  });
</script>
<s:if test="friends!=null && friends.size != 0">
<div class="uiContextualLayer belowleft" style="">
  <div style="width:167px;">
    <div class="uiTypeaheadView uiInlineTokenizerView">
      <ul class="compact">
        <s:iterator value="friends">
          <li class="user" onclick="selectFriend(<s:property value="userid"/>, '<s:property value="username"/>')">
            <img alt="" src="<s:property value='avatar'/>"/>
            <span class="text"><s:property value='username'/></span>
            <span class="subtext"><s:property value='cityname'/></span>
          </li>
        </s:iterator>
      </ul>
    </div>
  </div>
</div>
</s:if>