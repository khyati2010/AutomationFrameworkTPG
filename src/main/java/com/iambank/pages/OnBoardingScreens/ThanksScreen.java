package com.iambank.pages.OnBoardingScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.support.PageFactory;

import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.configuration.framework.ScreenTitles;
import com.iambank.pages.basepages.AppBasePage;

public class ThanksScreen extends AppBasePage {

	@AndroidFindBy(id = "complete_your_profile") 
	private MobileElement buttonCompleteYourProfile;

	public ThanksScreen (AppiumDriver<MobileElement> driver, AppiumCapabilities driverCapabilities) {
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
		return ScreenTitles.ThanksScreen.title();
	}

	public <T> T clickCompleteProfileButton (Class<T> expectedPage){
		buttonCompleteYourProfile.click();
		return PageFactory.initElements(getDriver(), expectedPage);
	}
}