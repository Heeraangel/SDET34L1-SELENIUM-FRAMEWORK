package com.vtiger.contactTest;

import org.testng.annotations.Test;
import com.vtiger.ElementRepository.ContactInformationPage;
import com.vtiger.ElementRepository.ContactPage;
import com.vtiger.ElementRepository.CreateNewContactPage;
import com.vtiger.genericLibrary.BaseClass;

public class EditContactTC_15Test extends BaseClass{

	@Test
	public void editContactTC_15Test(){
		ContactPage contactpage=new ContactPage(driver);
		ContactInformationPage conatctInformationpage=new ContactInformationPage(driver);
		CreateNewContactPage createnewcontactpage=new CreateNewContactPage(driver);
		homepage.clickConatct();
		contactpage.createNewContact();
		createnewcontactpage.createContact("Abc",driver);
		String actual_lastname= createnewcontactpage.editContact();
		conatctInformationpage.validation(actual_lastname);	
	}
}
