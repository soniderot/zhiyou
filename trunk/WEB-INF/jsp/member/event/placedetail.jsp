<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<div class="mbl" id="event_info_pagelet" data-referrer="event_info_pagelet">
	<img class="uiPhotoThumb largePhoto" widhth="220" height="220" src="<s:property value="place.avatar" />" alt="">
  <table class="uiInfoTable mvm profileInfoTable" style="table-layout:fixed;">
    <tbody>
       <tr>
        <th class="label">名称</th>
        <td class="data">
          <div class="location vcard">
            <span class="fn org"> <s:property value="place.placename" /></span>
            <div class="adr"></div>
          </div>
        </td>
      </tr>
      <tr class="spacer">
        <td colspan="2"><hr></td>
      </tr>
    </tbody>
    <tbody>
      <tr>
        <th class="label">位置</th>
        <td class="data">
          <div class="location vcard">
            <span class="fn org"> <s:property value="place.address" /></span>
            <div class="adr"></div>
          </div>
        </td>
      </tr>
      <tr class="spacer">
        <td colspan="2"><hr></td>
      </tr>
    </tbody>
    
    <tbody>
      <tr>
        <th class="label">详细信息</th>
        <td class="data">
          <div class="location vcard">
            <span class="fn org"> <s:property value="place.summary" /></span>
            <div class="adr"></div>
          </div>
        </td>
      </tr>
      <tr class="spacer">
        <td colspan="2"><hr></td>
      </tr>
    </tbody>
    
   
    
   
  </table>
</div>