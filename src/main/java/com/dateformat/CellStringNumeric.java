package com.dateformat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CellStringNumeric {

	public static void main(String[] args) throws IOException {
File file = new File("C:\\Users\\Y\\eclipse-workspace\\mavenframe\\Data\\Dummies.xlsx");
		
		FileInputStream stream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(stream);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		Date date = new Date();
		System.out.println(date);
	
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				//System.out.println(cell);
				
				CellType type = cell.getCellType();
				
				switch(type) {
				
				case STRING:
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);
					break;
					
				case NUMERIC:
//					double d = cell.getNumericCellValue();
//					BigDecimal b = BigDecimal.valueOf(d);
//					String string = b.toString();
//					System.out.println(string);
					
					if(DateUtil.isCellDateFormatted(cell)) {
						Date datevalue = cell.getDateCellValue();
						SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
						String format = sd.format(datevalue);
						System.out.println(format);
					}
					else {
						double dd = cell.getNumericCellValue();
						BigDecimal valueOf = BigDecimal.valueOf(dd);
						String string2 = valueOf.toString();
						System.out.println(string2);
					}
				default:
					break;
				}
				
			}
		}
		
		

	}

}
