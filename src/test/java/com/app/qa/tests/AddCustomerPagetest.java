package com.app.qa.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.app.qa.base.BaseClass;
import com.app.qa.data.MyData;
import com.app.qa.pages.AddCustomerPage;
import com.app.qa.pages.HomePage;
import com.app.qa.pages.LoginPage;
import com.qa.ExtentReportListener.ItestListener;
@Listeners(ItestListener.class)
public class AddCustomerPagetest extends BaseClass{
LoginPage page;
HomePage home;
AddCustomerPage custPage;
	
	
	
	@BeforeMethod
	public void setUp() {
		BaseClass bas=BaseClass.getInstance();
		bas.launchBrowser();
		
		page=new LoginPage();
		home=new HomePage();
		custPage=new AddCustomerPage();
		
		home=page.Login(prop.getProperty("username"), prop.getProperty("password"));
		custPage=home.clickOnNewCustomer();
		}
	
	@Test(priority=2)
	public void customerPagetitleTest() {
		String title=custPage.verifyCustomerPageTitle();
		Assert.assertEquals(title, "Guru99 Bank New Customer Entry Page", "not matching");
	}
	
	
	
	@DataProvider
	public String[][] getData() throws Exception {
		String arr[][]=MyData.getDataFromExcel();
		return arr;
	}
	
	
	@Test(priority=1,dataProvider="getData")
	public void addNewCustomerDetails(String name,String add,String City,String state,String pin,String mob,String email,String passwd) throws Exception {
		custPage.AddNewCustomerDetails(name, add, City, state, pin, mob, email, passwd);
		
	}
	
	@AfterMethod
	public void tearDown() {
	//	home.clickOnLogout();
	    closeBrowser();
	}
}
