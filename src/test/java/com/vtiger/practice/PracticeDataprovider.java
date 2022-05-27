package com.vtiger.practice;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.sdet34l1.genericLibrary.ExcelLibrary;
import com.sdet34l1.genericLibrary.IConstantPath;

public class PracticeDataprovider {
	ExcelLibrary excelLibrary=new ExcelLibrary();
	@Test(dataProvider="fetchMultipleData")
	public void practiceTest(String uname, String pwd)
	{
		Reporter.log(uname+" -> "+pwd,true);
	}
	@DataProvider
	public Object[][] loginData()
	{
		Object[][] data=new Object[5][2];
		data[0][0]="uname";
		data[0][1]="pwd";
		data[1][0]="uname1";
		data[1][1]="pwd1";
		data[2][0]="uname2";
		data[2][1]="pwd2";
		data[3][0]="uname3";
		data[3][1]="pwd3";
		data[4][0]="uname4";
		data[4][1]="pwd4";
		return data;
	}
	/**
	 * it is used to fetch multiple data from excel
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	@DataProvider
	public Object[][] fetchMultipleData() throws EncryptedDocumentException, IOException
	{
		excelLibrary.openExcel(IConstantPath.EXCELPATH);
		Object[][] arr=excelLibrary.getMultipleDataFromExcel("MultipleData");
		return arr;	
	}
}
