package com.iambank.test.app.IntroScreens;

import java.io.IOException;
import com.iambank.pages.IntroScreens.ThirdIntroScreen;
import com.iambank.pages.IntroScreens.SecondIntroScreen;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.iambank.execution.app.IAMBankAppInstance;
import com.iambank.execution.test.AppTestBase;
import com.iambank.pages.OnBoardingScreens.MarketSelectionScreen;

public class SecondIntroScreenTest extends AppTestBase{
	
	@Test(dataProvider = DEFAULT_PROVIDER)
	public void testSecondIntroScreenUI(IAMBankAppInstance app) throws IOException, InterruptedException {
		SecondIntroScreen secondScreen = moveToSecondScreen(app);
		Assert.assertEquals(secondScreen.getSecondScreenMainDescription(), "Use everyday shopping to pay off your debt.");
		Assert.assertEquals(secondScreen.getSecondScreenSmallDescription(), "At zero cost to you. There are no catches, sorry.");
		Assert.assertEquals(secondScreen.getSecondScreenNextButtonText(), "I'm listening.");     	
       	Assert.assertEquals(secondScreen.getSecondScreenSkipthisStuffLinkText(), "Skip this stuff");       	
       	Assert.assertEquals(secondScreen.getScreenNumber(), "2 OF 4");		
	}
	
	@Test(dataProvider = DEFAULT_PROVIDER) 
	  public void testNextButtonFunctionality(IAMBankAppInstance app ) throws IOException, InterruptedException  {
		ThirdIntroScreen thirdScreen = moveToSecondScreen(app)
				.clickSecondIntroNextButton();
		Assert.assertEquals(thirdScreen.getScreenNumber(), "3 OF 4");		  
	  }
	
	 @Test(dataProvider = DEFAULT_PROVIDER)
	  public void testSkipIntroScreenFunctionality(IAMBankAppInstance app ) throws IOException, InterruptedException  {
		 MarketSelectionScreen marketScreen = moveToSecondScreen(app)
				 .clickSkipThisStuffLink();
		 Assert.assertTrue(marketScreen.getTitle().contains(marketScreen.expectedScreenTitle()));			  
	  }
	
		public SecondIntroScreen moveToSecondScreen(IAMBankAppInstance app) throws IOException, InterruptedException {
			SecondIntroScreen secondScreen = app.startApp()
					.movetoWelcomeScreen()
					.clickWelcomeScreenNextButton()
					.clickFirstIntroNextButton();
			return secondScreen;
	}

}
