package config;

public class Configuration 
{
	public static String userDirectory = System.getProperty("user.dir");
	public static String testsite = "http://en.wikiwash.org/";
	public static String browser = "firefox";

	//configuration for the test
	public static final String searchBarCSS=".bar.ng-pristine.ng-untouched.ng-valid";
	public static final String washCSS=".button";
	
	//Configuration for the wash results page
	public static final String washResultCSS = ".collection.ng-isolate-scope";
	public static final String washResultItemsCSS = ".revision-link";
	
	public static final String editorCountXpath = "html/body/div[1]/div[1]/div[3]/div[1]/div[3]/div[1]/p";
	
}
