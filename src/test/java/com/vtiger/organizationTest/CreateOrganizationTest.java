package com.vtiger.organizationTest;

import org.testng.annotations.Test;
import com.sdet34l1.genericLibrary.BaseClass;
import com.vtiger.ElementRepository.CreateNewOrganizationPage;
import com.vtiger.ElementRepository.OrganizationInformationPage;
import com.vtiger.ElementRepository.OrganizationPage;

public class CreateOrganizationTest extends BaseClass {
	/**
	 * This method is used to create a organization
	 */
	@Test(groups="regression")
	public void createOrganizationTest() {
		String orgname=excelLibrary.getDataFromExcel("Organization", 2, 4)+randomNumber;
		OrganizationPage organizationpage=new OrganizationPage(driver);
		CreateNewOrganizationPage createneworganizationpage=new CreateNewOrganizationPage(driver);
		OrganizationInformationPage organizationinformationpage=new OrganizationInformationPage(driver);
		homepage.openOrganization();
		organizationpage.clickCreateOrg();
		createneworganizationpage.createOrganization(orgname,driver,longTimeOut);
		String expname=organizationinformationpage.getOrgName();
		javalibrary.assertionUsingEquals(orgname, expname);
		javalibrary.tCStatus();
		}
}