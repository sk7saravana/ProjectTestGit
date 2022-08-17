package com.testng;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.adacitinJunit.BaseJ;



public class TestNgWork extends BaseJ{
	static WebDriver driver;
	@BeforeSuite
	public static void launchBrowser(){
		gettingDriver();
	}
	
	@BeforeTest
	public void geturl(){
		enterUrl("https://www.google.com/");
	}

	@BeforeClass
	public static void maximize() {
		maximizewindow();
	}
	
	@Test(priority=1,groups="searchtest")
	public static void logoCheck() {
		WebElement googlelogo = elementByxpath("//img[@src='/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png']");
		boolean displayed = googlelogo.isDisplayed();
		Assert.assertEquals(true, displayed,"Google logo displayed is");
	}
	
	@Test(priority=1,groups="searchtest")
	public static void searchtextboxCheck() {
		WebElement txtsearchbox = elementByxpath("//input[@class='gLFyf gsfi']");
		elementSendKeys(txtsearchbox, "Iphone13");
		String elementgetAttributeValue = elementgetAttributeValue(txtsearchbox);
		Assert.assertEquals("Search is succesfull", elementgetAttributeValue, "Iphone13");
	}
}
