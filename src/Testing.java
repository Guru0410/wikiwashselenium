import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.Configuration;

public class Testing 
{

	public static void main(String args[])
	{
		System.setProperty("webdriver.gecko.driver", "E:\\Selenium\\Selenium V 3.4\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://en.wikiwash.org/");
		driver.findElement(By.cssSelector(".bar.ng-pristine.ng-untouched.ng-valid")).sendKeys("https://en.wikipedia.org/wiki/Canada");
		driver.findElement(By.cssSelector(".button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement edits = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".collection.ng-isolate-scope")));
//		WebElement edits = driver.findElement(By.cssSelector(".collection.ng-isolate-scope"));
		List<WebElement> listOfEdits = edits.findElements(By.cssSelector(".revision-link"));
		
		System.out.println(listOfEdits.size());
		String count = driver.findElement(By.xpath(Configuration.editorCountXpath)).getText();
		System.out.println(count);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

}