<%@page contentType="textml;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<div role="main" id="contentArea">
  <div class="uiHeader mhl uiHeaderPage">
    <div class="clearfix uiHeaderTop">
      <div class="uiHeaderActions rfloat">
        <a href="http://www.facebook.com/mkk158?ref=profile&amp;v=info" role="button" class="uiButton">
          <i class="mrs img sp_ah6icc sx_2efcc5"></i>
          <span class="uiButtonText">查看个人主页</span>
        </a>
        <a href="http://www.facebook.com/mkk158?viewas=100000686899395" role="button" class="uiButton">
          <span class="uiButtonText">以朋友身份查看…</span>
        </a>
      </div>
      <div>
        <h2 class="uiHeaderTitle">ま か<i class="mhs img sp_4fkm6u sx_e93a7e"></i>编辑个人主页</h2>
      </div>
    </div>
  </div>
  <div class="pal grayArea uiBoxGray noborder">
    <div id="editProfileForm">
      <s:form method="post" action="update" namespace="/usr">
        <input type="hidden" name="profileform.pageIndex" value="3" />
        <ul class="uiList">
          <li class="pbm fbEditProfileExperienceSection uiListItem uiListMedium uiListVerticalItemBorder">
            <div class="err_msg"/>
            <table class="uiInfoTable fbProfileEditExperiences noBorder">
              <tbody>
                <tr class="dataRow">
                  <th class="label">活动爱好：</th>
                  <td class="data">
                    <div id="add_1002">
                      <div id="u91etj_1" class="uiTypeahead uiClearableTypeahead photoTypeahead mbs addExperience fbHubsTypeahead">
                        <div class="wrap">
                          <div class="innerWrap">
                            <s:textfield name="profileform.hobby" title="你喜欢做些什么？" placeholder="你喜欢做些什么？" cssClass="inputtext textInput DOMControl_placeholder" />
                          </div>
                          <img class="photo img sp_dob1w7 sx_33eb13"/>
                        </div>
                        <div class="uiTypeaheadView hidden_elem"></div>
                      </div>
                    </div>
                  </td>
                </tr>
              </tbody>
            </table>
          </li>
          <li class="pvm fbEditProfileExperienceSection uiListItem uiListMedium uiListVerticalItemBorder">
            <table class="uiInfoTable noBorder">
              <tbody id="u91etj_5" class="mrl">
                <tr class="editLikesRow">
                  <th class="label">兴趣：</th>
                  <td class="data">
                    <div class="uiTokenizer fbHubsTokenizer fbHubsPhotoTokenizer">
                      <div id="u91etj_6" class="uiTypeahead uiClearableTypeahead photoTypeahead fbHubsTypeahead">
                        <div class="wrap">
                          <div class="innerWrap">
                            <s:textfield name="profileform.interest" title="你对什么感兴趣？" placeholder="你对什么感兴趣？" cssClass="inputtext textInput DOMControl_placeholder" />
                          </div>
                          <img class="photo img sp_c0827g sx_753c9e"/>
                        </div>
                        <div class="uiTypeaheadView hidden_elem"></div>
                      </div>
                      <div id="u91etj_7" class="tokenarea expanded clearfix hidden_elem"></div>
                      <input type="button" tabindex="-1" class="eventsInput"/>
                    </div>
                  </td>
                  <td class="rightCol"></td>
                </tr>
                <tr class="spacer">
                  <td colspan="3"><hr/></td>
                </tr>
              </tbody>
            </table>
            <div class="mtm fbMixedSaveButton stat_elem">
              <label for="u91etj_4" class="saveButton uiButton uiButtonConfirm">
                <input type="submit" id="u91etj_4" value="保存更改"/>
              </label>
              <img height="11" width="16" alt="" src="http://static.ak.fbcdn.net/rsrc.php/v1/yb/r/GsNJNwuI-UM.gif" class="mts mlm uiLoadingIndicatorAsync img"/>
              <span class="mhm inline_err_msg"></span>
            </div>
          </li>
        </ul>
      </s:form>
    </div>
  </div>
</div>