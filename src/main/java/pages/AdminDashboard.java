package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Util.BaseClass;

public class AdminDashboard extends BaseClass{

	@FindBy(xpath="//i[@class='fa fa-user-circle']")
	WebElement accounts;
	
	@FindBy(xpath="//a[text()='Customers']")
	WebElement customers;
	
	@FindBy(xpath="//button//i[@class='fa fa-laptop']")
	WebElement viewwebsite;
	
	public AdminDashboard() {
		PageFactory.initElements(driver, this);
	}
	
	public Customer clickOncustomer() {
		accounts.click();
		customers.click();
		return new Customer();
	}
	
	public void clickOnviewwebsite() {
		viewwebsite.click();
	}
}
