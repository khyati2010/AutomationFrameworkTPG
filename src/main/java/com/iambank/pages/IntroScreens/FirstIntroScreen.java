
package com.iambank.pages.IntroScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.pages.OnBoardingScreens.MarketSelectionScreen;
import com.iambank.pages.basepages.AppBasePage;


public class FirstIntroScreen extends AppBasePage  {
		
	public FirstIntroScreen(AppiumDriver<MobileElement> driver, AppiumCapabilities environment) {
		super(driver, environment);
		waitForElement(skipIntroScreens, 10);
	}
		
	public FirstIntroScreen(AppiumDriver<MobileElement> driver, AppiumCapabilities environment,boolean skipstuff) throws InterruptedException {
		super(driver, environment);
	}
				
	public MarketSelectionScreen clickSkipThisStuffLink() throws InterruptedException {
		skipIntroScreens.click();
		return new MarketSelectionScreen(getDriver(), getDriverCapabilities());		
	}
	
	public SecondIntroScreen clickFirstIntroNextButton(){
		introNextButton.click();
		return new SecondIntroScreen(getDriver(), getDriverCapabilities());		
	}
	
	public String getFirstScreenMainDescription() {
		return largeText.getText();		
	}
	
	public String getFirstScreenSmallDescription() {
		return smallText.getText();		
	}
	
	public String getFirstScreenNextButtonText() {
		return introNextButton.getText();		
	}
	
	public String getFirstScreenSkipthisStuffLinkText() {
		return skipIntroScreens.getText();
	}
	
}
