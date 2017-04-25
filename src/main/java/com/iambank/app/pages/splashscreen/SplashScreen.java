package com.iambank.app.pages.splashscreen;

import com.iambank.app.configuration.AppiumCapabilities;
import com.iambank.app.pages.AppBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SplashScreen extends AppBasePage {

    @AndroidFindBy(id = "spalash_root_1") 
    private WebElement welcomeScreenText;

    @SuppressWarnings("rawtypes")
	public SplashScreen(AppiumDriver driver, AppiumCapabilities environment) {
        super(driver, environment);
    }
}
