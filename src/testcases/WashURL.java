package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import core.TestCore;
import pages.LandingPage;
import pages.WashResultPage;
import utilities.Utility;

public class WashURL extends TestCore
{
	@BeforeTest
	public void checkRunMode()
	{
		if(!Utility.isExecutable("WashURL", excel))
			throw new SkipException("Skipping the test");
	}
	
	@Test(dataProvider="getData",groups="Regression")
	public void testWashURLEditCount(String wikiURL) 
	{	
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		WashResultPage washResult = landingPage.setSearchBar(wikiURL);
		boolean result = washResult.verifyEditorsCount();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(result);
		sa.assertAll();
	}
	

	@DataProvider
	public Object [][] getData()
	{
		//return test data from the sheetname provided
		return Utility.getData("WashURL",excel);
	}

	
}
