package com.iambank.pages.SampleScreens;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.driver.instance.WebDriverProxy;
import com.app.pages.baseclasses.AppBasePage;

public class LoginPage extends AppBasePage {
	@FindBy(xpath="//*[@id='displayView']/div/div/div[2]/div[1]/input")
	private WebElement username;
	@FindBy(xpath="//*[@id='displayView']/div/div/div[2]/div[2]/input")
	private WebElement pmpassword;
	@FindBy(xpath="//*[@id='displayView']/div/div/div[2]/button")
	private WebElement loginbutton;
	@FindBy(xpath="//*[@id='loginMsgBar']/div[2]/div/div")
	private WebElement loginmsgbar;
	String expectedTitle = "Parkmobile Self-Service Portal";
	
	
	public LoginPage (WebDriverProxy driver) {
		super(driver);
		
	}
	public HomePage enterUsernamePswd(String adminuser, String adminpswd){
		username.sendKeys(adminuser);
		pmpassword.sendKeys(adminpswd);
		loginbutton.click();
		return new HomePage(driver);		
	}
	public String getLogInPageTitle() {
		String pageTitle = getDriver().getTitle();
		return pageTitle;
	}
	
	public boolean verifySignInPageTitle() {
		return getLogInPageTitle().contains(expectedTitle);
	}
	
	
	
	public String getErrorMsg(){
		return loginmsgbar.getText();
		
	}
	
	
	
}
