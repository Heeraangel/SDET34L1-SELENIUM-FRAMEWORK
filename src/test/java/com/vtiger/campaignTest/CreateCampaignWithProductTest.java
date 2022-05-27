package com.vtiger.campaignTest;

import org.testng.annotations.Test;
import com.sdet34l1.genericLibrary.BaseClass;
import com.vtiger.ElementRepository.CampaginPage;
import com.vtiger.ElementRepository.CreateNewCampaginPage;
import com.vtiger.ElementRepository.CreateNewProductPage;
import com.vtiger.ElementRepository.ProductPage;

public class CreateCampaignWithProductTest extends BaseClass{

	/**
	 * This method is used to create new campaign with product
	 */
	@Test(groups="regression")
	public void createCampaignWithProductTest(){
		ProductPage productpage=new ProductPage(driver);
		CreateNewProductPage createnewproductpage=new CreateNewProductPage(driver);
		CreateNewCampaginPage createnewcampaginpage=new CreateNewCampaginPage(driver);
		CampaginPage campaginpage=new CampaginPage(driver);
		String campaign_name=excelLibrary.getDataFromExcel("Contact", 6, 4)+randomNumber;
		String product_name=excelLibrary.getDataFromExcel("Contact", 6, 5)+randomNumber;
		homepage.clickProduct();
		productpage.clickCreateProduct();
		createnewproductpage.createNewProduct(product_name);
		homepage.clickCampagin(driver, webDriverLibrary);
		campaginpage.clickCreateCampaign();
		createnewcampaginpage.createCampaignWithProduct(product_name, campaign_name, driver,longTimeOut); 
		javalibrary.tCStatus();
	}
}
