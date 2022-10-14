package com.agilecrmautomation;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver = null;

	public static void launchBrowser(String browser) {
		switch (browser) {

		case "chrome":
			// System.setProperty("webdriver.chrome.driver",
			// "C:\\chromedriver_win32\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			/*
			 * ChromeOptions option=new ChromeOptions(); option.setHeadless(true); WebDriver
			 * driver=new ChromeDriver(option);
			 */
			// WebdriverManager.chromedriver().setup();
			driver = new ChromeDriver(setChromeCapabilities());
			break;
		case "edge":
			// System.setProperty("WebDriver.edge.driver", "C:\\edge
			// driver\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(setEdgeCapabilities());
			break;
		default:
			System.setProperty("WebDriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
	}

	public static void click(By by, String msg) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
		System.out.println(msg);
	}

	public static void waitForVisibilityOfElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForElementToBeClickable(By element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForElementToBePresent(By element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	public static void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	static void fluentWait(final By by) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(16))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				System.out.println("waiting for element to be available");
				return driver.findElement(by);
			}
		});
	}

	public static void SelectDropdownValByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public static void SelectDropdownValByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public static void SelectDropdownValByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	private static ChromeOptions setChromeCapabilities() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("Start-maximized");
		option.setHeadless(false);
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "directory/path");
		option.setExperimentalOption("prefs", prefs);
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		return option;
	}

	private static EdgeOptions setEdgeCapabilities() {
		EdgeOptions option= new EdgeOptions();
		option.addArguments("Start-maximized");
		option.setHeadless(false);
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "directory/path");
		option.setExperimentalOption("prefs", prefs);
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		return option;

	}
}
