package com.iambank.app.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.iambank.app.configuration.AppiumCapabilities;

public abstract class AppBasePage {

    protected static final Logger LOGGER = LogManager.getLogger(AppBasePage.class);
    private AppiumDriver<WebElement> driver;
    AppiumCapabilities environment;
	private AppiumCapabilities driverCapabilities;

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public AppBasePage(AppiumDriver driver, AppiumCapabilities environment) {
    	 this.driver = driver;
	     this.environment = environment;
	      LOGGER.info("Navigating to [{}]...", this.getClass().getSimpleName());
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

   protected AppiumCapabilities getDriverCapabilities() {
       return (AppiumCapabilities) driverCapabilities;
   }
   
   protected AppiumDriver<WebElement> getDriver() {
       return driver;
   }
}


