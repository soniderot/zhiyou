  <%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
          <div role="main" id="contentArea">
            <div data-referrer="pagelet_welcome" id="pagelet_welcome">
              <div class="uiHeader uiHeaderWithImage uiHeaderBottomBorder uiHeaderPage">
                <div class="clearfix uiHeaderTop">
                  <div class="uiHeaderActions rfloat"></div>
                  <div>
                    <h2 class="uiHeaderTitle">
                      <i class="uiHeaderImage img sp_enac13 sx_89179c"></i><s:property value="#session.user.username"/>，欢迎造访 知友，
                    </h2>
                  </div>
                </div>
              </div>
              <ul id="welcome_dashboard">
                <li class="clearfix step last">
                  <h3 class="step_indicator active_step">1</h3>
                  <div class="welcome_task welcomeTaskFriendFinder">
                    <h3><a href="/?sk=ff">查找你认识的人</a></h3>
                    <div class="welcome_description">通过姓名搜索或者寻找同学和同事。</div>
                    <div class="search_query">
                      <form onsubmit="return Event.__inlineSubmit(this,event)" id="findfriends_search" name="findfriends_search" action="/search/?ref=ffs" method="get">
                        <input type="text" required="true" value="输入姓名或电子邮件地址" name="q" id="q_ff" maxlength="256" placeholder="输入姓名或电子邮件地址" title="输入姓名或电子邮件地址" size="42" class="inputtext DOMControl_placeholder"/>
                        <input type="hidden" value="2048" name="o" id="o" autocomplete="off"/>
                        <label for="ffs_input" class="findfriends_submit">
                          <input type="submit" id="ffs_input"/>
                          <span class="findfriends_glass"></span>
                        </label>
                        <input type="hidden" value="ffs" name="init" id="init" autocomplete="off"/>
                      </form>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
          </div>