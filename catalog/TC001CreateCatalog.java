package catalog;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001CreateCatalog extends BaseClass {
@Test
	public  void createCatalog() throws InterruptedException {
			
		WebElement frame = driver.findElementById("gsft_main");
		driver.switchTo().frame(frame);
		driver.findElementByXPath("//button[text()='New']").click();
		driver.findElementByLinkText("Catalog Task").click();
		Thread.sleep(5000);
//		driver.switchTo().frame("gsft_main");
		driver.findElementByXPath("//input[@id='sys_display.sc_task.cmdb_ci']").sendKeys("Java Application Server FLX");
		Thread.sleep(3000);
		driver.findElementByXPath("(//textarea[@class='form-control'])[1]").sendKeys("Testleaf");
		driver.findElementById("sysverb_insert_bottom").click();
	
		System.out.println("create catalog");
		
		
		
		
		
	}

}