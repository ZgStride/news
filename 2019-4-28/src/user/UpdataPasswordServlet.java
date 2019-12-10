package user;

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
 * Servlet implementation class UpdataPasswordServlet
 */
@WebServlet("/UpdataPasswordServlet")
public class UpdataPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdataPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//生成session、out、application
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		ServletContext appliction = this.getServletContext();
		//1、获取视图（修改密码页面）传递的数据
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String password_old = request.getParameter("password_old");
		String password_new = request.getParameter("password_new");
		String password_confirm = request.getParameter("password_confirm");
		//2、测试数据能否正确获取
		/*
		 * out.print(password_old); out.print(password_new);
		 * out.print(password_confirm);
		 */
		//3、调用模型进行业务处理
		UserBean userBean = (UserBean)session.getAttribute("userBean");
		String  password = userBean.getPassword();
		if(!password.equals(password_old)) {
			response.sendRedirect("oldpassworderror.jsp");
			
			return;
		}
		if(!password_new.equals(password_confirm)) {
			response.sendRedirect("newpassworderror.jsp");
			
			return;
		}
		//到数据库修改密码
		int id = userBean.getId();
		UserService us = new UserService();
		int row = us.doUpdatePassword(id, password_new);
		if(row >= 0) {
			response.sendRedirect("../2019-4-28/user/result.jsp?flag=2");
		}else {
			response.sendRedirect("../2019-4-28/user/result.jsp?flag=3");
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
