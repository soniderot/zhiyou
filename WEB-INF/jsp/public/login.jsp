<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh" id="facebook" class="no_js">
<head>
  <%@ include file="/WEB-INF/jsp/common/css.jsp"%>
</head>
<body class="login_page UIPage_LoggedOut ff3 win Locale_zh_CN">
  <div id="FB_HiddenContainer" style="position:absolute; top:-10000px; width:0px; height:0px;"></div>
  <div id="blueBarHolder" class="loggedOut">
    <div id="blueBar">
      <div class="loggedout_menubar_container">
      	<!--
        <div class="clearfix loggedout_menubar">
          <a class="lfloat" href="/" title="转到首页"><img class="fb_logo img" src="https://s-static.ak.facebook.com/rsrc.php/v1/yp/r/kk8dc2UJYJ4.png" alt="Facebook 商标" width="170" height="36" /></a>
          <div class="rfloat"></div>
        </div>-->
      </div>
      <div class="signup_bar_container">
        <div class="signup_box clearfix">
          <a class="signup_btn uiButton uiButtonSpecial uiButtonLarge" role="button" href="/usr/landing.jhtml">
            <span class="uiButtonText">注册</span>
          </a>
          <span class="signup_box_content">
            <span>知友网帮助你与他人随时保持联系，随地分享生活。</span>
          </span>
        </div>
      </div>
    </div>
  </div>
  <div id="globalContainer">
    <div id="content" class="fb_content clearfix">
      <div class="UIFullPage_Container">
        <div class="mvl ptm uiInterstitial login_page_interstitial uiInterstitialLarge uiBoxWhite">
          <div class="uiHeader uiHeaderBottomBorder mhl mts uiHeaderPage interstitialHeader">
            <div class="clearfix uiHeaderTop">
              <div class="uiHeaderActions rfloat"></div>
              <div>
                <h2 class="uiHeaderTitle">知友 登录</h2>
              </div>
            </div>
          </div>
          <div class="phl ptm uiInterstitialContent">
            <div class="login_form_container">
              <s:form action="/usr/login.jhtml" method="post" id="login_form">
              <input type="hidden" name="token" value="${token}" />
                <input type="hidden" name="charset_test" value="&euro;,&acute;,€,′,水,Д,?" />
                <input type="hidden" name="lsd" value="_9Sn9" autocomplete="off" />
                <div id="error" class="UIMessageBox UIMessageBoxError">
                  <h2 class="main_message" id="standard_error">请重新输入你的密码</h2>
                  <p class="sub_message" id="standard_explanation">
                    <p>你输入的密码不正确。请再试一次（确保你的大写锁定是关闭的）。</p>
                    <p>忘记密码了？ <a href="/recover.php?email_or_phone=mk-k%40163.com">请输入一个新的密码。</a></p>
                  </p>
                </div>
                <div id="loginform" style="">
                  
                  
                  <div class="form_row clearfix ">
                    <label for="email" id="label_email" class="login_form_label">用户名：</label>
                    <s:textfield name="email" cssClass="inputtext"  />
                    
                  </div>
                  <div class="form_row clearfix ">
                    <label for="pass" id="label_pass" class="login_form_label">密码：</label>
                    <s:password name="password" cssClass="inputpassword"  />
                  </div>
                  <div class="persistent">
                    <div class="uiInputLabel" id="persist_label">
                      <input id="persist_box" type="checkbox" value="1" checked="1" name="persistent" class="uiInputLabelCheckbox" />
                      <label for="persist_box">保持在登录状态</label>
                    </div>
                  </div>
                  <input type="hidden" autocomplete="off" id="default_persistent" name="default_persistent" value="1" />
                  <div id="buttons" class="form_row clearfix">
                    <label class="login_form_label"></label>
                    <div id="login_button_inline">
                      <label class="uiButton uiButtonConfirm uiButtonLarge" for="uvjo9s_1">
                        <input value="登录" name="login" onclick="" type="submit" id="uvjo9s_1" />
                      </label>
                    </div>
                    <div id="register_link">
                      或者<strong><a href="/usr/landing.jhtml?token=${token}" target="_blank" rel="nofollow" id="reg_btn_link" tabindex="-1">注册</a></strong>
                    </div>
                  </div>
                  <p class="reset_password form_row">
                    <a href="http://www.facebook.com/recover.php?locale=zh_CN&amp;email_or_phone=mk-k%40163.com" target="" tabindex="-1">忘记密码了？</a>
                  </p>
                </div>
              </s:form>
            </div>
          </div>
        </div>
      </div>
    </div>
    <%@ include file="/WEB-INF/jsp/common/footer.jsp"%>
  </div>
</body>
</html>
