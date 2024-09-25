package com.datadriven.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead extends BaseClass{
	
	
	public static void readexcel() throws IOException
	{
		File f = new File("C:\\neworkspace\\DataDrivenn_Sep\\src\\test\\java\\resource\\Testdata.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rowcount = sheet.getLastRowNum()+1;
		
		System.out.println(rowcount);
		
		int colcount = sheet.getRow(0).getLastCellNum();
		
		System.out.println(colcount);
	
		
		for(int i=0;i<colcount;i++)
		{
			map.put(format.formatCellValue(sheet.getRow(0).getCell(i)), format.formatCellValue(sheet.getRow(1).getCell(i)));
		}
		
		System.out.println(map);
		
		
	}

	
	public String quantityy(String key) throws IOException
	{
		readexcel();
		return map.get(key);
	}
}
