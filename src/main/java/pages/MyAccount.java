package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import actions.UiActions;

public class MyAccount  
{
	private By genderMale = By.id("id_gender1");
	private By genderFemale = By.id("id_gender2");
	private By fNameField = By.id("customer_firstname");
	private By sNameField = By.id("customer_lastname");
	private By password = By.id("passwd");
	private By daysList = By.id("days");
	private By monthList = By.id("months");
	private By yearList = By.id("years");
	private By company = By.id("company");
	private By fAddress = By.id("address1");
	private By sAddress = By.id("address2");
	private By state = By.id("id_state");
	private By postcode = By.id("postcode");
	private By city = By.id("city");
	private By id_country = By.id("id_country");
	private By phone = By.id("phone");
	private By phoneMobile = By.id("phone_mobile");
	private By alias = By.id("alias");
	private By submitAccount = By.id("submitAccount");
	UiActions myAction;
	public MyAccount(String testNme)
	{
		myAction= new UiActions(testNme);
	}
	public void setGender (String gender)
	{
		if(gender == "M")
		{
			myAction.click (genderMale);
		}
		else
		{
			myAction.click (genderFemale);
		}
	}
	public void setFname (String fName) 
	{
		myAction.type(fNameField,fName);
	}
	public void setSname (String sName) 
	{
		myAction.type(sNameField,sName);
	}
	public void setPasswd(String passwd)
	{
		myAction.type(password,passwd);
	}
	public void setCompany(String comp)
	{
		myAction.type(company,comp);
	}
	public void setfAddress(String fAdd)
	{
		myAction.type(fAddress,fAdd);
	}
	public void setsAddress(String sAdd)
	{
		myAction.type(sAddress,sAdd);
	}
	public void setState(String stat)
	{
		Select states = new Select(myAction.find(state));
		states.selectByVisibleText(stat);
	}
	public void setPostcode(String postCode)
	{
		myAction.type(postcode,postCode);
	}
	public void setCity(String City)
	{
		myAction.type(city,City);
	}
	public void setCountry(String country)
	{
		Select contires = new Select(myAction.find(id_country));
		contires.selectByVisibleText(country);
	}
	public void setPhone(String Phone)
	{
		myAction.type(phone,Phone);
	}
	public void setPhoneMobile(String Mobile)
	{
		myAction.type(phoneMobile,Mobile);
	}
	public void setAddAlias(String aliasAddress)
	{
		myAction.type(alias,aliasAddress);
	}
	public void selectFromList(String dayValue,String monthValue,String yearValue)
	{
		Select dayDropList = new Select(myAction.find(daysList));
		Select monthDropList = new Select(myAction.find(monthList));
		Select yearDropList = new Select(myAction.find(yearList));
		yearDropList.selectByValue(yearValue);
		dayDropList.selectByValue(dayValue);
		monthDropList.selectByValue(monthValue);
		
	}
	public void fillFields (String gender,String fname, String sname,String passwd,
			String dayValue,String monthValue,String yearValue,String comp,String fAdd,
			String sAdd,String stat,String postCode,String City,String country,String Phone
			,String Mobile,String aliasAddress)
	{
		myAction.enterUserInfo(submitAccount);
		setGender (gender);
		setFname(fname);
		setSname(sname);
		setPasswd(passwd);
		selectFromList(dayValue,monthValue,yearValue);
		setCompany(comp);
		setfAddress(fAdd);
		setsAddress(sAdd);
		setCity(City);
		setState(stat);
		setPostcode(postCode);
		setCountry(country);
		setPhone( Phone);
		setPhoneMobile(Mobile);
		setAddAlias(aliasAddress);
	}
	
	public void clickLoginButton () 
	{
		myAction.click(submitAccount);
	}
	public String returnDriverTitle()
	{
		return myAction.getDriverTitle();	
	}
	

}
