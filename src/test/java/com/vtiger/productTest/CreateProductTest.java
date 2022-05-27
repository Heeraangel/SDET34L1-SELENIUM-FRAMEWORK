package com.vtiger.productTest;

import org.testng.annotations.Test;
import com.sdet34l1.genericLibrary.BaseClass;
import com.vtiger.ElementRepository.CreateNewProductPage;
import com.vtiger.ElementRepository.ProductPage;

public class CreateProductTest extends BaseClass{

	/**
	 * This method is used to create a product
	 */
	@Test(groups={"regression","sanity"})
	public void createProductTest() {
		String product_name=excelLibrary.getDataFromExcel("Product", 0, 0)+randomNumber;
		ProductPage productpage=new ProductPage(driver);
		CreateNewProductPage createnewproductpage=new CreateNewProductPage(driver);
		homepage.clickProduct();
		productpage.clickCreateProduct();
		createnewproductpage.createNewProduct(product_name);
		javalibrary.tCStatus();
	}
}
