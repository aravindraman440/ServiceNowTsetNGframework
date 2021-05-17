package ticketmanagement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003AssignExsistingTicket extends BaseClassTicket {
@Test
	public  void assignExisting() throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://dev103117.service-now.com");
		driver.switchTo().frame(0);
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("India@123");
		driver.findElementById("sysverb_login").click();
		driver.findElementByXPath("//input[@id='filter']").sendKeys("My work",Keys.ENTER);
		driver.findElementByXPath("(//div[text()='My Work'])[1]").click();
		
		WebElement frame = driver.findElementById("gsft_main");
		driver.switchTo().frame(frame);
		
		WebElement search = driver.findElementByXPath("//select[@class='form-control default-focus-outline']");
		Select dd = new Select(search);
		dd.selectByVisibleText("Task type");
		
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@class='form-control']").sendKeys("Ticket",Keys.ENTER);
		
		Thread.sleep(2000);
		driver.findElementByXPath("//a[@class='linked formlink']").click();
		
		WebElement state = driver.findElementById("ticket.state");
		Select dd1 = new Select(state);
		dd1.selectByVisibleText("Closed Complete");
		
		
		WebElement priority = driver.findElementById("ticket.priority");
		Select dd2 = new Select(priority);
		dd2.selectByVisibleText("2 - High");
		
		driver.findElementById("sysverb_update_bottom").click();
		System.out.println("Assign Existing ticket");
	}

}

