package com.app.test.SampleTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.driver.instance.WebDriverInstance;
import com.app.driver.instance.WebDriverProxy;
import com.app.test.baseclasses.AppTestBase;
import com.iambank.pages.SampleScreens.LoginPage;
import com.iambank.pages.SampleScreens.PageTitle;


public class LoginTest extends AppTestBase {
	/*String adminuser = "peach@test.com";
	String adminpswd = "Tpg@12345";
	String sspurl = "http://selfserviceportal-test.parkmobile.3pillarglobal.com";
	String title = "Parkmobile";
	String firstname="Admin@12345";
	String email= "testing12@test.com";
	String UsermanagementPage = "User Management";
	String HomePageTitle = "Parkmobile Self-Service Portal";
	String msg1 = "Please enter a valid username or password.";*/
	
	
	
	
		@Test(dataProvider = DEFAULT_PROVIDER)
		public void verifyAddUser(WebDriverInstance webDriverInstance) {
			WebDriverProxy driver =  webDriverInstance.getDriver();
			Assert.assertTrue(webDriverInstance.getDriver().getCurrentUrl().contains(PageTitle.sspurl.value));			
			LoginPage loginPage = new LoginPage(driver);
			Assert.assertTrue(loginPage.getLogInPageTitle().contains(PageTitle.title.value));
			homePage=loginPage.enterUsernamePswd(PageTitle.adminuser.value,PageTitle.adminpswd.value );
			//Assert.assertTrue(homePage.verifyHomePage().contains(HomePageTitle));	
			Assert.assertTrue(homePage.verifyHomePage().contains(PageTitle.HomePageTitle.value));
			homePage.clickUserManagement().clickAddUser();
			//homePage.clickLogout();
		}
		
		/*@Test(dataProvider = DEFAULT_PROVIDER)
		public void verifyInvalidLogin(WebDriverInstance webDriverInstance) throws Exception {
			WebDriverProxy driver =  webDriverInstance.getDriver();
			LoginPage loginPage = new LoginPage(driver);
			loginPage.enterUsernamePswd(adminuser," " );
			Assert.assertTrue(loginPage.getErrorMsg().contains(msg1));
		}*/
			
 

}