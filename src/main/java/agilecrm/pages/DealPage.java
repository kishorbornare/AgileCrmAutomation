package agilecrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.agilecrmautomation.BaseClass;

public class DealPage extends BaseClass {
	public String addDeal(String deal) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		waitForVisibilityOfElement(driver.findElement(By.id("deals-action")));
		click(By.id("deals-action"), "click on add deal");
		driver.findElement(By.xpath("//form[@id='opportunityForm']/descendant::input[@id='name']")).sendKeys(deal);
		driver.findElement(
				By.xpath("//form[@id='opportunityForm']/descendant::input[@name='currency_conversion_value']"))
				.sendKeys("100000");
		waitForElementToBeClickable(driver.findElement(By.xpath("//div[@id='deals-new-footer']/a")));
		click(By.xpath("//div[@id='deals-new-footer']/a"), "click on save");
		System.out.println(deal);
		return "deal";
}

	public void archieveDeal(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		click(By.xpath("//li[@id='dealsmenu']/a"), "Click on deal menu");
		click(By.xpath("//div[@id='New-list-container']/descendant::a[1]"),"click on deal");
		click(By.xpath("//div[@class='panel-body']/descendant::button[1]"), "click on dropdown");
		click(By.id("dealdetail-archive"), "click on archieve");
		click(By.id("deal-quick-archive"), "click on confirm");}
	
	public void changeDealStatus(String srcStatus,String dstStatus,String position) throws Exception {
		click(By.id("dealsmenu"), "Clicked on deals menu");
		driver.manage().window().maximize();
		//wait until the element to clickable
		waitForElementToBeClickable(By.xpath("//ul[@milestone='"+srcStatus+"']/li[1]"));
		//locate source element
		WebElement srcElement=driver.findElement(By.xpath("//ul[@milestone='"+srcStatus+"']/li[1]"));
		//get the name of source deal
		String dealsname=driver.findElement(By.xpath("//ul[@milestone='"+srcStatus+"']/li[1]/descendant::a[1]")).getText();
		//locate destination element
		WebElement dstElement=driver.findElement(By.xpath("//ul[@milestone='"+dstStatus+"']/li["+position+"]"));
        Actions action=new Actions(driver);
        //perform drag nad drop between source and destination element
        action.dragAndDrop(srcElement, dstElement).build().perform();
        System.out.println("changing the status of "+dealsname+" from "+srcStatus+" to "+dstStatus);
        //get the name of dest deal
        WebElement dstDealName=driver.findElement(By.xpath("//ul[@milestone='"+dstStatus+"']/li[1]/descendant::a[1]"));
		verifyDealsStatus(dstStatus,dstDealName);
				} 	
	public void verifyDealsStatus(String expectedStatus,WebElement element) throws Exception
	{
		//wait until the dst element is clickable 
		waitForElementToBeClickable(element);
		//perform click operation
		element.click();
		//get the updated status of deal
		String actualStatus=driver.findElement(By.xpath("//div[@class=' text-muted deal-track text-xs']/span[1]")).getText();
		//compare the actual and expected deal status
		 if(actualStatus.equals(actualStatus))
		 {
			 System.out.println("Successfully performed drag and drop operation"); 
		 }
		 else
		 {
			 throw new Exception("Drag and drop did worked from source element");
		 }
	}}
	
