<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<script type="text/javascript" language="javascript" src="js/calendar.js"></script>
<div role="main" id="contentArea" style="padding:0 0;width:799px;">
  <div class="uiHeader mhl pts pbl uiHeaderPage">
    <div class="clearfix uiHeaderTop">
      <div>
      	
    
      </div>
    </div>
  </div>
  <div class="pal grayArea uiBoxGray noborder">
  	<s:form  action="/event/event!createPlace.jhtml" method="post" enctype="multipart/form-data" >
   	 
      <table class="uiInfoTable mtm mll noBorder">
        <tbody>
          <tr class="dataRow">
            <th class="label">地点名称：</th>
            <td class="data"><s:textfield name="placename" cssClass="inputtext" tipstype="error"/></td>
            <td class="rightCol"></td>
          </tr>
          <tr class="dataRow">
            <th class="label">活动类型：</th>
            <td class="data"><s:select name="category" list="eventCategorys" listKey="id"  listValue="name" cssClass="activity" headerKey="-1" headerValue="" tipstype="error" /></td>
            <td class="rightCol"></td>
          </tr>
	      <tr class="dataRow">
            <th class="label">区域：</th>
            <td class="data"> <s:select name="districtId" list="districts" listKey="id"  listValue="districtname" cssClass="activity" headerKey="-1" headerValue="" tipstype="error" /></td>
            <td class="rightCol"></td>
          </tr>
          
          <tr class="dataRow">
            <th class="label">地点：</th>
            <td class="data"><s:textfield name="address" cssClass="inputtext" id="address" /></td>
            <td class="rightCol"></td>
          </tr>
         
        
          
            <tr class="dataRow">
            <th class="label">图片：</th>
            <td class="data"> <input type="file" name="logo" id="profile_picture_post_file" class="inputfile"/></td>
            <td class="rightCol"></td>
          </tr>
          <tr class="dataRow">
            <th class="label">详细信息：</th>
            <td class="data"><s:textarea name="detail" rows="2" cols="40"  /></td>
            <td class="rightCol"></td>
          </tr>
          
         
          <tr class="spacer">
            <td colspan="3"><hr/></td>
          </tr>
        </tbody>
        <tfoot>
          <tr>
            <th class="label"></th>
            <td colspan="2" class="data">
              <div class="clearfix">
                <label for="u5hu7k_12" class="lfloat uiButton uiButtonConfirm uiButtonLarge">
                  <s:if test="eventname==null">
        			<input type="submit" id="u5hu7k_12" name="save" value="创建活动"/>
        		  </s:if>
          		  <s:else>
                    <input type="submit" id="u5hu7k_12" name="save" value="更新活动"/>
                  </s:else>
                </label>
              </div>
            </td>
          </tr>
        </tfoot>
      </table>
      
    </s:form>
  </div>
</div>

