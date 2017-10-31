package com.lu.bos.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.lu.bos.dao.base.IRoleDao;
import com.lu.bos.domain.Function;
import com.lu.bos.domain.Role;
import com.lu.bos.service.IRoleService;
import com.lu.bos.utils.PageBean;
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleDao roleDao;
	@Override
	public void save(Role model, String functionIds) {
		roleDao.save(model);
		if(StringUtils.isNoneBlank(functionIds))
		{
		String []funtionid=functionIds.split(",");
		for(String f:funtionid)
		{
			Function function=new Function(f);
			model.getFunctions().add(function);
		}
		}

	}
	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		roleDao.pageQuery(pageBean);
	}
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}

}
