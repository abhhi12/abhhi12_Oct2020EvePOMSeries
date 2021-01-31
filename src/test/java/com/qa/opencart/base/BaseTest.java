package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.democart.factory.DriverFactory;
import com.qa.democart.pages.AccountsPage;
import com.qa.democart.pages.LoginPage;
import com.qa.democart.pages.MovetoShopingCart;
import com.qa.democart.pages.RegisterPage;

public class BaseTest {//yaha base test me sabhi class ka object refrence banane kafayda ye hai hi ye base test ko sabhi pagetext class extends kar raha hai toh object refrence sab base ko v inherate karega. tabhi toh ye basesetup jase driverfactor or init_pro ko call karega.
	
	WebDriver driver;
	DriverFactory df;
	public Properties prop;
	public LoginPage loginPage;//first loginpage pe ana hai fir yaha se register link pe click kar k regisration page pe jana hai.
	public AccountsPage accountpage;//base test me sabhi ka object refrence bana lena hai or jaha v extends kiya jaye ga direct object reference use karge.
	public RegisterPage registerpage;//iska object loginpage me banaya gaya hai as a return le kar
	public MovetoShopingCart movetoShopingcart;
	
	@BeforeTest
	public void setUp() {
		df= new DriverFactory();
		prop=df.init_prop();//yaha prop me lene ka matlab ki Properties prop key(all key and value is me hai. ye pointer ka kaam karega) ko pick karega confg.properties or ye send kar dega key(jo ki crome hai) init_driver method me.
		driver=df.init_driver(prop);//yaha prop driver k sath connect ho gaya hai. driver k sath prop key ko fetch karega config.propreties se.
		driver.get(prop.getProperty("url"));
		loginPage= new LoginPage(driver);
		movetoShopingcart = new MovetoShopingCart(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
