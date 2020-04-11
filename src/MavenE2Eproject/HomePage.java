package MavenE2Eproject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resource.base;

public class HomePage extends base{ //using extends keyword, coz of inheritance property, can use "base" class property
	public static Logger Log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initilize() throws IOException
	{
		driver=initializeDriver();
		//dont need any driver webdriver, done from the base class
	}
	
	@Test(dataProvider="getData")
	public void BasePagenavigation(String UserName, String Password) throws IOException
	{
		driver.get(prop.getProperty("url"));
		 LandingPage l=new LandingPage(driver);
		 l.getLogin().click();
		 Log.info("Clicked on Login");
		 
		 LoginPage lP=new LoginPage(driver);
		 lP.Email().sendKeys(UserName);//remove inverted commas as it treats it a value and not a variable
		 lP.Enterpass().sendKeys(Password);
		 lP.Submitbut().click();
		 Log.info(" Tried Loggingin");
	}
	
	@AfterTest
	public void tear()
	{
		driver.close();
		driver=null;// to stop using the memory
	}
	
	
	
	@DataProvider
	//row stands for how many different data types test should run
	//column stands for how many valueseach test has 
	public Object[][] getData()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="Restricted@User.com";
				data[0][1]="123abx";
						data[1][0]="Non-Restricted@users.com";
								data[1][1]="123456";
								
		return data;
	} 
	
	
	}
	
	
	
	
