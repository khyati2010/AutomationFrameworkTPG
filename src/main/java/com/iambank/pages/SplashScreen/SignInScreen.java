package com.iambank.pages.SplashScreen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.pages.basepages.AppBasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SignInScreen extends AppBasePage{
	
	private static final Logger log = LogManager.getLogger(SignInScreen.class);
	
	@AndroidFindBy(id="username")
	private WebElement username;
	
	@AndroidFindBy(id="passwd")
	private WebElement password;
	
	@AndroidFindBy(id="login")
	private WebElement sign_in;
	
	public SignInScreen(AppiumDriver driver, AppiumCapabilities environment)
	{
		super(driver,environment);
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.textToBePresentInElement(, "Seems straightforward."));

		log.info("Landed on Sign in screen successfully");
	
	}
	
	public String getSignScreenText()
	{
		return("sign in");
		
	}

}
