<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<div class="hidden_elem" id="headerArea"></div>
<div role="complementary" id="rightCol">   </div>
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
                <i class="uiHeaderImage img sp_1md9rt sx_73fc1d"></i>消息
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
                      <a href="/messages/?query=is%3Aunread">未读</a>
                       · <a href="/messages/?query=is%3Aarchived">已存档</a>
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
            <li class="threadRow noDraft uiListItem uiListLight uiListVerticalItemBorder" id="id.237791252950736">
              <table cellspacing="0" cellpadding="0" class="uiGrid">
                <tbody>
                  <tr>
                    <td class="threadMainCol">
                      <a class="threadLink" href="/messages/?action=read&amp;tid=id.237791252950736" rel="ignore">
                        <div class="UIImageBlock clearfix pvs">
                          <img class="uiProfilePhoto UIImageBlock_Image UIImageBlock_MED_Image uiProfilePhotoLarge img" src="http://profile.ak.fbcdn.net/hprofile-ak-ash2/370142_1438697558_1584603112_q.jpg" alt="">
                          <div class="right UIImageBlock_Ext">
                            <label class="draft">草稿</label>
                            <span class="timestamp">
                              <abbr class="timestamp" data-date="Fri, 18 Nov 2011 02:25:01 -0800" title="2011年11月18日18:25">星期五</abbr>
                            </span>
                          </div>
                          <div class="content UIImageBlock_Content UIImageBlock_MED_Content">
                            <div class="authorsWrapper">
                              <strong class="authors">ま か</strong>
                              <span class="mls mutualFriends fsm fwn fcg"></span>
                            </div>
                            <div class="snippet fsm fwn fcg">
                              <i class="mrs indicator img sp_d1pr3k sx_18fadf"></i>
                              <span id="snippet_id.237791252950736">周末一起去钓鱼好吗</span>
                            </div>
                          </div>
                        </div>
                      </a>
                    </td>
                    <td class="plm">
                      <a class="uiTooltip markAsReadLink" onmouseout="this.blur();" href="#" ajaxify="/ajax/messaging/async.php?action=markRead&amp;tids%5B0%5D=id.237791252950736" rel="async-post">
                        <span class="readState markread"></span>
                        <span class="uiTooltipWrap top right righttop">
                          <span class="uiTooltipText">标记为已读</span>
                        </span>
                      </a>
                      <a class="uiTooltip markAsUnreadLink" onmouseout="this.blur();" href="#" ajaxify="/ajax/messaging/async.php?action=markUnread&amp;tids%5B0%5D=id.237791252950736" rel="async-post">
                        <span class="readState markunread"></span>
                        <span class="uiTooltipWrap top right righttop">
                          <span class="uiTooltipText">标记为未读</span>
                        </span>
                      </a>
                    </td>
                    <td class="pls">
                      <a class="uiTooltip archiveLink" onmouseout="this.blur();" ajaxify="/ajax/messaging/async.php?action=tag&amp;tag=action%3Aarchived&amp;tids%5B0%5D=id.237791252950736&amp;state=1" href="#" rel="async-post">
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
          </ul>
        </div>
      </div>
    </div>
  </div>
</div>
          
<%@ include file="/WEB-INF/jsp/popup/addMessagePop.jsp"%>