package changemanagement;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001CreateManagement extends BaseClassChange{

	@Test
	public  void createManagement() throws InterruptedException {

		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(iframe);

		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='container-fluid wizard-container']/a)[1]")).click();

		String number = driver.findElement(By.xpath("//input[@id='change_request.number']")).getAttribute("value");
		System.out.println(number);

		driver.findElement(By.xpath("//input[@id='change_request.short_description']")).sendKeys("Management Created");

		driver.findElement(By.xpath("//textarea[@id='change_request.description']"))
				.sendKeys("Change Request Management will be created");

		driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();

		driver.switchTo().defaultContent();

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[text()='Open'])[3]")).click();

		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(number, Keys.ENTER);

		String num2 = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		if (number.equals(num2)) {
			System.out.println("Change request should be created successfully");

		} else {
			System.out.println("Change request not created");

		}
	}
}