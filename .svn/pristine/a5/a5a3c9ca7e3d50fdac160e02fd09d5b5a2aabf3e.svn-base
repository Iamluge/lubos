package com.lu.bos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lu.bos.dao.IDecidedzoneDao;
import com.lu.bos.dao.ISubareaDao;
import com.lu.bos.domain.Decidedzone;
import com.lu.bos.domain.Subarea;
import com.lu.bos.service.IDecidedzoneService;
import com.lu.bos.utils.PageBean;

@Service
@Transactional
public class DecidedzoneServiceImpl implements IDecidedzoneService {
	@Autowired
	private IDecidedzoneDao decidedzoneDao;
	@Autowired
	private ISubareaDao subareaDao;

	/*
	 * 添加定区，同时关闭关联分区 (non-Javadoc)
	 * 
	 * @see com.lu.bos.service.IDecidedzoneService#save(com.lu.bos.domain.
	 * Decidedzone, java.lang.String[])
	 */
	public void save(Decidedzone model, String[] subareaid) {
		decidedzoneDao.save(model);
		for (String id : subareaid) {
			Subarea subarea = subareaDao.findById(id);
			subarea.setDecidedzone(model);// 分区关联定区
		}
	}

	@Override
	public void  pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		decidedzoneDao.pageQuery(pageBean);
	}

}
