/**
 * 
 */
package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCart;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * 
 */
public class OrderPageTest extends BaseClass
{
	IndexPage index;
	SearchResultPage searchResultPage;
	AddToCart addTocart;
	OrderPage orderPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser)
	{
		launchApp(browser);
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown()
	{
		getDriver().quit();
	}
	
	@Test(groups = "Regression")
	public void verifyTotalPrice()
	{
		index = new IndexPage();
		searchResultPage = index.searchProduct("t-shirt");
		addTocart = searchResultPage.clickOnProduct();
		addTocart.enterQuantity("2");
		addTocart.selectSize("M");
		addTocart.selectColour("White");
		addTocart.clickOnAddToCart();
		orderPage = addTocart.clickOnCheckout();
		Double unitPrice = orderPage.getUnitPrice();
		Double totalPrice = orderPage.getTotalPrice();
		Double totalExpectedPrice = (unitPrice*2)+2;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
	}

}
