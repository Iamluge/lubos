package com.lu.bos.service;

import java.util.List;

import com.lu.bos.domain.Region;
import com.lu.bos.utils.PageBean;

public interface IRegionService {

	public void saveBatch(List<Region> regionList);

	public void pageQuery(PageBean pageBean);

	public List<Region> findAll();

	

	public List<Region> findListByQ(String q);

	public void save(Region model);

}