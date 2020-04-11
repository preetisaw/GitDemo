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

public class ValidateText extends base{ //using extends keyword, coz of inheritance property, can use "base" class property
	public static Logger Log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initilize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));//dont need any driver webdriver, done from the base class
	}
	
	@Test
	public void ValidateTiltle() throws IOException
	{
		
		 LandingPage l=new LandingPage(driver);
		
		 //compare the text actual vs required(string expected.string actual)
		 Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES1");
		 Log.info("Text matched");
	}
	@AfterTest
	public void tear()
	{
		driver.close();
		driver=null;// to stop using the memory
	}
	
	 }
	
	
	
	
