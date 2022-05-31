package com.assignmentseven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class GmailVerfyAccount {
	WebDriver driver;
	WebElement element = null;

	@BeforeTest
	public void openBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.gmail.com");
	}

	@Test
	public void gmailLogin() throws InterruptedException {
		driver.findElement(By.id("identifierId")).sendKeys("yalselenium@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("vinodh-10");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Gmail", title);
		System.out.println("gmail login successfully created");
		Thread.sleep(3000);
		String oldtitle = driver.getTitle();
		System.out.println(oldtitle);
		String originalWindow = driver.getWindowHandle();
		assert driver.getWindowHandles().size() == 1;
		Thread.sleep(3000);
		WebElement compose = driver.findElement(
				By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div[1]/div/div"));
		compose.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("qatestng@vitsconsulting.com");

		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Qa automation text mail");

		Thread.sleep(5000);

		element = driver.findElement(By.xpath("//div[@class='Ar Au']//div"));
		element.click();
		element.sendKeys("The gmail text");

		for (String windowHandle : driver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(originalWindow);
			}

			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")).click();

		}

	}

	public void closeBrowser() {

		driver.quit();

	}

}
