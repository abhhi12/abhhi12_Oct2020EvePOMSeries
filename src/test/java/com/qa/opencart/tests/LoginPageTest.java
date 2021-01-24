package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.democart.utils.Constants;
import com.qa.opencart.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginPageTest extends BaseTest {
	
	@Description("verify login page title display...")
	@Severity(SeverityLevel.MINOR)//comming from allur report
	@Test(priority=1)
	public void verifyLoginPageTest() {
		String title=loginPage.getLoginPageTitle();
		System.out.println("login page title is :" +title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Description("verify Forgot Pwd link Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=2)
	public void verifyForgotPwdlinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
		
	}
	
	@Description("Login Test...")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=3)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

}
