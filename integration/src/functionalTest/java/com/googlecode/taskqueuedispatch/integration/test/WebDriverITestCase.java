package com.googlecode.taskqueuedispatch.integration.test;

import junit.framework.TestCase;

import org.openqa.selenium.WebDriver;

import com.google.inject.Provider;

public class WebDriverITestCase extends TestCase {

	final private Provider<WebDriver> provider;
	protected WebDriver driver;
	final protected String baseURL;

	public WebDriverITestCase(Provider<WebDriver> provider, String baseURL) {
		this.provider = provider;
		this.baseURL = baseURL;
	}

	public WebDriverITestCase() {
		this(new WebDriverProviderFactory().htmlUnitProvider(),
				"http://localhost:8080");
	}

	@Override
	protected void setUp() throws Exception {
		driver = provider.get();
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		driver.quit();
		super.tearDown();
	}
	
	public void sleepShort() throws NumberFormatException, InterruptedException {
		Thread.sleep(Long.valueOf(System.getProperty("short", "900")));
	}
	
	public void sleepShort(int times) throws NumberFormatException, InterruptedException {
		for (int i = 0; i < times; i++) {
			sleepShort();
		}
	}
}
