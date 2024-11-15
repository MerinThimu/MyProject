package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * 
 */
public class AddToCart extends BaseClass
{
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(name ="group_1")
	WebElement size;
	
	@FindBy(name ="White")
	WebElement colour;
	
	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement addToCartBtn;
	

	@FindBy(xpath = "//*[@id=\"layer_cart\"]//h2/i")
	WebElement addToCartmsg;
	
	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOutBtn;
	
	public AddToCart() 
	{
		PageFactory.initElements(getDriver(), this);
	}
	public void enterQuantity(String quantity1)
	{
		Action.type(quantity,quantity1);
	}
	public void selectSize(String size1)
	{
		Action.selectByVisibleText(size1,size);
	}
	public void selectColour(String Color1)
	{
		Action.click(getDriver(), colour);
	}
	public void clickOnAddToCart()
	{
		Action.click(getDriver(), addToCartBtn);
	}
	public boolean validateAddToCart()
	{
		Action.fluentWait(addToCartmsg, 10);
		return Action.isDisplayed(getDriver(),addToCartmsg);
	}
	public OrderPage clickOnCheckout()
	{
		Action.fluentWait(proceedToCheckOutBtn, 10);
		Action.JSClick(getDriver(), proceedToCheckOutBtn);
		return new OrderPage();
	}

}
