package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ExelUtil;
import com.qa.opencart.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class AccountsPageTest extends BaseTest {
	
	@BeforeClass//yaha BeforeClass ka is liye use kiya ja raha hai loginpage se ye account page me a raha hai. because login page hi main page hai. or ye @Beforeclass anotation @beforeTest anotation ke baad hi work karega
	public void accountpagesetup() {
		accountpage=loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));//stored in AccountsPage call object
		//We need this so that we can call all the methods from the accounts pageclass
		//because to call the method of the account page class we need to create the object of the class, accountpage this work as a refrence for AccountPage call and call the method
	
	}
	
	@Description("accounts Page Title Test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority=1)
	public void accountsPageTitleTest() {
		String title=accountpage.getAccountPageTitle();
		System.out.println("Acc page title is:"+title);
		Assert.assertEquals(title, Constants.ACCOUNT_PAGE_TITLE);
	}
	
	@Description("verifyacc Page Header Test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority=2)
	public void verifyaccPageHeaderTest() {
		String accheader=accountpage.getHeaderValue();
		System.out.println("Account Headre:" +accheader);
		Assert.assertEquals(accheader, Constants.ACCOUNTS_PAGE_HEADER);
	}
	
	@Description("verifyAcc Section Count Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=3)
	public void verifyAccSectionCountTest() {
		Assert.assertTrue(accountpage.getAccountSectionCount()==Constants.ACCOUNT_SECTION_COUNT);
	}
	
	@Description("verify Acount SectionList Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=4)
	public void verifyAcountSectionListTest() {
		List<String> accSecList=accountpage.getAccountSectionList();
		Assert.assertEquals(accSecList, Constants.getExpectedAccountSectionList());
	}
	
	//@DataProvider
//	public Object[][] productTestData() {//this method will generate the data
//		return new Object [][] {
//			                   {"iMac"},
//			                   {"Macbook"},
//			                   {"iPHONE"}
//		                       };
		
	//}coppyall+press tab to use //
	
	@DataProvider
	public Object[][] productTestData() {
		Object data[][]=ExelUtil.getTestData(Constants.SEARCH_SHEET_NAME);
		return data;
	}
	
	@Description("searc htest")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=5, dataProvider="productTestData")
	public void searchtest(String product) {
		Assert.assertTrue(accountpage.doSearch(product));// both are mapped with this keyword dataProvider
	}

}
