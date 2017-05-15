package com.iambank.execution.app;

import java.net.MalformedURLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.pages.IntroScreens.FirstIntroScreen;
import com.iambank.pages.SplashScreen.SplashScreen;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public final class AndroidAppInstance extends IAMBankAppInstance {
	private static final Logger logger = LogManager.getLogger(AndroidAppInstance.class);

	public AndroidAppInstance(AppiumCapabilities appiumCapabilities) {
		super(appiumCapabilities);
	}

	@Override
	protected void configureAppiumCapabilities() throws MalformedURLException {
		logger.info("Configuring android environment...");
		getDriver();
	}

	@Override
	protected AndroidDriver<MobileElement> getDriver() {
		if (driver == null) {
			AppiumCapabilities appiumCapabilities = getAppiumCapabilities();
			driver = new AndroidDriver<MobileElement>(appiumCapabilities.getCapabilities());
		}
		return (AndroidDriver<MobileElement>) driver;
	}

	@Override
	public AppiumCapabilities getAppiumCapabilities() {
		return appiumCapabilities;
	}

	@Override
	public SplashScreen startApp() throws MalformedURLException {
		logger.info("Launching android app ...");
		configureAppiumCapabilities();
		return new SplashScreen(getDriver(), getAppiumCapabilities());
	}
	
/*	@Override
	public FirstIntroScreen start(boolean skipIntroStuff) throws MalformedURLException {
		logger.info("Launching android app ...");
		configureAppiumCapabilities();
		try {
			return new FirstIntroScreen(getDriver(), getAppiumCapabilities(), skipIntroStuff);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	@Override
	public FirstIntroScreen start(boolean skipPopups) throws MalformedURLException {
		// TODO Auto-generated method stub
		return null;
	}
}
