package com.iambank.test.app.OnBoardingScreens;

import com.iambank.configuration.framework.PhoneNumberCountryName;
import com.iambank.configuration.framework.ScreenTitles;
import com.iambank.execution.app.IAMBankAppInstance;
import com.iambank.execution.test.AppTestBase;
import com.iambank.pages.OnBoardingScreens.SSNScreen;
import com.iambank.pages.OnBoardingScreens.USAddressScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class USAddressScreenTest extends AppTestBase{
	
	@Test(dataProvider = DEFAULT_PROVIDER)
    public void verifyUSAddressScreenUI(IAMBankAppInstance app) throws Exception {
    	
    	USAddressScreen addressScreenUS = movingToUSAddressScreen(app);
    	Assert.assertTrue(addressScreenUS.isSupportIconDisplayed());
    	Assert.assertTrue(addressScreenUS.isWhyTextDisplayed());
    	Assert.assertTrue(addressScreenUS.isSignInTextDisplayed());
    	Assert.assertEquals(addressScreenUS.getScreenNumber(),ScreenTitles.AddressScreenNumber.title());
    	Assert.assertEquals(addressScreenUS.getLargeText(), ScreenTitles.Address.title());
    	Assert.assertEquals(addressScreenUS.getSmallText(), ScreenTitles.AddressSmallText.title());     	
    }
	
	@Test(dataProvider = DEFAULT_PROVIDER)
    public void verifyAddressFieldsUI(IAMBankAppInstance app) throws Exception {
    	
		
    	USAddressScreen addressScreenUS = movingToUSAddressScreen(app);    	    	
    	Assert.assertEquals(addressScreenUS.getAddressLine1Text(), ScreenTitles.AddressLine1Text.title());
    	Assert.assertEquals(addressScreenUS.getAddressLineOptionalText(), ScreenTitles.AddressLineOptionalText.title());
    	Assert.assertEquals(addressScreenUS.getCityText(), ScreenTitles.CityText.title());
    	Assert.assertEquals(addressScreenUS.getStateText(), ScreenTitles.StateText.title());    	
    	Assert.assertEquals(addressScreenUS.getZipText(), ScreenTitles.ZipText.title());   	
    }
    
	@Test(dataProvider = DEFAULT_PROVIDER)
    public void verifyNextButtonClick(IAMBankAppInstance app) throws Exception {
    	movingToUSAddressScreen(app)
    			.enterAddressLine1("Street No.- A1/8")
    			.enterAddressLine2("near grocery shop")
    			.enterCity("Plainsborow")
    			.enterState("NEW Jersey")
    			.enterZip("893982")
    			.clickNextButton();
    }
    
    
	public USAddressScreen movingToUSAddressScreen(IAMBankAppInstance app) throws Exception {		
		USAddressScreen addressScreenUS = app.startApp()
				.movetoWelcomeScreen()
				.clickWelcomeScreenNextButton()
				.clickSkipThisStuffLink()
				.selectCountry("USA") .clickNextButton()
				.enterLegalName("Test USER2").clickNextButton()
				.selectCountry(PhoneNumberCountryName.India).enterPhoneNumber("9809155295").clickNextButton(false)
				.enterVerificationCode("74503").clickNextButton()
				.chosePIN("60938").clickNextButton(USAddressScreen.class);
					
				return addressScreenUS;	
				
	}
  	

}
