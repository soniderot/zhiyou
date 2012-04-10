<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div role="main" id="contentArea">
  <div id="reqs_standard_status">
    <div style="display: none;" class="UIMessageBox UIMessageBoxStatus" id="standard_status">
      <h2 class="main_message"> </h2>
      <p class="sub_message"> </p>
    </div>
  </div>
  <input type="hidden" value="b50e3113c7e3f36cf692cf0f46669ff2" name="post_form_id" id="post_form_id" autocomplete="off"/>
  <div class="uiHeader uiHeaderTopAndBottomBorder mbm uiHeaderSection">
    <div class="clearfix uiHeaderTop">
      <div>
        <h3 class="uiHeaderTitle">
        你可能认识的人	
        </h3>
        
        
      </div>
     
    </div>
  </div>
  
  
  <div class="fbRequestList">
    <table cellspacing="0" cellpadding="0" class="uiGrid">
    		
      <tbody>
        <tr class="searchBody">
          
          <td class="image" valign="top" id="imageContainer">
          	
         
            <div class="lists" style="margin-top: -11px;">
              <div id="umyxfi_1" class="fbProfileBrowserResult hideSummary">
                <div class="pvm phs fbProfileBrowserSummaryBox uiBoxWhite bottomborder"></div>
                <div class="fbProfileBrowserLargeList fbProfileBrowserListContainer">
                  <ul class="uiList uiListHorizontal clearfix mvm phs">
                    <s:iterator value="profilesVO" status='st'>
                    	<s:if test="#st.index%4==0&&match==null"> 
                    		<ul class="uiList uiListHorizontal clearfix mvm phs">
                    		</ul>
                    	</s:if> 
                    <li class="uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
                      <div class="dragWrapper">
                      	
                        <a ajaxify="" rel="theater" title="" href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value='profile.userid'/>" name="2731105203678" id="pic_2731105203678" class="uiMediaThumb uiScrollableThumb uiMediaThumbHuge">
                        
                          <div class="tagWrapper">
                          	 
                          		 <a href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value='profile.userid'/>">
                              <img height="116" width="160" src="<s:property value='profile.avatar'/>"/>
                            </a>
                          	
                          	
                           
                            <span class="textWrap fsm fwb">
                              <div class="textWrap fsm fcg" align="center"><s:property value='profile.username'/></div>
                              <div class="textWrap fsm fcg" align="center"><s:property value='profile.genderStr'/>,<s:property value='profile.age'/>岁,<s:property value='profile.cityname'/></div>
                            </span>
                          </div>
                          
                        </a>
                        <i class="dragHover img sp_biub6x sx_e83c4c"></i>
                      </div>
                    </li>
                    </s:iterator>
                  </ul>
                </div>
              </div>
            </div>
          </td>
        </tr>
      </tbody>
      
    </table>
     <div  align="right">
            <div>
              <s:if test="profilesVO.size()>0">
              <jsp:include page="/WEB-INF/jsp/common/pagination.jsp" flush="true" />
            </s:if>
           
            </div>
      </div>
  </div>
</div>
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

	
  var index = 0;
  var pageNo = 0;
  $(".userinfo").eq(0).removeClass("hidden_elem");
  function submitSearch() {
    var agefrom = $("select[name='startAge']").val();
    var ageto = $("select[name='endAge']").val();
    var gender = $("radio[name='gender']").val();
    var keyword = $("input[name='keyword']").val();
    $.get("sns/search.jhtml", 
      {startAge: agefrom, endAge: ageto, gender: gender, keyword: keyword,flag:1},
      function(data){
        $(".userinfo").remove();
        $("#imageContainer").append(data);
        $(".userinfo").eq(0).removeClass("hidden_elem");
        index = 0;
        pageNo = 0;
      }
    );
  }

  function prevPhoto() {
    if(index <= 0) {
      return false;
    }
    index = index - 1;
    $(".userinfo").eq(index + 1).addClass("hidden_elem");
    $(".userinfo").eq(index).removeClass("hidden_elem");
    return false;
  }
  function nextPhoto() {
    var agefrom = $("select[name='startAge']").val();
    var ageto = $("select[name='endAge']").val();
    var gender = $("radio[name='gender']").val();
    var keyword = $("input[name='keyword']").val();
    var size = $(".userinfo").size();
    
    if (index >= size - 1&&size > 1) {
      pageNo = pageNo + 1
      $.get("sns/search.jhtml", 
        {pageNo: pageNo,startAge: agefrom, endAge: ageto, gender: gender, keyword: keyword},
        function(data){
          $("#imageContainer").append(data);
          size = $(".userinfo").size();
          
          if (index < size - 1) {
            index = index + 1;
            $(".userinfo").eq(index-1).addClass("hidden_elem");
            $(".userinfo").eq(index).removeClass("hidden_elem");
          }
        }
      );
    } else {
      index = index + 1;
      $(".userinfo").eq(index-1).addClass("hidden_elem");
      $(".userinfo").eq(index).removeClass("hidden_elem");
    }
    return false;
  }

  function addOrCancelRequest(obj, type) {
    $.ajax({
     type: "GET",
     url: "usr/request!addOrCancelRequestAjax.jhtml",
     dataType: 'text',
     data: "profileId=" + obj + "&operate=" + type+ "&matchflag=T",
     success: function(data) {
        if(type == 1) {
          $("#yesBtn_" + obj).parent().addClass("uiButtonDisabled");
          $("#noBtn_" + obj).parent().removeClass("uiButtonDisabled");
        } else {
          $("#yesBtn_" + obj).parent().removeClass("uiButtonDisabled");
          $("#noBtn_" + obj).parent().addClass("uiButtonDisabled");          
        }
     }
    });
  }
  
  function topage(pageNo) {
  
  location.href = "/usr/landing.jhtml?pageNo="+pageNo
  return false;
  }
  
  


</script>
