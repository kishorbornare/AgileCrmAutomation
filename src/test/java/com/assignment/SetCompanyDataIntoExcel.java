package com.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.agilecrmautomation.BaseClass;
import com.agilecrmautomation.ExcelUtil;

import agilecrm.pages.LoginPage;

public class SetCompanyDataIntoExcel extends BaseClass {
	
	public void searchContact()  {
		launchBrowser("chrome");
		driver.navigate().to("https://rolex.agilecrm.com");
	    System.out.println(" Testcase1- username and valid password");
	    LoginPage loginpage = new LoginPage();
		loginpage.login("mahesh33@yopmail.com","Test1234");
		 waitForVisibilityOfElement(driver.findElement(By.xpath("//li[@id='companiesmenu']")));
		 click(By.xpath("//li[@id='companiesmenu']"),"click on compony menu");
		 waitForElementToBePresent(By.xpath("//a[@class='text-cap']"));
		 List<WebElement> componylist = driver.findElements(By.xpath("//a[@class='text-cap ']"));
		 //List<WebElement> owner = driver.findElements(By.xpath("//a[@class='text-cap ']"));
		 for (int i = 0; i <componylist.size(); i++) {
			 
				String text = componylist.get(i).getText();
				System.out.println(text);
			ExcelUtil getExel=new ExcelUtil();
			getExel.setDataInExcel("D:\\DemofileforExceldatadriventesting\\LoginTestData.xlsx","SHEET3", i, 0,text);	
		}
		
	}


	
	public static void main(String[] args) 
	{
		SetCompanyDataIntoExcel get=new SetCompanyDataIntoExcel();
		get.searchContact();
	}
}
