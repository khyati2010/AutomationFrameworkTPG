package com.iambank.test.app.SprintDemo;

import org.testng.annotations.Test;
import com.iambank.configuration.framework.PhoneNumberCountryName;
import com.iambank.execution.app.IAMBankAppInstance;
import com.iambank.execution.test.AppTestBase;
import com.iambank.pages.OnBoardingScreens.ChoosePINScreen;
import org.testng.Assert;

public class Sprint2DemoTest extends AppTestBase {

	String legalName = "Test User";
	String phoneNumber = "9910178908";
	String verificationCode = "12345";
	String countryName = "UK";
	boolean skipPopUp = true;
	String pinNumber = "12345";

	@Test(dataProvider = DEFAULT_PROVIDER)
	public void verifyNextButtonClick(IAMBankAppInstance app) throws Exception {
		ChoosePINScreen choosePINScreen= app.startApp().movetoWelcomeScreen()
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
				.clickNextButton();
		Assert.assertEquals(choosePINScreen.getTitle(), choosePINScreen.expectedScreenTitle());
		choosePINScreen.chosePIN(pinNumber);
		Assert.assertTrue(choosePINScreen.isNextButtonDisplayed());
		choosePINScreen.hidePIN();
		choosePINScreen.showPIN();
		choosePINScreen.deletePIN();
		Assert.assertFalse(choosePINScreen.isNextButtonDisplayed());
	}

}
