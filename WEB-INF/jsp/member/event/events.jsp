<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<div role="main" id="contentArea">
  <div id="pagelet_events">
    <div class="uiHeader uiHeaderWithImage uiHeaderPage">
      <div class="clearfix uiHeaderTop">
        <label for="u1ur4p_1" class="uiHeaderActions rfloat uiButton">
          <i class="mrs img sp_7gl7wd sx_61da04"></i>
          <input type="submit" id="u1ur4p_1" onclick='goURI("\/events\/create\/", true);' value="创建活动"/>
        </label>
        <div>
          <h2 class="uiHeaderTitle">
            <i class="uiHeaderImage img sp_6h8b4g sx_70f090"></i>活动
          </h2>
        </div>
      </div>
    </div>
    <div class="UIImageBlock clearfix fbxNullState">
      <i class="UIImageBlock_Image UIImageBlock_SMALL_Image img sp_9dewam sx_83050b"></i>
      <div class="UIImageBlock_Content UIImageBlock_SMALL_Content">
        <p>你没有即将举行的活动。
          <a href="/event/createOrUpdate!createOrUpdate.jhtml" class="pls">创建活动</a>
        </p>
      </div>
    </div>
    <div class="clearfix uiPager uiPagerTopBorder">
      <div class="summary lfloat fsm fcg">
        <div class="prm">
          <div class="fsm fwn fcg">
            <a href="/events/past/">已结束的活动</a>
             · <a href="/events/birthdays/">生日列表</a>
             · <a rel="dialog" href="/ajax/events/export_events_dialog.php">导出到日历</a>
          </div>
        </div>
      </div>
      
      <div class="rfloat">
        <a data-href="/?sk=events&amp;s=-1" role="button" class="prev uiButtonDisabled uiButton uiButtonNoText">
          <i class="mrs customimg img sp_9dewam sx_48249a"></i>
          <span class="uiButtonText"></span>
        </a>
        <a data-href="/?sk=events&amp;s=1" role="button" class="next uiButtonDisabled uiButton uiButtonNoText">
          <i class="mrs customimg img sp_9dewam sx_ce0533"></i>
          <span class="uiButtonText"></span>
        </a>
      </div>
    </div>
  </div>
</div>