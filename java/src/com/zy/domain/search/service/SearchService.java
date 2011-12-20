package com.zy.domain.search.service;

import java.util.List;
import org.apache.lucene.search.BooleanClause;
import com.zy.facade.vo.SearchResultVo;

public interface SearchService {
	
	public List<SearchResultVo> getSearchProfileId(String q,int topNum);
	public List<SearchResultVo> getSearchProfileId(String[] fields, String[] values, BooleanClause.Occur[] flags, int topNum);
	public List<SearchResultVo> getSearchProfileId(String[] fields, String[] values, BooleanClause.Occur[] flags,String start,String end, int topNum);
	//public int getCntSearchProfileId(String[] fields, String[] values, BooleanClause.Occur[] flags, int topNum);
	//public int getCntReceSearchProfileId(String[] fields, String[] values, BooleanClause.Occur[] flags,String start,String end);
	public List<String> getTopKeywords(int limit);
}
