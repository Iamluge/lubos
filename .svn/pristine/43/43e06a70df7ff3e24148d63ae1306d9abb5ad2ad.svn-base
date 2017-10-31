package com.lu.bos.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lu.bos.domain.Decidedzone;
import com.lu.bos.service.IDecidedzoneService;
import com.lu.crm.domain.Customer;
import com.lu.crm.domain.ICustomerService;

@Controller
@Scope("prototype")
public class DecidedzoneAction extends BaseAction<Decidedzone>{
private String []subareaid;

public String[] getSubareaid() {
	return subareaid;
}

public void setSubareaid(String[] subareaid) {
	this.subareaid = subareaid;
}
/*
 * 远程调用crm服务，获取关联和未关联的客户
 */

@Autowired
private ICustomerService proxy; 
public String findListNotAssociation(){
	List<Customer> list=proxy.findListNotAssociation();
	this.java2Json(list, new String[]{});
	return NONE;
}

public String findListHasAssociation(){
	String id=model.getId();
	List<Customer> list=proxy.findListHasAssociation(id);
	this.java2Json(list, new String[]{});
	return NONE;
}
private List<Integer> customerIds;


public List<Integer> getCustomerIds() {
	return customerIds;
}

public void setCustomerIds(List<Integer> customerIds) {
	this.customerIds = customerIds;
}

public String assigncustomerstodecidedzone(){
	proxy.assigncustomerstodecidedzone(model.getId(),customerIds);
	
	return LIST;
}
@Autowired
private IDecidedzoneService decidezoneService;
/*
 * 添加定区
 */
public String add(){
	decidezoneService.save(model,subareaid);
	return LIST;
}
public  String pageQuery(){
decidezoneService.pageQuery(pageBean);
	this.java2Json(pageBean, new String[]{"currentPage","detachedCriteria",
			"pageSize","subareas","decidedzones"});
	return NONE;
}

}
