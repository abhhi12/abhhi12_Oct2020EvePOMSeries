package com.qa.democart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ElementUtil;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Epic("EPIC:100 User Login page")
@Story("US 201: Login page Future Story")
public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	// Page Locators : By Locators : OR 
	private By emailid = By.id("input-email");
	private By Password = By.id("input-password");
	private By logibbutton = By.cssSelector("input[value='Login']");
	private By ForgotPwdLink = By.linkText("Forgotten Password");
	private By Register = By.linkText("Register");
	private By ShopingCart = By.linkText("Shopping Cart");
	private By Listofheader = By.xpath("//ul[@class='nav navbar-nav']/li");
	
	//Page Constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//page actions:
	@Step("get Login Page Title")
	public String getLoginPageTitle() {
		return elementUtil.waitForTitleToBe(Constants.LOGIN_PAGE_TITLE, 5);
	}
	
	@Step("Forgot password link is displayed on login page...")
	public boolean isForgotPwdLinkExist() {
		if(elementUtil.getElements(ForgotPwdLink).size()==Constants.FPRGOTTEN_PWD_LINK_COUNT) {
			return true;
		
		}
		return false;
		
	}
	
	@Step("Login with Username:{0} and Password:{1}")//0=un,1=pwd
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("login with username: "+un+"and password" +pwd);
		elementUtil.doSendKeys(emailid, un);
		elementUtil.doSendKeys(Password, pwd);
		elementUtil.doClick(logibbutton);
		
		return new AccountsPage(driver);//after click next page return me mil raha hai jo ki Accounts page hai
	}
	
	@Step("Anvigating to registration page")
	public RegisterPage navigateToRegisterPage() {
		elementUtil.doClick(Register);//yaha click karte hi ye registration page pe chala jaye ga is liye return new registration page dega.
		//yr Registration Page humlogo ne banaya hai through By locator jana hai(overall iska matlab ye hai)
		return new RegisterPage(driver);
	}
	public MovetoShopingCart doclickShopingCart() {
		elementUtil.doClick(ShopingCart);
		return new MovetoShopingCart(driver);
	}
	public List<String> doListofheader() {
		List<String> listofheader = new ArrayList<String>();
		
		List<WebElement> headerlist=elementUtil.getElements(Listofheader);
		for(WebElement e: headerlist) {
			String list_of_Header=e.getText();
			listofheader.add(list_of_Header);
			
		}
		return listofheader;
	}
}
