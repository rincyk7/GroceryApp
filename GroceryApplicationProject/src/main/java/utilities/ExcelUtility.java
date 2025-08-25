package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constant;

public class ExcelUtility {
	static FileInputStream fileinput;
	static XSSFWorkbook workbook;
	static XSSFSheet xsheet;
	
	public static String getStringData(int a,int b,String sheet) throws IOException {
		fileinput =new FileInputStream(Constant.EXCELDATA);
		workbook = new XSSFWorkbook(fileinput);
		xsheet = workbook.getSheet(sheet);
		XSSFRow r = xsheet.getRow(a);
		XSSFCell c = r.getCell(b);
		return c.getStringCellValue();
		
	}
	public static String getIntegerData(int a,int b,String sheet) throws IOException  
	{
		fileinput=new FileInputStream(Constant.EXCELDATA);
		workbook=new XSSFWorkbook(fileinput);  
		xsheet=workbook.getSheet(sheet);
		XSSFRow r=xsheet.getRow(a);
		XSSFCell c=r.getCell(b);
		int y = (int) c.getNumericCellValue();
		return String.valueOf(y);
	}

}
