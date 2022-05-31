package com.assignmentfive;

import java.time.Duration;
import java.util.logging.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CompanyAdmin {
	String optionsel = "1715,Bluegrass Trail Chaska, Minnesota, USA";
	WebDriver driver;
	
	@BeforeTest
	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.vitshr.com/");
		WebElement register = driver.findElement(By.linkText("Register"));
		register.click();
		//WebElement details = driver.findElement(By.id("details-button"));
		//details.click();
		//WebElement proceed = driver.findElement(By.linkText("Proceed to web.vitshr.com (unsafe)"));
		//proceed.click();
	}

	public void registerCompany() throws InterruptedException {

		WebElement companyname = driver.findElement(By.xpath("//input[@name='companyName']"));
		companyname.sendKeys("Vits");
		WebElement companyweb = driver.findElement(By.xpath("//input[@name='companyWebsite']"));
		companyweb.sendKeys("www.vitshr.com");
		WebElement phoneno = driver.findElement(By.xpath("//input[@name='phoneNo']"));
		phoneno.sendKeys("6156182666");
	}

	public void enterLocation() throws InterruptedException {
		WebElement companyadd = driver
				.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div[4]/div/div/input"));
		companyadd.click();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement web = driver.findElement(By.xpath("//input[@class='pac-target-input']"));
		web.sendKeys("1715 Bluegrass Trail Chaska, Minnesota, USA");
		Thread.sleep(3000);
		web.sendKeys(Keys.ARROW_DOWN);
		web.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		WebElement done = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/header/div/button[2]/span[1]"));
		done.click();
	}

	public void createSighnup() {

		WebElement zipcode = driver.findElement(By.xpath("//input[@name='zipcode']"));
		zipcode.sendKeys("55386");
		WebElement empid = driver.findElement(By.xpath("//input[@name='fein']"));
		empid.sendKeys("67-8995432");
		WebElement fedempid = driver.findElement(By.xpath("//input[@name='employerIdentificationNumber']"));
		fedempid.sendKeys("67-8905432");
		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		email.sendKeys("mailz2yal@gmail.com");
		WebElement logid = driver.findElement(By.xpath("//input[@name='loginId']"));
		logid.sendKeys("YALMOZHI123");
		WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
		pass.sendKeys("abcdef*23456");
		WebElement sighnup = driver
				.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/form/div[13]/div/button"));
		sighnup.click();

	}

	@Test
	public void excuteMeth() throws InterruptedException {
		registerCompany();
		enterLocation();
		createSighnup();
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
