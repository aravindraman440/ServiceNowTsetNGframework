package incidentmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.jsoup.select.Evaluator.Id;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_001_CreateNewIncident extends BaseClassIncident {
@Test
	public  void createNew() throws InterruptedException {
	driver.switchTo().frame(0);
		Thread.sleep(3000);

		// Get incident number
		String incidentNo = driver.findElement(By.xpath("//input[@class='form-control']")).getAttribute("value");
		System.out.println(incidentNo);
		
		// Filling mandatory fields
		driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> winHand1 = new ArrayList<String>(windowHandles);
		driver.switchTo().window(winHand1.get(1));
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Abel Tuter",Keys.ENTER);
		driver.findElement(By.linkText("Abel Tuter")).click();
		driver.switchTo().window(winHand1.get(0));
		driver.switchTo().frame(0);

		driver.findElement(By.id("incident.short_description")).sendKeys("Saheel TestLeaf");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();

		// Search with created incident no
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentNo, Keys.ENTER);
		boolean displayed = driver.findElement(By.xpath("//a[@class='linked formlink']")).isDisplayed();

		// verification
		if (displayed) {
			System.out.println("The incident is created successfully");
		} else {
			System.out.println("The incident is not created successfully");
		}
		

	}

}