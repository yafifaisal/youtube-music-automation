package com.youtube.music.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseUI {

	public WebDriver driver;
	public Properties testDataProp, locatorsProp;

	@BeforeMethod
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
		try {
			loadTestDataProperties();
			loadLocatorsProperties();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void navigateToURL(String url) {
		driver.get(testDataProp.getProperty(url));
	}

	public void tearDown() {
		driver.close();
	}

	@AfterMethod
	public void quitBrowser() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

	public void loadTestDataProperties() throws IOException {
		if (testDataProp == null) {
			testDataProp = new Properties();
			try {
				FileInputStream dataFile = new FileInputStream(
						System.getProperty("user.dir") + "/src/test/resources/objectRepository/testData.properties");
				testDataProp.load(dataFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void loadLocatorsProperties() throws IOException {
		if (locatorsProp == null) {
			locatorsProp = new Properties();
			try {
				FileInputStream locatorsFile = new FileInputStream(
						System.getProperty("user.dir") + "/src/test/resources/objectRepository/locators.properties");
				locatorsProp.load(locatorsFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public WebElement getElement(String elementKey) {
		WebElement element = null;
		if (elementKey.endsWith("_id")) {
			element = driver.findElement(By.id(locatorsProp.getProperty(elementKey)));
		} else if (elementKey.endsWith("_xpath")) {
			element = driver.findElement(By.xpath(locatorsProp.getProperty(elementKey)));
		} else {
			element = driver.findElement(By.className(locatorsProp.getProperty(elementKey)));
		}
		return element;
	}

	public void clickElement(String elementKey) {
		getElement(elementKey).click();
	}

	public void enterText(String elementKey, String text) {
		getElement(elementKey).sendKeys(testDataProp.getProperty(text));
		getElement(elementKey).sendKeys(Keys.ENTER);
	}

}
