import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class TestAdvanceControls {

	@Test
	public void testAdvance() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium-WS\\Jars\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:63342/JSDemos7to9/NewInputs.html");
		WebElement dob = driver.findElement(By.id("dob"));
		dob.click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("12")).click();

		/*WebElement selectedDate = driver.findElement(By.linkText("15"));
		selectedDate.click();*/
		/*driver.findElement(By.id("range")).clear();
		driver.findElement(By.id("range")).sendKeys("27");
		driver.findElement(By.id("number")).clear();
		driver.findElement(By.id("number")).sendKeys("1");*/



	}
}
