package com.iambank.execution.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.iambank.configuration.app.AppiumCapabilities;
import com.iambank.execution.app.IAMBankAppInstance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.nio.file.NotDirectoryException;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * This base class is leveraged by any tests that interacts with mobile application.
 */
public abstract class TestBase extends AbstractTestNGSpringContextTests  {

	protected static final Logger logger = LogManager.getLogger(TestBase.class);
	private static final String THREAD_TAG = "FISHTAG";
	private static final String DEFAULT_SUITE_LOG = "test-output/logs/default.log";
	private static final String SNAPSHOTS_PATH = "test-output/screenshots";
	private IAMBankAppInstance iAMBANKInstance;

	@Autowired
	protected AppiumCapabilities appiumCapabilities;

	@BeforeSuite(alwaysRun = true)
	protected void suiteInit() throws Exception {
		File defaultLog = new File(DEFAULT_SUITE_LOG);
		if (defaultLog.exists() && !defaultLog.delete()){
			logger.warn("Unable to delete default log file [{}].", defaultLog.getAbsolutePath());
		}
		logger.info("Preparing spring context...");
		super.springTestContextPrepareTestInstance();
	}

	@BeforeMethod(alwaysRun = true)
	public void baseSetup(Method method, Object[] params) throws MalformedURLException, NoSuchFieldException, NotDirectoryException, JsonProcessingException {
		if (params.length > 0 && params[0] instanceof IAMBankAppInstance){
			iAMBANKInstance = (IAMBankAppInstance)params[0];
		}
		String tag = UUID.randomUUID().toString();
		logger.info("Tagging test thread with [{}]...", tag);
		ThreadContext.put(THREAD_TAG, tag);
		logTestSetup(method);
		logger.info("Base setup complete!");
	}

	@AfterMethod(alwaysRun = true)
	public void baseCleanup(ITestContext context, ITestResult result, Object[] params) throws IOException {
		if (params.length > 0 && params[0] instanceof IAMBankAppInstance){
			IAMBankAppInstance iAMBANKInstance = (IAMBankAppInstance)params[0];
			if (result.getStatus() == ITestResult.FAILURE) {
				captureScreenshot(result, iAMBANKInstance);
			}
			iAMBANKInstance.cleanup();
		}
		logTestResult(result);
		String tag = ThreadContext.get(THREAD_TAG);
		logger.info("Test is finished, removing the tag [{}]...", tag);
		ThreadContext.remove(THREAD_TAG);
		result.setAttribute(THREAD_TAG, tag);
	}

	public IAMBankAppInstance getIAMBankAppInstance() {
		return iAMBANKInstance;
	}

	private void captureScreenshot(ITestResult result, IAMBankAppInstance iAMBANKInstance) throws IOException {
		String fileName = String.format("test-%s.%s", ThreadContext.get("FISHTAG"), "png");
		if (iAMBANKInstance.saveScreenshot(Paths.get(SNAPSHOTS_PATH, fileName).toFile())) {
			result.setAttribute("screenshot", Paths.get("screenshots", fileName).toString());
		}
	}
	
	private void logTestSetup(Method method) throws JsonProcessingException {
		StringBuilder sb = new StringBuilder();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		sb.append(mapper.writeValueAsString(appiumCapabilities));
		logger.info(sb.toString());
	}
	
    private void logTestResult(ITestResult result){
		String testResult;
		switch(result.getStatus()){
		case 1:
			testResult = "Passed";
			break;
		case 2:
			testResult = "Failed";
			break;
		case 3:
			testResult = "Skipped";
			break;
		default:
			testResult = "Success_Percentage_Failure";
		}

		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Test result: %s%s", testResult, System.lineSeparator()));
		logger.info(sb.toString());
	}
}
