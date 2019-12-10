package news;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserBean;

/**
 * Servlet implementation class updatenews
 */
@WebServlet("/updatenews")
public class updatenews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatenews() {
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
		
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		out.print(content);
		UserBean userBean = (UserBean)session.getAttribute("userBean");
		int userid = userBean.getId();
		
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:ss:mm");
		String pubtime = sf.format(date);
		
		News news = new News();
		news.setId(id);
		news.setTitle(title);
		news.setContent(content);
		news.setUserid(userid);
		news.setPubtime(pubtime);
		
		NewsService nw = new NewsService();
		int result = nw.setNews(news);
		if(result>=0) {
			response.sendRedirect("../2019-4-28/user/result.jsp?flag=8");
		}else {
			response.sendRedirect("../2019-4-28/user/result.jsp?flag=9");
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
