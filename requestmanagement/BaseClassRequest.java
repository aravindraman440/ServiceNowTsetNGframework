package requestmanagement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassRequest {
public ChromeDriver driver ;
@Parameters({"url","username","password"})
	@BeforeMethod
	public void preCondition(String url,String uName,String pWord) {
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
		//step3:enter my work in filter navigater
		WebElement id = driver.findElementByXPath("//input[@id='filter']");
		id.sendKeys("My Work", Keys.ENTER);
		//select under my work
		driver.findElementByXPath("(//div[text()='My Work'])[1]").click();

	}
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
}
