package com.vtiger.contactTest;

import org.testng.annotations.Test;
import com.vtiger.ElementRepository.ContactInformationPage;
import com.vtiger.ElementRepository.ContactPage;
import com.vtiger.genericLibrary.BaseClass;

public class CreateDuplicateContactTC_17Test extends BaseClass {

	@Test
	public void createDuplicateContactTC_17Test(){
		ContactPage contactpage=new ContactPage(driver);
		ContactInformationPage contactinformationpage=new ContactInformationPage(driver);
		homepage.clickConatct();
		contactpage.openInduvitualContact();
		String actual_name=contactinformationpage.dupicateConatct();
		contactinformationpage.validation(actual_name);
	}
}
