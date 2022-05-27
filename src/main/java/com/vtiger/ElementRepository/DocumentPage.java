package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentPage {
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createDocumentImg;
	
	public DocumentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void createNewDocument()
	{
		createDocumentImg.click();
	}
}
