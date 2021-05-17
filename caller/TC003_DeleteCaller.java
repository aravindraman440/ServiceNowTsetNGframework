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

public class TC003_DeleteCaller extends BaseClassCaller {
@Test(enabled = false)
	public  void deleteCaller() throws InterruptedException {
	// Click on Caller
	Thread.sleep(5000);
		
		// Search for existing Caller
		driver.switchTo().frame(0);
		WebElement dropDown = driver.findElement(By.className("form-control"));
		Select dd1 = new Select(dropDown);
		dd1.selectByValue("zztextsearchyy");
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("creating sample test", Keys.ENTER);

		driver.findElement(By.xpath("(//a[@class='linked formlink'])")).click();

		//Deleting the caller
		driver.findElement(By.id("sysverb_delete")).click();
		driver.findElement(By.id("ok_button")).click();
		
	// Verification
		
	boolean verification = driver.findElement(By.xpath("//td[text()='No records to display']")).isDisplayed();
	
	
		if (verification) {
		System.out.println("The caller is deleted successfully");
		}else {
			System.out.println("The caller is not deleted successfully");
		}	
	

	}

}