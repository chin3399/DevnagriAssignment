package com.register.test;



import org.testng.Assert;
import org.testng.annotations.Test;




import com.register.Pageobjects.RegistrationPage;

public class RegistrationTest extends BaseTest  {
	
	
	String emails = BaseTest.getSaltString()+"@gmail.com";
	String mobile = BaseTest.getRandomNumberString()+"9765";
	
	@Test
	public void RegisterUser()
	{
		
		boolean R;
		boolean E=true;
		RegistrationPage P = new RegistrationPage(driver);
		P.register(emails,mobile);
		if(driver.getPageSource().contains("activation email")){
			
			R = true;
		}
		
		else {
			
			R = false;
		}
		
		
	Assert.assertEquals(R, E);
	
	}
	
	
	
	


}
