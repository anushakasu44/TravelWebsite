package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Com.Util.BaseClass;

public class AddCustomerdetails extends BaseClass {

	@FindBy(xpath="//input[@name='fname']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@name='lname']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement email ;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='mobile']")
	WebElement mobile;
	
	@FindBy(xpath="//span[text()='Please Select']")
	WebElement country;
	
	@FindBy(xpath="//select[@class='chosen-select select2-offscreen']")
	WebElement selectcountry;
	
	@FindBy(xpath="//input[@name='address1']")
	WebElement address1;
	
	@FindBy(xpath="//input[@name='address2']")
	WebElement address2;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submit;
	
	public AddCustomerdetails() {
		PageFactory.initElements(driver, this);
	}
	
	public void addCustData(String fname,String lname,String emil,String pass,String mob,String add1,String add2) {
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		email.sendKeys(emil);
		password.sendKeys(pass);
		mobile.sendKeys(mob);
		country.click();
		Select sel=new Select(selectcountry);
		sel.selectByValue("IN");
		address1.sendKeys(add1);
		address2.sendKeys(add2);
		submit.click();
	}
}
