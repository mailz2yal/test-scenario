package com.assignmentseven;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class GmailVerfyAccount {
	WebDriver driver;

	@Test
	public void openBrowser() throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver");
	driver = new ChromeDriver();
	driver.navigate().to("https://www.gmail.com");
	driver.findElement(By.id("identifierId")).sendKeys("yalselenium@gmail.com");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[text()='Next']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("vinodh-10");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[text()='Next']")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	String title=driver.getTitle();
    System.out.println(title);
    Assert.assertEquals("Gmail",title);
    System.out.println("gmail login successfully created");
    Thread.sleep(3000);
    WebElement compose = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div[1]/div/div"));
    compose.click();
    WebElement newwindow = driver.findElement(By.xpath("/html/body/div[20]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/div/div[1]/div[2]/div[1]/div/table/tbody/tr/td[1]"));
    WebElement oldwindow= driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[8]"));
 
    String windows = driver.getWindowHandle();

	//WebElement secbutt1 = driver.findElement(By.id("home"));
	//secbutt1.click();

	Set<String> handles = driver.getWindowHandles();

	driver.switchTo().window(windows);

	int in = driver.getWindowHandles().size();
	System.out.println(in);
	//WebElement find = driver.findElement(By.id("color"));
	//find.click();

	int inw = driver.getWindowHandles().size();
	System.out.println(inw);

	for (String nowindow : handles) {
		if (!nowindow.equals(windows )) {

			driver.switchTo().window(windows);
			driver.close();

		}

	}

}
    
   



}


