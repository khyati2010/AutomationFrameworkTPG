package com.iambank.test.app.IntroScreens;

import java.io.IOException;
import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.iambank.execution.app.IAMBankAppInstance;
import com.iambank.execution.test.AppTestBase;
import com.iambank.pages.IntroScreens.*;
import com.iambank.pages.OnBoardingScreens.*;

public class FirstIntroScreenTest extends AppTestBase{
	
	@Test(dataProvider =DEFAULT_PROVIDER, priority = 1 )
	public void testSecondScreenTexts(IAMBankAppInstance app) throws IOException, InterruptedException
	{	
		FirstIntroScreen firstintroscreen = moveToWelcomeScreen(app);
		Assert.assertEquals(firstintroscreen.getFirstScreenMainDescription(), "We never charge negative fees.");		
		Assert.assertEquals(firstintroscreen.getFirstScreenSmallDescription(), "Ever.");	
		Assert.assertEquals(firstintroscreen.getFirstScreenNextButtonText(), "Seems straightforward.");       	
       	Assert.assertEquals(firstintroscreen.getFirstScreenSkipthisStuffLinkText(), "Skip this stuff");       	
       	Assert.assertEquals(firstintroscreen.getIntroScreenNumberText(), "1 OF 4"); 
	}
	
	@Test(dataProvider = DEFAULT_PROVIDER , priority = 2 )
	  public void testNextButtonFunctionality(IAMBankAppInstance app ) throws IOException, InterruptedException
	  {
		FirstIntroScreen firstintroscreen = moveToWelcomeScreen(app);
		SecondIntroScreen secondscreen = firstintroscreen.clickFirstIntroNextButton();
		Assert.assertEquals(secondscreen.getIntroScreenNumberText(), "2 OF 4");
		  
	  }
	
	 @Test(dataProvider = DEFAULT_PROVIDER , priority = 3)
	  public void testSkipintroscreenFunctionality(IAMBankAppInstance app ) throws IOException, InterruptedException
	  {
		 FirstIntroScreen firstintroscreen = moveToWelcomeScreen(app);
		 MarketSelectionScreen marketscreen = firstintroscreen.clickSkipThisStuffLink();
		 Assert.assertTrue(marketscreen.getTitle().contains(marketscreen.expectedScreenTitle()));
		// Assert.assertEquals(marketscreen.getIntroScreenNumberText(), "STEP 0 OF 6");
		   
		  
	  }
	
	@Test(dataProvider =DEFAULT_PROVIDER)
	public FirstIntroScreen moveToWelcomeScreen(IAMBankAppInstance app) throws IOException, InterruptedException
	{
		WelcomeScreen welcomescreen = app.startApp().movetoWelcomeScreen();
		
		return(welcomescreen.clickWelcomeScreenNextButton());
		
	}
		
	}
