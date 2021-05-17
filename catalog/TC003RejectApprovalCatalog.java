package catalog;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003RejectApprovalCatalog extends BaseClass  {
@Test
	public  void rejectApproval() throws InterruptedException {
		
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
		dd1.selectByVisibleText("Rejected");
		
		WebElement state = driver.findElementById("sc_task.state");
		Select dd2 = new Select(state);
		dd2.selectByVisibleText("Closed Skipped");
		
		driver.findElementById("sysverb_update_bottom").click();
		System.out.println("reject catalog");

	}

}