package com.macys.test.system.app;

import com.iambank.app.execution.IAMBankAppInstance;
import com.iambank.app.execution.AppTestBase;
import org.testng.annotations.Test;

public class SplashScreenTest extends AppTestBase {

    @Test(dataProvider = DEFAULT_PROVIDER)
    public void verifySplashScreensAreDisplayed(IAMBankAppInstance app) throws Exception {
       app.start();
    }
}
