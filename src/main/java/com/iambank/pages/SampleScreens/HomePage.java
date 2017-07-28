package com.iambank.pages.SampleScreens;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.driver.instance.WebDriverProxy;
import com.app.pages.baseclasses.AppBasePage;

public class HomePage extends AppBasePage{
	
	@FindBy(xpath="//a[text()='USER MANAGEMENT']")
	private WebElement UserManagementLink;	
	@FindBy(xpath="//*[@id='header']/ul/li[1]/a")
	private WebElement HomeLink;
	@FindBy(xpath="//*[@id='displayView']/div/div[2]/div[1]/div/div[2]")
	private WebElement HomePageTitle;
	@FindBy(xpath="//*[@id='header']/ul/li[3]/a")
	private WebElement AuditLogLink;
	@FindBy(xpath="//*[@id='displayView']/div/div[2]/div/div/div")
	private WebElement AuditLogTitle;
	@FindBy(xpath="//*[@id='header']/div/a[1]")
	private WebElement MyProfileLink;
	@FindBy(xpath="//*[@id='displayView']/div/div[2]/div/div/div")
	private WebElement MyProfileTitle;
	String title = "Parkmobile Self-Service Portal";
	@FindBy(xpath="//a[@class = 'ssp-pm-navLink-signOut base-font']")
	private WebElement logoutbutton;

	UserManagementPage usermangementpage;
	
	public HomePage(WebDriverProxy driver){
		super(driver);		
		
	}
	public String verifyHomePage(){
		return HomePageTitle.getText();
		
	}
	public UserManagementPage clickUserManagement(){	
		waitForElement(UserManagementLink,20);
		UserManagementLink.sendKeys(Keys.ENTER);
		return new UserManagementPage(driver);
		}
	
	/*public void clickHomeLink(){	
		//waitForElement(HomeLink,30);
		HomeLink.click();
		}
	
	public void clickAuditLink(){	
		//waitForElement(AuditLogLink,30);
		AuditLogLink.click();
		}
	public String verifyAuditLogPage(){
		return AuditLogTitle.getText();
		
	}
	public void clickMyProfileLink(){	
		//waitForElement(MyProfileLink,30);
		MyProfileLink.click();
		}
	public String verifyMyProfilePage(){
		return MyProfileTitle.getText();
		
	}
	*/
	public void clickLogout(){
		waitForElement(logoutbutton,30);
		logoutbutton.click();
		//return new HomePage(driver);
	}

}
