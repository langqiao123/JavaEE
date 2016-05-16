package org.langqiao.listener;

/**
 * 监听器，负责启动一条后台线程，
 * 该线程将会定期检查用户在线记录，
 * 并删除长期没有重新请求过 的记录
 * 
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.swing.Timer;

import org.apache.log4j.Logger;

@WebListener
public class OnlineListener implements ServletContextListener {

	private final static Logger logger = Logger.getLogger(OnlineListener.class);

	public final int MAX_MILLIS = 10 * 60 * 1000;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		new Timer(1000*5, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//如果距离上次访问的时间超过了制定时间
				//则从数据库中删除
			}
		}).start();
		
	}

	
	
}
