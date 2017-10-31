package com.lu.bos.dao.base.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lu.bos.dao.ISubareaDao;
import com.lu.bos.domain.Subarea;
@Repository
public class SubareaDaoImpl  extends BaseDaoImpl<Subarea> implements ISubareaDao{

	@Override
	public List<Object> findSubareaByProvince() {
		String hql="SELECT r.province ,count(*) FROM Subarea s LEFT OUTER JOIN s.region r Group BY r.province";
		return (List<Object>) this.getHibernateTemplate().find(hql);
	}

}
