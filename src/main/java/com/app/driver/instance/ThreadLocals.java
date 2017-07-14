package com.app.driver.instance;

import org.openqa.selenium.WebDriver;

public class ThreadLocals {
	public static ThreadLocal<WebDriver> commonDriver = new ThreadLocal<WebDriver>();

	/**
	 * @return the commonDriver
	 */
	public static WebDriver getCommonDriver() {
		return commonDriver.get();
	}

	/**
	 * @param commonDriver the commonDriver to set
	 */
	public static void setCommonDriver(WebDriver driver) {
		commonDriver.set(driver);
	}
}
