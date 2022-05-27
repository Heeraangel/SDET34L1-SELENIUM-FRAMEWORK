package com.sdet34l1.genericLibrary;

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
	public int randomNumber;
	public WebDriverLibrary webDriverLibrary;
	public ExcelLibrary excelLibrary;
	public FileLibrary fileLibrary;
	//public String url;
	public static WebDriver staticDriver;
	/**
	 * This method is used to open property file and excel sheet
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	@BeforeSuite(groups="baseclass")
	public void beforeSuite() throws EncryptedDocumentException, IOException
	{
		
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
	 * @param browser 
	 * @throws Throwable 
	 */
	//@Parameters("browser")
	@BeforeClass(groups="baseclass")
	public void beforeClass(/*String browser*/) throws Throwable
	{
		javalibrary=new JavaLibrary();
		webDriverLibrary=new WebDriverLibrary();
		excelLibrary=new ExcelLibrary();
		fileLibrary=new FileLibrary();
		fileLibrary.openPropertyFile(IConstantPath.PROPERTYPATH);
		excelLibrary.openExcel(IConstantPath.EXCELPATH);
		randomNumber=javalibrary.getRandomNumber(1000);
		longTimeOut=javalibrary.stringToLong(fileLibrary.getDataFromProperty("timeout"));
		//url =fileLibrary.getDataFromProperty("url");
		//String browser=fileLibrary.getDataFromProperty("browser");
		String url=System.getProperty("URL");
		String browser=System.getProperty("BROWSER");
		switch(browser)
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
		staticDriver=driver;
		webDriverLibrary.navigateApp(driver,url);
		webDriverLibrary.browserSetting(longTimeOut, driver);
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		webDriverLibrary.initilizeActions(driver);
	}
	/**
	 * This method is used to close the web browsers
	 */
	@AfterClass(groups="baseclass")
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
		loginpage.loginAction(fileLibrary.getDataFromProperty("uname"),fileLibrary.getDataFromProperty("pwd"));
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