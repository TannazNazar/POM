package com.Recap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateSheetEnterValues {

	public static void main(String[] args) throws IOException {
		/*open existing excel file, create new sheet and add headers:
		 * 1. Employee Name 2. Leave Type 3. FromDate 4. ToDate 5. Comment
		 */
		String xl="./TestData/OrangeHRMData.xlsx";
		FileInputStream fis=new FileInputStream(xl);
		//to read excel we have xssfworkbook(.xlsx) class and hssfworkbook(.xls) class
		
		XSSFWorkbook book = new XSSFWorkbook();
		XSSFSheet sheet = book.createSheet("AssignLeave");
		
		sheet.createRow(0).createCell(0).setCellValue("EmployeeName");
		XSSFRow row = sheet.getRow(0);
		row.createCell(1).setCellValue("LeaveType");
		row.createCell(2).setCellValue("FromDate");
		row.createCell(3).setCellValue("ToDate");
		row.createCell(4).setCellValue("Comment");
		
		FileOutputStream fos=new FileOutputStream(xl);
		book.write(fos);
		book.close();
		fos.close();
		System.out.println("I am done");
	}
}
