package com.iambank.pages.OnBoardingScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.support.PageFactory;

import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.configuration.framework.ScreenTitles;
import com.iambank.pages.basepages.AppBasePage;

public class ChoosePINScreen extends AppBasePage {

	private String xpathPinNumber = "//android.support.v7.widget.RecyclerView[@resource-id = 'com.iambank.debug:id/rvPinPad']";  
	private String idPinNumber = "tvPinNo" ;
	private String idNextButton = "ivNextButton" ;

	@AndroidFindBy(id = "ivHidePin") 
	private MobileElement hidePinButton;

	@AndroidFindBy(id = "ivShowPin") 
	private MobileElement showPinButton;

	@AndroidFindBy(id = "ivReset") 
	private MobileElement deletePinButton;

	public ChoosePINScreen (AppiumDriver<MobileElement> driver, AppiumCapabilities driverCapabilities) {
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
		return ScreenTitles.ChoosePIN.title();
	}

	public ChoosePINScreen chosePIN(String pinNumberText) {
		for(char number : pinNumberText.toCharArray()){
			Character.isDigit(number);
			int pinValue = Character.getNumericValue(number);
			getDriver().findElementByXPath(xpathPinNumber).findElementsById(idPinNumber).get(pinValue).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this;

	}

	public ChoosePINScreen hidePIN() {
		hidePinButton.click();
		return this;
	}

	public ChoosePINScreen showPIN() {
		showPinButton.click();
		return this;
	}

	public ChoosePINScreen deletePIN() {
		deletePinButton.click();
		return this;
	}

	public boolean isNextButtonDisplayed() {
		return !getDriver().findElementByXPath(xpathPinNumber).findElementsById(idNextButton).isEmpty();
	}

	public <T> T clickNextButton(Class<T> expectedPage) {
		getDriver().findElementByXPath(xpathPinNumber).findElementsById(idNextButton).get(0).click();
		return PageFactory.initElements(getDriver(), expectedPage);    
	}

}