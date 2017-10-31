package com.lu.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lu.bos.dao.base.IUserDao;
import com.lu.bos.domain.Role;
import com.lu.bos.domain.User;
import com.lu.bos.utils.MD5Utils;
import com.lu.bos.utils.PageBean;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;

	/***
	 * 用户登录
	 */
	public User login(User user) {
		// 使用MD5加密密码
		String password = MD5Utils.md5(user.getPassword());
		return userDao.findUserByUsernameAndPassword(user.getUsername(), password);
	}

	@Override
	public void editPassword(String id, String password) {
		// TODO Auto-generated method stub
		password = MD5Utils.md5(password);
		userDao.executeUpdate("user.editpassword", password, id);

	}

	@Override
	/*
	 * 添加用户 (non-Javadoc)
	 * 
	 * @see com.lu.bos.service.impl.IUserService#save(com.lu.bos.domain.User,
	 * java.lang.String)
	 */
	public void save(User user, String[] roleIds) {
		String password = user.getPassword();
		password = MD5Utils.md5(password);
		user.setPassword(password);
		userDao.save(user);
		if (roleIds != null && roleIds.length > 0) {
			for (String roleid : roleIds) {
				Role role = new Role(roleid);
				user.getRoles().add(role);
			}
		}

	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		userDao.pageQuery(pageBean);

	}

}
