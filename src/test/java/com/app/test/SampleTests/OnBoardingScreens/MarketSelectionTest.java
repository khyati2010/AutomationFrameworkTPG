package com.iambank.test.app.OnBoardingScreens;

import org.testng.annotations.Test;
import com.iambank.execution.app.IAMBankAppInstance;
import com.iambank.execution.test.AppTestBase;
import com.iambank.pages.OnBoardingScreens.LegalNameScreen;
import com.iambank.pages.OnBoardingScreens.MarketSelectionScreen;
import org.testng.Assert;

public class MarketSelectionTest extends AppTestBase {

	@Test(dataProvider = DEFAULT_PROVIDER, priority = 1)
	public void verifyMarketSelectionScreenisDisplayed(IAMBankAppInstance app) throws Exception {
		MarketSelectionScreen marketSelectionScreen = app.startApp().movetoWelcomeScreen()
				.clickWelcomeScreenNextButton()
				.clickFirstIntroNextButton()
				.clickSkipThisStuffLink();
		Assert.assertTrue(marketSelectionScreen.getTitle().contains(marketSelectionScreen.expectedScreenTitle()));
	}

	@Test(dataProvider = DEFAULT_PROVIDER, priority = 3)
	public void verifyNextButtonClick(IAMBankAppInstance app) throws Exception {
		String countryName = "UK";
		LegalNameScreen legalNameScreen = app.startApp()
				.movetoMarketSelectionScreen()
				.selectCountry(countryName)
				.clickNextButton();  
		Assert.assertEquals(legalNameScreen.getTitle(), legalNameScreen.expectedScreenTitle());
	}

	@Test(dataProvider = DEFAULT_PROVIDER, priority = 2)
	public void verifyMarketSelectionScreenUI(IAMBankAppInstance app) throws Exception {
		MarketSelectionScreen marketSelectionScreen = app.startApp()
				.movetoMarketSelectionScreen();	
		Assert.assertTrue(marketSelectionScreen.isSignInTextDisplayed());
		Assert.assertTrue(marketSelectionScreen.isWhyTextDisplayed());
		Assert.assertTrue(marketSelectionScreen.isSupportIconDisplayed());
	}

}
