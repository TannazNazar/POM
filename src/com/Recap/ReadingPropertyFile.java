package com.Recap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadingPropertyFile {

	public static void main(String[] args) throws IOException {
		/*Steps to read property file
		 * 1. Create an object of Propperties Class
		 * 2. Create object of FileInputStream
		 * 3. Load file into property object variable 
		 */
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("./configs/credentials.properties");
		
		prop.load(fis);
		
		String browserValue = prop.getProperty("browser");
		
		System.out.println(browserValue);
		
		System.out.println(prop.getProperty("userName"));
		
		System.out.println(prop.getProperty("url"));
		
		System.out.println(System.getProperty("user.dir"));

	}
}
