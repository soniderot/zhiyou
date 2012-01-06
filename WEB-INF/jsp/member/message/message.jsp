<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>

<div role="main" id="contentArea">
  <div data-referrer="pagelet_titan" id="pagelet_titan">
    <div id="MessagingDashboard">
      <div id="MessagingFrame" class="clearfix">
        <div class="hidden_elem"></div>
        <div class="uiHeader uiHeaderWithImage uiHeaderPage">
          <div class="clearfix uiHeaderTop">
            <div class="uiToolbar uiToolbarUnbordered mlm uiHeaderActions rfloat">
              <div class="clearfix uiToolbarContent">
                <div style="padding-right:200px;">
                  <a class="uiToolbarItem uiButton" role="button" href="#" rel="dialog" onclick="return showPopup('dialog_add_message')">
                    <i class="mrs img sp_7gl7wd sx_61da04"></i>
                    <span class="uiButtonText">新信息</span>
                  </a>
                </div>
              </div>
            </div>
            <div>
              <h2 class="uiHeaderTitle">
                <s:if test="(type=='outbox')"> 
                  <i class="uiHeaderImage img sp_1md9rt sx_73fc1d"></i>发出的消息
                </s:if> 
                <s:else> 
                  <i class="uiHeaderImage img sp_1md9rt sx_73fc1d"></i>收到的消息
                </s:else> 
              </h2>
            </div>
          </div>
        </div>
        <table cellspacing="0" cellpadding="0" class="uiGrid mts footerActionBar">
          <tbody>
            <tr>
              <td class="vTop">
                <ul class="uiList uiListHorizontal clearfix">
                  <li class="uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
                    <div class="clearfix mts"><div class="mrs lfloat fsm fwn fcg">
                      <strong>查看：</strong>
                    </div>
                    <div class="footerActionLinks rfloat fsm fwn fcg">
                      <a href="usr/message.jhtml?type=inbox" >收件箱</a>
                       · <a href="usr/message.jhtml?type=outbox">发件箱</a>
                      </div>
                    </div>
                  </li>
                </ul>
              </td>
            </tr>
          </tbody>
        </table>
        <div class="mbs clearfix" id="MessagingMainContent">
          <ul class="uiList" id="MessagingThreadlist">
            <s:if test="(messages==null||messages.size()==0)">
              <li class="threadRow noDraft uiListItem uiListLight uiListVerticalItemBorder" id="id.237791252950736">
                <table cellspacing="0" cellpadding="0" class="uiGrid">
                  <tbody>
                    <tr>
                       <td class="threadMainCol">
                        <div class="snippet fsm fwn fcg">
                          <i class="mrs indicator img sp_d1pr3k sx_18fadf"></i>
                          <span id="snippet_id.237791252950736"><s:property value="content"/>没有新的信息</span>
                         </div>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </li>
            </s:if>
            
            <s:iterator value="messages">
            <li class="threadRow noDraft uiListItem uiListLight uiListVerticalItemBorder <s:if test='%{\"T\"==message.isread}'>unread</s:if>" id="id_<s:property value='message.id'/>">
              <table cellspacing="0" cellpadding="0" class="uiGrid">
                <tbody>
                  <tr>
                    <td class="threadMainCol">
                      <a class="threadLink" href="/usr/message!viewMessage.jhtml?messageId=<s:property value="message.id"/>" rel="ignore">
                        <div class="UIImageBlock clearfix pvs">
                          <img class="uiProfilePhoto UIImageBlock_Image UIImageBlock_MED_Image uiProfilePhotoLarge img" src="<s:property value="profile.avatar"/>" alt="">
                          <div class="right UIImageBlock_Ext">
                            <label class="draft">草稿</label>
                            <span class="timestamp">
                              <abbr class="timestamp" data-date="Fri, 18 Nov 2011 02:25:01 -0800" title="<s:date name="message.createtime" format="yyyy-MM-dd HH:mm" />"><s:date name="message.createtime" format="yyyy-MM-dd HH:mm" /></abbr>
                            </span>
                          </div>
                          <div class="content UIImageBlock_Content UIImageBlock_MED_Content">
                            <div class="authorsWrapper">
                              <strong class="authors"><s:property value="profile.username"/></strong>
                              <span class="mls mutualFriends fsm fwn fcg"></span>
                            </div>
                            <div class="snippet fsm fwn fcg">
                              <i class="mrs indicator img sp_d1pr3k sx_18fadf"></i>
                              <span id="snippet_id.237791252950736"><s:property value="message.subject"/></span>
                            </div>
                          </div>
                        </div>
                      </a>
                    </td>
                    <td class="plm">
                      <a class="uiTooltip markAsReadLink" onmouseout="this.blur();" href="#" onclick="return markReadStatus(<s:property value='message.id'/>, 'F');" rel="async-post">
                        <span class="readState markread"></span>
                        <span class="uiTooltipWrap top right righttop">
                          <span class="uiTooltipText">标记为未读</span>
                        </span>
                      </a>
                      <a class="uiTooltip markAsUnreadLink" onmouseout="this.blur();" href="#"  onclick="return markReadStatus(<s:property value='message.id'/>, 'T');" rel="async-post">
                        <span class="readState markunread"></span>
                        <span class="uiTooltipWrap top right righttop">
                          <span class="uiTooltipText">标记为已读</span>
                        </span>
                      </a>
                    </td>
                    <td class="pls">
                      <a class="uiTooltip archiveLink" onmouseout="this.blur();"  href="/usr/message!deleteMessage.jhtml?messageId=<s:property value="message.id"/>" rel="async-post">
                        <label class="uiCloseButton uiCloseButtonSmall" for="up3vb3_4">
                          <input type="button" title="" id="up3vb3_4">
                        </label>
                        <span class="uiTooltipWrap top right righttop">
                          <span class="uiTooltipText">删除</span>
                        </span>
                      </a>
                    </td>
                  </tr>
                </tbody>
              </table>
            </li>
          </s:iterator>
          </ul>
        </div>
      </div>
    </div>
  </div>
</div>
          
<div>
  <s:if test="messages.size()>0">
    <jsp:include page="/WEB-INF/jsp/common/pagination.jsp" flush="true" />
  </s:if>
  <s:else>
    <div class="pam uiBoxLightblue uiMorePagerPrimary">目前没有更多消息可显示。</div>
  </s:else>
</div>
          
         
 
<script>
function topage(pageNo) {
  <s:if test="(type=='outbox')"> 
  location.href = "usr/message.jhtml?type=outbox&pageNo="+pageNo
  </s:if>
  <s:else>
  location.href = "usr/message.jhtml?pageNo="+pageNo
  </s:else>
  return false;
}

function markReadStatus(messageId, status) {
   $.ajax({
     type: "GET",
     url: "usr/message!markReadStatus.jhtml",
     dataType: 'text',
     data: "messageId="+messageId+"&status="+status,
     success: function(data){
       if("T" == status) {
          $("#id_" + messageId).addClass("unread");
       } else {
          $("#id_" + messageId).removeClass("unread");
       }
     }
   });
   return false;
}
</script>

<%@ include file="/WEB-INF/jsp/popup/addMessagePop.jsp"%>