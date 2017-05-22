package com.iambank.test.app.IntroScreens;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iambank.configuration.framework.IntroScreenTitles;
import com.iambank.execution.app.IAMBankAppInstance;
import com.iambank.execution.test.AppTestBase;
import com.iambank.pages.IntroScreens.SecondIntroScreen;
import com.iambank.pages.IntroScreens.FirstIntroScreen;
import com.iambank.pages.OnBoardingScreens.MarketSelectionScreen;

public class FirstIntroScreenTest extends AppTestBase{
		
	@Test(dataProvider =DEFAULT_PROVIDER)
	public void testFirstIntroScreenUI(IAMBankAppInstance app) throws IOException, InterruptedException {	
		
		FirstIntroScreen firstIntroScreen = moveToWelcomeScreen(app);
		Assert.assertEquals(firstIntroScreen.getFirstScreenMainDescription(), IntroScreenTitles.FirstIntroScreen.title());		
		Assert.assertEquals(firstIntroScreen.getFirstScreenSmallDescription(),IntroScreenTitles.FirstIntroSmallText.title() );	
		Assert.assertEquals(firstIntroScreen.getFirstScreenNextButtonText(), IntroScreenTitles.FirstIntroBttnText.title());       	
       	Assert.assertEquals(firstIntroScreen.getFirstScreenSkipthisStuffLinkText(), IntroScreenTitles.IntroSkipText.title());       	
       	Assert.assertEquals(firstIntroScreen.getScreenNumber(), IntroScreenTitles.FirstIntroScreenNumber.title()); 
	}
	
	@Test(dataProvider = DEFAULT_PROVIDER)
	  public void testNextButtonFunctionality(IAMBankAppInstance app ) throws IOException, InterruptedException {
		
		SecondIntroScreen secondScreen = moveToWelcomeScreen(app)
				.clickFirstIntroNextButton();
		Assert.assertEquals(secondScreen.getScreenNumber(), IntroScreenTitles.SecondIntroScreenNumber.title());		  
	 }
	
	 @Test(dataProvider = DEFAULT_PROVIDER)
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
