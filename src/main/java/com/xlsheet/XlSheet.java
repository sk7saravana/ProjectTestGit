package com.xlsheet;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlSheet {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Y\\eclipse-workspace\\mavenframe\\Data\\Dummies.xlsx");
		
		FileInputStream stream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(stream);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
	
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				XSSFCell cell = row.getCell(j);
				System.out.println(cell);
				
			}
		}
	}

}
