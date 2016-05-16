package org.langqiao.action;

import org.apache.log4j.Logger;
import org.langqiao.model.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

/**
 * 登录
 */
public class LoginAction implements Action{

	private static final long serialVersionUID = 1L;
	private final static Logger logger = Logger.getLogger(LoginAction.class);
	private User user;

	public String execute(){	
		ActionContext ctx = ActionContext.getContext();
		Integer counter = (Integer) ctx.getApplication().get("counter");
		if(counter == null){
			counter = 1;
		}else {
			counter = counter + 1;
		}
		ctx.getApplication().put("counter", counter);
		ctx.getSession().put("user", getUser().getUsername());
		if(getUser().getUsername().equals("langqiao") && getUser().getPassword().equals("langqiao")){
			ctx.put("tip", "服务器提示，您已成功登陆！");
			return SUCCESS;
		}else{
			ctx.put("tip", "服务器提示，您已成功登陆！");
			return ERROR;
		}
	}
	
	public String login(){	
		ActionContext ctx = ActionContext.getContext();
		Integer counter = (Integer) ctx.getApplication().get("counter");
		if(counter == null){
			counter = 1;
		}else {
			counter = counter + 1;
		}
		ctx.getApplication().put("counter", counter);
		ctx.getSession().put("user", getUser().getUsername());
		if(getUser().getUsername().equals("langqiao") && getUser().getPassword().equals("langqiao")){
			ctx.put("tip", "服务器提示，您已成功登陆！");
			return SUCCESS;
		}else{
			ctx.put("tip", "服务器提示，您已成功登陆！");
			return ERROR;
		}
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
