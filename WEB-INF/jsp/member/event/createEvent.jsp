<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<div role="main" id="contentArea" style="padding:0 0;width:799px;">
  <div class="uiHeader mhl pts pbl uiHeaderPage">
    <div class="clearfix uiHeaderTop">
      <div>
      	<s:if test="eventname==null">
        <h2 class="uiHeaderTitle">创建活动</h2>
        </s:if>
        
        <s:else>
        	<h2 class="uiHeaderTitle">更新活动</h2>
      </s:else>
      
     
      </div>
    </div>
  </div>
  <div class="pal grayArea uiBoxGray noborder">
  	<s:form action="/event/event!saveEvent.jhtml" method="post" enctype="multipart/form-data" >
   	  <input type="hidden" value="<s:property value="eventId" />" name="eventId"/>
      <input type="hidden" value="d987c72246020e1891443953e9b5b41b" name="post_form_id" autocomplete="off"/>
      <input type="hidden" autocomplete="off" value="AQCwdyla" name="fb_dtsg"/>
      <table class="uiInfoTable mtm mll noBorder">
        <tbody>
          <tr class="dataRow">
            <th class="label">活动名称：</th>
            <td class="data"><s:textfield name="eventname" cssClass="inputtext"   /></td>
            <td class="rightCol"></td>
          </tr>
          <tr id="event_time_row" class="dataRow">
            <th class="label">开始时间：</th>
            <td class="data">
              <table cellspacing="0" cellpadding="0" class="uiGrid">
                <tbody>
                  <tr>
                    <td class="prs">
                      <div id="u5hu7k_1" class="uiDatepicker clearfix">
                        <div class="dateBox">
                          <s:textfield name="startDate" cssClass="inputtext textField"  size="10"/>
                          <input type="hidden" value="12/5/2011" name="event_start" class="hiddenField" autocomplete="off"/>
                          <div class="calendarWrapper">
                            <table cellspacing="0" border="0">
                              <tbody>
                                <tr>
                                  <td class="prevMonth"><i class="img sp_b8po3p sx_4e5fd4"></i></td>
                                  <td colspan="5" class="monthTitle"></td>
                                  <td class="nextMonth"><i class="img sp_b8po3p sx_3fd0d2"></i></td>
                                </tr>
                               
                                <tr>
                                  <td class="days" colspan="7">
                                    <table>
                                      <tbody class="dayTable"></tbody>
                                    </table>
                                  </td>
                                </tr>
                              </tbody>
                            </table>
                          </div>
                        </div>
                      </div>
                    </td>
                    <td class="phs">
                      <s:select name="startHour" list="#request.hours" listKey="key"  listValue="value" ></s:select>
                     
                    </td>
                    <td class="pls">
                      
                    </td>
                  </tr>
                </tbody>
              </table>
            </td>
            <td class="rightCol"></td>
          </tr>
         
         
         
         <tr id="event_time_row" class="dataRow">
            <th class="label">结束时间：</th>
            <td class="data">
              <table cellspacing="0" cellpadding="0" class="uiGrid">
                <tbody>
                  <tr>
                    <td class="prs">
                      <div id="u5hu7k_1" class="uiDatepicker clearfix">
                        <div class="dateBox">
                          <s:textfield name="endDate" cssClass="inputtext textField"  size="10"/>
                          <input type="hidden" value="12/5/2011" name="event_start" class="hiddenField" autocomplete="off"/>
                          <div class="calendarWrapper">
                            <table cellspacing="0" border="0">
                              <tbody>
                                <tr>
                                  <td class="prevMonth"><i class="img sp_b8po3p sx_4e5fd4"></i></td>
                                  <td colspan="5" class="monthTitle"></td>
                                  <td class="nextMonth"><i class="img sp_b8po3p sx_3fd0d2"></i></td>
                                </tr>
                               
                                <tr>
                                  <td class="days" colspan="7">
                                    <table>
                                      <tbody class="dayTable"></tbody>
                                    </table>
                                  </td>
                                </tr>
                              </tbody>
                            </table>
                          </div>
                        </div>
                      </div>
                    </td>
                    <td class="phs">
                       <s:select name="endHour" list="#request.hours" listKey="key"  listValue="value" ></s:select>
                    </td>
                    <td class="pls">
                      
                    </td>
                  </tr>
                </tbody>
              </table>
            </td>
            <td class="rightCol"></td>
          </tr>
         
         
         
          <tr class="dataRow">
            <th class="label">地点：</th>
            <td class="data"> <s:textfield name="address" cssClass="inputtext"  /></td>
            <td class="rightCol"></td>
          </tr>
         
        
         
          <tr>
            <th class="label"></th>
            <td class="data"><a href="#">推荐场所</a></td>
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
          <tr class="dataRow">
            <th class="label">邀请了谁？：</th>
            <td class="data">
              <div id="u5hu7k_11">
                <a id="u5hu7k_10" href="#" role="button" class="uiButton" onclick="return showPopup('dialog_0')"><span class="uiButtonText">选择宾客</span></a>
                <input type="hidden" value="" name="invitees" class="invitees" autocomplete="off"/>
                <input type="hidden" value="" name="emails" class="emails" autocomplete="off"/>
                <input type="hidden" name="message" class="message" autocomplete="off"/>
              </div>
            </td>
            <td class="rightCol"><span class="hidden_elem" id="event_info_hidden_inputs"></span></td>
          </tr>
          <tr class="dataRow">
            <th class="label"></th>
            <td class="data">
              <ul class="uiList">
              	<!--
                <li class="uiListItem uiListVerticalItemBorder">
                  <label for="privacy_type" class="uiCheckbox">
                    <input type="checkbox" checked="1" onchange="CSS.conditionShow($('u5hu7k_5'), !this.checked);CSS.conditionShow(null, this.checked);" name="privacy_type" id="privacy_type"/>
                  </label>
                  <label for="privacy_type">Make this event public (anyone can see and join)</label>
                </li>-->
                <li id="u5hu7k_5" class="pll hidden_elem uiListItem uiListVerticalItemBorder">
                  <label for="friend_invites" class="uiCheckbox">
                    <input type="checkbox" name="friend_invites" id="friend_invites"/>
                  </label>
                  <label for="friend_invites">Let guests invite friends</label>
                </li>
                
                
                <!---
                <li class="uiListItem uiListVerticalItemBorder">
                  <label for="guest_list" class="uiCheckbox">
                    <input type="checkbox" checked="1" name="guest_list" id="guest_list"/>
                  </label>
                  <label for="guest_list">在活动页面显示宾客名单</label>
                </li>
                <li class="hidden_elem uiListItem uiListVerticalItemBorder">
                  <input type="checkbox" checked="1" name="connections_can_post" id="connections_can_post"/>
                  <label for="connections_can_post">非管理员可以在涂鸦墙上发贴</label>
                </li>
                --->
                
              </ul></td>
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

<%@ include file="/WEB-INF/jsp/popup/inviteEventFriends.jsp"%>