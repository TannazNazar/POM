package com.syntax.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.orangehrm.utils.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(id = "txtUsername")
	private WebElement userName;
	
	@FindBy(id="txtPassword")
	private WebElement password;
	
	@FindBy(id="btnLogin")
	private WebElement btnLogin;
	
	@FindBy(xpath="//img[contains(@src,'logo')]")
	private WebElement logo;
	
	@FindBy(id="spanMessage")
	private WebElement errorMessage;

	public LoginPage() {
		PageFactory.initElements(driver, this);
		//PageFactory.initElements(driver, LoginPage.class);
	}

	public void enterUserName(String uName) {
		userName.sendKeys(uName);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}

	public boolean verifyLogo() {
		return logo.isDisplayed();
	}
	
	public boolean verifyErrorMessage() {
		return errorMessage.isDisplayed();
	}
	
	public void doLogin(String uName, String pwd) {
		userName.sendKeys(uName);
		password.sendKeys(pwd);
		btnLogin.click();
	}
}
