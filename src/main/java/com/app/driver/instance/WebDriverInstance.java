package com.app.driver.instance;

import org.springframework.beans.factory.annotation.Autowired;
import com.app.configuration.driver.DriverProperties;

public final class WebDriverInstance {

	@Autowired
	private DriverProperties driverProperties;	
	private WebDriverProxy driver;

	public WebDriverInstance(DriverProperties driverProperties) {
		this.driverProperties = driverProperties;
	}

	public WebDriverProxy getDriver() {
		if (driver == null) {
			DriverProperties driverProperties = getDriverProperties();
			driver = driverProperties.setDriver(driverProperties.getAppURL());
		}
		return driver;
	}

	public DriverProperties getDriverProperties() {
		return driverProperties;
	}

	public void cleanup() {
		getDriver().quit();	
	}
}
