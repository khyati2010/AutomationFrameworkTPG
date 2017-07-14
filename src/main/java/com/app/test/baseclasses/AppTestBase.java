package com.iambank.execution.test;

import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.DataProvider;
import com.iambank.configuration.app.AppConfig;
import com.iambank.execution.app.AndroidAppInstance;

/**
 * This is the base class for all tests.
 */

@ContextConfiguration(classes = AppConfig.class)
public abstract class AppTestBase extends TestBase {

    public static final String DEFAULT_PROVIDER = "defaultConfig";

    @DataProvider(name = DEFAULT_PROVIDER, parallel = true)
    public Object[][] getAppProvider() {
    	logger.info("In data provider, creating new app instance...");
    	logger.info("Setting up test's  with app.properties configuration...");
        return new Object[][]{
                {new AndroidAppInstance(appiumCapabilities)}
        };
    }
 
}
