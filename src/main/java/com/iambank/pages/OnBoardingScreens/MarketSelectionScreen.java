package com.iambank.pages.OnBoardingScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.configuration.framework.ScreenTitles;
import com.iambank.pages.basepages.AppBasePage;

public class MarketSelectionScreen extends AppBasePage {
	
	public MarketSelectionScreen(AppiumDriver<MobileElement> driver, AppiumCapabilities driverCapabilities) throws InterruptedException {
        super (driver, driverCapabilities);
        Thread.sleep(10000);
    }

	public MarketSelectionScreen(AppiumDriver<MobileElement> driver, AppiumCapabilities driverCapabilities, boolean skipIntro) {
        super(driver, driverCapabilities);
        if (skipIntro) {
        }
    }
    
    @Override
    public String expectedScreenTitle (){
		return ScreenTitles.MarketSelection.title();
	}
    
    public MarketSelectionScreen selectCountry(String countryName) {
    	MobileElement countryButton = getDriver().findElementById(countryName.toLowerCase()+"_imageBtn");
    	countryButton.click();
    	return this;
    }
    
    public LegalNameScreen clickNextButton() {
    	nextButton.click();
    	return new LegalNameScreen(getDriver(), getDriverCapabilities());
    }
}