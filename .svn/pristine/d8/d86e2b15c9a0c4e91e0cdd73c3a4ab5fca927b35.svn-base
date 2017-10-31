package com.lu.bos.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lu.bos.domain.Region;
import com.lu.bos.domain.Subarea;
import com.lu.bos.service.ISubareaService;
import com.lu.bos.utils.FileUtils;
import com.lu.bos.utils.PageBean;
@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<Subarea>{
	@Resource
	private ISubareaService subareaService;
	/**
	 * 添加分区
	 */
	public String add(){
		subareaService.save(model);
		return LIST;
	}
	
	/*
	 * 为饼状图提供数据
	 */
	public String findSubareaByProvince(){
		List<Object> lsit=subareaService.findSubareaByProvince();
		this.java2Json(lsit, new String[]{});
		return NONE;
	}
	
	/*
	 * 分页查询
	 */
	public String pageQuery(){
		DetachedCriteria dCriteria=pageBean.getDetachedCriteria();
		//动态添加过滤条件
		String addresskey=model.getAddresskey();
		if(StringUtils.isNotBlank(addresskey))
		{
			//添加过滤条件，根据地址关键字模糊查询
			dCriteria.add(Restrictions.like("addresskey", "%"+addresskey+"%"));
			
		}
		Region region=model.getRegion();
		if(region!=null)
		{
			String province=region.getProvince();
			String city=region.getCity();
			String district=region.getDistrict();
			dCriteria.createAlias("region","r");
			if(StringUtils.isNotBlank(province))
			{
				//添加过滤条件，根据省份模糊查询---多表关联查询。使用别名方式实现
				//参数一：分区对象中关联的区域对象属性名称
				//参数二：别名
				dCriteria.add(Restrictions.like("r.province", "%"+province+"%"));
				
			}
			if(StringUtils.isNotBlank(city))
			{
				//添加过滤条件，根据省份模糊查询---多表关联查询。使用别名方式实现
				//参数一：分区对象中关联的区域对象属性名称
				//参数二：别名
				dCriteria.add(Restrictions.like("r.city", "%"+city+"%"));
				
			}
			if(StringUtils.isNotBlank(district))
			{
				//添加过滤条件，根据省份模糊查询---多表关联查询。使用别名方式实现
				//参数一：分区对象中关联的区域对象属性名称
				//参数二：别名
				dCriteria.add(Restrictions.like("r.district", "%"+district+"%"));
				
			}
			
		}
		
		subareaService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[]{"currentPage","detachedCriteria","pageSize","decidedzone","subareas"});
		return NONE;
	}
	//导出数据
	public String exportXls() throws IOException{
		//1、查询所有分区数据
		List<Subarea> list=subareaService.findAll();
		//2、使用POI将数据写到Excel文件中
		//在内存中创建一个Excel文件
		HSSFWorkbook hssfWorkbook=new HSSFWorkbook();
		//创建标签页
		HSSFSheet sheet=hssfWorkbook.createSheet("分区数据");
		//穿件标题行
		HSSFRow headRow=sheet.createRow(0);
		headRow.createCell(0).setCellValue("分区编号");
		headRow.createCell(1).setCellValue("开始编号");
		headRow.createCell(2).setCellValue("结束编号");
		headRow.createCell(3).setCellValue("位置信息");
		headRow.createCell(4).setCellValue("省市区");
		
		for( Subarea subarea:list)
		{
			HSSFRow dataRow=sheet.createRow(sheet.getLastRowNum()+1);
			
			dataRow.createCell(0).setCellValue(subarea.getId());
			dataRow.createCell(1).setCellValue(subarea.getStartnum());
			dataRow.createCell(2).setCellValue(subarea.getEndnum());
			dataRow.createCell(3).setCellValue(subarea.getPosition());
			dataRow.createCell(4).setCellValue(subarea.getRegion().getName());
		}
		//使用输出流进行文件下载
		String filename="分区数据.xls";
		String contentType=ServletActionContext.getServletContext().getMimeType(filename);
		
		ServletOutputStream outputStream=ServletActionContext.getResponse().getOutputStream();
		ServletActionContext.getResponse().setContentType(contentType);
		
		//获取客户端浏览器类型
		String agent=ServletActionContext.getRequest().getHeader("User-Agent");
		filename=FileUtils.encodeDownloadFilename(filename, agent);
		ServletActionContext.getResponse().setHeader("content-disposition", "attachment;filename="+filename);
		
		hssfWorkbook.write(outputStream);
		return NONE;
	}
	
	public String listajax()
	{
		List<Subarea> list=subareaService.findByNotAssociate();
		this.java2Json(list, new String[]{"region","decidedzone"});
		return NONE;
	}
	
	private String decidedzoneId;
	
	public String findByDecidedzoneId(){
		List<Subarea> list=subareaService.findByDecidedzoneId(decidedzoneId);
		this.java2Json(list, new String[]{"decidedzone","subareas"});
		return NONE;
	}
	
	public String getDecidedzoneId() {
		return decidedzoneId;
	}
	public void setDecidedzoneId(String decidedzoneId) {
		this.decidedzoneId = decidedzoneId;
	}
}
