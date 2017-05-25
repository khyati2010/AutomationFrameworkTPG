package com.iambank.test.app.IntroScreens;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.iambank.execution.app.IAMBankAppInstance;
import com.iambank.execution.test.AppTestBase;
import com.iambank.pages.IntroScreens.SecondIntroScreen;
import com.iambank.pages.IntroScreens.FirstIntroScreen;
import com.iambank.pages.OnBoardingScreens.MarketSelectionScreen;

public class FirstIntroScreenTest extends AppTestBase{
		
	@Test(dataProvider =DEFAULT_PROVIDER, groups="Smoke_Suite")
	public void testFirstIntroScreenUI(IAMBankAppInstance app) throws IOException, InterruptedException {	
		
		FirstIntroScreen firstIntroScreen = moveToWelcomeScreen(app);
		Assert.assertEquals(firstIntroScreen.getFirstScreenMainDescription(), "We never charge negative fees.");		
		Assert.assertEquals(firstIntroScreen.getFirstScreenSmallDescription(), "Ever.");	
		Assert.assertEquals(firstIntroScreen.getFirstScreenNextButtonText(), "Seems straightforward.");       	
       	Assert.assertEquals(firstIntroScreen.getFirstScreenSkipthisStuffLinkText(), "Skip this stuff");       	
       	Assert.assertEquals(firstIntroScreen.getScreenNumber(), "1 OF 4"); 
	}
	
	@Test(dataProvider = DEFAULT_PROVIDER)
	  public void testNextButtonFunctionality(IAMBankAppInstance app ) throws IOException, InterruptedException {
		
		SecondIntroScreen secondScreen = moveToWelcomeScreen(app)
				.clickFirstIntroNextButton();
		Assert.assertEquals(secondScreen.getScreenNumber(), "2 OF 4");		  
	 }
	
	@Test(dataProvider =DEFAULT_PROVIDER, groups="Smoke_Suite")
	  public void testSkipintroscreenFunctionality(IAMBankAppInstance app ) throws IOException, InterruptedException {
		 
		 MarketSelectionScreen marketScreen = moveToWelcomeScreen(app)		 
				 .clickSkipThisStuffLink();
		 Assert.assertTrue(marketScreen.getTitle().contains(marketScreen.expectedScreenTitle()));			  
	 }
	
	public FirstIntroScreen moveToWelcomeScreen(IAMBankAppInstance app) throws IOException, InterruptedException {
		
		FirstIntroScreen firstScreen = app.startApp()
				.movetoWelcomeScreen()
				.clickWelcomeScreenNextButton();										
		return firstScreen;
	}
		
}
