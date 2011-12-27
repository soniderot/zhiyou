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
        <h3 class="uiHeaderTitle">推荐场所</h3>
      </div>
    </div>
  </div>
  <div class="fbRequestList">
    <table cellspacing="0" cellpadding="0" class="uiGrid">
      <tbody>
        <tr class="head">
          <td class="left">
            <h1>Are you insterested?</h1>
          </td>
          <td align="center" class="image">
            <label class="uiButton uiButtonConfirm" for="u5rqxr_1">
              <input type="button" value="&nbsp;&nbsp;No&nbsp;&nbsp;" id="u5rqxr_1"/>
            </label>
            <label class="saveButton uiButtonDisabled uiButton uiButtonConfirm" for="u91etj_4">
              <input type="button" value="&nbsp;&nbsp;Yes&nbsp;&nbsp;" disabled="1" id="u91etj_4"/>
            </label>
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
                      <select id="u9ikxu_12" name="ageFrom">
                        <option selected="1" value="">年份</option>
                        <option value="18">18</option>
                        <option value="19">19</option>
                        <option value="20">20</option>
                        <option value="21">21</option>
                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                        <option value="25">25</option>
                        <option value="26">26</option>
                        <option value="27">27</option>
                        <option value="28">28</option>
                        <option value="29">29</option>
                        <option value="30">30</option>
                        <option value="31">31</option>
                        <option value="32">32</option>
                        <option value="33">33</option>
                        <option value="34">34</option>
                        <option value="35">35</option>
                        <option value="36">36</option>
                        <option value="37">37</option>
                        <option value="38">38</option>
                        <option value="39">39</option>
                        <option value="40">40</option>
                        <option value="41">41</option>
                        <option value="42">42</option>
                        <option value="43">43</option>
                        <option value="44">44</option>
                        <option value="45">45</option>
                        <option value="46">46</option>
                        <option value="47">47</option>
                        <option value="48">48</option>
                        <option value="49">49</option>
                        <option value="50">50</option>
                      </select>
                      &nbsp;&nbsp;To&nbsp;
                      <select id="u9ikxu_12" name="ageTo">
                        <option selected="1" value="">年份</option>
                        <option value="18">18</option>
                        <option value="19">19</option>
                        <option value="20">20</option>
                        <option value="21">21</option>
                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                        <option value="25">25</option>
                        <option value="26">26</option>
                        <option value="27">27</option>
                        <option value="28">28</option>
                        <option value="29">29</option>
                        <option value="30">30</option>
                        <option value="31">31</option>
                        <option value="32">32</option>
                        <option value="33">33</option>
                        <option value="34">34</option>
                        <option value="35">35</option>
                        <option value="36">36</option>
                        <option value="37">37</option>
                        <option value="38">38</option>
                        <option value="39">39</option>
                        <option value="40">40</option>
                        <option value="41">41</option>
                        <option value="42">42</option>
                        <option value="43">43</option>
                        <option value="44">44</option>
                        <option value="45">45</option>
                        <option value="46">46</option>
                        <option value="47">47</option>
                        <option value="48">48</option>
                        <option value="49">49</option>
                        <option value="50">50</option>
                      </select>
                    </td>
                  </tr>
                  <tr id="u9ikxu_14">
                    <td>性别：</td>
                    <td>
                      <label for="u9ikxu_25">
                                                男<input type="radio" id="u9ikxu_25" name="gender" value = "1" title="男"/>
                      </label>&nbsp;&nbsp;&nbsp;&nbsp;
                      <label for="u9ikxu_26">
                                                女<input type="radio" id="u9ikxu_26" name="gender" value = "2" title="女"/>
                      </label>&nbsp;&nbsp;&nbsp;&nbsp;
                      <label for="u9ikxu_27">
                                                 不限<input type="radio" id="u9ikxu_27" name="gender" value = "0" title="不限"/>
                      </label>
                    </td>
                  </tr>
                  <tr id="u9ikxu_15">
                    <td>
                                            学校：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    </td>
                    <td>
                      <div id="u9ikxu_18">
                        <div id="u9ikxu_24" class="uiTypeahead lfloat">
                          <div class="wrap">
                            <input type="hidden" name="highSchoolId" value="0" class="hiddenInput" autocomplete="off"/>
                            <div class="innerWrap">
                              <input type="text" title="键入大学名称" spellcheck="false" onfocus="return wait_for_load(this, event, function() {;JSCC.get(&#39;j4edc8b1c8101672034723769&#39;).init([&quot;defaultToText&quot;,&quot;submitOnChange&quot;]);;});" autocomplete="off" value="键入大学名称" size="35" placeholder="键入大学名称" class="inputtext textInput DOMControl_placeholder"/>
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
                        <input type="button" value="&nbsp;&nbsp;更&nbsp;新&nbsp;&nbsp;" id="u5rqxr_1" onclick="submitSearch()" />
                      </label>
                    </td>
                  </tr>
                </tbody>
              </table>
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
  function submitSearch() {
    var agefrom = $("select[name='ageFrom']").val();
    var ageto = $("select[name='ageTo']").val();
    var gender = $("radio[name='gender']").val();
    var schoolid = $("input[name='highSchoolId']").val();
    $.get("sns/search.jhtml", 
      {ageFrom: agefrom, ageTo: ageto, gender: gender, highSchoolId: schoolid},
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
    var size = $(".userinfo").size();
    if (index >= size - 1&&size > 1) {
      pageNo = pageNo + 1
      $.get("sns/search.jhtml", 
        {pageNo: pageNo},
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
</script>
