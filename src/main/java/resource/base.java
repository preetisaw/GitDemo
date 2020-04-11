package main.java.resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	
	protected WebDriver driver;//set this globally
	public Properties prop;//set globally, born
	public WebDriver initializeDriver() throws IOException//when return is driver, void changed to webdriver
	{
		prop=new Properties();//took life here
		FileInputStream fis=new FileInputStream(System.getProperty(“user.dir”)+"\\\\src\\\\main\\\\java\\\\resource\\\\data.properties");
	
		prop.load(fis);
		String browserName=prop.getProperty("browser");
	
		//if (browserName=="chrome")//== gives java.lang.NullPointerException
		if (browserName.equals("chrome"))
			
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.addArguments("headless");
			driver=new ChromeDriver(options);//no need to write webdriver everytime
		}
		
		
		else if(browserName.equals("Firefox"))
		{
			driver=new FirefoxDriver();	
		}
		
		else if(browserName.equals("IE"))
		{
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;//return type is driver
		
		}
	
	/*public void getScreenshot(String result) 
	 	{
			File Src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Src, new File("D:\\"+result+"Screenshots"));
			
		}*/
	
		}
	
	
	
