﻿package com.lu.bos.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.lu.bos.domain.User;
import com.lu.bos.utils.PageBean;

/*
 * 持久层通用接口test一下
 */
public interface IBaseDao<T> {
	public void save(T entity);
	public void saveOrUpdate(T entity);
public List<T> findByCriteria(DetachedCriteria detachedCriteria);
	public void delete(T entity);

	public void update(T entity);

	public T findById(Serializable entity);

	public List<T> findAll();

	public void executeUpdate(String queryname, Object... objects);

	public void pageQuery(PageBean pagebean);
}
