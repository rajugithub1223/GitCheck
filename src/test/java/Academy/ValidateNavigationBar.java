package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;
//Adding logs
//generating HTML reports
//scfeenshot on failure
//jenkins integration
public class ValidateNavigationBar extends base {
	public WebDriver driver;
	
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void validateAppNavBar() throws IOException
	{
		
		//1st Inheritance
		//2nd creating object to that class and invoke methods of it
		LandingPage l = new LandingPage(driver);
		//compare the text from the browser with actual text.-Error..
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("Navigation Bar is displayed");
		 System.out.println("Test completed");
		 System.out.println("Test Success");
		 System.out.println("Test Verfied");
		 System.out.println("Tested");
	//	Assert.assertFalse(false);
		
	//  .nav.navbar-nav.navbar-right>li>a
		
		
		
	
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
