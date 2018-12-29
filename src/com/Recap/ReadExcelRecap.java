package com.Recap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelRecap {

	public static void main(String[] args) throws IOException {
		String xlPath = "./TestData/credentials.xlsx";
		FileInputStream fis = new FileInputStream(xlPath);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		// to print all values I need to get count of all rows and cols
		int rows = sheet.getLastRowNum();//returns index of last row=6
		int cols = sheet.getRow(0).getLastCellNum();//return index of last column +1=4

		for (int i = 0; i <=rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.println(sheet.getRow(i).getCell(j).toString());
			}
		}
	}
}