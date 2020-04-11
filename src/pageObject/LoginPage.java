package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	
	By Email=By.id("user_email");
	By Password=By.id("user_password");
	By Submit=By.xpath("//input[@name='commit']");
	
	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}

	public WebElement Email()
	{
		return driver.findElement(Email);
	}
	public WebElement Enterpass()
	{
		return driver.findElement(Password);
	}
	public WebElement Submitbut()
	{
		return driver.findElement(Submit);
	}
	
	
	}


