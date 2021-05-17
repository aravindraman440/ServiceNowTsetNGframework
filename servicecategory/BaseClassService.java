package servicecategory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassService {
	public ChromeDriver driver;
		
@Parameters({"url","username","password"})
@BeforeMethod
public void preCondition(String url,String uName,String pWord) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	// step1: enter url
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	// step2:Login with positive credencial
	driver.switchTo().frame("gsft_main");
	driver.findElementById("user_name").sendKeys(uName);
	driver.findElementById("user_password").sendKeys(pWord);
	driver.findElementById("sysverb_login").click();
	Thread.sleep(1000);
	// step3:search on filter navigater enter the Service Catalog
	WebElement id = driver.findElementByXPath("//input[@id='filter']");
	id.sendKeys("Service catalog", Keys.ENTER);
	driver.findElementByXPath("(//a[@target='gsft_main']//div[text()='Service Catalog'])[1]").click();
	driver.switchTo().defaultContent();
	
}
@AfterMethod
public void postCondition() {
	driver.close();
}
}
