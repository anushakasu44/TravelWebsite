package com.app.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.ExtentReportListener.FireEventListener;

public class BaseClass {
private static BaseClass base=null;
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver edriver;
	public static WebDriverEventListener eventlistener;
	
	
//	private BaseClass() {
//		
//	}
	
	public static BaseClass getInstance() {
		if(base==null) 
			base=new BaseClass();
		return base;
		
	}
	
	public WebDriver launchBrowser() {
		try {
		prop=new Properties();
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resourses\\Config_Properties");
		prop.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		driver=null;
		if(prop.getProperty("name").equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resourses\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.addArguments("headless");
			
			driver=new ChromeDriver();
			
		}
		
		edriver=new EventFiringWebDriver(driver);
		eventlistener=new FireEventListener();
		edriver.register(eventlistener);
		driver=edriver;
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	
	

	
  public void sendKeysWait(int timer,WebElement element) {
	new WebDriverWait(driver, timer).until(ExpectedConditions.elementToBeClickable(element));
	element.click();
}
	public void closeBrowser()  {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
	
	public static void takeScreenShot(String TestMethodName) {
		try {
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File(System.getProperty("user.dir")+"\\target\\screenshots\\"+TestMethodName+System.currentTimeMillis()+"_"+".png"));
		}catch(Exception e) {
			e.getStackTrace();
		}
		}
	}

