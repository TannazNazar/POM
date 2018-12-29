package com.syntax.orangehrm.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	
	public static void setUp() {
		
		initProperties(Constants.configFilePath);
		String browser=prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
			driver=new ChromeDriver();
		}else if (browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver");
			driver=new FirefoxDriver();
		}else {
			System.out.println("Please provide valid browser");
		}
		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	public static Properties initProperties(String filePath) {
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream(filePath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public static void tearDown() {
		driver.quit();
	}
}
