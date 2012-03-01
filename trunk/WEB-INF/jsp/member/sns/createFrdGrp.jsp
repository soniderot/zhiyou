<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<script type="text/javascript">
function checkInput() {
  var grpName = $("input[name='snsGroupname']").val();
  var grpPlaceHolder = $("input[name='snsGroupname']").attr("placeholder");
  if ("" == grpName || grpName == grpPlaceHolder) {
    return false;
  }
  return true;
}
</script>
<div role="main" id="contentArea">
  <div id="pagelet_search_results_spellcheck">
    <div class="search_spell_check"></div>
  </div>
  <div class="mbm">
    <s:form onsubmit="return checkInput()" action="sns/sns!createSnsGroup.jhtml">
      <div class="mtm mrl detailedsearch_filter_loading_indicator_area">
        <img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="uiLoadingIndicatorAsync img"/>
      </div>
      <div class="mbs pam clearfix uiBoxGray noborder">
        <table>
          <tbody class="fbSearchAdvancedFiltersVisible">
            <tr id="u9ikxu_15">
              <td>
                分组名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              </td>
              <td>
                <div id="u9ikxu_18">
                  <div id="u9ikxu_24" class="uiTypeahead lfloat">
                    <div class="wrap">
                      <input type="hidden" name="wk" class="hiddenInput" autocomplete="off"/>
                      <div class="innerWrap">
                        <s:textfield name="snsGroupname" title="键入分组名称" autocomplete="off" value="键入分组名称" size="35" placeholder="键入分组名称" class="inputtext textInput DOMControl_placeholder"/>
                      </div>
                    </div>
                  </div>
                </div>
              </td>
              <td></td>
            </tr>
            <!--tr id="u9ikxu_15">
              <td>
                添加成员：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              </td>
              <td>
                <div id="u5hu7k_11">
                  <a onclick="return showPopup('dialog_0')" class="uiButton" role="button" href="#" id="customerSelect">
                    <span class="uiButtonText">选择成员</span>
                  </a>
                  <input type="hidden" autocomplete="off" class="invitees" name="invitees" value=""/>
                </div>
              </td>
              <td></td>
            </tr -->
          </tbody>
          <tbody class="fbSearchAdvancedFiltersHidden hidden_elem"></tbody>
          <tfoot>
          <tr>
            <td>
            </td>
            <td class="data" colspan="2" style="padding:10px 0px">
              <div class="clearfix">
                <label class="lfloat uiButton uiButtonConfirm uiButtonLarge" for="u5hu7k_12">
                  <input type="submit" value="创建分组" name="save" id="u5hu7k_12"/>
                </label>
              </div>
            </td>
          </tr>
        </tfoot>
        </table>
      </div>
    </s:form>
  </div>
</div>
<%@ include file="/WEB-INF/jsp/popup/addFriendRequest.jsp"%>
