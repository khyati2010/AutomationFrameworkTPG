package com.iambank.pages.SampleScreens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.app.driver.instance.WebDriverProxy;
import com.app.pages.baseclasses.AppBasePage;

public class AddUserPage extends AppBasePage {
	
	//@FindBy(xpath="//*[@id='addUserPanel']/div/add-user/div[1]/div[4]/div[1]/h4")
	@FindBy(xpath="//*[(@class='ssp-pm-userTypeContainer')]")
	private WebElement UserType;
	@FindBy(xpath="//*[@id='addUserPanel']/div/add-user/div[2]/div[1]/button[2]")
	private WebElement continuebutton;
	@FindBy(xpath="//*[@id='addUserPanel']/div/add-user/div[1]/div[4]/div[4]/div[1]/input")
	private WebElement FirstName;
	@FindBy(xpath="//*[@id='addUserPanel']/div/add-user/div[1]/div[4]/div[4]/div[2]/input")
	private WebElement LastName;
	@FindBy(xpath="//*[@id='addUserPanel']/div/add-user/div[1]/div[4]/div[4]/div[3]/input")
	private WebElement EmailAddress;
	@FindBy(xpath="//*[@id='addUserPanel']/div/add-user/div[2]/div[1]/button[3]")
	private WebElement SendInvitationBtn;
	
	public AddUserPage(WebDriverProxy driver){
		super(driver);
		//waitForElement(UserType,10);
	}
	
	public String addUserPage(){
		System.out.println(UserType.getText());
		return UserType.getText();		
	} 
	
	public void clickAddUserContinue(){
		continuebutton.click();		
	}
	public AddUserPage EnterFirstName(String fname,String lname, String email){
		FirstName.sendKeys(fname);
		LastName.sendKeys(lname);
		EmailAddress.sendKeys(email);
		return this;		
	}
	public void clickSendInvitation(){
		SendInvitationBtn.click();		
	}
	

}
