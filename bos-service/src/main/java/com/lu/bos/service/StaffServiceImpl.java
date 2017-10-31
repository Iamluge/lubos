package com.lu.bos.service;

import java.util.List;


import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lu.bos.dao.IStaffDao;
import com.lu.bos.domain.Staff;
import com.lu.bos.utils.PageBean;

@Service
@Transactional
public class StaffServiceImpl implements IStaffService {
	@Autowired
	private IStaffDao staffDao;
	

	@Override
	public void save(Staff model) {
		// TODO Auto-generated method stub
		staffDao.save(model);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		staffDao.pageQuery(pageBean);

	}

	@Override
	public void deleteBacth(String ids) {
		if (StringUtils.isNotBlank(ids)) {
			String[] staffids = ids.split(",");
			for (String id : staffids) {
				staffDao.executeUpdate("staff.delete", id);
			}
		}
	}

	@Override
	public Staff findById(String id) {
		
		return staffDao.findById(id);
	}

	@Override
	public void update(Staff staff) {
		// TODO Auto-generated method stub
		staffDao.update(staff);
		
	}

	@Override
	public void recoverBatch(String ids) {
		
		if (StringUtils.isNotBlank(ids)) {
			String[] staffids = ids.split(",");
			for (String id : staffids) {
				staffDao.executeUpdate("staff.recover", id);
			}
		}
		
	}

	@Override
	public List<Staff> findListNotDelete() {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Staff.class);
		detachedCriteria.add(Restrictions.eq("deltag", "0"));
		return staffDao.findByCriteria(detachedCriteria);
	}

}
