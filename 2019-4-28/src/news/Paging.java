package news;

import java.util.ArrayList;

public class Paging {
	public static final int PAGE_SIZE=4;
    private int page;//当前页
    private int pagenumber;//总页面数
    private String username;
    private String title;
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPagenumber() {
		return pagenumber;
	}

	public void setPagenumber(int pagenumber) {
		this.pagenumber = pagenumber;
	}

	
    
}