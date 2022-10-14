package com.assignment;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.agilecrmautomation.BaseClass;

public class Sample extends BaseClass {

	public static void main(String[] args) throws Exception {
	launchBrowser("chrome");
	driver.navigate().to("https://www.amazon.in/");
	Thread.sleep(4000);
	WebElement element = driver.findElement(By.id("desktop-banner"));
	Actions action = new Actions(driver);
	String parentid = driver.getWindowHandle();
	Thread.sleep(4000);
	action.contextClick(element).build().perform();
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_DOWN);
	robot.keyRelease(KeyEvent.VK_DOWN);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(7000);
	Set<String> allwindow = driver.getWindowHandles();
	for (String id : allwindow) {
		if (!id.equals(parentid)) {
			System.out.println(id);
			Thread.sleep(5000);
			driver.switchTo().window(id);
			System.out.println(driver.getTitle());
			List<WebElement> productName = driver
					.findElements(By.xpath("//div[@class='DealContent-module__truncate_sWbxETx42ZPStTc9jwySW']"));
			List<WebElement> pricetag = driver.findElements(By.xpath(
					"//div[@class='BadgeAutomated-module__badgeOneLineContainer_yYupgq1lKxb5h3bfDqA-B']/div[1]"));
			for (int i = 1; i < productName.size(); i++) {
				String pname = productName.get(i).getText();
				String ptag = pricetag.get(i).getText();
				System.out.println(pname + ":" + ptag);

}}}}}
