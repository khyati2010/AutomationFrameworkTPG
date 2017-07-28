package com.iambank.pages.SampleScreens;

import org.openqa.selenium.WebDriver;

import com.app.driver.instance.WebDriverProxy;
import com.app.pages.baseclasses.AppBasePage;

public class SamplePage extends AppBasePage {

	public SamplePage (WebDriverProxy driver) {
		super(driver);
	}
	
	public String getSignInPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public boolean verifySignInPageTitle() {
		String expectedTitle = "Sign in - Google Accounts";
		return getSignInPageTitle().contains(expectedTitle);
	}
}