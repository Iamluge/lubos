package com.lu.bos.action;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lu.bos.domain.Region;
import com.lu.bos.service.IRegionService;
import com.lu.bos.utils.PageBean;
import com.lu.bos.utils.PinYin4jUtils;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@Scope("prototype")
public class RegionAction extends BaseAction<Region> {
	private File regionFile;
	@Autowired
	private IRegionService regionService;

	public File getRegionFile() {
		return regionFile;
	}

	public void setRegionFile(File regionFile) {
		this.regionFile = regionFile;
	}
	
	public String add() {
		regionService.save(model);
		return LIST;
	}

	public String importXls() throws FileNotFoundException, IOException {
		List<Region> regionList = new ArrayList<Region>();
		// 使用POI解析Excel文件
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(regionFile));
		// 根据名称获取的hidingsheet对象
		HSSFSheet hssfSheet = workbook.getSheet("Sheet1");
		for (Row row : hssfSheet) {
			int rowNum = row.getRowNum();
			if (rowNum == 0) {
				continue;
			}
			String id = row.getCell(0).getStringCellValue();
			String province = row.getCell(1).getStringCellValue();

			String city = row.getCell(2).getStringCellValue();

			String district = row.getCell(3).getStringCellValue();
			String postcode = row.getCell(4).getStringCellValue();
			// 包装一个区域对象
			Region region = new Region(id, province, city, district, postcode, null, null, null);
			regionList.add(region);
			province = province.substring(0, province.length() - 1);
			city = city.substring(0, city.length() - 1);
			district = district.substring(0, district.length() - 1);
			String info = province + city + district;
			String[] headByString = PinYin4jUtils.getHeadByString(info);
			String shortcode = StringUtils.join(headByString);
			// 城市编码
			String citycode = PinYin4jUtils.hanziToPinyin(city, "");
			region.setCitycode(citycode);
			region.setShortcode(shortcode);
			regionList.add(region);
			
		}
		regionService.saveBatch(regionList);
		return NONE;
	}
	
	
	/*
	 * 查询所有区域
	 */
	private String q;


	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public String listajax(){
		List< Region> list=null;
		if(StringUtils.isNotBlank(q))
		{
			list=regionService.findListByQ(q);
		}else{
			list=regionService.findAll();
		}
		this.java2Json(list, new String[]{"subareas"});
		return NONE;
	}
	/*
	 * 分页查询
	 */
	



	

	public String pageQuery() throws IOException{
	
		regionService.pageQuery(pageBean);
	this.java2Json(pageBean, new String[]{"currentPage","detachedCriteria","pageSize","subareas"});
		
		return NONE;
	}
	

		
	

}
