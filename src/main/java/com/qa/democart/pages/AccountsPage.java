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

@Epic("EPIC:100 Design Full Accounts Page for open cart applicaton....")
@Story("US 201: Accounts page For user")//user story
public class AccountsPage {
	private WebDriver driver; 
	private ElementUtil elementutil;
	
	//private By header = By.xpath("//div[@id='logo']/h1/a");
	private By header = By.cssSelector("div#logo a");
	private By AccountSectionHeaders = By.cssSelector("div#content h2");
	private By SearchText = By.cssSelector("div#search input");
	private By SearchBtn = By.cssSelector("div#search button");
	private By SearchItemsresult = By.cssSelector("div.product-layout .product-thumb ");
	
	//constructor
	public AccountsPage(WebDriver driver) {//yaha AccountsPage ka object bante hi ye constructor ka call aye ga or jo driver pass kiya jaye ga wo elementutil me pass o jaye ga
		this.driver=driver;
		elementutil = new ElementUtil(driver);
	}
	@Step("Getting Accounts Oage Title")
	public String getAccountPageTitle() {
		return elementutil.waitForTitleToBe(Constants.ACCOUNT_PAGE_TITLE, 5);
	}
	
	@Step("Get Header Value")
	public String getHeaderValue() {
		if(elementutil.doIsDisplayed(header)) {
			return elementutil.doGetText(header);
		}
		return null;
	}
	
	@Step("Getting Account Section count")
	public int getAccountSectionCount() {
		return elementutil.getElements(AccountSectionHeaders).size();
	}
	
	@Step("Getting Account Section List")
	public List<String> getAccountSectionList() {
		List<String> accountlist = new ArrayList<String>();
		
		List<WebElement> accountSectionList=elementutil.getElements(AccountSectionHeaders);
		for(WebElement e : accountSectionList) {
			String secText=e.getText();
			accountlist.add(secText);
		}
		return accountlist;
	}
	
	@Step("Search th product with:{0}")
	public boolean doSearch(String productname) {
		System.out.println("Search Product name:" +productname);
		elementutil.doSendKeys(SearchText, productname);
		elementutil.doClick(SearchBtn);
		if(elementutil.getElements(SearchItemsresult).size()>0) {
			return true;
		}
		return false;
	}

}
