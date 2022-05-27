package com.vtiger.practice;

import java.io.IOException;
import org.testng.annotations.Test;
import com.sdet34l1.genericLibrary.BaseClass;
import com.sdet34l1.genericLibrary.IConstantPath;
import com.vtiger.ElementRepository.ContactInformationPage;
import com.vtiger.ElementRepository.ContactPage;
import com.vtiger.ElementRepository.CreateNewContactPage;

public class PracticeBaseClass extends BaseClass{
	@Test
	public void createContactTest() {
		String last_name=excelLibrary.getDataFromExcel("Contact", 2, 4)+randomNumber;
		ContactPage contactpage=new ContactPage(driver);
		CreateNewContactPage createnewcontactpage=new CreateNewContactPage(driver);
		ContactInformationPage contactinformationpage=new ContactInformationPage(driver);
		homepage.clickConatct();
		contactpage.createNewContact();
		createnewcontactpage.createContact(last_name);
		String expname=contactinformationpage.getLastName();
		if(last_name.equals(expname))
			javalibrary.printStatement("Contact Created Successfully");
		else
			javalibrary.printStatement("Contact Creation Failed");
		try {
			excelLibrary.writeDatatoExcel(IConstantPath.EXCELPATH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
