package com.iambank.pages.OnBoardingScreens;

import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.configuration.framework.ScreenTitles;
import com.iambank.pages.basepages.AppBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class USAddressScreen extends AppBasePage{
	
	@AndroidFindBy(id = "tl_addressLine1")
	private MobileElement addressLine1;
	
	@AndroidFindBy(id = "tl_addressLine2")
	private MobileElement addressLineOptional;
	
	@AndroidFindBy(id ="tl_city")
	private MobileElement cityUS;
	
	@AndroidFindBy(id = "tl_county")
	private MobileElement stateUS;
	
	@AndroidFindBy(id = "tl_postalCode")
	private MobileElement zipUS;
	
	@AndroidFindBy(id = "btn_next")
	private MobileElement nextButtonUS;
	
	

	public USAddressScreen(AppiumDriver<MobileElement> driver, AppiumCapabilities driverCapabilities) {
		super(driver, driverCapabilities);
		waitForElement(zipUS, 10);
	}
	
	@Override
	protected String expectedScreenTitle() {
		return ScreenTitles.Address.title();
	}
	
	public USAddressScreen enterAddressLine1(String address1) {
		addressLine1.sendKeys(address1);
		return this;
	}
	
	public USAddressScreen enterAddressLine2(String address2) {
		addressLineOptional.sendKeys(address2);
		return this;
	}
	
	public USAddressScreen enterCity(String city) {
		cityUS.sendKeys(city);;
		return this;
	}
	
	public USAddressScreen enterState(String state) {
		stateUS.sendKeys(state);
		return this;
	}
	
	public USAddressScreen enterZip(String zip) {
		zipUS.sendKeys(zip);
		return this;
	}
	
	public SSNScreen clickNextButton() {
		nextButtonUS.click();
		return new SSNScreen(getDriver(), getDriverCapabilities());
	}
	
	public boolean isLargeTextPresent() {
		return largeText.getText().equals("Where do you live?");
	}
	
	public boolean isSmallTextPresent() {
		return smallText.getText().equals("So we can send you a shiny new card.");
	}
	
	public boolean isAddressLine1TextPresent() {
		return addressLine1.getText().equals("Address Line 1");
	}
	
	public boolean isAddressLineOptionalTextPresent() {
		return addressLineOptional.getText().equals("Address Line 2 (optional)");
	}
	
	public boolean isCityTextPresent() {
		return cityUS.getText().equals("City");
	}
	
	public boolean isStateTextPresent() {
		return stateUS.getText().equals("State");
	}
	
	public boolean isZipTextPresent() {
		return zipUS.getText().equals("Zip");
	}
	
	
}
