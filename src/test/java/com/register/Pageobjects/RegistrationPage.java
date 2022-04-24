package com.register.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.register.Utilities.ReadConfig;
import com.register.test.BaseTest;


public class RegistrationPage {
	
	ReadConfig config = new ReadConfig();
	
	
	WebDriver driver;
	public RegistrationPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

@FindBy(id="first_name")
WebElement FirstName;

@FindBy(id="last_name")
WebElement LastName;

@FindBy(id="company")
WebElement Company;

@FindBy(id="email2")
WebElement Email;

@FindBy(id="number")
WebElement Number;

@FindBy(id="password2")
WebElement Password;

@FindBy(id="password-confirm")
WebElement ConfirmPassword;

@FindBy(xpath="//button[@name='signup']")
WebElement Signup;

String Firstnam= config.GetFirstname();
String LastNam= config.GetLastname();
String Comp=config.GetCompany();
String emails= config.Getemail();
String mobile= config.Getmobile();
String pas=config.Getpassword();
String confpas=config.Getpassword();



public void register(String emails, String mobile) {
	
	
	
	FirstName.sendKeys(Firstnam);
	LastName.sendKeys(LastNam);
	Company.sendKeys(Comp);
	Email.sendKeys(emails);
	Number.sendKeys(mobile);
	Password.sendKeys(pas);
	ConfirmPassword.sendKeys(confpas);
	Signup.click();


}

}
