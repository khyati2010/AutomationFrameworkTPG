package com.iambank.pages.OnBoardingScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.configuration.framework.ScreenTitles;
import com.iambank.pages.basepages.AppBasePage;

public class AddressScreen extends AppBasePage {
			
	@AndroidFindBy(id = "et_addressLine1") 
	private MobileElement addressLine1;
	
	@AndroidFindBy(id = "et_addressLine2") 
	private MobileElement addressLine2;
	
	@AndroidFindBy(id = "et_city") 
	private MobileElement cityTextBox;
	
	@AndroidFindBy(id = "et_county") 
	private MobileElement regionTextBox;
	
	@AndroidFindBy(id = "et_postalCode") 
	private MobileElement postalCodeTextBox;
	
	@AndroidFindBy(id = "btn_next") 
	private MobileElement nextButton;
	private String idNextButton = "btn_next";

	public AddressScreen (AppiumDriver<MobileElement> driver, AppiumCapabilities driverCapabilities) {
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
		return ScreenTitles.Address.title();
	}
    
    public boolean isAddressLine1Displayed() {
    	return addressLine1.isDisplayed();
    }
    
    public boolean isAddressLine2Displayed() {
    	return addressLine2.isDisplayed();
    }
    
    public boolean isCityTextBoxDisplayed() {
    	return cityTextBox.isDisplayed();
    }
    
    public boolean isRegionTextBoxDisplayed() {
    	return regionTextBox.isDisplayed();
    }
    
    public boolean isPostalCodeTextBoxDisplayed() {
    	return postalCodeTextBox.isDisplayed();
    }
    
    public boolean isNextButtonDisplayed() {
    	return !getDriver().findElementsById(idNextButton).isEmpty();
    }
    
    public void clickNextButton() {
    	nextButton.click();
    }
    
    public AddressScreen enterAddress1(String address1){
    	addressLine1.sendKeys(address1);
    	return this;
    }
    
    public AddressScreen enterAddress2(String address2){
    	addressLine2.sendKeys(address2);
    	return this;    }
    
    public AddressScreen enterCity(String city){
    	cityTextBox.sendKeys(city);
    	return this;
    }
    
    public AddressScreen enterRegion(String region){
    	regionTextBox.sendKeys(region);
    	return this;
    }
    
    public AddressScreen enterPostalCode(String postalCode){
    	postalCodeTextBox.sendKeys(postalCode);
    	return this;
    }
}