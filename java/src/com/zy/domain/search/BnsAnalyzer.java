package com.zy.domain.search;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.util.Version;

public class BnsAnalyzer {
	public final static Analyzer INDEX_ANALYZER= new StandardAnalyzer(Version.LUCENE_CURRENT);
	public final static Analyzer SEARCH_ANALYZER= new StandardAnalyzer(Version.LUCENE_CURRENT);

	//public final static Analyzer INDEX_ANALYZER= new StandardAnalyzer();
	//public final static Analyzer SEARCH_ANALYZER= new StandardAnalyzer();

}
