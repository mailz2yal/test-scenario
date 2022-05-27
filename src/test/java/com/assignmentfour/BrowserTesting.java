package com.assignmentfour;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BrowserTesting {

	WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void openBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/user/Downloads/geckodriver");
			driver = new FirefoxDriver();
		}
	}

	public void searchProducts() throws InterruptedException {
		driver.navigate().to("https://www.ebay.com");
		WebElement text = driver.findElement(By.id("gh-ac"));
		text.sendKeys("apple watches");
		Thread.sleep(3000);
		WebElement electronic = driver.findElement(By.xpath("//*[@id=\"gh-cat\"]"));
		Select item = new Select(electronic);
		item.selectByVisibleText("Consumer Electronics");
		WebElement search = driver.findElement(By.xpath("//*[@id=\"gh-btn\"]"));
		search.click();
	}

	@Test
	public void closeWindow() throws InterruptedException {
		searchProducts();
		driver.close();

	}
}
