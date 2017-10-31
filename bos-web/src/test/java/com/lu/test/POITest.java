package com.lu.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

public class POITest {
	//@Test
	public void test() throws FileNotFoundException, IOException {
		String filePath = "E:\\BaiduYunDownload\\han\\javaweb32\\11、物流BOS系统\\BOS-day05\\BOS-day05\\资料\\区域导入测试数据.xls";
		// 包装一个Excel文件对象
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File(filePath)));
		// 读取文件中第一个sheet标签页
		HSSFSheet hssfSheet = workbook.getSheetAt(0);
		// 遍历标签页中的所有行
		for (Row row : hssfSheet) {
			System.out.println();
			for (Cell cell : row) {
				System.out.print(cell.getStringCellValue() + " ");
			}
		}
	}
}
