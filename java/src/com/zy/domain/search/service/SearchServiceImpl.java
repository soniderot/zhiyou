package com.zy.domain.search.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Filter;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.QueryFilter;
import org.apache.lucene.search.RangeQuery;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Searcher;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.util.Version;

import com.zy.Constants;
import com.zy.common.model.ZyIndexlog;
import com.zy.common.util.LogUtil;
import com.zy.domain.search.BnsAnalyzer;
import com.zy.domain.search.IndexField;
import com.zy.domain.search.SearcherController;
import com.zy.domain.search.dao.IndexLogDao;
import com.zy.facade.vo.SearchResultVo;

public class SearchServiceImpl implements SearchService{
	private IndexLogDao indexLogDao;
	
	public IndexLogDao getIndexLogDao() {
		return indexLogDao;
	}

	public void setIndexLogDao(IndexLogDao indexLogDao) {
		this.indexLogDao = indexLogDao;
	}

	private List<SearchResultVo> generateSearchResultVo(Searcher searcher, ScoreDoc[] hits) throws CorruptIndexException, IOException {
		List<SearchResultVo> list = new ArrayList<SearchResultVo>();
		for (int i = 0; i < hits.length; i++) {
			LogUtil.info("----------hits doc----" + i);
			Document doc = searcher.doc(hits[i].doc);
			SearchResultVo vo = new SearchResultVo();
			vo.setProfileId(Integer.parseInt(doc.get(IndexField.Profile.USER_ID)));
			//vo.setFriendsCnt(Integer.parseInt(doc.get(IndexField.Profile.FRIENDS_1D)));
			//vo.setCountryname(doc.get(IndexField.Profile.COUNTRY_NAME_CN));
			//vo.setCityname(doc.get(IndexField.Profile.CITY_NAME_CN));
			list.add(vo);
		}
		return list;
	}
	
	public List<SearchResultVo> getSearchProfileId(String q,int topNum){
		Query query = null;
		Searcher searcher=null;
		try {
			TopScoreDocCollector collector = TopScoreDocCollector.create(topNum, false);
			ZyIndexlog last = this.indexLogDao.getLastIndexLog();
			String current_path = Constants.INDEX_DIR_PROFILE_LIVE + Constants.INDEX_LIVE1;
			if (last != null)
				current_path = Constants.INDEX_DIR_PROFILE_LIVE + last.getFilename();
			
			System.out.println("befroepath---------"+Constants.INDEX_DIR_PROFILE_LIVE);
			System.out.println("path---------"+current_path);
			searcher = SearcherController.getSearcher(current_path);
			QueryParser parser = new QueryParser(Version.LUCENE_CURRENT, q, BnsAnalyzer.SEARCH_ANALYZER);
			query = parser.parse(q);
			LogUtil.info(query + "------searcher-----" + searcher + "----------" + current_path);
			searcher.search(query, collector);
			return generateSearchResultVo(searcher, collector.topDocs().scoreDocs);
		} catch (IOException e) {
			e.printStackTrace();
			LogUtil.error(e);
		} catch (ParseException e) {
			e.printStackTrace();
			LogUtil.error(e);
		}finally{
			if(searcher!=null){//need optimize
				try {
					searcher.close();
				} catch (IOException e) {
				}
			}
		}
		return new ArrayList<SearchResultVo>(0);
	}
	
	public List<SearchResultVo> getSearchProfileId(String[] fields, String[] values, BooleanClause.Occur[] flags, int topNum){
		Searcher searcher=null;
		try {
			TopScoreDocCollector collector = TopScoreDocCollector.create(topNum, false);
			ZyIndexlog last = this.indexLogDao.getLastIndexLog();
			String current_path = Constants.INDEX_DIR_PROFILE_LIVE + Constants.INDEX_LIVE1;
			if (last != null)
				current_path = Constants.INDEX_DIR_PROFILE_LIVE + last.getFilename();
			searcher = SearcherController.getSearcher(current_path);
			BooleanQuery.setMaxClauseCount(Integer.MAX_VALUE);
			Query query = MultiFieldQueryParser.parse(Version.LUCENE_CURRENT, values, fields, flags, BnsAnalyzer.SEARCH_ANALYZER);
			LogUtil.info(query + "------searcher-----" + searcher + "----------" + current_path);
			searcher.search(query, collector);
			return generateSearchResultVo(searcher, collector.topDocs().scoreDocs);
		} catch (IOException e) {
			e.printStackTrace();
			LogUtil.error(e);
		} catch (ParseException e) {
			e.printStackTrace();
			LogUtil.error(e);
		}finally{
			if(searcher!=null){//need optimize
				try {
					searcher.close();
				} catch (IOException e) {
				}
			}
		}
		return new ArrayList<SearchResultVo>(0);
	}
	public List<SearchResultVo> getSearchProfileId(String[] fields, String[] values, BooleanClause.Occur[] flags,String start,String end, int topNum){
		Searcher searcher=null;
		try {
			TopScoreDocCollector collector = TopScoreDocCollector.create(topNum, false);
			ZyIndexlog last = this.indexLogDao.getLastIndexLog();
			String current_path = Constants.INDEX_DIR_PROFILE_LIVE + Constants.INDEX_LIVE1;
			if (last != null)
				current_path = Constants.INDEX_DIR_PROFILE_LIVE + last.getFilename();
			searcher = SearcherController.getSearcher(current_path);
			BooleanQuery.setMaxClauseCount(Integer.MAX_VALUE);
			Query query = MultiFieldQueryParser.parse(Version.LUCENE_CURRENT, values, fields, flags, BnsAnalyzer.SEARCH_ANALYZER);
			LogUtil.info(query + "------searcher-----" + searcher + "----------" + current_path);
			Term startTerm = new Term(IndexField.Profile.BIRTHDATE,start);
			Term endTerm = new Term(IndexField.Profile.BIRTHDATE,end);
			Query rangeQuery = new RangeQuery(startTerm, endTerm, true);
			Filter filter = new QueryFilter(rangeQuery);
			System.out.println(filter);
			searcher.search(query,filter,collector);
			return generateSearchResultVo(searcher, collector.topDocs().scoreDocs);
		} catch (IOException e) {
			e.printStackTrace();
			LogUtil.error(e);
		} catch (ParseException e) {
			e.printStackTrace();
			LogUtil.error(e);
		}finally{
			if(searcher!=null){//need optimize
				try {
					searcher.close();
				} catch (IOException e) {
				}
			}
		}
		return new ArrayList<SearchResultVo>(0);
	}
	
	/*
	public int getCntSearchProfileId(String[] fields, String[] values, BooleanClause.Occur[] flags, int topNum){
		return 0;
	}
	public int getCntReceSearchProfileId(String[] fields, String[] values, BooleanClause.Occur[] flags,String start,String end){
		return 0;
	}*/
	public List<String> getTopKeywords(int limit){
		//return searchLogDao.getTopKeywords(limit);
		return null;
	}
}
