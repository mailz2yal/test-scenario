package com.assignmenttwo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateAccount {
	static WebDriver driver;

	@BeforeTest
	public static void openCromeBrowser() throws InterruptedException

	{
		System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.navigate().to("https://facebook.com");
	}

	

	
	@Test(priority=0)
	public void getCurrentUrl() throws InterruptedException {
		String currenturl = driver.getCurrentUrl();
		Assert.assertEquals("https://www.facebook.com/", currenturl);
		{
			System.out.println("the current url" + ':' + currenturl);

		}
		Thread.sleep(2000);
		boolean status = driver.findElement(By.linkText("Create new account")).isDisplayed();
		if (status) {
			System.out.println("Create account is verified");
		} else {

			System.out.println("Create account is verified");
		}
	}

	@Test(priority=1)
	public void VerifyCreateAccount() {
		driver.findElement(By.linkText("Create new account")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	@Test(priority=2)
	public void creatingAccount() {

		WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
		firstname.sendKeys("yalmozhi");
		WebElement secondname = driver.findElement(By.xpath("//input[@name='lastname']"));
		secondname.sendKeys("samigounden");
		WebElement email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		email.sendKeys("mailz2yal@gmail.com");
		WebElement reenteremail = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
		reenteremail.sendKeys("mailz2yal@gmail.com");
		WebElement newpasword = driver.findElement(By.id("password_step_input"));
		newpasword.sendKeys("yal@viya");
		WebElement month = driver.findElement(By.id("month"));
		Select selectmonth = new Select(month);
		selectmonth.selectByIndex(3);
		WebElement date = driver.findElement(By.id("day"));
		Select selectdate = new Select(date);
		selectdate.selectByIndex(3);
		WebElement year = driver.findElement(By.id("year"));
		Select selectyear = new Select(year);
		selectyear.selectByValue("1991");
		WebElement gender = driver.findElement(By.xpath("//input[@name='sex']"));
		if (gender.isDisplayed()) {
			gender.click();
		}

		WebElement submit = driver.findElement(By.xpath("//button[@name='websubmit']"));
		submit.click();
	}

	@Test(priority=3)
	public void checkingTheAccount() {
		WebElement verify = driver.findElement(By.xpath("//input[@id='recovery_code_entry']"));
		verify.sendKeys("304779");
		WebElement continu = driver.findElement(By.xpath("//button[@name='reset_action']"));
		continu.click();
		WebElement text = driver.findElement(By.xpath("//h1[text()='Your story']"));
		text.getText();
		Assert.assertEquals("Your story", text);
		System.out.println(" accout created succesfully");
	}

	@AfterTest
	public void tearDowm() {
		driver.quit();

	}

}
