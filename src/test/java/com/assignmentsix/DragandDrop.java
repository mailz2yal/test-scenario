package com.assignmentsix;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

@Test
public class DragandDrop {
	WebDriver driver;

	@BeforeTest
	public void openBrowser() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.navigate().to("https://jqueryui.com/droppable/webpage");
	}

	@Test
	public void handleFrame() {
		driver.findElement(By.xpath("//*[@id=\"menu-top\"]/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul[1]/li[2]/a")).click();
		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).build().perform();
		String targetcol = target.getCssValue("color");
		System.out.println(targetcol);
		String sourcecol = source.getCssValue("color");
		System.out.println(sourcecol);
		Assert.assertNotSame(sourcecol, targetcol);
		String aftertext = target.getText();
		System.out.println(" after text : " + aftertext);
		String beforetext = source.getText();
		System.out.println("before text : " + beforetext);
		Assert.assertNotSame(aftertext, beforetext);
		System.out.println("the text is different");
	}

	@AfterTest
	public void closeWindow() {

		driver.quit();
	}

}
