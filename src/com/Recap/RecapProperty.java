package com.Recap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class RecapProperty {

	public static void main(String[] args) throws IOException {
		
		//String filePath="./configs/credentials.properties";
		String filePath=System.getProperty("user.dir")+"/configs/credentials.properties";
		//Users/assele4ka/Desktop/SeleniumBatchIII/POM
		System.out.println(filePath);
		
		FileInputStream fis=new FileInputStream(filePath);
		Properties prop=new Properties();
		
		prop.load(fis);
		
		System.out.println(prop.getProperty("userName"));
		System.out.println(prop.getProperty("url"));
		
	}
}
