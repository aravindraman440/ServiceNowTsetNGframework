package businessapplication;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeletinganExistingApplication extends BaseClass {
	//priority default 0
	@Test()
public  void deletingExistingApplication() throws InterruptedException {
	//step4:click on first resultingApplications
	driver.switchTo().frame("gsft_main");
	String text = driver.findElementByXPath("(//td[@class='vt']/a)[1]").getText();
	System.out.println(text);
	driver.findElementByXPath("(//td[@class='vt']/a)[1]").click();
	driver.switchTo().defaultContent();
	driver.switchTo().frame("gsft_main");
	//step5:click on delete button
	driver.findElementByXPath("//button[@id='sysverb_delete']").click();
	//step6:confirm on promptAlert
	driver.findElementByXPath("//div[@class='modal-footer']/button[@id='ok_button']").click();
	driver.switchTo().defaultContent();
	//step7:Verify the deleted Application
	driver.switchTo().frame("gsft_main");
	Thread.sleep(2000);
	driver.findElementByXPath("//span[@class='input-group-addon input-group-select']/following::input").sendKeys(text,Keys.ENTER);
	String text2 = driver.findElementByXPath("(//td[@class='vt']/a)[1]").getText();
	System.out.println(text2);
	if(text.equals(text2)) {
		System.out.println("The Business Application not Deletedd");
	}else
	{
		System.out.println("The Business Application  Deleted");
	}
	
}
}