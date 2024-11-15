/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * 
 */
public class HomePage extends BaseClass
{
	@FindBy(xpath = "//span[text()='My personal information']")
	WebElement myPersonalInfo;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	WebElement orderHistory;
	
	public HomePage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public  boolean validatemyPersonalInfo()
	{
		return Action.isDisplayed(getDriver(),myPersonalInfo);
	}
	public boolean validateorderHistory()
	{
		return Action.isDisplayed(getDriver(),orderHistory);
	}
	public String getCurrURL()
	{
		String homePageURL = getDriver().getCurrentUrl();
		return homePageURL;
	}

}
