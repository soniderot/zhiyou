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
        	<s:if test="match==null"> 
        	配对会员&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 
        
        	<a href="sns/search!search.jhtml?match=1">
        		配对成功会员</a>
        	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</h3>
        </s:if> 
        
        <s:if test="match!=null"> 
        	<a href="sns/search!search.jhtml">
        	配对会员&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 
        </a>
        	
        		配对成功会员
        	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</h3>
        </s:if> 
        
        
      </div>
     
    </div>
  </div>
  
  
  <div class="fbRequestList">
    <table cellspacing="0" cellpadding="0" class="uiGrid">
    	<s:if test="match==null"> 
    	<form  action="/sns/search!search.jhtml" >
      <tbody>
<br>
        <tr class="searchBody">
          <td valign="top">
            <div class="searchArea">
              <table>
                <tbody class="fbSearchAdvancedFiltersVisible">
                  <tr id="u9ikxu_13">
                    <td>
                      年龄：
                    </td>
                    <td>
                      从&nbsp;
                      <s:select name="startAge" list="#request.beginAges" listKey="key"  listValue="value" ></s:select>
                      &nbsp;&nbsp;到&nbsp;
                     <s:select name="endAge" list="#request.endAges" listKey="key"  listValue="value" ></s:select>
                    </td>
                  </tr>
                  <tr id="u9ikxu_14">
                    <td>性别：</td>
                    <td>
                      <s:select name="gender" list="#{'0':'选择性别', '1':'男', '2':'女'}"></s:select>
                      
                     
                      </label>
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
                        <input type="submit" value="&nbsp;&nbsp;更&nbsp;新&nbsp;&nbsp;" id="u5rqxr_1"  />
                      </label>
                    </td>
                  </tr>
                </tbody>
                </form>
                </s:if> 
              </table>
            </div>
          </td>
          <td class="image" valign="top" id="imageContainer">
            <div class="lists" style="margin-top: -11px;">
              <div id="umyxfi_1" class="fbProfileBrowserResult hideSummary">
                <div class="pvm phs fbProfileBrowserSummaryBox uiBoxWhite bottomborder"></div>
                <div class="fbProfileBrowserLargeList fbProfileBrowserListContainer">
                  <ul class="uiList uiListHorizontal clearfix mvm phs">
                    <s:iterator value="profileList" status='st'>
                    	<s:if test="#st.index%4==0&&match==null"> 
                    		<ul class="uiList uiListHorizontal clearfix mvm phs">
                    			</ul>
                    		</s:if> 
                    <li class="uiListItem uiListHorizontalItemBorder uiListHorizontalItem">
                      <div class="dragWrapper">
						            		<a ajaxify="" rel="theater" title="" href="#" name="2731105203678" id="pic_2731105203678" class="uiMediaThumb uiScrollableThumb uiMediaThumbHuge">
							                <div class="tagWrapper">
							                	<i style="background-image: url(http://localhost:8080/photos/2012/02/25/1cdec9db-5b72-45d1-b8fa-f06654d36998-small.jpg);"></i>
							                 <span class="textWrap fsm fwb">
							                 	 <div class="textWrap fsm fcg" align="center"><s:property value='username'/></div>
							                  
							                  <div class="textWrap fsm fcg" align="center"><s:property value='age'/>岁,<s:property value='cityname'/></div>
							                  <div class="taggerOverlay hidden_elem">
							                   </span>
							                  </div>
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
            	<s:if test="profileList.size()>0">
            	<jsp:include page="/WEB-INF/jsp/common/pagination.jsp" flush="true" />
            </s:if>
           
            </div>
      </div>
  </div>
</div>
<script type="text/javascript">
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
  <s:if test="keyword!=null">
   location.href = "/sns/search!search.jhtml?startAge=<s:property value="startAge" />&endAge=<s:property value="endAge" />&gender=<s:property value="gender" />&keyword=<s:property value="keyword" />&pageNo="+pageNo
  </s:if>
  <s:else>
  location.href = "/sns/search!search.jhtml?match=<s:property value="match" />&startAge=<s:property value="startAge" />&endAge=<s:property value="endAge" />&gender=<s:property value="gender" />&pageNo="+pageNo
  </s:else>
  return false;
  }
</script>
