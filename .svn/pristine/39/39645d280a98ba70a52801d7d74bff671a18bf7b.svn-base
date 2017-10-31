package com.lu.bos.dao.base.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lu.bos.dao.IRegionDao;
import com.lu.bos.domain.Region;
import com.lu.bos.utils.PageBean;
@Repository
public class RegionDaoImpl extends BaseDaoImpl<Region> implements IRegionDao {

	/*
	 * 根据q进行模糊查询
	 * (non-Javadoc)
	 * @see com.lu.bos.dao.IRegionDao#findListByQ(java.lang.String)
	 */
	public List<Region> findListByQ(String q) {
		String hql="FROM Region r WHERE r.shortcode LIKE ? "
				+ "	OR r.citycode LIKE ? OR r.province LIKE ? "
				+ "OR r.city LIKE ? OR r.district LIKE ?";
		List<Region> list = (List<Region>) this.getHibernateTemplate().
				find(hql, "%"+q+"%","%"+q+"%","%"+q+"%","%"+q+"%","%"+q+"%");
		return list;
	}

}
