package news;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Selectnews_servlet
 */
@WebServlet("/Selectnews_servlet")
public class Selectnews_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Selectnews_servlet() {
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
		String username = request.getParameter("username");
		String title = request.getParameter("title");
		
		int currPage = 1;
        if (request.getParameter("currPage") == null||Integer.parseInt(request.getParameter("currPage"))<=0){
            currPage = 1;
        }else{
            currPage = Integer.parseInt(request.getParameter("currPage"));
        }
        
        Paging paging=new Paging();
        paging.setPage(currPage);
        paging.setTitle(title);
              
		NewsService ndao = new NewsService();
		
		ArrayList<News> list =ndao.doSelectBy(title, username, currPage);
		request.getSession().setAttribute("list", list);
		
		NewsService dao = new NewsService(); 
        int count = dao.findCount();
        
		response.sendRedirect("../2019-4-28/news/selectnews.jsp?pages="+paging.getPage());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
