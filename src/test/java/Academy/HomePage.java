package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;
	
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException
	{
//		driver = initializeDriver();
//		driver.get("http://rahulshettyacademy.com");
		//1st Inheritance
		//2nd creating object to that class and invoke methods of it
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		
		//lp.getLogin().click();   //driver.findElement(By.cssSelector(""))
		
		//LoginPage l = new LoginPage(driver);
		LoginPage lp = l.getLogin();
		
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		
		//System.out.println(text);
		
		
		log.info(text);
		
		lp.getLogin().click();
		ForgotPassword fp= lp.forgotPassword();
		fp.getEmail().sendKeys("xxx");
		fp.sendMeInstructions().click();
	
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		
		//Row stands for how many different data types test should run
		//Coloumn stands for how many values per each test
		//Array size is index start with 0,1,2,3,4...
		Object[][] data = new Object[2][3];
		//0th row
		data[0][0] = "nonrestrictedUser@gmail.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted User";
		//1st row
		data[1][0] = "restrictedUser@gmail.com";
		data[1][1] = "456789";
		data[1][2] = "Non Restricted User";  
		
		return data;

	}
	
}

