package com.app.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.qa.base.BaseClass;

public class LoginPage extends BaseClass {
	
	Logger log=Logger.getLogger(LoginPage.class);

	@FindBy(xpath="//input[starts-with(@name,'ui')]")
	WebElement Username;
	
	@FindBy(xpath="//input[contains(@name,'password')]")
	WebElement Password;
	
	@FindBy(xpath="//input[contains(@name,'btnLogin')]")
	WebElement login;
	
	@FindBy(xpath="//h2[text()='Guru99 Bank']")
	WebElement Bank;
	
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateLoginpageTitle() {
		log.info("giving the home page title");
		return driver.getTitle();
	}
	
	public Boolean validateBankname() {
		return Bank.isDisplayed();
		
	}
	
	public HomePage Login(String username,String password) {
     Username.sendKeys(username);
     Password.sendKeys(password);
     login.click();
     return new HomePage();
     
	}
}
