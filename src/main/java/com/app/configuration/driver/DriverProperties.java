package com.app.configuration.driver;

import javax.annotation.PostConstruct;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.app.driver.instance.WebDriverProxy;

@Component
public final class DriverProperties {
	private static final Logger logger = LogManager.getLogger(DriverProperties.class);

	@Value("${browser}")
	private String browser;
	@Value("${appURL}")
	private String appURL;
	@Value("${driverPath}")
	private String driverPath;

	public String getAppURL() {
		return appURL;
	}

	public String getBrowserType() {
		return browser;
	}

	@PostConstruct
	public void init(){
		logger.info("info..:" + browser + appURL + driverPath);
		logger.info("Setting up driverProperties in @PostConstruct...");
		String browserType = getBrowserType();
		switch (browserType) {
		case "chrome" :
			System.setProperty("webdriver.chrome.driver", driverPath);
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver",driverPath);
			break;
		default:
			System.out.println("browser : " + getBrowserType()
			+ " is invalid, Launching Chrome as browser of choice..");
			System.setProperty("webdriver.gecko.driver",driverPath);
		}

	}

	private WebDriverProxy initChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return new WebDriverProxy(driver);
	}

	private WebDriverProxy initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		WebDriver driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return new WebDriverProxy(driver);
	}

	public WebDriverProxy setDriver(String appURL){
		logger.info("Setting up driverProperties in @PostConstruct...");
		WebDriverProxy driver;
		switch (getBrowserType()) {
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		case "chrome":
			driver = initChromeDriver(appURL);
			break;
		default:
			System.out.println("browser : " + getBrowserType()
			+ " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL);
		}

		return driver;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
