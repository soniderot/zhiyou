<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<script type="text/javascript" language="javascript">
$(function(){
  $.ajax({
   type: "GET",
   url: "usr/header!getNewrequestcnt.jhtml",
   dataType: 'text',
   success: function(data){
     if (data > 0) {
        $("#fbRequestsJewel").addClass("hasNew");
        $("#requestsCountValue").text(data);
     }
   }
  });
  
  $.ajax({
   type: "GET",
   url: "usr/header!getNewmessagecnt.jhtml",
   dataType: 'text',
   success: function(data){
     if (data > 0) {
        $("#fbMessagesJewel").addClass("hasNew");
        $("#messagesCountValue").text(data);
     }
   }
  });
  
  $.ajax({
   type: "GET",
   url: "usr/header!getNewnotificationcnt.jhtml",
   dataType: 'text',
   success: function(data){
     if (data > 0) {
        $("#fbNotificationsJewel").addClass("hasNew");
        $("#notificationsCountValue").text(data);
     }
   }
  });
});
</script>

  <div class="slim" id="blueBarHolder">
    <div id="blueBar">
      <div role="banner" id="pageHead" class="clearfix slimHeader">
        <h1 id="pageLogo">
          <a title="首页" href="http://www.facebook.com/?ref=logo"/>
        </h1>
        
        <div id="jewelContainer">
          <div id="fbRequestsJewel" class="fbJewel">
            <a data-gt='{"ua_id":"jewel:requests"}' data-target="fbRequestsFlyout" href="usr/request.jhtml" name="requests" rel="toggle" class="jewelButton">
              <span id="requestsCountWrapper" class="jewelCount">
                <span id="requestsCountValue"></span>
              </span>
            </a>
          </div>
          <div id="fbMessagesJewel" class="fbJewel">
            <a data-gt='{"ua_id":"jewel:messages"}' data-target="fbMessagesFlyout" name="messages" rel="toggle" href = "usr/message.jhtml" class="jewelButton">
              <span id="messagesCountWrapper" class="jewelCount">
                <span id="messagesCountValue"></span>
              </span>
            </a>
          </div>
          <div id="fbNotificationsJewel" class="fbJewel">
            <a data-gt='{"ua_id":"jewel:notifications"}' data-target="fbNotificationsFlyout" href="usr/notify.jhtml" name="notifications" rel="toggle" class="jewelButton">
              <span id="notificationsCountWrapper" class="jewelCount">
                <span id="notificationsCountValue"></span>
              </span>
            </a>
          </div>
         
        </div>
        <div id="headNav" class="clearfix">
         
          <div class="rfloat">
            <ul role="navigation" id="pageNav">
              <li class="topNavLink tinyman">
                <a title="个人主页" href="/usr/update.jhtml">
                  <span class="headerTinymanName"><s:property value="#session.user.username"/></span>
                </a>
              </li>
              <li class="topNavLink middleLink">
                <a href="/sns/sns!search.jhtml">搜索朋友</a>
              </li>
              <li class="topNavLink middleLink">
                <a href="/usr/logout.jhtml">退出</a>
              </li>
             
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>