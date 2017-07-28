package com.iambank.pages.SampleScreens;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.driver.instance.WebDriverProxy;
import com.app.pages.baseclasses.AppBasePage;

public class UserManagementPage extends AppBasePage{
	@FindBy(xpath="//*[@id='displayView']/div/div[2]/div[1]/div/div")
	private WebElement UserManagementPageTitle;
	
	@FindBy(xpath= "//div[@id='displayView']/div/div/div[2]/button")
	//@FindBy(className= "ssp-create")
	private WebElement adduserbutton;
	
	@FindBy(xpath="//div[@class='slider round']")
	private WebElement slider;
	
	//By CTA = By.xpath("//*[@class='ssp-create']");
	
	AddUserPage adduserpage;
	
	public UserManagementPage(WebDriverProxy driver){
		super(driver);
		
		
	}
	public String verifyUserMangementpage(){
		//System.out.println(UserManagementPageTitle.getText());
		return UserManagementPageTitle.getText();
		
	} 
	
	
	public AddUserPage clickAddUser()  {
		
	    //waitForElement(adduserbutton,40);
		//adduserbutton.click();
		//adduserbutton.sendKeys(Keys.ENTER);
		//Actions action = new Actions(driver);
		//action.moveToElement(adduserbutton, 300, 60).click().perform();
		driver.findElement(By.xpath("//div[@id='displayView']/div/div/div[2]/button")).click();
		return new AddUserPage(driver);
		
		
	}

}
