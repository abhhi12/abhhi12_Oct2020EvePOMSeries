package com.qa.democart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author abhhi
 * 
 */

public class DriverFactory {
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	//this is using for threading means parallel execution of driver at the the time of testrun. they have set and get method for driver
	/**
	 * 
	 * @param browserName
	 * @return this return WebDriver reference on the basis of given browser
	 */
	
	public WebDriver init_driver(Properties prop) {//Properties java lib se aya hai jo ki properties me KEY ko point karta hai for example browser="chrome", yaha browser key hai or chromwe value hai.
		String browserName=prop.getProperty("browser");
		
	System.out.println("Browser name is :" + browserName);
	
	switch(browserName) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		tlDriver.set(new ChromeDriver());
		break;
		
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		//driver = new FirefoxDriver();
		tlDriver.set(new FirefoxDriver());
		break;
		
	case "safari":
		//driver = new SafariDriver();
		tlDriver.set(new SafariDriver());
		break;
		
	default:
		System.out.println("Please Pass the correct Browser name:" +browserName);
		break;		
	}
	
	    getDriver().manage().deleteAllCookies();
	    getDriver().manage().window().maximize();
	
	return getDriver();
	
	}
	/**
	 * getDriver using local threads
	 * @return 
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	
	/**
	 * This method will initialize the properties from config.properties file
	 * @return prop
	 */
	public Properties init_prop() {
		Properties prop = null;//null because if properties not loaded then it will return null
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");//yaha path se copy karna hai 
			prop = new Properties();//yaha object creat karna hai Properties ka
			prop.load(ip);//or yaha load function se ip me jo v config.prop me se aya hai, yaha a jaye ga. or is try and catch clouse se surround karna hai
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	/**
	 * This method is used to take the screenshot and it will return the path
	 * of the screenshot
	 * @return 
	 */
	public String getScreenShot() {//this method is used in extendspagelogic
		File src=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshots/"+ System.currentTimeMillis()+".png";
		File destination = new File(path);
		
		try {
			FileUtils.copyFile(src, destination);////FileUtils is a class in Selenium
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
