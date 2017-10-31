package com.lu.bos.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lu.bos.domain.Role;
import com.lu.bos.service.IRoleService;
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
private String functionIds;

public String getFunctionIds() {
	return functionIds;
}

public void setFunctionIds(String functionIds) {
	this.functionIds = functionIds;
}
@Autowired
private IRoleService roleService;
public String add(){
	roleService.save(model,functionIds);
	return LIST;
} 
public String pageQuery(){
	roleService.pageQuery(pageBean);
	this.java2Json(pageBean, new String[]{"functions","users"});
	return NONE;
}
public String listajax(){
List<Role> list=roleService.findAll();
this.java2Json(list, new String[]{"functions","users"});
	return NONE;
}
}
