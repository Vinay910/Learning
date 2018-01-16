package masteringSelenium;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicTestWD extends DriverFactory {
	
	private void googleExampleThatSearchFor(final String searchString) throws Exception
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vmahajan\\Downloads\\Day1\\Browser_Drivers_32bit\\chromedriver.exe");
		WebDriver driver=DriverFactory.getDriver();
		driver.get("https://www.google.com");
		WebElement searchField =driver.findElement(By.name("q"));
		searchField.clear();
		searchField.sendKeys(searchString);
		System.out.println("Titel is" + driver.getTitle());
		searchField.submit();
		(new WebDriverWait(driver,10)).until
				(new ExpectedCondition<Boolean>()
				{
						public Boolean apply(WebDriver driverObject)
							{
								return driverObject.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
							}
					}
				);
		
		System.out.println("Titel is" + driver.getTitle());
	}
	
	@Test
	public void googleCheeseExample() throws Exception
	{
		googleExampleThatSearchFor("Cheese");
		
	}
	@Test
	public void googleMilkExample() throws Exception
	{
		googleExampleThatSearchFor("Milk");
		
	}
	@Test
	public void googleCheeseExample1() throws Exception
	{
		googleExampleThatSearchFor("Cheese1");
		
	}
	@Test
	public void googleMilkExample1() throws Exception
	{
		googleExampleThatSearchFor("Milk2");
		
	}
	public void googleMilkExample2() throws Exception
	{
		googleExampleThatSearchFor("Milk2");
		
	}

}
