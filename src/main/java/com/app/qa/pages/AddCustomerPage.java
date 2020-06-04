package com.app.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.app.qa.base.BaseClass;
import com.app.qa.data.MyData;

public class AddCustomerPage extends BaseClass {

	@FindBy(xpath="//input[@name='name']")
	WebElement Customername;
	
	@FindBy(xpath="//input[@value='f']")
	WebElement Gender;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement city;
	
	@FindBy(xpath="//textarea[@onkeyup='validateAddress();']")
	WebElement Address;
	
	@FindBy(xpath="//input[@onkeyup='validateState();']")
	WebElement State;
	
	@FindBy(xpath="//input[@onkeyup='validatePIN();']")
	WebElement Pincode;
	
	@FindBy(xpath="//input[@onkeyup='validateTelephone();']")
	WebElement Mobileno;
	
	@FindBy(xpath="//input[@onkeyup='validateEmail();']")
	WebElement Email;
	
	@FindBy(xpath="//input[@onkeyup='validatepassword();']")
	WebElement Pass;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement submit;
	
	@FindBy(xpath="//a[text()='Home']")
	WebElement Home;
	
	public AddCustomerPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCustomerPageTitle() {
		return driver.getTitle();
	}
	
	

	public void AddNewCustomerDetails(String name,String add,String City,String state,String pin,String mob,String email,String passwd) throws InterruptedException {
		Customername.sendKeys(name);
		Gender.click();
		boolean bool=Gender.isSelected();
		System.out.println(bool);
		Address.sendKeys(add);
		city.sendKeys(City);
		State.sendKeys(state);
		Pincode.sendKeys(pin);
		Mobileno.sendKeys(mob);
		Email.sendKeys(email);
		Pass.sendKeys(passwd);
		Thread.sleep(2000);
		submit.click();
		Alert act=driver.switchTo().alert();
		act.getText();
		act.accept();
	}
	
	public void clickOnHome() {
		sendKeysWait(10,Home );
		Home.click();
		
	}
}
