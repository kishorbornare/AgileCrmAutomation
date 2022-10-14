

package agilecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.agilecrmautomation.BaseClass;

public class CompanyPage extends BaseClass {
	By CompanyButton=By.id("companiesmenu");
	   By addCompanyButton= By.id("view-list");
	 By companyName= By.id("company_name");
	 By companyUrl=By.id("company_url");
	 By contineEditButton= By.id("continue-company");
	By emailName= By.xpath("//div[contains(@class,'second')]/descendant::input[@name='email']");
	By phoneNumber=By.xpath("//div[contains(@class,'second')]/descendant::input[@id='phone']");
	By website=By.xpath("//div[contains(@class,'second')]/descendant::input[@id='website']");
	By address= By.xpath("//div[contains(@class,'second')]/descendant::input[@id='address']");
	 
	public void addCompany() throws Exception {
   
		
		
		
 WebElement CompanyButton1=driver.findElement(this.CompanyButton);
	
		WebElement CompanyButton = driver.findElement(this.CompanyButton);
		Actions action = new Actions(driver);
		action.click(CompanyButton).build().perform();
	   WebElement addCompanyButton = driver.findElement(this.addCompanyButton);
		action.click(addCompanyButton).build().perform();
		WebElement companyName = driver.findElement(this.companyName);
		companyName.sendKeys("Boff");
		WebElement companyUrl = driver.findElement(this.companyUrl);
		action.click(companyUrl).sendKeys("boxer").perform();
	   WebElement contineEditButton= driver.findElement(this.contineEditButton);
	   contineEditButton .click();
		Thread.sleep(3000);
			WebElement emailName = driver
				.findElement(this.emailName);
		action.click(emailName).sendKeys("cybersuccess@yopmail.com").build().perform();
//		Select select = new Select(driver
//				.findElement(this.emailName));
//		select.selectByIndex(2);
     	WebElement phoneNumber = driver
				.findElement(this.phoneNumber);
		action.click(phoneNumber).sendKeys("58+8+8+8").build().perform();
	// select1= new Select(driver.findElement(this.phoneNumber));
		//select1.selectByIndex(2);
		WebElement website = driver
				.findElement(this.website);
		action.click(website).sendKeys("www.jdbfhfbfh.com").build().perform();
//		Select select2=new Select(driver.findElement(this.website));
//		select2.selectByIndex(2);
		WebElement address = driver
				.findElement(this.address);
		action.click(address).sendKeys("ggggeggeuecu").build().perform();
		//select.selectByIndex(2);
		driver.findElement(By.id("city")).sendKeys("Nasik");
		driver.findElement(By.id("state")).sendKeys("MH");
		driver.findElement(By.id("zip")).sendKeys("123432");
		Select select3 = new Select(driver.findElement(By.name("country")));
		select3.selectByVisibleText("India");
		driver.findElement(By.id("company-update")).click();
	}
	
	}

/*
 * // label[text()='Tag']/following::div/div/ul
 * 
 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); Actions
 * action1 = new Actions(driver); action.build().perform(); //
 * action.clickAndHold().moveToElement(null).release().perform();
 * 
 * click(By.xpath("//li[@id='companiesmenu']/a/i"), "clickoncompany");
 * click(By.xpath("//button[contains(text(),'Add Company')]"),
 * "click on add company button");
 * driver.findElement(By.id("company_name")).sendKeys("vijaywada"); //
 * driver.findElement(By.id("continue-company")).click();
 * click(By.id("continue-company"), "clickon continue editing");
 * 
 * Select select2 = new Select(driver.findElement(By.name("country"))); //
 * select.selectByVisibleText("India"); // select.selectByIndex(12); if
 * (!select.isMultiple()) { List<WebElement> alloptions = select.getOptions();
 * 
 * for (WebElement element : alloptions) { String option = element.getText();
 * System.out.println(option); }
 * 
 * } driver.findElement(By.xpath("//*[@id="company-update"]")).click(); //
 * List<WebElement> countryselect=select.getOptions(); // for(WebElement
 * element:countryselect) { // String text=element.getText(); //
 * if(text.equalsIgnoreCase("Austria")) // {
 * 
 * // } /// }
 * 
 * // System.out.println(text);
 * 
 * driver.findElement(By.xpath("//div[@class='contact-lhs-actions']/a[1]")).
 * click(); driver.findElement(By.xpath(
 * "//div[contains(@class,'second')]/descendant::input[@id='email']"))
 * .sendKeys("krish@yopmail.com"); Select select3 = new Select(driver
 * .findElement(By.xpath(
 * "//div[contains(@class,'second')]/descendant::select[@name='email-select']"))
 * ); select1.selectByIndex(2);
 * driver.findElement(By.id("company-update")).click();
 * 
 * {
 * 
 * } }
 */
