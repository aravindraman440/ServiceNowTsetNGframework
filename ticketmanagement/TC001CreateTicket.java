package ticketmanagement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001CreateTicket extends BaseClassTicket {
	@Test

	public  void createTicket() throws InterruptedException {
		
		WebElement frame = driver.findElementById("gsft_main");
		driver.switchTo().frame(frame);
		driver.findElementByXPath("//button[text()='New']").click();
		
		driver.findElementByLinkText("Ticket").click();
		
		driver.findElementById("ticket.short_description").sendKeys("TestLeaf");
		
		Thread.sleep(3000);
		driver.findElementById("sysverb_insert_bottom").click();
		
		System.out.println("Create Ticket");
		

	}

}