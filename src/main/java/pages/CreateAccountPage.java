package pages;

import org.openqa.selenium.By;
import actions.UiActions;

public class CreateAccountPage
{
	
	UiActions uiActions ;
	String testClassName;
	public CreateAccountPage(String testClassName,String url)
	{
		this.testClassName = testClassName;
		uiActions = new UiActions(testClassName);
		uiActions.navigateToUrl(url);
	}
   
	
	By emailCreateText = By.id("email_create"); 
	By submitCreateAccount = By.id("SubmitCreate"); 
	

	public void enterCreateAccount(String email) {
		uiActions.type(emailCreateText, email);
		uiActions.oneClick(submitCreateAccount);

	}

}
