package servicecategory;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002UpdatedOrder extends BaseClassService{
	@Test
public  void updatedOrder() throws InterruptedException {
	
	driver.switchTo().frame("gsft_main");
	driver.findElementByXPath("(//td[@class='vt']//a[@class='linked formlink'])[3]").click();
	driver.switchTo().defaultContent();
	
	driver.switchTo().frame("gsft_main");
	WebElement dropDown1 = driver.findElementByXPath("//select[@id='sc_request.approval']");
	Select select1=new Select(dropDown1);
	select1.selectByVisibleText("Requested");
	WebElement dropDown2 = driver.findElementByXPath("//select[@id='sc_request.request_state']");
	Select select2=new Select(dropDown2);
	select2.selectByVisibleText("Approved");

	driver.findElementById("sc_request.description").sendKeys("the mobile phone orderd and request number checked");
	driver.findElementById("sc_request.short_description").sendKeys("the mobile short list diplayed");
	WebElement id = driver.findElementById("sc_request.special_instructions");
	id.clear();
	id.sendKeys("Updated oreder");
	driver.findElementByXPath("(//button[text()='Update'])[1]").click();
	driver.switchTo().defaultContent();
	System.out.println("Updated Succesfully");
		
}
}