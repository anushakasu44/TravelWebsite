package com.app.qa.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class MyData {
	


	public static String [][] getDataFromExcel() throws Exception{
		
FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\app\\qa\\data\\CustomerData.xlsx");
		XSSFWorkbook excel=new XSSFWorkbook(fis);
		XSSFSheet sheet=excel.getSheetAt(0);
		String array[][]=new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
	for(int i=1;i<=sheet.getLastRowNum();i++) {
			XSSFRow row=sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++) {
				XSSFCell cell=row.getCell(j);
			     array[i-1][j]= cell.getStringCellValue();
			     System.out.println(array[i-1][j]);
				
			}
		}
	return array;
		
		
		
		
	}


}
