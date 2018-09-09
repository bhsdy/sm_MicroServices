package com.sm.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageBean <T> implements Serializable{

	private static final long serialVersionUID = -8652652596351231066L;
	
	public static final Integer DEFAULT_PAGE_SIZE = 10;
	
	public static final Integer DEFAULT_CURRENT_PAGE = 1;
	/**
	 * 当前页
	 */
	public int currPage;
	public void setCurrPage(int currPage) {
		this.currPage = currPage<= 0 ? DEFAULT_CURRENT_PAGE : currPage;
	}
	
	/**
	 * 每页的记录条数
	 */
	public int pageSize;
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize <= 0 ? DEFAULT_PAGE_SIZE: pageSize;
	}
	
	/**
	 * 总记录数
	 */
	public int totalCount;
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;

		//复值totalPageCount
		if (this.totalCount == 0) {
			this.totalPageCount = 0;
		} else {
			this.totalPageCount = (this.totalCount -1) / this.pageSize + 1;
		}

		//修正currPage
		this.currPage = this.currPage > this.totalPageCount ? this.totalPageCount: this.currPage;
	}
	
	/**
	 * 总页数
	 */
	public int totalPageCount;

	/**
	 * 当前页的记录
	 */
	public List<T> page;
	
	/**
	 * 分页按钮list，0表示省略号
	 */
	public List<Integer> pageBtns;
	public List<Integer> getPageBtns() {
		List<Integer> pageBtns = new ArrayList<Integer>();
		if (this.totalPageCount == 0) {
			
			return pageBtns;
		}

		//totalPageCount <= 7时，全部按钮显示
		if (this.totalPageCount <= 7) {
			for (int i=1; i<=this.totalPageCount; i++) {
				pageBtns.add(i);
			}
			
			return pageBtns;
		}
		
		/* 页数大于7时*/
   		
		//首页
		pageBtns.add(1);
		
		if (this.currPage <= 1 + 3) {
			pageBtns.add(2);
			pageBtns.add(3);
			pageBtns.add(4);
			pageBtns.add(5);
			pageBtns.add(0);
		}
		
		if (this.currPage >= this.totalPageCount - 3) {
			pageBtns.add(0);
			pageBtns.add(this.totalPageCount - 4);
			pageBtns.add(this.totalPageCount - 3);
			pageBtns.add(this.totalPageCount - 2);
			pageBtns.add(this.totalPageCount - 1);
		}

		if (this.currPage>(1+3) && this.currPage<(this.totalPageCount-3)) {
			pageBtns.add(0);
			pageBtns.add(this.currPage - 2);
			pageBtns.add(this.currPage - 1);
			pageBtns.add(this.currPage);
			pageBtns.add(this.currPage + 1);
			pageBtns.add(this.currPage + 2);
			pageBtns.add(0);
		}
		
		//尾页
		pageBtns.add(this.totalPageCount);
		
		return pageBtns;
	}
}
