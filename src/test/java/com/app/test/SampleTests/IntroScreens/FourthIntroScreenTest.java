package com.iambank.test.app.IntroScreens;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iambank.configuration.framework.IntroScreenTitles;
import com.iambank.execution.app.IAMBankAppInstance;
import com.iambank.execution.test.AppTestBase;
import com.iambank.pages.IntroScreens.FourthIntroScreen;
import com.iambank.pages.OnBoardingScreens.MarketSelectionScreen;

public class FourthIntroScreenTest extends AppTestBase{
	
	@Test(dataProvider=DEFAULT_PROVIDER)
	public void testFourthIntroScreenUI(IAMBankAppInstance app) throws IOException, InterruptedException {
		
		FourthIntroScreen fourthScreen = movetoFourthScreen(app);
		Assert.assertEquals(fourthScreen.getFourthScreenMainDescription(), IntroScreenTitles.FourthIntroScreen.title());
		Assert.assertEquals(fourthScreen.getFourthScreenSmallDescription(), IntroScreenTitles.FourthIntroSmallText.title());	
		Assert.assertEquals(fourthScreen.getFourthScreenNextButtonText(), IntroScreenTitles.FourthIntroBttnText.title());  	
       	Assert.assertEquals(fourthScreen.getFourthScreenSignInText(), IntroScreenTitles.FourthIntroSignInText.title());    	
       	Assert.assertEquals(fourthScreen.getScreenNumber(), IntroScreenTitles.FourthIntroScreenNumber.title());
	}
	
	@Test(dataProvider = DEFAULT_PROVIDER)
	  public void testNextButtonFunctionality(IAMBankAppInstance app ) throws IOException, InterruptedException {
		
		MarketSelectionScreen marketScreen = movetoFourthScreen(app)
		  		.clickFourthIntroNextButton();
		Assert.assertTrue(marketScreen.getTitle().contains(marketScreen.expectedScreenTitle()));
	}
	
	@Test(dataProvider = DEFAULT_PROVIDER)
	public void testSignInLink(IAMBankAppInstance app) throws IOException, InterruptedException {
		
		FourthIntroScreen fourthScreen = movetoFourthScreen(app);
		fourthScreen.clickAlreadyhaveAccount();
	}
	
	public FourthIntroScreen movetoFourthScreen(IAMBankAppInstance app) throws IOException,InterruptedException {
		
		FourthIntroScreen fourthScreen = app.startApp()
				.movetoWelcomeScreen()
				.clickWelcomeScreenNextButton()
				.clickFirstIntroNextButton()
				.clickSecondIntroNextButton()
				.clickThirdIntroNextButton();
		return fourthScreen;
	}

}
