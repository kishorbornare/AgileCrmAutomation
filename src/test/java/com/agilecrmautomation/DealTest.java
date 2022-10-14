package com.agilecrmautomation;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import agilecrm.pages.DealPage;
import agilecrm.pages.LoginPage;

public class DealTest extends BaseClass {
	@Test

	public void addDeal() throws Exception {
		launchBrowser("chrome");
		driver.navigate().to("https://boss123.agilecrm.com");
		LoginPage login = new LoginPage();
		login.login("vishal1@yopmail.com", "Vishal@123");
		DealPage deal = new DealPage();
		//deal.archieveDeal();// you can add this after add deal.
		deal.changeDealStatus("New", "Prospect","1");
		
		click(By.xpath("//li[@id='dealsmenu']/a"), "Click on deal menu");

		ArrayList<String> dealNames = new ArrayList<String>();
		for (int i = 1; i <= 10; i++) {
			String dealName = deal.addDeal("paisa" + i);
			dealNames.add(dealName);
		}
		

		/*
		 * {for(String dealName:dealNames) { System.out.println(dealName);
		 * deal.addDeal("dealName"); }}
		 */
			
	}
}
