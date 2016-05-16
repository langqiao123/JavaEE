package org.langqiao.action;

import org.apache.log4j.Logger;
import org.langqiao.model.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.PreResultListener;

/**
 * 登录
 */
public class LoginRegisterAction implements Action{

	private static final long serialVersionUID = 1L;
	
	private final static Logger logger = Logger.getLogger(LoginRegisterAction.class);
	private User user;
	private String username;           //用户名  
    private String password;           //密码  
    private String tip;                //封装结果  
      
    public String getUsername() {  
        return username;  
    }  
    public void setUsername(String username) {  
        this.username = username;  
    }  
    public String getPassword() {  
        return password;  
    }  
    public void setPassword(String password) {  
        this.password = password;  
    }  
    public String getTip() {  
        return tip;  
    }  
    public void setTip(String tip) {  
        this.tip = tip;  
    }  
      
    //Action包含的注册控制逻辑  
    public String regist(){  
        ActionContext.getContext().getSession().put("user", getUsername());  
        return SUCCESS;  
    }  
      
    //Action包含的登陆控制逻辑  
    public String login(){  
        ActionInvocation actionInvocation = ActionContext.getContext().getActionInvocation();  
        //可以作为日志的实现方式
        actionInvocation.addPreResultListener(new PreResultListener(){  
            public void beforeResult(ActionInvocation action,String resultCode){  
                System.out.println("返回的逻辑视图名字为:"+resultCode);  
                //在返回resultCode之前加入一个额外的数据  
                action.getInvocationContext().put("extra", new java.util.Date()+"由"+resultCode+"逻辑视图转入");  
                }  
        });  
        if(user.getUsername().equals("langqiao")&&user.getPassword().equals("langqiao")){  
            ActionContext.getContext().getSession().put("user", user.getUsername());  
            setTip("欢迎,"+user.getUsername()+",您已经成功登陆！");  
            return SUCCESS;  
        }  
        else {  
            return ERROR;  
        }  
    }
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}  
}  
