package com.hoteloginexcel;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hpsf.Date;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	WebDriver driver;

	//1. getting driver
	public void gettingDriver() {
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
	}

	//2.entering url
	public void enterUrl(String Url) {
		driver.get(Url);
	}

	//3.maximizingwindow
	public void maximizewindow() {
		driver.manage().window().maximize();
	}

	//4.sendKeys
	public void elementSendKeys(WebElement element, String data) {
		element.sendKeys(data);
	}

	//5.click
	public void elementclick(WebElement element) {
		element.click();
	}
	public void cleartext(WebElement element) {
		element.clear();
	}

	//6.get application Title
	public String getapplicationTitle() {
		String title = driver.getTitle();
		return title;
	}
	//Locators
	//7.get element By Id
	public WebElement elementById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}

	//8.get element By Name
	public WebElement elementByName(String attributevalue) {
		WebElement element = driver.findElement(By.name(attributevalue));
		return element;
	}

	//9.get element By ClassName
	public WebElement elementByClassName(String attributevalue) {
		WebElement element = driver.findElement(By.className(attributevalue));
		return element;
	}

	//10.get element By CssSelector
	public WebElement elementBySelector(String attributevalue) {
		WebElement element = driver.findElement(By.cssSelector(attributevalue));
		return element;
	}
	
	

	//11.get element By LinkText
	public WebElement elementByLinkedText(String attributevalue) {
		WebElement element = driver.findElement(By.linkText(attributevalue));
		return element;
	}

	//12.get elementBy partiallinked Text
	public WebElement elementByPartialLinkedText(String attributevalue) {
		WebElement element = driver.findElement(By.partialLinkText(attributevalue));
		return element;
	}

	//13.get element By TagName
	public WebElement elementBytagName(String attributevalue) {
		WebElement element = driver.findElement(By.tagName(attributevalue));
		return element;
	}

	//14.get element By xpath
	public WebElement elementByxpath(String attributevalue) {
		WebElement element = driver.findElement(By.xpath(attributevalue));
		return element;
	}

	//Navigation Command
	//15 navigate to url
	public void navigateto(String url) {
		driver.navigate().to(url);
	}

	//16 navigate to back
	public void navigateback() {
		driver.navigate().back();
	}

	//17.navigateforward
	public void navigateforward() {
		driver.navigate().forward();
	}

	//18.navigaterefresh
	public void navigaterefresh() {
		driver.navigate().refresh();
	}

	//19.isenabled
	public boolean elementIsEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}

	//20isDisplayed
	public boolean elementIsDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	//21.isSelected
	public boolean elementIsSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}

	//waits
	//22.wait
	public void navigateWait(int second) throws InterruptedException {
		driver.navigate().wait(second);
	}

	//close and quit
	//23.current windowclose
	public void closeCurrentWindow() {
		driver.close();
	}

	//24.allwindow close
	public void closeallWindow() {
		driver.quit();
	}

	//getText
	//25. element get Text
	public String elementGetText(WebElement element) {
		String text = element.getText();
		return text;
	}

	//26 element get attribute===========99%
	public String elementgetAttributeValue(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	//27 element get attribute===============1%
	public String elementgetAttributevalue(WebElement element,String attributeName) {
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}

	//mouseoveraction
	//28.movetoelement
	public void moveToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	//29draganddrop
	public void dragAndDrop(WebElement element1,WebElement element2) {
		Actions action = new Actions(driver);
		action.dragAndDrop(element1, element2).perform();
	}

	//30..rightclick
	public void	rightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element);
	}

	//31.doubleclick
	public void doubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element);
	}

	//32.draganddrop coordinates
	public void dragAndDropBy(WebElement element, int origin, int dest) {
		Actions action = new Actions(driver);
		action.dragAndDropBy(element, origin, dest).perform();
	}

	//alert
	//33.Alertaccept
	public void alertAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	//34.Alertdismiss
	public void alertdismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	//35.AlertsendKeys();
	public void alertSendKeys(String text) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
	}

	//36.AlertgetText
	public String alertGetText() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		return text;
	}

	//JavaScript
	//37.Js sendKeys
	public Object elementSendKeys1(WebElement element,String data) {
		JavascriptExecutor executor =(JavascriptExecutor) driver;
		Object executeScript = executor.executeScript("arguments[0].setAttribute('value','"+data+"')",element);
		return executeScript;
	}

	//38.js get attribute
	public Object jsGetAttribute(WebElement element) {
		JavascriptExecutor executor =(JavascriptExecutor) driver;
		Object executeScript = executor.executeScript("return arguments[0].getAttribute('value')",element);
		return executeScript;
	}

	//40.js click
	public Object jsClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object executeScript = executor.executeScript("arguments[0].click()", element);
		return executeScript;

	}

	//41.js scrolldown
	public  void jsScrollDown(WebElement upelement) {
		JavascriptExecutor executor =(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true)",upelement);

	}
	//42.js scrollup
	public  void elementScrollUp(WebElement downelement) {
		JavascriptExecutor executor =(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(false)",downelement);

	}

	//TakeScreenshot
	//43.Taking entire screen
	public void screenShotscreen(String location) throws IOException {
		//File file = new File(location);
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		File des = new File(location);
		FileUtils.copyFile(file, des);
	}

	//44.taking particular element
	public void screenShotElement(WebElement element,String location) throws IOException {
		File file = element.getScreenshotAs(OutputType.FILE);
		File des = new File(location);
		FileUtils.copyFile(file, des);

	}


	//Dropdown
	//45.selectbyindex
	public void ddSelectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	//46.selectbyvalue
	public void ddSelectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	//47.selectbyvisibletext
	public void ddSelectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	//48.getOptions by Index
	public void getOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			select.selectByIndex(i);
		}

	}



	//49.getcount
	public int getCount(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		int size = options.size();
		return size;
	}

	//50.isMultiple
	public boolean isMultiple(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	//51.getFirstselectedoption
	public WebElement firstSelectedOption(WebElement element) {
		Select select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		return firstSelectedOption;
	}

	//52.deselectByIndex
	public void deselectByIndex(WebElement element,int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	//53.deselectByvalue
	public void deselectByValue(WebElement element,String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}

	//54.deselectbyvisibletext
	public void deselectByVisibleText(WebElement element,String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	//55.deselectAll
	public void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	//56.dropdown equals
	public boolean dequals(WebElement element1,WebElement element2) {
		Select select = new Select(element1);
		boolean equals = select.equals(element2);
		return equals;
	}
	//57.dropdown getAllSelectedOptions
	public 	List<WebElement> dgetAllSelectedOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		return allSelectedOptions ;

	}
	//58.

	//60.


	//KeyboardAction
	//Robot class enter
	public void robotEnter(int event1, int event2) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);


	}

	//extract data from excel sheet
	public String getDataFromExcel(String sheetName, int rownums, int cellnum) throws IOException {
		String res = null;

		File file = new File("C:\\Users\\Y\\eclipse-workspace\\mavenframe\\Data\\hotelldetails.xlsx");
		FileInputStream stream =  new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet(sheetName);//data string
		Row row = sheet.getRow(rownums);
		Cell cell = row.getCell(cellnum);

		CellType type = cell.getCellType();

		switch (type) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if(DateUtil.isCellDateFormatted(cell)){
				java.util.Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
				res = dateformat.format(dateCellValue);
				
				break;
			}
			else {
				double numericCellValue = cell.getNumericCellValue();
				long num = Math.round(numericCellValue);
				if(num==numericCellValue) {
					res=String.valueOf(num);
				}
				else {
					res = String.valueOf(numericCellValue);
				}
				break;
			}
			
		default:
			break;
		}

		return res;

		                     //extract data from excel sheet
	}

	//code to insert vale in newcell
	public void writeDataExcel(String SheetName, int rowNo, int cellNo, String data) throws IOException {

		File file = new File("C:\\Users\\Y\\eclipse-workspace\\mavenframe\\Data\\hotelldetails.xlsx");
	FileInputStream stream =  new FileInputStream(file);
	Workbook workbook = new XSSFWorkbook(stream);
	org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet(SheetName);
	Row row = sheet.getRow(rowNo);
	Cell cell = row.createCell(cellNo);
	cell.setCellValue(data);
	FileOutputStream output = new FileOutputStream(file);
	workbook.write(output);
	
	}

}
