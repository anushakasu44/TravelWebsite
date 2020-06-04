package Com.Util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class BaseClass {
   private static BaseClass base;
	public static WebDriver driver;
	public static Properties prop;
	
	
	public static BaseClass GetInstance() {
		if(base==null)
			base=new BaseClass();
		return base;
		
	}
	
	public WebDriver openBrowser() {
		try{
			prop=new Properties();
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Config.Properties");
			prop.load(fis);
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		if(prop.getProperty("browser").equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\anush\\Downloads\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public static void takeScreenShot(String testmethod) {
		try {
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File(System.getProperty("user.dir")+"\\target\\shreenshots\\"+testmethod+".png"));
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		}
	
	public static void javaScriptClick(WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click()"
				, element);
		
	}
}
