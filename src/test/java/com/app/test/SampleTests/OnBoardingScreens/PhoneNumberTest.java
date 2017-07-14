package com.iambank.test.app.OnBoardingScreens;

import org.testng.annotations.Test;
import com.iambank.configuration.framework.PhoneNumberCountryName;
import com.iambank.execution.app.IAMBankAppInstance;
import com.iambank.execution.test.AppTestBase;
import com.iambank.pages.OnBoardingScreens.PhoneNumberScreen;
import com.iambank.pages.OnBoardingScreens.VerificationCodeScreen;
import org.testng.Assert;

public class PhoneNumberTest extends AppTestBase {

	@Test(dataProvider = DEFAULT_PROVIDER, priority = 1)
	public void verifyPhoneNumberScreenisDisplayed(IAMBankAppInstance app) throws Exception {
		PhoneNumberScreen phoneNumberScreen = movingToPhoneNumberScreen(app, "UK");	
		Assert.assertTrue(phoneNumberScreen.getTitle().contains(phoneNumberScreen.expectedScreenTitle()));
	}

	@Test(dataProvider = DEFAULT_PROVIDER, priority = 3)
	public void verifyNextButtonClick(IAMBankAppInstance app) throws Exception {
		String phoneNumber = "01234567890";
		VerificationCodeScreen verificationCodeScreen = movingToPhoneNumberScreen(app, "UK")
				.selectCountry(PhoneNumberCountryName.UK)
				.enterPhoneNumber(phoneNumber)
				.clickNextButton(true);	
		Assert.assertEquals(verificationCodeScreen.getTitle(), verificationCodeScreen.expectedScreenTitle());
	}
	
	@Test(dataProvider = DEFAULT_PROVIDER, priority = 2)
	public void verifyPhoneNumberScreenUI(IAMBankAppInstance app) throws Exception {
		PhoneNumberScreen phoneNumberScreen = movingToPhoneNumberScreen(app, "UK");	
		Assert.assertTrue(phoneNumberScreen.isSignInTextDisplayed());
		Assert.assertTrue(phoneNumberScreen.isWhyTextDisplayed());
		Assert.assertTrue(phoneNumberScreen.isSupportIconDisplayed());
	}
	
	public PhoneNumberScreen movingToPhoneNumberScreen(IAMBankAppInstance app, String countryName ) throws Exception {
		String legalName = "TestUser";
		PhoneNumberScreen phoneNumberScreen = app.startApp().movetoWelcomeScreen()
				.clickWelcomeScreenNextButton()
				.clickFirstIntroNextButton()
				.clickSkipThisStuffLink()
				.selectCountry(countryName)
				.clickNextButton()
				.enterLegalName(legalName)
				.clickNextButton();
		return phoneNumberScreen;
	}
}
