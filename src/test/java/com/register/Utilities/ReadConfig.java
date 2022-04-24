package com.register.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	

		Properties prop;

		public ReadConfig() {
			File src = new File("./Configuration/config.properties");
			try {
				FileInputStream file = new FileInputStream(src);
				prop = new Properties();
				prop.load(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("The following exception is hit" + " e.printStackTrace()");
			}

			
		}

	
		public String GetFirstname() 
		{
			String Firstnam = prop.getProperty("Firstname");
			return Firstnam;

		}
		
		
	
		public String GetLastname() 
		{
			String LastNam = prop.getProperty("LastName");
			return LastNam;

		}
		
		public String GetCompany() 
		{
			String Comp = prop.getProperty("Company");
			return Comp;

		}
		
		public String Getmobile() 
		{
			String mobile = prop.getProperty("mobile");
			return mobile;

		}
		
		public String Getemail() 
		{
			String emails = prop.getProperty("email");
			return emails;

		}
		
	
	
		public String Getpassword() 
		{
			String pas = prop.getProperty("password");
			return pas;

		}
		

		public String Geturl() 
		{
			String url = prop.getProperty("url");
			return url;

		}
		
		public String getchromepath() {

			String chromepath = prop.getProperty("chromepath");
			return chromepath;
		}

		public String getiepath() {
			String iepath = prop.getProperty("iepath");
			return iepath;

		}

		public String getfirefoxpath() {
			String firefoxpath = prop.getProperty("firefoxpath");
			return firefoxpath;
		}
	
	
	
	
	}
