package org.langqiao.servlet;

/**
 * 从web.xml文件中获取"init-param"的参数值(取自己servlet下配置的 <init-param>)
 */
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class GetServletParam extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private final static Logger logger = Logger.getLogger(GetServletParam.class);
	
    public GetServletParam() {
        super();
    }

    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    }
    
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取ServletConfig对象
		ServletConfig config = getServletConfig();
		String initValue = config.getInitParameter("encoding");
		System.out.println("encoding:"+initValue);
	}

}
