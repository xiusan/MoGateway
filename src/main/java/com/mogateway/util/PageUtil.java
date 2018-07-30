package com.mogateway.util;

/**
 * 创建用户：杨辽
 * 创建时间：2016-11-2 10:22:00
 * 描    述：分页工具类
 */
public class PageUtil {

	private Integer limit = 10; // 当前页大小//每页行数
	private Integer total = 0; // 总记录数
	private Integer currentPage = 1; // 当前页
	private Integer totalPage = 0; // 总页数

	
	public PageUtil() {
		super();
	}

	public PageUtil(Integer limit, Integer currentPage, Integer total) {
		super();
		this.limit = limit;
		this.currentPage = currentPage;
		if (total > 0) {
			this.total = total;

			if (total % this.limit > 0) {
				this.totalPage = (total / this.limit) + 1;
			} else {
				this.totalPage = (total / this.limit);
			}
		} else {
			this.total = 0;
		}
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		if (total > 0) {
			this.total = total;

			if (total % this.limit > 0) {
				this.totalPage = (total / this.limit) + 1;
			} else {
				this.totalPage = (total / this.limit);
			}
		} else {
			this.total = 0;
		}
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	@Override
	public String toString() {
		return "PageUtil{" +
				"limit=" + limit +
				", total=" + total +
				", currentPage=" + currentPage +
				", totalPage=" + totalPage +
				'}';
	}
}
