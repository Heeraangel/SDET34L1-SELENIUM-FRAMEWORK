package com.vtiger.contactTest;

import org.testng.annotations.Test;
import com.vtiger.ElementRepository.ContactSendMail;
import com.vtiger.genericLibrary.BaseClass;

public class OpenSendMailTC_19Test extends BaseClass{

	@Test
	public void openSendMailTC_19Test(){
		homepage.clickConatct();
		ContactSendMail contactsendmail=new ContactSendMail(driver);
		contactsendmail.openMail(driver);
	}
}
