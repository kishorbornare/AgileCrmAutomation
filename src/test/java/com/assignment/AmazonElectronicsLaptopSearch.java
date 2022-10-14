package com.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.agilecrmautomation.BaseClass;

public class AmazonElectronicsLaptopSearch extends BaseClass {
	@BeforeTest(groups= {"regression"})
	@Parameters("browser")
	public void login(String browser) {
	  launchBrowser(browser);
		driver.navigate().to("https://www.amazon.in/");
	}
	@AfterTest(groups= {"regression"})
	public void logout() {
		System.out.println("logout from amazon");
	}
	@Test(groups= {"regression"})
public void main() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptops");
		click(By.id("nav-search-submit-button"), "click on searh button");
		List<WebElement> applianceName = driver.findElements(By.xpath("//div[@class='sg-row']/descendant::h2"));
		List<WebElement> appliancePrice = driver
				.findElements(By.xpath("//div[@class='sg-row']/descendant::a//span[@class='a-price-whole']"));
		for (int i = 0; i < applianceName.size(); i++) {
			String name = applianceName.get(i).getText();
			String price = appliancePrice.get(i).getText();

			String newPrice = price.replace(",", "");
			int newPrice1 = Integer.parseInt(newPrice);
			if (newPrice1 >= 30000) {

				System.out.println(name + "  :" + newPrice1);
			}

		}

	}
}
