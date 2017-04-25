package com.iambank.app.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import com.iambank.app.configuration.AppiumCapabilities;

public class FirstIntroScreen extends AppBasePage {

    @AndroidFindAll({
            @AndroidFindBy(id = "lnr_screen"),                      
            @AndroidFindBy(xpath = "//*[@content-desc ='Screen']")})  
    private WebElement trait;

    @AndroidFindBy(id = "action")
    private WebElement next;

   @SuppressWarnings("rawtypes")
	public FirstIntroScreen(AppiumDriver driver, AppiumCapabilities environment) {
        this(driver, environment, true);
    }

    @SuppressWarnings("rawtypes")
	public FirstIntroScreen(AppiumDriver driver, AppiumCapabilities environment, boolean skipIntro) {
        super(driver, environment);
        if (skipIntro) {
            skipIntroStuff();
        }
    }

    private void skipIntroStuff() {   
    }
}