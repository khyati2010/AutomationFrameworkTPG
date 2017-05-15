package com.iambank.pages.SplashScreen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.pages.OnBoardingScreens.LegalNameScreen;
import com.iambank.pages.OnBoardingScreens.MarketSelectionScreen;
import com.iambank.pages.IntroScreens.*;
import com.iambank.pages.basepages.AppBasePage;

public class SplashScreen extends AppBasePage {

	public SplashScreen(AppiumDriver<MobileElement> driver, AppiumCapabilities driverCapabilities) {
        super(driver, driverCapabilities);
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public MarketSelectionScreen movetoMarketSelectionScreen() throws InterruptedException{  	
		return new MarketSelectionScreen (getDriver(), getDriverCapabilities());
    }
    
    public LegalNameScreen movetoLegalNameScreen() throws InterruptedException{  	
		return new LegalNameScreen (getDriver(), getDriverCapabilities());
    }
    
    public SignInScreen movetoSignInScreen() throws InterruptedException{   
    	  return new SignInScreen (getDriver(), getDriverCapabilities());
    	    }
    
    public WelcomeScreen movetoWelcomeScreen()throws InterruptedException{
    	return new WelcomeScreen(getDriver(), getDriverCapabilities());
    }
}
