package queueentry;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001CreateChatQueueEntry extends BaseClassQueue{
@Test
	
	public  void createChat() {
		
			
		WebElement frame = driver.findElementById("gsft_main");
		driver.switchTo().frame(frame);
		driver.findElementByXPath("//button[text()='New']").click();
		driver.findElementByLinkText("Chat_queue_entry").click();

		driver.findElementByClassName("form-control").sendKeys("Testleaf");

		driver.findElementById("sysverb_insert_bottom").click();
		System.out.println("Create chat Queue entry");
		
	}

}