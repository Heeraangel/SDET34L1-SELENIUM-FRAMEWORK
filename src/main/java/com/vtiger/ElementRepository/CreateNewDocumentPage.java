package com.vtiger.ElementRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericLibrary.WebDriverLibrary;

public class CreateNewDocumentPage {
	WebDriverLibrary webDriverLibrary=new WebDriverLibrary();
	@FindBy(xpath="//input[@name='notes_title']")
	private WebElement titleTxt;
	
	@FindBy(xpath="//iframe[@title='Rich text editor, notecontent, press ALT 0 for help.']")
	private WebElement frame;
	
	@FindBy(xpath="//body[@class='cke_show_borders']")
	private WebElement descriptions;
	
	
	@FindBy(xpath="//a[@id='cke_5']")
	private WebElement bold;
	
	@FindBy(xpath="//a[@id='cke_6']")
	private WebElement italic;
	
	@FindBy(xpath="//input[@name='filename']")
	private WebElement file;
	
	@FindBy(xpath="//b[.='File Information']/../../following-sibling::tr[4]//input[@title='Save [Alt+S]']")
	private WebElement saveBt;
	
	public CreateNewDocumentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void createDocument(WebDriver driver,String title, String description, String path) {
		titleTxt.sendKeys(title);
		webDriverLibrary.switchToFrame(frame, driver);
		descriptions.sendKeys(description,Keys.CONTROL+"ac");
		webDriverLibrary.switchToMainFrame(driver);
		bold.click();
		italic.click();
		file.sendKeys(path);
		saveBt.click();
	}
}
