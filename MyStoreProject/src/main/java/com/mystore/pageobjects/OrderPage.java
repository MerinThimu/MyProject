/**
 * 
 */
package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 */
public class OrderPage extends BaseClass
{
	@FindBy(xpath = "//td[@class='cart_unit']/ul/li")
	WebElement unitPrice;
	
	@FindBy(xpath = "//td[@class='price']/span")
	WebElement totalPrice;
	
	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement proceedToCheckOut;
	
	public OrderPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public double getUnitPrice()
	{
		//Action.fluentWait(unitPrice, 10);
		String unitPrice1 = unitPrice.getText();
		String unit = unitPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalUnitPrice = Double.parseDouble(unit);
		return finalUnitPrice/100;
	}

	public double getTotalPrice()
	{
		String totalPrice1 = totalPrice.getText();
		String tot = totalPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalTotalPrice = Double.parseDouble(tot);
		return finalTotalPrice/100;
	}
	
	public LoginPage clickOnCheckout()
	{
		Action.click(getDriver(),proceedToCheckOut);
		return new LoginPage();
	}

}
