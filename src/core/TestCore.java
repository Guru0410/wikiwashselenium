package core;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import config.Configuration;
import utilities.ExcelReader;

public class TestCore {
	public static WebDriver driver = null;

	public static ExcelReader excel = null;
	
	@BeforeSuite
	public static void init() throws IOException{

		if(driver == null)
		{
			//load the Excel file
			excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\testdata\\testdata.xlsx");
			//Initialize the WebDriver

			if(Configuration.browser.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.10.0-win64\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(Configuration.browser.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			}

			driver.get(Configuration.testsite);
			driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
		}
	}


	@AfterSuite
	public static void testQuitDriver() {
		driver.quit();
	}

}
