package com.youtube.music.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseUI {

	public WebDriver driver;

	public void invokeBrowser() {
		String browserName = System.getProperty("browser");
		if (browserName == null) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdirver.gecko.driver",
					System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdirver.chrome.driver",
					System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
	}

	public void navigateToURL(String url) {
		driver.get(url);
	}

	public void tearDown() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

}
