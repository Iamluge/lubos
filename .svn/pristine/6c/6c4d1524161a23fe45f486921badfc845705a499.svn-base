package com.lu.bos.dao.base.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lu.bos.dao.base.IFunctionDao;
import com.lu.bos.domain.Function;

@Repository
public class FunctionDaoImpl extends BaseDaoImpl<Function> implements IFunctionDao{
	
	//TODO 这里有一个页面显示不了的问题待解决
	
	public List<Function> findAll() {
		String hql = "FROM Function f WHERE f.parentFunction IS NULL";
		List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql);
		return list;
	}

	@Override
	public List<Function> findListByUserId(String id) {
		String hql="SELECT DISTINCT f FROM Function f LEFT OUTER JOIN f.roles"
				+ " r LEFT OUTER JOIN r.users u WHERE u.id = ?";
		List<Function> list=(List<Function>) this.getHibernateTemplate().find(hql, id);
		return list;
	}

	@Override
	public List<Function> fundAllMenu() {
	String hql="FROM Function f WHERE f.generatemenu='1' ORDER BY f.zindex DESC";
	List<Function> list=(List<Function>) this.getHibernateTemplate().find(hql);	
	return list;
	}

	@Override
	public List<Function> findMenuByUserId(String id) {
		String hql="SELECT DISTINCT f FROM Function f LEFT OUTER JOIN f.roles"
				+ " r LEFT OUTER JOIN r.users u WHERE u.id = ? AND  f.generatemenu='1' ORDER BY f.zindex DESC";		
		List<Function> list=(List<Function>) this.getHibernateTemplate().find(hql,id);
		return list;
	}
	

}
