package com.vtiger.genericLibrary;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtiger.ElementRepository.HomePage;
import com.vtiger.ElementRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver=null;
	public JavaLibrary javalibrary;
	public LoginPage loginpage;
	public HomePage homepage;
	public Long longTimeOut;
	public int num;
	/**
	 * This method is used to open property file and excel sheet
	 */
	@BeforeSuite
	public void beforeSuite()
	{
		try {
			FileLibrary.openPropertyFile(IConstantPath.PROPERTYPATH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ExcelLibrary.openExcel(IConstantPath.EXCELPATH);
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
	@AfterSuite
	public void afterSuite()
	{
		try {
			ExcelLibrary.closeExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to open the web browser,generate random number,Object creation
	 */
	@BeforeClass
	public void beforeClass()
	{
		javalibrary=new JavaLibrary();
		num=javalibrary.getRandomNumber(1000);
		longTimeOut=javalibrary.stringToLong(FileLibrary.getDataFromProperty("timeout"));
		switch(FileLibrary.getDataFromProperty("browser"))
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
		WebDriverLibrary.navigateApp(driver);
		WebDriverLibrary.browserSetting(longTimeOut, driver);
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		WebDriverLibrary.initilizeActions(driver);
	}
	/**
	 * This method is used to close the web browsers
	 */
	@AfterClass
	public void afterClass()
	{
		WebDriverLibrary.quit(driver);
		try {
			ExcelLibrary.writeDatatoExcel(IConstantPath.EXCELPATH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to login to the application
	 */
	@BeforeMethod
	public void beforeMethod()
	{
		loginpage.loginAction(FileLibrary.getDataFromProperty("uname"), FileLibrary.getDataFromProperty("pwd"));
	}
	/**
	 * This method is used to logout from the application 
	 */
	@AfterMethod
	public void afterMethod()
	{
		homepage.signOutAction(driver);	
	}
}
