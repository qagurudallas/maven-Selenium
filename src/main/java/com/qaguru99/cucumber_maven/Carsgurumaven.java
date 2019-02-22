package com.qaguru99.cucumber_maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Carsgurumaven {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\seleniumdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.cargurus.com");
	}

	@Test(priority=1)
	public void verifypageTitle() {
		
		String actualTitle = driver.getTitle();
		//Assert.assertEquals(actualTitle, "Used Cars, New Cars, Reviews, Photos and Opinions - CarGurus");
		Assert.assertTrue(actualTitle.contains("Used Cars, New Cars"));
		
	}

	@Test(priority=2, enabled=false)
	public void verifyPageTitleAfterSearchByZipcode() {
		WebElement tab3 = driver.findElement(By.id("heroSearch-tab-2"));
		tab3.click();
		driver.findElement(By.id("dealFinderZipCPOId")).sendKeys("75006");
		driver.findElement(By.id("dealFinderFormCPO_0")).click();
		
		String actualTitle = driver.getTitle();
		Assert.assertTrue(actualTitle.contains("Carrollton, TX"));
	}
	
	@Test(priority=2)
	public void verifyPageTitleAfterSearchByZipcode1() {
		WebElement tab3 = driver.findElement(By.cssSelector("[data-condition-selector-value='CPOCar']"));
		tab3.click();
		driver.findElement(By.id("dealFinderZipCPOId")).sendKeys("75006");
		driver.findElement(By.id("dealFinderFormCPO_0")).click();
		
		String actualTitle = driver.getTitle();
		Assert.assertTrue(actualTitle.contains("Carrollton, TX"));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		
	}
}
