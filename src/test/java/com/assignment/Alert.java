package com.assignment;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.agilecrmautomation.BaseClass;

public class Alert extends BaseClass {
	
public Alert() {
}
	
	
@Test(groups= {"regression"})

	public  void main() {
		launchBrowser("chrome");
		driver.navigate().to("https://www.orangehrm.com/");
		JavascriptExecutor  js=(JavascriptExecutor )driver;
	js.executeScript("alert('This is smaple alert');");
	driver.switchTo().alert().accept();}
@Test(priority=1)
public  void main1() {
	launchBrowser("chrome");
	driver.navigate().to("https://www.orangehrm.com/");
	JavascriptExecutor  js=(JavascriptExecutor )driver;
js.executeScript("confirm('This is smaple alert');");
driver.switchTo().alert().accept();}
@Test(priority=2)
public  void main2() {
	launchBrowser("chrome");
	driver.navigate().to("https://www.orangehrm.com/");
	JavascriptExecutor  js=(JavascriptExecutor )driver;
js.executeScript("prompt('This is smaple alert');");
driver.switchTo().alert().accept();
 }




}


