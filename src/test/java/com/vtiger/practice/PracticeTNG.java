package com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticeTNG {
/*	@Test
	public void methodTest()
	{
		Reporter.log("cheems",true);
		Reporter.log("vidhayk",false);
		Reporter.log("doge");
		System.out.print("cheems 1");
		System.out.print("vidhayak 1");
		System.out.print("doge 1");
	}
	*/
	@Test
	public void methodTest()
	{
		Reporter.log("Method");
	}
	@BeforeSuite
	public void BSTest()
	{
		Reporter.log("BS",true);
	}
	@AfterSuite
	public void ASTest()
	{
		Reporter.log("AS");
	}
	@BeforeTest
	public void BTTest()
	{
		Reporter.log("BT",true);
	}
	@AfterTest
	public void ATTest()
	{
		Reporter.log("AT",true);
	}

}
