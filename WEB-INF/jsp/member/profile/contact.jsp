<%@page contentType="textml;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<div role="main" id="contentArea">
  <div class="uiHeader mhl uiHeaderPage">
    <div class="clearfix uiHeaderTop">
      <div class="uiHeaderActions rfloat">
        <a href="http://www.facebook.com/mkk158?ref=profile&amp;v=info" role="button" class="uiButton">
          <i class="mrs img sp_ah6icc sx_2efcc5"></i>
          <span class="uiButtonText">查看个人主页</span>
        </a>
        <a href="http://www.facebook.com/mkk158?viewas=100000686899395" role="button" class="uiButton">
          <span class="uiButtonText">以朋友身份查看…</span>
        </a>
      </div>
      <div>
        <h2 class="uiHeaderTitle">ま か<i class="mhs img sp_4fkm6u sx_e93a7e"></i>编辑个人主页</h2>
      </div>
    </div>
  </div>
  <div class="pal grayArea uiBoxGray noborder">
    <div id="editProfileForm">
      <s:form onsubmit="return validateUpdateContact(this);" method="post" action="update" namespace="/usr">
        <input type="hidden" name="profileform.pageIndex" value="4" />
        <table class="uiInfoTable">
          <tbody>
            <tr class="dataRow">
              <th class="label">电子邮件：</th>
              <td class="data"><s:textfield name="profileform.email" cssClass="inputtext profileEditText" tipstype="error" /></td>
              <td class="rightCol"></td>
            </tr>
            
            <tr class="spacer">
              <td colspan="3"><hr/></td>
            </tr>
          </tbody>
          
          <tbody>
            <tr class="dataRow">
              <th class="label">电话号码：</th>
              <td class="data">
                <div id="u5rqxr_2" class="uiTypeahead uiClearableTypeahead photoTypeahead fbHubsTypeahead">
                  <div class="wrap">
                    <div class="innerWrap">
                      <s:textfield name="profileform.mobile" cssClass="inputtext textInput" tipstype="error" />
                    </div>
                    <i class="photo img sp_c0827g sx_c5d496"></i></div>
                </div></td>
              <td class="rightCol"></td>
            </tr>
            <tr class="dataRow">
              <th class="label">QQ号码：</th>
              <td class="data">
                <s:textfield name="profileform.qq" cssClass="inputtext profileEditText" tipstype="error" />
              </td>
              <td class="rightCol"/>
            </tr>
            
            <tr class="spacer">
              <td colspan="3"><hr/></td>
            </tr>
          </tbody>
          <tbody>
            <tr class="dataRow">
              <th class="label">联系地址：</th>
              <td class="data">
                <s:textfield name="profileform.address" cssClass="inputtext profileEditText"/>
              </td>
              <td class="rightCol"></td>
            </tr>
            <tr class="spacer">
              <td colspan="3"><hr/></td>
            </tr>
          </tbody>
          <tfoot>
            <tr>
              <th class="label"/>
              <td colspan="2" class="data">
                <table cellspacing="0" cellpadding="0" class="uiGrid">
                  <tbody>
                    <tr>
                      <td class="vTop">
                        <label for="u5rqxr_1" class="uiButton uiButtonConfirm">
                        <input type="submit" id="u5rqxr_1" value="保存更改"/>
                        </label>
                      </td>
                      <td class="vTop plm profileSaveErrorWrap"><span class="inline_err_msg"></span></td>
                    </tr>
                  </tbody>
                </table>
              </td>
            </tr>
          </tfoot>
        </table>
      </s:form>
    </div>
  </div>
</div>