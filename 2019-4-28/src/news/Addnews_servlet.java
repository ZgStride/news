package news;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;


import user.UserBean;

/**
 * Servlet implementation class Addnews_servlet
 */
@WebServlet("/addnwes")
public class Addnews_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addnews_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		ServletContext appliction = this.getServletContext();
		//一、获取数据
		//1、防止乱码处理
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; Character=utf-8");
		//2、获取新闻标题与内容
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		//3、获取发布人
		UserBean userBean = (UserBean)session.getAttribute("userBean");
		int userid = userBean.getId();
		
		//4、获取发布时间
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:ss:mm");
		String pubtime = sf.format(date);
		//out.print(userid);
		//out.print(pubtime);
		
		
		//、二调用模型把新闻数据写入数据库
		//1、把新闻数据包装
		News news = new News();
		news.setContent(content);
		news.setPubtime(pubtime);
		news.setTitle(title);
		news.setUserid(userid);
		//2、调用NewsDao发布新闻到数据库
		NewsService nw = new NewsService();
		int result = nw.doAddNews(news);
		if(result >= 0){
			response.sendRedirect("../2019-4-28/user/result.jsp?flag=0");
		}else{
			response.sendRedirect("../2019-4-28/user/result.jsp?flag=1");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
