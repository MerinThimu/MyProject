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
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

/**
 * 
 */
public class HomePageTest extends BaseClass
{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
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
	@Test(groups = "Smoke")
	public void wishListTest()
	{
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homePage.validatemyPersonalInfo();
		Assert.assertTrue(result);
	}
	@Test(groups = "Smoke")
	public void orderHistoryandDetailsTest()
	{
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homePage.validateorderHistory();
		Assert.assertTrue(result);
	}

}
