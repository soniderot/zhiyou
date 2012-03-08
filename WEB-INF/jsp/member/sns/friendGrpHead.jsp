<%@page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<script type="text/javascript">
$(function(){
  $('.uiMenuInner li').bind('mouseenter mouseleave', function() {
    $(this).toggleClass('selected');
  });
  $("#headerArea .wrap").toggle(
    function () {
      $(this).addClass("openToggler");
    },
    function () {
      $(this).removeClass("openToggler");
    }
  );
  
  $("#uzfwc1_3").bind("click", function(){
    $("#u29f2l_1").removeClass("friendListHeaderEditMode");
  });
});

  function showRenameForm() {
    $("#u29f2l_1").addClass("friendListHeaderEditMode");
  }

  function submitRenameGrp(form) {
    $.post("sns/sns!updatSnsGroup.jhtml", {
      snsGroupId : form.snsGroupId.value,
      snsGroupname : form.snsGroupname.value
    }, function (data) {
      $(".name").html(data);
      form.snsGroupname.placeholder = data;
      $("#u29f2l_1").removeClass("friendListHeaderEditMode");
    }, "html");
    return false;
  }
</script>
<s:if test="friendsInGroup==null || friendsInGroup.size==0||1>0">
<div id="headerArea">
  <div class="uiHeader uiHeaderWithImage friendListHeader" id="u29f2l_1">
    <div class="clearfix uiHeaderTop">
      <ul class="uiList uiListHorizontal clearfix uiHeaderActions rfloat">
        <li class="pls uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
          <div class="uiSelector inlineBlock friendListManage uiSelectorRight uiSelectorNormal">
            <div class="wrap">
              <a rel="toggle" href="#" class="uiSelectorButton uiButton"><span class="uiButtonText">管理朋友列表</span></a>
              <div class="uiSelectorMenuWrapper uiToggleFlyout">
                <div class="uiMenu uiSelectorMenu">
                  <ul class="uiMenuInner">
                    <li class="uiMenuItem editName">
                      <a rel="ignore" href="#" onclick="return showRenameForm()" tabindex="0" class="itemAnchor"><span class="itemLabel fsm">重命名朋友列表</span></a>
                    </li>
                    <li class="uiMenuItem">
                      <a href="#" rel="dialog" tabindex="-1" class="itemAnchor"><span class="itemLabel fsm">添加/删除朋友……</span></a>
                    </li>
                    <li class="uiMenuSeparator"/>
                    <li class="uiMenuItem">
                      <a href="#" onclick="return showGrpPopup('dialog_delete_grp')" rel="dialog" tabindex="-1" class="itemAnchor">
                        <span class="itemLabel fsm">删除列表</span>
                      </a>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </li>
      </ul>
      <div>
        <h2 class="uiHeaderTitle">
          <i class="uiHeaderImage img sp_84xm9t sx_3ac7dc"></i>
          <div class="friendListName">
            <div class="staticName">
              <span class="name"><s:property value="friendGroup.groupname"/></span>
            </div>
            <s:form onsubmit="return submitRenameGrp(this)" method="post" action="sns/sns!updatSnsGroup.jhtml" cssClass="editForm clearfix">
              <input type="hidden" value=${friendGroup.id} name="snsGroupId" autocomplete="off"/>
              <div class="lfloat">
                <s:textfield name="snsGroupname" placeholder="${friendGroup.groupname}" maxlength="80" cssClass="inputtext nameInput"/>
              </div>
              <label for="uzfwc1_2" class="mls saveButton lfloat uiButton uiButtonConfirm uiButtonLarge">
                <input type="submit" id="uzfwc1_2" value="储存"/>
              </label>
              <label for="uzfwc1_3" class="mls cancel lfloat uiButton uiButtonLarge">
                <input type="button" id="uzfwc1_3" value="取消"/>
              </label>
          </s:form>
          </div>
        </h2>
      </div>
    </div>
    <div class="clearfix">
      <div class="mbs friendListSubHeader uiHeaderSubTitle lfloat fsm fwn fcg">
        <div class="fsm fwn fcg">自建群组</div>
      </div>
    </div>
  </div>
</div>
</s:if>
<%@ include file="/WEB-INF/jsp/popup/delGroupPop.jsp"%>