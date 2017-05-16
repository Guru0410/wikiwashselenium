package pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import config.Configuration;

public class WashResultPage 
{
	WebDriver driver;
	/**
	 * It is the constructor of the main form page.
	 * @param driver
	 */

	public WashResultPage(WebDriver driver)
	{
		this.driver = driver;
	}

	List<WebElement> allLinks;
	@FindBy(css = Configuration.washResultCSS)
	WebElement washResult;

	@FindBy(xpath = Configuration.editorCountXpath)
	WebElement editorCount;

	@FindBy(tagName = "a")
	List<WebElement> hrefURL;

	@FindBy(tagName = "img")
	List<WebElement> hrefImages;

	public List<WebElement> getFinalList()
	{
		allLinks = new ArrayList<WebElement>();

		for(WebElement element: hrefURL)
		{
			if(element.getAttribute("href") != null)
			{
				allLinks.add(element);
			}		 
		}

		for(WebElement element: hrefImages)
		{
			if(element.getAttribute("href") != null)
			{
				allLinks.add(element);
			}		 
		}

		return allLinks;
	}


	public boolean isLinkBroken(List<WebElement> allLinks)
	{
		HttpClient client = HttpClientBuilder.create().build();

		try 
		{
			for(WebElement element: allLinks)
			{
				HttpGet request = new HttpGet(element.getAttribute("href"));
				HttpResponse response = client.execute(request);

				if (response.getStatusLine().getStatusCode() != 200)
					return false;
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return true;
	}

	public List<WebElement> getWashResultItems()
	{
		return washResult.findElements(By.cssSelector(Configuration.washResultItemsCSS));
	}

	public ArrayList<String> getEditorsCount()
	{
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(editorCount.getText());
		ArrayList<String> count = new ArrayList<>();
		while (m.find()) 
		{
			count.add(m.group());
		}

		return count;
	}

	public boolean verifyEditorsCount()
	{
		ArrayList<String> count = getEditorsCount();
		List<WebElement> itemCount = getWashResultItems();

		if(itemCount.size()==(Integer.parseInt(count.get(1))))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean verifyBrokenLinks()
	{
		return isLinkBroken(this.getFinalList());
	}

}
