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

public class TC001_CreateCaller extends BaseClassCaller {
@Test(invocationCount = 3)
	public  void createCaller() throws InterruptedException {
	// Click on Caller
	Thread.sleep(5000);
		// Click on new button inside the frame
		driver.switchTo().frame(0);
		driver.findElement(By.id("sysverb_new")).click();

		// Fill mandatory fields
		driver.findElement(By.id("sys_user.first_name")).sendKeys("Saheel");
		driver.findElement(By.id("sys_user.last_name")).sendKeys("Khan");
		driver.findElement(By.id("sys_user.title")).sendKeys("creating sample test");
		driver.findElement(By.id("sys_user.email")).sendKeys("saheel1410@gmail.com");
		driver.findElement(By.id("sys_user.phone")).sendKeys("7639981100");
		driver.findElement(By.name("sys_user.mobile_phone")).sendKeys("7639981110");

		// Click on submit button
		driver.findElement(By.id("sysverb_insert_bottom")).click();

		// Verification
		WebElement dropDown = driver.findElement(By.className("form-control"));
		Select dd1 = new Select(dropDown);
		dd1.selectByValue("first_name");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("Saheel",Keys.ENTER);
		
		Thread.sleep(5000);
		String verificationName = driver.findElement(By.xpath("(//tbody[@class='list2_body']//tr[@class='list_row list_odd']//td[@class='vt']/following-sibling::td)[1]")).getText();
		System.out.println(verificationName);
		if (verificationName.equalsIgnoreCase("saheel")) {
			System.out.println("The caller is created successfully");
		}else {
			System.out.println("The caller is not created successfully");
		}
	
		//driver.close();

	}

}