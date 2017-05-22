package com.iambank.test.app.IntroScreens;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.iambank.execution.app.IAMBankAppInstance;
import com.iambank.execution.test.AppTestBase;
import com.iambank.pages.IntroScreens.*;
import com.iambank.pages.OnBoardingScreens.MarketSelectionScreen;

public class ThirdIntroScreenTest extends AppTestBase{
	
	@Test(dataProvider = DEFAULT_PROVIDER)
	public void testThirdScreenTexts(IAMBankAppInstance app) throws IOException, InterruptedException {
		ThirdIntroScreen thirdScreen = moveToSecondScreen(app);
		Assert.assertEquals(thirdScreen.getThirdScreenMainDescription(), "We have actual people you can talk to.");
		Assert.assertEquals(thirdScreen.getThirdScreenSmallDescription(), "A novel idea, but we hate talking to machines too.");	
		Assert.assertEquals(thirdScreen.getThirdScreenNextButtonText(), "Cool.");  	
       	Assert.assertEquals(thirdScreen.getThirdScreenSkipthisStuffLinkText(), "Skip this stuff");    	
       	Assert.assertEquals(thirdScreen.getScreenNumber(), "3 OF 4");
	}
	
	@Test(dataProvider = DEFAULT_PROVIDER)
	public void testNextButtonFunctionality(IAMBankAppInstance app ) throws IOException, InterruptedException {
		 FourthIntroScreen fourthScreen = moveToSecondScreen(app)
		 		.clickThirdIntroNextButton();
		Assert.assertEquals(fourthScreen.getScreenNumber(), "4 OF 4");
		  
	  }
	
	 @Test(dataProvider = DEFAULT_PROVIDER)
	public void testSkipintroscreenFunctionality(IAMBankAppInstance app ) throws IOException, InterruptedException {
		 MarketSelectionScreen marketScreen = moveToSecondScreen(app)
				 .clickSkipThisStuffLink();
		 Assert.assertTrue(marketScreen.getTitle().contains(marketScreen.expectedScreenTitle()));		  
	  }
	
	public ThirdIntroScreen moveToSecondScreen(IAMBankAppInstance app) throws IOException, InterruptedException {
		ThirdIntroScreen thirdScreen = app.startApp()
				.movetoWelcomeScreen()
				.clickWelcomeScreenNextButton()
				.clickFirstIntroNextButton()
				.clickSecondIntroNextButton();
		return thirdScreen;		
	}

}
