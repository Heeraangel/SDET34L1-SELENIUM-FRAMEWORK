package com.vtiger.contactTest;

import org.testng.annotations.Test;
import com.sdet34l1.genericLibrary.BaseClass;  
import com.vtiger.ElementRepository.ContactInformationPage;
import com.vtiger.ElementRepository.ContactPage;
import com.vtiger.ElementRepository.CreateNewContactPage;

public class CreateContactTest extends BaseClass{

	/**
	 * This method is used to create a contact
	 */
	@Test(groups={"regression","sanity"})
	public void createContactTest(){
		String last_name=excelLibrary.getDataFromExcel("Contact", 2, 4)+randomNumber;
		ContactPage contactpage=new ContactPage(driver);
		CreateNewContactPage createnewcontactpage=new CreateNewContactPage(driver);
		ContactInformationPage contactinformationpage=new ContactInformationPage(driver);
		homepage.clickConatct();
		contactpage.createNewContact();
		createnewcontactpage.createContact(last_name);
		String expname=contactinformationpage.getLastName();
		javalibrary.assertionUsingEquals(last_name, expname);
		javalibrary.tCStatus();
	}
}
