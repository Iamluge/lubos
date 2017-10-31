package com.lu.bos.service;

import java.util.List;

import com.lu.bos.domain.Staff;
import com.lu.bos.utils.PageBean;

public interface IStaffService {

public	void save(Staff model);

public void pageQuery(PageBean pageBean);

public void deleteBacth(String ids);

public Staff findById(String id);

public void update(Staff staff);

public void recoverBatch(String ids);

public List<Staff> findListNotDelete();

}
