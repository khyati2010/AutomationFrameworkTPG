package com.iambank.app.execution;

import com.iambank.app.configuration.AppConfig;
import com.iambank.app.configuration.AppiumCapabilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.DataProvider;

/**
 * This is the base class for all tests.
 */

@ContextConfiguration(classes = AppConfig.class)
public abstract class AppTestBase extends TestBase {

    private static final Logger log = LogManager.getLogger(AppTestBase.class);
    public static final String DEFAULT_PROVIDER = "defaultConfig";

    @Autowired
    private AppiumCapabilities appiumCapabilities;

    @DataProvider(name = DEFAULT_PROVIDER, parallel = true)
    public Object[][] getAppProvider() {
        log.info("In data provider, creating new app instance...");
        log.info("Setting up test's  with app.properties configuration...");
        return new Object[][]{
                {new AndroidAppInstance(appiumCapabilities)}
        };
    }
 
}
