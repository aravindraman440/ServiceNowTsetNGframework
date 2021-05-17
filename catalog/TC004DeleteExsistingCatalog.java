package catalog;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC004DeleteExsistingCatalog extends BaseClass {
@Test
	public  void deleteCatalog() throws InterruptedException {
			
		WebElement frame = driver.findElementById("gsft_main");
		driver.switchTo().frame(frame);
		
		WebElement search = driver.findElementByXPath("//select[@class='form-control default-focus-outline']");
		Select dd = new Select(search);
		dd.selectByVisibleText("Task type");
		
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@class='form-control']").sendKeys("Catalog Task",Keys.ENTER);
		
		
        driver.findElementByXPath("//a[@class='linked formlink']").click();
        
        driver.findElementById("sysverb_delete").click();
		
		driver.findElementById("ok_button").click();
		System.out.println("Delete catlog");
	}

}