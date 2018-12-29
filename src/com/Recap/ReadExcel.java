package com.Recap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		//to read excel create FileInputStream object
		String xlFile="./TestData/credentials.xlsx";
		FileInputStream fis=new FileInputStream(xlFile);
		//create an object of workbook and load the file
		//HSSFWorkbook - .xls
		XSSFWorkbook workbook=new XSSFWorkbook(fis);//.xlsx
		//create an object of sheet
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		//create an object of row
		XSSFRow row = sheet.getRow(0);
		//create an object of cell
		XSSFCell cell = row.getCell(0);
		//get value of cell
		String value=cell.getStringCellValue();
//		System.out.println(value);
		System.out.println(row.getCell(0).getStringCellValue());
		System.out.println(row.getCell(1).getStringCellValue());
		
		XSSFRow row4 = sheet.getRow(3);
		System.out.println(row4.getCell(0).getStringCellValue());
		System.out.println(row4.getCell(1).getStringCellValue());

	}
}
