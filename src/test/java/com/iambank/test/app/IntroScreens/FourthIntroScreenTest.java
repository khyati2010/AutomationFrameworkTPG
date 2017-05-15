package com.iambank.test.app.IntroScreens;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iambank.execution.app.IAMBankAppInstance;
import com.iambank.execution.test.AppTestBase;
import com.iambank.pages.IntroScreens.FirstIntroScreen;
import com.iambank.pages.IntroScreens.FourthIntroScreen;
import com.iambank.pages.IntroScreens.SecondIntroScreen;
import com.iambank.pages.IntroScreens.ThirdIntroScreen;
import com.iambank.pages.IntroScreens.WelcomeScreen;
import com.iambank.pages.OnBoardingScreens.MarketSelectionScreen;
import com.iambank.pages.SplashScreen.SignInScreen;

public class FourthIntroScreenTest extends AppTestBase{
	
	@Test(dataProvider=DEFAULT_PROVIDER ,priority = 1)
	public void testThirdScreenTexts(IAMBankAppInstance app) throws IOException, InterruptedException {
		FourthIntroScreen fourthscreen = movetoFourthScreen(app);
		Assert.assertEquals(fourthscreen.getFourthScreenMainDescription(), "Let's get started.");
		Assert.assertEquals(fourthscreen.getFourthScreenSmallDescription(), "Applying for an account usually takes 2-3 minutes. Let's go!");	
		Assert.assertEquals(fourthscreen.getFourthScreenNextButtonText(), "Apply for a new account");  	
       	Assert.assertEquals(fourthscreen.getFourthScreenSignInText(), "I already have an account");    	
       	Assert.assertEquals(fourthscreen.getIntroScreenNumberText(), "4 OF 4");
	}
	
	@Test(dataProvider = DEFAULT_PROVIDER , priority = 2 )
	  public void testNextButtonFunctionality(IAMBankAppInstance app ) throws IOException, InterruptedException {
		FourthIntroScreen fourthscreen = movetoFourthScreen(app);
		MarketSelectionScreen marketscreen = fourthscreen.clickFourthIntroNextButton();
		Assert.assertTrue(marketscreen.getTitle().contains(marketscreen.expectedScreenTitle()));
	}
	
	@Test(dataProvider = DEFAULT_PROVIDER , priority = 3 )
	public void testSignInLink(IAMBankAppInstance app) throws IOException, InterruptedException {
		FourthIntroScreen fourthscreen = movetoFourthScreen(app);
		fourthscreen.clickAlreadyhaveAccount();
		logger.info("Landed on Sign in screen");
	}
	
	public FourthIntroScreen movetoFourthScreen(IAMBankAppInstance app) throws IOException,InterruptedException {
		WelcomeScreen welcomescreen = app.startApp().movetoWelcomeScreen();
		FirstIntroScreen firstscreen = welcomescreen.clickWelcomeScreenNextButton();
		SecondIntroScreen secondscreen = firstscreen.clickFirstIntroNextButton();
		ThirdIntroScreen thirdscreen = secondscreen.clickSecondIntroNextButton();
		return(thirdscreen.clickThirdIntroNextButton());
	}

}
