package com.app.test.baseclasses;

import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.DataProvider;

import com.app.configuration.driver.DriverConfig;
import com.app.driver.instance.WebDriverInstance;
import com.iambank.pages.SampleScreens.HomePage;

/**
 * This is the base class for all tests.
 */

@ContextConfiguration(classes = DriverConfig.class)
public abstract class AppTestBase extends TestBase {
	
    public static final String DEFAULT_PROVIDER = "defaultConfig";
    protected HomePage homePage;
  
    @DataProvider(name = DEFAULT_PROVIDER, parallel = true)
    public Object[][] getDriverProvider() {
    	logger.info("In data provider, creating new driver instance...");
        return new Object[][]{
                {new WebDriverInstance(driverProperties)}
        };
    }
}
