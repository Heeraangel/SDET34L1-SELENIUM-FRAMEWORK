package com.vtiger.ElementRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(name="user_name")
	private WebElement userNameTxt;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * This method is used for Login to the application
	 * @param username
	 * @param password
	 */
	public void loginAction(String username,String password)
	{
		userNameTxt.sendKeys(username,Keys.TAB,password,Keys.ENTER);
	}
}
