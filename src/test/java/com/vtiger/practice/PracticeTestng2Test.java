package com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticeTestng2Test{
	@BeforeSuite(groups="baseclass")
	public void methodBSTest()
	{
		Reporter.log("Before Suite",true);
	}
	@AfterSuite(groups="baseclass")
	public void methodASTest()
	{
		Reporter.log("After Suite",true);
	}
	@BeforeTest(groups="baseclass")
	public void methodBTTest()
	{
		Reporter.log("Before Test",true);
	}
	@AfterTest(groups="baseclass")
	public void methodATTest()
	{
		Reporter.log("After Test",true);
	}
	@BeforeClass(groups="baseclass")
	public void methodBCTest()
	{
		Reporter.log("Before Class",true);
	}
	@AfterClass(groups="baseclass")
	public void methodACTest()
	{
		Reporter.log("After Class",true);
	}
	@BeforeMethod(groups="baseclass")
	public void methodBMTest()
	{
		Reporter.log("Before Method",true);
	}
	@AfterMethod(groups="baseclass")
	public void methodAMTest()
	{
		Reporter.log("After Method",true);
	}
	@Test(groups="sanity")
	public void method4Test()
	{
		Reporter.log("Test 4",true);
	}
}
