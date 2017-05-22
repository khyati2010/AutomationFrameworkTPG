package com.iambank.pages.SignInScreens;

import org.openqa.selenium.WebElement;
import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.pages.basepages.AppBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SignInScreen extends AppBasePage{
	
	@AndroidFindBy(id="username")
	private WebElement username;
	
	@AndroidFindBy(id="passwd")
	private WebElement password;
	
	@AndroidFindBy(id="login")
	private WebElement sign_in;
	
	public SignInScreen(AppiumDriver<MobileElement> driver, AppiumCapabilities environment)
	{
		super(driver,environment);
	}
	
	public String getSignScreenText()
	{
		return("sign in");
		
	}

}
