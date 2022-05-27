package com.vtiger.practice;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.sdet34l1.genericLibrary.ExcelLibrary;
import com.sdet34l1.genericLibrary.FileLibrary;
import com.sdet34l1.genericLibrary.IConstantPath;
import com.sdet34l1.genericLibrary.JavaLibrary;
import com.sdet34l1.genericLibrary.WebDriverLibrary;
import com.vtiger.ElementRepository.HomePage;
import com.vtiger.ElementRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassPractice {
	public WebDriver driver=null;
	public JavaLibrary javalibrary;
	public LoginPage loginpage;
	public HomePage homepage;
	public Long longTimeOut;
	public int randomNumber;
	public WebDriverLibrary webDriverLibrary=new WebDriverLibrary();
	public FileLibrary fileLibrary=new FileLibrary();
	public ExcelLibrary excelLibrary=new ExcelLibrary();
	/**
	 * This method is used to open property file and excel sheet
	 */
	@BeforeSuite(groups="baseclass")
	public void beforeSuite()
	{
		try {
			fileLibrary.openPropertyFile(IConstantPath.PROPERTYPATH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			excelLibrary.openExcel(IConstantPath.EXCELPATH);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to close the excel sheet
	 */
	@AfterSuite(groups="baseclass")
	public void afterSuite()
	{
		try {
			excelLibrary.closeExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to open the web browser,generate random number,Object creation
	 */
	@BeforeTest(groups="baseclass")
	public void beforeClass()
	{
		javalibrary=new JavaLibrary();
		randomNumber=javalibrary.getRandomNumber(1000);
		longTimeOut=javalibrary.stringToLong(fileLibrary.getDataFromProperty("timeout"));
		switch(fileLibrary.getDataFromProperty("browser"))
		{
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
				break;
		}
		webDriverLibrary.navigateApp(driver,IConstantPath.PROPERTYPATH);
		webDriverLibrary.browserSetting(longTimeOut, driver);
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		webDriverLibrary.initilizeActions(driver);
	}
	/**
	 * This method is used to close the web browsers
	 */
	@AfterTest(groups="baseclass")
	public void afterClass()
	{
		webDriverLibrary.quit(driver);
		try {
			excelLibrary.writeDatatoExcel(IConstantPath.EXCELPATH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to login to the application
	 */
	@BeforeMethod(groups="baseclass")
	public void beforeMethod()
	{
		loginpage.loginAction(fileLibrary.getDataFromProperty("uname"), fileLibrary.getDataFromProperty("pwd"));
	}
	/**
	 * This method is used to logout from the application 
	 * @throws InterruptedException 
	 */
	@AfterMethod(groups="baseclass")
	public void afterMethod() throws InterruptedException
	{
		homepage.signOutAction(driver,webDriverLibrary);	
	}

}
