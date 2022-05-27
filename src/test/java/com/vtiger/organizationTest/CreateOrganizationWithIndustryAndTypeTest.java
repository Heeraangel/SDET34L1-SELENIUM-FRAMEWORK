package com.vtiger.organizationTest;

import org.testng.annotations.Test;
import com.sdet34l1.genericLibrary.BaseClass;
import com.vtiger.ElementRepository.CreateNewOrganizationPage;
import com.vtiger.ElementRepository.OrganizationInformationPage;
import com.vtiger.ElementRepository.OrganizationPage;

public class CreateOrganizationWithIndustryAndTypeTest extends BaseClass {
/**
 * This method is used to create an organization with industry and type dropdown
 */
	@Test(groups="sanity")
	public void createOrganizationWithIndustryAndTypeTest() {
		String organization_name=excelLibrary.getDataFromExcel("Organization", 4, 4)+randomNumber;
		CreateNewOrganizationPage createneworganizationpage=new CreateNewOrganizationPage(driver);
		OrganizationPage organizationpage=new OrganizationPage(driver);
		OrganizationInformationPage organizationinformationpage=new OrganizationInformationPage(driver);
		homepage.openOrganization();
		organizationpage.clickCreateOrg();
		createneworganizationpage.createOrgWithIndustryandType(organization_name);
		String exp_orgname=organizationinformationpage.getOrgName();
		javalibrary.assertionUsingEquals(organization_name, exp_orgname);
		javalibrary.tCStatus();
	}
}
