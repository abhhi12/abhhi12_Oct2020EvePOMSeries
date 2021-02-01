package com.qa.opencart.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class MovetoShopingCartTest extends BaseTest {
	@BeforeClass
	public void fromloginpagetoShopigcart() {
		movetoShopingcart=loginPage.doclickShopingCart();
	}
	@Test(priority=1)
	public void TestMovetoShopingCart() {
		movetoShopingcart.doclickCOntBtn();
		
	}
	
}
