package com.lu.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lu.bos.dao.base.IWorkordermanageDao;
import com.lu.bos.domain.Workordermanage;
import com.lu.bos.service.IWorkordermanageService;

@Service
@Transactional
public class WorkordermanageServiceImpl implements IWorkordermanageService {

	@Autowired
	private IWorkordermanageDao workordermanageDao;

	public void save(Workordermanage model) {
		workordermanageDao.save(model);
	}
}
