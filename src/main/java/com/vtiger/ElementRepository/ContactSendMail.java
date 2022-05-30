package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.vtiger.genericLibrary.WebDriverLibrary;

public class ContactSendMail {
	@FindBy(xpath="//a[@href='index.php?module=Contacts&parenttab=Marketing&action=DetailView&record=185' and text()='www']")
	private WebElement openConatct;
	
	@FindBy(xpath="//span[@id='dtlview_Email']/a")
	private WebElement clickMail;

	@FindBy(xpath="//input[@name='Send' and @value=' Send ']")
	private WebElement send;
	
	public ContactSendMail(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void sendMail(WebDriver driver)
	{
		openConatct.click();
		clickMail.click();
		WebDriverLibrary.switchToWindowBasedOnTitle(driver, "Emails");
		send.click();
		WebDriverLibrary.initilizeAlert(driver);
		WebDriverLibrary.dissmisAlert();
		driver.close();
		WebDriverLibrary.switchToWindowBasedOnTitle(driver,"Contacts");

	}
	public void openMail(WebDriver driver)
	{
		openConatct.click();
		clickMail.click();
		WebDriverLibrary.switchToWindowBasedOnTitle(driver, "Emails");
		driver.close();
		WebDriverLibrary.switchToWindowBasedOnTitle(driver,"Contacts");
	}
}
