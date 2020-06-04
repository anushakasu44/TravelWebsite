package com.app.qa.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.app.qa.base.BaseClass;
import com.app.qa.pages.HomePage;
import com.app.qa.pages.LoginPage;
import com.qa.ExtentReportListener.ItestListener;


@Listeners(ItestListener.class)
public class LoginPageTest extends BaseClass{
	
	LoginPage page;
	HomePage home;
	
	
	@BeforeMethod
	public void setUp() {
		BaseClass bas=BaseClass.getInstance();
		bas.launchBrowser();
		page=new LoginPage();
		
	}
	
	@Test(priority=2)
	public void pageTitleTest() {
		String title=page.validateLoginpageTitle();
		Assert.assertEquals(title, "Guru99 Bank Home Page","Title page is not matching");
	}
	
	@Test(priority=3)
	public void bankNameTest() {
		Boolean bool=page.validateBankname();
		Assert.assertTrue(bool);
	}
	
	@Test(priority=1)
	public void loginTest() {
		home=page.Login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() {
	closeBrowser();
	}
	
	
}
