package com.app.test.SampleTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.app.driver.instance.WebDriverInstance;
import com.app.driver.instance.WebDriverProxy;
import com.app.test.baseclasses.AppTestBase;
//import com.iambank.pages.SampleScreens.SamplePage;

public class SampleTest extends AppTestBase {

	@Test(dataProvider = DEFAULT_PROVIDER)
	public void verifySignInFunction(WebDriverInstance webDriverInstance) {
		System.out.println("Sign In functionality details...");
		WebDriverProxy driver =  webDriverInstance.getDriver();
	//	SamplePage samplePage = new SamplePage (driver);
		logger.info(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("isro.gov.in"));
	}

}
