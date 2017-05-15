package com.iambank.pages.IntroScreens;

import com.iambank.pages.basepages.AppBasePage;
import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.pages.OnBoardingScreens.*;

import io.appium.java_client.AppiumDriver;

public class FourthIntroScreen extends AppBasePage{

	public FourthIntroScreen(AppiumDriver driver, AppiumCapabilities driverCapabilities) {
		super(driver, driverCapabilities);
		// TODO Auto-generated constructor stub
	}
	
	public String getIntroScreenNumberText()
	{
		return (getIntroScreenNumber());
	}

}
