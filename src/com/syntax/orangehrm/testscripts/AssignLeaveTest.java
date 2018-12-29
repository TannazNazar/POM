package com.syntax.orangehrm.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.orangehrm.pages.AssignLeave;
import com.syntax.orangehrm.pages.DashboardPage;
import com.syntax.orangehrm.pages.LoginPage;
import com.syntax.orangehrm.utils.BaseClass;
import com.syntax.orangehrm.utils.CommonMethods;
import com.syntax.orangehrm.utils.Constants;
import com.syntax.orangehrm.utils.ExcelUtility;

public class AssignLeaveTest extends BaseClass{

	@BeforeMethod
	public void start() {
		setUp();
		LoginPage login=new LoginPage();
		login.doLogin(prop.getProperty("userName"), prop.getProperty("password"));
		
		DashboardPage dashboard=new DashboardPage();
		dashboard.clickAssignLeave();
	}
	
	@Test(dataProvider="AssignLeave")
	public void assignEmployeeLeave(String empName, String leaveType, String fromDate, String toDate, String comment) throws InterruptedException {
		System.out.println(fromDate);
		System.out.println(toDate);
		AssignLeave leave=new AssignLeave();
		CommonMethods.enterValue(leave.empName, empName);
		CommonMethods.selectValue(leave.ddLeaveType, leaveType);
		CommonMethods.enterValue(leave.fromDate, fromDate);
		CommonMethods.enterValue(leave.toDate, toDate);
		CommonMethods.enterValue(leave.comment, comment);
		CommonMethods.click(leave.btnAssign);
		Thread.sleep(5000);
	}
	@DataProvider(name="AssignLeave")
	public Object[][] getData(){
		ExcelUtility excel=new ExcelUtility();
		excel.openExcel(Constants.excelPath, "AssignLeave");
		int rows=excel.rowCount();
		int cols=excel.columnCount();
		Object[][] data=new Object[rows][cols];

		for(int x=1; x<rows; x++) {
			for(int y=0; y<cols; y++) {
				String cellValue=excel.getExcelData(x, y);
				data[x-1][y]=cellValue;
//				data[0][0]="Linda Anderson";
//				data[0][1]="FMLA US";
//				data[0][2]="12/12/2018";
//				//2 row
//				data[1][0]="John";
			}
		}
		return data;
	}
	
	@AfterMethod
	public void close() {
		tearDown();
	}
}
