package com.lu.bos.service;

import java.util.List;

import com.lu.bos.domain.Subarea;
import com.lu.bos.utils.PageBean;

public interface ISubareaService {

	public void save(Subarea model);

	public void pageQuery(PageBean pageBean);

	public List<Subarea> findAll();

	public List<Subarea> findByNotAssociate();

	public List<Subarea> findByDecidedzoneId(String decidedzoneId);

	public List<Object> findSubareaByProvince();

}
