package com.vtiger.genericLibrary;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is used to maintain all the Web Driver common action
 * @author HP
 *
 */
public class WebDriverLibrary {
	static WebDriverWait wait;
	static Actions act;
	static Select select;
	static JavaLibrary jl=new JavaLibrary();
	static TakesScreenshot ts;
	static JavascriptExecutor js;
	static Alert alt;
	/**
	 * This method is used to navigate the application
	 * @param driver
	 * @param url
	 */
	public static void navigateApp(WebDriver driver)
	{
		driver.get(FileLibrary.getDataFromProperty("url"));
	}
	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
	public static void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to implicit wait till page load
	 * @param longTimeOut
	 * @param driver
	 */
	public static void waitTillPageLoad(long longTimeOut,WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(longTimeOut,TimeUnit.SECONDS);
	}
	/**
	 * This method is used to maximize the browser and implicit wait
	 * @param longTimeOut
	 * @param driver
	 */
	public static void browserSetting(long longTimeOut,WebDriver driver)
	{
		maximizeBrowser(driver);
		waitTillPageLoad(longTimeOut,driver);
	}
	/**
	 * This method is used to initilize the actions class
	 * @param driver
	 */
	public static void initilizeActions(WebDriver driver)
	{
		act=new Actions(driver);
	}
	/**
	 * This method is used to mouse hover element
	 * @param driver
	 * @param wb
	 */
	public static void mouseHoverOnTheElement(WebElement wb)
	{
		act.moveToElement(wb).perform();
	}
	/**
	 * This method is used to quit the browser
	 * @param driver
	 */
	public static void quit(WebDriver driver)
	{
		driver.quit();
	}
	/**
	 * This method is used to web driver wait
	 * @param driver
	 * @param timeOut
	 */
	public static void explicitWaitUsingVisibility(WebDriver driver,long timeOut,WebElement element) 
	{
		wait=new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is used to switch window the window based on title
	 * @param driver
	 * @param current_id
	 * @param partialText
	 */
	public static void switchToWindowBasedOnTitle(WebDriver driver,String partialText)
	{
		Set<String> allid=driver.getWindowHandles();
		for(String id:allid)
		{
			driver.switchTo().window(id);
			if(driver.getTitle().contains(partialText))
			{
				break;
			}
		}
	}
	/**
	 * This method is used to switch to the frame
	 * @param wb
	 * @param driver
	 */
	public static void switchToFrame(WebElement wb, WebDriver driver)
	{
		driver.switchTo().frame(wb);
	}
	/**
	 * This method is used to switch to main frame
	 * @param driver
	 */
	public static void switchToMainFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to switch to parent frame
	 * @param driver
	 */
	public static void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * This method is used to initilize the select class object
	 * @param element
	 */
	public static void initilizeSelectClass(WebElement element)
	{
		select=new Select(element);
	}
	/**
	 * This method is used to select value from dropdown using value
	 * @param element
	 * @param value
	 */
	public static void selectDropdownByValue(String value)
	{
		select.selectByValue(value);
	}
	/**
	 * This method is used to select value from dropdown using index
	 * @param index
	 */
	public static void selectDropdownByIndex(int index)
	{
		select.selectByIndex(index);
	}
	/**
	 * This method is used to select value from dropdown using visible text
	 * @param value
	 */
	public static void selectDropdownByVisibleText(String value)
	{
		select.selectByVisibleText(value);
	}
	/**
	 * This method is used to customized wait
	 * @param element
	 * @param polingTime
	 * @param duration
	 */
	public static void customWait(WebElement element,long polingTime,int duration)
	{
		int count=0;
		while(count<=duration)
		{
			try {
				element.click();
				break;
				} catch (Exception e) {
				try {
					Thread.sleep(polingTime);
					count++;
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	/**
	 * This method is used to take screen shot
	 * @param driver
	 * @param fileName
	 * @throws IOException
	 */
	public static void takeScreenShot(WebDriver driver,String fileName) throws IOException
	{
		ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("./Screenshot/"+fileName+"-"+jl.dateTimeInFormat()+".png");
		FileUtils.copyFile(src,dst);
	}
	/**
	 * This method is used to initilize the java script
	 * @param driver
	 */
	public static void initilizeJavaScript(WebDriver driver)
	{
		js=(JavascriptExecutor)driver;
	}
	/**
	 * This method is used to imitilize alert interface
	 * @param driver
	 */
	public static void initilizeAlert(WebDriver driver)
	{
		alt=driver.switchTo().alert();
	}
	/**
	 * This method is used to dissmis the alert popup
	 */
	public static void dissmisAlert()
	{
		alt.dismiss();
	}
}