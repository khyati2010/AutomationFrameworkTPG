package com.app.pages.baseclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.driver.instance.WebDriverProxy;

public abstract class AppBasePage extends BasePage{

	@FindBy(id = "intro_big_txt")
	protected WebElement screenTitle;

	
	protected AppBasePage(WebDriverProxy driver) {
		super(driver);
	}

	protected void waitForElement(WebElement element , long waitforseconds){
    	WebDriverWait wait = new WebDriverWait(getDriver(), waitforseconds);
    	wait.until(ExpectedConditions.visibilityOf(element));    	
    }

	public boolean verifyBasePageTitle() {
		// TODO Auto-generated method stub
		return false;
	}
}


