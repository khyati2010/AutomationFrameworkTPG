package com.iambank.pages.IntroScreens;

import com.iambank.pages.basepages.AppBasePage;
import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.pages.OnBoardingScreens.MarketSelectionScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SecondIntroScreen extends AppBasePage{
	
	public SecondIntroScreen(AppiumDriver<MobileElement> driver, AppiumCapabilities environment) {
		super(driver, environment);
		waitForElement(skipIntroScreens, 10);
	}
	
	public MarketSelectionScreen clickSkipThisStuffLink() throws InterruptedException {
		skipIntroScreens.click();
		return new MarketSelectionScreen(getDriver(), getDriverCapabilities());		
	}
	
	public ThirdIntroScreen clickSecondIntroNextButton() {
		introNextButton.click();
		return new ThirdIntroScreen(getDriver(),getDriverCapabilities());		
	}
	
	public String getSecondScreenMainDescription() {
		return largeText.getText();		
	}
	
	public String getSecondScreenSmallDescription() {
		return smallText.getText();		
	}
	
	public String getSecondScreenNextButtonText() {
		return introNextButton.getText();		
	}
	
	public String getSecondScreenSkipthisStuffLinkText() {
		return skipIntroScreens.getText();
	}	
	
}
