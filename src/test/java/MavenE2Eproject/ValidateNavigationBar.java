package MavenE2Eproject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resource.base;

public class ValidateNavigationBar extends base{ //using extends keyword, coz of inheritance property, can use "base" class property
	public static Logger Log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initilise() throws IOException
	{
		driver=initializeDriver();
		Log.info("driver has initilised");
		driver.get(prop.getProperty("url"));//dont need any driver webdriver, done from the base class
		Log.info("chrome has opened");
	}
	
	
	@Test
	public void ValidateBar() throws IOException
	{
		 LandingPage l=new LandingPage(driver);
		 Assert.assertTrue(l.getContact().isDisplayed());//get text takes string value while is displayed gives boolean
		 Log.info("contact is displayed");
		}
	@AfterTest
	public void tear()
	{
		driver.close();
		driver=null;// to stop using the memory
	}
	}
	
	
	 
	
	
	
	
