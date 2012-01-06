<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<div role="main" id="contentArea">
  <div data-referrer="pagelet_friends" id="pagelet_friends">
    <div class="uiHeader uiHeaderWithImage uiHeaderPage">
      <div class="clearfix uiHeaderTop">
        <a href="sns/sns!getFriendsList.jhtml" role="button"
          class="uiHeaderActions rfloat uiButton"> <span
          class="uiButtonText">管理朋友列表</span> </a>
        <div>
          <h2 class="uiHeaderTitle">
            <i class="uiHeaderImage img sp_7gl7wd sx_0b0f8c"></i>朋友
          </h2>
        </div>
      </div>
    </div>
    <div class="clearfix findfriends" id="content_inner">
      <div class="new_ff" id="importer_frame">
        <div id="main_ff_container">
          <div id="new_ff">
            <div class="uiHeader uiHeaderTopAndBottomBorder uiHeaderSection">
              <div class="clearfix uiHeaderTop">
                <div>
                  <h3 class="uiHeaderTitle">
                    将个人联系人加为朋友
                  </h3>
                </div>
              </div>
            </div>
            <div class="mvs mls uiP fsm">
              选择你与朋友的通讯方式。
              <a rel="dialog" ajaxify="/contact_importer/ajax/disclaimer.php"
                href="http://www.facebook.com/ajax/home/generic.php?sidecol=true&amp;path=%2F&amp;sk=ff&amp;key=ff&amp;endpoint=%2Fajax%2Fhome%2Fgeneric.php&amp;how-it-works=1">了解如何使用</a>
              或
              <a href="/invite_history.php">管理已导入的联系人</a>。
            </div>
            <div class="uiStepList pbs">
              <ol>
                <li class="uiStep uiStepFirst uiStepSelected">
                  <div class="part back"></div>
                  <div class="part middle">
                    <div class="content">
                      <div class="title fsl fwb fcb">
                        步骤 1
                      </div>
                      <span class="description">搜索朋友</span>
                    </div>
                  </div>
                  <div class="part point"></div>
                </li>
                <li class="uiStep">
                  <div class="part back"></div>
                  <div class="part middle">
                    <div class="content">
                      <div class="title fsl fwb fcb">
                        步骤 2
                      </div>
                      <span class="description">添加朋友</span>
                    </div>
                  </div>
                  <div class="part point"></div>
                </li>
                <li id="ci_steplist_3" class="uiStep uiStepLast">
                  <div class="part back"></div>
                  <div class="part middle">
                    <div class="content">
                      <div class="title fsl fwb fcb">
                        步骤 3
                      </div>
                      <span class="description">邀请朋友</span>
                    </div>
                  </div>
                  <div class="part point"></div>
                </li>
              </ol>
            </div>
            <div id="ci_module_list" class="mbl">
              <ul id="ci_modules_visible" class="uiList">
                <li id="ua7fzy_2"
                  class="pvs ci_module uiListItem uiListMedium uiListVerticalItemBorder expanded">
                  <div
                    onclick="JSCC.get(&#39;j4eca1bb8cf8e935727335251&#39;).handleClick(&quot;ua7fzy_2&quot;); return false"
                    class="UIImageBlock clearfix">
                    <i
                      class="UIImageBlock_Image UIImageBlock_MED_Image img sp_apfmrz sx_bc34d6"></i>
                    <a href="#" class="expand_link UIImageBlock_Ext">搜寻朋友</a>
                    <div
                      class="ci_module_header UIImageBlock_Content UIImageBlock_MED_Content fwb">
                      Windows Live Hotmail
                    </div>
                  </div>
                  <div class="ci_module_content">
                    <div class="contact_importer_widget ci_webmail">
                      <div class="api" id="ua7fzy_11_ci_webmail">
                        <div class="clearfix">
                         <s:form action="/sns/sns!getContactsFromAddressBook.jhtml">
                            <table class="uiInfoTable noBorder">
                              <tbody>
                                <tr class="dataRow">
                                  <th class="label">
                                    <label for="ua7fzy_11_ci_login">你的电子邮件：</label>
                                  </th>
                                  <td class="data">
                                    <s:textfield name="emailAddress" cssClass="inputtext ci_login" />
                                  </td>
                                </tr>
                                <tr class="ci_password_row dataRow">
                                  <th class="label">
                                    <label for="ua7fzy_11_ci_password">电子邮箱密码：</label>
                                  </th>
                                  <td class="data">
                                    <s:password name="emailPass" cssClass="inputtext ci_login" />
                                  </td>
                                </tr>
                                <tr>
                                  <th class="label"></th>
                                  <td class="data">
                                    <div>
                                      <label for="ua7fzy_12" class="uiButton uiButtonConfirm">
                                        <input type="submit" id="ua7fzy_12" value="搜索朋友" />
                                      </label>
                                      <img height="11" width="16" alt=""
                                        src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif"
                                        class="mts mls uiLoadingIndicatorAsync img" />
                                    </div>
                                  </td>
                                </tr>
                                <tr>
                                  <th class="label"></th>
                                  <td class="data">
                                    <div class="UIImageBlock clearfix disclaimer">
                                      <i class="UIImageBlock_Image UIImageBlock_ICON_Image img sp_aprvt7 sx_bd5265">
                                        <u>privacy_lock</u>
                                      </i>
                                      <span class="UIImageBlock_Content UIImageBlock_ICON_Content fcg">
                                             知友不会储存你的密码。
                                      </span>
                                    </div>
                                  </td>
                                </tr>
                                <tr>
                                  <th class="label"></th>
                                  <td class="data">
                                    <div class="unsupported_email">
                                      <span class="fwb">我们暂时还不能导入这个电邮地址的联系人名单。</span>
                                      <div class="mvs">
                                        You may try one of our
                                        <a rel="dialog"
                                          href="/contact_importer/ajax/supported_domains.php">支持的电邮地址</a>
                                        . 此外，如果你能上传 CSV 文件或使用 Outlook，可以试试我们的
                                        <a href="/find-friends/?expand=upload">文件导入器</a>。
                                      </div>
                                    </div>
                                  </td>
                                </tr>
                              </tbody>
                            </table>
                           </s:form>  
                        </div>
                      </div>
                    </div>
                  </div>
                </li>

                <li id="ua7fzy_6" class="pvs ci_module uiListItem uiListMedium uiListVerticalItemBorder">
                  <div onclick="return false" class="UIImageBlock clearfix">
                    <i class="UIImageBlock_Image UIImageBlock_MED_Image img sp_apfmrz sx_da3c35"></i>
                    <a href="#" class="expand_link UIImageBlock_Ext">搜寻朋友</a>
                    <div class="ci_module_header UIImageBlock_Content UIImageBlock_MED_Content fwb">
                      Windows Live Messenger
                    </div>
                  </div>
                  <div class="ci_module_content hidden_elem">
                    <div class="contact_importer_widget ci_webmail">
                      <div class="valid" id="ua7fzy_19_ci_webmail">
                        <div class="clearfix">
                          <form id="ua7fzy_19_ci_form" name="ua7fzy_19_ci_form" method="post" action="" class="ci_form">
                            <table class="uiInfoTable noBorder">
                              <tbody>
                                <tr class="dataRow">
                                  <th class="label">
                                    <label for="ua7fzy_19_ci_login">你的电子邮件：</label>
                                  </th>
                                  <td class="data">
                                    <input type="text" id="ua7fzy_19_ci_login" name="login_str" value="mk-k@163.com" class="inputtext ci_login" />
                                  </td>
                                </tr>
                                <tr class="ci_password_row dataRow">
                                  <th class="label">
                                    <label for="ua7fzy_19_ci_password">电子邮箱密码：</label>
                                  </th>
                                  <td class="data">
                                    <input type="password" id="ua7fzy_19_ci_password" name="password" class="inputtext ci_password" />
                                  </td>
                                </tr>
                                <tr>
                                  <th class="label"></th>
                                  <td class="data">
                                    <span> 你最近从 NetEase 导入了联系人。 <a href="/find-friends/result.php?import_id=2685010491339&amp;ref=findfriends">查看结果</a>
                                    </span>
                                  </td>
                                </tr>
                                <tr>
                                  <th class="label"></th>
                                  <td class="data">
                                    <div>
                                      <label for="ua7fzy_20" class="uiButton uiButtonConfirm">
                                        <input type="submit" id="ua7fzy_20" onclick="" value="搜索朋友" />
                                      </label>
                                      <img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="mts mls uiLoadingIndicatorAsync img" />
                                    </div>
                                  </td>
                                </tr>
                                <tr>
                                  <th class="label"></th>
                                  <td class="data">
                                    <div class="UIImageBlock clearfix disclaimer">
                                      <i class="UIImageBlock_Image UIImageBlock_ICON_Image img sp_aprvt7 sx_bd5265">
                                        <u>privacy_lock</u>
                                      </i>
                                      <span class="UIImageBlock_Content UIImageBlock_ICON_Content fcg">
                                            知友不会储存你的密码。
                                      </span>
                                    </div>
                                  </td>
                                </tr>
                                <tr>
                                  <th class="label"></th>
                                  <td class="data">
                                    <div class="unsupported_email">
                                      <span class="fwb">我们暂时还不能导入这个电邮地址的联系人名单。</span>
                                      <div class="mvs">
                                        You may try one of our
                                        <a rel="dialog" href="/contact_importer/ajax/supported_domains.php">支持的电邮地址</a>
                                        . 此外，如果你能上传 CSV 文件或使用 Outlook，可以试试我们的
                                        <a href="/find-friends/?expand=upload">文件导入器</a>。
                                      </div>
                                    </div>
                                  </td>
                                </tr>
                              </tbody>
                            </table>
                          </form>
                        </div>
                      </div>
                    </div>
                  </div>
                </li>
                <li id="ua7fzy_7"
                  class="pvs ci_module uiListItem uiListMedium uiListVerticalItemBorder">
                  <div onclick="return false" class="UIImageBlock clearfix">
                    <i class="UIImageBlock_Image UIImageBlock_MED_Image img sp_apfmrz sx_64e9e0"></i>
                    <a href="#" class="expand_link UIImageBlock_Ext">搜寻朋友</a>
                    <div class="ci_module_header UIImageBlock_Content UIImageBlock_MED_Content fwb">
                      gmail
                    </div>
                  </div>
                  <div class="ci_module_content hidden_elem">
                    <div class="contact_importer_widget ci_webmail">
                      <div class="valid" id="ua7fzy_21_ci_webmail">
                        <div class="clearfix">
                          <form
                            onsubmit="return function(event){return wait_for_load(this, event, function() {JSCC.get('j4eca1bb8cf8e935727335259').onSubmit(); return false;});}.call(this,event)!==false &amp;&amp; Event.__inlineSubmit(this,event)"
                            id="ua7fzy_21_ci_form" name="ua7fzy_21_ci_form"
                            method="post"
                            action="https://www.facebook.com/find-friends/index.php"
                            class="ci_form">
                            <input type="hidden"
                              value="6e216452824f44ec542d34fca1ae8f75"
                              name="post_form_id" autocomplete="off" />
                            <input type="hidden" autocomplete="off" value="AQAlLjK8"
                              name="fb_dtsg" />
                            <input type="hidden" value="2" name="importer_action"
                              autocomplete="off" />
                            <input type="hidden" value="2" name="flow"
                              autocomplete="off" />
                            <input type="hidden" value="1" name="type"
                              autocomplete="off" />
                            <input type="hidden" value="" name="callback_element_id"
                              autocomplete="off" />
                            <input type="hidden" value='{"referer":"9"}'
                              name="tracked_params" autocomplete="off" />
                            <input type="hidden" value="1" name="jsonp"
                              autocomplete="off" />
                            <table class="uiInfoTable noBorder">
                              <tbody>
                                <tr class="dataRow">
                                  <th class="label">
                                    <label for="ua7fzy_21_ci_login">
                                      你的电子邮件：
                                    </label>
                                  </th>
                                  <td class="data">
                                    <input type="text" autocomplete="off"
                                      id="ua7fzy_21_ci_login" name="login_str"
                                      value="mk-k@163.com" class="inputtext ci_login" />
                                  </td>
                                </tr>
                                <tr class="ci_password_row dataRow">
                                  <th class="label">
                                    <label for="ua7fzy_21_ci_password">
                                      电子邮箱密码：
                                    </label>
                                  </th>
                                  <td class="data">
                                    <input type="password" autocomplete="off"
                                      id="ua7fzy_21_ci_password" name="password" value=""
                                      class="inputtext ci_password" />
                                  </td>
                                </tr>
                                <tr>
                                  <th class="label"></th>
                                  <td class="data">
                                    <span> 你最近从 NetEase 导入了联系人。 <a
                                      href="/find-friends/result.php?import_id=2685010491339&amp;ref=findfriends">查看结果</a>
                                    </span>
                                  </td>
                                </tr>
                                <tr>
                                  <th class="label"></th>
                                  <td class="data">
                                    <div>
                                      <label for="ua7fzy_22"
                                        class="uiButton uiButtonConfirm">
                                        <input type="submit" id="ua7fzy_22" onclick=""
                                          value="搜索朋友" />
                                      </label>
                                      <img height="11" width="16" alt=""
                                        src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif"
                                        class="mts mls uiLoadingIndicatorAsync img" />
                                    </div>
                                  </td>
                                </tr>
                                <tr>
                                  <th class="label"></th>
                                  <td class="data">
                                    <div class="UIImageBlock clearfix disclaimer">
                                      <i
                                        class="UIImageBlock_Image UIImageBlock_ICON_Image img sp_aprvt7 sx_bd5265">
                                        <u>privacy_lock</u> </i>
                                      <span
                                        class="UIImageBlock_Content UIImageBlock_ICON_Content fcg">Facebook
                                        不会储存你的密码。</span>
                                    </div>
                                  </td>
                                </tr>
                                <tr>
                                  <th class="label"></th>
                                  <td class="data">
                                    <div class="unsupported_email">
                                      <span class="fwb">我们暂时还不能导入这个电邮地址的联系人名单。</span>
                                      <div class="mvs">
                                        You may try one of our
                                        <a rel="dialog"
                                          href="/contact_importer/ajax/supported_domains.php">支持的电邮地址</a>
                                        . 此外，如果你能上传 CSV 文件或使用 Outlook，可以试试我们的
                                        <a href="/find-friends/?expand=upload">文件导入器</a>。
                                      </div>
                                    </div>
                                  </td>
                                </tr>
                              </tbody>
                            </table>
                          </form>
                        </div>
                      </div>
                    </div>
                  </div>
                </li>
                <li id="ua7fzy_7" class="pvs ci_module uiListItem uiListMedium uiListVerticalItemBorder">
                  <div onclick="return false" class="UIImageBlock clearfix">
                    <i class="UIImageBlock_Image UIImageBlock_MED_Image img sp_apfmrz sx_64e9e0"></i>
                    <a href="#" class="expand_link UIImageBlock_Ext">搜寻朋友</a>
                    <div class="ci_module_header UIImageBlock_Content UIImageBlock_MED_Content fwb">
                      163
                    </div>
                  </div>
                  <div class="ci_module_content hidden_elem">
                    <div class="contact_importer_widget ci_webmail">
                      <div class="valid" id="ua7fzy_21_ci_webmail">
                        <div class="clearfix">
                          <form
                            onsubmit="return function(event){return wait_for_load(this, event, function() {JSCC.get('j4eca1bb8cf8e935727335259').onSubmit(); return false;});}.call(this,event)!==false &amp;&amp; Event.__inlineSubmit(this,event)"
                            id="ua7fzy_21_ci_form" name="ua7fzy_21_ci_form"
                            method="post"
                            action="https://www.facebook.com/find-friends/index.php"
                            class="ci_form">
                            <table class="uiInfoTable noBorder">
                              <tbody>
                                <tr class="dataRow">
                                  <th class="label">
                                    <label for="ua7fzy_21_ci_login">
                                      你的电子邮件：
                                    </label>
                                  </th>
                                  <td class="data">
                                    <input type="text" autocomplete="off"
                                      id="ua7fzy_21_ci_login" name="login_str"
                                      value="mk-k@163.com" class="inputtext ci_login" />
                                  </td>
                                </tr>
                                <tr class="ci_password_row dataRow">
                                  <th class="label">
                                    <label for="ua7fzy_21_ci_password">
                                      电子邮箱密码：
                                    </label>
                                  </th>
                                  <td class="data">
                                    <input type="password" autocomplete="off"
                                      id="ua7fzy_21_ci_password" name="password" value=""
                                      class="inputtext ci_password" />
                                  </td>
                                </tr>
                                <tr>
                                  <th class="label"></th>
                                  <td class="data">
                                    <span> 你最近从 NetEase 导入了联系人。 <a
                                      href="/find-friends/result.php?import_id=2685010491339&amp;ref=findfriends">查看结果</a>
                                    </span>
                                  </td>
                                </tr>
                                <tr>
                                  <th class="label"></th>
                                  <td class="data">
                                    <div>
                                      <label for="ua7fzy_22"
                                        class="uiButton uiButtonConfirm">
                                        <input type="submit" id="ua7fzy_22" onclick=""
                                          value="搜索朋友" />
                                      </label>
                                      <img height="11" width="16" alt=""
                                        src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif"
                                        class="mts mls uiLoadingIndicatorAsync img" />
                                    </div>
                                  </td>
                                </tr>
                                <tr>
                                  <th class="label"></th>
                                  <td class="data">
                                    <div class="UIImageBlock clearfix disclaimer">
                                      <i
                                        class="UIImageBlock_Image UIImageBlock_ICON_Image img sp_aprvt7 sx_bd5265">
                                        <u>privacy_lock</u> </i>
                                      <span
                                        class="UIImageBlock_Content UIImageBlock_ICON_Content fcg">Facebook
                                        不会储存你的密码。</span>
                                    </div>
                                  </td>
                                </tr>
                                <tr>
                                  <th class="label"></th>
                                  <td class="data">
                                    <div class="unsupported_email">
                                      <span class="fwb">我们暂时还不能导入这个电邮地址的联系人名单。</span>
                                      <div class="mvs">
                                        You may try one of our
                                        <a rel="dialog"
                                          href="/contact_importer/ajax/supported_domains.php">支持的电邮地址</a>
                                        . 此外，如果你能上传 CSV 文件或使用 Outlook，可以试试我们的
                                        <a href="/find-friends/?expand=upload">文件导入器</a>。
                                      </div>
                                    </div>
                                  </td>
                                </tr>
                              </tbody>
                            </table>
                          </form>
                        </div>
                      </div>
                    </div>
                  </div>
                </li>
                <li id="ua7fzy_7"
                  class="pvs ci_module uiListItem uiListMedium uiListVerticalItemBorder">
                  <div
                    onclick="JSCC.get(&#39;j4eca1bb8cf8e935727335251&#39;).handleClick(&quot;ua7fzy_7&quot;); return false"
                    class="UIImageBlock clearfix">
                    <i
                      class="UIImageBlock_Image UIImageBlock_MED_Image img sp_apfmrz sx_64e9e0"></i>
                    <a href="#" class="expand_link UIImageBlock_Ext">搜寻朋友</a>
                    <div
                      class="ci_module_header UIImageBlock_Content UIImageBlock_MED_Content fwb">
                      sina
                    </div>
                  </div>
                  <div class="ci_module_content hidden_elem">
                    <div class="contact_importer_widget ci_webmail">
                      <div class="valid" id="ua7fzy_21_ci_webmail">
                        <div class="clearfix">
                          <form
                            onsubmit="return function(event){return wait_for_load(this, event, function() {JSCC.get('j4eca1bb8cf8e935727335259').onSubmit(); return false;});}.call(this,event)!==false &amp;&amp; Event.__inlineSubmit(this,event)"
                            id="ua7fzy_21_ci_form" name="ua7fzy_21_ci_form"
                            method="post"
                            action="https://www.facebook.com/find-friends/index.php"
                            class="ci_form">
                            <input type="hidden"
                              value="6e216452824f44ec542d34fca1ae8f75"
                              name="post_form_id" autocomplete="off" />
                            <input type="hidden" autocomplete="off" value="AQAlLjK8"
                              name="fb_dtsg" />
                            <input type="hidden" value="2" name="importer_action"
                              autocomplete="off" />
                            <input type="hidden" value="2" name="flow"
                              autocomplete="off" />
                            <input type="hidden" value="1" name="type"
                              autocomplete="off" />
                            <input type="hidden" value="" name="callback_element_id"
                              autocomplete="off" />
                            <input type="hidden" value='{"referer":"9"}'
                              name="tracked_params" autocomplete="off" />
                            <input type="hidden" value="1" name="jsonp"
                              autocomplete="off" />
                            <table class="uiInfoTable noBorder">
                              <tbody>
                                <tr class="dataRow">
                                  <th class="label">
                                    <label for="ua7fzy_21_ci_login">
                                      你的电子邮件：
                                    </label>
                                  </th>
                                  <td class="data">
                                    <input type="text" autocomplete="off"
                                      id="ua7fzy_21_ci_login" name="login_str"
                                      value="mk-k@163.com" class="inputtext ci_login" />
                                  </td>
                                </tr>
                                <tr class="ci_password_row dataRow">
                                  <th class="label">
                                    <label for="ua7fzy_21_ci_password">
                                      电子邮箱密码：
                                    </label>
                                  </th>
                                  <td class="data">
                                    <input type="password" autocomplete="off"
                                      id="ua7fzy_21_ci_password" name="password" value=""
                                      class="inputtext ci_password" />
                                  </td>
                                </tr>
                                <tr>
                                  <th class="label"></th>
                                  <td class="data">
                                    <span> 你最近从 NetEase 导入了联系人。 <a
                                      href="/find-friends/result.php?import_id=2685010491339&amp;ref=findfriends">查看结果</a>
                                    </span>
                                  </td>
                                </tr>
                                <tr>
                                  <th class="label"></th>
                                  <td class="data">
                                    <div>
                                      <label for="ua7fzy_22"
                                        class="uiButton uiButtonConfirm">
                                        <input type="submit" id="ua7fzy_22" onclick=""
                                          value="搜索朋友" />
                                      </label>
                                      <img height="11" width="16" alt=""
                                        src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif"
                                        class="mts mls uiLoadingIndicatorAsync img" />
                                    </div>
                                  </td>
                                </tr>
                                <tr>
                                  <th class="label"></th>
                                  <td class="data">
                                    <div class="UIImageBlock clearfix disclaimer">
                                      <i
                                        class="UIImageBlock_Image UIImageBlock_ICON_Image img sp_aprvt7 sx_bd5265">
                                        <u>privacy_lock</u> </i>
                                      <span
                                        class="UIImageBlock_Content UIImageBlock_ICON_Content fcg">Facebook
                                        不会储存你的密码。</span>
                                    </div>
                                  </td>
                                </tr>
                                <tr>
                                  <th class="label"></th>
                                  <td class="data">
                                    <div class="unsupported_email">
                                      <span class="fwb">我们暂时还不能导入这个电邮地址的联系人名单。</span>
                                      <div class="mvs">
                                        You may try one of our
                                        <a rel="dialog"
                                          href="/contact_importer/ajax/supported_domains.php">支持的电邮地址</a>
                                        . 此外，如果你能上传 CSV 文件或使用 Outlook，可以试试我们的
                                        <a href="/find-friends/?expand=upload">文件导入器</a>。
                                      </div>
                                    </div>
                                  </td>
                                </tr>
                              </tbody>
                            </table>
                          </form>
                        </div>
                      </div>
                    </div>
                  </div>
                </li>
                <li id="ua7fzy_7"
                  class="pvs ci_module uiListItem uiListMedium uiListVerticalItemBorder">
                  <div
                    onclick="JSCC.get(&#39;j4eca1bb8cf8e935727335251&#39;).handleClick(&quot;ua7fzy_7&quot;); return false"
                    class="UIImageBlock clearfix">
                    <i
                      class="UIImageBlock_Image UIImageBlock_MED_Image img sp_apfmrz sx_64e9e0"></i>
                    <a href="#" class="expand_link UIImageBlock_Ext">搜寻朋友</a>
                    <div
                      class="ci_module_header UIImageBlock_Content UIImageBlock_MED_Content fwb">
                      其他邮件服务器
                    </div>
                  </div>
                  <div class="ci_module_content hidden_elem">
                    <div class="contact_importer_widget ci_webmail">
                      <div class="valid" id="ua7fzy_21_ci_webmail">
                        <div class="clearfix">
                          <form
                            onsubmit="return function(event){return wait_for_load(this, event, function() {JSCC.get('j4eca1bb8cf8e935727335259').onSubmit(); return false;});}.call(this,event)!==false &amp;&amp; Event.__inlineSubmit(this,event)"
                            id="ua7fzy_21_ci_form" name="ua7fzy_21_ci_form"
                            method="post"
                            action="https://www.facebook.com/find-friends/index.php"
                            class="ci_form">
                            <input type="hidden"
                              value="6e216452824f44ec542d34fca1ae8f75"
                              name="post_form_id" autocomplete="off" />
                            <input type="hidden" autocomplete="off" value="AQAlLjK8"
                              name="fb_dtsg" />
                            <input type="hidden" value="2" name="importer_action"
                              autocomplete="off" />
                            <input type="hidden" value="2" name="flow"
                              autocomplete="off" />
                            <input type="hidden" value="1" name="type"
                              autocomplete="off" />
                            <input type="hidden" value="" name="callback_element_id"
                              autocomplete="off" />
                            <input type="hidden" value='{"referer":"9"}'
                              name="tracked_params" autocomplete="off" />
                            <input type="hidden" value="1" name="jsonp"
                              autocomplete="off" />
                            <table class="uiInfoTable noBorder">
                              <tbody>
                                <tr class="dataRow">
                                  <th class="label">
                                    <label for="ua7fzy_21_ci_login">
                                      你的电子邮件：
                                    </label>
                                  </th>
                                  <td class="data">
                                    <input type="text" autocomplete="off"
                                      id="ua7fzy_21_ci_login" name="login_str"
                                      value="mk-k@163.com" class="inputtext ci_login" />
                                  </td>
                                </tr>
                                <tr class="ci_password_row dataRow">
                                  <th class="label">
                                    <label for="ua7fzy_21_ci_password">
                                      电子邮箱密码：
                                    </label>
                                  </th>
                                  <td class="data">
                                    <input type="password" autocomplete="off"
                                      id="ua7fzy_21_ci_password" name="password" value=""
                                      class="inputtext ci_password" />
                                  </td>
                                </tr>
                                <tr>
                                  <th class="label"></th>
                                  <td class="data">
                                    <span> 你最近从 NetEase 导入了联系人。 <a
                                      href="/find-friends/result.php?import_id=2685010491339&amp;ref=findfriends">查看结果</a>
                                    </span>
                                  </td>
                                </tr>
                                <tr>
                                  <th class="label"></th>
                                  <td class="data">
                                    <div>
                                      <label for="ua7fzy_22"
                                        class="uiButton uiButtonConfirm">
                                        <input type="submit" id="ua7fzy_22" onclick=""
                                          value="搜索朋友" />
                                      </label>
                                      <img height="11" width="16" alt=""
                                        src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif"
                                        class="mts mls uiLoadingIndicatorAsync img" />
                                    </div>
                                  </td>
                                </tr>
                                <tr>
                                  <th class="label"></th>
                                  <td class="data">
                                    <div class="UIImageBlock clearfix disclaimer">
                                      <i
                                        class="UIImageBlock_Image UIImageBlock_ICON_Image img sp_aprvt7 sx_bd5265">
                                        <u>privacy_lock</u> </i>
                                      <span
                                        class="UIImageBlock_Content UIImageBlock_ICON_Content fcg">Facebook
                                        不会储存你的密码。</span>
                                    </div>
                                  </td>
                                </tr>
                                <tr>
                                  <th class="label"></th>
                                  <td class="data">
                                    <div class="unsupported_email">
                                      <span class="fwb">我们暂时还不能导入这个电邮地址的联系人名单。</span>
                                      <div class="mvs">
                                        You may try one of our
                                        <a rel="dialog"
                                          href="/contact_importer/ajax/supported_domains.php">支持的电邮地址</a>
                                        . 此外，如果你能上传 CSV 文件或使用 Outlook，可以试试我们的
                                        <a href="/find-friends/?expand=upload">文件导入器</a>。
                                      </div>
                                    </div>
                                  </td>
                                </tr>
                              </tbody>
                            </table>
                          </form>
                        </div>
                      </div>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>