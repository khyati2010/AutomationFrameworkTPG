package com.iambank.test.app.IntroScreens;

import com.iambank.execution.app.IAMBankAppInstance;
import com.iambank.execution.test.AppTestBase;
import com.iambank.pages.IntroScreens.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

public class WelcomeScreenTest extends AppTestBase {


	
    @Test(dataProvider = DEFAULT_PROVIDER ,  priority = 1)
    public void testFirstIntroScreenTexts(IAMBankAppInstance app) throws IOException, InterruptedException {
    	WelcomeScreen welcomescreen = app.startApp().movetoWelcomeScreen(); 
        Assert.assertEquals(welcomescreen.getWelcomeScreenMainDescription(), "We're a different kind of bank.");    	 
      	Assert.assertEquals(welcomescreen.getWelcomeScreenSmallDescription(), "Give us a chance, and we'll prove it.");      	
       	Assert.assertEquals(welcomescreen.getWelcomeScreenNextButtonText(), "Ok, so prove it!");      	
       	Assert.assertEquals(welcomescreen.getWelcomeScreenSignInLinkText(), "Sign In");      	       
    }
    
  @Test(dataProvider = DEFAULT_PROVIDER ,  priority = 2)
  public void testNextButtonFunctionality(IAMBankAppInstance app ) throws IOException, InterruptedException
  {
	  WelcomeScreen welcomescreen = app.startApp().movetoWelcomeScreen();
	  FirstIntroScreen firstscreen = welcomescreen.clickWelcomeScreenNextButton();
	  Assert.assertEquals(firstscreen.getFirstScreenNextButtonText(), "Seems straightforward.");
	  
  }
    
    
  @Test(dataProvider = DEFAULT_PROVIDER , priority = 3)
  public void testSignInFunctionality(IAMBankAppInstance app ) throws IOException, InterruptedException
  {
	  WelcomeScreen welcomescreen = app.startApp().movetoWelcomeScreen();
	  welcomescreen.clickSignIn();
	   
	  
  }
    
    
    
}