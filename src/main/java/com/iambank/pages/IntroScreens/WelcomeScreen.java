package com.iambank.pages.IntroScreens;

import com.iambank.pages.basepages.AppBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.pages.SignInScreens.SignInScreen;
public class WelcomeScreen extends AppBasePage{
	
	public WelcomeScreen(AppiumDriver<MobileElement> driver, AppiumCapabilities driverCapabilities) {
		super(driver, driverCapabilities);	
		waitForElement(introNextButton, 10);
	}
	
	public FirstIntroScreen clickWelcomeScreenNextButton(){
		introNextButton.click();
		return new FirstIntroScreen(getDriver(),getDriverCapabilities());		
	}
	
	public SignInScreen clickSignIn(){
		skipIntroScreens.click();
		return new SignInScreen(getDriver(),getDriverCapabilities());		
	}
	
	public String getWelcomeScreenMainDescription(){
		return largeText.getText();		
	}
	
	public String getWelcomeScreenSmallDescription(){
		return smallText.getText();		
	}
	
	public String getWelcomeScreenNextButtonText(){
		return introNextButton.getText();		
	}
	
	public String getWelcomeScreenSignInLinkText(){
		return skipIntroScreens.getText();
	}

}
