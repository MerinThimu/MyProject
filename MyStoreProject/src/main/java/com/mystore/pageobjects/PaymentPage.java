/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

import org.openqa.selenium.WebElement;

/**
 * 
 */
public class PaymentPage extends BaseClass
{
	@FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
	WebElement bankWireMethod;
	
	@FindBy(xpath = "//a[contains(text(),'Pay by check')]")
	WebElement payByCheckMethod;
	
	public PaymentPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderSummary clickOnPaymentMethod()
	{
		Action.click(getDriver(),bankWireMethod);
		return new OrderSummary();
	}
}
