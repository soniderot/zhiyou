package com.zy.facade;

import java.util.List;

import com.zy.facade.vo.PageListVO;
import com.zy.facade.vo.SearchFormVo;
import com.zy.facade.vo.SearchResultVo;

public interface SearchFacade {
	public List<SearchResultVo> getProfilesBySearch_tx(int userId, SearchFormVo form, int limitNum);
	
	//public int getCntProfilesBySearch(int userId, SearchFormVo form, int limitNum);
	//public int getCntReceProfilesBySearch(int userId, SearchFormVo form);
	
	public PageListVO<SearchResultVo> getProfilesBySearch(int userId, SearchFormVo form, int pageNo, int pageSize, int limitNum);
}
