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


public class UsingTestNG {
	WebDriver driver;
	
/*	@BeforeMethod
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
	
	// Test Case 
	//@Test(timeOut=3000)
	@Test(invocationCount=5,threadPoolSize=5)
	public void testMercuryLoginPage() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium-WS\\Jars\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		WebElement userName = driver.findElement(By.name("userName"));
		userName.sendKeys("amitsrivastava");
		
		WebElement pwd = driver.findElement(By.name("password"));
		pwd.sendKeys("amit123456");
		
		WebElement loginBt = driver.findElement(By.name("login"));
		loginBt.click();
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Flight"));
		Thread.sleep(3000);
		driver.close();
	}
	
	@Test(enabled=false)
	public void testBooking(){
		/*System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium-WS\\Jars\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");*/
		WebElement userName = driver.findElement(By.name("userName"));
		userName.sendKeys("amitsrivastava");
		
		WebElement pwd = driver.findElement(By.name("password"));
		pwd.sendKeys("amit123456");
		
		WebElement loginBt = driver.findElement(By.name("login"));
		loginBt.click();
		
		
		List<WebElement> radioList = driver.findElements(By.name("tripType"));
		radioList.get(1).click();
		
		WebElement deptFrom = driver.findElement(By.name("fromPort"));
		Select deptFromselect = new Select(deptFrom);
		deptFromselect.selectByVisibleText("London");
		
		WebElement fromMonth = driver.findElement(By.name("fromMonth"));
		Select fromMonthselect = new Select(fromMonth);
		fromMonthselect.selectByVisibleText("December");
		

		WebElement fromDay = driver.findElement(By.name("fromDay"));
		Select fromDayselect = new Select(fromDay);
		fromDayselect.selectByVisibleText("25");
		
		WebElement continueBt = driver.findElement(By.name("findFlights"));
		continueBt.click();
		String pageTitle =driver.getTitle();
		Assert.assertTrue(pageTitle.contains("Bus"));
		//driver.close();
	}

}
