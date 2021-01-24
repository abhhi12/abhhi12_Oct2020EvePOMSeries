package com.qa.democart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ElementUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class RegisterPage {
	
	private WebDriver driver;
	private ElementUtil elementutil;
	
	private By firstname = By.id("input-firstname");
	private By lastname = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	
	private By paswword = By.id("input-password");
	private By Confpassword = By.id("input-confirm");
	
	private By SubscribeYes = By.xpath("//label[@class='radio-inline'][position()=1]/input");
	private By SubscribeNo = By.xpath("//label[@class='radio-inline'][position()=2]/input");
	
	private By AgreeCheckBox = By.name("agree");
	private By ContinueBtn = By.xpath("//input[@type='submit' and @value='Continue']");
	
	private By AccSuccessMsg = By.cssSelector("div#content h1");
	private By logout = By.linkText("Logout");
	private By register = By.linkText("Register");
	
	//constructor= we are creating constructor to initiate driver whenever object is created abd this driver passed to the private Webdriver.
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(driver);// yaha driver v Elementutil constructor k liye hai 
		
	}
	//page action
	@Step("Account Registration firstname:{0} lastname:{1} Email:{2} telephone:{3} Pwd:{4} Subscribe:{5}")
	public boolean AccountRegistration(String fisrtName, String lastName,
			String Email, String Telephone, String pwd, String Subscribe ) {
		elementutil.doSendKeys(firstname, fisrtName);
		elementutil.doSendKeys(lastname, lastName);
		elementutil.doSendKeys(email, Email);
		elementutil.doSendKeys(telephone, Telephone);
		elementutil.doSendKeys(paswword, pwd);
		
		
		if(Subscribe.equals("yes")) {
			elementutil.doClick(SubscribeYes);
		}
		else {
			elementutil.doClick(SubscribeNo);
		}
		
		elementutil.doClick(AgreeCheckBox);
		elementutil.doClick(ContinueBtn);
		
		String text=elementutil.doGetText(AccSuccessMsg);
		if(text.equals(Constants.ACCOUNT_HAS_CREATED_SUCCES)) {
			elementutil.doClick(logout);
			elementutil.doClick(register);
			return true;
		}
		return false;
		
	}
	
}
