package com.datadriven.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead_Array {
	
	public String[][] readexcell() throws IOException
	{
File f = new File("C:\\neworkspace\\DataDrivenn_Sep\\src\\test\\java\\resource\\Testdata.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rowcount = sheet.getLastRowNum();
		
		System.out.println(rowcount);
		
		int colcount = sheet.getRow(0).getLastCellNum();
		
		System.out.println(colcount);
		
		String data[][] = new String[rowcount][colcount];
		
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				XSSFCell cell = sheet.getRow(i).getCell(j);
				cell.setCellType(CellType.STRING);
				
		data[i-1][j] =		cell.getStringCellValue();
		System.out.println(data[i-1][j]);
			}
		}
	System.out.println("before return statement");
	return data;
		
	}

}
