package com.vtiger.practice;

import org.testng.annotations.Test;
import com.vtiger.ElementRepository.ContactInformationPage;
import com.vtiger.ElementRepository.ContactPage;
import com.vtiger.ElementRepository.CreateNewContactPage;
import com.vtiger.ElementRepository.CreateNewOrganizationPage;
import com.vtiger.ElementRepository.OrganizationPage;

public class PracticeMethodPETest extends BaseClassPractice {
	String org_name=excelLibrary.getDataFromExcel("Contact", 5, 4)+randomNumber;
	String last_name=excelLibrary.getDataFromExcel("Contact", 5, 5)+randomNumber;
	ContactPage contactpage=new ContactPage(driver);
	CreateNewContactPage createnewcontactpage=new CreateNewContactPage(driver);
	ContactInformationPage contactinformationpage=new ContactInformationPage(driver);
	OrganizationPage organizationpage=new OrganizationPage(driver);
	CreateNewOrganizationPage createneworganizationpage=new CreateNewOrganizationPage(driver);
	@Test
	public void createOrgTest()
	{
		homepage.openOrganization();
		organizationpage.clickCreateOrg();
		createneworganizationpage.createOrganizationForContact(org_name,driver,longTimeOut);
	}
	@Test
	public void createContactWithOrgTest()
	{
		homepage.clickContactImg();
		contactpage.createNewContact();
		try {
			createnewcontactpage.createConatctWithOrg(last_name, driver, org_name,longTimeOut);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}