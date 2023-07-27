package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import TestBase.Base;

public class ReadExcelData extends Base {

	@DataProvider(name= "XLSheet")
	public String[][] readXLSheet(Method method) throws Exception {
//		Taking method name as a sheet name
		String excelSheetName = method.getName();
		File file = new File(System.getProperty("user.dir")+"\\TestData_From_Excel\\TestData.xlsx");
		FileInputStream fistream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fistream);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);
		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfcolums = sheet.getRow(0).getLastCellNum();
		String [][] data = new String[noOfRows-1][noOfcolums];
		for (int i = 0; i < noOfRows-1; i++) {
			for (int j = 0; j < noOfcolums; j++) {
				DataFormatter dataformatter = new DataFormatter();
				data[i][j] =dataformatter.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
			
		}
			workbook.close();
			fistream.close();
				
		return data;	
				
	}


}
