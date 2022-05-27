package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleDataTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("./src/test/resources/testData.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet=book.getSheet("MultipleData");
		for(int i=0;i<=sheet.getLastRowNum();i++){
			for(int j=0;j<sheet.getRow(i).getLastCellNum();j++){
				System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+" ");}
			System.out.println();}
	}
}
