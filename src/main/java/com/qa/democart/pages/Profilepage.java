package com.qa.democart.pages;

import org.openqa.selenium.By;

public class Profilepage {
	
	private By profile = By.id("profile"); 
	
	public  Profilepage() {
		System.out.println("PP....default constructor");
	}
	public void gettitle() {
		System.out.println("PP...title");
		System.out.println("click on profile");
	}

}
