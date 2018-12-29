package com.syntax.orangehrm.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*
 * This class will handle all excel operations
 */
public class ExcelUtility {

	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	/* 
	 * This method will open excel file and get the sheet
	 */
	public void openExcel(String xlPath, String sheetName) {
		try {
			fis = new FileInputStream(xlPath);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/* 
	 * This method will return value from specify column and cell
	 */
	public String getExcelData(int rowNum, int cellNum) {
		String cellValue=sheet.getRow(rowNum).getCell(cellNum).toString();
		return cellValue;
	}

	public int rowCount() {
		int rowNum=sheet.getLastRowNum();
		return rowNum;
	}
	
	public int columnCount() {
		return sheet.getRow(0).getLastCellNum();
	}
}
