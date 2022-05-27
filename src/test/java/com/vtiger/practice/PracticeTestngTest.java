package com.vtiger.practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PracticeTestngTest extends PracticeTestng2Test {
	
	@Test(groups="sanity")
	public void method1Test()
	{
		Reporter.log("Test 1",true);
		Assert.fail();
	}
	@Test(groups="regression")
	public void method2Test()
	{
		System.out.println("Test 2");
	}
	@Test(groups={"regression","sanity"})
	public void method3Test()
	{
		System.out.println("Test 3");
	}
}
