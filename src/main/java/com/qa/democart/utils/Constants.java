package com.qa.democart.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	//these are variables
	public static final int FPRGOTTEN_PWD_LINK_COUNT = 2;
	public static final int ACCOUNT_SECTION_COUNT = 4;
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String ACCOUNTS_PAGE_HEADER = "Your Store";
	
	public static final String ACCOUNT_HAS_CREATED_SUCCES = "Your Account Has Been Created!";
	public static final String REGISTER_SHEET_NAME = "Register";
	public static final String SEARCH_SHEET_NAME = "Sheet1";
	public static final int Justfy_TABLET_SERCH = 6;
	
	public static List<String> accSecList;
	
	//this is a method
	public static List<String> getExpectedAccountSectionList(){
		accSecList = new ArrayList<String>();
		accSecList.add("My Account");
		accSecList.add("My Orders");
		accSecList.add("My Affiliate Account");
		accSecList.add("Newsletter");
		return accSecList;
		
	}

}
