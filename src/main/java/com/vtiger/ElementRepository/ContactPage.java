package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
<<<<<<< HEAD
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactImg;
	
	@FindBy(xpath="//a[text()='www']")
	private WebElement contactLink;
	
	@FindBy(xpath="//img[@title='Last Viewed']")
	private WebElement lastViewedDropDown;
	
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void createNewContact()
	{
		createContactImg.click();
	}
	public void openInduvitualContact()
	{
		contactLink.click();
	}
	public void lastViewed()
	{
		lastViewedDropDown.click();
	}
=======
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createContactImg;
	
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void createNewContact()
	{
		createContactImg.click();
	}

>>>>>>> branch 'master' of https://github.com/Heeraangel/SDET34L1-SELENIUM-FRAMEWORK.git
}
