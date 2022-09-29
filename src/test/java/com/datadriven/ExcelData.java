 package com.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelData {
	@DataProvider(name="loginData")
	public  String[][] logindata() throws Exception {
	File f =new File("C:\\Users\\arulv\\OneDrive\\Documents\\testdata.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook workbook =new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfColumn = sheet.getRow(0).getLastCellNum();
		String[][] data=new String[noOfRows-1][noOfColumn];
		for(int i=0;i<noOfRows-1;i++) {
			for(int j=0;j<noOfColumn;j++) {
				DataFormatter df=new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
	
			
		}return data;
	}}
		//for(String[]dataArr:data) {
		//	System.out.println(Arrays.toString(dataArr));
		//}
	
	


