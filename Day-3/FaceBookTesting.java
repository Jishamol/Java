

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class FaceBookTesting {
	/*
	@DataProvider(name="mydataprovider")
	public Object[][] excelDataProvider() throws Exception{
		ExcelReader excelReader = new ExcelReader();
		Object array[][]   = excelReader.readDataFromExcel();
		return array;
	}*/

	@DataProvider(name="mydataprovider")
	public Object[][] DataBaseDataProvider() throws Exception{
		
		DBReader dbReader = new DBReader();
		Object array[][]   = dbReader.readDataFromDB();
		return array;
	}
	
	@Test(dataProvider="mydataprovider")
	public void faceBookLoginTest(String userid, String pwd){
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium-WS\\Jars\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		WebElement emailId = driver.findElement(By.id("email"));
		emailId.sendKeys(userid);
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys(pwd);
		WebElement loginBT= driver.findElement(By.id("u_0_v"));
		loginBT.click();
		WebElement msg = driver.findElement(By.cssSelector(".fsl.fwb.fcb"));
		String msgText = msg.getText();
		Assert.assertTrue(msgText.contains("your password"));
		driver.close();
		
	}
	
}
