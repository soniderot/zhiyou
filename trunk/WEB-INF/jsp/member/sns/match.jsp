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
      <tbody>
        <tr class="head">
          <td class="left">
            <h1>感兴趣?</h1>
          </td>
          <td align="center" class="image">

          </td>
      </tr>
        <tr class="searchBody">
          <td>
            <div class="searchArea">
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
                  </tr>
                  <tr id="u9ikxu_14">
                    <td>性别：</td>
                    <td>
                      <s:select name="gender" list="#{'0':'选择性别', '1':'男', '2':'女'}"></s:select>
                    </td>
                  </tr>
                  <tr id="u9ikxu_15">
                    <td>
                                            关键字：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    </td>
                    <td>
                      <div id="u9ikxu_18">
                        <div id="u9ikxu_24" class="uiTypeahead lfloat">
                          <div class="wrap">
                            
                            <div class="innerWrap">
                            <s:textfield name="keyword" cssClass="inputtext DOMControl_placeholder"  />
                            </div>
                          </div>
                        </div>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td></td>
                    <td class="updateButton">
                      <label class="uiButton uiButtonConfirm" for="u5rqxr_1">
                      	<!--
                        <input type="button" value="&nbsp;&nbsp;更&nbsp;新&nbsp;&nbsp;" id="u5rqxr_1" onclick="submitSearch()" />
                        -->
                        <input type="submit" value="&nbsp;&nbsp;更&nbsp;新&nbsp;&nbsp;" id="u5rqxr_1" />
                      </label>
                    </td>
                  </tr>
                </tbody>
              </table>
               </form>
            </div>
          </td>
          <td class="image" align="center" id="imageContainer">
            <div class="prev arrowLeft">
              <a title="上一张" href="#" class="uiButton uiButtonOverlay uiButtonNoText" onclick="return prevPhoto();">
                <span class="uiButtonText"></span>
              </a>
            </div>
            <div class="next arrowRight">
              <a title="下一张" href="#" class="uiButton uiButtonOverlay uiButtonNoText" onclick="return nextPhoto();">
                <span class="uiButtonText"></span>
              </a>
            </div>
            <div class="userinfo hidden_elem">
              <div class="slidewrap">
      			<div class="slidesubwrap">
      				<div class="slidecontent">
      				  <img src="images/male.gif"/>
      				</div>
      			</div>
      		  </div>
              <div align="center">
                <span></span>
                <span></span>
                <span></span>
              </div>
            </div>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</div>
<script type="text/javascript">
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
