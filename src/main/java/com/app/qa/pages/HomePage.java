package com.app.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.qa.base.BaseClass;

public class HomePage extends BaseClass{

	@FindBy(xpath="//td[text()='Manger Id : mngr254531']")
	WebElement ManagerId;
	
	
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement NewCustomer;
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement logout;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateHomepageTitle() {
		return driver.getTitle();
		
	}
	
	public boolean validatemanagerId() {
		return ManagerId.isDisplayed();
	}
	
	public AddCustomerPage clickOnNewCustomer() {
		NewCustomer.click();
		return new AddCustomerPage();
	}
	public void clickOnLogout() {
		sendKeysWait(5, logout);
		logout.click();
		try {
		Alert act=driver.switchTo().alert();
		act.getText();
		act.accept();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
