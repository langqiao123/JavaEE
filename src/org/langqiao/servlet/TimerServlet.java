package org.langqiao.servlet;

/**
 * 该servlet不响应用户请求，仅执行计数器功能
 * 每隔一段时间会在控制台打印出系统当前时间
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.swing.Timer;

import org.apache.log4j.Logger;


public class TimerServlet extends HttpServlet{

	private static final long serialVersionUID = 3167146921668436916L;

	private final static Logger logger = Logger.getLogger(TimerServlet.class);
	
	public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	Timer t = new Timer(1000,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				logger.info("TimerServlet:"+df.format(new Date()));
			}
		});
    	//t.start();
    }
}
