package requestmanagement;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002UpdateRequest extends BaseClassRequest {
	@Test
	public  void updateRequest() throws InterruptedException {
		//select the first request
		driver.switchTo().frame("gsft_main");
		driver.findElementByXPath("(//td[@class='vt']/a[@class='linked formlink'])[1]").click();
		driver.switchTo().defaultContent();
		//Update existing Request with location as Rhode Island,USA 
		driver.switchTo().frame("gsft_main");
		String oldWindow = driver.getWindowHandle();

		WebElement id2 = driver.findElementById("lookup.sc_request.location");
		Thread.sleep(3000);
		id2.click();
		Set<String> handles = driver.getWindowHandles();
		List<String> newlst=new ArrayList<String>(handles);
		String newOpenWindow = newlst.get(1);
		driver.switchTo().window(newOpenWindow);
		Thread.sleep(5000);
		driver.findElementByXPath("//img[@src='images/gwt/treenode_expand_plus.gifx']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//img[@src='images/gwt/treenode_expand_plus.gifx']").click();
		driver.findElementByLinkText("Rhode Island").click();
		driver.switchTo().window(oldWindow);
		// Due date as tomorrow
		driver.switchTo().frame("gsft_main");//same frame but error
		driver.findElementByXPath("(//button[@class='btn btn-default btn-ref date_time_trigger']/span)[1]").click();
		driver.findElementByXPath("//table[@class='calTable']//a[text()='13']").click();
		driver.findElementById("GwtDateTimePicker_ok").click();
		
		driver.findElementById("sc_request.description").sendKeys("new Create Request  ha s Created");
		driver.findElementById("sc_request.short_description").sendKeys("new element shorted");
		driver.findElementById("sc_request.special_instructions").sendKeys("metal special instrument");
		//driver.findElementById("sysverb_insert").click();
		System.out.println("updated");
		driver.findElementById("sysverb_update").click();


	}
}
