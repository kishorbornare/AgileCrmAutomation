package com.agilecrmautomation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import agilecrm.pages.ContactPage;
import agilecrm.pages.LoginPage;

public class ContactTest extends BaseClass {
	static ContactPage object = new ContactPage();
@BeforeClass
	public void login() {
		launchBrowser("chrome");

		driver.navigate().to("https://boss123.agilecrm.com");
		LoginPage login1 = new LoginPage();
		login1.login("vishal1@yopmail.com", "Vishal@123");
		//object.getContact();
	}

	@AfterClass
	public void logout() {
		System.out.println("logout");
	}

	@Test(priority=1)
	public void contacts() {
		object.addContact();
		System.out.println("create contact succesfully");}
		@Test(priority=2)
		public void search() {
		object.searchContact();
		System.out.println("contact search succesfully");}
		@Test(priority=3)
		public void update() {
		object.updateContact();
		System.out.println("Update Contact succesfully");}
		@Test(priority=4)
		public void delete () {
		object.deleteContact();
		System.out.println("delete contact succesfully");}
	}

