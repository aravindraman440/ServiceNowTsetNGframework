package businessapplication;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public ChromeDriver driver;
	@Parameters({"url","username","password"})
	@BeforeMethod
public void preCondition(String url,String username,String password) {
	WebDriverManager.chromedriver().setup();
 driver = new ChromeDriver();
	// step1: enter url
	driver.get("https://dev103117.service-now.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	// step2:Login with positive credencial
	driver.switchTo().frame("gsft_main");
	driver.findElementById("user_name").sendKeys(username);
	driver.findElementById("user_password").sendKeys(password);
	driver.findElementById("sysverb_login").click();
	
	// step3:search on filter navigater enter the Business Application
	WebElement id = driver.findElementByXPath("//input[@id='filter']");
	id.sendKeys("Business Applications", Keys.ENTER);
	driver.findElementByXPath("(//div[text()='Business Applications'])[1]").click();
	driver.switchTo().defaultContent();

}
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
}
