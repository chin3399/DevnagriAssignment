package com.register.test;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.register.Utilities.ReadConfig;





public class BaseTest {

	WebDriver driver;
	ReadConfig config = new ReadConfig();
	String url = config.Geturl();
	

	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", config.getchromepath());
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", config.getfirefoxpath());
			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("ie")) {

			System.setProperty("webdriver.ie.driver", config.getiepath());
			driver = new InternetExplorerDriver();
		}

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     	driver.manage().window().maximize();
		
	}

	@AfterClass
	public void TearDown() {
		driver.manage().deleteAllCookies();
	//	driver.quit();
	}
	
	public static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
	public static String getRandomNumberString() {
	    // It will generate 6 digit random Number.
	    // from 0 to 999999
	    Random rnd = new Random();
	    int number = rnd.nextInt(99999);

	    // this will convert any number sequence into 6 character.
	    return String.format("%06d", number);
	}


public void CaptureScreen(WebDriver driver, String Tname) throws IOException {
	
	TakesScreenshot ts = (TakesScreenshot)driver;
	File Source = ts.getScreenshotAs(OutputType.FILE);
	File Target = new File(System.getProperty("user.dir")+ "/Screenshots/" + Tname + ".png");
	FileHandler.copy(Source, Target);

}
	
	
}
