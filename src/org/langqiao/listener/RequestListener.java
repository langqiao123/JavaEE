package org.langqiao.listener;

/**
 * 监听器，监听每次用户的请求：每次请求到达时
 * 如果是新用户，则向数据库中新插入一条记录
 * 如果是老用户，则更新数据库表中已有的记录
 * 改程序用于统计在线的用户数量
 * 
 */
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@WebListener


public class RequestListener implements ServletRequestListener {

	private final static Logger logger = Logger.getLogger(RequestListener.class);

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		HttpServletRequest request = (HttpServletRequest) arg0.getServletRequest();
		HttpSession session = request.getSession();
		//获取sessionId
		String sessionId = session.getId();
		String ip = request.getRemoteHost();
		String page = request.getRequestURI();
		String user = (String) session.getAttribute("user");
		
		//未登陆用户当做"游客"处理
		user = (user == null) ? "游客" : user;
		//从数据库表中查询该sessionId是否存在
		boolean flag = true;	//存在
		if(flag){
			//更新数据库表中的记录
		}else{
			//向数据库中新插入一条记录
		}
	}

	
	
}
