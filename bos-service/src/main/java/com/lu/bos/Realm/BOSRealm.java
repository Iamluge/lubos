package com.lu.bos.Realm;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;

import com.lu.bos.dao.base.IFunctionDao;
import com.lu.bos.dao.base.IUserDao;
import com.lu.bos.domain.Function;
import com.lu.bos.domain.User;

public class BOSRealm  extends AuthorizingRealm{

	@Autowired
	private IUserDao userDao;
	@Autowired
	private IFunctionDao functionDao;
	@Override
	//授权方法
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//获取当前用户
		User user=(User) SecurityUtils.getSubject().getPrincipal();
		//根据当前用户查询数据库，获取 对应权限
		List<Function> list=null;
		if(user.getUsername().equals("admin"))
		{
			DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Function.class);
			//超级管理员为内置用户，拥有所有权限
			list=functionDao.findByCriteria(detachedCriteria);	
		}else{
			list=functionDao.findListByUserId(user.getId());
		}
		for(Function function:list)
		{
			info.addStringPermission(function.getCode());
		}
		//info.addStringPermission("staff-list");
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("自定义的realm中认证方法执行了。。。。");
		UsernamePasswordToken passwordToken = (UsernamePasswordToken)token;
		//获得页面输入的用户名
		String username = passwordToken.getUsername();
		//根据用户名查询数据库中的密码
		User user = userDao.findUserByUsername(username);
		if(user == null){
			//页面输入的用户名不存在
			return null;
		}
		//简单认证信息对象
		AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
		//框架负责比对数据库中的密码和页面输入的密码是否一致
		return info;
	}

}
