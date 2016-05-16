package org.langqiao.listener;

/**
 * 监听器，监听session的创建和销毁
 * 改程序用于统计在线的用户数量
 * 
 */
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

@WebListener
public class SessionListener implements HttpSessionListener {

	private final static Logger logger = Logger.getLogger(SessionListener.class);

	//用户与服务器的会话开始、创建时触发该方法
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		ServletContext application = session.getServletContext();
		//获取sessionId
		String sessionId = session.getId();
		//如果是一次新的 会话
		if(session.isNew()){
			String user = (String) session.getAttribute("user");
			//未登陆用户当做"游客"处理
			user = (user == null) ? "游客" : user;
			Map<String, String> online = (Map<String, String>) application.getAttribute("online");
			if(online == null){
				online = new HashMap<String, String>();
			}
			online.put(sessionId, user);
			application.setAttribute("online", online);
		}
	}

	//用户与服务器的会话断开、销毁时触发该方法
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		ServletContext application = session.getServletContext();
		//获取sessionId
		String sessionId = session.getId();
		//如果是一次新的 会话
		Map<String, String> online = (Map<String, String>) application.getAttribute("online");
		if(online != null){
			//删除该用户的在线信息
			online.remove(sessionId);
		}
		application.setAttribute("online", online);
	}
	
	
}
