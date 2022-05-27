package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sdet34l1.genericLibrary.ExcelLibrary;
import com.sdet34l1.genericLibrary.WebDriverLibrary;

public class CreateNewContactPage {
	WebDriverLibrary webDriverLibrary=new WebDriverLibrary();
	ExcelLibrary excelLibrary=new ExcelLibrary();
	@FindBy(name="lastname")
	private WebElement lastnameTxt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBt;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement clickOrganiozation;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBt;
	
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement searchOrganization;
	
	@FindBy(xpath="//a[@href='javascript:window.close();']")
	private WebElement orgNameLink;
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void createContact(String last_name)
	{
		lastnameTxt.sendKeys(last_name);
		//excelLibrary.setDatatoExcel("Contact", 7, 17, last_name);
		saveBt.click();
	}
	public void createConatctWithOrg(String lastName, WebDriver driver, String org_name, long longTimeOut) throws InterruptedException
	{
		lastnameTxt.sendKeys(lastName);
		clickOrganiozation.click();
		webDriverLibrary.switchToWindowBasedOnTitle(driver,"Organization");
		searchOrganization.sendKeys(org_name);
		searchBt.click();
		Thread.sleep(2000);
		//WebDriverLibrary.explicitWaitUsingVisibility(driver, longTimeOut, orgNameLink);
		orgNameLink.click();
		webDriverLibrary.switchToWindowBasedOnTitle(driver,"Contact");
		saveBt.click();
	}
}
