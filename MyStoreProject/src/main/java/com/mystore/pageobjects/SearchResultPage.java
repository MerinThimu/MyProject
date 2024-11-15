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
public class SearchResultPage extends BaseClass
{
	@FindBy(xpath = "//*[@id=\"bigpic\"]")
	WebElement productResult;
	
	
	public SearchResultPage() 
	{
		PageFactory.initElements(getDriver(), this);
	}
	public boolean isProductAvailable()
	{
		return Action.isDisplayed(getDriver(),productResult);
	}
	public AddToCart clickOnProduct()
	{
		Action.click(getDriver(), productResult);
		return new AddToCart();
	}


}
