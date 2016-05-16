package org.langqiao.interceptor;

/**
 * 登录的过滤器，过滤.jsp、.html、.htm类型的文件
 */
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginFilter extends HttpServlet implements Filter {    
    
    private static final long serialVersionUID = 1L;    
    
    @Override    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {    
        HttpServletRequest req = (HttpServletRequest)request;    
        HttpServletResponse res = (HttpServletResponse)response;    
        String path = req.getContextPath();  
        //登录页面的路径
        String indexPath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path+ "/login.jsp";  
        if(req.getRequestURI().endsWith("login.jsp")){  
            chain.doFilter(request, response);   
            return;  
        }  
          
        Object loginuser = req.getSession().getAttribute("username");    
        if(loginuser == null){  
            res.sendRedirect(indexPath);    
            return;    
        }  
        chain.doFilter(request, response);    
    }    
    
    @Override    
    public void init(FilterConfig arg0) throws ServletException {    
    }    
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
    	System.out.println("URL的方式访问LoginFilter");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}    