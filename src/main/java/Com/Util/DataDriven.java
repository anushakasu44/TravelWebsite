package Com.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	
	public static String[][] getCustomerData() throws Exception {

	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\custdetails.xlsx");
	XSSFWorkbook excel=new XSSFWorkbook(fis);
	XSSFSheet sheet=excel.getSheetAt(0);
	String[][] data=new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i=1;i<=sheet.getLastRowNum();i++) {
		XSSFRow row=sheet.getRow(i);
		for(int j=0;j<row.getLastCellNum();j++) {
			XSSFCell cell=row.getCell(j);
			data[i-1][j]=cell.getStringCellValue();
			
		}
		
	
	}
	return data;

}}


