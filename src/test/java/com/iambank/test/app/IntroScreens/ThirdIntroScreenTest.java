package com.iambank.test.app.IntroScreens;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.iambank.execution.app.IAMBankAppInstance;
import com.iambank.execution.test.AppTestBase;
import com.iambank.pages.IntroScreens.*;
import com.iambank.pages.OnBoardingScreens.MarketSelectionScreen;

public class ThirdIntroScreenTest extends AppTestBase{
	
	@Test(dataProvider = DEFAULT_PROVIDER , priority = 1)
	public void testThirdScreenTexts(IAMBankAppInstance app) throws IOException, InterruptedException {
		ThirdIntroScreen thirdscreen = moveToSecondScreen(app);
		Assert.assertEquals(thirdscreen.getThirdScreenMainDescription(), "We have actual people you can talk to.");
		Assert.assertEquals(thirdscreen.getThirdScreenSmallDescription(), "A novel idea, but we hate talking to machines too.");	
		Assert.assertEquals(thirdscreen.getThirdScreenNextButtonText(), "Cool.");  	
       	Assert.assertEquals(thirdscreen.getThirdScreenSkipthisStuffLinkText(), "Skip this stuff");    	
       	Assert.assertEquals(thirdscreen.getIntroScreenNumberText(), "3 OF 4");
	}
	
	@Test(dataProvider = DEFAULT_PROVIDER , priority = 2 )
	  public void testNextButtonFunctionality(IAMBankAppInstance app ) throws IOException, InterruptedException
	  {
		ThirdIntroScreen thirdscreen = moveToSecondScreen(app);
		FourthIntroScreen fourthscreen = thirdscreen.clickThirdIntroNextButton();
		Assert.assertEquals(fourthscreen.getIntroScreenNumberText(), "4 OF 4");
		  
	  }
	
	 @Test(dataProvider = DEFAULT_PROVIDER , priority = 3)
	  public void testSkipintroscreenFunctionality(IAMBankAppInstance app ) throws IOException, InterruptedException
	  {
		 ThirdIntroScreen thirdscreen = moveToSecondScreen(app);
		 MarketSelectionScreen marketscreen = thirdscreen.clickSkipThisStuffLink();
		 Assert.assertTrue(marketscreen.getTitle().contains(marketscreen.expectedScreenTitle()));
		  
	  }
	
		public ThirdIntroScreen moveToSecondScreen(IAMBankAppInstance app) throws IOException, InterruptedException{
		WelcomeScreen welcomescreen = app.startApp().movetoWelcomeScreen();
		FirstIntroScreen firstscreen= welcomescreen.clickWelcomeScreenNextButton();
		SecondIntroScreen secondscreen = firstscreen.clickFirstIntroNextButton();
		return(secondscreen.clickSecondIntroNextButton());
		
	}

}
