<%@page contentType="textml;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<script type="text/javascript">
  $(document).ready(function() {
      $('#schoolName').autocomplete({
        serviceUrl: "usr/school.jhtml",
        onSelect: selectMySchool,
        onClear: clearMySchool,
        notFound: notFoundMySchool
      });
      
  });
  
  function selectMySchool(value, data) {
    var schoolId = data.schoolId;
    var schoolName = data.schoolName;
    if (city>0) {
      $("#schoolId").val(schoolId);
      $("#schoolName").val(schoolName);
    }
  }
  
  function clearMySchool() {
    $("#schoolId").val("");
  }
  
  function notFoundMySchool() {
   clearMyCity();
  }
  
</script>
<div role="main" id="contentArea">
  <div class="uiHeader mhl uiHeaderPage">
    <div class="clearfix uiHeaderTop">
      <div class="uiHeaderActions rfloat">
      	<!---
        <a href="http://www.facebook.com/mkk158?ref=profile&amp;v=info" role="button" class="uiButton">
          <i class="mrs img sp_ah6icc sx_2efcc5"></i>
          <span class="uiButtonText">查看个人主页</span>
        </a>
        <a href="http://www.facebook.com/mkk158?viewas=100000686899395" role="button" class="uiButton">
          <span class="uiButtonText">以朋友身份查看…</span>
        </a>--->
      </div>
      <div>
        <h2 class="uiHeaderTitle"><s:property value="#session.user.username"/><i class="mhs img sp_4fkm6u sx_e93a7e"></i>编辑个人主页</h2>
      </div>
    </div>
  </div>
  <div class="pal grayArea uiBoxGray noborder">
    <div data-referrer="editProfileForm" id="editProfileForm">
      <s:form action="update" namespace="/usr">
      <table class="uiInfoTable fbEditProfileExperienceSection">
        <tbody>
          <tr class="dataRow">
            <th class="label">工作单位：</th>
            <td class="data">
              <div id="add_work" class="uiTypeahead uiClearableTypeahead photoTypeahead mbs addExperience stat_elem fbHubsTypeahead">
                <div class="wrap">
                  <label for="u83nqz_4" class="clear uiCloseButton">
                    <input type="button" id="u83nqz_4" onclick="var c = JSCC.get('j4ed60c7576e6211830524982').getCore(); c.reset(); c.getElement().focus(); " title="删除"/>
                  </label>
                  <input type="hidden" name="employerId" class="hiddenInput" autocomplete="off"/>
                  <div class="innerWrap">
                    <s:textfield name="employerName" title="你曾经在哪就职？"  onfocus="" autocomplete="off" placeholder="你曾经在哪就职？"  cssClass="inputtext textInput DOMControl_placeholder"/>
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
        <tbody>
          <tr class="dataRow">
            <th class="label">学院/大学：</th>
            <td class="data">
              <div id="add_college" class="uiTypeahead uiClearableTypeahead photoTypeahead mbs addExperience stat_elem fbHubsTypeahead">
                <div class="wrap">
                  <label for="u83nqz_5" class="clear uiCloseButton">
                    <input type="button" id="u83nqz_5" onclick="var c = JSCC.get('j4ed60c7576e6211830524984').getCore(); c.reset(); c.getElement().focus(); " title="删除"/>
                  </label>
                  <input type="hidden" id="schoolId" name="schoolId" class="hiddenInput" autocomplete="off"/>
                  <div class="innerWrap">
                    <s:textfield id="schoolName" name="schoolName" title="你在哪儿念的大学？" value="你在哪儿念的大学？" onfocus="" autocomplete="off" placeholder="你在哪儿念的大学？" cssClass="inputtext textInput DOMControl_placeholder"/>
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
        <!-- 
        <tbody>
          <tr class="dataRow">
            <th class="label">高中：</th>
            <td class="data">
              <div id="add_high_school" class="uiTypeahead uiClearableTypeahead photoTypeahead mbs addExperience stat_elem fbHubsTypeahead">
                <div class="wrap">
                  <label for="u83nqz_6" class="clear uiCloseButton">
                    <input type="button" id="u83nqz_6" onclick="var c = JSCC.get('j4ed60c7576e6211830524986').getCore(); c.reset(); c.getElement().focus(); " title="删除"/>
                  </label>
                  <input type="hidden" name="high_school_id" class="hiddenInput" autocomplete="off"/>
                  <div class="innerWrap">
                    <input type="text" title="你在哪儿读的高中？" value="你在哪儿读的高中？" spellcheck="false" onfocus="return wait_for_load(this, event, function() {JSCC.get(&#39;j4ed60c7576e6211830524989&#39;).init(JSCC.get(&#39;j4ed60c7576e6211830524986&#39;));;JSCC.get(&#39;j4ed60c7576e6211830524986&#39;).init([&quot;setPhotoOnSelect&quot;]);;});" autocomplete="off" placeholder="你在哪儿读的高中？" name="high_school_name" class="inputtext textInput DOMControl_placeholder"/>
                  </div>
                  <i class="photo img sp_dob1w7 sx_33eb13"></i></div>
              </div>
            </td>
          </tr>
        </tbody>
      -->
      </table>
      </s:form>
    </div>
  </div>
</div>