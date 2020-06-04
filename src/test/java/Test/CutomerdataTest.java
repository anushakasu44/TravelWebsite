package Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.Util.BaseClass;
import Com.Util.DataDriven;
import pages.AddCustomerdetails;
import pages.AdminDashboard;
import pages.AdminLogin;
import pages.Customer;

public class CutomerdataTest extends BaseClass{

	AdminLogin ad;
	AdminDashboard ada;
	Customer c;
	AddCustomerdetails ac;
	
	
	@BeforeMethod()
	public void setUp() {
		BaseClass ba=BaseClass.GetInstance();
		ba.openBrowser();
		 ad=new AdminLogin();
		 ada =ad.adminlogin();
		 ada=new AdminDashboard();
		 c=ada.clickOncustomer();
		 c=new Customer();
		 ac=c.clickOnAdd();
		 ac=new AddCustomerdetails();
		
	}
	@DataProvider
	public String[][] getdata() throws Exception {
		String[][] cus=DataDriven.getCustomerData();
		return cus;
		
	}
	
	@Test(priority=2,dataProvider="getdata")
	public void addCustDataTest(String fname,String lname,String emil,String pass,String mob,String add1,String add2) {
		ac.addCustData(fname, lname, emil, pass, mob, add1, add2);
		
	}
	

	@AfterMethod()
	public void tearDown() {
		driver.quit();
		}
	

	
	
}
