package com.vtiger.ElementRepository;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericLibrary.JavaLibrary;


public class ContactInformationPage {
	@FindBy(xpath="//span[@id='dtlview_Last Name']")
	private WebElement exp_lastname;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement exporgName;
	
	@FindBy(xpath="//input[@title='Duplicate [Alt+U]']")
	private WebElement duplicateBt;
	
	@FindBy(xpath="//td[@class='tabSelected']/a")
	private WebElement contactLink;
	
	@FindBy(xpath="//a[@title='Contacts']")
	private List<WebElement> contactList;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBt;
	
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
	
	public String dupicateConatct()
	{
		String expName=exp_lastname.getText();
		duplicateBt.click();
		saveBt.click();
		return expName;
	}
	public void validation(String actual_name)
	{
		JavaLibrary jl=new JavaLibrary();
		contactLink.click();
		List<WebElement> allname=contactList;
		ArrayList<String> list=new ArrayList<String>();
		for(WebElement wb:allname)
		{
			list.add(wb.getText());
		}
		int c=0;
		if(list.contains(actual_name))
			c++;
		if(c>1)
			jl.printStatement("Contact is duplicated");
		else
			jl.printStatement("Contact is not duplicated");
	}
}
=======
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
>>>>>>> branch 'master' of https://github.com/Heeraangel/SDET34L1-SELENIUM-FRAMEWORK.git
