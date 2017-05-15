package com.iambank.pages.OnBoardingScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.configuration.framework.ScreenTitles;
import com.iambank.pages.basepages.AppBasePage;

public class LegalNameScreen extends AppBasePage {
	
	@AndroidFindBy(id = "legal_name")
	private MobileElement legalNameTextBox;

	public LegalNameScreen (AppiumDriver<MobileElement> driver, AppiumCapabilities driverCapabilities) {
        super (driver, driverCapabilities);
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Override
	public String expectedScreenTitle (){
		return ScreenTitles.LegalName.title();
	}
	
	public LegalNameScreen enterLegalName(String legalName) {
		legalNameTextBox.sendKeys(legalName);
    	return this;
    }
	
    public PhoneNumberScreen clickNextButton() {
    	nextButton.click();
    	try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return new PhoneNumberScreen(getDriver(), getDriverCapabilities());
    }
}