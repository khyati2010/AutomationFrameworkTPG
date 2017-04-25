package com.macys.test.system.app;

import com.iambank.app.execution.IAMBankAppInstance;
import com.iambank.app.execution.AppTestBase;
import com.iambank.app.pages.FirstIntroScreen;
import org.testng.annotations.Test;
import java.io.IOException;

public class IntroScreenTest extends AppTestBase {

    @Test(dataProvider = DEFAULT_PROVIDER)
    public void introScreenTest(IAMBankAppInstance app) throws IOException {
        FirstIntroScreen firstIntroScreen = app.start();
    }
}