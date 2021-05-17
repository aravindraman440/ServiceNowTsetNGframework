package incidentmanagement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassIncident {
	public ChromeDriver driver;
	@Parameters({"url","username","password"})
@BeforeMethod
public void preCondition(String url,String username,String password) {
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	ChromeDriver driver = new ChromeDriver(options);

	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	// login with credentials
	driver.switchTo().frame(0);
	driver.findElement(By.id("user_name")).clear();
	driver.findElement(By.id("user_name")).sendKeys(username);

	driver.findElement(By.id("user_password")).clear();
	driver.findElement(By.id("user_password")).sendKeys(password);

	driver.findElement(By.id("sysverb_login")).click();

	// search incident on field navigator
	driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident", Keys.ENTER);

	// clicking on create new
	driver.findElement(By.xpath("//div[text()='Create New']")).click();
	
}
@AfterMethod
public void postCondition() {
	driver.close();
}
}
