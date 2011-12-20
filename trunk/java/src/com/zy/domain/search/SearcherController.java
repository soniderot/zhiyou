package com.zy.domain.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Searcher;
import org.apache.lucene.store.FSDirectory;

public class SearcherController {
	
	private static final String SEGMENTS = "segments";
	private static final String SEGMENTS_GEN = "segments.gen";
	  
	private final static Map<String, SearcherCacheBean> _cache = new HashMap<String, SearcherCacheBean>();
	
	

	public static Searcher getSearcher(String path) throws IOException {
		//方法一
		//return new IndexSearcher(FSDirectory.open(new File(path)), true);
		return new IndexSearcher(FSDirectory.open(new File("c://200")), true);
		
//		//方法二
//		if (StringUtils.isBlank(path))
//			throw new IOException("invalid path");
//		if (!new File(path).exists()) {
//			throw new FileNotFoundException("path '" + path + "' does not exist");
//		}
//		
//		Searcher searcher = null;
//		
//		synchronized (_cache) {
//			SearcherCacheBean searcherCacheBean = _cache.get(path);
//			
//			/* new a searcher or fetch a searcher from cache */
//			if(searcherCacheBean == null){
//				searcher = new IndexSearcher(FSDirectory.open(new File(path)), true);
//				
//				searcherCacheBean = new SearcherCacheBean();
//				searcherCacheBean.setSearcher(searcher);
//				File segmentFile = SearcherController.seekSegmentFile(path);
//				searcherCacheBean.setSegmentFile(segmentFile);
//				searcherCacheBean.setLoadTime(segmentFile.lastModified());
//				_cache.put(path, searcherCacheBean);
//			
//			} else {
//				
//				/* reused if not expired */
//				long lastModified = searcherCacheBean.getSegmentFile().lastModified();
//				if(lastModified > searcherCacheBean.getLoadTime()){
//					searcherCacheBean.getSearcher().close();
//					searcher = new IndexSearcher(FSDirectory.open(new File(path)), true);
//					searcherCacheBean.setSearcher(searcher);
//					searcherCacheBean.setLoadTime(lastModified);
//				} else {
//					return searcherCacheBean.getSearcher();
//				}
//			}
//		}
//		
//		return searcher;
//		

		//目前的方法
		//return new IndexSearcher(IndexReader.open(FSDirectory.open(new File(path)), true));
	}
	

	private static File seekSegmentFile(String path){
		if(!new File(path).exists())
			return null;
		
		File segments = new File(path, SearcherController.SEGMENTS);
		if(segments.exists())
			return segments;
		
		segments = new File(path, SearcherController.SEGMENTS_GEN);
		return segments;		
	}
	
}

class SearcherCacheBean {
	
	private Searcher searcher;
	private long loadTime;
	private File segmentFile;
	
	public Searcher getSearcher() {
		return searcher;
	}
	public void setSearcher(Searcher searcher) {
		this.searcher = searcher;
	}
	public long getLoadTime() {
		return loadTime;
	}
	public void setLoadTime(long loadTime) {
		this.loadTime = loadTime;
	}
	public File getSegmentFile() {
		return segmentFile;
	}
	public void setSegmentFile(File segmentFile) {
		this.segmentFile = segmentFile;
	}

}



