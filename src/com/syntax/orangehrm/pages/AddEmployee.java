package com.syntax.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.orangehrm.utils.BaseClass;

public class AddEmployee extends BaseClass{
	@FindBy(id="firstName")
	public WebElement firstName;
	
	@FindBy(id="lastName")
	public WebElement lastName;
	
	@FindBy(id="btnSave")
	public WebElement btnSave;
	
	@FindBy(id="chkLogin")
	public WebElement chxLoginDetails;
	
	@FindBy(id="user_name")
	public WebElement userName;
	
	@FindBy(id="user_password")
	public WebElement password;
	
	@FindBy(id="re_password")
	public WebElement confPwd;
	
	public AddEmployee() {
		PageFactory.initElements(driver, this);
	}
	public void enterFirstName(String fName) {
		firstName.sendKeys(fName);
	}
	public void enterLastName(String lName) {
		lastName.sendKeys(lName);
	}
	public void clickSave() {
		btnSave.click();
	}
	
//	public void enteruserName(String lName) {
//		userName.sendKeys(lName);
//	}
//	public void enterpassword(String lName) {
//		password.sendKeys(lName);
//	}
}
