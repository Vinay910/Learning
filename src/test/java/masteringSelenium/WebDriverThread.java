package masteringSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import config.DriverType;

import static config.DriverType.FIREFOX;
import static config.DriverType.valueOf;

public class WebDriverThread {
	
	private WebDriver webdriver;
	private DriverType selectDriverType;
	
	private final DriverType defaultDriverType= FIREFOX ;
	private final String browser=System.getProperty("browser").toUpperCase();
	private final String operatingSystem=System.getProperty("os.name").toUpperCase();
	private final String operatingArchitecture=System.getProperty("os.arch");
	
	public WebDriver getDriver() throws Exception
	{
		if(null==webdriver)
		{
			selectDriverType=determineEffectiveDriverType();
			DesiredCapabilities desiredCapabilities=selectDriverType.getDesiredCapabilities();
			
		}
		
		return webdriver;
	}
	
	private DriverType determineEffectiveDriverType() {
		
		DriverType driverType=defaultDriverType;
		try
		{
			driverType=valueOf(browser);
		}
		catch(NullPointerException ignored)
		{
			System.out.println("No driver specified, defaulting to  " +driverType+"....");
		}
		catch(IllegalArgumentException ignored)
		{
			System.out.println("No driver specified, defaulting to  " +driverType+"....");
		}
		return driverType;
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
