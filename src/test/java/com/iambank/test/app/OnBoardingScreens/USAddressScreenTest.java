package com.iambank.test.app.OnBoardingScreens;

import com.iambank.execution.app.IAMBankAppInstance;
import com.iambank.execution.test.AppTestBase;
import com.iambank.pages.OnBoardingScreens.USAddressScreen;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;

public class USAddressScreenTest extends AppTestBase{
	
	
    public void verifyUSAddressScreenUI(IAMBankAppInstance app) throws Exception {
    	
    	USAddressScreen addressScreenUS = movingToUSAddressScreen(app);
    	Assert.assertTrue(addressScreenUS.isSupportIconDisplayed());
    	Assert.assertTrue(addressScreenUS.isWhyTextDisplayed());
    	Assert.assertTrue(addressScreenUS.isSignInTextDisplayed());
    	Assert.assertEquals(addressScreenUS.getIntroScreenNumber(), "STEP 6 OF 6");
    	Assert.assertTrue(addressScreenUS.isLargeTextPresent());
    	Assert.assertTrue(addressScreenUS.isSmallTextPresent());
    }
	
    public void verifyAddressFieldsUI(IAMBankAppInstance app) throws Exception {
    	USAddressScreen addressScreenUS = movingToUSAddressScreen(app);
    	
    }
    
    
	public USAddressScreen movingToUSAddressScreen(IAMBankAppInstance app) throws Exception {
		
		USAddressScreen addressScreenUS = app.startApp().movetoUSAddressScreen();
		return addressScreenUS;		
	}
  	

}
