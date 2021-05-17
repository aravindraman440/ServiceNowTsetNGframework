package caller;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_UpdateCaller extends BaseClassCaller {
@Test(invocationCount = 2)
	public  void updateCaller() throws InterruptedException {
	// Click on Caller
	Thread.sleep(5000);
		
	
		// Search for existing Caller
		driver.switchTo().frame(0);
		WebElement dropDown = driver.findElement(By.className("form-control"));
		Select dd1 = new Select(dropDown);
		dd1.selectByValue("zztextsearchyy");
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("creating sample test", Keys.ENTER);

		driver.findElement(By.xpath("(//a[@class='linked formlink'])")).click();

		// Modifying the Business Phone number
		driver.findElement(By.id("sys_user.phone")).clear();
		driver.findElement(By.id("sys_user.phone")).sendKeys("7639981100");

		// Click on update button
		driver.findElement(By.id("sysverb_update")).click();

	// Verification
	 dropDown = driver.findElement(By.className("form-control"));
	 
	 dd1 = new Select(dropDown);
	dd1.selectByValue("zztextsearchyy");
	
	driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("creating sample test",Keys.ENTER);
	
	String phoneNum = driver.findElement(By.xpath("(//td[@class='vt'])[3]")).getText();
	System.out.println(phoneNum);
	String businessPhonNum = phoneNum.replaceAll("\\D","");
	
	System.out.println(businessPhonNum);
		if (businessPhonNum.equalsIgnoreCase("7639981100")) {
		System.out.println("The caller is updated successfully");
		}else {
			System.out.println("The caller is not updated successfully");
		}	
	

	}

}