package actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


public class UiActions
{
	public WebDriver driver;
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
	public  String getDriverTitle()
	{
		String ActualTitle = driver.getTitle();
		return ActualTitle;
		
	}
	public void enterUserInfo(By submitAccount)
	{
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(submitAccount));
	
	}

}
