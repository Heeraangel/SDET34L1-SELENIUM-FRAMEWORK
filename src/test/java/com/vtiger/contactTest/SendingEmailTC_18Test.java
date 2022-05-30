package com.vtiger.contactTest;

import org.testng.annotations.Test;

import com.vtiger.ElementRepository.ContactSendMail;
import com.vtiger.genericLibrary.BaseClass;

public class SendingEmailTC_18Test extends BaseClass{

	@Test
	public void sendingEmailTC_18Test() {
		ContactSendMail contactsendMail=new ContactSendMail(driver);
		homepage.clickConatct();
		contactsendMail.sendMail(driver);
	}
}
