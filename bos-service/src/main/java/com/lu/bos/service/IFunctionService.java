package com.lu.bos.service;

import java.util.List;

import com.lu.bos.domain.Function;
import com.lu.bos.utils.PageBean;

public interface IFunctionService {

public 	List<Function> findAll();

public void save(Function model);

public void pageQuery(PageBean pageBean);

public List<Function> findMenu();

}
