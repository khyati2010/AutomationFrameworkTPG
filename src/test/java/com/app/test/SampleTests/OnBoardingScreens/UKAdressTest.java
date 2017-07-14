package com.iambank.test.app.OnBoardingScreens;

import org.testng.annotations.Test;

import com.iambank.configuration.framework.PhoneNumberCountryName;
import com.iambank.execution.app.IAMBankAppInstance;
import com.iambank.execution.test.AppTestBase;
import com.iambank.pages.OnBoardingScreens.AddressScreen;
import com.iambank.pages.OnBoardingScreens.ChoosePINScreen;
import com.iambank.pages.OnBoardingScreens.USAddressScreen;
import com.iambank.pages.OnBoardingScreens.UploadDocumentScreen;

import org.testng.Assert;

public class UKAdressTest extends AppTestBase {
	String legalName = "Test User";
	String phoneNumber = "9910178908";
	String verificationCode = "12345";
	String countryName = "UK";
	boolean skipPopUp = true;
	String pinNumber = "12345";
	String address1 = "Test Address1";
	String address2 = "Test Address2";
	String city = "TestCity";
	String region = "TestRegion";
	String postalCode = "12345";

	@Test(dataProvider = DEFAULT_PROVIDER, priority = 1)
	public void verifyCorrectAdressScreenisDisplayed(IAMBankAppInstance app) throws Exception {
		AddressScreen addressScreen = movingToAdressScreen(app, countryName, phoneNumber, false, legalName, verificationCode, pinNumber);	
		Assert.assertEquals(addressScreen.getTitle(), addressScreen.expectedScreenTitle());
	}

	@Test(dataProvider = DEFAULT_PROVIDER, priority = 3)
	public void verifyNextButtonValidations(IAMBankAppInstance app) throws Exception {		
		AddressScreen addressScreen = movingToAdressScreen(app, countryName, phoneNumber, false, legalName, verificationCode, pinNumber);	
		addressScreen.enterAddress1(address1);
		addressScreen.enterCity(city);
		addressScreen.enterPostalCode(postalCode);
		Assert.assertTrue(addressScreen.isNextButtonDisplayed());
		addressScreen.enterAddress2(address2);
		addressScreen.enterRegion(region);
		UploadDocumentScreen uploadDocumentScreen = addressScreen.clickNextButton(UploadDocumentScreen.class);
		Assert.assertEquals(uploadDocumentScreen.getTitle(), uploadDocumentScreen.expectedScreenTitle());
	}
	
	@Test(dataProvider = DEFAULT_PROVIDER, priority = 2)
	public void verifyVerificationCodeScreenUI(IAMBankAppInstance app) throws Exception {
		AddressScreen addressScreen = movingToAdressScreen(app, countryName, phoneNumber, false, legalName, verificationCode, pinNumber);	
		Assert.assertTrue(addressScreen.isAddressLine1Displayed());
		Assert.assertTrue(addressScreen.isAddressLine2Displayed());
		Assert.assertTrue(addressScreen.isCityTextBoxDisplayed());
		Assert.assertTrue(addressScreen.isRegionTextBoxDisplayed());
		Assert.assertTrue(addressScreen.isPostalCodeTextBoxDisplayed());
		Assert.assertTrue(addressScreen.isSignInTextDisplayed());
		Assert.assertTrue(addressScreen.isWhyTextDisplayed());
		Assert.assertTrue(addressScreen.isSupportIconDisplayed());
	}
	
	@SuppressWarnings("unchecked")
	public <T> T  movingToAdressScreen (IAMBankAppInstance app, String countryName, String phoneNumber, boolean skipPopUp, String legalName
			, String verificationCode, String pinNumber) throws Exception {
		ChoosePINScreen choosePINScreen = app.startApp().movetoWelcomeScreen()
				.clickWelcomeScreenNextButton()
				.clickFirstIntroNextButton()
				.clickSkipThisStuffLink()
				.selectCountry(countryName)
				.clickNextButton()
				.enterLegalName(legalName)
				.clickNextButton()
				.selectCountry(PhoneNumberCountryName.India)
				.enterPhoneNumber(phoneNumber)
				.clickNextButton(skipPopUp)
				.enterVerificationCode(verificationCode)
				.clickNextButton()
				.chosePIN(pinNumber);

		if(countryName != "USA"){
			AddressScreen addressScreen = choosePINScreen.clickNextButton(AddressScreen.class);
			return (T) addressScreen;
		}
		else {
			USAddressScreen usAddressScreen = choosePINScreen.clickNextButton(USAddressScreen.class);
			return (T) usAddressScreen;
		}  

	}
}
