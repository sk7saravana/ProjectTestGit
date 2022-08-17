package com.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.WorkbookUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumMethods {
    WebDriver driver;
	public void launchBrowser(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
	}
	
	public void enterurl(String url) {
		driver.get(url);
	}
	
	public String getCurrentUrl() {
		String currenturl=driver.getCurrentUrl();
		return currenturl;
	}
	
	public String pageTittle() {
		String title = driver.getTitle();
		return title;
	}
	
	public void elementClick(WebElement element) {
		element.click();
	}
	public WebElement findElementbyid(String attributevalue) {
		WebElement element = driver.findElement(By.id(attributevalue));
		return element;
	}
	public WebElement findElementbyname(String attributevalue) {
		WebElement element = driver.findElement(By.name(attributevalue));
		return element;
	}
	public WebElement findElementbyclassname(String attributevalue) {
		WebElement element = driver.findElement(By.className(attributevalue));
		return element;
	}
	public WebElement findElementbytagname(String attributevalue) {
		WebElement element = driver.findElement(By.tagName(attributevalue));
		return element;
	}
	public WebElement findElementbyxpath(String attributevalue) {
		WebElement element = driver.findElement(By.xpath(attributevalue));
		return element;
	}
	public WebElement findElementbylinktext(String attributevalue) {
		WebElement element = driver.findElement(By.linkText(attributevalue));
		return element;
	}
	public WebElement findElementbypartiallinktext(String attributevalue) {
		WebElement element = driver.findElement(By.partialLinkText(attributevalue));
		return element;
	}
	public String gettheText(WebElement element) {
		String text = element.getText();
		return text;
	}
	public String getEnteredTextvalue(WebElement element) {
		String text = element.getAttribute("value");
		return text;
	}
	public String getEnteredText(WebElement element,String attributeName) {
		String text = element.getAttribute(attributeName);
		return text;
	}
	public String getEnteredTextvaluejs(WebElement element,String attributeName) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		Object executeScript = js.executeScript("arguments[0].getAttribute('"+attributeName+"')", element);
		String txt = executeScript.toString();
		return txt;
	}
	
	public void toEntertextboxjs(WebElement element,String attributeName, String text) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0]."+attributeName+"='"+text+"';", element);
		
	}
	public void toEntertextbox(WebElement element, String text) {
		element.sendKeys(text);
		
	}
	
	public void selectbyvisibletext(WebElement element,String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	public void selectbyindex(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public void selectbyvalue(WebElement element,String attributevalue) {
		Select select = new Select(element);
		select.selectByValue(attributevalue);
	}
	public List<WebElement> alloptionsselect(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}
	public boolean multipleselection(WebElement element) {
		Select select = new Select(element);
		boolean multipleselec = select.isMultiple();
		return multipleselec;
	}
	public void switchToalert() {
		driver.switchTo().alert();
	}
	public void acceptalert() {
		driver.switchTo().alert().accept();
	}
	public void dimissalert() {
		driver.switchTo().alert().dismiss();
	}
	public void textalertbox(String text) {
		driver.switchTo().alert().sendKeys(text);
	}
	public void switchframeid(String id) {
		driver.switchTo().frame(id);
	}
	public void switchframeelement(WebElement element) {
		driver.switchTo().frame(element);
	}
	public void switchframeid(int index) {
		driver.switchTo().frame(index);
	}
	public boolean isDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}
	public boolean isEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}
	public boolean isselected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}
	public void moveToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element);
		
	}
	public void closewindow() {
		driver.close();
	}
	public void closebrowser() {
		driver.quit();
	}
	public void toclear(WebElement element) {
		element.clear();
	}
	public void toSleep(int millisec) {
		try {
			Thread.sleep(millisec);
		} catch (InterruptedException e) {
			
		}
	}
	
	
	public void contextclick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element);
		
	}
	public void draganddrop(WebElement source,WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source,target);
		
	}
	public void doubleclick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element);
	}
	public void navigate(String url) {
		driver.navigate().to(url);
	}
	public void refresh() {
		driver.navigate().refresh();
	}
	public void backward() {
		driver.navigate().back();
	}
	public void forward() {
		driver.navigate().forward();
	}
	public void scrollupdownjs(WebElement element,String str) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView('"+str+"')", element);
		
	}
	public void filelocations(String drivelocation) {
		File file = new File(drivelocation);
	}
	public File takeScreenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	}
	public File elementScreenshot(WebElement element) {
		File screenshotAs = element.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	}
	
	public String readcellValue(String sheetname,int row, int cell,String fileloc) throws IOException {
		String res = null;
		File file = new File(fileloc);
		FileInputStream stream = new FileInputStream(file);
		
		HSSFWorkbook workbook = new HSSFWorkbook(stream);
		HSSFSheet sheet = workbook.getSheet(sheetname);
		HSSFRow row2 = sheet.getRow(row);
		HSSFCell cell2 = row2.getCell(cell);
		CellType type = cell2.getCellType();
		switch(type) {
		case NUMERIC:
			if(DateUtil.isCellDateFormatted(cell2)) {
				Date dateCellValue = cell2.getDateCellValue();
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				String format2 = format.format(dateCellValue);
				res = format2;
				
			}
			else {
				double numericCellValue = cell2.getNumericCellValue();
				BigDecimal b = BigDecimal.valueOf(numericCellValue);
				String stringnum = b.toString();
				res = stringnum;
		}
			
		case STRING:
			String stringCellValue = cell2.getStringCellValue();
			res=stringCellValue;
			
		default:
			break;
		}
		
		return res;
	}
	
	public void updatecell(String sheetname,int rowindex, int cellindex,String fileloc,String olddata,String newdata) throws IOException {
		File file = new File(fileloc);
		FileInputStream stream = new FileInputStream(file);
		
		HSSFWorkbook workbook = new HSSFWorkbook(stream);
		HSSFSheet sheet = workbook.getSheet(sheetname);
		HSSFRow row2 = sheet.getRow(rowindex);
		HSSFCell cell2 = row2.getCell(cellindex);
		String stringCellValue = cell2.getStringCellValue();
		
		if(stringCellValue.equals(olddata)) {
			cell2.setCellValue(newdata);
		}
		else {
			System.out.println("cell value dosent match");
		}
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
		
	}
	public void writecell(String sheetname,int rowindex, int cellindex,String fileloc,String newdata) throws IOException {
		File file = new File(fileloc);
		FileInputStream stream = new FileInputStream(file);
		
		HSSFWorkbook workbook = new HSSFWorkbook(stream);
		HSSFSheet sheet = workbook.getSheet(sheetname);
		HSSFRow row2 = sheet.getRow(rowindex);
		HSSFCell cell2 = row2.createCell(cellindex);
		String stringCellValue = cell2.getStringCellValue();
		cell2.setCellValue(newdata);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
		
	}
	public void pressandreleasekey(int keycode) throws AWTException {
		Robot robot = new Robot();
	   robot.keyPress(keycode);
	   robot.keyRelease(keycode);	
	}
	public void presskey(int keycode) throws AWTException {
		Robot robot = new Robot();
	   robot.keyPress(keycode);	
	}
	public void switchwindowbyid(String winid) {
		driver.switchTo().window(winid);
	}
	public void switchwindowbyurl(String url) {
		driver.switchTo().window(url);
	}
	public void switchwindowbytittle(String tittle) {
		driver.switchTo().window(tittle);	
	}
	public void implicitwait() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	
	
	
	
	
	
	
	
	
}
