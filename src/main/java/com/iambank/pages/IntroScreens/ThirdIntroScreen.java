package com.iambank.pages.IntroScreens;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.iambank.pages.basepages.AppBasePage;
import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.pages.OnBoardingScreens.*;

import io.appium.java_client.AppiumDriver;

public class ThirdIntroScreen extends AppBasePage {

	public ThirdIntroScreen(AppiumDriver driver, AppiumCapabilities driverCapabilities) {
		super(driver, driverCapabilities);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(nextbutton, "Cool."));

		LOGGER.info("Landed on Third intro screen successfully");
	}
	
	public MarketSelectionScreen clickSkipThisStuffLink() throws InterruptedException
	{
		if(skipintroscreens.isEnabled() )
		{
			skipintroscreens.click();
			return new MarketSelectionScreen(getDriver(), getDriverCapabilities());
		}
		
		else
		{
			LOGGER.error("Not able to click on skip this stuff link");
			return null;
		}
	}
	
	public FourthIntroScreen clickThirdIntroNextButton()
	{
		if(nextbutton.isEnabled())
		{
			nextbutton.click();
			return new FourthIntroScreen(getDriver(),getDriverCapabilities());
		}
		else
		{
			LOGGER.error("Not able to click on Next button to navigate on next screen from Second intro screen");
			return null;
		}
		
	}
	public String getThirdScreenMainDescription()
	{
		return (intro_txt_large.getText());
		
	}
	
	public String getThirdScreenSmallDescription()
	{
		return (intro_txt_small.getText());
		
	}
	
	public String getThirdScreenNextButtonText()
	{
		return nextbutton.getText();
		
	}
	
	public String getThirdScreenSkipthisStuffLinkText()
	{
		return (skipintroscreens.getText());
	}
	
	public String getIntroScreenNumberText()
	{
		return (getIntroScreenNumber());
	}

}
