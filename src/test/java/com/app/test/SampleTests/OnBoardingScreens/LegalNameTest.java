package com.iambank.test.app.OnBoardingScreens;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.iambank.execution.app.IAMBankAppInstance;
import com.iambank.execution.test.AppTestBase;
import com.iambank.pages.OnBoardingScreens.LegalNameScreen;
import com.iambank.pages.OnBoardingScreens.PhoneNumberScreen;

public class LegalNameTest extends AppTestBase {

	@Test(dataProvider = DEFAULT_PROVIDER)
	public void verifyLegalNameScreenisDisplayed(IAMBankAppInstance app) throws Exception {
		LegalNameScreen legalNameScreen = movingToLegalNameScreen(app, "UK");
		Assert.assertTrue(legalNameScreen.getTitle().contains(legalNameScreen.expectedScreenTitle()));
	}

	@Test(dataProvider = DEFAULT_PROVIDER)
	public void verifyNextButtonClick(IAMBankAppInstance app) throws Exception {
		String legalName = "TestUser";
		LegalNameScreen legalNameScreen = movingToLegalNameScreen(app, "UK");
		PhoneNumberScreen phoneNumberScreen = legalNameScreen.enterLegalName(legalName).clickNextButton();
		Assert.assertEquals(phoneNumberScreen.getTitle(), phoneNumberScreen.expectedScreenTitle());
	}

	@Test(dataProvider = DEFAULT_PROVIDER)
	public void verifyLegalNameScreenUI(IAMBankAppInstance app) throws Exception {
		LegalNameScreen legalNameScreen = movingToLegalNameScreen(app, "UK");
		Assert.assertTrue(legalNameScreen.isSignInTextDisplayed());
		Assert.assertTrue(legalNameScreen.isWhyTextDisplayed());
		Assert.assertTrue(legalNameScreen.isSupportIconDisplayed());
	}

	private LegalNameScreen movingToLegalNameScreen(IAMBankAppInstance app, String countryName) throws Exception {
		LegalNameScreen legalNameScreen = app.startApp().movetoWelcomeScreen().clickWelcomeScreenNextButton()
				.clickFirstIntroNextButton().clickSkipThisStuffLink().selectCountry(countryName).clickNextButton();
		return legalNameScreen;
	}
}
