package jxau.model;

public class Page {
	private int page;
	private int recTotal;
	private int recPerPage;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRecTotal() {
		return recTotal;
	}
	public void setRecTotal(int recTotal) {
		this.recTotal = recTotal;
	}
	public int getRecPerPage() {
		return recPerPage;
	}
	public void setRecPerPage(int recPerPage) {
		this.recPerPage = recPerPage;
	}
	public Page(int page, int recTotal, int recPerPage) {
		super();
		this.page = page;
		this.recTotal = recTotal;
		this.recPerPage = recPerPage;
	}
	
}
