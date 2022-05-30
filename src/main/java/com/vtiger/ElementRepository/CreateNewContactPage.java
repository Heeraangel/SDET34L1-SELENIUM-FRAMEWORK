package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
<<<<<<< HEAD
import com.vtiger.genericLibrary.ExcelLibrary;
import com.vtiger.genericLibrary.WebDriverLibrary;

public class CreateNewContactPage {
	
	@FindBy(xpath="//input[@name='lastname']")
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
	
	@FindBy(xpath="//input[@title='Edit [Alt+E]']")
	private WebElement editBt;
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void createContact(String last_name, WebDriver driver)
	{
		lastnameTxt.sendKeys(last_name);
		ExcelLibrary.setDatatoExcel("Contact", 7, 17, last_name);
		saveBt.click();
		WebDriverLibrary.explicitWaitUsingVisibility(driver, 10, editBt);
	}
	public String editContact()
	{
		editBt.click();
		lastnameTxt.sendKeys(ExcelLibrary.getDataFromExcel("Contact", 9, 4));
		String actual_lastname=lastnameTxt.getText();
		saveBt.click();
		return actual_lastname;
	}
	public void createConatctWithOrg(String lastName, WebDriver driver, String org_name) throws InterruptedException
	{
		lastnameTxt.sendKeys(lastName);
		clickOrganiozation.click();
		WebDriverLibrary.switchToWindowBasedOnTitle(driver,"Organization");
		searchOrganization.sendKeys(org_name);
		searchBt.click();
		Thread.sleep(4000);
		orgNameLink.click();
		WebDriverLibrary.switchToWindowBasedOnTitle(driver,"Contact");
=======
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
>>>>>>> branch 'master' of https://github.com/Heeraangel/SDET34L1-SELENIUM-FRAMEWORK.git
		saveBt.click();
	}
}
