package com.iambank.pages.basepages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import com.iambank.configuration.app.AppiumCapabilities;

public abstract class BasePage {

    protected static final Logger LOGGER = LogManager.getLogger(BasePage.class);
    private AppiumDriver<MobileElement> driver;
	private AppiumCapabilities driverCapabilities;

	protected BasePage(AppiumDriver<MobileElement> driver, AppiumCapabilities driverCapabilities) {
    	 this.driver = driver;
	     this.driverCapabilities = driverCapabilities;
	      LOGGER.info("Navigating to [{}]...", this.getClass().getSimpleName());
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

   protected AppiumCapabilities getDriverCapabilities() {
       return (AppiumCapabilities) driverCapabilities;
   }
   
   protected AppiumDriver<MobileElement> getDriver() {
       return driver;
   }
}


