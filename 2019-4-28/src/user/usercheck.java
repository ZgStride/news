package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class usercheck
 */
@WebServlet("/usercheck")
public class usercheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usercheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		         //设置字符编码集
		         request.setCharacterEncoding("utf-8");
		         //模拟存在数据库里面的账号
		         
		         //获取前台传来的数据
		         
		        
		         String uname=request.getParameter("uname");
		         UserService us =new UserService();
		         
		         //模拟和数据库里面的信息匹配
		        
		         boolean mark=us.isExist(uname);
		         
		        
		         //响应前台
		         response.setCharacterEncoding("utf-8");
		         response.setContentType("text/html");
		         PrintWriter out=response.getWriter();
		         if(mark){
		             out.println("<font color='green' size='15px'>√</font>");
		        }else{
		             out.println("<font color='red' size='15px'>×</font>");
		         }
		         out.flush();//刷新流
		         out.close();//关闭流
		         
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
