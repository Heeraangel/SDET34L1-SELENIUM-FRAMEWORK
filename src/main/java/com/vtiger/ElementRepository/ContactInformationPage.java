package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	@FindBy(xpath="//span[@id='dtlview_Last Name']")
	private WebElement exp_lastname;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement exporgName;
	
	public ContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public String getLastName()
	{
		return exp_lastname.getText();
	}
	public String getOrgName()
	{
		return exporgName.getText();
	}
}
