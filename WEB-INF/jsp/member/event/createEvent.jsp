<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<div role="main" id="contentArea" style="padding:0 0;width:799px;">
  <div class="uiHeader mhl pts pbl uiHeaderPage">
    <div class="clearfix uiHeaderTop">
      <div>
        <h2 class="uiHeaderTitle">创建活动</h2>
      </div>
    </div>
  </div>
  <div class="pal grayArea uiBoxGray noborder">
    <form onsubmit="return Event.__inlineSubmit(this,event)" id="event_info_form" action="http://www.facebook.com/events/create/" method="post" class="eventEditForm">
      <input type="hidden" value="d987c72246020e1891443953e9b5b41b" name="post_form_id" autocomplete="off"/>
      <input type="hidden" autocomplete="off" value="AQCwdyla" name="fb_dtsg"/>
      <table class="uiInfoTable mtm mll noBorder">
        <tbody>
          <tr class="dataRow">
            <th class="label">事件名称：</th>
            <td class="data"><input type="text" name="name" id="name" class="inputtext"/></td>
            <td class="rightCol"></td>
          </tr>
          <tr id="event_time_row" class="dataRow">
            <th class="label">日期与时间：</th>
            <td class="data">
              <table cellspacing="0" cellpadding="0" class="uiGrid">
                <tbody>
                  <tr>
                    <td class="prs">
                      <div id="u5hu7k_1" class="uiDatepicker clearfix">
                        <div class="dateBox">
                          <input type="text" title="日期。适当的格式是月份/日期/年份。" autocomplete="off" size="10" name="event_startIntlDisplay" value="12/5/2011" class="inputtext textField"/>
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
                                  <th style="width: 14.2857%;" class="first">日</th>
                                  <th style="width: 14.2857%;" class="">一</th>
                                  <th style="width: 14.2857%;" class="">二</th>
                                  <th style="width: 14.2857%;" class="">三</th>
                                  <th style="width: 14.2857%;" class="">四</th>
                                  <th style="width: 14.2857%;" class="">五</th>
                                  <th style="width: 14.2857%;" class="last">六</th>
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
                      <select id="start_time_min" name="start_time_min">
                        <option value="0">0:00</option>
                        <option value="30">0:30</option>
                        <option value="60">1:00</option>
                        <option value="90">1:30</option>
                        <option value="120">2:00</option>
                        <option value="150">2:30</option>
                        <option value="180">3:00</option>
                        <option value="210">3:30</option>
                        <option value="240">4:00</option>
                        <option value="270">4:30</option>
                        <option value="300">5:00</option>
                        <option value="330">5:30</option>
                        <option value="360">6:00</option>
                        <option value="390">6:30</option>
                        <option value="420">7:00</option>
                        <option value="450">7:30</option>
                        <option value="480">8:00</option>
                        <option value="510">8:30</option>
                        <option value="540">9:00</option>
                        <option value="570">9:30</option>
                        <option value="600">10:00</option>
                        <option value="630">10:30</option>
                        <option value="660">11:00</option>
                        <option value="690">11:30</option>
                        <option value="720">12:00</option>
                        <option value="750">12:30</option>
                        <option value="780">13:00</option>
                        <option value="810">13:30</option>
                        <option value="840">14:00</option>
                        <option value="870">14:30</option>
                        <option value="900">15:00</option>
                        <option value="930">15:30</option>
                        <option value="960">16:00</option>
                        <option value="990">16:30</option>
                        <option value="1020">17:00</option>
                        <option value="1050">17:30</option>
                        <option value="1080">18:00</option>
                        <option value="1110">18:30</option>
                        <option value="1140">19:00</option>
                        <option value="1170">19:30</option>
                        <option selected="selected" value="1200">20:00</option>
                        <option value="1230">20:30</option>
                        <option value="1260">21:00</option>
                        <option value="1290">21:30</option>
                        <option value="1320">22:00</option>
                        <option value="1350">22:30</option>
                        <option value="1380">23:00</option>
                        <option value="1410">23:30</option>
                      </select>
                    </td>
                    <td class="pls">
                      
                    </td>
                  </tr>
                </tbody>
              </table>
            </td>
            <td class="rightCol"></td>
          </tr>
          <tr id="end_time_row" class="dataRow hidden_elem">
            <th class="label">结束时间：</th>
            <td class="data"><div id="end_time_row_content"></div></td>
            <td class="rightCol"></td>
          </tr>
          <tr class="dataRow">
            <th class="label">地点：</th>
            <td class="data">
              <div id="u5hu7k_3" class="uiTypeahead uiClearableTypeahead">
                <div class="wrap">
                  <label for="u5hu7k_7" class="clear uiCloseButton">
                    <input type="button" id="u5hu7k_7" onclick="var c = JSCC.get('j4edc70bb69e6b7e076659742').getCore(); c.reset(); c.getElement().focus(); " title="删除"/>
                  </label>
                  <input type="hidden" name="place_page_id" class="hiddenInput" autocomplete="off"/>
                  <div class="innerWrap">
                    <input type="text" spellcheck="false" onfocus="return wait_for_load(this, event, function() {;JSCC.get('j4edc70bb69e6b7e076659742').init([]);;});" autocomplete="off" name="location" class="inputtext textInput"/>
                  </div>
                </div>
                <div id="u5hu7k_2" style="width: 381px;" class="uiTypeaheadView PlacesTypeaheadView hidden_elem">
                  <div id="u5hu7k_8" style="width: 381px;" class="uiScrollableArea nofade">
                    <div class="uiScrollableAreaWrap scrollable">
                      <div style="width: 371px;" class="uiScrollableAreaBody">
                        <div class="uiScrollableAreaContent">
                          <div class="PlacesTypeaheadViewList"></div>
                        </div>
                      </div>
                    </div>
                    <div class="uiScrollableAreaTrack">
                      <div class="uiScrollableAreaGripper hidden_elem"></div>
                    </div>
                  </div>
                  <div id="u5hu7k_6" style="height: 150px; width: 381px;" class="uiMap2 PlacesTokenizerMap hidden_elem">
                    <iframe height="381" frameborder="0" width="150" scrolling="no" src="http://www.facebook.com/places/map2_iframe.php?locale=zh_CN&amp;id=u5hu7k_6&amp;controller=0" id="u5hu7k_9" class="uiMap2Iframe"></iframe>
                  </div>
                </div>
              </div>
            </td>
            <td class="rightCol"></td>
          </tr>
          <tr id="street_row" class="dataRow hidden_elem">
            <th class="label">街道：</th>
            <td class="data"><input type="text" name="street" value="" class="inputtext"/></td>
            <td class="rightCol"></td>
          </tr>
          <tr id="geo_row" class="dataRow hidden_elem">
            <th class="label">市/县：</th>
            <td class="data">
              <div id="u5hu7k_4" class="uiTypeahead">
                <div class="wrap">
                  <input type="hidden" name="geo_id" class="hiddenInput" autocomplete="off"/>
                  <div class="innerWrap">
                    <input type="text" spellcheck="false" onfocus="return wait_for_load(this, event, function() {;JSCC.get('j4edc70bb69e6b7e076659744').init([]);;});" autocomplete="off" value="" id="geo_sq" name="geo_sq" class="inputtext textInput"/>
                  </div>
                </div>
              </div>
            </td>
            <td class="rightCol"></td>
          </tr>
          <tr>
            <th class="label"></th>
            <td class="data"><a href="#">推荐场所</a></td>
            <td class="rightCol"></td>
          </tr>
          <tr class="dataRow">
            <th class="label">详细信息：</th>
            <td class="data"><textarea id="event_desc" name="desc" rows="2"></textarea></td>
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
                <li class="uiListItem uiListVerticalItemBorder">
                  <label for="privacy_type" class="uiCheckbox">
                    <input type="checkbox" checked="1" onchange="CSS.conditionShow($('u5hu7k_5'), !this.checked);CSS.conditionShow(null, this.checked);" name="privacy_type" id="privacy_type"/>
                  </label>
                  <label for="privacy_type">Make this event public (anyone can see and join)</label>
                </li>
                <li id="u5hu7k_5" class="pll hidden_elem uiListItem uiListVerticalItemBorder">
                  <label for="friend_invites" class="uiCheckbox">
                    <input type="checkbox" name="friend_invites" id="friend_invites"/>
                  </label>
                  <label for="friend_invites">Let guests invite friends</label>
                </li>
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
                  <input type="submit" id="u5hu7k_12" name="save" value="创建活动"/>
                </label>
              </div>
            </td>
          </tr>
        </tfoot>
      </table>
      <input type="hidden" name="new"/>
      <input type="hidden" value="1323069627" name="session_id" autocomplete="off"/>
      <input type="hidden" name="submitting"/>
    </form>
  </div>
</div>

<%@ include file="/WEB-INF/jsp/popup/inviteEventFriends.jsp"%>