package com.facebook.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadingUtility {
	
	public Object[][] readData(String sheet) throws IOException {
		
		FileInputStream ip = new FileInputStream("D:\\Testdata.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(ip);
		
		XSSFSheet xs = wb.getSheet(sheet);
		
		int rownum = xs.getPhysicalNumberOfRows();
		
		int colnum = xs.getRow(0).getPhysicalNumberOfCells();
		
		Object arr[][] = new Object[rownum-1][colnum];
		
		for(int i=1; i<rownum; i++) {
			
			for(int j=0; j<colnum; j++){
				
				arr[i-1][j]= xs.getRow(i).getCell(j).getStringCellValue();
				
			}
			
			
		}
		return arr;
		
		
	}

}
