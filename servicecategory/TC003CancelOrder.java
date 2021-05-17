package servicecategory;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003CancelOrder extends BaseClassService {
	@Test
public  void cancelOrder() throws InterruptedException {
	

	driver.switchTo().frame("gsft_main");
	driver.findElementByXPath("(//td[@class='vt']//a[@class='linked formlink'])[3]").click();
	driver.switchTo().defaultContent();
	
	driver.switchTo().frame("gsft_main");
	WebElement dropDown1 = driver.findElementByXPath("//select[@id='sc_request.approval']");
	Select select1=new Select(dropDown1);
	select1.selectByVisibleText("Rejected");
	WebElement dropDown2 = driver.findElementByXPath("//select[@id='sc_request.request_state']");
	Select select2=new Select(dropDown2);
	select2.selectByVisibleText("Closed Complete");
	
	driver.findElementByXPath("(//button[text()='Cancel Request'])[1]").click();
	
	System.out.println("cancel request");


}
}
