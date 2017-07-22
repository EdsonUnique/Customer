package domain;

import java.util.List;

public class Page {
	
	private List<Customer>list;
	private int totalpage;
	private String url;

	private int startindex;
	private int pagesize=1;
	
	private int pagenum;
	private int pagerecord;
	
	private int startPage;
	private int endPage;
	
	
	public Page(int pagenum,int pagerecord){
		this.pagenum=pagenum;
		this.pagerecord=pagerecord;
		
		startindex=(pagenum-1)*pagesize;
		totalpage=(int)Math.ceil(pagerecord*1.0/pagesize);
		
		if(totalpage<=10){
			startPage=1;
			endPage=totalpage;
		}else{
			startPage=pagenum-4;
			endPage=pagenum+5;
			
			if(endPage>=totalpage){
				startPage=totalpage-9;
				endPage=totalpage;
			}
			
			if(startPage<1){
				startPage=1;
				endPage=10;
			}
		}
		
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public List<Customer> getList() {
		return list;
	}

	public void setList(List<Customer> list) {
		this.list = list;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getStartindex() {
		return startindex;
	}

	public void setStartindex(int startindex) {
		this.startindex = startindex;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public int getPagerecord() {
		return pagerecord;
	}

	public void setPagerecord(int pagerecord) {
		this.pagerecord = pagerecord;
	}
	
	
	
	

}
