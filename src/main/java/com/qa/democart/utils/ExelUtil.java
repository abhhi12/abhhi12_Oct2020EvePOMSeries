package com.qa.democart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExelUtil {
	
	public static Workbook book;
	public static Sheet sheet;//these are inbult calss in apache API just like String call in Java to give the value or store the data in respective format
	
	public static String TEST_DATA_SHEET_PATH = "./src/test/resources/testdata/DemoAppTetData.xlsx";
	
	public static Object[][] getTestData(String SheetName) {
		Object data[][]=null;
		try {
			FileInputStream ip = new FileInputStream(TEST_DATA_SHEET_PATH);//this will intract with path, whic will provide the file path
			book = WorkbookFactory.create(ip);//comes from apache API//gives the entire refrence of the workboo(ie. excel sheet)
			sheet=book.getSheet(SheetName);//.getsheet fill fetch the desired sheet from workbook
		//its giving sheet class object here(means ye sheet class ka object hai so sheet name ka class banana hoga.
		
			data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i=0; i<sheet.getLastRowNum(); i++) {
				for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				}
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

}
