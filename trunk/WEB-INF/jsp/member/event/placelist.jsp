<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<div id="contentArea" role="main" style="width:800px">
  <div id="reqs_standard_status">
    <div id="standard_status" class="UIMessageBox UIMessageBoxStatus" style="display: none;">
      <h2 class="main_message"> </h2>
      <p class="sub_message"> </p>
    </div>
  </div>
  <input type="hidden" autocomplete="off" id="post_form_id" name="post_form_id" value="b50e3113c7e3f36cf692cf0f46669ff2">
  <div class="uiHeader uiHeaderTopAndBottomBorder mbm uiHeaderSection">
    <div class="clearfix uiHeaderTop">
      <div>
        <h3 class="uiHeaderTitle">推荐场所</h3>
      </div>
    </div>
  </div>
  <div class="fbRequestList">
    <ul class="uiList">
      <s:iterator value="places">
      <li class="objectListItem uiListItem uiListLight uiListVerticalItemBorder" id="100003206989957_1_req">
        <div class="UIImageBlock clearfix UIImageBlock_Entity">
        	<a class="UIImageBlock_Image UIImageBlock_ENT_Image" href="event/event!viewPlaceDetail.jhtml?placeId=<s:property value="id" />" tabindex="-1">
	          <img class="img" src="<s:property value="avatar" />"   alt="">
	          <!--
	          <div class="uiScaledImageContainer uiProfilePhotoHuge">
	          	<img class="img" src="<s:property value="avatar" />"   alt="">
	          </div>-->
          </a>
          <div id="100003206989957_1_req_status" class="requestStatus UIImageBlock_Content UIImageBlock_SMALL_Content">
            <div class="clearfix">
              <div class="rfloat">
                <div class="auxiliary" id="100003206989957_1_req_aux">
                  <div class="actions">
                    <label class="uiButton uiButtonConfirm" for="ul7tes_1">
                    	<input type="button" value="选择" name="actions[accept]" onclick="selectPlace('<s:property value="id"/>', '<s:property value="placename"/>','<s:property value="address"/>')">
                    </label>
                    <!---
                    <label class="uiButton" for="ul7tes_2">
                    	<input type="button" value="去看看" name="actions[hide]" title="去看看" id="ul7tes_2">
                    </label>-->
                  </div>
                </div>
              </div>
              <div>
                <div>
                	<span class="title fsl fwb fcb">
                      <a href="event/event!viewPlaceDetail.jhtml?placeId=<s:property value="id" />"><s:property value="placename" /></a>
                    </span>
                </div>
                <div class="networkContextWrapper"><br>
                	地址：<s:property value="address" /><br>
                	<span style="display:inline-block;float:left;">简介：</span>
                    <span style="overflow:hidden;display:inline-block;width:600px;vertical-align:top;"><s:property value="summary" /></span>
                </div>
              </div>
            </div>
            <div class="fsm fwn fcg"></div>
          </div>
        </div>
      </li>
    </s:iterator >
      <!--
      <li class="uiListItem uiListLight uiListVerticalItemBorder">
        <div class="pam hidden_elem uiBoxLightblue">没有新请求</div>
      </li>
      -->
    </ul>
  </div>
</div>
<script type="text/javascript">
  function selectPlace(placeId, placeName,address) {
    window.opener.document.getElementById("placeId").value=placeId;
    window.opener.document.getElementById("address").value=placeName+"("+address+")";
    window.close();
  }
</script>