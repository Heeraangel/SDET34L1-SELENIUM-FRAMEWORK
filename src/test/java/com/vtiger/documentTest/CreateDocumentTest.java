package com.vtiger.documentTest;

import org.testng.annotations.Test;
import com.sdet34l1.genericLibrary.BaseClass;
import com.vtiger.ElementRepository.CreateNewDocumentPage;
import com.vtiger.ElementRepository.DocumentInformationPage;
import com.vtiger.ElementRepository.DocumentPage;

public class CreateDocumentTest extends BaseClass {

	/**
	 * This method is used to create a document
	 */
	@Test(groups="regression")
	public void createDocumentTest() {
		String title=excelLibrary.getDataFromExcel("Documents", 2, 4)+randomNumber;
		String path=excelLibrary.getDataFromExcel("Documents", 2, 5);
		String description=excelLibrary.getDataFromExcel("Documents", 2, 6);
		DocumentPage documentpage=new DocumentPage(driver);
		CreateNewDocumentPage createnewdocumentpage=new CreateNewDocumentPage(driver);
		DocumentInformationPage documentinformationpage=new DocumentInformationPage(driver);
		homepage.openDocument();
		documentpage.createNewDocument();
		createnewdocumentpage.createDocument(driver, title, description, path);
		String exp_title=documentinformationpage.getTitle();
		javalibrary.assertionUsingEquals(title, exp_title);
		javalibrary.tCStatus();
	}
}
