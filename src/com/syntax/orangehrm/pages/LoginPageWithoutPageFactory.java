package com.syntax.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.syntax.orangehrm.utils.BaseClass;

public class LoginPageWithoutPageFactory extends BaseClass {

	//WebDriver driver;
	
	private WebElement userName = driver.findElement(By.id("txtUsername"));
	private WebElement password = driver.findElement(By.id("txtPassword"));
	private WebElement btnLogin = driver.findElement(By.id("btnLogin"));
	private WebElement logo = driver.findElement(By.xpath("//img[contains(@src, 'logo')]"));

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
}
