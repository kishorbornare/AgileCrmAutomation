package agilecrm.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.agilecrmautomation.BaseClass;

public class ContactPage extends BaseClass {
	String firstName = "kishorkumar";
	String lastName = "bornare";
	String emailId = "kbc@gmail.com";
	String mobNumber = "706777566";
	By contactMenu = By.id("contactsmenu");
	By addConttact = By.xpath("//div[@id='view-list']/div/button");
	By fname = By.id("fname");
	By continueEdit = By.id("continue-contact");
	By update = By.xpath("//a[@type='submit']");
	By allCheckBox = By.xpath("//a[text()='All']");
	By contactChequebox = By.xpath("//a[text()='Contacts']");
	By searchButton = By.xpath("//i[@class='search material-icons']");

	public void addContact() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		waitForVisibilityOfElement(driver.findElement(this.contactMenu));
		click(this.contactMenu, "click on contactmenu");

		// waitForVisibilityOfElement(driver.findElement(By.xpath("//div[@id='view-list']/div/button")));
		click(this.addConttact, "click on addcontact");
		waitForVisibilityOfElement(driver.findElement(this.fname));
		driver.findElement(this.fname).sendKeys(firstName);
		click(this.continueEdit, "click on continue edit");
		click(this.update, "cllick on update");
	}

	public void searchContact() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.xpath("//li[@id='calendarmenu']/preceding::button[3]")).click();
		click(this.allCheckBox, "click on all checkbox");
		click(this.contactChequebox, "click on contact checkbox");
		driver.findElement(By.id("searchText")).sendKeys(firstName);
		click(this.searchButton, "click on search button");
		waitForVisibilityOfElement(driver.findElement(By.id("search-model-list")));
		driver.findElement(By.id("search-model-list")).click();
	}

	public void updateContact() {

		driver.findElement(
				By.xpath("//*[@id=\"contact-details-block\"]/div/div/div/div/div/div[1]/div/div/div[7]/a[1]")).click();
		driver.findElement(By.name("lname")).sendKeys("Bornare123");
		driver.findElement(By.id("update")).click();
	}

	public void deleteContact() {

		driver.findElement(By.xpath("//i[@class='material-icons more_vert v-middle']")).click();
		// waitForVisibilityOfElement(driver.findElement(By.cssSelector("#contact-actions-delete
		// > span")));
		click(By.cssSelector("#contact-actions-delete > span"), "click on dlt");
		driver.findElement(By.cssSelector("#contact-actions-delete > span")).click();
		waitForVisibilityOfElement(driver.findElement(By.id("success_callback")));
		driver.findElement(By.id("success_callback")).click();

		waitForVisibilityOfElement(driver
				.findElement(By.xpath("//div[@class='panel-middle-align-mobile m-b-sm']/preceding::div[1]/button")));
		driver.findElement(By.xpath("//div[@class='panel-middle-align-mobile m-b-sm']/preceding::div[1]/button"))
				.click();

		click(By.xpath("//div[@class='panel-middle-align-mobile m-b-sm']/preceding::div[1]/button/following::li[10]/a"),
				"click on deelet");

		waitForVisibilityOfElement(driver.findElement(By.id("success_callback")));
		driver.findElement(By.id("success_callback")).click();
	}

	public static void getContact() {
		waitForVisibilityOfElement(driver.findElement(By.id("contactsmenu")));
		click(By.id("contactsmenu"), "click on contactmenu");

		// driver.findElement(By.xpath("contactsmenu")).click();
		List<WebElement> web = driver.findElements(By.xpath("//*[@id=\"contacts-table\"]/thead/tr/th[2]"));
		System.out.println(web);
	}

}
