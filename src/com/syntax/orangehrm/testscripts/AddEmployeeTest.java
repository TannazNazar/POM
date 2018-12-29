package com.syntax.orangehrm.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.orangehrm.pages.AddEmployee;
import com.syntax.orangehrm.pages.LoginPage;
import com.syntax.orangehrm.utils.BaseClass;
import com.syntax.orangehrm.utils.CommonMethods;
import com.syntax.orangehrm.utils.ExcelUtility;

public class AddEmployeeTest extends BaseClass {
	/*As an admin I should be able to add and create login credentials for 5 employees
	1. Store data in excel file
	2. Read data from excel and load into DataProvider
	3. Using DataProvider supply test case
	*/
	@BeforeMethod
	public void start() {
		setUp();
	}
	/*
	 * Using dataProvider pass values into test
	 */
	@Test(dataProvider="Employee Details")
	public void addingEmployee(String fName, String lName, String uName, String pwd) {
		LoginPage login = new LoginPage();
		login.doLogin("admin", "admin123");
		CommonMethods.clickLink("PIM");
		CommonMethods.clickLink("Add Employee");
		AddEmployee employee = new AddEmployee();
		CommonMethods.enterValue(employee.firstName, fName);
		CommonMethods.enterValue(employee.lastName, lName);
		CommonMethods.click(employee.chxLoginDetails);
		CommonMethods.enterValue(employee.userName, uName);
		CommonMethods.enterValue(employee.password, pwd);
		CommonMethods.enterValue(employee.confPwd, pwd);
		CommonMethods.click(employee.btnSave);
	}

	@DataProvider(name="Employee Details")
	public Object[][] getData(){
		/*Open excel
		 * get count of rows and colums
		 * loop through all rows and colums and get value of each cell
		 * value from each cell will store into Object[][]
		 */
		ExcelUtility obj=new ExcelUtility();
		obj.openExcel("./TestData/OrangeHRMData.xlsx", "AddEmployee");
		
		int rows=obj.rowCount();
		int cols=obj.columnCount();
		
		Object[][] data=new Object[rows][cols];

		for(int i=1; i<=rows; i++) {
			for (int j=0; j<cols; j++) {
				String value=obj.getExcelData(i, j);
				data[i-1][j]=value;
			}
		}
		return data;
	}
	
	@AfterMethod
	public void finish() {
		tearDown();
	}
}
