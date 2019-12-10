package user;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

/**
 * Servlet implementation class LonginServlet
 */
@WebServlet("/login")
public class LonginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LonginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//1、获取视图传递的数据
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
        
		//2、调用模型（JavaBean）做业务处理
		UserBean user = new UserBean(username,password);
		UserService us = new UserService(user);
		boolean result = us.islogin();
		//3、根据结果选择跳转
		if(result) {
			UserBean userBean = us.doSelectByUsername(username);
			HttpSession session = request.getSession();
	        session.setAttribute("userBean", userBean);
	        int num;//当前在线人数
	        String count = (String)this.getServletContext().getAttribute("count");
	        if(count == null){
				//第一人上线为空
				num = 1;
			}else{
				num = Integer.parseInt(count)+1;//把字符串转换为整型
			}
			//更新在线人数
			count = String.valueOf(num);
			this.getServletContext().setAttribute("count", count);
			response.sendRedirect("../2019-4-28/user/index.jsp");
		}else {
			response.sendRedirect("../2019-4-28/user/denglu_fial.jsp");
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
