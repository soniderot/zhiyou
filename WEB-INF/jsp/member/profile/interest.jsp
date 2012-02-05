<%@page contentType="textml;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<div role="main" id="contentArea">
  <div class="uiHeader mhl uiHeaderPage">
    <div class="clearfix uiHeaderTop">
      <div class="uiHeaderActions rfloat">
      	<!---
        <a href="http://www.facebook.com/mkk158?ref=profile&amp;v=info" role="button" class="uiButton">
          <i class="mrs img sp_ah6icc sx_2efcc5"></i>
          <span class="uiButtonText">查看个人主页</span>
        </a>
        <a href="http://www.facebook.com/mkk158?viewas=100000686899395" role="button" class="uiButton">
          <span class="uiButtonText">以朋友身份查看…</span>
        </a>--->
      </div>
      <div>
        <h2 class="uiHeaderTitle"><s:property value="#session.user.username"/><i class="mhs img sp_4fkm6u sx_e93a7e"></i>编辑个人主页</h2>
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
                            <s:textfield name="newTag" title="你喜欢做些什么？" placeholder="你喜欢做些什么？" cssClass="inputtext textInput DOMControl_placeholder" />
                             <s:hidden name="profileform.hobby" />
                          </div>
                          <label for="u91etj_3" class="clear saveButton uiButton uiButtonConfirm" style="float:right;display:inline;position:absolute;top:5px;right:-70px;">
                          <input type="button" id="u91etj_3" value="添加标签" onclick="createTag()" />
                        </label>
                        </div>
                        
                        <div class="uiTypeaheadView hidden_elem"></div>
                      </div>
                    </div>
                    <ul id="uefgga_2" class="uiList fbProfileEditExperiences sortableExperienceList">
                      <li id="hub_2752612181339" class="experience sortableExperience uiListItem uiListLight uiListVerticalItemBorder editingExperience">
                        <form id="uefn29_1" action="#" method="post" class="pas editExperienceForm">
                          <div id="selectedTags" class="UIImageBlock clearfix pbs experienceTitle">
                          <c:forEach items="${selectedHobbies}" var="hobby" varStatus="status">
                          <span title="${hobby.tag}" class="removable uiToken" onclick="deleteTag(this, ${hobby.id})">
    	                   ${hobby.tag}<a href="javascript:void(0);" title="删除${hobby.tag}" class="remove uiCloseButton uiCloseButtonSmall"></a>
                          </span>
                          </c:forEach>
                          </div>
                          
                          <div class="editTableWrapper">
                            <table class="uiInfoTable mts noBorder">
                              <tbody>
                                <tr class="dataRow">
                                  <td>你可能感兴趣的标签：</td>
                                  <td colspan="4"><span style="float:right;padding-right"><a onclick="changeTag()">换一换</a></span></td>
                                </tr>
                                <c:set var="count">${fn:length(interests)}</c:set>
                                <c:forEach items="${interests}" var="interest" step="4" varStatus="status">
                                <tr>
                                  <td></td>
                                  <td>
                                    <c:if test="${count>status.index}">
                                      <span class="removable uiToken" onclick="addTag(${interests[status.index].id}, '${interests[status.index].tag}')">
                                        <b>+</b>${interests[status.index].tag}
                                      </span>
                                     </c:if>
                                  </td>
                                  <td>
                                    <c:if test="${count>status.index+1}">
                                      <span class="removable uiToken" onclick="addTag(${interests[status.index+1].id}, '${interests[status.index+1].tag}')">
                                        <b>+</b>${interests[status.index+1].tag}
                                      </span>
                                    </c:if>
                                  </td>
                                  <td>
                                    <c:if test="${count>status.index+2}">
                                      <span class="removable uiToken" onclick="addTag(${interests[status.index+2].id}, '${interests[status.index+2].tag}')">
                                        <b>+</b>${interests[status.index+2].tag}
                                      </span>
                                    </c:if>
                                  </td>
                                  <td>
                                    <c:if test="${count>status.index+3}">
                                      <span class="removable uiToken" onclick="addTag(${interests[status.index+3].id}, '${interests[status.index+3].tag}')">
                                        <b>+</b>${interests[status.index+3].tag}
                                      </span>
                                    </c:if>
                                  </td>
                                </tr>
                                </c:forEach>
                              </tbody>
                            </table>
                          </div>
                        </form>
                      </li>
                    </ul>
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
<script type="text/javascript">
  function addTag(id, tag) {
    var hobbies = $("input[name='profileform.hobby']").val();
    if (hobbies != null && hobbies != "") {
      var hobbyArr = hobbies.split(" ");
      if (hobbyArr.length > 8) {
        return false;
      }
      for (i = 0; i < hobbyArr.length; i++) {
        if (id == hobbyArr[i]) {
          return false;
        }
      }
      hobbies = hobbies + " " + id;
    } else {
      hobbies = id;
    }
    $("input[name='profileform.hobby']").val(hobbies);
    var oneTag = "<span title='" + tag +"' class='removable uiToken' onclick='deleteTag(this, " + id + ")'>";
    oneTag += tag + "<a href='javascript:void(0);' title='删除" + tag + "' class='remove uiCloseButton uiCloseButtonSmall'></a></span>";
    $("#selectedTags").append(oneTag);
  }
  
  function deleteTag(obj, id) {
    var hobbies = $("input[name='profileform.hobby']").val();
    var hobbyArr = hobbies.split(" ");
    if (hobbyArr.length == 1) {
      $("input[name='profileform.hobby']").val("");
    } else {
      var hobbyStr = "";
      for (i = 0; i < hobbyArr.length; i++) {
        if (id != hobbyArr[i]) {
          hobbyStr += hobbyArr[i] + " ";
        }
      }
      hobbyStr = hobbyStr.substr(0, hobbyStr.length - 1);
      $("input[name='profileform.hobby']").val(hobbyStr);
    }
    $(obj).remove();
  }
  
  function createTag() {
    var tag = $("input[name='newTag']").val();
    if (tag == "") {
      return false;
    }
    $.ajax({
      type: "GET",
      url: "usr/interest!createInterestAjax.jhtml",
      dataType: 'text',
      data: "tagName=" + tag,
      success: function(data) {
        var hobbies = $("input[name='profileform.hobby']").val();
        if (hobbies != null && hobbies != "") {
          var hobbyArr = hobbies.split(" ");
          if (hobbyArr.length > 8) {
            return false;
          }
          for (i = 0; i < hobbyArr.length; i++) {
            if (data == hobbyArr[i]) {
              return false;
            }
          }
          hobbies = hobbies + " " + data;
        } else {
          hobbies = data;
        }
        $("input[name='profileform.hobby']").val(hobbies);
        var oneTag = "<span title='" + tag +"' class='removable uiToken' onclick='deleteTag(this, " + data + ")'>";
        oneTag += tag + "<a href='javascript:void(0);' title='删除" + tag + "' class='remove uiCloseButton uiCloseButtonSmall'></a></span>";
        $("#selectedTags").append(oneTag);
      }
    });
  }
  
  var pageNo = 1;
  var tagCount = '${tagCount}';
  function changeTag() {
    if (pageNo*12 >= tagCount) {
      pageNo = 1;
    } else {
      pageNo += 1;
    }
    $.ajax({
      type: "GET",
      url: "usr/interest!getInterestsAjax.jhtml",
      dataType: 'html',
      data: "pageNo=" + pageNo,
      success: function(data) {
        $(".editTableWrapper").html(data);
      }
    });
    return false;
  }
</script>