package actions;

import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserActions
{
	public static WebDriver driver;
	public static HashMap<String,WebDriver> browserAndTests = new HashMap<String,WebDriver>();
	public static void initalize_driver(String classname, String browser)
	{
		if (browser.equalsIgnoreCase("chrome"))
		{
			System.out.println("***chrome***");
			WebDriverManager.chromedriver().setup();
			browserAndTests.put(classname,new ChromeDriver());
			driver = browserAndTests.get(classname);
			System.out.println("***testname = "+classname+"*****");
		}
		else if (browser.equalsIgnoreCase("chrome-headless")) 
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions(); 
			options.addArguments("headless");
			browserAndTests.put(classname,new ChromeDriver(options));
			driver = browserAndTests.get(classname);
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			browserAndTests.put(classname,new FirefoxDriver());
			driver = browserAndTests.get(classname);
		}
		else
			System.out.println("This browser "+ browser+ "is not supported");
		driver.manage().window().maximize();
	}
	public static void close_driver(String classname)
	{
		driver.close();
		browserAndTests.remove(classname);
	}
}
