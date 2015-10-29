import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CommandExecutor {

	@Test
	public void executeCommand() throws Exception{
		WebDriver driver = null;
		WebElement webElement = null;
		ExcelReader excelReader  = new ExcelReader();
		// Step - 1 Make a class to the ExcelReader and get the ArrayList of CommandClass
		ArrayList<CommandClass> commandList = excelReader.readExcel();
		// Step -2 Looping the ArrayList to fetch one by one commands
		for(int i = 0; i<commandList.size(); i++){
			CommandClass oneCommand = commandList.get(i); // Give the Current Command
			if(oneCommand.command.equalsIgnoreCase("browser")){
				if(oneCommand.target.equalsIgnoreCase("chrome")){
					System.setProperty("webdriver.chrome.driver",
							"D:\\Selenium-WS\\Jars\\chromedriver_win32\\chromedriver.exe");
					driver = new ChromeDriver();
				}
				else
				if(oneCommand.target.equalsIgnoreCase("firefox")){
					driver= new FirefoxDriver();
				}
			} // browser command code ends here
			else
			if(oneCommand.command.equalsIgnoreCase("open")){
				driver.get(oneCommand.target);
			}  // Open Command Code Ends Here
			else
			if(oneCommand.command.equalsIgnoreCase("type")){	
				String target = oneCommand.target;
				String array[] = target.split("=");
				if(array[0].equalsIgnoreCase("id")){
					webElement = driver.findElement(By.id(array[1]));
				}
				else
				if(array[0].equalsIgnoreCase("name")){
					webElement = driver.findElement(By.name(array[1]));
				}
				webElement.sendKeys(oneCommand.value);
			} // Type Command Code Ends Here
			else
			if(oneCommand.command.equalsIgnoreCase("clickAndWait")){
				String target = oneCommand.target;
				String array[] = target.split("=");
				if(array[0].equalsIgnoreCase("id")){
					webElement = driver.findElement(By.id(array[1]));
				}
				else
				if(array[0].equalsIgnoreCase("name")){
					webElement = driver.findElement(By.name(array[1]));
				}
				webElement.click();
			}  // ClickAndWait Command Code Ends Here
			else
			if(oneCommand.command.equalsIgnoreCase("asserttitle")){
				String title = driver.getTitle();
				String expectedTitle = oneCommand.target;
				Assert.assertTrue(title.contains(expectedTitle));
			}// Assert title Command Code Ends Here
		} // Loop Code Ends Here
		driver.close();
	}
	
}
