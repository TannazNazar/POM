package com.Recap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	
	public static void main(String[] args) throws IOException {
		String xlPath = "./TestData/credentials.xlsx";
		FileInputStream fis=new FileInputStream(xlPath);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		//write values into existing row
		sheet.getRow(1).createCell(4).setCellValue("pass");
		sheet.getRow(2).createCell(4).setCellValue("fail");
		//create new row and cell 
		sheet.createRow(7).createCell(0).setCellValue("admin7");
		
		FileOutputStream fos=new FileOutputStream(xlPath);
		
		wb.write(fos);
		wb.close();
	}
}
