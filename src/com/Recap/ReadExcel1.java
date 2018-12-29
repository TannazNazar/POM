package com.Recap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel1 {

	public static void main(String[] args) throws IOException {
		String xlFile="./TestData/credentials.xlsx";
		FileInputStream fis=new FileInputStream(xlFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		//get value from 1 row
		sheet.getRow(0).getCell(0).getStringCellValue();
		sheet.getRow(0).getCell(1).getStringCellValue();
		//get value from 2 row
		sheet.getRow(1).getCell(0).getStringCellValue();
		String value = sheet.getRow(1).getCell(2).toString();
		System.out.println(value);
		//find out number of rows and colums
		int rowNum = sheet.getLastRowNum();//gets index of last row
		rowNum=rowNum+1;
		int colNum=sheet.getRow(0).getLastCellNum();//gets index of lastCell in 1 row
													//+1 is added by default
		for(int i=0; i<rowNum; i++) {
			for (int j=0; j<colNum; j++) {
				String cellValue=sheet.getRow(i).getCell(j).toString();
				System.out.println(cellValue);
			}
		}
	}
}
