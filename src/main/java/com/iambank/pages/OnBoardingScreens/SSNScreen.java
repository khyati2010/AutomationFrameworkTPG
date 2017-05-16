package com.iambank.pages.OnBoardingScreens;

import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.configuration.framework.ScreenTitles;
import com.iambank.pages.basepages.AppBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SSNScreen extends AppBasePage{
	
	@AndroidFindBy(id = "edt_ssn")
	private MobileElement ssnTextBox;
	
	@AndroidFindBy(id = "tvDocumentPhoto")
	private MobileElement uploadDocumentLink;

	protected SSNScreen(AppiumDriver<MobileElement> driver, AppiumCapabilities driverCapabilities) {
		super(driver, driverCapabilities);
		// TODO Auto-generated constructor stub
		waitForElement(ssnTextBox, 10);	
	}
	
	@Override
	public String expectedScreenTitle (){
		return ScreenTitles.SSN.title();
	}
	
	public SSNScreen enterSSN(String socialSecurityNumber) {
		ssnTextBox.sendKeys(socialSecurityNumber);
		return this;
	}
	
	public void clickNextButton() {
		nextButton.click();		
	}
	
	public void clickUploadDocument() {
		uploadDocumentLink.click();		
	}

	
}
