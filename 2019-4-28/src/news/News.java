package news;
/**
 * 新闻信息类(装新闻数据)
 * @author 张桃洪
 *
 */
public class News {
//select id,title,content,userid,pubtime from news;
	public static final int PAGE_SIZE=2;
	private int id;
	private String username;
	private String title;
	private String content;
	private int userid;
	private String pubtime;
	
	public News() {
		super();
	}
	
	public News(int id, int userid) {
		super();
		this.id = id;
		this.userid = userid;
	}

	public News(int id, int userid, String pubtime) {
		super();
		this.id = id;
		this.userid = userid;
		this.pubtime = pubtime;
	}

	public News(String title) {
		super();
		this.title = title;
	}

	public News(int id) {
		super();
		this.id = id;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPubtime() {
		return pubtime;
	}
	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}

}
