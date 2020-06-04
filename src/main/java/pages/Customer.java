package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Com.Util.BaseClass;

public class Customer extends BaseClass{

	@FindBy(xpath="//button[@type='submit']")
	WebElement add;
	
	public Customer() {
		PageFactory.initElements(driver, this);
	}
	
	public AddCustomerdetails clickOnAdd() {
		Boolean bool=add.isEnabled();
		Assert.assertTrue(bool);
		javaScriptClick(add);
		return new AddCustomerdetails();
	}
}
