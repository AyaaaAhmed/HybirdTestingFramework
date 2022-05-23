package tests;

import java.io.IOException;

import org.apache.commons.math3.exception.NoDataException;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import utilities.Helper;
import actions.BrowserActions;
import data.ExcelReader;
import data.LoadProperty;

public class CreateAccountTest
{

	public String testName;
	public BrowserActions browserAcrtions = new BrowserActions();
	@DataProvider(name="ExcelData")
	public Object[][] userRegisterData() throws IOException
	{
		try
		{
			// get data from Excel Reader class 
			ExcelReader ER = new ExcelReader();
			return ER.getExcelData();
		}
		catch(NoDataException exc)
		{
			System.out.println("error in data");
			return null;
		}
	}
	@BeforeClass
	@Parameters("browser")
	public void setup(String browser)
	{
		testName =  "CreateAccountTest";
		BrowserActions.initalize_driver(testName, browser);
	}
	@Test(dataProvider="ExcelData")
	public void HomePageSignIn(String email )
	{
		String url = LoadProperty.userData.getProperty("url");
		CreateAccountPage createAccount = new CreateAccountPage(testName,url);
		createAccount.enterCreateAccount(email);
	}
	

	@AfterMethod
	  public void screenshotONFaluir(ITestResult result)
	  {
		  if(result.getStatus() == ITestResult.FAILURE)
		  {
			  System.out.println("******Failed Testcase******");
			  Helper.captureScreenshots(BrowserActions.browserAndTests.get(testName), result.getName());
		  }
	  }
	@AfterClass
	void tearDown()
	{
		BrowserActions.close_driver(testName);
	}

}
