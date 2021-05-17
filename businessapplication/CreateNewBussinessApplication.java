package businessapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewBussinessApplication extends BaseClass{
	@Test(priority = 2)
	public  void createNewBusiness() throws InterruptedException {
			//step4: click on new Button
		driver.switchTo().frame("gsft_main");
		driver.findElementByXPath("//button[text()='New']").click();
		driver.switchTo().defaultContent();
		//step5: to enter the mandatory filled
		driver.switchTo().frame("gsft_main");
		//enter name
		driver.findElementById("cmdb_ci_business_app.name").sendKeys("Aravind",Keys.ENTER);
		//enter description
		driver.findElementById("cmdb_ci_business_app.short_description").sendKeys("text lead");

		String windowHandle = driver.getWindowHandle();
		driver.findElementByXPath("//button[@id='lookup.cmdb_ci_business_app.it_application_owner']//span[1]").click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>newWindow =new ArrayList<String>(windowHandles);
		driver.switchTo().window(newWindow.get(1));
		WebElement path = driver.findElementByXPath("//span[@class='input-group-addon input-group-select']/following-sibling::input");
		Thread.sleep(2000);
		path.sendKeys("System Administrator",Keys.ENTER);
		driver.findElementByLinkText("System Administrator").click();
		driver.switchTo().window(windowHandle);
		//step6:click on submit button
		driver.switchTo().frame("gsft_main");
		driver.findElementByXPath("//button[@id='sysverb_insert']").click();
		//step7:Verify the newly created Business Application 
		driver.findElementByXPath("//span[@id='cmdb_ci_business_app_hide_search']//input[@placeholder='Search']").sendKeys("Aravind",Keys.ENTER);
		String text = driver.findElementByXPath("(//td[@class='vt']/a)[1]").getText();
		System.out.println(text);
		if(text.equals("Aravind")) {
			System.out.println("The Business Application verified");
		}else
		{
			System.out.println("The Business Application not verified");
		}

	}
}