package servicecategory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC004DeleteOrder extends BaseClassService {
	@Test
public  void deleteOrder() throws InterruptedException {
	// step4:click on Mobiles
	driver.switchTo().frame("gsft_main");
	Thread.sleep(2000);
	driver.findElementByXPath("//td[@class='drag_section_movearea']/a[text()='Mobiles']").click();
	driver.switchTo().defaultContent();
	// step5:click on iphone 6s
	driver.switchTo().frame("gsft_main");
	driver.findElementByLinkText("iPhone 6s").click();
	driver.switchTo().defaultContent();
	// step7:select as a dropdown in gold
	driver.switchTo().frame("gsft_main");
	WebElement dropDown1 = driver.findElementByXPath("(//select[@class='form-control cat_item_option '])[1]");
	Select select1 = new Select(dropDown1);
	select1.selectByVisibleText("Gold");
	// step8:select as a dropdown in 128
	WebElement dropDown2 = driver.findElementByXPath("(//select[@class='form-control cat_item_option '])[2]");
	Select select2 = new Select(dropDown2);
	select2.selectByVisibleText("128");
	// step9:Select Order now option
	driver.findElementById("oi_order_now_button").click();
	driver.switchTo().defaultContent();
	// step10:Verify order is placed and copy the request number
	driver.switchTo().frame("gsft_main");
	String text = driver.findElementById("requesturl").getText();
	System.out.println(text);
	driver.switchTo().defaultContent();
	Thread.sleep(2000);
	driver.findElementByXPath("//div[text()='Requests']").click();
	
	driver.switchTo().frame("gsft_main");
	
	driver.findElementByXPath("(//input[@class='form-control'])[1]").sendKeys(text);
	driver.switchTo().defaultContent();
	
	driver.switchTo().frame("gsft_main");
	driver.findElementByXPath("(//td[@class='vt']/a)[1]").click();
	driver.switchTo().defaultContent();
	driver.switchTo().frame("gsft_main");
	driver.findElementByXPath("(//button[text()='Delete'])[1]").click();
	driver.findElementByXPath("//div[@class='modal-footer']/button[@id='ok_button']").click();
	driver.switchTo().defaultContent();
	System.out.println("deleted updated");
		
	
	
}
}