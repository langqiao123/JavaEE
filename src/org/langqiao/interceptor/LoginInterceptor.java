package org.langqiao.interceptor;

import java.util.Map;  

import com.opensymphony.xwork2.Action;  
import com.opensymphony.xwork2.ActionContext;  
import com.opensymphony.xwork2.ActionInvocation;  
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;  
public class LoginInterceptor extends AbstractInterceptor {  
	private static final long serialVersionUID = 6479784572996849942L;

	@Override  
    public String intercept(ActionInvocation invocation) throws Exception {  
        // 取得请求相关的ActionContext实例  
        ActionContext ctx = invocation.getInvocationContext();  
        Map session = ctx.getSession();  
        String user = (String) session.get("username");  
  
        // 如果没有登陆，即用户名不存在，都返回重新登陆  
        System.out.println("user:"+user);
        if (user != null) {  
            System.out.println("test");  
            return invocation.invoke();  
        }  
        System.out.println("你还没有登录"); 
        ctx.put("tip", "你还没有登录");  
        return Action.LOGIN;    //返回一个叫login的result结果
    }  
}  