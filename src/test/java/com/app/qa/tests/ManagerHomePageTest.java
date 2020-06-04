package com.app.qa.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.app.qa.base.BaseClass;
import com.app.qa.pages.AddCustomerPage;
import com.app.qa.pages.HomePage;
import com.app.qa.pages.LoginPage;
import com.qa.ExtentReportListener.ItestListener;
@Listeners(ItestListener.class)
public class ManagerHomePageTest extends BaseClass{
LoginPage page;
HomePage home;
AddCustomerPage custPage;



@BeforeMethod
public void setUp() {
	BaseClass bas=BaseClass.getInstance();
	bas.launchBrowser();
	page=new LoginPage();
	home=page.Login(prop.getProperty("username"), prop.getProperty("password"));
	home=new HomePage();
}

@Test(priority=1)
public void homePageTitleTest() {
	String Title=home.validateHomepageTitle();
	Assert.assertEquals(Title, "Guru99 Bank Manager HomePage");
}

@Test(priority=2)
public void managerIdVerificationTest() {
	home.validatemanagerId();
	Assert.assertTrue(true);
}

@Test(priority=3)
public void addCustomerTest() {
	custPage=home.clickOnNewCustomer();
}

@AfterMethod
public void tearDown(){
//	
//	home.clickOnLogout();
	closeBrowser();
}
}
