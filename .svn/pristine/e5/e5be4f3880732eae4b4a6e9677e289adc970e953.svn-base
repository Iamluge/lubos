package com.lu.bos.utils;
/*
 * 写一个工具类用以获取session和登录的用户
 */

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lu.bos.domain.User;

public class BOSUtils {
	//获取session
	public static HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}
	//获取user
	public  static User getUser(){
		return (User)getSession().getAttribute("loginUser");
		
	}

}
