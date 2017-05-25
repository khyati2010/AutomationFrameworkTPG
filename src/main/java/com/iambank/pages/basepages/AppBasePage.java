package com.iambank.pages.basepages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.HashMap;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.configuration.framework.ScreenTitles;

public abstract class AppBasePage extends BasePage{

	@AndroidFindBy(id = "intro_big_txt")
	protected MobileElement screenTitle;

	@AndroidFindBy(id = "bottom_btn_name")
	protected MobileElement nextButton;
	
	@AndroidFindBy(id = "supportIcon")
	protected MobileElement supportIcon;
	
	@AndroidFindBy(id = "why_txt")
	protected MobileElement whyText;
	
	@AndroidFindBy(id = "sign_in_txt")
	protected MobileElement signInText;
	
	@AndroidFindBy(id="bottom_btn")
	protected MobileElement nextBottomButton;

	@AndroidFindBy(id="bottom_btn")
	protected MobileElement introNextButton;
	
	@AndroidFindBy(id="bottom_text")
	protected MobileElement skipIntroScreens;
			
	@AndroidFindBy(id="intro_big_txt")
	protected MobileElement largeText;
	
	@AndroidFindBy(id="intro_small_txt") 
	protected MobileElement smallText;
	
	@AndroidFindBy(id="tv_progress")
	protected MobileElement screenNumber;

	protected AppBasePage(AppiumDriver<MobileElement> driver, AppiumCapabilities driverCapabilities) {
		super(driver, driverCapabilities);
	}
	
	protected AppBasePage(AppiumDriver<MobileElement> driver, AppiumCapabilities driverCapabilities, boolean skipIntro) {
		super(driver, driverCapabilities);
	}
	   
	protected String expectedScreenTitle (){
		return ScreenTitles.UNKNOWN.title();
	}
	
    public boolean isSupportIconDisplayed() {
    	return supportIcon.isDisplayed();
    }  
    
    public boolean isWhyTextDisplayed() {
    	return whyText.getText().equals("Why?");
    }  
    
    public boolean isSignInTextDisplayed() {
    	return signInText.getText().equals("Sign in");
    }  
    
    public String getTitle() {
    	return screenTitle.getText();
    }  
    
    public String getScreenNumber()
 	{
 		return screenNumber.getText();
 	}
    
    protected void waitForElement(MobileElement element , long waitforseconds){
    	WebDriverWait wait = new WebDriverWait(getDriver(), waitforseconds);
    	wait.until(ExpectedConditions.visibilityOf(element));    	
    }
    
    public boolean isElementEnabled(MobileElement element){
    	return element.isEnabled();
    }
    
    public void screenScroll(MobileElement fromElement , MobileElement toElement) {
//    	Dimension dimensions = getDriver().manage().window().getSize();
//		Double screenHeightStart = dimensions.getHeight() * 0.5;
//		int scrollStart = screenHeightStart.intValue();
//		Double screenHeightEnd = dimensions.getHeight() * 0.2;
//		int scrollEnd = screenHeightEnd.intValue();
//		int startx = dimensions.width / 2;
//		 new TouchAction(getDriver()).press(24, scrollEnd)
//				.moveTo(24, scrollStart).release().perform();
    	
    	TouchAction act = new TouchAction(getDriver());
		act.longPress(fromElement).moveTo(toElement).release().perform();		 	 
    }

}


