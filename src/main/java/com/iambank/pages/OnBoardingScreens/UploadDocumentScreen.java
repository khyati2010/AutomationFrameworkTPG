package com.iambank.pages.OnBoardingScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.configuration.framework.ScreenTitles;
import com.iambank.pages.basepages.AppBasePage;

public class UploadDocumentScreen extends AppBasePage {
			
	@AndroidFindBy(id = "btn_take_pic") 
	private MobileElement buttonTakePic;

	public UploadDocumentScreen (AppiumDriver<MobileElement> driver, AppiumCapabilities driverCapabilities) {
        super (driver, driverCapabilities);
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Override
	public String expectedScreenTitle (){
		return ScreenTitles.UploadDocument.title();
	}
    
   public ThanksScreen clickTakePicButton(){
	   buttonTakePic.click();
	   return new ThanksScreen(getDriver(), getDriverCapabilities());
   }
}