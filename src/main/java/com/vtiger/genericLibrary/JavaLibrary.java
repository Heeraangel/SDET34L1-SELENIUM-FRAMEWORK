package com.vtiger.genericLibrary;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * This class contains only java specific reusable methods
 * @author HP
 *
 */
public class JavaLibrary {
	/**
	 * This method is used to convert string value to long datatype
	 * @param value
	 * @return
	 */
		public long stringToLong(String value) {
			return Long.parseLong(value);
		}
		/**
		 * This method is used to generate random numbers
		 * @param limit
		 * @return
		 */
		public int getRandomNumber(int limit)
		{
			Random r=new Random();
			return r.nextInt(limit);
		}
		/**
		 * This method is used  to print the message
		 * @param message
		 */
		public void printStatement(String message)
		{
			System.out.println(message);
		}
		/**
		 * This method is used to check the assertion
		 * @param actualResult
		 * @param expectedResult
		 * @param testCase
		 */
		public void assertionUsingIfElse(String actualResult, String expectedResult, String testCase)
		{
			if(actualResult.equalsIgnoreCase(expectedResult))
			{
			System.out.println(testCase+"created successfully");
			System.out.println("Pass");
			}
		}
		/**
		 * This method is used to check assertion using equalsIgnoreCase
		 * @param value
		 * @param exp_value
		 */
		public void assertionUsingEquals(String value, String exp_value)
		{
			if(value.equalsIgnoreCase(exp_value))
			System.out.println("Created successfully");
			else
				System.out.println("Creation failed");
		}
		/**
		 * This method is used to return current date and time
		 * @return
		 */
		public String dateTimeInFormat()
		{
		return	new SimpleDateFormat("yyyy_MM_dd_HH_mm_sss").format(new Date());
		}
		/**
		 * This method will print passed
		 */
		public void tCStatus()
		{
			System.out.println("Passed");
		}
}