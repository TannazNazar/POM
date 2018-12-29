package com.syntax.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.orangehrm.utils.BaseClass;

public class AssignLeave extends BaseClass{

	@FindBy(id="assignleave_txtEmployee_empName")
	public WebElement empName;
	
	@FindBy(id="assignleave_txtLeaveType")
	public WebElement ddLeaveType;
	
	@FindBy(id="assignleave_txtFromDate")
	public WebElement fromDate;
	
	@FindBy(id="assignleave_txtToDate")
	public WebElement toDate;
	
	@FindBy(id="assignleave_txtComment")
	public WebElement comment;
	
	@FindBy(id="assignBtn")
	public WebElement btnAssign;
	
	public AssignLeave() {
		PageFactory.initElements(driver, this);
	}
	//12:40
	
	
}
