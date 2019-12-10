package common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserBean;

/**
 * Servlet Filter implementation class PublicFilter
 */
@WebFilter("/PublicFilter")
public class PublicFilter implements Filter {
	
	private String excludedPage;
	 private String[] excludedPages;
    /**
     * Default constructor. 
     */
    public PublicFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		//中文乱码处理过滤器
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("utf-8");
		
		String path = req.getRequestURI();
	    System.out.println(path);
		
		boolean flag = false;
        for (String page:excludedPages) {
        	 System.out.println(page);
            if (req.getRequestURI().equals(page)){
                flag = true;
            }
            System.out.println(flag);
        }
        
        if(flag){
        	if (req.getRequestURI().equals("/2019-4-28/user/zhuce.jsp")){
                flag = true;
            }
            chain.doFilter(req, resp);               
        }else{
        	
	    	UserBean userBean = (UserBean)session.getAttribute("userBean");
	    	
	    	if (userBean != null){
	    		chain.doFilter(req,resp);
	        }else {
	        	if (req.getRequestURI().equals("/2019-4-28/user/zhuce.jsp")){
	        		chain.doFilter(req, resp);
	            }
	            
	        	resp.sendRedirect("weidenglu.jsp");
        }
    	
    }       
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		excludedPage = fConfig.getInitParameter("ignores");//此处的ignores就是在web.xml定义的名称一样。
        if (excludedPage != null && excludedPage.length() > 0){
            excludedPages = excludedPage.split(",");
        }
	}

}
