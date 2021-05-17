package queueentry;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003ConfigureExsisting extends BaseClassQueue{
	@Test
	public  void configureExisting() throws InterruptedException {

		WebElement frame = driver.findElementById("gsft_main");
		driver.switchTo().frame(frame);

		WebElement search = driver.findElementByXPath("//select[@class='form-control default-focus-outline']");
		Select dd = new Select(search);
		dd.selectByVisibleText("Task type");

		driver.findElementByXPath("//input[@class='form-control']").sendKeys("Chat Queue Entry", Keys.ENTER);

		driver.findElementByXPath("//a[@class='linked formlink']").click();

		WebElement state = driver.findElementById("chat_queue_entry.state");
		Select dd1 = new Select(state);
		dd1.selectByVisibleText("Closed Abandoned");

		WebElement priority = driver.findElementById("chat_queue_entry.priority");
		Select dd2 = new Select(priority);
		dd2.selectByValue("1");

		Thread.sleep(5000);
		driver.findElementByXPath("//input[@id='sys_display.chat_queue_entry.cmdb_ci']").sendKeys("PS Apache02",
				Keys.ENTER);
		Thread.sleep(3000);
		driver.findElementById("sysverb_update_bottom").click();
		System.out.println("Configure  Existing chat queue");
		
	}

}
