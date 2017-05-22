package com.iambank.test.app.IntroScreens;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.iambank.execution.app.IAMBankAppInstance;
import com.iambank.execution.test.AppTestBase;
import com.iambank.pages.IntroScreens.FourthIntroScreen;
import com.iambank.pages.OnBoardingScreens.MarketSelectionScreen;

public class FourthIntroScreenTest extends AppTestBase{
	
	@Test(dataProvider=DEFAULT_PROVIDER)
	public void testFourthIntroScreenUI(IAMBankAppInstance app) throws IOException, InterruptedException {
		
		FourthIntroScreen fourthScreen = movetoFourthScreen(app);
		Assert.assertEquals(fourthScreen.getFourthScreenMainDescription(), "Let's get started.");
		Assert.assertEquals(fourthScreen.getFourthScreenSmallDescription(), "Applying for an account usually takes 2-3 minutes. Let's go!");	
		Assert.assertEquals(fourthScreen.getFourthScreenNextButtonText(), "Apply for a new account");  	
       	Assert.assertEquals(fourthScreen.getFourthScreenSignInText(), "I already have an account");    	
       	Assert.assertEquals(fourthScreen.getScreenNumber(), "4 OF 4");
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
