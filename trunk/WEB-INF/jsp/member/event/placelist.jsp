<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<div id="contentArea" role="main">
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
					        	<a class="UIImageBlock_Image UIImageBlock_ENT_Image" href="http://www.facebook.com/profile.php?id=100003206989957" tabindex="-1">
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
					                  <form rel="async" action="/ajax/reqs.php" method="post" onsubmit="return Event.__inlineSubmit(this,event)">
					                    <input type="hidden" autocomplete="off" name="post_form_id" value="b50e3113c7e3f36cf692cf0f46669ff2">
					                    <div class="actions">
					                      <label class="uiButton uiButtonConfirm" for="ul7tes_1">
					                      	<input type="submit" value="选择" name="actions[accept]" id="ul7tes_1">
					                      </label>
					                      <label class="uiButton" for="ul7tes_2">
					                      	<input type="submit" value="去看看" name="actions[hide]" title="去看看" id="ul7tes_2">
					                      </label>
					                    </div>
					                  </form>
					                </div>
					              </div>
					              <div>
					                <div>
					                	<span class="title fsl fwb fcb"><a href="http://www.facebook.com/profile.php?id=100003206989957"><s:property value="placename" /></a></span>
					                </div>
					                <div class="networkContextWrapper"><br>
					                	已有<font color="red">1282</font>人选择<br>
					                	地址：延平路98号<br>
					                	简介：旋转餐厅，让您享受巴黎的浪漫，感受中国的魅力。
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