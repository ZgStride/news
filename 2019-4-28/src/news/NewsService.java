package news;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DB;
import user.UserBean;

/**
 * 新闻处理类
 * @author 张桃洪
 *
 */
public class NewsService {
	private News news;
	private DB db = new DB();
	private Paging paging;
	public NewsService(){
		
	}
	
	public NewsService(News news){
		this.news = news;
	}

	public News getNews() {
		return news;
	}

	public int setNews(News news) {
		String sql="update news set title='"+news.getTitle()+"',content='"+news.getContent()+"',userid='"+news.getUserid()+"',pubtime='"+news.getPubtime()+"' where id="+news.getId()+";";
		int result = db.executeUpdate(sql);
		System.out.println(sql);
		return result;
	}
	
	public int deleteNewsById(int id) {
		String sql="delete from news where id="+id+";";
		int result = db.executeUpdate(sql);
		return result;
	}
	
	public int deleteAllNewsById(String allid) {
		String sql="delete from news where id in ("+allid+");";
		System.out.println(sql);
		int result = db.executeUpdate(sql);
		return result;
	}
	
	public News doSelectById(int id) {
		News news = null;
		String sql="select news.id,title,content,username,pubtime from news left outer join user on userid=user.id where news.id="+id+";";
		ResultSet rs = db.executeQuery(sql);
		try {
			if(rs.next()) {
				news = new News();
				news.setId(rs.getInt("news.id"));
				news.setContent(rs.getString("content"));
				news.setTitle(rs.getString("title"));
				news.setUsername(rs.getString("username"));
				news.setPubtime(rs.getString("pubtime"));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closeDB();
		}
		return news;
	}
	
	/**
	 * 发布新闻
	 * @return
	 */
	public int doAddNews(){
		int result = -1;
		
		String sql = "insert news(title,content,userid,pubtime) values('"+news.getTitle()+"','"+news.getContent()+"',"+news.getUserid()+",'"+news.getPubtime()+"');";
		//System.out.println(sql);
		result = db.executeUpdate(sql);
		db.closeDB();
		
		return result;
	}
	
	/**
	 * 发布新闻
	 * @param news 新闻信息
	 * @return
	 */
	public int doAddNews(News news){
		int result = -1;
		
		String sql = "insert news(title,content,userid,pubtime) values('"+news.getTitle()+"','"+news.getContent()+"',"+news.getUserid()+",'"+news.getPubtime()+"');";
		result = db.executeUpdate(sql);
		db.closeDB();
		
		return result;
	}
	public ArrayList<News> doSelectBy(String title,String username,int page){
		ArrayList<News> list = new ArrayList<News>();
		
		String sql="select news.id,title,content,userid,username,pubtime from news left outer join user on userid=user.id where 1=1 limit "+(page-1)*Paging.PAGE_SIZE+","+Paging.PAGE_SIZE+"";
		
		if(title != null && title.length()>0) {
			sql="select news.id,title,content,userid,username,pubtime from news left outer join user on userid=user.id where 1=1 ";
			sql += "and title like '%"+title+"%'";
		}
		
		if(username != null && username.length()>0) {
			sql="select news.id,title,content,userid,username,pubtime from news left outer join user on userid=user.id where 1=1 ";
			sql += "and username like '%"+username+"%'";
		}

		ResultSet rs = db.executeQuery(sql);
		try {
			while(rs.next()) {
				News news = new News();
				news.setId(rs.getInt("news.id"));
				news.setContent(rs.getString("content"));
				news.setUserid(rs.getInt("userid"));
				news.setTitle(rs.getString("title"));
				news.setUsername(rs.getString("username"));
				news.setPubtime(rs.getString("pubtime"));
				list.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.closeDB();
		
		return list;
	}
	public int findCount(){
        int count = 0;
        int pages = 0;
        String sql = "select count(*) from news";
        ResultSet rs = db.executeQuery(sql);
        try {           
            if (rs.next()){
                count = rs.getInt(1);  
            }
            if (count % Paging.PAGE_SIZE == 0){
                pages = count/Paging.PAGE_SIZE; //分为几页
            }else{
                pages = count / Paging.PAGE_SIZE+1; //多余的增加一列
            }
            rs.close();
            
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return pages;
    }
	
	
	
}
