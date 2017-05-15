package com.iambank.test.app.IntroScreens;

import java.io.IOException;
import com.iambank.pages.IntroScreens.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.iambank.execution.app.IAMBankAppInstance;
import com.iambank.execution.test.AppTestBase;
import com.iambank.pages.OnBoardingScreens.MarketSelectionScreen;

public class SecondIntroScreenTest extends AppTestBase{
	
	@Test(dataProvider = DEFAULT_PROVIDER , priority = 1)
	public void testSecondScreenTexts(IAMBankAppInstance app) throws IOException, InterruptedException {
		SecondIntroScreen secondscreen = moveToSecondScreen(app);
		Assert.assertEquals(secondscreen.getSecondScreenMainDescription(), "Use everyday shopping to pay off your debt.");
		Assert.assertEquals(secondscreen.getSecondScreenSmallDescription(), "At zero cost to you. There are no catches, sorry.");
		Assert.assertEquals(secondscreen.getSecondScreenNextButtonText(), "I'm listening.");     	
       	Assert.assertEquals(secondscreen.getSecondScreenSkipthisStuffLinkText(), "Skip this stuff");       	
       	Assert.assertEquals(secondscreen.getIntroScreenNumberText(), "2 OF 4");		
	}
	
	@Test(dataProvider = DEFAULT_PROVIDER , priority = 2 )
	  public void testNextButtonFunctionality(IAMBankAppInstance app ) throws IOException, InterruptedException
	  {
		SecondIntroScreen secondscreen = moveToSecondScreen(app);
		ThirdIntroScreen thirdscreen = secondscreen.clickSecondIntroNextButton();
		Assert.assertEquals(thirdscreen.getIntroScreenNumberText(), "3 OF 4");		  
	  }
	
	 @Test(dataProvider = DEFAULT_PROVIDER , priority = 3)
	  public void testSkipintroscreenFunctionality(IAMBankAppInstance app ) throws IOException, InterruptedException
	  {
		 SecondIntroScreen secondscreen = moveToSecondScreen(app);
		 MarketSelectionScreen marketscreen = secondscreen.clickSkipThisStuffLink();
		 Assert.assertTrue(marketscreen.getTitle().contains(marketscreen.expectedScreenTitle()));
		 //Assert.assertEquals(marketscreen.getIntroScreenNumberText(), "STEP 0 OF 6");		  
	  }
	
	@Test(dataProvider = DEFAULT_PROVIDER)
	public SecondIntroScreen moveToSecondScreen(IAMBankAppInstance app) throws IOException, InterruptedException{
		WelcomeScreen welcomescreen = app.startApp().movetoWelcomeScreen();
		FirstIntroScreen firstscreen= welcomescreen.clickWelcomeScreenNextButton();
		return(firstscreen.clickFirstIntroNextButton());	
	}

}
