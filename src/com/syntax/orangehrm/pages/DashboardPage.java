package com.syntax.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.orangehrm.utils.BaseClass;

public class DashboardPage extends BaseClass{

	@FindBy(id="welcome")
	private WebElement welcome;
		
	@FindBy(xpath="//img[contains(@src, 'MyTimesheet')]")
	private WebElement timesheet;
	
	@FindBy(xpath="//span[text()='Assign Leave']")
	WebElement assignLeave;
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyWelcomeLink() {
		return welcome.isDisplayed();
	}
	
	public void clickTimesheet() {
		timesheet.click();
	}
	
	public void clickAssignLeave() {
		assignLeave.click();
	}
	
}
