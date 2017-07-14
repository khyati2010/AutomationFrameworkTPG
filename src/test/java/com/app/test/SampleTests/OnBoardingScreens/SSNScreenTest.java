package com.iambank.test.app.OnBoardingScreens;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.iambank.configuration.framework.PhoneNumberCountryName;
import com.iambank.configuration.framework.ScreenTitles;
import com.iambank.execution.app.IAMBankAppInstance;
import com.iambank.execution.test.AppTestBase;
import com.iambank.pages.OnBoardingScreens.AddressScreen;
import com.iambank.pages.OnBoardingScreens.ChoosePINScreen;
import com.iambank.pages.OnBoardingScreens.SSNScreen;
import com.iambank.pages.OnBoardingScreens.USAddressScreen;

public class SSNScreenTest extends AppTestBase {

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
	public void verifySSNScreenUI(IAMBankAppInstance app) throws Exception {
		SSNScreen ssnScreen = movingtoSSNScreen (app, countryName, phoneNumber, false, legalName, verificationCode, pinNumber);
		Assert.assertEquals(ssnScreen.getScreenNumber(), ScreenTitles.SSNScreenNumber.title());
		Assert.assertEquals(ssnScreen.getLargeText(),ScreenTitles.SSN.title());
		Assert.assertEquals(ssnScreen.getSmallText(),ScreenTitles.SSNSmallText.title());
		Assert.assertEquals(ssnScreen.getSSNFieldText(),ScreenTitles.SSNFieldText.title());
		Assert.assertEquals(ssnScreen.getDocumentUploadText(),ScreenTitles.SSNDocumentUploadText.title());		
	}

	public SSNScreen movingtoSSNScreen (IAMBankAppInstance app, String countryName, String phoneNumber, boolean skipPopUp, String legalName
			, String verificationCode, String pinNumber) throws Exception {
		USAddressScreen usAddressScreen = app.startApp().movetoWelcomeScreen()
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
				.chosePIN(pinNumber)
				.clickNextButton(USAddressScreen.class);
		SSNScreen sSNScreen = usAddressScreen.enterAddressLine1(address1)
				.enterAddressLine2(address2)
				.enterCity(city)
				.enterState(state)
				.enterZip(zip)
				.clickNextButton();
		return sSNScreen;
	}

}
