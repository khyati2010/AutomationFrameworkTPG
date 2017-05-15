package com.iambank.execution.app;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.Augmenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.pages.IntroScreens.FirstIntroScreen;
import com.iambank.pages.SplashScreen.SplashScreen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public abstract class IAMBankAppInstance {
	
	@Autowired
    protected AppiumCapabilities appiumCapabilities;
	
    private static final Logger logger = LogManager.getLogger(IAMBankAppInstance.class);
    
	protected AppiumDriver<MobileElement> driver;

    protected IAMBankAppInstance(AppiumCapabilities appiumCapabilities) {
        this.appiumCapabilities = appiumCapabilities;
    }

    public abstract FirstIntroScreen start(boolean skipPopups) throws MalformedURLException;
    
    public abstract SplashScreen startApp() throws MalformedURLException;

    protected abstract void configureAppiumCapabilities() throws MalformedURLException;
    
    protected abstract AppiumDriver<MobileElement> getDriver();

    public AppiumCapabilities getAppiumCapabilities() {
        return appiumCapabilities;
    }
 
    public void cleanup() {
        if (driver != null) {
            logger.info("Cleaning up Appium driver...");
            getDriver().quit();
        }
    }

  
    public boolean saveScreenshot(File destination) throws IOException {
        boolean success = false;
        if (driver != null) {
            logger.info("Saving screenshot to {}...", destination.getAbsolutePath());
            File parentDir = destination.getParentFile();
            if (!parentDir.exists()) {
                Assert.assertTrue(parentDir.mkdirs(), "Could not create directory \"" + parentDir.getAbsolutePath() + "\".");
            }
            @SuppressWarnings("unchecked")
			AppiumDriver<MobileElement> augmentedDriver = (AppiumDriver<MobileElement>) new Augmenter().augment(getDriver());
            try {
                File snapshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
                success = snapshot.renameTo(destination);
            } catch (WebDriverException e){
                logger.catching(e);
            }
        }
        return success;
    }

    /**
     * Gets a screenshot if driver exists
     */
    public byte[] getScreenshot() {
        byte[] image = new byte[0];
        if (driver != null) {
        	@SuppressWarnings("unchecked")
			AppiumDriver<MobileElement> augmentedDriver = (AppiumDriver<MobileElement>) new Augmenter().augment(getDriver());
            try {
                image = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.BYTES);
            } catch (WebDriverException e){
                logger.catching(e);
            }
        }
        return image;
    }

    public boolean isDriverAvailable() {
        return driver != null;
    }
}
