package com.zy.common.util;

import java.util.List;
public class Pageinfo<T>{

	
	private List<T>       resultlist;
	private PageIndex     pageIndex;
	private Integer       totalrecond;
	private Integer       firstindex=1;	
	private Integer       maxresult=3;
	private Integer       pagecount;
    //--当当前页记录数小于maxresult时用到这个值具体值
	private Integer       resultlistsize=0;
	
	

	public Pageinfo() {
		super();
	}

	public Pageinfo(List<T> resultlist, Integer totalrecond, Integer firstindex, Integer maxresult) {
		super();
		this.resultlist = resultlist;
		this.totalrecond = totalrecond;
		this.firstindex = firstindex;
		this.maxresult = maxresult;
		if(maxresult!=null){
		this.pagecount = this.totalrecond%this.maxresult>0?
				this.totalrecond/this.maxresult+1:this.totalrecond/this.maxresult;}
		if(maxresult!=null&&firstindex!=null){
		getPageIndex(this.maxresult, this.firstindex, this.pagecount);}
		this.resultlistsize=resultlist.size();
	}

	public Integer getFirstindex() {
		return firstindex<1?1:firstindex;
	}

	public void setFirstindex(Integer firstindex) {
		this.firstindex = firstindex;
	}

	public Integer getMaxresult() {
		return maxresult;
	}

	public void setMaxresult(Integer maxresult) {
		this.maxresult = maxresult;
	}

	public Integer getPagecount() {
		return pagecount;
	}

	public void setPagecount(Integer pagecount) {
		this.pagecount = pagecount;
	}

	public List<T> getResultlist() {
		return resultlist;
	}

	public void setResultlist(List<T> resultlist) {
		this.resultlist = resultlist;
	}

	public Integer getTotalrecond() {
		return totalrecond;
	}

	public void setTotalrecond(Integer totalrecond) {
		this.totalrecond = totalrecond;
	}
    
	public Integer getResultlistsize() {
		return resultlistsize;
	}

	public void setResultlistsize(Integer resultlistsize) {
		this.resultlistsize = resultlistsize;
	}

	public PageIndex getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(PageIndex pageIndex) {
		this.pageIndex = pageIndex;
	}
   
   public void getPageIndex(Integer viewpagecount, int currentPage, Integer totalpage){
		  Integer startpage = currentPage-(viewpagecount%2==0? viewpagecount/2-1 : viewpagecount/2);
		  Integer endpage = currentPage+viewpagecount/2;
			if(startpage<1){
				startpage = 1;
				if(totalpage>=viewpagecount) endpage = viewpagecount;
				else endpage = totalpage;
			}
			if(endpage>totalpage){
				endpage = totalpage;
				if((endpage-viewpagecount)>0) startpage = endpage-viewpagecount+1;
				else startpage = 1;
			}
			pageIndex=new PageIndex(startpage, endpage);		
	  }	
   
   public  class PageIndex {
		private Integer startindex;
		private Integer endindex;
		
		public PageIndex(Integer startindex, Integer endindex) {
			super();
			this.startindex = startindex;
			this.endindex = endindex;
		}
		public Integer getEndindex() {
			return endindex;
		}
		public void setEndindex(Integer endindex) {
			this.endindex = endindex;
		}
		public Integer getStartindex() {
			return startindex;
		}
		public void setStartindex(Integer startindex) {
			this.startindex = startindex;
		}
	}
}
