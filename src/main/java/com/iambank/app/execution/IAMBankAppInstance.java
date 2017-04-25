package com.iambank.app.execution;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.Augmenter;
import org.testng.Assert;

import com.iambank.app.configuration.AppiumCapabilities;
import com.iambank.app.pages.FirstIntroScreen;

public abstract class IAMBankAppInstance {
    protected AppiumCapabilities appiumCapabilities;
    private static final Logger logger = LogManager.getLogger(IAMBankAppInstance.class);

    protected WebDriver driver;

    protected abstract WebDriver getDriver();

    protected IAMBankAppInstance(AppiumCapabilities appiumCapabilities) {
        this.appiumCapabilities = appiumCapabilities;
    }

    public FirstIntroScreen start() throws MalformedURLException {
        return start(true);
    }

    public abstract FirstIntroScreen start(boolean skipPopups) throws MalformedURLException;

    protected abstract void configureAppiumCapabilities() throws MalformedURLException;

    public AppiumCapabilities getAppiumCapabilities() {
        return appiumCapabilities;
    }
 
    void cleanup() {
        if (driver != null) {
            logger.info("Cleaning up web driver...");
            getDriver().quit();
        }
    }

  
    boolean saveScreenshot(File destination) throws IOException {
        boolean success = false;
        if (driver != null) {
            logger.info("Saving screenshot to {}...", destination.getAbsolutePath());
            File parentDir = destination.getParentFile();
            if (!parentDir.exists()) {
                Assert.assertTrue(parentDir.mkdirs(), "Could not create directory \"" + parentDir.getAbsolutePath() + "\".");
            }
            WebDriver augmentedDriver = new Augmenter().augment(getDriver());
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
            WebDriver augmentedDriver = new Augmenter().augment(getDriver());
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
