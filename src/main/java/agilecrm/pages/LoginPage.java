package agilecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.agilecrmautomation.BaseClass;
public class LoginPage extends BaseClass{ 
By uname=By.name("email");
	By signIn=By.xpath("//input[@type='submit']");
	  By pwd=By.name("password");

	public void login (String username,String password){
		WebElement uname=driver.findElement(this.uname);
		uname.clear();
		uname.sendKeys(username);
		WebElement pwd =driver.findElement(this.pwd);
	
		pwd.clear();
		pwd.sendKeys(password);
		
		WebElement signIn=driver.findElement(this.signIn);
		signIn.click();
		
		
		
		
	
		
//		if(driver.findElement(By.xpath("//a[@class='close']/parent::*")).isDisplayed()){
//			System.out.println("Invalid username:" +username+"or password:"+ password);
//		}
//		else{
//			driver.findElement(By.xpath("//*[@id=\"fat-menu\"]/a/span/img")).click();
//			driver.findElement(By.xpath("//*[@id=\"fatMenuModal\"]/div[2]/div/div/div/div[3]/div/a")).click();
//			driver.close();	
//		
//		}
		
		}
	
	}
