package com.lu.bos.interceptor;

import org.aopalliance.intercept.Invocation;
import org.apache.struts2.ServletActionContext;

import com.lu.bos.domain.User;
import com.lu.bos.utils.BOSUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/*
 * 自定义拦截器，实现用户未登录自动跳转到登录页面
 */
public class BOSLoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		User user = BOSUtils.getUser();
		if(user==null)
		{
			return "login";
		}
		//放行
		return invocation.invoke();
	}

}
