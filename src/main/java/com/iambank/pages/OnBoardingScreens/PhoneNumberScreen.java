package com.iambank.pages.OnBoardingScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;
import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.configuration.framework.ScreenTitles;
import com.iambank.configuration.framework.PhoneNumberCountryName;
import com.iambank.pages.basepages.AppBasePage;

public class PhoneNumberScreen extends AppBasePage {

	@AndroidFindBy(id = "edt_phone")
	private MobileElement phoneNumberTextBox;

	@AndroidFindBy(id = "spinner")
	private MobileElement countrySelectionSpinner;

	@AndroidFindBy(xpath = "//android.widget.ListView")
	private MobileElement countrySelectionList;

	@AndroidFindBy(xpath= "//android.widget.LinearLayout") 
	private List<MobileElement> countryIconList;
	
	private String xpathPermissionAllowButton = "//*[@class='android.widget.Button'][2]";
	
	@AndroidFindBy(id = "btn_send")
	private MobileElement nextBttn;
	
	public PhoneNumberScreen (AppiumDriver<MobileElement> driver, AppiumCapabilities driverCapabilities) {
		super (driver, driverCapabilities);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String expectedScreenTitle (){
		return ScreenTitles.PhoneNumber.title();
	}

	public PhoneNumberScreen selectCountry(PhoneNumberCountryName countryName) {
		countrySelectionSpinner.click();
		switch (countryName.countryName()){
		case "United States" :
			countryIconList.get(0).click();
			break;
		case "United Kingdom" :
			countryIconList.get(countryIconList.size() - 4).click();
			break;
		case "Ireland" :
			countryIconList.get(countryIconList.size() - 3).click();
			break;
		case "India" :
			countryIconList.get(countryIconList.size() - 1).click();
			break;
		}
		return this;
	}

	public PhoneNumberScreen enterPhoneNumber(String phoneNumber) {
		phoneNumberTextBox.sendKeys(phoneNumber);
		return this;
	}

	public VerificationCodeScreen clickNextButton(boolean permissionPopUp) {
		nextBttn.click();
		if (permissionPopUp) {
			getDriver().findElement(MobileBy.xpath(xpathPermissionAllowButton)).click();
		}
		return new VerificationCodeScreen(getDriver(), getDriverCapabilities());
	}
}