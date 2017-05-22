package com.iambank.test.app.IntroScreens;

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
        Assert.assertEquals(welcomeScreen.getWelcomeScreenMainDescription(), "We're a different kind of bank.");    	 
      	Assert.assertEquals(welcomeScreen.getWelcomeScreenSmallDescription(), "Give us a chance, and we'll prove it.");      	
       	Assert.assertEquals(welcomeScreen.getWelcomeScreenNextButtonText(), "Ok, so prove it!");      	
       	Assert.assertEquals(welcomeScreen.getWelcomeScreenSignInLinkText(), "Sign In");      	       
    }
    
  @Test(dataProvider = DEFAULT_PROVIDER)
  public void testNextButtonFunctionality(IAMBankAppInstance app ) throws IOException, InterruptedException {
	  FirstIntroScreen firstScreen = app.startApp().movetoWelcomeScreen()
			  .clickWelcomeScreenNextButton();
	  Assert.assertEquals(firstScreen.getFirstScreenNextButtonText(), "Seems straightforward.");	  
  }
    
    
  @Test(dataProvider = DEFAULT_PROVIDER)
  public void testSignInFunctionality(IAMBankAppInstance app ) throws IOException, InterruptedException {
	  WelcomeScreen welcomescreen = app.startApp().movetoWelcomeScreen();
	  welcomescreen.clickSignIn();  	  
  }
        
}