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
            <!--
            <div class="mvs mls uiP fsm">
              选择你与朋友的通讯方式。
              <a rel="dialog" ajaxify="/contact_importer/ajax/disclaimer.php"
                href="http://www.facebook.com/ajax/home/generic.php?sidecol=true&amp;path=%2F&amp;sk=ff&amp;key=ff&amp;endpoint=%2Fajax%2Fhome%2Fgeneric.php&amp;how-it-works=1">了解如何使用</a>
              或
              <a href="/invite_history.php">管理已导入的联系人</a>。
            </div>-->
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
                
                <!--
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
                --->
                
                <li id="ci_steplist_3" class="uiStep uiStepLast">
                  <div class="part back"></div>
                  <div class="part middle">
                    <div class="content">
                      <div class="title fsl fwb fcb">
                        步骤 2
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
                    <!--
                    <i
                      class="UIImageBlock_Image UIImageBlock_MED_Image img sp_apfmrz sx_bc34d6"></i>
                    --->
                    
                    <a href="#" class="expand_link UIImageBlock_Ext">搜寻朋友</a>
                    <!--
                    <div
                      class="ci_module_header UIImageBlock_Content UIImageBlock_MED_Content fwb">
                      <!--
                      Windows Live Hotmail
                    </div>-->
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
                    
                    <div class="ci_module_header UIImageBlock_Content UIImageBlock_MED_Content fwb">
                      Windows Live Messenger
                    </div>
                    
                  </div>
                  
                  
                  
                </li>
                <li id="ua7fzy_7"
                  class="pvs ci_module uiListItem uiListMedium uiListVerticalItemBorder">
                  <div  class="UIImageBlock clearfix">
                    <i class="UIImageBlock_Image UIImageBlock_MED_Image img sp_apfmrz sx_64e9e0"></i>
                   
                    <div class="ci_module_header UIImageBlock_Content UIImageBlock_MED_Content fwb">
                      gmail
                    </div>
                  </div>
                
                </li>
                <li id="ua7fzy_7" class="pvs ci_module uiListItem uiListMedium uiListVerticalItemBorder">
                  <div  class="UIImageBlock clearfix">
                    <i class="UIImageBlock_Image UIImageBlock_MED_Image img sp_apfmrz sx_64e9e0"></i>
                   
                    <div class="ci_module_header UIImageBlock_Content UIImageBlock_MED_Content fwb">
                      163
                    </div>
                  </div>
                  
                </li>
                <li id="ua7fzy_7"
                  class="pvs ci_module uiListItem uiListMedium uiListVerticalItemBorder">
                  <div
                    
                    class="UIImageBlock clearfix">
                    <i
                      class="UIImageBlock_Image UIImageBlock_MED_Image img sp_apfmrz sx_64e9e0"></i>
                   
                    <div
                      class="ci_module_header UIImageBlock_Content UIImageBlock_MED_Content fwb">
                      sina
                    </div>
                  </div>
                 
                </li>
                <li id="ua7fzy_7"
                  class="pvs ci_module uiListItem uiListMedium uiListVerticalItemBorder">
                  <div class="UIImageBlock clearfix">
                    <i
                      class="UIImageBlock_Image UIImageBlock_MED_Image img sp_apfmrz sx_64e9e0"></i>
                   
                    <div
                      class="ci_module_header UIImageBlock_Content UIImageBlock_MED_Content fwb">
                      YAHOO
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