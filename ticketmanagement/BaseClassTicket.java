package ticketmanagement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassTicket {
	public ChromeDriver driver;
	@Parameters({"url","username","password"})
@BeforeMethod
public void preCondition(String url,String username,String password) {
	WebDriverManager.chromedriver().setup();
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--disable-notifications");
	driver = new ChromeDriver(option);
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	driver.get(url);
	driver.switchTo().frame(0);
	driver.findElementById("user_name").sendKeys(username);
	driver.findElementById("user_password").sendKeys(password);
	driver.findElementById("sysverb_login").click();
	driver.findElementByXPath("//input[@id='filter']").sendKeys("My work",Keys.ENTER);
	driver.findElementByXPath("(//div[text()='My Work'])[1]").click();
	
}
@AfterMethod
public void postCondition() {
	driver.close();
}
}
