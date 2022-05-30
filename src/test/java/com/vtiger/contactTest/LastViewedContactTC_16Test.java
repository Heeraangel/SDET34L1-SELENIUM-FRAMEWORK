package com.vtiger.contactTest;

import org.testng.annotations.Test;
import com.vtiger.ElementRepository.ContactPage;
import com.vtiger.genericLibrary.BaseClass;

public class LastViewedContactTC_16Test extends BaseClass {

	@Test
	public void lastViewedContactTC_16Test() {
		ContactPage contactpage=new ContactPage(driver);
		homepage.clickConatct();
		contactpage.lastViewed();
	}
}
