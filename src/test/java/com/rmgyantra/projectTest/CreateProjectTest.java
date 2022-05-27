package com.rmgyantra.projectTest;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.sdet34l1.genericLibrary.DataBaseLibrary;
import com.sdet34l1.genericLibrary.ExcelLibrary;
import com.sdet34l1.genericLibrary.FileLibrary;
import com.sdet34l1.genericLibrary.IConstantPath;
import com.sdet34l1.genericLibrary.JavaLibrary;
import com.sdet34l1.genericLibrary.WebDriverLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProjectTest {

	static FileLibrary fileLibrary=new FileLibrary();
	static ExcelLibrary excelLibrary=new ExcelLibrary();
	public static void main(String[] args){
		// TODO Auto-generated method stub
		JavaLibrary javaLibrary=new JavaLibrary();
		DataBaseLibrary dataBaseLibrary=new DataBaseLibrary();
		WebDriverLibrary webDriverLibrary=new WebDriverLibrary();
		
		try {
			fileLibrary.openPropertyFile(IConstantPath.RMGYANTRA_PROPERTYPATH);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		Long longTimeOut=javaLibrary.stringToLong(fileLibrary.getDataFromProperty("timeOut"));
		
		try {
			excelLibrary.openExcel(IConstantPath.RMGYANTRA_EXCELPATH);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String project_name=excelLibrary.getDataFromExcel("Project", 2, 4)+javaLibrary.getRandomNumber(1000);
		String created_By=excelLibrary.getDataFromExcel("Project", 2, 5);
		try {
			excelLibrary.closeExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriver driver=null;
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
		webDriverLibrary.navigateApp(driver,IConstantPath.RMGYANTRA_PROPERTYPATH);
		webDriverLibrary.maximizeBrowser(driver);
		webDriverLibrary.browserSetting(longTimeOut, driver);
		driver.findElement(By.id("usernmae")).sendKeys(fileLibrary.getDataFromProperty("Username"),Keys.TAB,fileLibrary.getDataFromProperty("Password"),Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.className("material-icons")).click();
		driver.findElement(By.cssSelector("[name='projectName']")).sendKeys(project_name);
		driver.findElement(By.name("createdBy")).sendKeys(created_By);
	    WebElement projectstatus=driver.findElement(By.xpath("//label[text()='Project Status ']/../select"));
	    webDriverLibrary.initilizeSelectClass(projectstatus);
	    webDriverLibrary.selectDropdownByVisibleText("On Goging",projectstatus);
	    driver.findElement(By.xpath("//input[@value='Add Project']")).click();
	    dataBaseLibrary.openDBConnection(IConstantPath.DATABASEURL+fileLibrary.getDataFromProperty("dbName"), fileLibrary.getDataFromProperty("dbUname"), fileLibrary.getDataFromProperty("dbPwd"));
	    dataBaseLibrary.getDataFromDatabase("select * from project;","project_name");
	    boolean status=dataBaseLibrary.validateDataInDatabase("select * from project;","project_name",project_name );
	    if(status==true)
	    {
	    	System.out.println("TC Pass");
	    }
	    else
	    {
	    	System.out.println("TC Fail");	
	    }
	    dataBaseLibrary.closeDBConnection();
	    webDriverLibrary.quit(driver);
	}
}
