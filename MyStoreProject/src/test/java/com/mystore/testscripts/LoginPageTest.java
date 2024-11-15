/**
 * 
 */
package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

/**
 * 
 */
public class LoginPageTest extends BaseClass
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

    @Test(dataProvider = "Credentials" , dataProviderClass = DataProviders.class , groups = {"Smoke","Sanity"})
	public void loginTest(String uname,String pswd)
	{
    	Log.startTestCase("loginTest");
		indexPage = new IndexPage();
		Log.info("user clicking on signin");
		//indexPage.clickOnSignIn();
		loginPage = indexPage.clickOnSignIn();
		Log.info("Enter username and password");
		homePage = loginPage.Login(uname, pswd);
		String actualURL = homePage.getCurrURL();
		String expectedURL = "http://www.automationpractice.pl/index.php?";
		Log.info("Verifying if user is able to login");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login is success");
		Log.endTestCase("loginTest");
	}
}
