package com.assignment;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.agilecrmautomation.BaseClass;

public class LinkVerification extends BaseClass {
	@BeforeMethod(groups= {"regression"})
	@Parameters("browser")
	public void login(String browser) {
		launchBrowser(browser);
		driver.navigate().to("https://www.amazon.in/");
	}

	@AfterMethod (groups= {"regression"})
	public void logout() {
		System.out.println("logout");
	}

	@Test(groups= {"regression"})
	public void linkVerify() {
		driver.navigate().to("https://www.amazon.in/");
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		for (WebElement e : elements) {
			String links = e.getAttribute("href");
			if (links != null && links.startsWith("https")) {
				//System.out.println(links);
				try {
					URL url = new URL(links);
					URLConnection urlConnection = url.openConnection();
					HttpURLConnection connection = (HttpURLConnection) urlConnection;
					connection.connect();
					int statusCode = connection.getResponseCode();

					if (statusCode != 200) {
						System.out.println(statusCode + "url:" + "link");
						connection.disconnect();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

	}
}
