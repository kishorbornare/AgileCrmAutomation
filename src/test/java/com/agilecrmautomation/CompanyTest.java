package com.agilecrmautomation;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import agilecrm.pages.CompanyPage;
import agilecrm.pages.LoginPage;

public class CompanyTest extends BaseClass {

	@BeforeMethod
	public void login() {
		launchBrowser("chrome");
		driver.navigate().to("https://boss123.agilecrm.com");
		LoginPage login1 = new LoginPage();
		login1.login("vishal1@yopmail.com", "Vishal@123");
	}

	@Test
	public void company() throws Exception {
		CompanyPage addCompany = new CompanyPage();
		addCompany.addCompany();
//	WebElement CompanyButton=driver.findElement(this.CompanyButton);
	}

	@AfterMethod
	public void logout() {
		System.out.println("LogOut");
	}
}
