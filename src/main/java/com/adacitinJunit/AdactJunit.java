package com.adacitinJunit;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdactJunit {
	static WebDriver driver;
	@BeforeClass
	public static void getdriver() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	@Test
	public void test() {
		driver.get("http://adactinhotelapp.com/");
		driver.findElement(By.id("username")).sendKeys("Greens8767");
		driver.findElement(By.id("password")).sendKeys("QN8V3A");
		driver.findElement(By.name("login")).click();
		
		
	}
	@After
	public void waittime() throws InterruptedException {
		Thread.sleep(2000);
	}
	@AfterClass
	public static void quit() {
		driver.quit();
	}
	
	@Test
	private void simmanMethod() {
		System.out.println("Hi g  ");
	}
	
}
