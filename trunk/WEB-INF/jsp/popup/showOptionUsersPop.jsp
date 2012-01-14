<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>

<div class="generic_dialog pop_dialog profileBrowserDialog full_bleed" id="dialog_optionUsers">
  <div style="WIDTH: 447px; TOP: 40px" class=generic_dialog_popup>
    <div class=pop_container>
      <div id=pop_content class="pop_content pop_content_old" role=alertdialog tabIndex=0>
        <h2 id=title_dialog_0 class=dialog_title><span>投选了这选项的人</span></h2>
        <div class=dialog_content>
          <div class="dialog_summary hidden_elem"></div>
          <div class=dialog_body>
            <div id=uei1z5_2 class=fbProfileBrowser>
              <div class=standardLayout>
                <div id=uei1z5_3 class="listView clearfix">
                  <IMG class="throbber img" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/y9/r/jKEcVPZFk-2.gif" width=32 height=32>
                  <div class=lists>
                    <div id=uei1z5_1 class="fbProfileBrowserResult hideSummary">
                      <div class="pvm phs fbProfileBrowserSummaryBox uiBoxWhite bottomborder"></div>
                      <div class="fbProfileBrowserList fbProfileBrowserListContainer">
                        <ul class="uiList clearfix">
                          <s:iterator value="friends">
                          <li class="fbProfileBrowserListItem uiListItem uiListLight uiListVerticalItemBorder">
                            <div class="UIImageBlock clearfix UIImageBlock_Entity">
                              <a class="UIImageBlock_Image UIImageBlock_ENT_Image" tabIndex=-1 href="http://www.facebook.com/profile.php?id=100003206989957&amp;ref=pb">
                                <img class=img alt="" src="<s:property value='avatar' />">
                              </a>
                              <div class="UIImageBlock_Content UIImageBlock_ENT_Content">
                                <div class="fsl fwb fcb">
                                  <a href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value='userid'/>"><s:property value='username' /></a>
                                </div>
                              </div>
                            </div>
                          </li>
                          </s:iterator>
                        </ul>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="dialog_buttons clearfix">
            <div class=dialog_buttons_msg></div>
            <div>
              <label class="uiButton uiButtonLarge uiButtonConfirm">
              <input value="关闭" type="button" name="close" onclick="removePopup()"/>
              </label>
            </div>
          </div>
          <div class="dialog_footer hidden_elem"></div>
        </div>
        <div class=dialog_loading>加载中...</div>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
function removePopup() {
  $("#dialog_optionUsers").remove();
}
</script>