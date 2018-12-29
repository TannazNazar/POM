package com.syntax.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.orangehrm.utils.BaseClass;

public class TimePage extends BaseClass{

	@FindBy(id="employee")
	private WebElement empName;
	
	@FindBy(id="btnView")
	private WebElement btnView;
	
	@FindBy(xpath="//div[@class='message warning']")
	private WebElement errorMsg;
	
	public TimePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmpName(String name) {
		empName.clear();
		empName.sendKeys(name);
	}
	
	public void clickView() {
		btnView.click();
	}
	
	public boolean verifyErrorMsg() {
		return errorMsg.isDisplayed();
	}
}
