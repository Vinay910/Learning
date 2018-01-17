package masteringSelenium;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DriverFactory {
	
	private static List<WebDriverThread> WebDriverThreadPool= Collections.synchronizedList(new ArrayList<WebDriverThread>());
	private static ThreadLocal<WebDriverThread> driverThread;
	@BeforeSuite
	public static void instantiateDriverObject()
	{
		driverThread=new ThreadLocal<WebDriverThread>()
				{
					@Override
					protected WebDriverThread initialValue()
					{
						WebDriverThread webDriverThread=new WebDriverThread();
						return webDriverThread;
					}
				
				};
	}

	public static WebDriver getDriver() throws Exception 
	{
		return driverThread.get().getDriver();
		
	}
	
	@AfterMethod
	public static void quitDriver() throws Exception
	{
		getDriver().manage().deleteAllCookies();
		driverThread.get().quitDriver();
	}
	@AfterSuite
	public static void closeDriverObject()
	{
		for (WebDriverThread webDriverThread: WebDriverThreadPool)
		{
			webDriverThread.quitDriver();
		}
		
	}
	
}
