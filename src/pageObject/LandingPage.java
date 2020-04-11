package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	WebDriver driver;
	
	By SignIn=By.xpath("//span[contains(text(),'Login')]");
	By Title=By.className("text-center");
	By Contact=By.xpath("//a[contains(text(),'Contact')]");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}

	public WebElement getLogin()
	{
		return driver.findElement(SignIn);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(Title);
	}
	
	public WebElement getContact()
	{
		return driver.findElement(Contact);
	}
	}


