package caller;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassCaller {
	public ChromeDriver driver;
	@BeforeMethod
public void preCondition() {
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	ChromeDriver driver = new ChromeDriver(options);

	driver.manage().window().maximize();
	driver.get("https://dev103117.service-now.com");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	// login with credentials
	driver.switchTo().frame(0);
	driver.findElement(By.id("user_name")).clear();
	driver.findElement(By.id("user_name")).sendKeys("admin");

	driver.findElement(By.id("user_password")).clear();
	driver.findElement(By.id("user_password")).sendKeys("India@123");

	driver.findElement(By.id("sysverb_login")).click();

	// search incident on field navigator
	driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("caller", Keys.ENTER);
	driver.findElement(By.xpath("//div[text()='Callers']")).click();

	
}
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
}
