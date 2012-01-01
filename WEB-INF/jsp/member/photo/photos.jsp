<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<div role="main" id="contentArea">
  <div data-referrer="pagelet_roosters" id="pagelet_roosters"></div>
  
  <div data-referrer="pagelet_composer" id="pagelet_composer">
    <div id="u3mxyl_2"
      onclick="Bootloader.loadComponents(&quot;Composer&quot;, function() { JSCC.get(&#39;j4ec37b3f908df06889566482&#39;) });"
      class="uiComposer uiComposerHideContent stat_elem uiMetaComposer uiComposerTopBorder uiComposerOpen uiComposerHideContent uiComposerWhiteMessageBox">
      <div class="focus_target">
        <ul class="uiList uiListHorizontal clearfix uiComposerAttachments">
         
        </ul>

      
      </div>
    </div>
  </div>
  
  
  <iframe style="width: 1px; height: 1px; position: absolute; top: -10000px;" name="u3jjus_1" class="fbUploadIframe"></iframe>
  <div data-gt='{"ref":"nf"}' data-referrer="pagelet_home_stream" id="pagelet_home_stream">
    <div id="c4ec37b3fc7e022d58174072" class="UIIntentionalStream UIStream">
      <ul id="home_stream" class="uiList uiStream UIIntentionalStream_Content" data-referrer="home_stream" style="min-height: 100px;">
        <s:iterator value="userPhotos">
          <li id="stream_story_4ec37b3fd947b3232640247"
            data-ft='{"qid":"5675515467749930831","mf_story_key":"2652098748566","c":"m"}'
            class="pvm uiUnifiedStory uiStreamStory genericStreamStory aid_1438697558 uiListItem uiListLight uiListVerticalItemBorder">
            <div class="storyHighlightIndicatorWrapper"></div>
            <div class="storyContent">
              <div class="UIImageBlock clearfix" align="center">
               
                <div class="storyInnerContent UIImageBlock_Content UIImageBlock_MED_Content">
                  <div class="mainWrapper">
                    <h6 class="uiStreamMessage">
                      <div class="actorDescription actorName">
                       
                       
                       
                       	<h6 data-ft="{&quot;type&quot;:1}" class="uiStreamMessage"> 
          											<span data-ft="{&quot;type&quot;:3}" class="messageBody"><s:property value="summary" /></span>
          											</h6>
          											<div data-ft="{&quot;type&quot;:10}" class="mvm uiStreamAttachments clearfix fbMainStreamAttachment">
          												<div>
          													<a data-ft="{&quot;type&quot;:41}" title="<s:property value="summary" />" ajaxify="#" class="uiPhotoThumb largePhoto">
          														<img   alt="" src="<s:property value="filename" />" class="img">
          														</a>
          														<div class="fsm fwn fcg">
          															<span class="caption"></span>
          															<div class="uiAttachmentDesc translationEligibleUserAttachmentMessage"></div>
          														</div>
          														</div>
          														</div>
                       
                       
                       
                      
                    </h6>
                    
                     <span class="uiStreamFooter">
                       
                        <span class="uiStreamSource" data-ft="{&quot;type&quot;:26}">
                          <abbr title="<s:date name="feed.created" format="yyyy-MM-dd HH:mm" />"  class="timestamp livetimestamp">
                            上传于<s:date name="createtime" format="yyyy-MM-dd HH:mm" />
                          </abbr>
                        </span>
                      </span>
                    
                  </div>
                </div>
              </div>
            </div>
          </li>
        </s:iterator>
      </ul>

      <div>
        <div id="pagelet_stream_pager"
          data-referrer="pagelet_stream_pager">
          <div class="clearfix mts uiMorePager stat_elem fbStreamPager">
            <a href="/ajax/feed/edit_options_dialog.php?filter_key=lf" rel="dialog" class="uiMorePagerSecondary rfloat">编辑选项</a>
            <div>
              <div class="pam uiBoxLightblue uiMorePagerPrimary">目前没有更多动态可显示。</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>