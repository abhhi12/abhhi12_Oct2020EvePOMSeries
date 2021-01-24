package com.qa.opencart.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ExelUtil;
import com.qa.opencart.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class RegisterPageTest extends BaseTest {
	
	
//yaha registerpage pe ane k liye humlogo ko pehle loginpage pe ana hoga fir waha se register btn ko click karna hoga
//is liye loginpage pe ek regester kaek locater lana hoga. Or ek method v develop karna hoga because wahi test page me assert karege.
	
	@BeforeClass
	public void regPageSetUp() {//it is a method, yaha 
		registerpage=loginPage.navigateToRegisterPage();//yaha loginPage class reference se loginpage methode ko call kar rahe hai jo ki method execute k baad me return me register page calls object de raha hai.
		//yaha "loginPage.navigateToRegisterPage" method ka sara executon ko Registerpage class k object refrence me le liya gaya hai. connection k liye
		//aab yaha se next page Registerpage me chale gaye hai
		//registerpage ye aab loginPage.navigateToRegisterPage or Register Page ka v method/data hold karega.
	}
	
	@DataProvider
	public Object[][] getRegistrationSetup() {
		Object data[][]=ExelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return data;
	}
	@Description("Uesr Page Registration SetUP Test")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProvider="getRegistrationSetup")
	public void userRegistrationSetUp(String firstname, String lastname, String email, String telephone, String pwd, String subscribe) {
		registerpage.AccountRegistration(firstname, lastname, email, telephone, telephone, subscribe);
	}//output me phone number 9.5262 ata hai so we have to fix it in excel sheet by putting cot.
	
}
