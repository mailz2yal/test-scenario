package com.assignmentone;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Openfirefox {
	WebDriver driver;

	@BeforeTest
	public void openbrowser()

	{
		System.setProperty("webdriver.gecko.driver", "/Users/user/Downloads/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void multipleWindow() throws InterruptedException {
		driver.get("https://vitshr.com/");
		String Url = driver.getCurrentUrl();
		Thread.sleep(3000);
		Assert.assertEquals("https://vitshr.com/", Url);
		{
			System.out.println("true");

		}

		driver.navigate().to("https://facebook.com");
		driver.navigate().back();
		String vitsurl = driver.getCurrentUrl();
		System.out.println(vitsurl);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().refresh();

	}

	@AfterTest
	public void closeWindow() {

		driver.close();
	}
}
