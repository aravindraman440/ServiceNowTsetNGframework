package requestmanagement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001CreateRequest extends BaseClassRequest{
	@Test
public  void createRequest() {
		//step4: create new request
	driver.switchTo().frame("gsft_main");
	driver.findElementById("sysverb_new").click();
	driver.switchTo().defaultContent();
	//select request
	driver.switchTo().frame("gsft_main");
	driver.findElementByLinkText("Request").click();
	driver.switchTo().defaultContent();
	//create request with default values
	driver.switchTo().frame("gsft_main");
	String attribute = driver.findElementById("sc_request.number").getAttribute("value");
	System.out.println(attribute);
	//driver.findElementById("sc_request.description").sendKeys("new Create Request  ha s Created");
	driver.findElementById("sysverb_insert").click();
	driver.switchTo().defaultContent();
	//step5:verify the new request verified
	driver.switchTo().frame("gsft_main");
	driver.findElementByXPath("(//input[@class='form-control'])[1]").sendKeys(attribute,Keys.ENTER);
	String text = driver.findElementByXPath("(//td[@class='vt']/a)[1]").getText();
	System.out.println(text);
	if(text.equals(attribute)) {
		System.out.println("The Request management has created");
	}else
	{
		System.out.println("The Request management has not created");
	}
}
}