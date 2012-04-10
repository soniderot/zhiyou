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
        <h3 class="uiHeaderTitle">配对会员</h3>
      </div>
    </div>
  </div>
  <div class="fbRequestList">
  <table cellspacing="0" cellpadding="0" class="uiGrid">
    <form  action="/sns/search!search.jhtml" >
    	<input type="hidden" id="selectedCity" name="cityid" />
      <tbody>
        <tr>
          <td colspan="3"><div class="searchArea">
            <table>
              <tbody class="fbSearchAdvancedFiltersVisible">
              <tr>
                  <td> 年龄： </td>
                  <td> From&nbsp;
                    <s:select name="startAge" list="#request.beginAges" listKey="key"  listValue="value" ></s:select>
                    &nbsp;&nbsp;To&nbsp;
                    <s:select name="endAge" list="#request.endAges" listKey="key"  listValue="value" ></s:select>
                  </td>

                  <td>性别：</td>
                  <td><s:select name="gender" list="#{'0':'选择性别', '1':'男', '2':'女'}"></s:select>
                  </td>
                  
                  <td>城市：</td>
                  <td>
                  	<s:if test="cityid==0">
                        <s:textfield id="mycity" name="cityname"  cssClass="inputtext textInput DOMControl_placeholder" placeholder="请您输入所在城市" tipstype="error" />
                      </s:if>
                      <s:else>
                        	<s:textfield id="mycity" name="cityname"  cssClass="inputtext textInput DOMControl_placeholder"  tipstype="error" />
                      </s:else>
                  </td>

                 
                  
                  <td class="updateButton"><label class="uiButton uiButtonConfirm" for="u5rqxr_1">
                    <!--
                        <input type="button" value="&nbsp;&nbsp;更&nbsp;新&nbsp;&nbsp;" id="u5rqxr_1" onclick="submitSearch()" />
                        -->
                    <input type="submit" value="&nbsp;&nbsp;更&nbsp;新&nbsp;&nbsp;" id="u5rqxr_1" />
                    </label>
                  </td>

              </tr>
              <tr>
               <td> 关键字：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
                  <td><div id="u9ikxu_18">
                      <div id="u9ikxu_24" class="uiTypeahead lfloat">
                        <div class="wrap">
                          <div class="innerWrap">
                            <s:textfield name="keyword" cssClass="inputtext DOMControl_placeholder"  />
                          </div>
                        </div>
                      </div>
                    </div>
                  </td>
                  
                   <td> 兴趣爱好：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
                  <td><div id="u9ikxu_18">
                      <div id="u9ikxu_24" class="uiTypeahead lfloat">
                        <div class="wrap">
                          <div class="innerWrap">
                            <s:textfield name="hobby" cssClass="inputtext DOMControl_placeholder"  />
                          </div>
                        </div>
                      </div>
                    </div>
                  </td>
              </tr>
              </tbody>
            </table>
    </form>
    </div>
    
    </td>
    
    </tr>
   
    <tr class="searchBody">

      <td class="image" align="center" id="imageContainer" colspan="1">
      <div style="position:relative">
      <div class="prev arrowLeft"> <a title="上一张" href="#" class="uiButton uiButtonOverlay uiButtonNoText" onclick="return prevPhoto();"> <span class="uiButtonText"></span> </a> </div>
        <div class="next arrowRight"> <a title="下一张" href="#" class="uiButton uiButtonOverlay uiButtonNoText" onclick="return nextPhoto();"> <span class="uiButtonText"></span> </a> </div>
        <div class="userinfo hidden_elem">
          <div class="slidewrap">
            <div class="slidesubwrap">
              <div class="slidecontent"> <img src="images/male.gif"/> </div>
            </div>
          </div>
          <div align="center"> <span></span> <span></span> <span></span> </div>
        </div>
        
     
        </td>
    </tbody>
    
  </table>
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
  
  $.get("sns/search.jhtml", 
      {startAge: <s:property value="startAge" />, endAge: <s:property value="endAge" />, gender: <s:property value="gender" />, keyword:'<s:property value="keyword" />',flag:0,profileId:<s:property value="profileId" />},
      function(data){
        $(".userinfo").remove();
        $("#imageContainer").append(data);
        $(".userinfo").eq(0).removeClass("hidden_elem");
        index = 0;
        pageNo = 0;
      }
    );
  
  
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
   
    if (index >= size - 1&&size >=1
) {
      pageNo = pageNo + 1
      $.get("sns/search.jhtml", 
        {pageNo: pageNo,startAge: agefrom, endAge: ageto, gender: gender, keyword: keyword,profileId:<s:property value="profileId" />,flag:'1'},
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
</script>
