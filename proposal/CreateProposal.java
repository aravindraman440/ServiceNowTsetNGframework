package proposal;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProposal extends BaseClassProposal {
	@Test

	public  void createProposal() throws InterruptedException {


		Actions builder = new Actions(driver);

		Thread.sleep(5000);
		WebElement iframe2 = driver.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(iframe2);

		WebElement New = driver.findElementByXPath("//button[@id='sysverb_new']");
		Thread.sleep(5000);
		builder.moveToElement(New).build().perform();
		New.click();

		String Num = driver.findElement(By.id("std_change_proposal.number")).getText();
		System.out.println(Num);

		driver.findElement(By.id("std_change_proposal.short_description")).sendKeys("Propsal Created");

		Thread.sleep(2000);
		WebElement changeReq = driver.findElement(By.xpath("(//span[text()='Change Request values'])[1]"));
		changeReq.click();

		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();

		List<WebElement> list = driver.findElements(By.xpath("//a[@class='linked formlink']"));

		for (WebElement list1 : list) {
			list1.getSize();
			String text = list1.getText();
			if (text.contains(Num)) {
				System.out.println("Proposal Created");
				break;
			} else {
				System.out.println("Proposal Not Created");
			}
		}
	}
}