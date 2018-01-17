package config;

import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public enum DriverType implements DriverSetup
{
	// Firefox is a enum
	FIREFOX{
		
	public DesiredCapabilities getDesiredCapabilities() {
		
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		return capabilities;
	}

	public WebDriver getWebDriverObject(DesiredCapabilities desiredCapabilities) {
		
		return new FirefoxDriver(desiredCapabilities);
	}
	},
	
	CHROME{
		
	public DesiredCapabilities getDesiredCapabilities() {
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches", Arrays.asList("--no-default-browser-check"));
		HashMap<String,String> chromePreferences= new HashMap<String,String>();
		chromePreferences.put("profile.password_manager_enabled", "false");
		capabilities.setCapability("chrome.prefs", chromePreferences);
		return capabilities;
	}

	public WebDriver getWebDriverObject(DesiredCapabilities desiredCapabilities) {
		
		return new ChromeDriver(desiredCapabilities);
	}
	},
	IE{
		
	public DesiredCapabilities getDesiredCapabilities() {
		
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION,true);
		capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING,true);
		capabilities.setCapability("requiredWindowFocus", true);
		return capabilities;
	}

	public WebDriver getWebDriverObject(DesiredCapabilities desiredCapabilities) {
		
		return new InternetExplorerDriver(desiredCapabilities);
	}
	};
}
