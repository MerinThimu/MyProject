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
import com.mystore.pageobjects.SearchResultPage;

/**
 * 
 */
public class AddToCartPageTest extends BaseClass
{
	IndexPage index;
	SearchResultPage searchResultPage;
	AddToCart addTocart;
	
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
	@Test(groups = {"Regression","Sanity"})
	public void addToCartTest()
	{
		index = new IndexPage();
		searchResultPage = index.searchProduct("t-shirt");
		addTocart = searchResultPage.clickOnProduct();
		addTocart.enterQuantity("2");
		addTocart.selectSize("M");
		addTocart.selectColour("White");
		addTocart.clickOnAddToCart();
		boolean result = addTocart.validateAddToCart();
		Assert.assertTrue(result);
	}

}
