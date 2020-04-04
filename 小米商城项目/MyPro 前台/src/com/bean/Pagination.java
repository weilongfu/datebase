package com.bean;

import java.util.ArrayList;
import java.util.List;

public class Pagination {
	private int pageSize=5; // 每页显示记录
	private int currentPage=1; // 当前页
	private int rowCount; // 总记录数
	private List list; // 当前页显示的记录信息

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	// ------------------------------
	// 总页数
	public int getPageCount() {
		return (rowCount % pageSize == 0) ? rowCount / pageSize : rowCount
				/ pageSize + 1;
	}

	// 上一页
	public int getPrevPage() {
		return (this.currentPage > 1) ? this.currentPage - 1 : 1;
	}

	// 下一页
	public int getNextPage() {
		return this.currentPage < this.getPageCount() ? this.currentPage + 1
				: this.getPageCount();
	}
	// 首页
	public int getFirstPage(){
		return 1;
	}
	// 尾页
	public int getLastPage(){
		return this.getPageCount();
	}

}
