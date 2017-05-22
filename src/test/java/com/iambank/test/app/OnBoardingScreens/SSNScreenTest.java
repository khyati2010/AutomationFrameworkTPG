package com.iambank.test.app.OnBoardingScreens;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.iambank.configuration.framework.PhoneNumberCountryName;
import com.iambank.configuration.framework.ScreenTitles;
import com.iambank.execution.app.IAMBankAppInstance;
import com.iambank.execution.test.AppTestBase;
import com.iambank.pages.OnBoardingScreens.SSNScreen;

public class SSNScreenTest extends AppTestBase{
	
	@Test(dataProvider = DEFAULT_PROVIDER)
    public void verifySSNScreenUI(IAMBankAppInstance app) throws Exception {
		SSNScreen ssnScreen = movingtoSSNScreen(app);
		Assert.assertEquals(ssnScreen.getScreenNumber(), ScreenTitles.SSNScreenNumber.title());
		Assert.assertEquals(ssnScreen.getLargeText(),ScreenTitles.SSN.title());
		Assert.assertEquals(ssnScreen.getSmallText(),ScreenTitles.SSNSmallText.title());
		Assert.assertEquals(ssnScreen.getSSNFieldText(),ScreenTitles.SSNFieldText.title());
		Assert.assertEquals(ssnScreen.getDocumentUploadText(),ScreenTitles.SSNDocumentUploadText.title());		
	}
	
	public SSNScreen movingtoSSNScreen(IAMBankAppInstance app) throws Exception {
		SSNScreen ssnScreen = app.startApp()
				.movetoWelcomeScreen()
				.clickWelcomeScreenNextButton()
				.clickSkipThisStuffLink()
				.selectCountry("USA") .clickNextButton()
				.enterLegalName("Test USER2").clickNextButton()
				.selectCountry(PhoneNumberCountryName.India).enterPhoneNumber("9809155295").clickNextButton(false)
				.enterVerificationCode("74503").clickNextButton()
				.chosePIN("60938").clickNextButton();
		return ssnScreen;
	}

}
