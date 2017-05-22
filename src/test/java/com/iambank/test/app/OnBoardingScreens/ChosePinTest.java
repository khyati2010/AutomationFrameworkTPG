package com.iambank.test.app.OnBoardingScreens;

import org.testng.annotations.Test;
import com.iambank.configuration.framework.PhoneNumberCountryName;
import com.iambank.execution.app.IAMBankAppInstance;
import com.iambank.execution.test.AppTestBase;
import com.iambank.pages.OnBoardingScreens.ChoosePINScreen;
import org.testng.Assert;

public class ChosePinTest extends AppTestBase {
	
	String legalName = "Test User";
	String phoneNumber = "9910178908";
	String verificationCode = "12345";
	String countryName = "UK";
	boolean skipPopUp = true;
	String pinNumber = "12345";

	@Test(dataProvider = DEFAULT_PROVIDER, priority = 1)
	public void verifyVerificationCodeScreenisDisplayed(IAMBankAppInstance app) throws Exception {
		ChoosePINScreen choosePINScreen = movingToChosePinScreen(app, countryName, phoneNumber, false, legalName, verificationCode );	
		Assert.assertEquals(choosePINScreen.getTitle(), choosePINScreen.expectedScreenTitle());
	}

	@Test(dataProvider = DEFAULT_PROVIDER, priority = 3)
	public void verifyNextButtonValidations(IAMBankAppInstance app) throws Exception {		
		ChoosePINScreen choosePINScreen = movingToChosePinScreen(app, countryName, phoneNumber, false, legalName, verificationCode )	
				.chosePIN(pinNumber);
				Assert.assertTrue(choosePINScreen.isNextButtonDisplayed());
				choosePINScreen.hidePIN();
				choosePINScreen.showPIN();
				choosePINScreen.deletePIN();
				Assert.assertFalse(choosePINScreen.isNextButtonDisplayed());
	}
	
	@Test(dataProvider = DEFAULT_PROVIDER, priority = 2)
	public void verifyVerificationCodeScreenUI(IAMBankAppInstance app) throws Exception {
		ChoosePINScreen choosePINScreen = movingToChosePinScreen(app, countryName, phoneNumber, false, legalName, verificationCode );	
		Assert.assertTrue(choosePINScreen.isSignInTextDisplayed());
		Assert.assertTrue(choosePINScreen.isWhyTextDisplayed());
		Assert.assertTrue(choosePINScreen.isSupportIconDisplayed());
	}
	
	public ChoosePINScreen movingToChosePinScreen (IAMBankAppInstance app, String countryName, String phoneNumber, boolean skipPopUp, String legalName
			, String verificationCode) throws Exception {
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
				.clickNextButton();
		return choosePINScreen;
	}
}
