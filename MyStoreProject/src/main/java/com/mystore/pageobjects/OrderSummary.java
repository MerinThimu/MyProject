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
public class OrderSummary extends BaseClass
{
	@FindBy(xpath = "//span[text()='I confirm my order']")
	WebElement confirmOrderBtn;
	
	public OrderSummary()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderConfirmation clickOnConfirmOrderBtn()
	{
		Action.click(getDriver(),confirmOrderBtn);
		return new OrderConfirmation();
	}

}
