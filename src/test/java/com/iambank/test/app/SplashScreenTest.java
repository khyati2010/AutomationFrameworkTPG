package com.iambank.test.app;

import org.testng.annotations.Test;

import com.iambank.execution.app.IAMBankAppInstance;
import com.iambank.execution.test.AppTestBase;

public class SplashScreenTest extends AppTestBase {

    @Test(dataProvider = DEFAULT_PROVIDER)
    public void verifySplashScreensAreDisplayed(IAMBankAppInstance app) throws Exception {
       app.startApp();
    }
}
