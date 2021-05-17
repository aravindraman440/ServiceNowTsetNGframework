package incidentmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.jsoup.select.Evaluator.Id;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_003_AssingTheIncident extends BaseClassIncident {
@Test
	public  void assignIncident() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.get("https://dev103117.service-now.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// login with credentials
		driver.switchTo().frame(0);
		driver.findElement(By.id("user_name")).clear();
		driver.findElement(By.id("user_name")).sendKeys("admin");

		driver.findElement(By.id("user_password")).clear();
		driver.findElement(By.id("user_password")).sendKeys("India@123");

		driver.findElement(By.id("sysverb_login")).click();

		// search incident on field navigator
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident", Keys.ENTER);

		// Click on open
		driver.findElement(By.xpath("//div[text()='Open']")).click();

		driver.switchTo().frame(0);
		Thread.sleep(3000);

		// search for existing incident
		WebElement textSelect = driver.findElement(By.className("form-control"));
		Select dropdown = new Select(textSelect);
		dropdown.selectByValue("zztextsearchyy");
		
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Saheel", Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();

		// Get incident number
		String incidentNo = driver.findElement(By.xpath("//input[@class='form-control']")).getAttribute("value");
		System.out.println(incidentNo);

		// Setting group as Software
		driver.findElement(By.id("sys_display.incident.assignment_group")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("sys_display.incident.assignment_group")).sendKeys("Software",Keys.ENTER);
		Thread.sleep(2000);

		// selecting state as Inprogress
		driver.findElement(By.xpath("(//textarea[contains(@class,'sn-string-textarea form-control')])[3]")).sendKeys("Testing");
		Thread.sleep(2000);

		// update
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentNo, Keys.ENTER);

		boolean group = driver.findElement(By.linkText("Software")).isDisplayed();
		
		// verification
		if (group) {
			System.out.println("The incident is updated successfully");
		} else {
			System.out.println("The incident is not updated successfully");
		}
		

	}

}