package cn.yq.ssh.test;

import java.io.File;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class POITest {
	
	//使用POI创建一个Excel 并保存到本地成 excel文件
	public static void main(String[] args) {
		
		//1.创建一个工作书
		HSSFWorkbook book = new HSSFWorkbook(); 
		
		//2.创建一个sheet
		HSSFSheet sheet = book.createSheet();
		
		//3.创建一行 ,行的索引，从0开始
		HSSFRow row = sheet.createRow(0);
		
		//4.通过行创建单元格,单元格的索引，从0开始
		//HSSFCell cell1 = row.createCell(0);
		//5.设置单元格的内容
		//cell1.setCellValue("姓名");
		
		row.createCell(0).setCellValue("姓名");
		row.createCell(1).setCellValue("密码");
		row.createCell(2).setCellValue("邮箱");
		
		HSSFRow row1 = sheet.createRow(1);
		
		row1.createCell(0).setCellValue("张三");
		row1.createCell(1).setCellValue("zhangsan");
		row1.createCell(2).setCellValue("zhangsan@qq.com");
		
		//将POI创建的Excel工作集保存到本地成 excel文件 xlsx
		
		try {
			book.write(new File("d:/用户信息.xlsx"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
