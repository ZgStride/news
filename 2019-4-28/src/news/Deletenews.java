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
 * Servlet implementation class Deletenews
 */
@WebServlet("/Deletenews")
public class Deletenews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deletenews() {
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
		String allid = request.getParameter("allid");
		
		
		if(operation.equals("alldelete")) {			
			NewsService ne = new NewsService();
			int result = ne.deleteAllNewsById(allid);
			
			if(result>=0) {
				response.sendRedirect("../2019-4-28/user/result.jsp?flag=10");
			}else {
				response.sendRedirect("../2019-4-28/user/result.jsp?flag=11");
			}
		}
		if(operation.equals("delete")) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			NewsService ne = new NewsService();
			int result = ne.deleteNewsById(id);
			
			if(result>=0) {
				response.sendRedirect("../2019-4-28/user/result.jsp?flag=10");
			}else {
				response.sendRedirect("../2019-4-28/user/result.jsp?flag=11");
			}
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
