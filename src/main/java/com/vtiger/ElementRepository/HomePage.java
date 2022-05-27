package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sdet34l1.genericLibrary.WebDriverLibrary;

public class HomePage {
	WebDriverLibrary webDriverLibrary=new WebDriverLibrary();
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
	
	@FindBy(xpath="//a[.='Contacts']")
	private WebElement contactTab;
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement organizationTab;

	@FindBy(xpath="//a[text()='Documents']")
	private WebElement documentTab;
	
	@FindAll({@FindBy(xpath="//a[text()='Contacts' and @href='index.php?module=Contacts&action=index']"),@FindBy(xpath="//a[.='Contacts']")})
	private WebElement contactImg;
	
	
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
	public void clickContactImg()
	{
		contactImg.click();
	}
	public void waitUntilClickContactImageVisible(WebDriver driver)
	{
		webDriverLibrary.explicitWaitUsingVisibility(driver, 10, contactTab);
	}
	/**
	 * This method is used to open the organization module
	 * @param driver
	 */
	public void openOrganization()
	{
		organizationTab.click();
	}
	/**
	 * This method is used to click on campaign module
	 */
	public void clickCampagin(WebDriver driver,WebDriverLibrary webdriverlibrary)
	{
		webdriverlibrary.mouseHoverOnTheElement(moreDropDown);
		campaignTab.click();
	}
	/**
	 * This method is used to logout from application
	 * @param driver 
	 * @throws InterruptedException 
	 */
	public void signOutAction(WebDriver driver,WebDriverLibrary webdriverlibrary) throws InterruptedException
	{
		webDriverLibrary.explicitWaitUsingVisibility(driver, 10, administator);
		Thread.sleep(2000);
		webdriverlibrary.mouseHoverOnTheElement(administator);
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
