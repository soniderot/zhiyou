<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
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
<div data-referrer="pagelet_search_results_spellcheck" id="pagelet_search_results_spellcheck">
  <div class="search_spell_check"></div>
</div>
<s:if test="(keyWordSearch!=true)"> 
<div class="mbs detailedsearch_feature_header"><span>搜索朋友</span></div>
<div class="mbm">
  <form  action="/sns/sns!search.jhtml" >
    <input type="hidden" name="flag" value="1">
    <input type="hidden" name="runFlag" value="true">
    <input type="hidden" id="selectedCity" name="cityid" />
    <input type="hidden" id="selectedHometown" name="hometownid" />
    <input type="hidden" id="schoolId" name="collegeid" />
    <div class="mtm mrl detailedsearch_filter_loading_indicator_area">
      <img height="11" width="16" alt="" src="images/GsNJNwuI-UM.gif" class="uiLoadingIndicatorAsync img"/>
    </div>
    <div class="mbs pam clearfix uiBoxGray noborder">
      <table>
        <tbody class="fbSearchAdvancedFiltersVisible">
          <tr id="u9ikxu_13">
            <td>
              年龄：
            </td>
            <td>
              From&nbsp;
              <s:select name="startAge" list="#request.beginAges" listKey="key"  listValue="value" ></s:select>
                &nbsp;&nbsp;To&nbsp;
               <s:select name="endAge" list="#request.endAges" listKey="key"  listValue="value" ></s:select>
            </td>
            <td>
            </td>
          </tr>
          <tr id="u9ikxu_14">
            <td>
              性别：
            </td>
            <td>
              <s:select name="gender" list="#{'0':'选择性别', '1':'男', '2':'女'}"></s:select>
            </td>
            <td>
            </td>
          </tr>
           <tr class="dataRow">
              <td>居住城市：</td>
              <td class="data">
                <div>
                  <div id="u2urlx_8" class="uiTypeahead uiClearableTypeahead photoTypeahead fbHubsTypeahead uiTypeaheadFocused">
                    <div class="wrap">
                      <div class="innerWrap">
                      <s:if test="cityid==0">
                        <s:textfield id="mycity" name="cityname"  cssClass="inputtext textInput DOMControl_placeholder" placeholder="请您输入所在城市" tipstype="error" />
                      </s:if>
                      <s:else>
                        	<s:textfield id="mycity" name="cityname"  cssClass="inputtext textInput DOMControl_placeholder"  tipstype="error" />
                      </s:else>
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
              <td>家乡：</td>
              <td class="data">
                <div>
                  <div id="u2urlx_10" class="uiTypeahead uiClearableTypeahead photoTypeahead fbHubsTypeahead">
                    <div class="wrap">
                      <div class="innerWrap">
                      	<s:if test="hometownid==0">
                        <s:textfield id="myhometown" name="hometownname" cssClass="inputtext textInput DOMControl_placeholder" placeholder="请您输入家乡城市" tipstype="error" />
                      	</s:if>
                      <s:else>
                      	<s:textfield id="myhometown" name="hometownname" cssClass="inputtext textInput DOMControl_placeholder"  tipstype="error" />
                      </s:else>
                      </div>
                      <i class="photo img sp_c0827g sx_c5d496"></i>
                    </div>
                  </div>
                </div>
              </td>
              <td class="rightCol"></td>
            </tr>
            
            <tr class="dataRow">
              <td>学院/大学：</td>
              <td class="data">
                <div id="add_college" class="uiTypeahead uiClearableTypeahead photoTypeahead mbs addExperience stat_elem fbHubsTypeahead">
                  <div class="wrap">
                    <label for="u83nqz_5" class="clear uiCloseButton">
                      <input type="button" id="u83nqz_5" onclick="var c = JSCC.get('j4ed60c7576e6211830524984').getCore(); c.reset(); c.getElement().focus(); " title="删除"/>
                    </label>
                    <div class="innerWrap">
                    		<s:if test="collegeid==0">
                      <s:textfield id="schoolName" name="collegename" title="你在哪儿念的大学？" placeholder="你在哪儿念的大学？" cssClass="inputtext textInput DOMControl_placeholder"/>
                   		</s:if>
                   		<s:else>
                   			<s:textfield id="schoolName" name="collegename" title="你在哪儿念的大学？"  cssClass="inputtext textInput DOMControl_placeholder"/>
                   		</s:else>
                    </div>
                    <i class="photo img sp_dob1w7 sx_33eb13"></i>
                  </div>
                </div>
              </td>
            </tr>
          
          
          <tr id="u9ikxu_14">
             <td></td>
            <td>
              <div class="options">
          <div class="desc"><input value="搜索" tabindex="4" type="submit" id="ubyzxj_3" /></div>
         </div>
            </td>
          </tr>
        </tbody>
        <tbody class="fbSearchAdvancedFiltersHidden hidden_elem"></tbody>
      </table>
    </div>
  </form>
  
