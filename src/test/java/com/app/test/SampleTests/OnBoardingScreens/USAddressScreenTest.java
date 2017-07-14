package com.iambank.test.app.OnBoardingScreens;

import com.iambank.configuration.framework.PhoneNumberCountryName;
import com.iambank.configuration.framework.ScreenTitles;
import com.iambank.execution.app.IAMBankAppInstance;
import com.iambank.execution.test.AppTestBase;
import com.iambank.pages.OnBoardingScreens.AddressScreen;
import com.iambank.pages.OnBoardingScreens.ChoosePINScreen;
import com.iambank.pages.OnBoardingScreens.SSNScreen;
import com.iambank.pages.OnBoardingScreens.USAddressScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class USAddressScreenTest extends AppTestBase{

	String legalName = "Test User";
	String phoneNumber = "9910178908";
	String verificationCode = "12345";
	String countryName = "UK";
	boolean skipPopUp = true;
	String pinNumber = "12345";
	String address1 = "Test Address1";
	String address2 = "Test Address2";
	String city = "TestCity";
	String state = "TestRegion";
	String zip = "12345";

	@Test(dataProvider = DEFAULT_PROVIDER)
	public void verifyUSAddressScreenUI(IAMBankAppInstance app) throws Exception {
		USAddressScreen addressScreenUS =  movingToAdressScreen(app, countryName, phoneNumber, false, legalName, verificationCode, pinNumber);
		Assert.assertTrue(addressScreenUS.isSupportIconDisplayed());
		Assert.assertTrue(addressScreenUS.isWhyTextDisplayed());
		Assert.assertTrue(addressScreenUS.isSignInTextDisplayed());
		Assert.assertEquals(addressScreenUS.getScreenNumber(),ScreenTitles.AddressScreenNumber.title());
		Assert.assertEquals(addressScreenUS.getLargeText(), ScreenTitles.Address.title());
		Assert.assertEquals(addressScreenUS.getSmallText(), ScreenTitles.AddressSmallText.title());     	
	}

	@Test(dataProvider = DEFAULT_PROVIDER)
	public void verifyAddressFieldsUI (IAMBankAppInstance app) throws Exception {
		USAddressScreen addressScreenUS =  movingToAdressScreen(app, countryName, phoneNumber, false, legalName, verificationCode, pinNumber);    	
		Assert.assertEquals(addressScreenUS.getAddressLine1Text(), ScreenTitles.AddressLine1Text.title());
		Assert.assertEquals(addressScreenUS.getAddressLineOptionalText(), ScreenTitles.AddressLineOptionalText.title());
		Assert.assertEquals(addressScreenUS.getCityText(), ScreenTitles.CityText.title());
		Assert.assertEquals(addressScreenUS.getStateText(), ScreenTitles.StateText.title());    	
		Assert.assertEquals(addressScreenUS.getZipText(), ScreenTitles.ZipText.title());   	
	}

	@Test(dataProvider = DEFAULT_PROVIDER)
	public void verifyNextButtonClick(IAMBankAppInstance app) throws Exception {
		USAddressScreen addressScreenUS =  movingToAdressScreen(app, countryName, phoneNumber, false, legalName, verificationCode, pinNumber);
		addressScreenUS.enterAddressLine1("Street No.- A1/8")
		.enterAddressLine2("near grocery shop")
		.enterCity("Plainsborow")
		.enterState("NEW Jersey")
		.enterZip("893982");

		SSNScreen sSNScreen = addressScreenUS.clickNextButton();
		Assert.assertEquals(sSNScreen.getTitle(), sSNScreen.expectedScreenTitle());
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
