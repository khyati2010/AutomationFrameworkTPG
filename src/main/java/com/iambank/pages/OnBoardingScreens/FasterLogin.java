package com.iambank.pages.OnBoardingScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.configuration.framework.ScreenTitles;
import com.iambank.pages.basepages.AppBasePage;

public class FasterLogin extends AppBasePage {

	@AndroidFindBy(id = "btn_allowFingerPrint") 
	private MobileElement buttonAllowFingerPrint;

	@AndroidFindBy(id = "tv_skip") 
	private MobileElement skipButton;

	public FasterLogin (AppiumDriver<MobileElement> driver, AppiumCapabilities driverCapabilities) {
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
		return ScreenTitles.FasterLogin.title();
	}

	public ThanksScreen clickCompleteProfileButton(){
		skipButton.click();
		return new ThanksScreen(getDriver(), getDriverCapabilities());
	}
	
	public EnterEmailAddress clickAllowFingerPrint(){
		buttonAllowFingerPrint.click();
		return new EnterEmailAddress(getDriver(), getDriverCapabilities());
	}
}