</div>
 </s:if> 
<div class="mbs detailedsearch_feature_header"><span>搜索结果</span></div>
<div data-referrer="pagelet_search_results_objects" id="pagelet_search_results_objects">
  <s:iterator value="searchProfiles">
  <div>
    <div class="mbm detailedsearch_result detailedsearch_last_result">
      <div class="UIImageBlock clearfix">
        <a class="UIImageBlock_Image UIImageBlock_ICON_Image" href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value="userid"/>"  tabindex="-1" aria-hidden="true">
        <img class="uiProfilePhoto uiProfilePhotoLarge" src="<s:property value="avatar"/>" alt="" >
        </a>
        <div class="pls UIImageBlock_Content UIImageBlock_ICON_Content">
          <div class="clearfix">
            <div class="rfloat">
              <div id="u9ikxu_28">
                <div id="div_<s:property value="userid"/>" class="FriendButton">
                	 <s:if test="friendFlag==false">
                  <label for="addFriendBtn_<s:property value="userid"/>" class="FriendRequestAdd addButton uiButton">
                    <i class="mrs img sp_ah6icc sx_070d6b"></i>
                    <input type="button" id="addFriendBtn_<s:property value="userid"/>" value="加为好友" onclick="showPopup('dialog_0', <s:property value="userid"/>)"/>
                  </label>
                   </s:if>
                  
                  <s:if test="friendFlag==true">
                  	
                  	<a class="mls uiButton" role="button" href="/profile/profile!viewProfileInfo.jhtml?userid=<s:property value="userid"/>">
									
										<i class="mrs img sp_7gl7wd sx_167a57"></i>
									<span class="uiButtonText">查看详细</span>
									</a>
                  
                  </s:if>
                  
                  <a href="#" role="button" class="FriendRequestOutgoing enableFriendListFlyout hidden_elem outgoingButton uiButton">
                    <i class="mrs img sp_ah6icc sx_070d6b"></i>
                    <span class="uiButtonText">朋友请求已传送。</span>
                  </a>
                </div>
              </div>
            </div>
            <div>
              <div class="instant_search_title fsl fwb fcb">
                <a  href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value="userid"/>" ><s:property value="username"/></a>
              </div>
              <div class="instant_search_title fsl fwb fcb">
                <s:if test="gender==1">男</s:if><s:else>女</s:else>
               <s:if test="age>0">，<s:property value="age"/>岁</s:if><s:if test="friendFlag==true">，1度朋友</s:if>
              </div>
              <div class="fsm fwn fcg"></div>
            </div>
          </div>
          <div></div>
        </div>
      </div>
    </div>
  </div>
  </s:iterator>
</div>

<div class="friendBrowserCheckboxContentPager">
  <div class="clearfix uiMorePager stat_elem friendBrowserMorePager uiMorePagerCenter">
    <jsp:include page="/WEB-INF/jsp/common/pagination.jsp" flush="true" /> 
  </div>
</div>

<script>
function topage(pageNo) {
	<s:if test="keyWordSearch==true">
	location.href = "/sns/sns!keyWordSearch.jhtml?keyword=${keyword}&pageNo="+pageNo
	</s:if>
	
  <s:elseif test="gender>0">
  location.href = "/sns/sns!search.jhtml?cityid=${cityid}&hometownid=${howetownid}&collegeid=${collegeid}&flag=1&startAge=${startAge}&endAge=${endAge}&gender=${gender}&pageNo="+pageNo
  </s:elseif>
  <s:else>
  location.href = "/sns/sns!search.jhtml?cityid=${cityid}&hometownid=${howetownid}&collegeid=${collegeid}&flag=1&startAge=${startAge}&endAge=${endAge}&gender=0&pageNo="+pageNo
  </s:else>
  return false;
}
</script>
<%@ include file="/WEB-INF/jsp/popup/addFriendRequest.jsp"%>
