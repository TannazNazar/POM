package com.syntax.orangehrm.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.syntax.orangehrm.pages.DashboardPage;
import com.syntax.orangehrm.pages.LoginPage;
import com.syntax.orangehrm.utils.BaseClass;

public class LoginPageTest extends BaseClass{
// 1. Verify user is able to login with valid credentials and verify welcome text
// 2. Verify user is not ABLE TO LOGIN WITH valid uName & invalid pwd
	
	LoginPage login;
	
	@BeforeMethod
	public void start() {
		setUp();
		login=new LoginPage();
	}
	
	@Test
	public void validLogin() {
		login.enterUserName(prop.getProperty("userName"));
		login.enterPassword(prop.getProperty("password"));
		login.clickLogin();
		
		DashboardPage dashboard=new DashboardPage();
		boolean welcomeText=dashboard.verifyWelcomeLink();
		//System.out.println(welcomeText);
		Assert.assertTrue(welcomeText);
	}
	
	@Test
	public void invalidLogin() {
		login.enterUserName("admin");
		login.enterPassword("123");
		login.clickLogin();
		Assert.assertTrue(login.verifyErrorMessage());
	}
	
	@AfterMethod
	public void finish() {
		tearDown();
	}
}
