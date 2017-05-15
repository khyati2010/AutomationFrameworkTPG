package com.iambank.pages.IntroScreens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.configuration.framework.ScreenTitles;
import com.iambank.pages.OnBoardingScreens.MarketSelectionScreen;
import com.iambank.pages.basepages.AppBasePage;
import io.appium.java_client.functions.ExpectedCondition;

public class FirstIntroScreen extends AppBasePage  {
	
	private static final Logger log = LogManager.getLogger(FirstIntroScreen.class);
	
	
		public FirstIntroScreen(AppiumDriver driver, AppiumCapabilities environment)
	{
		super(driver, environment);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(nextbutton, "Seems straightforward."));

		log.info("Landed on first intro screen successfully");
	}
		
		public FirstIntroScreen(AppiumDriver driver, AppiumCapabilities environment,boolean skipstuff) throws InterruptedException
		{
			super(driver, environment);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.textToBePresentInElement(nextbutton, "Seems straightforward."));

			log.info("Landed on first intro screen successfully");
			clickSkipThisStuffLink();
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
			log.error("Not able to click on skip this stuff link");
			return null;
		}
	}
	
	public SecondIntroScreen clickFirstIntroNextButton()
	{
		
		if(nextbutton.isEnabled())
		{
			nextbutton.click();
			return new SecondIntroScreen(getDriver(), getDriverCapabilities());
		}
		else
		{
			log.error("Not able to click on Next button to navigate on next screen from Second intro screen");
			return null;
		}
		
	}
	public String getFirstScreenMainDescription()
	{
		return (intro_txt_large.getText());
		
	}
	
	public String getFirstScreenSmallDescription()
	{
		return (intro_txt_small.getText());
		
	}
	
	public String getFirstScreenNextButtonText()
	{
		return nextbutton.getText();
		
	}
	
	public String getFirstScreenSkipthisStuffLinkText()
	{
		return (skipintroscreens.getText());
	}
	
	public String getIntroScreenNumberText()
	{
		return (getIntroScreenNumber());
	}

}
