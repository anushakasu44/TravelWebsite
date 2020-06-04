package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Util.BaseClass;

public class AdminLogin extends BaseClass{

	@FindBy(xpath="//input[@type='text']")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement login;
	
	public AdminLogin() {
		PageFactory.initElements(driver, this);
	}
	
	public AdminDashboard adminlogin() {
		username.sendKeys(prop.getProperty("adminuser"));
		password.sendKeys(prop.getProperty("adminpasswd"));
		login.click();
		return new AdminDashboard();
	}
}
