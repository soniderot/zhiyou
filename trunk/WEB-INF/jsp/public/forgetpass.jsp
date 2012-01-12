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
                <h2 class="uiHeaderTitle">知友</h2>
              </div>
            </div>
          </div>
          <div class="phl ptm uiInterstitialContent">
            <div class="login_form_container">
              <s:form action="/usr/forgetPass.jhtml" method="post" id="login_form">
                <div id="error" class="UIMessageBox UIMessageBoxError">
                  <h2 class="main_message" id="standard_error">请输入你的注册邮箱</h2>
                 
                </div>
                <div id="loginform" style="">
                  
                  
                  <div class="form_row clearfix ">
                    <label for="email" id="label_email" class="login_form_label">邮箱地址：</label>
                    <s:textfield name="email" cssClass="inputtext"  />
                  </div>
                 
                  
                  <input type="hidden" autocomplete="off" id="default_persistent" name="default_persistent" value="1" />
                  <div id="buttons" class="form_row clearfix">
                    <label class="login_form_label"></label>
                    <div id="login_button_inline">
                      <label class="uiButton uiButtonConfirm uiButtonLarge" for="uvjo9s_1">
                        <input value="发送密码" name="login" onclick="" type="submit" id="uvjo9s_1" />
                      </label>
                    </div>
                    <s:if test="errorFlag==true">
                    <div id="register_link">
                      <font color=red><strong>邮箱不存在</strong></font>
                    </div>
                    </s:if>
                    <s:else>
                    	 <s:if test="email!=null">
                    	 <div id="register_link">
                      <font color=red><strong>密码已经发送到邮箱中</strong></font>
                    </div>
                    	</s:if>
                 		</s:else>
                  </div>
                
                  
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
