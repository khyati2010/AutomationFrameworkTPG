package com.iambank.test.app.OnBoardingScreens;

import org.testng.annotations.Test;
import com.iambank.configuration.framework.PhoneNumberCountryName;
import com.iambank.execution.app.IAMBankAppInstance;
import com.iambank.execution.test.AppTestBase;
import com.iambank.pages.OnBoardingScreens.ChoosePINScreen;
import com.iambank.pages.OnBoardingScreens.VerificationCodeScreen;
import org.testng.Assert;

public class VerficationCodeTest extends AppTestBase {
	
	String phoneNumber = "01234567890";

	@Test(dataProvider = DEFAULT_PROVIDER, priority = 1)
	public void verifyVerificationCodeScreenisDisplayed(IAMBankAppInstance app) throws Exception {
		VerificationCodeScreen verificationCodeScreen = movingToVerificationCodeScreen(app, "UK", phoneNumber, false);	
		Assert.assertTrue(verificationCodeScreen.getTitle().contains(verificationCodeScreen.expectedScreenTitle()));
	}

	@Test(dataProvider = DEFAULT_PROVIDER, priority = 3)
	public void verifyNextButtonClick(IAMBankAppInstance app) throws Exception {
		String verificationCode = "12345";
		ChoosePINScreen choosePINScreen = movingToVerificationCodeScreen(app, "UK", phoneNumber, false)
				.enterVerificationCode(verificationCode)
				.clickNextButton();
		Assert.assertEquals(choosePINScreen.getTitle(), choosePINScreen.expectedScreenTitle());
	}
	
	@Test(dataProvider = DEFAULT_PROVIDER, priority = 2)
	public void verifyVerificationCodeScreenUI(IAMBankAppInstance app) throws Exception {
		VerificationCodeScreen verificationCodeScreen = movingToVerificationCodeScreen(app, "UK", phoneNumber, false);	
		Assert.assertTrue(verificationCodeScreen.isSignInTextDisplayed());
		Assert.assertTrue(verificationCodeScreen.isWhyTextDisplayed());
		Assert.assertTrue(verificationCodeScreen.isSupportIconDisplayed());
	}
	
	public VerificationCodeScreen movingToVerificationCodeScreen(IAMBankAppInstance app, String countryName, String phoneNumber, boolean skipPopUp ) throws Exception {
		String legalName = "TestUser";
		VerificationCodeScreen verificationCodeScreen = app.startApp()
				.movetoMarketSelectionScreen()
				.selectCountry(countryName)
				.clickNextButton()
				.enterLegalName(legalName)
				.clickNextButton()
				.selectCountry(PhoneNumberCountryName.UK)
				.enterPhoneNumber(phoneNumber)
				.clickNextButton(skipPopUp);
		return verificationCodeScreen;
	}
}
