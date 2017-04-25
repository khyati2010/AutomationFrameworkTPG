package com.iambank.app.execution;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iambank.app.configuration.AppiumCapabilities;
import com.iambank.app.pages.FirstIntroScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;

public final class AndroidAppInstance extends IAMBankAppInstance {
    private static final Logger logger = LogManager.getLogger(AndroidAppInstance.class);
    
    protected AndroidAppInstance(AppiumCapabilities environment) {
        super(environment);
    }

    @SuppressWarnings("rawtypes")
	@Override
    protected void configureAppiumCapabilities() throws MalformedURLException {
        logger.info("Configuring android environment...");
        String environmentPropertyFile = String.format("/sdcard/env.properties");
        AndroidDriver aDriver = (AndroidDriver) getDriver();
        String[] generatedConfigs = getAndroidConfig();
        aDriver.pushFile(environmentPropertyFile, generatedConfigs[0].getBytes(StandardCharsets.UTF_8));
        String actualEnvProperties = new String(aDriver.pullFile(environmentPropertyFile), StandardCharsets.UTF_8);
        logger.info("env.properties: {}", actualEnvProperties);
        aDriver.resetApp();
    }

    @SuppressWarnings("rawtypes")
	@Override
    protected AppiumDriver getDriver() {
        if (driver == null) {
            AppiumCapabilities environment = getAppiumCapabilities();
            driver = 
                    new AndroidDriver(environment.getCapabilities());
        }
        return (AppiumDriver) driver;
    }

    @Override
    public FirstIntroScreen start(boolean skipIntroStuff) throws MalformedURLException {
        logger.info("Launching android app ...");
        configureAppiumCapabilities();
        return new FirstIntroScreen(getDriver(), getAppiumCapabilities(), skipIntroStuff);
    }

    @JsonIgnore
    private String[] getAndroidConfig() throws MalformedURLException {
        StrBuilder envConfig = new StrBuilder();
        return new String[]{envConfig.toString()};
    }

	@Override
	public AppiumCapabilities getAppiumCapabilities() {
		return appiumCapabilities;
	}

}
