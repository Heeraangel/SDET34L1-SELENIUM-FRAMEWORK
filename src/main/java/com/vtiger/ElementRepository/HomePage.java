package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericLibrary.WebDriverLibrary;

public class HomePage {
	@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreDropDown;
	
	@FindBy(xpath="//a[@name='Campaigns']")
	private WebElement campaignTab;

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administator;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutLink;
	
	@FindBy(linkText="Products")
	private WebElement productTab;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactTab;
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement organizationTab;

	@FindBy(xpath="//a[text()='Documents']")
	private WebElement documentTab;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void openDocument()
	{
		documentTab.click();
	}
	public void clickProduct()
	{
		productTab.click();
	}
	/**
	 * This method is used to open the organization module
	 * @param driver
	 */
	public void openOrganization(WebDriver driver)
	{
		organizationTab.click();
	}
	/**
	 * This method is used to click on campaign module
	 */
	public void clickCampagin(WebDriver driver)
	{
		WebDriverLibrary.initilizeActions(driver);
		WebDriverLibrary.mouseHoverOnTheElement(moreDropDown);
		campaignTab.click();
	}
	/**
	 * This method is used to logout from application
	 * @param driver 
	 */
	public void signOutAction(WebDriver driver)
	{
		WebDriverLibrary.initilizeActions(driver);
		WebDriverLibrary.mouseHoverOnTheElement(administator);

		signOutLink.click();
	}
	/**
	 * This method is used to open contact module
	 */
	public void clickConatct()
	{
		contactTab.click();
	}
}
