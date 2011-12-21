<%@page contentType="textml;charset=utf-8"%>
 <%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
 
<script type="text/javascript">
  $(document).ready(function() {
      $('#mycity').autocomplete({
        onSelect: selectMyCity,
        onClear: clearMyCity,
        notFound: notFoundMyCity
      });
      
     $('#myhometown').autocomplete({
        onSelect: selectMyHometown,
        onClear: clearMyHometown,
        notFound: notFoundMyHometown
      });
      
  });
  
  function selectMyCity(value, data) {
    var city = data.city;
    var cityString = data.cityString;
    if (city>0) {
      $("#selectedCity").val(city);
      $("#mycity").val(cityString);
    }
  }
  
  function selectMyHometown(value, data) {
    var city = data.city;
    var cityString = data.cityString;
    if (city>0) {
      $("#selectedHometown").val(city);
      $("#myhometown").val(cityString);
    }
  }
  
  function clearMyCity() {
    $("#selectedCity").val("");
  }
  
  function clearMyHometown() {
    $("#selectedHometown").val("");
  }
  
  function notFoundMyCity() {
   clearMyCity();
  }
  
  function notFoundMyHometown() {
   clearMyHometown();
  }
</script>

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
    <div data-referrer="editprofileform" id="editprofileform">
      <s:form action="update" namespace="/usr" id="ep_form">
        <input type="hidden" id="selectedCity" name="profileform.cityid" autocomplete="off"/>
        <input type="hidden" id="selectedHometown" name="profileform.hometownid" autocomplete="off"/>
        <input type="hidden" id="selectedHometown" name="profileform.pageIndex" autocomplete="off"/>
        <table class="uiInfoTable">
          <tbody>
            <tr class="dataRow">
              <th class="label">居住城市：</th>
              <td class="data">
                <div>
                  <div id="u2urlx_8" class="uiTypeahead uiClearableTypeahead photoTypeahead fbHubsTypeahead uiTypeaheadFocused">
                    <div class="wrap">
                      <div class="innerWrap">
                        <s:textfield id="mycity" name="mycity" cssClass="inputtext textInput DOMControl_placeholder" placeholder="请您输入所在城市" tipstype="error" />
                      </div>
                      <i class="photo img sp_c0827g sx_c5d496"></i>
                    </div>
                    <div class="uiTypeaheadView hidden_elem"></div>
                  </div>
                </div>
              </td>
              <td class="rightCol"></td>
            </tr>
            <tr class="dataRow">
              <th class="label">家乡：</th>
              <td class="data">
                <div>
                  <div id="u2urlx_10" class="uiTypeahead uiClearableTypeahead photoTypeahead fbHubsTypeahead">
                    <div class="wrap">
                      <div class="innerWrap">
                        <s:textfield id="myhometown" name="myhometown" cssClass="inputtext textInput DOMControl_placeholder" placeholder="请您输入家乡城市" tipstype="error" />
                      </div>
                      <i class="photo img sp_c0827g sx_c5d496"></i>
                    </div>
                  </div>
                </div>
              </td>
              <td class="rightCol"></td>
            </tr>
            <tr class="spacer">
              <td colspan="3"><hr/></td>
            </tr>
          </tbody>
          <tbody>
            <tr class="dataRow">
              <th class="label">性别：</th>
              <td class="data">
                <ul class="uiList">
                  <li class="uiListItem uiListVerticalItemBorder">
                    <s:select name="profileform.gender" list="#{'-1':'选择性别', '1':'男', '2':'女'}" tipstype="error"></s:select>
                  </li>
                </ul>
              </td>
              <td class="rightCol"></td>
            </tr>
            <tr class="spacer">
              <td colspan="3"><hr/></td>
            </tr>
          </tbody>
          <tbody>
            <tr class="dataRow">
              <th class="label">生日：</th>
              <td class="data">
                <ul class="uiList">
                  <li class="uiListItem uiListVerticalItemBorder">
                    <s:select name="profileform.year" list="#request.years" listKey="key"  listValue="value" tipstype="error"></s:select>
                    <s:select name="profileform.month" list="#request.months" listKey="key"  listValue="value" tipstype="error"></s:select>
                    <s:select name="profileform.day" list="#request.days" listKey="key"  listValue="value" tipstype="error"></s:select>
                  </li>
                  <li class="ptm uiListItem uiListVerticalItemBorder">
                    <span id="birthday_popup" class="hidden_elem">
                    <div>Note: you can only change your birthday a limited number of times.</div>
                    <div>
                      <label for="birthday_confirmation" class="uiCheckbox">
                        <input type="checkbox" checked="1" value="1" id="birthday_confirmation" name="birthday_confirmation"/>
                        I confirm my age is <span id="birthday_confirmation_age">X</span>.
                      </label>
                    </div>
                    </span>
                  </li>
                </ul>
              </td>
              <td class="rightCol"></td>
            </tr>
            <tr class="spacer">
              <td colspan="3"><hr/></td>
            </tr>
          </tbody>
          <tbody>
            <tr class="genderInterestRow dataRow">
              <th class="label">兴趣对象：</th>
              <td class="data">
                <div class="uiInputLabel inlineBlock">
                  <input type="checkbox" class="uiInputLabelCheckbox" id="meeting_sex1" name="profileform.meeting_sex2" value="2" />
                  <label for="meeting_sex1">女性</label>
                </div>
                <div class="uiInputLabel inlineBlock">
                  <input type="checkbox" class="uiInputLabelCheckbox" id="meeting_sex2" name="profileform.meeting_sex1" value="1" />
                  <label for="meeting_sex2">男性</label>
                </div>
              </td>
              <td class="rightCol"></td>
            </tr>
            <tr class="spacer">
              <td colspan="3"><hr/></td>
            </tr>
          </tbody>
          <tbody class="profileTextareaField">
            <tr class="dataRow">
              <th class="label">自我简介：</th>
              <td class="data">
                <s:textarea name="profileform.introduction" rows="5" cssClass="profileEditText" />
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
              <td colspan="2" class="data"><table cellspacing="0" cellpadding="0" class="uiGrid">
                  <tbody>
                    <tr>
                      <td class="vTop"><input type="hidden" value="1" name="save" autocomplete="off"/>
                        <label for="u2urlx_7" class="uiButton uiButtonConfirm">
                          <input type="submit" id="u2urlx_7" value="保存更改"/>
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