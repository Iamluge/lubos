package com.lu.bos.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lu.bos.domain.Noticebill;
import com.lu.bos.service.INoticebillService;
import com.lu.crm.domain.Customer;
import com.lu.crm.domain.ICustomerService;

@Controller
@Scope("prototype")
public class NoticebillAction extends BaseAction<Noticebill> {
	@Autowired
	private ICustomerService iCustomerService;
	public String findCustomerByTelephone(){
		String telephone=model.getTelephone();
		Customer customer=iCustomerService.findCustomerByTelephone(telephone);
		this.java2Json(customer, new String[]{});
		return NONE;
	}

	@Autowired
	private INoticebillService noticebillService;
	public String add(){
	System.out.println(model.getPickaddress()+"I am here");
		noticebillService.save(model);
		return "noticebill_add";
	}
}
