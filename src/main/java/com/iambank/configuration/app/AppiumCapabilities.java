package com.iambank.configuration.app;

import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.io.File;

/**
 * Generic driver capabilities class.
 */
@Component
public final class AppiumCapabilities {
	private static final Logger logger = LogManager.getLogger(AppiumCapabilities.class);

	// Device capabilities
	@Value("${platformName}")
	private String platformName;
	@Value("${platformVersion:}")
	private String platformVersion;
	@Value("${app:}")
	private String appFile;
	@Value("${processArguments:}")
	private String processArguments;
	@Value("${appiumVersion:1.6}")
	private String appiumVersion;
	@Value("${deviceOrientation:portrait}")
	private String orientation;
	@Value("${udId:}")
	private String udId;
	@Value("${fullReset:true}")
	private boolean shouldFullResetApp;
	@Value("${NoReset:false}")
	private boolean shouldNoResetApp;
	@Value("${platform:ANY}")
	private Platform platform;
	@Value("${deviceName:}")
	private String deviceName;
	@Value("${recordVideo:true}")
	private boolean recordVideo;
	@Value("${recordScreenshots:true}")
	private boolean recordScreenshots;

	private DesiredCapabilities capabilities;

	public DesiredCapabilities getCapabilities() {
		if (capabilities == null) {
			capabilities = new DesiredCapabilities();
			capabilities.setCapability("recordVideo",recordVideo);
			capabilities.setCapability("recordScreenshots",recordScreenshots);
			if (!deviceName.isEmpty()) {
				capabilities.setCapability("deviceName", deviceName);
			}
		}
		return capabilities;
	}
	
	@PostConstruct
	public void init(){
		logger.info("Setting up capabilities in @PostConstruct...");
		setDesiredCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
		setDesiredCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 900);
		setLocalCapabilities();
		setDesiredCapability(MobileCapabilityType.FULL_RESET, shouldFullResetApp());
		setDesiredCapability(MobileCapabilityType.NO_RESET, shouldNoResetApp);
		setDesiredCapability("platform", platform);
	}

	public String getAppName() {
		return appFile;
	}

	protected void setDesiredCapability(String capability, Object value) {
		getCapabilities().setCapability(capability, value);
	}

	public boolean shouldFullResetApp() {
		return shouldFullResetApp;
	}

	private void setLocalCapabilities() {
		if (platformVersion != null) {
			setDesiredCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
		}
		File app = new File(getAppName());
		setDesiredCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
