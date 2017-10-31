package com.lu.bos.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lu.bos.dao.ISubareaDao;
import com.lu.bos.domain.Subarea;
import com.lu.bos.service.ISubareaService;
import com.lu.bos.utils.PageBean;
@Service
@Transactional
public class SubareaServiceImpl implements ISubareaService {
	@Autowired
private ISubareaDao subareaDao;
	@Override
	public void save(Subarea model) {
		subareaDao.save(model);

	}
	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		subareaDao.pageQuery(pageBean);
	}
	@Override
	public List<Subarea> findAll() {
		// TODO Auto-generated method stub
		return subareaDao.findAll();
	}
	@Override
	public List<Subarea> findByNotAssociate() {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Subarea.class);
		//分区属性中decidedzone为null
		detachedCriteria.add(Restrictions.isNull("decidedzone"));
		return subareaDao.findByCriteria(detachedCriteria);
	}
	@Override
	public List<Subarea> findByDecidedzoneId(String decidedzoneId) {
	DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Subarea.class);
	detachedCriteria.add(Restrictions.eq("decidedzone.id",decidedzoneId ));
		return subareaDao.findByCriteria(detachedCriteria);
	}
	@Override
	public List<Object> findSubareaByProvince() {
		// TODO Auto-generated method stub
		return subareaDao.findSubareaByProvince();
	}

}
