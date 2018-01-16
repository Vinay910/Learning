package masteringSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverThread {
	
	private WebDriver webdriver;
	
	private final String operatingSystem=System.getProperty("os.name").toUpperCase();
	private final String operatingArchitecture=System.getProperty("os.arch");
	
	public WebDriver getDriver() throws Exception
	{
		if(null==webdriver)
		{
			System.out.println(" ");
			System.out.println("Current Operating System:  " + operatingSystem);
			System.out.println("Current Architecture:  " + operatingArchitecture);
			System.out.println("Current Browser Selection : Chrome");
			System.out.println(" ");
			webdriver = new ChromeDriver(DesiredCapabilities.chrome());
		}
		
		return webdriver;
	}
	
	public void quitDriver()
	{
		if(null!=webdriver)
		{
			webdriver.quit();
			webdriver=null;
		}
	}

}
