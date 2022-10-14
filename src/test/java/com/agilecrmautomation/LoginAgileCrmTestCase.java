package com.agilecrmautomation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import agilecrm.pages.LoginPage;

public class LoginAgileCrmTestCase extends BaseClass {
	
	@BeforeMethod
 public void main2() {

		launchBrowser("chrome");
		driver.navigate().to("https://boss123.agilecrm.com");
		// driver.manage().window().maximize();
		LoginPage loginpage = new LoginPage();
		loginpage.login("vishal1@yopmail.com", "Vishal@123");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		// loginpage.login("automation@yopmail.com", "Test12345");
//		// loginpage.login("automation@yopmail.com", " ");
//		// loginpage.login("automationyopmail.com", "Test1234");
	//	loginpage.login("automation@yopmail", "Test1234");
	}

	@Test
	public void a() {
		System.out.println("abc");
	}
	@AfterMethod (groups= {"regression"})

	public void b() {System.out.println("efg"); }
	 
}

