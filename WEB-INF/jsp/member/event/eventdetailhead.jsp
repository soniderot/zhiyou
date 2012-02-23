<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<div class="mbl" id="event_info_pagelet" data-referrer="event_info_pagelet">
  <table class="uiInfoTable mvm profileInfoTable">
    <tbody>
      <tr>
        <th class="label">时间</th>
        <td class="data">
          <div> 
            <span class="dtstart">
              <span class="value-title" title=""> </span>
              <s:date name="event.begintime" format="yyyy-MM-dd HH:mm" />
            </span> - 
            <span class="dtend">
              <span class="value-title" title=""> </span>
              <s:date name="event.endtime" format="yyyy-MM-dd HH:mm" />
            </span>
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
            <span class="fn org"> <s:property value="event.address" /></span>
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
            <span class="fn org"> <s:property value="event.detail" /></span>
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
        <th class="label">创建人</th>
        <td class="data">
          <div class="uiCollapsedList uiCollapsedListHidden organizer" id="u4yt3n_2">
            <span class="visible">
              <a href="profile/profile!viewProfileInfo.jhtml?userid=<s:property value="createUser.userid" />" > <s:property value="createUser.username" /></a>
            </span>
          </div>
        </td>
      </tr>
      <tr class="spacer">
        <td colspan="2"><hr></td>
      </tr>
    </tbody>
    
   
  </table>
</div>