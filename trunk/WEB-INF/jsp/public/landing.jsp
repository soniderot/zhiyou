<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="textml;charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html id="facebook">
<head>
  <%@ include file="/WEB-INF/jsp/common/css.jsp"%>
</head>

<body class="fbIndex UIPage_LoggedOut ff3 win Locale_zh_CN">
  <div id="FB_HiddenContainer" style="position:absolute; top:-10000px; width:0px; height:0px;"></div>
  <div id="blueBarHolder" class="loggedOut">
    <div id="blueBar">
      <div class="loggedout_menubar_container">
        <div class="clearfix loggedout_menubar">
          <a class="lfloat" href="/" title="转到Facebook首页"><img class="fb_logo img" src="#" alt="Facebook 商标" width="170" height="36" /></a>
          <div class="rfloat">
            <div class="menu_login_container">
              <form method="POST" action="usr/login.jhtml" id="login_form">
                <input type="hidden" name="lsd" value="Y0F8N" autocomplete="off" />
                <input type="hidden" autocomplete="off" id="locale" name="locale" value="zh_CN" />
                <table cellspacing="0">
                  <tr>
                    <td class="html7magic">
                      <label for="email">电子邮件</label>
                    </td>
                    <td class="html7magic">
                      <label for="pass">密码</label>
                    </td>
                  </tr>
                  <tr>
                    <td><input type="text" class="inputtext" name="email" id="email" value="" tabindex="1" /></td>
                    <td><input type="password" class="inputtext" name="password" id="pass" tabindex="2" /></td>
                    <td><label class="uiButton uiButtonConfirm" for="ubyzxj_3"><input value="登录" tabindex="4" type="submit" id="ubyzxj_3" /></label></td></tr>
                  <tr>
                    <td class="login_form_label_field">
                      <div class="uiInputLabel" id="persist_label">
                        <input id="persist_box" type="checkbox" name="persistent" value="1" tabindex="3" class="uiInputLabelCheckbox" />
                        <label for="persist_box">保持在登录状态</label>
                      </div>
                      <input type="hidden" name="default_persistent" value="0" />
                    </td>
                    <td class="login_form_label_field">
                      <a href="#" rel="nofollow">忘记密码了？</a>
                    </td>
                  </tr>
                </table>
                <input type="hidden" autocomplete="off" id="lsd" name="lsd" value="Y0F8N" />
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div id="globalContainer">
    <div id="content" class="fb_content clearfix">
      <div>
        <div class="gradient">
          <div class="gradientContent">
            <div class="clearfix fbIndexFeaturedRegistration">
              <div class="feature lfloat">
                <div class="plm fbIndexMap">
                  <div class="plm title fsl fwb fcb">美好生活，知友共享。</div>
                  <div class="mtl map"></div>
                </div>
              </div>
              <div class="signupForm rfloat">
                <div class="mbm phm headerTextContainer">
                  <div class="mbs mainTitle fsl fwb fcb">注册</div>
                  <div class="mbm subtitle fsm fwn fcg">完全并永久免费。</div>
                </div>
                <div id="registration_container">
                  <div data-referrer="simple_registration_form">
                    <noscript>
                      <div id="no_js_box">
                        <h2>你的浏览器禁用了JavaScript。</h2>
                        <p>要注册知友，请在你的浏览器中启用JavaScript，或升级为支持JavaScript的浏览器。</p>
                      </div>
                    </noscript>
                    <div id="simple_registration_container" class="simple_registration_container">
                      <div id="reg_box">
                        <s:form action="register" namespace="/usr" onsubmit="return validateSignUp()">
                          <div id="reg_form_box" class="large_form">
                             <table class="uiGrid editor" cellspacing="0" cellpadding="1">
                              <tbody>
                                <tr>
                                  <td class="label"><label for="firstname">用户名:</label></td>
                                  <td>
                                    <div class="field_container">
                                      <s:textfield name="username" cssClass="inputtext DOMControl_placeholder" placeholder="请您输入用户名" tipstype="error" />
                                      <s:fielderror><s:param>username</s:param></s:fielderror>
                                    </div>
                                  </td>
                                </tr>
                                <tr>
                                  <td class="label">
                                    <label for="reg_email__">电子邮件:</label>
                                  </td>
                                  <td>
                                    <div class="field_container">
                                      <s:textfield name="email" cssClass="inputtext DOMControl_placeholder" placeholder="请您输入电子邮件" tipstype="error" />
                                    </div>
                                  </td>
                                </tr>
                                
                                <tr>
                                  <td class="label">
                                    <label for="reg_passwd__">密码:</label>
                                  </td>
                                  <td>
                                    <div class="field_container">
                                      <s:password name="password" cssClass="inputtext" tipstype="error" />
                                    </div>
                                  </td>
                                </tr>
                                <tr>
                                  <td class="label">
                                    <label for="reg_passwd__">确认密码:</label>
                                  </td>
                                  <td>
                                    <div class="field_container">
                                      <s:password name="confirmpassword" cssClass="inputtext" tipstype="error" />
                                    </div>
                                  </td>
                                </tr>
                                <tr>
                                  <td class="label">性别:</td>
                                  <td>
                                    <div class="field_container">
                                      <s:select name="gender" list="#{'-1':'选择性别', '1':'男', '2':'女'}" tipstype="error"></s:select>
                                    </div>
                                  </td>
                                </tr>
                                <tr>
                                  <td class="label">生日:</td>
                                  <td>
                                    <div class="field_container">
                                      <s:select name="year" list="#request.years" listKey="key"  listValue="value" tipstype="error"></s:select>
                                      <s:select name="month" list="#request.months" listKey="key"  listValue="value" tipstype="error"></s:select>
                                      <s:select name="day" list="#request.days" listKey="key"  listValue="value" tipstype="error"></s:select>
                                    </div>
                                  </td>
                                </tr>
                              </tbody>
                            </table>
                            <div class="reg_btn clearfix">
                              <label class="uiButton uiButtonSpecial" for="ubyzxj_1">
                                <input value="注册"  type="submit" id="ubyzxj_1" />
                              </label>
                              <span id="async_status" class="async_status" style="display: none">
                                <img class="img" src="#" alt="" width="16" height="11" />
                              </span>
                            </div>
                          </div>
                        </s:form>        
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Footer Start-->
    <div id="pageFooter" data-referrer="page_footer">
      <div id="contentCurve"></div>
      <div class="clearfix" id="footerContainer">
        <div class="mrl lfloat" role="contentinfo">
          <div class="fsm fwn fcg">
            <span> 知友 ? 2011</span>
            · <a rel="dialog" href="/ajax/intl/language_dialog.php?uri=http%3A%2F%2Fwww.facebook.com%2F" title="更换语言">中文(简体)</a>
          </div>
        </div>
        <div class="navigation fsm fwn fcg" role="navigation">
          <a href="http://www.facebook.com/facebook" accesskey="8" title="阅读我们的博客，在资源中心里探索，同时寻找属于你的工作机会。">关于</a>
          · <a href="http://www.facebook.com/campaign/landing.php?placement=pf&amp;campaign_id=402047449186&amp;extra_1=auto" title="在 Facebook 上做广告。">做广告</a>
          · <a href="http://www.facebook.com/pages/create.php?ref_type=sitefooter" title="创建专页">创建专页</a>
          · <a href="http://developers.facebook.com/?ref=pf" title="在我们的平台上开发。">开发人员</a>
          · <a href="http://www.facebook.com/careers/?ref=pf" title="请把你的下一个工作机会瞄准我们这个最优秀的公司。">招聘</a>
          · <a href="http://www.facebook.com/privacy/explanation" title="了解 Facebook 和你的隐私权。">隐私政策</a>
          · <a href="http://www.facebook.com/terms.php?ref=pf" accesskey="9" title="查看我们的服务条款。">条款</a>
          · <a href="http://www.facebook.com/help/?ref=pf" accesskey="0" title="访问我们的帮助中心。">帮助中心</a>
        </div>
      </div>
    </div>
    <!-- Footer End -->
  </div>

</body>
</html>