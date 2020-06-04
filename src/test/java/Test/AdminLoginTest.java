package Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.Util.BaseClass;
import pages.AddCustomerdetails;
import pages.AdminDashboard;
import pages.AdminLogin;
import pages.Customer;

public class AdminLoginTest extends BaseClass {
	AdminLogin ad;
	AdminDashboard ada;
	Customer c;
	AddCustomerdetails ac;
	
	
	@BeforeMethod()
	public void setUp() {
		BaseClass ba=BaseClass.GetInstance();
		ba.openBrowser();
		 ad=new AdminLogin();
		 ada=new AdminDashboard();
		 c=new Customer();
		 ac=new AddCustomerdetails();
		
	}
	@Test(priority=1)
	public void adminlogin() {
		ada =ad.adminlogin();
		c=ada.clickOncustomer();
		ac=c.clickOnAdd();
	}


	
//	@AfterMethod()
//	public void tearDown() {
//		driver.quit();
//		}
	
}
