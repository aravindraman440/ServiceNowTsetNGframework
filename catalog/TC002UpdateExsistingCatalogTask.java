package catalog;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002UpdateExsistingCatalogTask extends BaseClass  {
@Test
	public  void updateCatalog() throws InterruptedException {
			
		WebElement frame = driver.findElementById("gsft_main");
		driver.switchTo().frame(frame);
		
		WebElement search = driver.findElementByXPath("//select[@class='form-control default-focus-outline']");
		Select dd = new Select(search);
		dd.selectByVisibleText("Task type");
		
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@class='form-control']").sendKeys("Catalog Task",Keys.ENTER);
		
		driver.findElementByXPath("//a[@class='linked formlink']").click();
		
		WebElement approval = driver.findElementById("sc_task.approval");
		Select dd1 = new Select(approval);
		dd1.selectByVisibleText("Requested");
		
		WebElement state = driver.findElementById("sc_task.state");
		Select dd2 = new Select(state);
		dd2.selectByVisibleText("Work in Progress");
		
		WebElement priority = driver.findElementById("sc_task.priority");
		Select dd3 = new Select(priority);
		dd3.selectByVisibleText("1 - Critical");
		
		Thread.sleep(2000);
		driver.findElementById("sysverb_update_bottom").click();
		
  System.out.println("updated existing");
	}

}