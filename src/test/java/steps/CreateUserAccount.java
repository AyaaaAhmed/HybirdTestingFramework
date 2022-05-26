package steps;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import actions.BrowserActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import pages.CreateAccountPage;
import pages.MyAccount;

public class CreateUserAccount extends AbstractTestNGCucumberTests
{

	public String className;
	public String driverName;
	public BrowserActions browserAcrtions = new BrowserActions();
	String testName = "CreateUserAccount";
	String url="http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
	String email="dddayaddd@gmail.com";
	MyAccount myAccInfo; 
	CreateAccountPage myAccount;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String browser)
	{
		myAccInfo= new MyAccount(testName);
	}
	@Given("the user in the registration page")
	public void the_user_in_the_registration_page()
	{
		BrowserActions.initalize_driver(testName, "chrome");
		myAccount =  new CreateAccountPage(testName,url);
		myAccount.enterCreateAccount(email);
	}
	@When("I enter all the data")
	public void i_enter_all_the_data() 
	{
		myAccInfo= new MyAccount(testName);
		myAccInfo.fillFields( "F", "Aya","Ahmed", "A1234567", "1", "5", "1999", "non",
				"ayhaga", "ahaga2","Alaska","33333", "cairo", "United States", 
				"11111111", "22222222222", "7amda");
	}
	@When("I click on register button")
	public void i_click_on_register_button() 
	{
		myAccInfo.clickLoginButton();
	}
	@Then("I register successfully")
	public void i_register_successfully()
	{
		Assert.assertEquals(myAccInfo.returnDriverTitle(),"My account - My Store");
	}
	
	
	

}
