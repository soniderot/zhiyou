<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>

<div role="main" id="contentArea">
  <div id="pagelet_bookmark_seeall">
    <div>
      <div class="uiHeader uiHeaderPage">
        <div class="clearfix uiHeaderTop">
          <a href="sns/sns!newFrdGrp.jhtml" class="uiHeaderActions rfloat uiButton">
            <i class="mrs img sp_1jofei sx_b3565d"></i>
            <span class="uiButtonText">建立新列表</span>
          </a>
          <div>
            <h2 class="uiHeaderTitle">朋友名单一览表</h2>
          </div>
        </div>
      </div>
      <div id="pagelet_seeall_filter">
        <div id="bookmarksSeeAllSection">
          <ul class="uiList fbBookmarksSeeAllList">
            <s:iterator value="#session.snsgroups">
            <li id="seeAllItem_fl_2634661952657" class="seeAllItem clearfix key-fl_2634661952657 uiListItem uiListLight uiListVerticalItemBorder">
              <div class="uiSelector inlineBlock mtm mrm bookmarksMenuButton lfloat">
                <div class="wrap">
                  <a rel="toggle" href="#" title="" class="uiSelectorButton uiCloseButton"></a>
                  <div class="uiSelectorMenuWrapper uiToggleFlyout">
                    <div class="uiMenu uiSelectorMenu" role="menu">
                      <ul class="uiMenuInner">
                        <li class="uiMenuItem favorite">
                          <a rel="ignore" href="usr/feed!getFeedsOfGroup.jhtml?groupId=<s:property value="id" />" tabindex="0" role="menuitem" class="itemAnchor">
                            <span class="itemLabel fsm">添加为最喜欢的</span>
                          </a>
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
              <a href="usr/feed!getFeedsOfGroup.jhtml?groupId=<s:property value="id" />" title="<s:property value="groupname" />" class="pvm phs itemLink">
                <div class="UIImageBlock clearfix">
                  <i class="mrs UIImageBlock_Image UIImageBlock_ICON_Image img sp_1jofei sx_cc5a53"></i>
                  <div class="UIImageBlock_Content UIImageBlock_ICON_Content">
                    <span class="itemLabel fcb"><s:property value="groupname" /></span>
                    <span class="count mhs itemCount hidden_elem uiSideNavCount uiSideNavCountInline">
                      <span class="countValue fss">0</span>
                      <span class="maxCountIndicator"></span>
                    </span>
                  </div>
                </div>
              </a>
            </li>
            </s:iterator>
          </ul>
        </div>
      </div>
    </div>
  </div>
</div>