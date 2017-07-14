package com.app.pages.baseclasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.app.driver.instance.WebDriverProxy;

public abstract class BasePage {

	protected static final Logger LOGGER = LogManager.getLogger(BasePage.class);
	protected WebDriverProxy driver;
	public int TimeoutValue = 30;

	protected BasePage(WebDriverProxy driver) {
		this.driver = driver;
		LOGGER.info("Navigating to [{}]...", this.getClass().getSimpleName());
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TimeoutValue), this);       
	}

	protected WebDriverProxy getDriver() {
		return driver;
	}
}


