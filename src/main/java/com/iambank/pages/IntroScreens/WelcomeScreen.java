package com.iambank.pages.IntroScreens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.pages.SignInScreens.SignInScreen;
import com.iambank.pages.basepages.AppBasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class WelcomeScreen extends AppBasePage{
	
	 private static final Logger log = LogManager.getLogger(WelcomeScreen.class);

	public WelcomeScreen(AppiumDriver<MobileElement> driver, AppiumCapabilities driverCapabilities) {
		super(driver, driverCapabilities);	
		log.info("Landed on FirstIntro Screen Successfully");
	}
	
	public FirstIntroScreen clickWelcomeScreenNextButton()
	{
		if(nextBottomButton.isEnabled() )
		{
			nextBottomButton.click();
			return new FirstIntroScreen(getDriver(),getDriverCapabilities());
		}
		else
		{
			log.error("Not able to click on Next button to navigate on next screen from First intro screen");
			return null;
		}
		
	}
	
	public SignInScreen clickSignIn()
	{
		if(skipintroscreens.isEnabled())
		{
			skipintroscreens.click();
			return new SignInScreen(getDriver(),getDriverCapabilities());
		}
		else
		{
			log.error("Not able to click on Sign in link on First intro screen");
			return null;
		}
		
	}
	
	public String getWelcomeScreenMainDescription()
	{
		return (intro_txt_large.getText());
		
	}
	
	public String getWelcomeScreenSmallDescription()
	{
		return (intro_txt_small.getText());
		
	}
	
	public String getWelcomeScreenNextButtonText()
	{
		return nextBottomButton.getText();
		
	}
	public String getWelcomeScreenSignInLinkText()
	{
		return (skipintroscreens.getText());
	}

}
