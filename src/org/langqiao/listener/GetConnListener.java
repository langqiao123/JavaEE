package org.langqiao.listener;

/**
 * 监听器，监听web的启动和关闭
 * servletContextListener获取的是web应用的配置参数
 * 而不是像servlet和filter获取本身的配置参数
 * 因为listener十分简单，只需要配置实现类即可，
 * 不能配置初始化参数
 */
import java.util.Enumeration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

@WebListener
public class GetConnListener implements ServletContextListener {

	private final static Logger logger = Logger.getLogger(GetConnListener.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		/*ServletContext servletContext = arg0.getServletContext();
		String initValue = servletContext.getInitParameter("Encoding");
		logger.info("Encoding:"+initValue);*/
		try {
		    ServletContext sc = arg0.getServletContext();
		    Enumeration parameters = sc.getInitParameterNames();
		    while(parameters.hasMoreElements()) {
		    	String parameter = (String)parameters.nextElement();

		    	//相应的键值对存到map中
		    	System.out.println(parameter+":"+sc.getInitParameter(parameter));
		    	//config.addKeyValue(parameter, sc.getInitParameter(parameter)); 
		    }
		} catch(Exception e) {
		   System.out.println("com.shou error:" + e.getMessage());
		}
	}
}
