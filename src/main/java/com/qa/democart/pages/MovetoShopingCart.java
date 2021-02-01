package com.qa.democart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.democart.utils.ElementUtil;

public class MovetoShopingCart {
		private WebDriver driver;
		private ElementUtil eleutil;
		
		private By contbtn = By.linkText("Continue");
		private By zeroitembtn = By.cssSelector("#cart-total");
		private By Displaytextfromzeroitembtn = By.xpath("//ul[@class='dropdown-menu pull-right']/li/p");
		private By HeaderMenu = By.xpath("//ul[@class='nav navbar-nav']/li");
		
		
		public MovetoShopingCart(WebDriver driver) {
			this.driver = driver;
			eleutil = new ElementUtil(driver);
		}
		
		public void doclickCOntBtn() {
			eleutil.doClick(contbtn);
			eleutil.doClick(zeroitembtn);
			eleutil.doGetText(Displaytextfromzeroitembtn);
			eleutil.doGetText(HeaderMenu);
		}
}
