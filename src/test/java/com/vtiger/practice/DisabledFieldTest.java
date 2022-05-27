package com.vtiger.practice;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DisabledFieldTest {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8084");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Random r=new Random();
		int num=r.nextInt(10000);
		String projectname="Abc"+num;
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra",Keys.TAB,"rmgy@9999",Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.className("material-icons")).click();
		driver.findElement(By.cssSelector("[name='projectName']")).sendKeys(projectname);
		
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("document.getElementByName('teamSize').value='2'");
		
		driver.findElement(By.name("createdBy")).sendKeys("Deepak");
	    WebElement projectstatus=driver.findElement(By.xpath("//label[text()='Project Status ']/../select"));
	    Select s=new Select(projectstatus);
	    s.selectByVisibleText("On Goging");
	    //driver.findElement(By.xpath("//input[@value='Add Project']")).click();

	}

}
