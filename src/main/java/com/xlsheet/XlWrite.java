package com.xlsheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class XlWrite {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Y\\eclipse-workspace\\mavenframe\\Data\\Dummies.xlsx");
		
		FileInputStream stream = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(stream);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		XSSFRow row = sheet.getRow(10);
		XSSFCell cell = row.createCell(9);
		cell.setCellValue("Master Blaster");
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}

}
