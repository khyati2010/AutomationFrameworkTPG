package com.iambank.test.app.IntroScreens;

import com.iambank.configuration.framework.IntroScreenTitles;
import com.iambank.execution.app.IAMBankAppInstance;
import com.iambank.execution.test.AppTestBase;
import com.iambank.pages.IntroScreens.WelcomeScreen;
import com.iambank.pages.IntroScreens.FirstIntroScreen;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class WelcomeScreenTest extends AppTestBase {

    @Test(dataProvider = DEFAULT_PROVIDER)
    public void testFirstIntroScreenTexts(IAMBankAppInstance app) throws IOException, InterruptedException {
    	WelcomeScreen welcomeScreen = app.startApp().movetoWelcomeScreen(); 
        Assert.assertEquals(welcomeScreen.getWelcomeScreenMainDescription(), IntroScreenTitles.WelcomeScreen.title());    	 
      	Assert.assertEquals(welcomeScreen.getWelcomeScreenSmallDescription(), IntroScreenTitles.WelcomeScreenSmallText.title());      	
       	Assert.assertEquals(welcomeScreen.getWelcomeScreenNextButtonText(), IntroScreenTitles.WelcomeScreenBttnText.title());      	
       	Assert.assertEquals(welcomeScreen.getWelcomeScreenSignInLinkText(), IntroScreenTitles.WelcomeScreenSignInText.title());      	       
    }
    
  @Test(dataProvider = DEFAULT_PROVIDER)
  public void testNextButtonFunctionality(IAMBankAppInstance app ) throws IOException, InterruptedException {
	  FirstIntroScreen firstScreen = app.startApp().movetoWelcomeScreen()
			  .clickWelcomeScreenNextButton();
	  Assert.assertEquals(firstScreen.getFirstScreenNextButtonText(), IntroScreenTitles.FourthIntroBttnText.title());	  
  }
    
    
  @Test(dataProvider = DEFAULT_PROVIDER)
  public void testSignInFunctionality(IAMBankAppInstance app ) throws IOException, InterruptedException {
	  WelcomeScreen welcomescreen = app.startApp().movetoWelcomeScreen();
	  welcomescreen.clickSignIn();  	  
  }
        
}