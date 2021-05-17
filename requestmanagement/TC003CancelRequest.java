package requestmanagement;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003CancelRequest extends BaseClassRequest{
	@Test
public  void cancelRequest() {
	
	//step4:open the existing Request
	driver.switchTo().frame("gsft_main");
	String text = driver.findElementByXPath("(//td[@class='vt']/a)[1]").getText();
	System.out.println("existing Request:"+text);
	driver.findElementByXPath("(//td[@class='vt']/a)[1]").click();
	driver.switchTo().defaultContent();
	//step5:click on cancel request
	driver.switchTo().frame("gsft_main");
	driver.findElementByXPath("(//button[text()='Cancel Request'])[1]").click();
	driver.switchTo().defaultContent();
	
	
	//verify the request is cancelled
	driver.switchTo().frame("gsft_main");
	String text2 = driver.findElementByXPath("(//caption[@class='sr-only']/following::tr)[3]").getText();
	System.out.println("text2"+text2);
}
}