package com.lu.bos.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lu.bos.domain.Function;
import com.lu.bos.service.IFunctionService;
@Controller
@Scope("prototype")
public class FunctionAction  extends BaseAction<Function>{
	@Autowired
private IFunctionService functionService;
public String listajax(){
	List<Function> list=functionService.findAll();
	this.java2Json(list, new String[]{"parentFunction","roles"});
	return NONE;
}

public String add(){
	if(model.getParentFunction().equals("")&&model.getParentFunction()!=null)
	{
		model.setParentFunction(null);
	}
	functionService.save(model);
	return LIST;
}
public String pageQuery(){
	pageBean.setCurrentPage(Integer.parseInt(model.getPage()));
	functionService.pageQuery(pageBean);
	this.java2Json(pageBean, new String[]{"parentFunction","roles","children"});
	return NONE;
}


public String findMenu(){
	List<Function> list=functionService.findMenu();
	this.java2Json(list, new String[]{"parentFunction","roles","children"});	
	return NONE;
}
}
