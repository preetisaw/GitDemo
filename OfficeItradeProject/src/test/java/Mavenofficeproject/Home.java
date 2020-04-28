package Mavenofficeproject;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.UserInfo;
import resources.base;
import resources.ExcelData;

public class Home extends base {
	public static Logger log =LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void commonnavigation() throws IOException
	{
		driver=initializeDriver();
	}
	@Test
	public void UserInfo()
	{
		
		String nameInput = "@#$!%&*()_-+={}[]^|\\?, a.;:'\"A13";
		String typedText;
		
		
		driver.get(prop.getProperty("url"));
		//driver.get("https://itrade.angelbroking.com/");
		driver.manage().window().maximize();
		UserInfo ui=new UserInfo(driver);
		
		ui.getName().sendKeys(nameInput);
		log.info("Name is entered: "+ nameInput );
		typedText=ui.getName().getAttribute("value");
		log.info("Name printed: "+ typedText);
		boolean tFlag = true;
		//validate Enter Name textbox input
		int tLen = nameInput.length();
		for(int cnt = 0; cnt<tLen; cnt++)
		{
			if (typedText.contains(Character.toString(nameInput.charAt(cnt))))//else
			{
				if (!Character.toString(nameInput.charAt(cnt)).toLowerCase().matches("[a-z/./ ]"))
				{
					tFlag = false;
				}
			}
			else if(Character.toString(nameInput.charAt(cnt)).toLowerCase().matches("[a-z/.]"))
			{
				tFlag= false;
			}
		}
		
		if (tFlag)
		{
			Assert.assertTrue(true, "Validation for Enter Name passed");
		}
		else
		{
			Assert.assertFalse(false, "Validation for Enter Name failed");
		}
		
		//ui.getMobile().sendKeys("8082426341");
		ui.getCity().sendKeys("dhanbad");
		ui.getOTP().sendKeys("00000");
		//database connection required
		ui.getRefCode().sendKeys("cbho");
		Actions action = new Actions(driver);
		action.doubleClick(ui.getChkBx()).perform();
		log.info("auto checked, when double clicked it checks and unchecks");
		ui.getTC().click();
		ui.getTkMeAhd().click();
		
		ExcelData ed = new ExcelData();
		ArrayList<String> mobNumb = new ArrayList<String>();
		String colName = "Mobilenumber";
		try 
		{
			mobNumb = ed.getData(colName,"BO","D://Mobilenumber.xlsx");
			for (int cnt = 0; cnt < mobNumb.size(); cnt++)
			{
				ui.getMobile().sendKeys(mobNumb.get(cnt));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
	}
	
	
	
	
	
}
