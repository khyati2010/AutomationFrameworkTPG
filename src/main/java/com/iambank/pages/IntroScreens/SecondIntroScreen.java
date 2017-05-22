package com.iambank.pages.IntroScreens;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.pages.OnBoardingScreens.MarketSelectionScreen;
import com.iambank.pages.basepages.AppBasePage;

import io.appium.java_client.AppiumDriver;

public class SecondIntroScreen extends AppBasePage{
	
	public SecondIntroScreen(AppiumDriver driver, AppiumCapabilities environment)
	{
		super(driver, environment);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(nextBottomButton, "I'm listening."));

		LOGGER.info("Landed on second intro screen successfully");
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
	
	public ThirdIntroScreen clickSecondIntroNextButton()
	{
		if(nextBottomButton.isEnabled())
		{
			nextBottomButton.click();
			return new ThirdIntroScreen(getDriver(),getDriverCapabilities());
		}
		else
		{
			LOGGER.error("Not able to click on Next button to navigate on next screen from Second intro screen");
			return null;
		}
		
	}
	public String getSecondScreenMainDescription()
	{
		return (intro_txt_large.getText());
		
	}
	
	public String getSecondScreenSmallDescription()
	{
		return (intro_txt_small.getText());
		
	}
	
	public String getSecondScreenNextButtonText()
	{
		return nextBottomButton.getText();
		
	}
	
	public String getSecondScreenSkipthisStuffLinkText()
	{
		return (skipintroscreens.getText());
	}
	
	public String getIntroScreenNumberText()
	{
		return (getIntroScreenNumber());
	}
	

}
