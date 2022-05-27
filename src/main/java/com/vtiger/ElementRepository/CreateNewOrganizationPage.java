package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericLibrary.JavaLibrary;
import com.sdet34l1.genericLibrary.WebDriverLibrary;

public class CreateNewOrganizationPage {
	WebDriverLibrary webDriverLibrary=new WebDriverLibrary();
	JavaLibrary javalibrary=new JavaLibrary();
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBt;
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgname;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement industry;
	
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement type;
	
	@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
	private WebElement contactTab;
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void createOrganization(String org_name, WebDriver driver, long timeout)
	{
		orgname.sendKeys(org_name);
		saveBt.click();
	}
	public void createOrganizationForContact(String org_name, WebDriver driver, long timeout)
	{
		orgname.sendKeys(org_name);
		saveBt.click();
		javalibrary.customWait(contactTab, timeout, 10);
	}
	public void createOrgWithIndustryandType(String organization_name)
	{
		orgname.sendKeys(organization_name);
		webDriverLibrary.selectDropdownByValue("Education",industry);
		webDriverLibrary.selectDropdownByValue("Press",type);
		saveBt.click();
	}
}