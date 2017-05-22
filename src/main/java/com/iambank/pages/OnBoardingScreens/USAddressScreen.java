package com.iambank.pages.OnBoardingScreens;


import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.configuration.framework.ScreenTitles;
import com.iambank.pages.basepages.AppBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class USAddressScreen extends AddressScreen{
	
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
		 try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@Override
	public String expectedScreenTitle() {
		return ScreenTitles.Address.title();
	}
	
	public USAddressScreen enterAddressLine1(String address1) {
		addressLine1.click();
		addressLine1.sendKeys(address1);
		getDriver().hideKeyboard();
		return this;
	}
	
	public USAddressScreen enterAddressLine2(String address2) {
		addressLineOptional.click();
		addressLineOptional.sendKeys(address2);
		getDriver().hideKeyboard();
		return this;
	}
	
	public USAddressScreen enterCity(String city) {
		cityUS.click();
		cityUS.sendKeys(city);
		getDriver().hideKeyboard();
		return this;
	}
	
	public USAddressScreen enterState(String state) {
		stateUS.click();
		stateUS.sendKeys(state);
		getDriver().hideKeyboard();
		return this;
	}
	
	public USAddressScreen enterZip(String zip) {
		screenScroll(stateUS, addressLine1);
		zipUS.click();
		zipUS.sendKeys(zip);
		getDriver().hideKeyboard();
		return this;
	}
	
	public SSNScreen clickNextButton() {
		screenScroll(zipUS, cityUS);
		nextButtonUS.click();
		return new SSNScreen(getDriver(), getDriverCapabilities());
	}
	
	public String getLargeText() {
		return largeText.getText();
	}
	
	public String getSmallText() {
		return smallText.getText();
	}
	
	public String getAddressLine1Text() {
		return addressLine1.getText();
	}
	
	public String getAddressLineOptionalText() {
		return addressLineOptional.getText();
	}
	
	public String getCityText() {
		return cityUS.getText();
	}
	
	public String getStateText() {
		return stateUS.getText();
	}
	
	public String getZipText() {
		screenScroll(stateUS, addressLine1);
		return zipUS.getText();
	}
	
			
}
