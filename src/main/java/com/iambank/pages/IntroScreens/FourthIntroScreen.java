package com.iambank.pages.IntroScreens;

import com.iambank.pages.basepages.AppBasePage;
import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.pages.OnBoardingScreens.MarketSelectionScreen;
import com.iambank.pages.SplashScreen.SignInScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class FourthIntroScreen extends AppBasePage{
	public FourthIntroScreen(AppiumDriver<MobileElement> driver, AppiumCapabilities driverCapabilities) {
		super(driver, driverCapabilities);
		waitForElement(introNextButton, 10);
	}
	
	public SignInScreen clickAlreadyhaveAccount() throws InterruptedException {
		skipIntroScreens.click();
		return new SignInScreen(getDriver(), getDriverCapabilities());		
	}
	
	public MarketSelectionScreen clickFourthIntroNextButton() throws InterruptedException {
		introNextButton.click();
		return new MarketSelectionScreen(getDriver(),getDriverCapabilities());
	}
	
	public String getFourthScreenMainDescription() {
		return largeText.getText();		
	}
	
	public String getFourthScreenSmallDescription() {
		return smallText.getText();		
	}
	
	public String getFourthScreenNextButtonText() {
		return introNextButton.getText();		
	}
	
	public String getFourthScreenSignInText() {
		return skipIntroScreens.getText();
	}
	
}
