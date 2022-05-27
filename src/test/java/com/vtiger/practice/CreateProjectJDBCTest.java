package com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.mysql.cj.jdbc.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProjectJDBCTest {

	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driver1=new Driver();
		DriverManager.registerDriver(driver1);
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		Statement statement=connection.createStatement();
		Random r=new Random();
		int num=r.nextInt(100);
		String projectId="TY_PROJ_0"+num;
		int num1=r.nextInt(100);
		String projectName="Abc"+num1;
		int result=statement.executeUpdate("insert into project values('"+projectId+"','Deepak','28/04/2022','"+projectName+"','On Going',3);");
		if(result==1)
			System.out.println("Data inserted successfully");
		connection.close();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8084");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra",Keys.TAB,"rmgy@9999",Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		List<WebElement> listOfProject=driver.findElements(By.xpath("//table//tbody/tr/td[2]"));
		for(WebElement project:listOfProject)
		{
			if(project.getText().equalsIgnoreCase(projectName))
			{
				System.out.println("Project name present in GUI");
				break;
			}
		}
		driver.quit();
	}
}