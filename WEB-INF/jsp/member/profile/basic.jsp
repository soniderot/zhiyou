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
      
     $('#schoolName').autocomplete({
      serviceUrl: "usr/school.jhtml",
      onSelect: selectMySchool,
      onClear: clearMySchool,
      notFound: notFoundMySchool
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
  
  function selectMySchool(value, data) {
    var schoolId = data.schoolId;
    var schoolName = data.schoolName;
    if (schoolId > 0) {
      $("#schoolId").val(schoolId);
      $("#schoolName").val(schoolName);
    }
  }
  
  function clearMySchool() {
    $("#schoolId").val("");
  }
  
  function notFoundMySchool() {
   clearMySchool();
  }
  
</script>

<div role="main" id="contentArea">
  <div class="uiHeader mhl uiHeaderPage">
    <div class="clearfix uiHeaderTop">
      <div class="uiHeaderActions rfloat">
      	<!--
        <a href="http://www.facebook.com/mkk158?ref=profile&amp;v=info" role="button" class="uiButton">
          <i class="mrs img sp_ah6icc sx_2efcc5"></i>
          <span class="uiButtonText">查看个人主页</span>
        </a>
        <a href="http://www.facebook.com/mkk158?viewas=100000686899395" role="button" class="uiButton">
          <span class="uiButtonText">以朋友身份查看…</span>
        </a>
        -->
      </div>
      <div>
        <h2 class="uiHeaderTitle"><s:property value="#session.user.username"/><i class="mhs img sp_4fkm6u sx_e93a7e"></i>编辑个人主页</h2>
      </div>
    </div>
  </div>
  <div class="pal grayArea uiBoxGray noborder">
    <div id="editprofileform">
      <s:form action="update" namespace="/usr" id="ep_form">
        <input type="hidden" id="selectedCity" name="profileform.cityid" />
        <input type="hidden" id="selectedHometown" name="profileform.hometownid" />
        <input type="hidden" id="schoolId" name="profileform.collegeid" />
        <input type="hidden" name="profileform.pageIndex" value="1"/>
        <table class="uiInfoTable">
          <tbody>
          	<!--
          	<tr class="dataRow">
              <th class="label">用户名：</th>
              <td class="data">
                <div>
                  <div id="u2urlx_8" class="uiTypeahead uiClearableTypeahead photoTypeahead fbHubsTypeahead uiTypeaheadFocused">
                    <div class="wrap">
                      <div class="innerWrap">
                        <s:textfield  name="profileform.username" cssClass="inputtext textInput DOMControl_placeholder"   />
                      </div>
                      <i class="photo img sp_c0827g sx_c5d496"></i>
                    </div>
                    <div class="uiTypeaheadView hidden_elem"></div>
                  </div>
                </div>
              </td>
              <td class="rightCol"></td>
            </tr>-->
            <tr class="dataRow">
            
              <th class="label">新密码(不修改请保持为空)：</th>
              <td class="data">
                <div>
                  <div id="u2urlx_8" class="uiTypeahead uiClearableTypeahead photoTypeahead fbHubsTypeahead uiTypeaheadFocused">
                    <div class="wrap">
                      <div class="innerWrap">
                        <s:password  name="profileform.passwd"  cssClass="inputtext textInput DOMControl_placeholder"  />
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
              <th class="label">居住城市：</th>
              <td class="data">
                <div>
                  <div id="u2urlx_8" class="uiTypeahead uiClearableTypeahead photoTypeahead fbHubsTypeahead uiTypeaheadFocused">
                    <div class="wrap">
                      <div class="innerWrap">
                        <s:textfield id="mycity" name="profileform.cityname" cssClass="inputtext textInput DOMControl_placeholder" placeholder="请您输入所在城市" tipstype="error" />
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
                        <s:textfield id="myhometown" name="profileform.hometownname" cssClass="inputtext textInput DOMControl_placeholder" placeholder="请您输入家乡城市" tipstype="error" />
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
                  <s:checkbox cssClass="uiInputLabelCheckbox" id="meeting_sex1" name="profileform.meeting_sex2" />
                  <label for="meeting_sex1">女性</label>
                </div>
                <div class="uiInputLabel inlineBlock">
                  <s:checkbox cssClass="uiInputLabelCheckbox" id="meeting_sex2" name="profileform.meeting_sex1" />
                  <label for="meeting_sex2">男性</label>
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
              <th class="label">学院/大学：</th>
              <td class="data">
                <div id="add_college" class="uiTypeahead uiClearableTypeahead photoTypeahead mbs addExperience stat_elem fbHubsTypeahead">
                  <div class="wrap">
                    <label for="u83nqz_5" class="clear uiCloseButton">
                      <input type="button" id="u83nqz_5" onclick="var c = JSCC.get('j4ed60c7576e6211830524984').getCore(); c.reset(); c.getElement().focus(); " title="删除"/>
                    </label>
                    <div class="innerWrap">
                      <s:textfield id="schoolName" name="profileform.collegename" title="你在哪儿念的大学？" placeholder="你在哪儿念的大学？" cssClass="inputtext textInput DOMControl_placeholder"/>
                    </div>
                    <i class="photo img sp_dob1w7 sx_33eb13"></i>
                  </div>
                </div>
              </td>
            </tr>
            <tr class="spacer">
              <td colspan="2"><hr/></td>
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
                      <td class="vTop">
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