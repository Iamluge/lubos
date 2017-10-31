package com.lu.bos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lu.bos.dao.base.IFunctionDao;
import com.lu.bos.domain.Function;
import com.lu.bos.domain.User;
import com.lu.bos.service.IFunctionService;
import com.lu.bos.utils.BOSUtils;
import com.lu.bos.utils.PageBean;
@Service
@Transactional
public class FunctionServiceImpl implements IFunctionService{
	@Autowired
	private IFunctionDao functionDao;

	@Override
	public List<Function> findAll() {
		return functionDao.findAll();
	
	}

	@Override
	public void save(Function model) {
		Function parentFunction = model.getParentFunction();
		if(parentFunction != null && parentFunction.getId().equals("")){
			model.setParentFunction(null);
		}
		functionDao.save(model);
		
	}

	@Override
	public void pageQuery(PageBean pageBean) {
	functionDao.pageQuery(pageBean);
		
	}

	/*
	 * 根据当前登录用户查询菜单数据
	 */
	public List<Function> findMenu() {
		// TODO Auto-generated method stub
		List<Function> list=null;
		User user=BOSUtils.getUser();
		if(user.getUsername().equals("admin"))
		{
			//内置超级管理员
			list=functionDao.fundAllMenu();
		}else{
			//普通用户
			list=functionDao.findMenuByUserId(user.getId());
		}
		return list;
	}

}
