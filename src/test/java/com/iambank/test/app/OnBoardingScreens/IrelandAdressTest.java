package com.iambank.test.app.OnBoardingScreens;

import org.testng.annotations.Test;
import com.iambank.execution.app.IAMBankAppInstance;
import com.iambank.execution.test.AppTestBase;
import com.iambank.pages.OnBoardingScreens.AddressScreen;
import org.testng.Assert;

public class IrelandAdressTest extends AppTestBase {
	
	String address1 = "Test Address1";
	String address2 = "Test Address2";
	String city = "TestCity";
	String region = "TestRegion";
	String postalCode = "12345";

	@Test(dataProvider = DEFAULT_PROVIDER, priority = 1)
	public void verifyCorrectAdressScreenisDisplayed(IAMBankAppInstance app) throws Exception {
		AddressScreen addressScreen = movingToAdressScreen();	
		Assert.assertEquals(addressScreen.getTitle(), addressScreen.expectedScreenTitle());
	}

	@Test(dataProvider = DEFAULT_PROVIDER, priority = 3)
	public void verifyNextButtonValidations(IAMBankAppInstance app) throws Exception {		
		AddressScreen addressScreen = movingToAdressScreen();
		addressScreen.enterAddress1(address1);
		addressScreen.enterCity(city);
		addressScreen.enterPostalCode(postalCode);
		Assert.assertTrue(addressScreen.isNextButtonDisplayed());
		addressScreen.enterAddress2(address2);
		addressScreen.enterRegion(region);
		addressScreen.clickNextButton();
		Assert.assertEquals("", "");
	}
	
	@Test(dataProvider = DEFAULT_PROVIDER, priority = 2)
	public void verifyVerificationCodeScreenUI(IAMBankAppInstance app) throws Exception {
		AddressScreen addressScreen = movingToAdressScreen();	
		Assert.assertTrue(addressScreen.isAddressLine1Displayed());
		Assert.assertTrue(addressScreen.isAddressLine2Displayed());
		Assert.assertTrue(addressScreen.isCityTextBoxDisplayed());
		Assert.assertTrue(addressScreen.isRegionTextBoxDisplayed());
		Assert.assertTrue(addressScreen.isPostalCodeTextBoxDisplayed());
		Assert.assertTrue(addressScreen.isSignInTextDisplayed());
		Assert.assertTrue(addressScreen.isWhyTextDisplayed());
		Assert.assertTrue(addressScreen.isSupportIconDisplayed());
	}
	
	//To-Do
	public AddressScreen movingToAdressScreen() throws Exception {
		AddressScreen addressScreen  = null;
		return addressScreen;
	}
}
