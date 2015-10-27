import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestNGDemo1 {
	
	// TestCase
	// @Test it is a predefine TESTNG Annotation , and this will give the 
	// instruction to the Compiler that treat this method as a Test Case.
	/*WebDriver driver;
	
	
	@BeforeMethod
	public void start(){
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium-WS\\Jars\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		
	}
	
	@AfterMethod
	public void stop(){
		driver.close();
	}*/
	
	//@Test(timeOut=1000)
	@Test(invocationCount=5,threadPoolSize=5)
	public void testMercuryLogin(){
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium-WS\\Jars\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		
		WebElement userid = driver.findElement(By.name("userName"));
		userid.sendKeys("amitsrivastava");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("amit123456");
		WebElement loginBt = driver.findElement(By.name("login"));
		loginBt.click();
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Flight"));
		driver.close();
	}
	
	// TestCase
	/*@Test(enabled=false)
	public void testMercuryTicketBooking(){
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium-WS\\Jars\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		WebElement userid = driver.findElement(By.name("userName"));
		userid.sendKeys("amitsrivastava");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("amit123456");
		WebElement loginBt = driver.findElement(By.name("login"));
		loginBt.click();
		List<WebElement> radioList = driver.findElements(By.name("tripType"));
		radioList.get(1).click();
		WebElement pass = driver.findElement(By.name("passCount"));
		Select passengerSelect = new Select(pass);
		passengerSelect.selectByValue("4");
		WebElement deptFrom = driver.findElement(By.name("fromPort"));
		Select deptFromSelect = new Select(deptFrom);
		deptFromSelect.selectByValue("London");
		WebElement fromMonth = driver.findElement(By.name("fromMonth"));
		Select month = new Select(fromMonth);
		month.selectByVisibleText("December");
		
		WebElement fromDate = driver.findElement(By.name("fromDay"));
		Select day = new Select(fromDate);
		day.selectByValue("25");
		WebElement continueBt = driver.findElement(By.name("findFlights"));
		continueBt.click();
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.contains("Bus"));
		//driver.close();
	}*/

}
