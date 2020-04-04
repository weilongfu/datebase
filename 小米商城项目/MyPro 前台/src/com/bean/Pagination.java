package com.bean;

import java.util.ArrayList;
import java.util.List;

public class Pagination {
	private int pageSize=5; // ÿҳ��ʾ��¼
	private int currentPage=1; // ��ǰҳ
	private int rowCount; // �ܼ�¼��
	private List list; // ��ǰҳ��ʾ�ļ�¼��Ϣ

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
	// ��ҳ��
	public int getPageCount() {
		return (rowCount % pageSize == 0) ? rowCount / pageSize : rowCount
				/ pageSize + 1;
	}

	// ��һҳ
	public int getPrevPage() {
		return (this.currentPage > 1) ? this.currentPage - 1 : 1;
	}

	// ��һҳ
	public int getNextPage() {
		return this.currentPage < this.getPageCount() ? this.currentPage + 1
				: this.getPageCount();
	}
	// ��ҳ
	public int getFirstPage(){
		return 1;
	}
	// βҳ
	public int getLastPage(){
		return this.getPageCount();
	}

}
