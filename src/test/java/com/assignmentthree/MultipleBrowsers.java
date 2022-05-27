package com.assignmentthree;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleBrowsers {

	public static Properties properties = null;
	public static WebDriver driver;

	public static Properties loadProperties() throws IOException {

		FileInputStream fileinputstream = new FileInputStream("Config.properties");
		properties = new Properties();
		properties.load(fileinputstream);
		return properties;
	}

	@BeforeTest
	public static void launchBrowser() throws IOException, InterruptedException {
		loadProperties();
		String browser = properties.getProperty("browser");
		System.out.print(browser);

		String chromedriverlocation = properties.getProperty("chromelocation");
		String geckodriverlocation = properties.getProperty("firefoxlocation");
		System.out.print(chromedriverlocation);
		System.out.print(geckodriverlocation);
		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", chromedriverlocation);
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", geckodriverlocation);
			driver = new FirefoxDriver();
		}

	}

	public static void getTheLinks() {
		String urlLink = properties.getProperty("urllink");
		System.out.print(urlLink);
        driver.get(urlLink);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		List<WebElement> allLinks = driver.findElements(By.tagName("div"));
		System.out.println("The number of links is " + allLinks.size());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for (WebElement link : allLinks) {
			System.out.println(link.getText());
			System.out.println(link.getAttribute("href"));

		}
	}

	@Test
	public static void excuteMeth() throws InterruptedException {
		getTheLinks();

	}

	@AfterTest
	public static void closeBrowser() {
		driver.quit();

	}

}
