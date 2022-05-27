package com.vtiger.campaignTest;

import org.testng.annotations.Test;
import com.sdet34l1.genericLibrary.BaseClass;
import com.vtiger.ElementRepository.CampaginPage;
import com.vtiger.ElementRepository.CreateNewCampaginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class CreateCampaignTest extends BaseClass{

	/**
	 * This method is used to create a new campaign
	 */
	@Test(groups="sanity")
	@Description("Description:-CreateCampaignTest")
	@Epic("Epic:-CreateCampaignTest")
	@Story("Story:-CreateCampaignTest")
	@Step("Step=CreateCampaignTest")
	@Severity(SeverityLevel.BLOCKER)
	public void createCampaignTest(){
		CampaginPage campaginpage=new CampaginPage(driver);
		CreateNewCampaginPage createnewcampaginpage=new CreateNewCampaginPage(driver);
		String campaign_name=excelLibrary.getDataFromExcel("Campaign", 2, 4)+randomNumber;
		homepage.clickCampagin(driver, webDriverLibrary);
		campaginpage.clickCreateCampaign();
		createnewcampaginpage.createCampagin(campaign_name);
		javalibrary.tCStatus();
	}
}