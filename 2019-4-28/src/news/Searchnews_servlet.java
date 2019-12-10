package news;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Searchnews_servlet
 */
@WebServlet("/Searchnews_servlet")
public class Searchnews_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Searchnews_servlet() {
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
		
		String operation = request.getParameter("operation");
		out.print(operation);
		
		int id = Integer.parseInt(request.getParameter("id"));
		NewsService nw = new NewsService();
		News news = nw.doSelectById(id);
		request.getSession().setAttribute("news", news);
		if(operation.equals("view")) {
			response.sendRedirect("../2019-4-28/news/chakanxinwen.jsp");
		}
		if(operation.equals("updata")) {
			response.sendRedirect("../2019-4-28/news/xiugaixinwen.jsp");
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
