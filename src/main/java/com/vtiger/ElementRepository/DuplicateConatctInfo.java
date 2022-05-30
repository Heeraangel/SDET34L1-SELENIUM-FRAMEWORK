package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DuplicateConatctInfo {

	@FindBy(id="//input[@title='Save [Alt+S]']")
	private WebElement saveBt;
	
	public DuplicateConatctInfo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void saveDuplicateContact()
	{
		saveBt.click();
	}
}
