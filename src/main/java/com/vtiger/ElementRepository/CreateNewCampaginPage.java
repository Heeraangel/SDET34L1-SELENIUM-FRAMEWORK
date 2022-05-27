package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericLibrary.JavaLibrary;
import com.sdet34l1.genericLibrary.WebDriverLibrary;

public class CreateNewCampaginPage {
	JavaLibrary javalibrary=new JavaLibrary();
	WebDriverLibrary webDriverLibrary=new WebDriverLibrary();
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement campaginName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBt;
	
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement searchProductName;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement addProductName;
	
	@FindBy(xpath="//input[@type='button']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//a[@href='javascript:window.close();']")
	private WebElement selectedProductLink;
	
	public CreateNewCampaginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void createCampagin(String campaignName)
	{
		campaginName.sendKeys(campaignName);
		saveBt.click();
	}
	public void createCampaignWithProduct(String productname, String campaignName, WebDriver driver, long LongTimeout)
	{
		campaginName.sendKeys(campaignName);
		addProductName.click();
		webDriverLibrary.switchToWindowBasedOnTitle(driver, "Products");
		searchProductName.sendKeys(productname);
		searchBtn.click();
		webDriverLibrary.explicitWaitUsingVisibility(driver, LongTimeout, selectedProductLink);
		selectedProductLink.click();
		webDriverLibrary.switchToWindowBasedOnTitle(driver, "Campaigns");
		saveBt.click();
	}
}
