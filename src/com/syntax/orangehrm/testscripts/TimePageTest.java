package com.syntax.orangehrm.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.syntax.orangehrm.pages.DashboardPage;
import com.syntax.orangehrm.pages.LoginPage;
import com.syntax.orangehrm.pages.TimePage;
import com.syntax.orangehrm.utils.BaseClass;

public class TimePageTest extends BaseClass {
	/*
	 * US31435 - As an admin I should be able to navigate to timeshseets and view
	 * time card for given employee and if employee dont have submitted timesheet I
	 * should see "No Timesheets Found" error message.
	 * 
	 * ALM -to create test cases, XL TC35622- Verify "No Timesheets Found" error
	 * message is dislayed when there is no time card for given employee Test Steps:
	 * Step1: open browser and navigate to
	 * "https://opensource-demo.orangehrmlive.com/" Step2: login with valid
	 * credentilas Step3: click on timesheet icon, enter employee name and click
	 * view
	 * 
	 * Expected result: "No Timesheets Found" error message should be displayed
	 ********************************************************************************
	 *US31436 - As an admin I should be able to navigate to timeshseets 
	 *and when I do not provide any employee name and I click on View 
	 *I should receive "required" error message next to employee name field
	 ***********************************************************************************/
	//break till 12:35
	TimePage time;
	
	@BeforeMethod
	public void start() {
		setUp();
		LoginPage login = new LoginPage();
		login.doLogin("admin", "admin123");
		DashboardPage dashboard = new DashboardPage();
		dashboard.clickTimesheet();
		time = new TimePage();
	}
	@Test
	public void verifyErrorMessage() {
		time.enterEmpName("John Smith");
		time.clickView();
		boolean error=time.verifyErrorMsg();
		Assert.assertTrue(error);
	}
	
	@AfterMethod
	public void finish() {
		tearDown();
	}

}
