package com.crm.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class excelUtility {

	 public String readDataFromExcel(String sheetName,int rowNo,int celNo) throws Throwable, IOException
	 {
		FileInputStream fi = new FileInputStream(IpathConstants.Excelpath) ;
		Workbook wb=WorkbookFactory.create(fi);
		String value = wb.getSheet(sheetName).getRow(rowNo).getCell(celNo).getStringCellValue();
		return value;
	
	 }
	 public void writeDataIntoExcel(String sheetName,int rowNo,int celNo,String data) throws Throwable, IOException
	 {
		 FileInputStream fi = new FileInputStream(IpathConstants.Excelpath) ;
			Workbook wb=WorkbookFactory.create(fi);
			 wb.getSheet(sheetName).createRow(rowNo).createCell(celNo).setCellValue(data);
	
			 FileOutputStream fos = new FileOutputStream(IpathConstants.Excelpath);
		     wb.write(fos);
			 wb.close();
	 }
	 
	 public int getLastRowNo(String sheetName) throws Throwable, IOException
	 {
		 FileInputStream fi = new FileInputStream(IpathConstants.Excelpath) ;
			Workbook wb=WorkbookFactory.create(fi);
			Sheet sh = wb.getSheet(sheetName);
			int count=sh.getLastRowNum();
			return count;
	 }
	 public HashMap<String, String> getMultipleDataFromExcel(String sheetName,int keycolumn,int valuecolumn,WebDriver driver) throws Throwable
	 {
		 FileInputStream fi = new FileInputStream(IpathConstants.Excelpath) ;
			Workbook wb=WorkbookFactory.create(fi);
			Sheet sh = wb.getSheet(sheetName);
			int count=sh.getLastRowNum();
			
			HashMap<String, String> map = new HashMap< String,String>();
		 
			
			//JavaUtility jLib = new JavaUtility();
			for(int i=0;i<=count;i++)
			{
				String key = sh.getRow(i).getCell(keycolumn).getStringCellValue();
				String value = sh.getRow(i).getCell(valuecolumn).getStringCellValue();
			     map.put(key, value);
			}
			
			for(Entry<String, String> set:map.entrySet())
			{
			//	driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+jLib.getRandomNo());
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			}
			
		 return map;
	 }
		 
		 
		 public HashMap<String, String> getMultipleDataFromExcelWithoutRandom(String sheetName,int keycolumn,int valuecolumn) throws Throwable
		 {
			 FileInputStream fi = new FileInputStream(IpathConstants.Excelpath) ;
				Workbook wb=WorkbookFactory.create(fi);
				Sheet sh = wb.getSheet(sheetName);
				int count=sh.getLastRowNum();
				
				HashMap<String, String> map = new HashMap< String,String>();
			 
				for(int i=0;i<=count;i++)
				{
					String key = sh.getRow(i).getCell(keycolumn).getStringCellValue();
					String value = sh.getRow(i).getCell(valuecolumn).getStringCellValue();
				     map.put(key, value);
				}
				
				 return map;
		     }
	  public Object[][] DataProviderMultiplesetOfData(String Sheetname) throws Throwable
	  {
			FileInputStream fis = new FileInputStream(IpathConstants.Excelpath);
		       Workbook book = WorkbookFactory.create(fis);
		       Sheet sh=book.getSheet(Sheetname);
		       int LastRow=sh.getLastRowNum()+1;
		       int LastCell=sh.getRow(0).getLastCellNum();
		       
		       Object[][] obj=new Object[LastRow][LastCell];
		       for (int i = 0; i <LastRow ; i++) 
		       {
				for (int j = 0; j < LastCell; j++) 
				{
				 obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();	
				}
			}
		    	return obj;	
		       
		       
		       
	  }

}
