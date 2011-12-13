      <%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
      <%@page contentType="text/html; charset=UTF-8"%>
          <div role="complementary" id="rightCol">
            <div class="home_right_column">
              <div class="rightColumnWrapper">
                <div data-referrer="pagelet_chbox" id="pagelet_chbox"></div>
                <div data-referrer="pagelet_ego_pane_w" id="pagelet_ego_pane_w">
                  <div class="ego_column egoOrganicColumn">
                    <div class="ego_section">
                    <s:if test="profiles!=null">   
                      <div class="uiHeader uiHeaderTopAndBottomBorder mbs uiSideHeader">
                       
                        <div class="clearfix uiHeaderTop">
                          <a href="/l.php?u=%2Ffind-friends%2Fbrowser%2F%3Fref%3Dpsa&amp;h=mAQEl7miD&amp;cb=3&amp;p=AT6YmGpyC61GFOqpL1z1SAgrqzJ3tBYp1BVWvPDIiNUVHC7HCXy5-TpjnD0ccPM5gXw49jNjlkaI8KFSqNrtUAS8FD35PyyGL17TmFEl4eHNVACx" class="uiHeaderActions rfloat">显示全部</a>
                          <div><h4 class="uiHeaderTitle">你可能认识的人</h4></div>
                        </div>
                       
                        
                      </div>
                       </s:if>   
                      <div class="phs">
                        
                        
                        <s:iterator value="profiles">
                        <div class="UIImageBlock clearfix ego_unit">
                          <a aria-hidden="true" tabindex="-1" data-gt='{"engagement":{"eng_type":"1","eng_src":"13","eng_tid":"1372884330","eng_data":{"ego_service":"pymk","ego_pos":"4"}}}' href="/l.php?u=http%3A%2F%2Fwww.facebook.com%2Fprofile.php%3Fid%3D1372884330%26ref%3Dpymk&amp;h=hAQGxW-rE&amp;cb=3&amp;p=AT7Zsd7HEO5HNDrHCHxcNHOHxwnedFFtRSikBsemMO1dEi-1lI0m-OfA6ItpfPHZ0VGbnP_mMSXCrwGvNuteIWVnnsG24f_peAT6dxI9pF-TdIrE" class="UIImageBlock_Image UIImageBlock_SMALL_Image"><img alt="" src="${avatar }" class="uiProfilePhoto uiProfilePhotoLarge img"/></a>
                          <div class="egoProfileTemplate UIImageBlock_Content UIImageBlock_SMALL_Content">
                            <a data-gt='{"engagement":{"eng_type":"1","eng_src":"13","eng_tid":"1372884330","eng_data":{"ego_service":"pymk","ego_pos":"4"}}}' href="http://www.sina.com.cn" class="ego_title">${username }</a>
                            <div class="ego_action"><a rel="async-post" ajaxify="/ajax/eh.php?p=AT40NdOtMrgtwvu4JKgo5VHEGidrTZ-sB-WdjBy8W1aWculkjgHbDN1ZEr7TJ0MCM2moWiqZtDrL0zakSFQBgdg_-qZVcgk-C7U869a3z5wolGJd6rCM4zvTWlsMrqzWuneDBHbnySqOk58A698NV-F6N2CpjFGQqZMfAMR2Iq9aNNtK&amp;xids=%7B%221376605282%22%3A1%2C%221147506336%22%3A1%2C%22709329294%22%3A1%2C%221372884330%22%3A1%7D" style="padding-left: 18px;" class="uiIconText">
                              <i style="top: 2px;" class="img sp_6h8b4g sx_c4a0c4"></i>加为好友</a>
                            </div>
                          </div>
                        </div>
                 		</s:iterator>
                 		
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>