package com.zy.common.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class Page {
	private int totalRows;
	private int currentPage = 1;
	private int pageSize;
	private List<Integer> pages;
	public int firstPage = 1;
	private int prePage;
	private int nextPage;
	private int lastPage;
	private int totalPage;
	private int num = 5;
	private String url;
	private int currentPageFirst;
	private int currentPageLast;

	public Page() {

	}

	/**
	 * Bing this method is compatible for the old Page.java class
	 * 
	 * @param totalRows
	 * @param currentPage
	 * @param pageSize
	 * @param data
	 */
	public Page(int totalRows, int currentPage, final int pageSize, int num) {
		// 计算总页数
		if (totalRows > 0) {
			this.totalRows = totalRows;
			this.totalPage = (totalRows + pageSize - 1) / pageSize;
		}
		currentPage = (currentPage == 0 ? 1:currentPage);
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.num = num;
		this.setLastPage();
		this.setNextPage();
		this.setPrePage();

		/**
		 * compatible pages param
		 */
		pages = new ArrayList<Integer>();
		for (Integer o : getPrevPages()) {
			pages.add(o);
		}
		pages.add(getCurrentPage());
		for (Integer o : getNextPages()) {
			pages.add(o);
		}
	}

	/**
	 * Bing automatic create your pagination url so you can do you business and
	 * won't write any 'onclick gotopage javascript' more.
	 * 
	 * <pre>
	 * &lt;a class=&quot;next&quot; href=&quot;&lt;s:property value=&quot;page.url&quot;/&gt;pageNo=&lt;s:property value=&quot;page.currentPage-1&quot;/&gt;&quot;&gt;&lt;s:text name=&quot;bns.prePage&quot; /&gt;&lt;/a&gt;
	 * </pre>
	 * 
	 * @param totalRows
	 * @param currentPage
	 * @param pageSize
	 * @param num
	 * @param request
	 */
	public Page(int totalRows, int currentPage, final int pageSize, int num, HttpServletRequest request) {
		if (totalRows > 0) {
			this.totalRows = totalRows;
			this.totalPage = (totalRows + pageSize - 1) / pageSize;
		}
		currentPage = (currentPage == 0 ? 1:currentPage);
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.num = num;
		this.setLastPage();
		this.setNextPage();
		this.setPrePage();

		/**
		 * compatible pages param
		 */
		pages = new ArrayList<Integer>();
		for (Integer o : getPrevPages()) {
			pages.add(o);
		}
		pages.add(getCurrentPage());
		for (Integer o : getNextPages()) {
			pages.add(o);
		}
		this.url = request.getRequestURI() + "?";
		java.util.Enumeration paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			if (!("pageNo".equals(paramName))) {
				String[] paramValues = request.getParameterValues(paramName);
				for (int i = 0; i < paramValues.length; i++) {
					String paramValue = paramValues[i];
					if (paramValue != null && !"".equals(paramValue)) {
						try {
							paramValue = java.net.URLEncoder.encode(paramValue, "utf-8");
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
						this.url = this.url + paramName + "=" + paramValue + "&";
					}
				}
			}
		}
	}

	public int getCurrentPageFirst() {
		this.currentPageFirst = ((currentPage - 1) * pageSize) == 0 ? 1 : ((currentPage - 1) * pageSize+1);
		return currentPageFirst;
	}

	public void setCurrentPageFirst(int currentPageFirst) {
		this.currentPageFirst = currentPageFirst;
	}

	public int getCurrentPageLast() {
		this.currentPageLast = ((currentPage) * pageSize) > totalRows ? totalRows : ((currentPage) * pageSize);
		return currentPageLast;
	}

	public void setCurrentPageLast(int currentPageLast) {
		this.currentPageLast = currentPageLast;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<Integer> getPages() {
		return pages;
	}

	public void setPages(List<Integer> pages) {
		this.pages = pages;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getNextPage() {
		return this.nextPage;
	}

	public void setNextPage() {
		if (this.currentPage == this.totalPage)
			this.nextPage = this.totalPage;
		else
			this.nextPage = this.currentPage + 1;
	}

	public int getPrePage() {
		return this.prePage;
	}

	public void setPrePage() {
		if (this.currentPage > 1)
			this.prePage = this.currentPage - 1;
		else
			this.prePage = 0;

	}

	public int getLastPage() {
		return this.lastPage;
	}

	public void setLastPage() {
		this.lastPage = this.totalPage;
	}

	public int getTotalPage() {
		return this.totalPage;
	}

	public void setTotalPage() {
		this.totalPage = totalRows % pageSize == 0 ? totalRows / pageSize : totalRows / pageSize + 1;
	}

	public static void main(String[] args) {
		// Page p = new Page(15, 2, 30);
		// System.out.println("-currentpage--"+p.getCurrentPage()+"--last page--"
		// + p.getLastPage() + "--total page-" + p.getTotalPage());
		// for(Integer s:p.getPages()){
		// System.out.print(s+",");
		// }
		Page p2 = new Page(120, 10, 10, 3);
		System.out.println("是否有下一页：" + p2.getIsNext());
		System.out.println("是否有上一页：" + p2.getIsPrev());

		System.out.println("当前第" + p2.getCurrentPage() + "页");
		System.out.println("共有" + p2.getTotalPage() + "页");
		System.out.println("每页显示" + p2.getPageSize() + "记录");
		System.out.println("共有" + p2.getTotalRows() + "条记录");

		System.out.println("分页导航：");
		for (Integer o : p2.getPages()) {
			System.out.print(o + ",");
		}

		/**
		 * 分页导航条
		 */
		System.out.println("分页导航条");
		for (Integer o : p2.getPrevPages()) {
			System.out.print(o + ",");
		}
		System.out.print("[" + p2.getCurrentPage() + "],");
		for (Integer o : p2.getNextPages()) {
			System.out.print(o + ",");
		}
	}

	/**
	 * 当前页的前num条页 假设当前页是 6 共有11页 如：1 2 3 4 5
	 * 
	 * @return
	 */
	public List<Integer> getPrevPages() {
		List<Integer> list = new ArrayList<Integer>();
		int _frontStart = 1;

		if (this.currentPage > num) {
			_frontStart = this.currentPage - num;
		}

		for (int i = _frontStart; i < this.currentPage; i++) {
			list.add(i);
		}

		return list;
	}

	/**
	 * 当前页的后num条页 假设当前页是 6 共有11页 如：7 8 9 10 11
	 * 
	 * @return
	 */
	public List<Integer> getNextPages() {
		List<Integer> list = new ArrayList<Integer>();
		int _endCount = num;
		if (num > this.totalPage || (this.currentPage + num) > this.totalPage) {
			_endCount = this.totalPage;
		}
		if (num < this.totalPage && (this.currentPage + num) <= this.totalPage) {
			_endCount = this.currentPage + _endCount;
		}

		for (int i = this.currentPage + 1; i <= _endCount; i++) {
			list.add(i);
		}

		return list;
	}

	/**
	 * 设置当前页之前或之后显示的页数个数
	 * 
	 * @param num
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * 判断是否有前一页
	 * 
	 * @return
	 */
	public boolean getIsPrev() {
		if (this.currentPage > 1) {
			return true;
		}
		return false;
	}

	/**
	 * 判断是否有后一页
	 * 
	 * @return
	 */
	public boolean getIsNext() {
		if (this.currentPage < this.totalPage) {
			return true;
		}
		return false;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
