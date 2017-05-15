package com.iambank.pages.IntroScreens;

import com.iambank.pages.basepages.AppBasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.pages.OnBoardingScreens.*;
import com.iambank.pages.SplashScreen.SignInScreen;
import io.appium.java_client.AppiumDriver;


public class FourthIntroScreen extends AppBasePage{
	public FourthIntroScreen(AppiumDriver driver, AppiumCapabilities driverCapabilities) {
		super(driver, driverCapabilities);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.textToBePresentInElement(nextbutton, "Apply for a new account"));
	}
	
	public SignInScreen clickAlreadyhaveAccount() throws InterruptedException {
		if(skipintroscreens.isEnabled() )
		{
			skipintroscreens.click();
			return new SignInScreen(getDriver(), getDriverCapabilities());
		}
		
		else
		{
			LOGGER.error("Not able to click on Already have an account link");
			return null;
		}
	}
	
	public MarketSelectionScreen clickFourthIntroNextButton() throws InterruptedException {
		if(nextbutton.isEnabled()) {
			nextbutton.click();
			return new MarketSelectionScreen(getDriver(),getDriverCapabilities());
		}
		else {
			LOGGER.error("Not able to click on Next button to navigate on next screen from Fourth intro screen");
			return null;
		}
		
	}
	public String getFourthScreenMainDescription() {
		return (intro_txt_large.getText());
		
	}
	
	public String getFourthScreenSmallDescription() {
		return (intro_txt_small.getText());
		
	}
	
	public String getFourthScreenNextButtonText() {
		return nextbutton.getText();
		
	}
	
	public String getFourthScreenSignInText() {
		return (skipintroscreens.getText());
	}
	
	public String getIntroScreenNumberText() {
		return (getIntroScreenNumber());
	}
}
