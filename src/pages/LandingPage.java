package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import config.Configuration;

public class LandingPage 
{

	WebDriver driver;
	
	/**
	 * It is the constructor of the main form page.
	 * @param driver
	 */
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(css=Configuration.searchBarCSS)
	WebElement searchBar;
	
	@FindBy(css=Configuration.washCSS)
	WebElement wash;
	
	public WashResultPage setSearchBar(String wikiURL)
	{
		searchBar.sendKeys(wikiURL);
		try {
			driver.wait(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wash.click();
		return PageFactory.initElements(driver, WashResultPage.class);
	}
	
}
