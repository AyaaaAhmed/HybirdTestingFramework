package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class UiActions
{
	WebDriver driver;
	public UiActions(String testName) {
		this.driver = BrowserActions.browserAndTests.get(testName);
	}

	public WebElement find(By elementlocator)
	{
		return driver.findElement(elementlocator);
	}

	public void oneClick(By element) {
		WebElement currentElement = find(element);
		currentElement.click();
	}

	public void type(By element,String text) {
		WebElement currentElement = find(element);
		currentElement.clear();
		currentElement.sendKeys(text);
	}
	public void navigateToUrl(String url) {
		driver.get(url);
	}
	public void click (By locator)
	{
		find(locator).click();
	}
	public Boolean isDisplayed (By locator)
	{
		try
		{
			System.out.println(locator.toString());
			return find(locator).isDisplayed();
		}
		catch (NoSuchElementException exc) 
		{
			return false;
		}
	}

}
