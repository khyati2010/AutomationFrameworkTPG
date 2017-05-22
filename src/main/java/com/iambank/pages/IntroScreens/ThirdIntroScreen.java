package com.iambank.pages.IntroScreens;


import com.iambank.pages.basepages.AppBasePage;
import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.pages.OnBoardingScreens.MarketSelectionScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ThirdIntroScreen extends AppBasePage {

	public ThirdIntroScreen(AppiumDriver<MobileElement> driver, AppiumCapabilities driverCapabilities) {
		super(driver, driverCapabilities);
		waitForElement(introNextButton, 10);
	}
	
	public MarketSelectionScreen clickSkipThisStuffLink() throws InterruptedException {
		skipIntroScreens.click();
		return new MarketSelectionScreen(getDriver(), getDriverCapabilities());		
	}
	
	public FourthIntroScreen clickThirdIntroNextButton() {		
		introNextButton.click();
		return new FourthIntroScreen(getDriver(),getDriverCapabilities());		
	}
	
	public String getThirdScreenMainDescription() {
		return (largeText.getText());		
	}
	
	public String getThirdScreenSmallDescription() {
		return (smallText.getText());		
	}
	
	public String getThirdScreenNextButtonText() {
		return introNextButton.getText();		
	}
	
	public String getThirdScreenSkipthisStuffLinkText() {
		return skipIntroScreens.getText();
	}
	
}
