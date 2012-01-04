<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page pageEncoding="utf-8"%>
<div id="contentArea" role="main">
  <div id="pagelet_welcome" data-referrer="pagelet_welcome">
    <div class="uiHeader uiHeaderWithImage uiHeaderBottomBorder uiHeaderPage">
      <div class="clearfix uiHeaderTop">
        <div class="uiHeaderActions rfloat"></div>
        <div>
          <h2 class="uiHeaderTitle">
            <i class="uiHeaderImage img sp_1md9rt sx_73fc1d"></i>
            <span id="MessagingReadParticipants">
              <a href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value="sender.userid" />" data-hovercard="#"><s:property value="sender.username" /></a>
            </span>
          </h2>
        </div>
      </div>
    </div>
    <ul class="uiList">
     <s:iterator value="zyMessages">
      <li class="MessagingMessage uiListItem uiListLight uiListVerticalItemBorder">
        <div class="clearfix main">
          <div class="UIImageBlock clearfix">
            <a class="UIImageBlock_Image UIImageBlock_SMALL_Image" href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value="profile.userid" />" tabindex="-1" aria-hidden="true" data-hovercard="/ajax/hovercard/hovercard.php?id=1438697558">
              <img class="uiProfilePhoto uiProfilePhotoLarge img" src="<s:property value="profile.avatar" />" alt="<s:property value="profile.username" />">
            </a>
            <div class="UIImageBlock_Content UIImageBlock_SMALL_Content">
              <div>
                <div class="rfloat">
                  <abbr title="<s:date name="message.createtime" format="yyyy-MM-dd HH:mm" />"  class="timestamp timestamp livetimestamp"><s:date name="message.createtime" format="yyyy-MM-dd HH:mm" /></abbr>
                  <a class="mls uiTooltip sourceTooltip" onmouseout="this.blur();" href="#">
                    <i class="img sp_3rokp3 sx_b6f17a"></i>
                    <span class="uiTooltipWrap middle left leftmiddle">
                      <span class="uiTooltipText">来自聊天室</span>
                    </span>
                  </a>
                </div>
                <strong><a href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value="profile.userid" />" ><s:property value="profile.username" /></a></strong>
              </div>
              <div>
                <ul class="uiList body contentListWidth">
                  <li class="uiListItem uiListVerticalItemBorder">
                    <div class="subject hidden_elem"></div>
                    <div class="content noh" id="id.249792425088617">
                      <p><s:property value="message.subject" /></p>
                    </div>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </li>
     </s:iterator>
    </ul>
  </div>
  <s:form  action="usr/message!replyMessage.jhtml" method="post" enctype="multipart/form-data" >
    <input type="hidden" name="receiverId" value="<s:property value="sender.userid" />">
      <input type="hidden" name="messageId" value="<s:property value="messageId" />">
  <div class="" id="MessagingShelf">
    <div class="clearfix uiBoxGray topborder" id="MessagingShelfContent">
      <div id="MessagingInlineComposer" class="MessagingComposer">
        <div class="MessagingComposerForm">
          <table cellspacing="0" cellpadding="0" class="uiGrid">
            <tbody>
              <tr>
                <td class="vTop prs MessagingComposerFormLeft">
                  <textarea style="height: 15px;" class="MessagingComposerBody DOMControl_placeholder" title="回复..." name="replyMessage" rows="1" placeholder="回复...">回复...</textarea>
                </td>
                <td class="vTop pls">
                  <label class="uiButton uiButtonConfirm" id="MessagingSendReplyButton" for="u1czie_7">
                    <input type="submit" value="回复" id="u1czie_7">
                  </label>
                </td>
              </tr>
            </tbody>
          </table>
          <input type="hidden" value="id.249792425088617" id="MessagingComposerReplyID">
        </div>
      </div>
    </div>
  </div>
</s:form>
</div>