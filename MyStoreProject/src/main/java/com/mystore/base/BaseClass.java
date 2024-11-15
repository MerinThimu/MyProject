package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static Properties prop;
	//public static WebDriver driver;
	
	//Declare ThreadLocal driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	@BeforeSuite(groups = {"Smoke","Sanity","Regression"})
	public void loadconfig()
	{
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		try
		{
			prop = new Properties();
			System.out.println("super constructor invoked");
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);
			System.out.println("driver:"+driver);
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static WebDriver getDriver()
	{
		//get driver from threadLocalmap
		return driver.get();
	}
	
	
	
	public void launchApp(String browsername)
	{
		
		//String browserName = prop.getProperty("browser");
		
		
		if(browsername.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			
			//set browserto ThreadLocalmap
			driver.set(new ChromeDriver());
		}
		else if (browsername.equalsIgnoreCase("FireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			
			//set browserto ThreadLocalmap
			driver.set(new FirefoxDriver());
		}
		else if (browsername.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			//driver = new EdgeDriver();
			
			//set browserto ThreadLocalmap
			driver.set(new EdgeDriver());
		}
		//max screen
		getDriver().manage().window().maximize();
		
		//delete cookies
		getDriver().manage().deleteAllCookies();
		
		//Implicit TimeOuts
		getDriver().manage().timeouts().implicitlyWait
		(Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
		
		//PageLoad TimeOuts
		getDriver().manage().timeouts().pageLoadTimeout
			(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
		
		//Launching the URL
		getDriver().get(prop.getProperty("url"));
	}
	
	@AfterSuite
	public void afterSuite()
	{
		ExtentManager.endReport();
		
		
	}

}
