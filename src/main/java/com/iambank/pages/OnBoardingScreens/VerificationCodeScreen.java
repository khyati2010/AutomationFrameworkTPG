package com.iambank.pages.OnBoardingScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.configuration.framework.ScreenTitles;
import com.iambank.pages.basepages.AppBasePage;

public class VerificationCodeScreen extends AppBasePage {
	
	@AndroidFindBy(id = "verify_phone_edit_text")
	private MobileElement enterVerificationCodeTextBox;
	
	@AndroidFindBy(id = "bottom_btn_next")
	private MobileElement nextBottomButton;

	public VerificationCodeScreen (AppiumDriver<MobileElement> driver, AppiumCapabilities driverCapabilities) {
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
		return ScreenTitles.VerificationCode.title();
	}
		
	public VerificationCodeScreen enterVerificationCode(String verificationCode) {
		enterVerificationCodeTextBox.sendKeys(verificationCode);
		getDriver().hideKeyboard();
    	return this;
    }
	
    public ChoosePINScreen clickNextButton() {
    	nextBottomButton.click();
    	return new ChoosePINScreen(getDriver(), getDriverCapabilities());
    }
}