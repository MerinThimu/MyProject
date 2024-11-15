/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

/**
 * 
 */
public class OrderConfirmation extends BaseClass
{
	@FindBy(xpath = "//p[text()='Your order on My Shop is complete.']")
	WebElement confirmMessage;
	
	public OrderConfirmation()
	{
		PageFactory.initElements(getDriver(), this);
	}
	public String validateConfirmMessage()
	{
		String confirmMsg = confirmMessage.getText();
		return confirmMsg;
	}

}
