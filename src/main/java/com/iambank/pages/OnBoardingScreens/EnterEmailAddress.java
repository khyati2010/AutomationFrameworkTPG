package com.iambank.pages.OnBoardingScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.configuration.framework.ScreenTitles;
import com.iambank.pages.basepages.AppBasePage;

public class EnterEmailAddress extends AppBasePage {

	@AndroidFindBy(id = "bottom_btn_next") 
	private MobileElement nextButton;

	@AndroidFindBy(id = "skip") 
	private MobileElement skipButton;

	public EnterEmailAddress (AppiumDriver<MobileElement> driver, AppiumCapabilities driverCapabilities) {
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
		return ScreenTitles.EnterEmailAddress.title();
	}

	public ThanksScreen clickCompleteProfileButton(){
		skipButton.click();
		return new ThanksScreen(getDriver(), getDriverCapabilities());
	}
}