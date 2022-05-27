package com.vtiger.practice;

import org.testng.annotations.Test;
import com.sdet34l1.genericLibrary.BaseClass;
import com.vtiger.ElementRepository.ContactInformationPage;
import com.vtiger.ElementRepository.ContactPage;
import com.vtiger.ElementRepository.CreateNewContactPage;
import com.vtiger.ElementRepository.CreateNewOrganizationPage;
import com.vtiger.ElementRepository.OrganizationPage;

	public class CreateContactWithOrg extends BaseClass {

		/**
		 * This method is used to create contact with organization
		 * @throws InterruptedException
		 */
		@Test
		public void createContactWithOrganizationTest() {
			// TODO Auto-generated method stub
			
			String org_name=excelLibrary.getDataFromExcel("Contact", 5, 4)+randomNumber;
			String last_name=excelLibrary.getDataFromExcel("Contact", 5, 5)+randomNumber;
			ContactPage contactpage=new ContactPage(driver);
			OrganizationPage organizationpage=new OrganizationPage(driver);
			CreateNewOrganizationPage createneworganizationpage=new CreateNewOrganizationPage(driver);
			CreateNewContactPage newcontact=new CreateNewContactPage(driver);
			ContactInformationPage contactinformationpage=new ContactInformationPage(driver);
			homepage.openOrganization();
			organizationpage.clickCreateOrg();
			createneworganizationpage.createOrganization(org_name, driver, longTimeOut);
			
			homepage.clickConatct();
			contactpage.createNewContact();
			try {
				newcontact.createConatctWithOrg(last_name, driver, org_name, longTimeOut);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String exp_orgname=contactinformationpage.getOrgName();
			javalibrary.assertionUsingEquals(org_name, exp_orgname);
			javalibrary.tCStatus();
		}
}
