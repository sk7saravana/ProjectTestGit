package com.xlsheet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class CreateSheet {

	public static void main(String[] args) throws IOException {
		File file = new File("D:\\MY FILES\\helo.xlsx");
		
		//boolean createNewFile = file.createNewFile();
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet createSheet = workbook.createSheet("Sheet1");
		Row createRow = createSheet.createRow(0);
		Cell cell = createRow.createCell(0);
		cell.setCellValue("Newsheet");
		FileOutputStream stream = new FileOutputStream(file);
		workbook.write(stream);
	}

}
