package com.zy.facade.vo;
import java.util.List;

import com.zy.common.util.Page;

public class PageListVO<T> {
	private List<T> list;
	private Page page;
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	public PageListVO(List<T> list,Page page){
		this.list = list;
		this.page = page;
	}
	
	public PageListVO(List<T> list,int pageNo,int pageSize,int totalCnt){
		this.list = list;
		this.page = new Page(totalCnt,pageNo,pageSize,5);
	}
}
