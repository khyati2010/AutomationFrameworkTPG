package com.app.driver.instance;

import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.app.pages.baseclasses.BasePage;

public class WebDriverProxy implements WebDriver, WebDriverEventListener {

	private Logger log = LogManager.getLogger(BasePage.class);
	private WebDriver driver;

	public WebDriverProxy(WebDriver driver) {
		this.driver = driver;
	}

	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub

	}

	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub

	}

	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	public void onException(Throwable arg0, WebDriver arg1) {

	}

	public void close() {
		// TODO Auto-generated method stub

	}

	public WebElement findElement(By arg0) {
		log.info("Using webdriver proxy function....");
		return driver.findElement(arg0);
	}

	public List<WebElement> findElements(By arg0) {
		// TODO Auto-generated method stub
		log.info("Using webdriver proxy function....");
		return driver.findElements(arg0);
	}

	public void get(String arg0) {
		// TODO Auto-generated method stub

	}

	public String getCurrentUrl() {
		log.info("Using webdriver proxy function....");
		return driver.getCurrentUrl();
	}

	public String getPageSource() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getWindowHandle() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		return null;
	}

	public Options manage() {
		// TODO Auto-generated method stub
		return null;
	}

	public Navigation navigate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void quit() {
		//driver.quit();
	}

	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return null;
	}

	public WebDriver getDriver() {
		return driver;
	}
}
